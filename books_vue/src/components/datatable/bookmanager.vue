<template>
  <n-space vertical :size="12">
    <n-space style="padding: 0">
      <n-auto-complete v-model:value="bookname" :input-props="{ autocomplete: 'disable' }" placeholder="书名" />
      <n-auto-complete v-model:value="author" :input-props="{ autocomplete: 'disable' }" placeholder="作者" />
      <n-auto-complete v-model:value="publisher" :input-props="{ autocomplete: 'disable' }" placeholder="出版社" />
      <n-button type="warning" style="width: 1rem;justify-content: center;" @click="search">
        搜索
      </n-button>
      <n-button type="warning" style="margin-left: 1.1rem; --n-border: 1px solid seagreen; background-color: seagreen;"
        @click="activate('right')">
        新增
      </n-button>
      <n-button type="error" @click="deleteCheck">
        删除
      </n-button>
    </n-space>
    <n-data-table :bordered="false" :columns="columns" :data="data" :pagination="pagination" :row-key="rowKey"
      @update:checked-row-keys="handleCheck" :theme-overrides="{ borderRadius: '1rem' }" />
  </n-space>
  <!-- 新增图书抽屉 -->
  <n-drawer v-model:show="active" :width="502" :placement="placement">
    <n-drawer-content title="新增图书">
      <n-space vertical>
        <n-auto-complete v-model:value="newBookname" :input-props="{ autocomplete: 'disable' }" placeholder="书名" />
        <n-auto-complete v-model:value="newAuthor" :input-props="{ autocomplete: 'disable' }" placeholder="作者" />
        <n-auto-complete v-model:value="newPublisher" :input-props="{ autocomplete: 'disable' }" placeholder="出版社" />
      </n-space>
      <n-select style="margin-top: .1rem" placeholder="图书类型" v-model:value="type" @update:value="handleType"
        :options="typeOptions"></n-select>
      <n-button @click="addNewBook" type="success" style="margin-top: .1rem; width: 100%;">添加</n-button>
    </n-drawer-content>
  </n-drawer>
  <!-- 编辑图书抽屉 -->
  <n-drawer v-model:show="activeEdit" :width="502" :placement="editPlacement">
    <n-drawer-content title="编辑图书">
      <n-space vertical>
        <n-auto-complete v-model:value="editBookname" :input-props="{ autocomplete: 'disable' }" placeholder="书名" />
        <n-auto-complete v-model:value="editAuthor" :input-props="{ autocomplete: 'disable' }" placeholder="作者" />
        <n-auto-complete v-model:value="editPublisher" :input-props="{ autocomplete: 'disable' }" placeholder="出版社" />
        <n-auto-complete v-model:value="editIsbn" :input-props="{ autocomplete: 'disable' }" placeholder="ISBN" />
      </n-space>
      <n-select style="margin-top: .1rem" placeholder="图书类型" v-model:value="type" @update:value="handleType"
        :options="typeOptions"></n-select>
      <n-button @click="updateBook" type="success" style="margin-top: .1rem; width: 100%;">编辑</n-button>
    </n-drawer-content>
  </n-drawer>
  <!-- 删除确认模态框 -->
  <n-modal v-model:show="showModal" preset="dialog" type="warning" title="确认删除" content="是否删除选中图书" positive-text="确认"
    negative-text="取消" @positive-click="submit" @negative-click="cancel">
  </n-modal>
</template>

<script setup lang="ts">
import { DataTableColumns, DataTableRowKey, NButton, SelectOption, useMessage } from 'naive-ui';
import type { DrawerPlacement } from 'naive-ui';
import { onMounted, reactive, ref, h } from 'vue';
import { getBookList, getTypeList, deleteBook, createNewBook, updateBookInfo } from '../../api/book';
import { toNumber } from 'lodash';

const bookData = ref<API.BookData[]>([] as API.BookData[])
const $message = useMessage()

/* api 响应 */
const getBookData = async () => {
  const { data } = await getBookList()
  bookData.value = data.data
}
const getTypeData = async () => {
  const res = await getTypeList()
  if (res.status == 1) {
    $message.error("获取类型列表失败!")
  }
  const typeData = res.data.data
  typeData.forEach((e) => {
    typeOptions.value.push({
      id: e.id,
      label: e.type_name
    })
  })
}

/* vue页面初始化时加载 */
onMounted(async () => {
  await getBookData()
  await getTypeData()
})

/* 搜索框 */
const bookname = ref('')
const author = ref('')
const publisher = ref('')
const search = async () => {
  const res = await getBookList({
    bookname: bookname.value,
    author: author.value,
    publisher: publisher.value
  })
  if (res.status === 0) {
    bookData.value = res.data.data
    $message.success(res.message)
  }
  if (res.status === 1) {
    $message.error(res.message)
  }
}
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
      key: 'edit',
      render(row) {
        return h(
          NButton,
          {
            onClick: () => editBook(row)
          },
          {
            default: () => '编辑'
          }
        )
      }
    }
  ]
}

/* 图书列表 */
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

/* 新增抽屉 */
const active = ref(false)
const placement = ref<DrawerPlacement>('right')
const activate = (place: DrawerPlacement) => {
  active.value = true
  placement.value = place
}
const newBookname = ref('')
const newAuthor = ref('')
const newPublisher = ref('')
const addNewBook = async () => {
  const { data } = await createNewBook({
    bookname: newBookname.value,
    author: newAuthor.value,
    publisher: newPublisher.value,
    type: typeId.value ?? 0,
  })
  if (data.status === 0) {
    $message.success(data.message)
  } else {
    $message.error(data.message)
  }
  await getBookData()
}

/* 编辑抽屉 */
const editId = ref(0)
const editBookname = ref('')
const editIsbn = ref('')
const editAuthor = ref('')
const editPublisher = ref('')
const editTypeId = ref(0)
const activeEdit = ref(false)
const editPlacement = ref<DrawerPlacement>('right')
const editBook = (row: any) => {
  typeId.value = row.type_id
  editId.value = row.id
  editBookname.value = row.bookname
  editAuthor.value = row.author
  editPublisher.value = row.publisher
  editIsbn.value = row.isbn
  editTypeId.value = row.typeId
  type.value = row.type
  activeEdit.value = true
}
const updateBook = async () => {
  const { data } = await updateBookInfo({
    id: editId.value,
    bookname: editBookname.value,
    author: editAuthor.value,
    publisher: editPublisher.value,
    isbn: editIsbn.value,
    type: typeId.value ?? 0,
  })
  if (data.status === 0) {
    $message.success(data.message)
    await getBookData()
    activeEdit.value = false
  } else {
    $message.error(data.message)
  }
}

/* 删除模态框 */
const showModal = ref(false)
const deleteCheck = () => {
  showModal.value = true
}
const submit = async () => {
  const ids: number[] = []
  checkedRowKeysRef.value.map((e) => {
    ids.push(toNumber(e))
  })
  const { data } = await deleteBook(ids)
  if (data.status === 0) {
    $message.success(data.message)
  } else {
    $message.error(data.message)
  }
  showModal.value = false
  await getBookData()
}
const cancel = () => {
  showModal.value = false
}

/* 类型下拉框 */
const type = ref<string>('')
const typeId = ref<number>()
const typeOptions = ref<{
  id: number,
  label: string,
}[]>([])
const handleType = (_: string, option: SelectOption) => {
  type.value = option.label as string
  typeId.value = option.id as number
}
</script>

<style scoped lang="less">

</style>