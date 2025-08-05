package dao.response;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ResponseDataGetTrans extends Response{
    private Integer numPage;

    public ResponseDataGetTrans(String requestId, String sessionId, Boolean error, String message, Integer errorCode, ArrayList data, Integer numPage) {
        super(requestId, sessionId, error, message, errorCode, data);
        this.numPage = numPage;
    }

    public ResponseDataGetTrans(String requestId, String sessionId, Boolean error, String message, Integer errorCode, Integer numPage) {
        super(requestId, sessionId, error, message, errorCode);
        this.numPage = numPage;
    }

    public Integer getNumPage() {
        return numPage;
    }
}