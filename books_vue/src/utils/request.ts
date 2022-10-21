import axios from "axios";
import type { AxiosRequestConfig } from "axios";
import { Storage } from "./Storage";
import { ACCESS_TOKEN_KEY } from "../enum/user";

const service = axios.create({
  timeout: 6000,
});

service.defaults.baseURL = '/api'

service.interceptors.request.use(
  (config) => {
    const token = Storage.get(ACCESS_TOKEN_KEY);
    if (token && config.headers) {
      config.headers["token"] = token;
    }
    return config;
  },
  (error) => {
    Promise.reject(error);
  }
);

export interface RequestOptions {
  perm?: string[];
  successMsg?: string;
  errorMsg?: string;
  mock?: boolean;
}

export type Response<T = any> = {
  status: 0 | 1;
  message: string;
  data: T;
};

export type BaseResponse<T = any> = Promise<Response<T>>;

export const request = async <T = any>(
  config: AxiosRequestConfig,
  options: RequestOptions = {
    mock: false,
  }
): Promise<T> => {
  try {
    const res = await service.request(config);
    return options.mock ? res.data : res;
  } catch (err: any) {
    return Promise.reject(err);
  }
};
