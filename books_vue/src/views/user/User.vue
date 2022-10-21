<template>

  <body>
    <!-- 头部区域开始 -->
    <div class="header">
      <div class="w center_V">
        <div class="logo">
          <a href="#" onclick="javascript:history.back(-1);" class="glyphicon glyphicon-chevron-left">
            <span>返回首页</span>
          </a>
          <img src="../../assets/images/logo.png" alt="" />
        </div>
      </div>
    </div>
    <!-- 头部区域结束 -->

    <!-- banner部分开始 -->
    <div class="banner">
      <!-- 版心 -->
      <div class="w">
        <!-- 个人信息/用户中心 -->
        <div class="person">
          <ul>
            <li>
              <img src="../../assets/images/user1.png" alt="" />
            </li>
            <li>
              <span>用户昵称</span>
              <input type="text" v-model="nickname">
            </li>
            <li>
              <span>用户账号</span>
              <input type="text" v-model="account">
            </li>
            <li>
              <span>旧密码</span>
              <input type="text" v-model="oldPassword">
            </li>
            <li>
              <span>新密码</span>
              <input type="text" v-model="newPassword">
            </li>
            <li>
              <button @click="update">修改</button>
              <button @click="logout">退出登录</button>
            </li>
          </ul>
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

  </body>
</template>

<script lang="ts" setup>
import { useMessage } from 'naive-ui';
import { ref, onMounted } from 'vue';
import router from '../../router';
import { useUserStore } from '../../store/modules/user';

const userStore = useUserStore()
const $message = useMessage()
const id = ref(0)
const nickname = ref("")
const account = ref("")
const oldPassword = ref("")
const newPassword = ref("")

onMounted(() => {
  nickname.value = userStore.getUserInfo.nickname ?? ''
  account.value = userStore.getUserInfo.account ?? ''
  id.value = userStore.getUserInfo.id
})

const logout = () => {
  userStore.logout()
  $message.success("退出成功!")
  // simple clear router stack cache
  const back_length = history.length - 1
  history.go(-back_length)
  router.push({ name: 'hello' })
}
const update = async () => {
  const res = await userStore.updateUserInfo({
    id: id.value,
    account: account.value,
    nickname: nickname.value,
    old_password: oldPassword.value,
    new_password: newPassword.value,
  })
  if (res.status == 0) {
    $message.success(res.message)
    location.reload()
    router.go(0)
  } else {
    $message.error(res.message)
  }
}
</script>

<style scoped lang="less">
@import '../../styles/common.less';
@import '../../styles/user.less';
</style>