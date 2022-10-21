import { onMounted } from "vue";

export default function (): Promise<void> {
  return new Promise(() => {
    onMounted(() => {
      const h1 = document.querySelector("#h1") as Element;
      const h2 = document.querySelector("#h2") as Element;
      const m1 = document.querySelector("#m1") as Element;
      const m2 = document.querySelector("#m2") as Element;
      const s1 = document.querySelector("#s1") as Element;
      const s2 = document.querySelector("#s2") as Element;

      const getTimechuo = () => {
        let data = new Date();

        const padZero = (n: number | string) => {
          return n < 10 ? (n = "0" + n) : n;
        };

        let h = padZero(data.getHours());
        let m = padZero(data.getMinutes());
        let s = padZero(data.getSeconds());

        h1.innerHTML = h.toString().split("")[0];
        h2.innerHTML = h.toString().split("")[1];
        m1.innerHTML = m.toString().split("")[0];
        m2.innerHTML = m.toString().split("")[1];
        s1.innerHTML = s.toString().split("")[0];
        s2.innerHTML = s.toString().split("")[1];
      };

      getTimechuo();
      setInterval(() => {
        getTimechuo();
      }, 1000);
    });
  });
}
