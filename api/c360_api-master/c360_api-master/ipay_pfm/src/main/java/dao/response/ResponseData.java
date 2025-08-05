package dao.response;

import java.util.ArrayList;

public class ResponseData <T> extends Response {
    private double amountTotalIncome;
    private double amountTotalExpense;


    public ResponseData(String requestId, String sessionId, Boolean error, String message, Integer errorCode, ArrayList<T> data, double amountTotalIncome,double amountTotalExpense) {
        super(requestId, sessionId, error, message, errorCode, data);
        this.amountTotalExpense = amountTotalExpense;
        this.amountTotalIncome = amountTotalIncome;
    }
    public ResponseData(String requestId, String sessionId, Boolean error, String message, Integer errorCode, ArrayList<T> data) {
        super(requestId, sessionId, error, message, errorCode, data);
    }

    public double getAmountTotalIncome() {
        return amountTotalIncome;
    }

    public double getAmountTotalExpense() {
        return amountTotalExpense;
    }



}
