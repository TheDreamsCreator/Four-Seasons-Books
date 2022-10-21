declare namespace API {
  interface Result<T> {
    status: number;
    message: string;
    data: T
  }
}