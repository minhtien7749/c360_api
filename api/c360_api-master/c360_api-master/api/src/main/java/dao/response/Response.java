package dao.response;

import java.util.ArrayList;
import java.util.Map;

public class Response <T> {
    private String requestId;
    private Boolean error;
    private String message;
    private Integer errorCode;
    private ArrayList<T> data;
    private Map<String,String> datas;

    public Response(String requestId, Boolean error, String message, Integer errorCode, ArrayList<T> data) {
        this.requestId = requestId;
        this.error = error;
        this.message = message;
        this.errorCode = errorCode;
        this.data = data;
    }
    
    public Response(String requestId, Boolean error, String message, Integer errorCode, ArrayList<T> data,Map<String,String> datas) {
        this.requestId = requestId;
        this.error = error;
        this.message = message;
        this.errorCode = errorCode;
        this.data = data;
        this.datas = datas;
    }

    public Response(String requestId, Boolean error, String message, Integer errorCode) {
        this.requestId = requestId;
        this.error = error;
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getRequestId() {
        return requestId;
    }


    public Boolean getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public ArrayList<T> getData() {
        return data;
    }

	public Map<String, String> getDatas() {
		return datas;
	}

	public void setDatas(Map<String, String> datas) {
		this.datas = datas;
	}


    
    
}


