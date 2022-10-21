package com.fts.four_seasons.exception;

/**
 * 自定义 Api 异常
 */
public class ApiException extends RuntimeException {
  private static final long serialVersionUID = 1L;

	/**
	 * 错误信息
	 */
	protected String errorMessage;

	public ApiException(String errorMessage) {
		super(errorMessage);
    this.errorMessage = errorMessage;
	}

  public ApiException(String errorMessage, Exception e) {
		super(errorMessage, e);
    this.errorMessage = errorMessage;
	}

  public String getMessage() {
    return errorMessage;
  }
	
	@Override
	public Throwable fillInStackTrace() {
		return this;
	}
}
