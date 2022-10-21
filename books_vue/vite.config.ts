import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  server: {
    host: "127.0.0.1",
    port: 3000,
    proxy: {
      '/api': {
        target: "http://localhost:8080",
        changeOrigin: true,
        secure: true,
        // @ts-ignore
        pathRewrite: {
          '/api': ''
        }
      },
    },
  },
});
