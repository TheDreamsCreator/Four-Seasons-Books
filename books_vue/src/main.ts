import { createApp } from "vue";
import router from "./router/index";
import App from "./App.vue";
import { createPinia } from "pinia";
import {
  create,
  NButton,
  NSwitch,
  NSpace,
  NMenu,
  NDataTable,
  NMessageProvider,
  NAutoComplete,
  NInput,
  NDrawer,
  NDrawerContent,
  NModal,
  NDropdown,
  NSelect
} from "naive-ui";
const naive = create({
  components: [
    NButton,
    NSwitch,
    NSpace,
    NMenu,
    NDataTable,
    NMessageProvider,
    NAutoComplete,
    NInput,
    NDrawer,
    NDrawerContent,
    NModal,
    NDropdown,
    NSelect
  ],
});

const store = createPinia();
const app = createApp(App)
app.use(naive).use(store).use(router).mount("#app");
