package dao.response;

import java.util.ArrayList;

public class Response <T> {
    private String requestId;
    private Boolean error;
    private String message;
    private Integer errorCode;
    private ArrayList<T> data;

    public Response(String requestId, Boolean error, String message, Integer errorCode, ArrayList<T> data) {
        this.requestId = requestId;
        this.error = error;
        this.message = message;
        this.errorCode = errorCode;
        this.data = data;
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
}


