declare namespace API {
  type BookData = {
    id: number;
    isbn: string;
    bookname: string;
    author: string;
    publisher: string;
    type_id: number;
    type: string;
  };

  type TypeData = {
    id: number;
    type_name: string;
  };

  type BorrowDataSelf = {
    id: number
    book_id: number
    book_name: string
    book_isbn: string
    book_author: string
    book_publisher: string
    type_name: string
    borrow_time: string
  }

  type NewBookParam = {
    bookname: string;
    author: string;
    publisher: string;
    type: number;
  };

  type UpdateBookParam = {
    id: number;
    publisher: string;
    bookname: string;
    author: string;
    isbn: string;
    type: number;
  };

  type QueryBorrowSelf = {
    userId: number;
    limit?: number;
    page?: number;
  };

  type QueryBookParam = {
    bookname?: string;
    author?: string;
    publisher?: string;
    isBorrow?: number;
    limit?: number;
    page?: number;
  };

  type BookRentParam = {
    user_id: number;
    book_id: number;
  }

  type BookReturnParam = {
    id: number;
    book_id: number;
  }
}
