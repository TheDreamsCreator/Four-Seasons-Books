<template>
  <n-space vertical :size="12">
    <n-data-table :bordered="false" :columns="columns" :data="data" :pagination="pagination" :row-key="rowKey"
      @update:checked-row-keys="handleCheck" :theme-overrides="{ borderRadius: '1rem' }" />
    <n-button style="background-color: #f74d4e; --n-border: 0; margin-left: 10rem;width: 1.05rem;" type="info">借阅
    </n-button>
  </n-space>
</template>

<script setup lang="ts">
import { DataTableColumns, DataTableRowKey } from 'naive-ui';
import { reactive, ref } from 'vue';
const bookData = ref<API.BookData[]>([
  {
    id: 0,
    isbn: 'string',
    bookname: 'string',
    author: 'string',
    publisher: 'string',
    type: 'string'
  },
  {
    id: 1,
    isbn: 'string',
    bookname: 'string',
    author: 'string',
    publisher: 'string',
    type: 'string'
  }
] as API.BookData[])
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
  console.log(checkedRowKeysRef.value)
}

const data = ref(createData())
const columns = ref(createColumns())
const pagination = ref(paginationReactive)
</script>

<style scoped lang="less">

</style>