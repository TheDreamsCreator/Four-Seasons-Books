<template>
  <!-- 头部区域开始 -->
  <div class="header">
    <div class="w center_V">
      <div class="logo">
        <img src="../../assets/images/logo.png" alt="" />
      </div>
      <div class="user">
        <a @click="goToUser">
          <img src="../../assets/images/user1.png" alt="" />
          <p>{{ nickname }}</p>
        </a>
      </div>
    </div>

  </div>
  <!-- 头部区域结束 -->

  <!-- banner部分开始 -->
  <div class="banner">
    <!-- 版心 -->
    <div class="w">
      <!-- 子导航栏 -->
      <div class="subnav">
        <n-menu ref="menuInstRef" v-model:value="selectedKey" :options="options" :accordion="accordion" />
      </div>
      <!-- 右侧内容 -->
      <div class="table">
        <!-- 查询书籍 -->
        <Booklist v-if="selectedKey === 'booklist'"></Booklist>
        <!-- 图书借阅 -->
        <Bookrent v-if="selectedKey === 'bookRent'"></Bookrent>
        <!-- 图书归还 -->
        <Bookreturn v-if="selectedKey === 'bookReturn'"></Bookreturn>
        <!-- 图书管理 -->
        <Bookmanager v-if="selectedKey === 'bookManage'"></Bookmanager>
      </div>
    </div>
  </div>
  <!-- banner部分结束 -->

  <!-- footer模块开始 -->
  <div class="footer">
    <div class="w">
      <div class="copyright">
        <img src="../../assets/images/logo.png" alt="">
        <p>四季图书致力于简化用户借还书籍操作，实时展示书籍信息供用户选择。<br /> © 2022年SJTS bsy.保留所有权利。-闽ICP备12345678号</p>
      </div>
      <div class="links">
        <dl>
          <dt>关于四季图书</dt>
          <dd><a href="#">关于</a></dd>
          <dd><a href="#">管理团队</a></dd>
          <dd><a href="#">工作机会</a></dd>
          <dd><a href="#">客户服务</a></dd>
          <dd><a href="#">帮助</a></dd>
        </dl>
        <dl>
          <dt>关于四季图书</dt>
          <dd><a href="#">关于</a></dd>
          <dd><a href="#">管理团队</a></dd>
          <dd><a href="#">工作机会</a></dd>
          <dd><a href="#">客户服务</a></dd>
          <dd><a href="#">帮助</a></dd>
        </dl>
        <dl>
          <dt>关于四季图书</dt>
          <dd><a href="#">关于</a></dd>
          <dd><a href="#">管理团队</a></dd>
          <dd><a href="#">工作机会</a></dd>
          <dd><a href="#">客户服务</a></dd>
          <dd><a href="#">帮助</a></dd>
        </dl>
      </div>
    </div>
  </div>
  <!-- footer 模块结束 -->
</template>

<script setup lang="ts">
import { useUserStore } from '../../store/modules/user';
import router from '../../router';
import { onMounted, ref } from 'vue';
import { MenuInst } from 'naive-ui';
import Bookrent from '../../components/datatable/bookrent.vue';
import Booklist from '../../components/datatable/booklist.vue';
import Bookreturn from '../../components/datatable/bookreturn.vue';
import Bookmanager from '../../components/datatable/bookmanager.vue';


onMounted(async () => {
  nickname.value = userStore.getNickname ?? "去登陆"
})
const goToUser = () => {
  if (!userStore.getNickname) {
    router.push({ name: 'login' })
  } else {
    router.push({ name: 'user' })
  }
}

/* 左侧导航栏 */
const nickname = ref('')
const accordion = ref(false)
const selectedKey = ref('booklist')
const menuInstRef = ref<MenuInst | null>(null)
const userStore = useUserStore()
const options = ref([
  {
    label: "查询书籍",
    key: "booklist"
  },
  {
    label: "图书借阅",
    key: "bookRent"
  },
  {
    label: "图书归还",
    key: "bookReturn"
  },
  {
    label: "图书管理",
    key: "bookManage"
  }
])
</script>

<style lang="less" scoped>
@import '../../styles/index.css';
@import '../../styles/book.css';

::v-deep(.n-menu .n-menu-item-content .n-menu-item-content-header) {
  color: white;
}

::v-deep(.n-menu .n-menu-item-content.n-menu-item-content--selected::before) {
  background-color: #f74d4e;
}

::v-deep(.n-space) {
  padding: 1rem;
}

::v-deep(.n-data-table .n-data-table-th) {
  background-color: rgba(255, 99, 71, 0.3);
}

::v-deep(.n-data-table .n-data-table-thead) {
  background-color: rgba(255, 99, 71, 0.3);
}

::v-deep(.n-data-table .n-data-table-td) {
  background-color: rgba(255, 255, 255, 0.3);
}

::v-deep(.n-data-table .n-data-table-table) {
  background-color: rgba(255, 255, 255, 0.3);
}

// ::v-deep(.n-scroll) {
//   border-radius: .1rem
// }

.table {
  width: 100%
}
</style>