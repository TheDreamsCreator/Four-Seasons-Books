import { BASE_URL } from "../../config";
import { BaseResponse, request } from "../../utils/request";

export function getBookList(param?: API.QueryBookParam) {
  return request<BaseResponse<API.Result<API.BookData[]>>>({
    baseURL: BASE_URL,
    url: "getBookList",
    method: "get",
    params: param,
  });
}

export function getBorrowList(param?: { userId: number }) {
  return request<BaseResponse<API.Result<API.BorrowDataSelf[]>>>({
    url: "getBorrowList",
    method: "get",
    params: param,
  });
}

export function deleteBook(ids: number[]) {
  return request<BaseResponse<API.Result<void>>>({
    url: "deleteBook",
    method: "put",
    data: ids,
  });
}

export function getTypeList() {
  return request<BaseResponse<API.Result<API.TypeData[]>>>({
    url: "getBookTypes",
    method: "get",
  });
}

export function createNewBook(param: API.NewBookParam) {
  return request<BaseResponse<API.Result<void>>>({
    url: "addBook",
    method: "post",
    data: param,
  });
}

export function updateBookInfo(param: API.UpdateBookParam) {
  return request<BaseResponse<API.Result<void>>>({
    url: "updateBook",
    method: "post",
    data: param,
  })
}

export function borrowBook(param: API.BookRentParam) {
  return request<BaseResponse<API.Result<void>>>({
    url: 'borrowBook',
    method: 'post',
    data: param
  })
}

export function returnBook(param: API.BookReturnParam) {
  return request<BaseResponse<API.Result<void>>>({
    url: 'updateBorrow',
    method: 'put',
    data: param
  })
}

