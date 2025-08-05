package dao.response;

import java.util.ArrayList;

public class ResponseDto<T> {
    private String requestId;
    private Boolean error;
    private String message;
    private Integer errorCode;
    private T data;

    public ResponseDto(String requestId, Boolean error, String message, Integer errorCode, T data) {
        this.requestId = requestId;
        this.error = error;
        this.message = message;
        this.errorCode = errorCode;
        this.data = data;
    }

    public ResponseDto(String requestId, Boolean error, String message, Integer errorCode) {
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

    public T getData() {
        return data;
    }
}
