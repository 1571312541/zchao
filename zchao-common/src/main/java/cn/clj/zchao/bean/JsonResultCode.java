package cn.clj.zchao.bean;

public enum JsonResultCode {
	/**
	 * 失败
	 */
	FAILED(10000, "failed"),

	/**
	 * 成功
	 */
	SUCCESS(10200, "success"),

	/**
	 * 无效长度
	 */
	INVALID_LENGTH(10001, "Invalid length"),

	/**
	 * 用户名不能为空
	 */
	EMPTY_USERNAME(10101, "Username cannot be empty"),

	/**
	 * 密码不能为空
	 */
	EMPTY_PASSWORD(10102, "Password cannot be empty"),

	/**
	 * 帐号不存在
	 */
	INVALID_USERNAME(10103, "Account does not exist"),

	/**
	 * 密码错误
	 */
	INVALID_PASSWORD(10104, "Password error"),

	/**
	 * 无效帐号
	 */
	INVALID_ACCOUNT(10105, "Invalid account");

	public Integer code;
	public String message;

	JsonResultCode(Integer code, String message) {

		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
