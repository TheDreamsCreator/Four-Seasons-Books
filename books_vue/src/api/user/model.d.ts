declare namespace API {
  type LoginParams = {
    account: string;
    password: string;
  }

  type RegisterParams = {
    account: string
    password: string
    nickname: string
    email: string 
    cellphone: string
    age: number
  }

  type UserInfoUpdateParams = {
    account: string
    nickname: string
    old_password: string
    new_password: string
  }
  
  type TokenData = {
    account: string;
    nickname: string;
    age: number;
    cellphone: string;
    email: string;
    exp: number;
    role: string;
  }

  interface LoginResult extends Result<string> {
  }

  interface RegisterResult extends Result<void> {
  }

  interface UserInfoUpdateResult extends Result<{
    nickname: string,
    account: string
  }>{}

}