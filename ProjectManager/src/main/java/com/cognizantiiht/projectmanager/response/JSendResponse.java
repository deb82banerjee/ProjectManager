package com.cognizantiiht.projectmanager.response;

public class JSendResponse {

    public static final String STATUS_SUCCESS = "success";
    public static final String STATUS_WARNING = "warning";
    public static final String STATUS_FAIL = "fail";
    public static final String STATUS_ERROR = "error";
	
	private Object data;
	private String message;
	private String status;

	
	public JSendResponse(String status) {
		super();
		this.status = status;
	}
	
	public JSendResponse() {
		this.status = STATUS_SUCCESS;
	}
	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
