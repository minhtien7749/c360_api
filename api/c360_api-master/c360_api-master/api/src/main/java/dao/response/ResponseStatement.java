package dao.response;

import java.util.ArrayList;

public class ResponseStatement extends  Response {
    private String beginBal;
    private String endBal;
    private String totalCre;
    private String totalDeb;
    private String countDeb;
    private String countCre;

    public ResponseStatement(String requestId, Boolean error, String message, Integer errorCode, ArrayList data, String beginBal, String endBal, String totalCre, String totalDeb, String countDeb, String countCre) {
        super(requestId, error, message, errorCode, data);
        this.beginBal = beginBal;
        this.endBal = endBal;
        this.totalCre = totalCre;
        this.totalDeb = totalDeb;
        this.countDeb = countDeb;
        this.countCre = countCre;
    }

    public ResponseStatement(String requestId, Boolean error, String message, Integer errorCode, String beginBal, String endBal, String totalCre, String totalDeb, String countDeb, String countCre) {
        super(requestId, error, message, errorCode);
        this.beginBal = beginBal;
        this.endBal = endBal;
        this.totalCre = totalCre;
        this.totalDeb = totalDeb;
        this.countDeb = countDeb;
        this.countCre = countCre;
    }

    public String getCountCre() {
        return countCre;
    }

    public String getCountDeb() {
        return countDeb;
    }

    public String getTotalDeb() {
        return totalDeb;
    }

    public String getTotalCre() {
        return totalCre;
    }

    public String getEndBal() {
        return endBal;
    }

    public String getBeginBal() {
        return beginBal;
    }
}
