import { defineStore } from "pinia";
import { login, updateUserInfo } from "../../api/user";
import { ACCESS_TOKEN_KEY, USER_LOGIN_INFO } from "../../enum/user";
import Storage from "../../utils/Storage";
import jwt_decode from "jwt-decode";

interface UserInfo {
  nickname?: string;
  age?: number;
  email?: string;
  cellphone?: string;
  account?: string;
  role?: string;
}

interface UserState {
  token: string;
  user_info: UserInfo;
}

export const useUserStore = defineStore({
  id: "user",
  state: (): UserState => ({
    token: Storage.get(ACCESS_TOKEN_KEY, null),
    user_info: Storage.get(USER_LOGIN_INFO, {}),
  }),
  getters: {
    getToken(): string {
      return this.token;
    },
    getNickname(): string | undefined {
      return this.user_info.nickname;
    },
    getAccount(): string | undefined {
      return this.user_info.account
    },
    getUserInfo(): UserInfo {
      return this.user_info
    }
  },
  actions: {
    setToken(token: string) {
      this.token = token ?? "";
      const ex = 7 * 24 * 60 * 60 * 1000;
      Storage.set(ACCESS_TOKEN_KEY, this.token, ex);
    },
    setUserInfo(user_info: UserInfo) {
      this.user_info = user_info ?? {}
      const ex = 7 * 24 * 60 * 60 * 1000;
      Storage.set(USER_LOGIN_INFO, this.user_info, ex);
    },
    async login(params: API.LoginParams) {
      try {
        const { data } = await login(params);
        const decoded: API.TokenData = jwt_decode(data.data);
        if (data.data != null) {
          const { nickname, age, email, cellphone, account, role } = decoded;
          this.setUserInfo({
            nickname,
            age,
            email,
            cellphone,
            account,
            role
          })
          this.setToken(data.data);
        }
        return data;
      } catch (e) {
        return Promise.reject(e);
      }
    },
    logout() {
      Storage.clear()
    },
    async updateUserInfo(params: API.UserInfoUpdateParams) {
      try {
        const { data } = await updateUserInfo(params)
        this.user_info.nickname = data.data.nickname
        this.user_info.account = data.data.account
        this.setUserInfo(this.user_info)
        return data
      } catch (e) {
        return Promise.reject(e)
      }
    }
  },
});
