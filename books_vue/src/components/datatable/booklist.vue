<template>
  <n-space vertical :size="12">
    <n-space style="padding: 0 !important;">
      <n-auto-complete v-model:value="bookname" :input-props="{ autocomplete: 'disable' }" placeholder="书名" />
      <n-auto-complete v-model:value="author" :input-props="{ autocomplete: 'disable' }" placeholder="作者" />
      <n-auto-complete v-model:value="publisher" :input-props="{ autocomplete: 'disable' }" placeholder="出版社" />
      <n-button type="warning" style="width: 1rem;justify-content: center;" @click="search">
        搜索
      </n-button>
    </n-space>
    <n-data-table :bordered="false" :columns="columns" :data="data" :pagination="pagination" />
  </n-space>
</template>

<script lang="ts" setup>
import { onMounted, ref, reactive } from 'vue';
import { useMessage } from 'naive-ui';
import type { DataTableColumns } from 'naive-ui'
import { getBookList } from '../../api/book';

const bookData = ref<API.BookData[]>([] as API.BookData[])
const $message = useMessage()

onMounted(async () => {
  const { data } = await getBookList()
  bookData.value = data.data
})
/* 搜索框 */
const bookname = ref('')
const author = ref('')
const publisher = ref('')
const search = async () => {
  const { data } = await getBookList({
    bookname: bookname.value,
    author: author.value,
    publisher: publisher.value
  })
  if (data.status == 0) {
    bookData.value = data.data
    $message.success(data.message)
  }
  if (data.status == 1) {
    $message.error(data.message)
  }
}

/* 查询书籍 */
const createColumns = (): DataTableColumns<API.BookData> => {
  return [
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

const paginationReactive = reactive({
  page: 1,
  pageSize: 5,
  showSizePicker: true,
  pageSizes: [5, 8, 10],
  onChange: (page: number) => {
    paginationReactive.page = page
  },
  onUpdatePageSize: (pageSize: number) => {
    paginationReactive.pageSize = pageSize
    paginationReactive.page = 1
  }
})

const data = ref(createData())
const columns = ref(createColumns())
const pagination = ref(paginationReactive)
</script>

<style scoped lang="less">

</style>