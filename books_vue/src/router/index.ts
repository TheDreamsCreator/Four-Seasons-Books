import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";

declare module "vue-router" {
  interface RouteMeta {
    title?: string;
  }
}

export const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "hello",
    component: () => import("../views/home/Home.vue"),
    meta: {
      title: "欢迎来到图书管理系统"
    }
  },
  {
    path: "/login",
    name: "login",
    component: () => import("../views/login/Login.vue"),
    meta: {
      title: "登录界面",
    },
  },
  {
    path: "/index",
    name: "index",
    component: () => import("../views/index/Index.vue"),
    meta: {
      title: "首页"
    }
  },
  {
    path: "/register",
    name: 'register',
    component: () => import("../views/login/Register.vue"),
    meta: {
      title: "注册页面"
    }
  },
  {
    path: '/user',
    name: 'user',
    component: () => import("../views/user/User.vue"),
    meta: {
      title: "用户页面"
    }
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
