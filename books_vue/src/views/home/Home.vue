<template>

  <body>
    <div class="main">
      <div class="nav">
        <div class="img"></div>
        <ul>
          <li>欢迎</li>
          <li>来到</li>
          <li>我的</li>
          <li>主页</li>
          <li><a href="/index">图书管理</a></li>
        </ul>

      </div>
      <div class="contain">
        <div class="wold">
          <h1>Welcome To</h1>
          <h1>四季图书馆</h1>
        </div>
        <div class="welc">
          欢迎
          {{ userStore.getNickname ?? "用户" }}
          来到四季图书馆
        </div>
        <div class="link">
          <a href="/login" v-show="!show">去登录</a>
          <a @click="logout" v-show="show">退出</a>
        </div>
      </div>
      <div class="time_box">
        <ul class="ul">
          <li>
            <p id="h1">1</p>
            <p id="h2">2</p>
          </li>
          <li>
            <p id="m1">3</p>
            <p id="m2">4</p>
          </li>
          <li>
            <p id="s1">5</p>
            <p id="s2">6</p>
          </li>
        </ul>
      </div>

    </div>
  </body>
</template>

<script setup lang="ts">
import { useMessage } from 'naive-ui';
import { onMounted, ref } from 'vue';
import clock from '../../hooks/ClockOnHello'
import router from '../../router';
import { useUserStore } from '../../store/modules/user';
clock();
const userStore = useUserStore()
const $message = useMessage()
const show = ref(false)
onMounted(() => {
  if (userStore.getToken) {
    show.value = true
  } else {
    show.value = false
  }
})
const logout = () => {
  userStore.logout()
  $message.success("退出登录成功!")
  location.reload()
  router.go(0)
}
</script>

<style scoped lang="less">
@import '../../styles/hello.css';
</style>