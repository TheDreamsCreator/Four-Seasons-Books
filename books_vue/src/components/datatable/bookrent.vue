<template>
  <n-space vertical :size="12">
    <n-data-table :bordered="false" :columns="columns" :data="data" :pagination="pagination" :row-key="rowKey"
      @update:checked-row-keys="handleCheck" :theme-overrides="{ borderRadius: '1rem' }" />
    <n-modal v-model:show="showConfirm" preset="dialog" title="借阅" content="您确认要借阅此书?" positive-text="确认"
      negative-text="取消" @positive-click="submit" @negative-click="cancel" />
  </n-space>
</template>

<script setup lang="ts">
import { DataTableColumns, DataTableRowKey, NButton, useMessage } from 'naive-ui';
import { h, onMounted, reactive, ref } from 'vue';
import { borrowBook, getBookList } from '../../api/book';
import { useUserStore } from '../../store/modules/user';

const userStore = useUserStore();
const $message = useMessage();
const getBookData = async () => {
  const { data } = await getBookList({
    isBorrow: 0
  })
  bookData.value = data.data
}
onMounted(async () => {
  await getBookData()
})

/* 数据表格 */
const bookData = ref<API.BookData[]>([] as API.BookData[])
const createColumns = (): DataTableColumns<API.BookData> => {
  return [
    {
      type: 'selection',
      disabled(row: API.BookData) {
        return row.bookname === ''
      }
    },
    {
      title: 'ISBN',
      key: 'isbn'
    },
    {
      title: '书名',
      key: 'bookname'
    },
    {
      title: '作者',
      key: 'author'
    },
    {
      title: '出版社',
      key: 'publisher'
    },
    {
      title: '类别',
      key: 'type'
    },
    {
      title: '',
      key: 'rent',
      render(row) {
        return h(
          NButton,
          {
            onClick: () => rentBook(row)
          },
          {
            default: () => '借阅'
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
  pageSizes: [5, 8, 10],
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
}
const data = ref(createData())
const columns = ref(createColumns())
const pagination = ref(paginationReactive)

/* 借阅模态框 */
const showConfirm = ref(false)
const book_id = ref(0)
const rentBook = (row: any) => {
  showConfirm.value = true
  book_id.value = row.id
}
const submit = async () => {
  try {
    const { data } = await borrowBook({
      user_id: userStore.getUserInfo.id,
      book_id: book_id.value,
    })
    if (data.status === 0) {
      $message.success(data.message)
    } else {
      $message.error(data.message)
    }
    showConfirm.value = false
    await getBookData()
  } catch (e: any) {
    $message.error(e.message)
  }
}
const cancel = () => {
  showConfirm.value = false
}
</script>

<style scoped lang="less">

</style>