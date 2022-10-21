import { BaseResponse, request } from "../../utils/request";

export function login(data: API.LoginParams) {
  return request<BaseResponse<API.LoginResult>>(
    {
      url: 'login',
      method: 'post',
      data,
    }
  )
}

export function register(data: API.RegisterParams) {
  return request<BaseResponse<API.RegisterResult>>(
    {
      url: 'register',
      method: 'post',
      data
    }
  )
}

export function updateUserInfo(data: API.UserInfoUpdateParams) {
  return request<BaseResponse<API.UserInfoUpdateResult>>(
    {
      url: 'userInfo',
      method: 'put',
      data
    }
  )
}