<template>

  <body>
    <div class="main">
      <div class="contain">
        <div class="left">
          <p>请登录</p>
          <ul>
            <li>没有账号？</li>
            <em>请你按提示输入正确格式的用户名和密码即可完成注册。</em>
          </ul>
        </div>
        <div class="right">
          <form id="subForm" @submit="submit">
            <p class="label">Sign Up</p>
            <ul>
              账号:<input v-model="state.form.account" id="username"/>
              <span id="msg1">*请输入7位以上的账号</span>
            </ul>
            <ul>
              密码:<input type="password" v-model="state.form.password" id="password" />
              <span class="spanT" id="msg2">*请输入包含数字、字母和特殊字符的密码</span>
            </ul>
            <p class="control_login">
              <a id="reg" class="control" href="/register">注 册</a>
              <button @click="login" id="login" class="control">登录</button>
            </p>
          </form>
        </div>
      </div>
    </div>
  </body>
</template>

<script setup lang="ts">
import { useMessage } from 'naive-ui';
import { reactive } from 'vue';
import router from '../../router';
import { useUserStore } from '../../store/modules/user';
const submit = (e: Event) => {
  e.preventDefault();
}

const state = reactive({
  form: {
    account: '',
    password: ''
  }
})
const userStore = useUserStore()
const $message = useMessage()
const login = async () => { 
  const { account, password } = state.form
  if (account.trim() == '' || password.trim() == '') {
    $message.warning('用户名或密码不为空')
    return
  }
  const res = await userStore.login(state.form);
  if (res.status == 0) {
    $message.success(res.message)
    router.push({ name: 'index' })
  } else {
    $message.error(res.message)
  }
}
</script>

<style scoped lang="less">
@import '../../styles/login.css';
</style>