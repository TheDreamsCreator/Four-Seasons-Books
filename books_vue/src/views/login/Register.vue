<template>

  <body>
    <div class="main">
      <div class="contain">
        <div class="left">
          <p>请注册</p>
          <ul>
            <li>没有账号？</li>
            <em>请你按提示输入正确格式的用户名和密码即可完成注册。</em>
          </ul>
        </div>
        <div class="right">
          <form id="regForm" @submit="submit">
            <p class="label">Register</p>
            <ul>
              账 号：<input type="text" name="account" id="account" v-model="account" />
              <!-- <span>*请输入7位以上的账号</span> -->
            </ul>
            <ul>
              密 码：<input type="text" name="password" id="pwd" v-model="password" />
              <!-- <span>*请输入包含数字、字母和特殊字符的密码</span> -->
            </ul>
            <ul>
              昵 称：<input type="text" name="name" id="nickname" v-model="nickname" />
              <!-- <span>*请输入昵称</span> -->
            </ul>
            <ul>
              邮 箱：<input type="email" name="email" id="email" v-model="email" />
              <!-- <span>*请输入正确的邮箱格式</span> -->
            </ul>
            <ul>
              电 话：<input type="tel" name="sel" id="cellphone" v-model="cellphone" />
              <!-- <span>请输入正确格式的手机号</span> -->
            </ul>
            <ul>
              年 龄：<input type="text" name="age" id="age" v-model="age" />
              <!-- <span>请输入年龄</span> -->
            </ul>
            <p class="control_login">
              <a id="login" class="control reg" href="/login">登 录</a>
              <a id="reg" class="control login" @click="registerAction">注 册</a>
            </p>
          </form>
        </div>
      </div>
    </div>
  </body>
</template>

<script setup lang="ts">
import { useMessage } from 'naive-ui';
import { ref } from 'vue';
import { register } from '../../api/user';
const submit = (e: Event) => {
  e.preventDefault();
}
const $message = useMessage()
const account = ref<string>('')
const password = ref<string>('')
const nickname = ref<string>('')
const email = ref<string>('')
const cellphone = ref<string>('')
const age = ref<number>()
const registerAction = async () => {

  if (age.value == null) {
    $message.warning('年龄不能为空!')
  } else {
    const { data } = await register({
      account: account.value,
      password: password.value,
      nickname: nickname.value,
      email: email.value,
      cellphone: cellphone.value,
      age: age.value,
    })
    if (data.status === 0) {
      $message.success(data.message)
    } else {
      $message.error(data.message)
    }
  }
  
}
</script>

<style scoped lang="less">
@import '../../styles/register.css';

.control_login a {
  cursor: pointer;
}
</style>