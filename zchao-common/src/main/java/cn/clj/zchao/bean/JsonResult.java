package cn.clj.zchao.bean;

import java.io.Serializable;

public class JsonResult implements Serializable{
	
	private static final long serialVersionUID = 9097178053970524899L;

	/**
	 * 状态
	 */
	private Boolean status;
	/**
	 *  信息
	 */
	private String message;
	/**
	 *  数据
	 */
	private Object data;
	/**
	 *  编码
	 */
	private Integer code;

	public JsonResult(){}

	public JsonResult(Boolean status) {
		super();
		this.status = status;
	}

	public JsonResult(Boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public JsonResult(Boolean status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}

	public JsonResult(Boolean status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public JsonResult(Boolean status, String message, Object data,Integer code) {
		this.status = status;
		this.message = message;
		this.data = data;
		this.code = code;
	}

	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public JsonResult failure(String msg){
		this.status=false;
		this.message=msg;
		return this;
	}

	public JsonResult failure(String msg,Object data){
		this.status=false;
		this.message=msg;
		this.data=data;
		return this;
	}

	public JsonResult failure(Integer code,String msg,Object data){
		this.status=false;
		this.message=msg;
		this.data=data;
		this.code=code;
		return this;
	}

	public JsonResult failure(JsonResultCode jsonResultCode,Object data){
		this.status=false;
		this.message=jsonResultCode.getMessage();
		this.code=jsonResultCode.getCode();
		this.data=data;
		return this;
	}
	public JsonResult success(String msg){
		this.status=true;
		this.message=msg;
		return this;
	}

	public JsonResult success(Object data){
		this.status=true;
		this.data=data;
		return this;
	}

	public JsonResult success(String msg,Object data){
		this.status=true;
		this.message=msg;
		this.data=data;
		return this;
	}
	public JsonResult success(Integer code,String msg,Object data){
		this.status=true;
		this.message=msg;
		this.data=data;
		this.code=code;
		return this;
	}
	public JsonResult success(JsonResultCode jsonResultCode,Object data){
		this.status=true;
		this.message=jsonResultCode.getMessage();
		this.code=jsonResultCode.getCode();
		this.data=data;
		return this;
	}


}
