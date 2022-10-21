declare namespace API {
  type BookData = {
    id: number
    isbn: string
    bookname: string
    author: string
    publisher: string
    type_id: number
    type: string
  }

  type TypeData = {
    id: number
    type_name: string
  }

  type NewBookParam = {
    bookname: string,
    author: string,
    publisher: string,
    type: number
  }

  type UpdateBookParam = {
    id: number,
    publisher: string,
    bookname: string,
    author: string,
    isbn: string,
    type: number,
  }
}