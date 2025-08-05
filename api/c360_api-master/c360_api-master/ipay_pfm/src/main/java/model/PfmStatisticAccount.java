package model;

import java.math.BigDecimal;

public class PfmStatisticAccount extends PfmStatistic{
    private String cidType;
    private String accountNo;

    public PfmStatisticAccount(String customerId, String type, BigDecimal amount, String cidType, String accountNo) {
        super(customerId, type, amount);
        this.cidType = cidType;
        this.accountNo = accountNo;
    }

    public String getCidType() {
        return cidType;
    }

    public String getAccountNo() {
        return accountNo;
    }

    @Override
    public String toString() {
        return "PfmStatisticAccount{" +
                "cidType='" + cidType + '\'' +
                ", accountNo='" + accountNo + '\'' +
                '}';
    }
}
