package payload.response;

import java.util.ArrayList;

public class ResponseStatement extends Response {

    public int numPage;

    public ResponseStatement(String requestId, Boolean error, String message, Integer errorCode, ArrayList data, int numPage) {
        super(requestId, error, message, errorCode, data);
        this.numPage = numPage;
    }

    public int getNumPage() {
        return numPage;
    }
}