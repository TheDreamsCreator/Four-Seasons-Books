<template>
  <n-message-provider>
    <router-view></router-view>
  </n-message-provider>
</template>

<script setup lang="ts">
import { watchEffect } from 'vue';
import { useRoute } from 'vue-router';
const route = useRoute()
watchEffect(() => {
  if (route.meta?.title) {
    document.title = route.meta.title;
  }
})

</script>

<style>
html {
  font-size: 5rem;
}

* {
  margin: 0;
  padding: 0;
}
</style>
