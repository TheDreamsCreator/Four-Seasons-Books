<template>
  <n-space vertical :size="12">
    <n-data-table :bordered="false" :columns="columns" :data="data" :pagination="pagination" :row-key="rowKey"
      @update:checked-row-keys="handleCheck" :theme-overrides="{ borderRadius: '1rem' }" />
    <n-modal v-model:show="showConfirm" preset="dialog" title="归还" content="是否归还此书?" positive-text="确认"
      negative-text="取消" @positive-click="submit" @negative-click="cancel" />
  </n-space>
</template>

<script setup lang="ts">
import { DataTableColumns, DataTableRowKey, NButton, useMessage } from 'naive-ui';
import { reactive, ref, h, onMounted } from 'vue';
import { getBorrowList, returnBook } from '../../api/book';
import { useUserStore } from '../../store/modules/user';
const userStore = useUserStore();
const $message = useMessage();

const getBorrowBook = async () => {
  const { data } = await getBorrowList({
    user_id: userStore.getUserInfo.id
  })
  if (data.status === 1) {
    $message.error(data.message)
    return
  }
  bookData.value = data.data
  $message.success(data.message)
}

onMounted(async () => {
  await getBorrowBook()
})

const bookData = ref<API.BorrowDataSelf[]>([] as API.BorrowDataSelf[])
const createColumns = (): DataTableColumns<API.BorrowDataSelf> => {
  return [
    {
      type: 'selection',
      disabled(row: API.BorrowDataSelf) {
        return row.book_name === ''
      }
    },
    {
      title: 'ISBN',
      key: 'book_isbn'
    },
    {
      title: '书名',
      key: 'book_name'
    },
    {
      title: '作者',
      key: 'book_author'
    },
    {
      title: '出版社',
      key: 'book_publisher'
    },
    {
      title: '类别',
      key: 'type_name'
    },
    {
      title: '借阅时间',
      key: 'borrow_time'
    },
    {
      title: '',
      key: 'rent',
      render(row) {
        return h(
          NButton,
          {
            onClick: () => bookReturn(row)
          },
          {
            default: () => '归还'
          }
        )
      }
    }
  ]
}
const createData = () => {
  return bookData
}
const checkedRowKeysRef = ref<DataTableRowKey[]>([])
const paginationReactive = reactive({
  page: 1,
  pageSize: 5,
  showSizePicker: true,
  pageSizes: [5, 8],
  checkedRowKeys: checkedRowKeysRef,
  onChange: (page: number) => {
    paginationReactive.page = page
  },
  onUpdatePageSize: (pageSize: number) => {
    paginationReactive.pageSize = pageSize
    paginationReactive.page = 1
  },
})
const rowKey = (row: API.BookData) => row.id
const handleCheck = (rowKeys: DataTableRowKey[]) => {
  checkedRowKeysRef.value = rowKeys
  console.log(checkedRowKeysRef.value)
}

const data = ref(createData())
const columns = ref(createColumns())
const pagination = ref(paginationReactive)

/* 归还模态框 */
const showConfirm = ref(false)
const book_id = ref(0)
const bookReturn = (row: any) => {
  showConfirm.value = true
  book_id.value = row.book_id
}
const submit = async () => {
  try {
    const { data } = await returnBook({
      user_id: userStore.getUserInfo.id,
      book_id: book_id.value,
    })
    if (data.status === 0) {
      $message.success(data.message)
    } else {
      $message.error(data.message)
    }
    showConfirm.value = false
    await getBorrowBook()
  } catch (e: any) {
    $message.error(e.message)
  }
}
const cancel = () => {
  showConfirm.value = false
}
</script>
