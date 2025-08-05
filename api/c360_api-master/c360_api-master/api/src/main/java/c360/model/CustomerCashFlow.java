package c360.model;

import java.math.BigDecimal;

public class CustomerCashFlow {
    private String acn;
    private String branch;
    private BigDecimal mtd_credt_trnsfr_amt_couter;
    private BigDecimal mtd_credt_trnsfr_cnt_couter;
    private BigDecimal mtd_debit_trnsfr_amt_couter;
    private BigDecimal mtd_debit_trnsfr_cnt_couter;
    private BigDecimal mtd_credt_trnsfr_amt_online;
    private BigDecimal mtd_credt_trnsfr_cnt_online;
    private BigDecimal mtd_debit_trnsfr_amt_online;
    private BigDecimal mtd_debit_trnsfr_cnt_online;
    private BigDecimal mtd_credt_trnsfr_amt;
    private BigDecimal mtd_credt_trnsfr_cnt;
    private BigDecimal mtd_debit_trnsfr_amt;

    @Override
    public String toString() {
        return "CustomerCashFlow{" +
                "acn='" + acn + '\'' +
                ", branch='" + branch + '\'' +
                ", mtd_credt_trnsfr_amt_couter=" + mtd_credt_trnsfr_amt_couter +
                ", mtd_credt_trnsfr_cnt_couter=" + mtd_credt_trnsfr_cnt_couter +
                ", mtd_debit_trnsfr_amt_couter=" + mtd_debit_trnsfr_amt_couter +
                ", mtd_debit_trnsfr_cnt_couter=" + mtd_debit_trnsfr_cnt_couter +
                ", mtd_credt_trnsfr_amt_online=" + mtd_credt_trnsfr_amt_online +
                ", mtd_credt_trnsfr_cnt_online=" + mtd_credt_trnsfr_cnt_online +
                ", mtd_debit_trnsfr_amt_online=" + mtd_debit_trnsfr_amt_online +
                ", mtd_debit_trnsfr_cnt_online=" + mtd_debit_trnsfr_cnt_online +
                ", mtd_credt_trnsfr_amt=" + mtd_credt_trnsfr_amt +
                ", mtd_credt_trnsfr_cnt=" + mtd_credt_trnsfr_cnt +
                ", mtd_debit_trnsfr_amt=" + mtd_debit_trnsfr_amt +
                ", mtd_debit_trnsfr_cnt=" + mtd_debit_trnsfr_cnt +
                ", mtd_outbank_debit_trnsfr_amt=" + mtd_outbank_debit_trnsfr_amt +
                ", mtd_outbank_debit_trnsfr_cnt=" + mtd_outbank_debit_trnsfr_cnt +
                ", mtd_outbank_credt_trnsfr_amt=" + mtd_outbank_credt_trnsfr_amt +
                ", mtd_outbank_credt_trnsfr_cnt=" + mtd_outbank_credt_trnsfr_cnt +
                ", mtd_bill_payment_amt=" + mtd_bill_payment_amt +
                ", mtd_bill_payment_cnt=" + mtd_bill_payment_cnt +
                ", mtd_saving_amt=" + mtd_saving_amt +
                ", mtd_saving_cnt=" + mtd_saving_cnt +
                ", mtd_loan_payment_amt=" + mtd_loan_payment_amt +
                ", mtd_loan_payment_cnt=" + mtd_loan_payment_cnt +
                ", mtd_credit_cash_amt=" + mtd_credit_cash_amt +
                ", mtd_credit_cash_cnt=" + mtd_credit_cash_cnt +
                ", mtd_debit_cash_amt=" + mtd_debit_cash_amt +
                ", mtd_debit_cash_cnt=" + mtd_debit_cash_cnt +
                ", mtd_debit_oversea_amt=" + mtd_debit_oversea_amt +
                ", mtd_credit_oversea_amt=" + mtd_credit_oversea_amt +
                ", mtd_debit_oversea_cnt=" + mtd_debit_oversea_cnt +
                ", mtd_credit_oversea_cnt=" + mtd_credit_oversea_cnt +
                ", qtd_credt_trnsfr_amt_couter=" + qtd_credt_trnsfr_amt_couter +
                ", qtd_credt_trnsfr_cnt_couter=" + qtd_credt_trnsfr_cnt_couter +
                ", qtd_debit_trnsfr_amt_couter=" + qtd_debit_trnsfr_amt_couter +
                ", qtd_debit_trnsfr_cnt_couter=" + qtd_debit_trnsfr_cnt_couter +
                ", qtd_credt_trnsfr_amt_online=" + qtd_credt_trnsfr_amt_online +
                ", qtd_credt_trnsfr_cnt_online=" + qtd_credt_trnsfr_cnt_online +
                ", qtd_debit_trnsfr_amt_online=" + qtd_debit_trnsfr_amt_online +
                ", qtd_debit_trnsfr_cnt_online=" + qtd_debit_trnsfr_cnt_online +
                ", qtd_credt_trnsfr_amt=" + qtd_credt_trnsfr_amt +
                ", qtd_credt_trnsfr_cnt=" + qtd_credt_trnsfr_cnt +
                ", qtd_debit_trnsfr_amt=" + qtd_debit_trnsfr_amt +
                ", qtd_debit_trnsfr_cnt=" + qtd_debit_trnsfr_cnt +
                ", qtd_outbank_debit_trnsfr_amt=" + qtd_outbank_debit_trnsfr_amt +
                ", qtd_outbank_debit_trnsfr_cnt=" + qtd_outbank_debit_trnsfr_cnt +
                ", qtd_outbank_credt_trnsfr_amt=" + qtd_outbank_credt_trnsfr_amt +
                ", qtd_outbank_credt_trnsfr_cnt=" + qtd_outbank_credt_trnsfr_cnt +
                ", qtd_bill_payment_amt=" + qtd_bill_payment_amt +
                ", qtd_bill_payment_cnt=" + qtd_bill_payment_cnt +
                ", qtd_saving_amt=" + qtd_saving_amt +
                ", qtd_saving_cnt=" + qtd_saving_cnt +
                ", qtd_loan_payment_amt=" + qtd_loan_payment_amt +
                ", qtd_loan_payment_cnt=" + qtd_loan_payment_cnt +
                ", qtd_credit_cash_amt=" + qtd_credit_cash_amt +
                ", qtd_credit_cash_cnt=" + qtd_credit_cash_cnt +
                ", qtd_debit_cash_amt=" + qtd_debit_cash_amt +
                ", qtd_debit_cash_cnt=" + qtd_debit_cash_cnt +
                ", qtd_debit_oversea_amt=" + qtd_debit_oversea_amt +
                ", qtd_credit_oversea_amt=" + qtd_credit_oversea_amt +
                ", qtd_debit_oversea_cnt=" + qtd_debit_oversea_cnt +
                ", qtd_credit_oversea_cnt=" + qtd_credit_oversea_cnt +
                ", ytd_credt_trnsfr_amt_couter=" + ytd_credt_trnsfr_amt_couter +
                ", ytd_credt_trnsfr_cnt_couter=" + ytd_credt_trnsfr_cnt_couter +
                ", ytd_debit_trnsfr_amt_couter=" + ytd_debit_trnsfr_amt_couter +
                ", ytd_debit_trnsfr_cnt_couter=" + ytd_debit_trnsfr_cnt_couter +
                ", ytd_credt_trnsfr_amt_online=" + ytd_credt_trnsfr_amt_online +
                ", ytd_credt_trnsfr_cnt_online=" + ytd_credt_trnsfr_cnt_online +
                ", ytd_debit_trnsfr_amt_online=" + ytd_debit_trnsfr_amt_online +
                ", ytd_debit_trnsfr_cnt_online=" + ytd_debit_trnsfr_cnt_online +
                ", ytd_credt_trnsfr_amt=" + ytd_credt_trnsfr_amt +
                ", ytd_credt_trnsfr_cnt=" + ytd_credt_trnsfr_cnt +
                ", ytd_debit_trnsfr_amt=" + ytd_debit_trnsfr_amt +
                ", ytd_debit_trnsfr_cnt=" + ytd_debit_trnsfr_cnt +
                ", ytd_outbank_debit_trnsfr_amt=" + ytd_outbank_debit_trnsfr_amt +
                ", ytd_outbank_debit_trnsfr_cnt=" + ytd_outbank_debit_trnsfr_cnt +
                ", ytd_outbank_credt_trnsfr_amt=" + ytd_outbank_credt_trnsfr_amt +
                ", ytd_outbank_credt_trnsfr_cnt=" + ytd_outbank_credt_trnsfr_cnt +
                ", ytd_bill_payment_amt=" + ytd_bill_payment_amt +
                ", ytd_bill_payment_cnt=" + ytd_bill_payment_cnt +
                ", ytd_saving_amt=" + ytd_saving_amt +
                ", ytd_saving_cnt=" + ytd_saving_cnt +
                ", ytd_loan_payment_amt=" + ytd_loan_payment_amt +
                ", ytd_loan_payment_cnt=" + ytd_loan_payment_cnt +
                ", ytd_credit_cash_amt=" + ytd_credit_cash_amt +
                ", ytd_credit_cash_cnt=" + ytd_credit_cash_cnt +
                ", ytd_debit_cash_amt=" + ytd_debit_cash_amt +
                ", ytd_debit_cash_cnt=" + ytd_debit_cash_cnt +
                ", ytd_debit_oversea_amt=" + ytd_debit_oversea_amt +
                ", ytd_credit_oversea_amt=" + ytd_credit_oversea_amt +
                ", ytd_debit_oversea_cnt=" + ytd_debit_oversea_cnt +
                ", ytd_credit_oversea_cnt=" + ytd_credit_oversea_cnt +
                ", ytd_dda_rlse_amt=" + ytd_dda_rlse_amt +
                ", ytd_rlse_amt=" + ytd_rlse_amt +
                ", ytd_rlse_shrtrm_amt=" + ytd_rlse_shrtrm_amt +
                ", ytd_rlse_lngtrm_amt=" + ytd_rlse_lngtrm_amt +
                ", ytd_dda_rlse_amt_ratio=" + ytd_dda_rlse_amt_ratio +
                ", ytd_credit_trnsfr_amt_ratio=" + ytd_credit_trnsfr_amt_ratio +
                ", ytd_outbank_trns_fr_ratio=" + ytd_outbank_trns_fr_ratio +
                ", cob_dt='" + cob_dt + '\'' +
                '}';
    }

    private BigDecimal mtd_debit_trnsfr_cnt;
    private BigDecimal mtd_outbank_debit_trnsfr_amt;
    private BigDecimal mtd_outbank_debit_trnsfr_cnt;
    private BigDecimal mtd_outbank_credt_trnsfr_amt;
    private BigDecimal mtd_outbank_credt_trnsfr_cnt;
    private BigDecimal mtd_bill_payment_amt;
    private BigDecimal mtd_bill_payment_cnt;
    private BigDecimal mtd_saving_amt;
    private BigDecimal mtd_saving_cnt;
    private BigDecimal mtd_loan_payment_amt;
    private BigDecimal mtd_loan_payment_cnt;
    private BigDecimal mtd_credit_cash_amt;
    private BigDecimal mtd_credit_cash_cnt;
    private BigDecimal mtd_debit_cash_amt;
    private BigDecimal mtd_debit_cash_cnt;
    private BigDecimal mtd_debit_oversea_amt;
    private BigDecimal mtd_credit_oversea_amt;
    private BigDecimal mtd_debit_oversea_cnt;
    private BigDecimal mtd_credit_oversea_cnt;
    private BigDecimal qtd_credt_trnsfr_amt_couter;
    private BigDecimal qtd_credt_trnsfr_cnt_couter;
    private BigDecimal qtd_debit_trnsfr_amt_couter;
    private BigDecimal qtd_debit_trnsfr_cnt_couter;
    private BigDecimal qtd_credt_trnsfr_amt_online;
    private BigDecimal qtd_credt_trnsfr_cnt_online;
    private BigDecimal qtd_debit_trnsfr_amt_online;
    private BigDecimal qtd_debit_trnsfr_cnt_online;
    private BigDecimal qtd_credt_trnsfr_amt;
    private BigDecimal qtd_credt_trnsfr_cnt;
    private BigDecimal qtd_debit_trnsfr_amt;
    private BigDecimal qtd_debit_trnsfr_cnt;
    private BigDecimal qtd_outbank_debit_trnsfr_amt;
    private BigDecimal qtd_outbank_debit_trnsfr_cnt;
    private BigDecimal qtd_outbank_credt_trnsfr_amt;
    private BigDecimal qtd_outbank_credt_trnsfr_cnt;
    private BigDecimal qtd_bill_payment_amt;
    private BigDecimal qtd_bill_payment_cnt;
    private BigDecimal qtd_saving_amt;
    private BigDecimal qtd_saving_cnt;
    private BigDecimal qtd_loan_payment_amt;
    private BigDecimal qtd_loan_payment_cnt;
    private BigDecimal qtd_credit_cash_amt;
    private BigDecimal qtd_credit_cash_cnt;
    private BigDecimal qtd_debit_cash_amt;
    private BigDecimal qtd_debit_cash_cnt;
    private BigDecimal qtd_debit_oversea_amt;
    private BigDecimal qtd_credit_oversea_amt;
    private BigDecimal qtd_debit_oversea_cnt;
    private BigDecimal qtd_credit_oversea_cnt;
    private BigDecimal ytd_credt_trnsfr_amt_couter;
    private BigDecimal ytd_credt_trnsfr_cnt_couter;
    private BigDecimal ytd_debit_trnsfr_amt_couter;
    private BigDecimal ytd_debit_trnsfr_cnt_couter;
    private BigDecimal ytd_credt_trnsfr_amt_online;
    private BigDecimal ytd_credt_trnsfr_cnt_online;
    private BigDecimal ytd_debit_trnsfr_amt_online;
    private BigDecimal ytd_debit_trnsfr_cnt_online;
    private BigDecimal ytd_credt_trnsfr_amt;
    private BigDecimal ytd_credt_trnsfr_cnt;
    private BigDecimal ytd_debit_trnsfr_amt;
    private BigDecimal ytd_debit_trnsfr_cnt;
    private BigDecimal ytd_outbank_debit_trnsfr_amt;
    private BigDecimal ytd_outbank_debit_trnsfr_cnt;
    private BigDecimal ytd_outbank_credt_trnsfr_amt;
    private BigDecimal ytd_outbank_credt_trnsfr_cnt;
    private BigDecimal ytd_bill_payment_amt;
    private BigDecimal ytd_bill_payment_cnt;
    private BigDecimal ytd_saving_amt;
    private BigDecimal ytd_saving_cnt;
    private BigDecimal ytd_loan_payment_amt;
    private BigDecimal ytd_loan_payment_cnt;
    private BigDecimal ytd_credit_cash_amt;
    private BigDecimal ytd_credit_cash_cnt;
    private BigDecimal ytd_debit_cash_amt;
    private BigDecimal ytd_debit_cash_cnt;
    private BigDecimal ytd_debit_oversea_amt;
    private BigDecimal ytd_credit_oversea_amt;
    private BigDecimal ytd_debit_oversea_cnt;
    private BigDecimal ytd_credit_oversea_cnt;
    private BigDecimal ytd_dda_rlse_amt;
    private BigDecimal ytd_rlse_amt;
    private BigDecimal ytd_rlse_shrtrm_amt;
    private BigDecimal ytd_rlse_lngtrm_amt;
    private BigDecimal ytd_credit_trnsfr_amt_ratio;
    private BigDecimal ytd_dda_rlse_amt_ratio;
    private BigDecimal ytd_outbank_trns_fr_ratio;
    private BigDecimal ytd_credit_cash_instore_amt;
    private String cob_dt;

    public CustomerCashFlow(String acn, String branch, BigDecimal mtd_credt_trnsfr_amt_couter,
                            BigDecimal mtd_credt_trnsfr_cnt_couter, BigDecimal mtd_debit_trnsfr_amt_couter,
                            BigDecimal mtd_debit_trnsfr_cnt_couter, BigDecimal mtd_credt_trnsfr_amt_online,
                            BigDecimal mtd_credt_trnsfr_cnt_online, BigDecimal mtd_debit_trnsfr_amt_online,
                            BigDecimal mtd_debit_trnsfr_cnt_online, BigDecimal mtd_credt_trnsfr_amt,
                            BigDecimal mtd_credt_trnsfr_cnt, BigDecimal mtd_debit_trnsfr_amt,
                            BigDecimal mtd_debit_trnsfr_cnt, BigDecimal mtd_outbank_debit_trnsfr_amt,
                            BigDecimal mtd_outbank_debit_trnsfr_cnt, BigDecimal mtd_outbank_credt_trnsfr_amt,
                            BigDecimal mtd_outbank_credt_trnsfr_cnt, BigDecimal mtd_bill_payment_amt,
                            BigDecimal mtd_bill_payment_cnt, BigDecimal mtd_saving_amt, BigDecimal mtd_saving_cnt,
                            BigDecimal mtd_loan_payment_amt, BigDecimal mtd_loan_payment_cnt,
                            BigDecimal mtd_credit_cash_amt, BigDecimal mtd_credit_cash_cnt, BigDecimal mtd_debit_cash_amt,
                            BigDecimal mtd_debit_cash_cnt, BigDecimal mtd_debit_oversea_amt,
                            BigDecimal mtd_credit_oversea_amt, BigDecimal mtd_debit_oversea_cnt,
                            BigDecimal mtd_credit_oversea_cnt, BigDecimal qtd_credt_trnsfr_amt_couter,
                            BigDecimal qtd_credt_trnsfr_cnt_couter, BigDecimal qtd_debit_trnsfr_amt_couter,
                            BigDecimal qtd_debit_trnsfr_cnt_couter, BigDecimal qtd_credt_trnsfr_amt_online,
                            BigDecimal qtd_credt_trnsfr_cnt_online, BigDecimal qtd_debit_trnsfr_amt_online,
                            BigDecimal qtd_debit_trnsfr_cnt_online, BigDecimal qtd_credt_trnsfr_amt,
                            BigDecimal qtd_credt_trnsfr_cnt, BigDecimal qtd_debit_trnsfr_amt,
                            BigDecimal qtd_debit_trnsfr_cnt, BigDecimal qtd_outbank_debit_trnsfr_amt,
                            BigDecimal qtd_outbank_debit_trnsfr_cnt, BigDecimal qtd_outbank_credt_trnsfr_amt,
                            BigDecimal qtd_outbank_credt_trnsfr_cnt, BigDecimal qtd_bill_payment_amt,
                            BigDecimal qtd_bill_payment_cnt, BigDecimal qtd_saving_amt, BigDecimal qtd_saving_cnt,
                            BigDecimal qtd_loan_payment_amt, BigDecimal qtd_loan_payment_cnt,
                            BigDecimal qtd_credit_cash_amt, BigDecimal qtd_credit_cash_cnt,
                            BigDecimal qtd_debit_cash_amt, BigDecimal qtd_debit_cash_cnt, BigDecimal qtd_debit_oversea_amt,
                            BigDecimal qtd_credit_oversea_amt, BigDecimal qtd_debit_oversea_cnt,
                            BigDecimal qtd_credit_oversea_cnt, BigDecimal ytd_credt_trnsfr_amt_couter,
                            BigDecimal ytd_credt_trnsfr_cnt_couter, BigDecimal ytd_debit_trnsfr_amt_couter,
                            BigDecimal ytd_debit_trnsfr_cnt_couter, BigDecimal ytd_credt_trnsfr_amt_online,
                            BigDecimal ytd_credt_trnsfr_cnt_online, BigDecimal ytd_debit_trnsfr_amt_online,
                            BigDecimal ytd_debit_trnsfr_cnt_online, BigDecimal ytd_credt_trnsfr_amt,
                            BigDecimal ytd_credt_trnsfr_cnt, BigDecimal ytd_debit_trnsfr_amt,
                            BigDecimal ytd_debit_trnsfr_cnt, BigDecimal ytd_outbank_debit_trnsfr_amt,
                            BigDecimal ytd_outbank_debit_trnsfr_cnt, BigDecimal ytd_outbank_credt_trnsfr_amt,
                            BigDecimal ytd_outbank_credt_trnsfr_cnt, BigDecimal ytd_bill_payment_amt,
                            BigDecimal ytd_bill_payment_cnt, BigDecimal ytd_saving_amt,
                            BigDecimal ytd_saving_cnt, BigDecimal ytd_loan_payment_amt,
                            BigDecimal ytd_loan_payment_cnt, BigDecimal ytd_credit_cash_amt,
                            BigDecimal ytd_credit_cash_cnt, BigDecimal ytd_debit_cash_amt,
                            BigDecimal ytd_debit_cash_cnt, BigDecimal ytd_debit_oversea_amt,
                            BigDecimal ytd_credit_oversea_amt, BigDecimal ytd_debit_oversea_cnt,
                            BigDecimal ytd_credit_oversea_cnt, BigDecimal ytd_dda_rlse_amt, BigDecimal ytd_rlse_amt,
                            BigDecimal ytd_rlse_shrtrm_amt, BigDecimal ytd_rlse_lngtrm_amt,BigDecimal ytd_credit_cash_instore_amt,BigDecimal ytd_dda_rlse_amt_ratio,BigDecimal ytd_credit_trnsfr_amt_ratio,BigDecimal ytd_outbank_trns_fr_ratio, String cob_dt) {
        this.acn = acn;
        this.branch = branch;
        this.mtd_credt_trnsfr_amt_couter = mtd_credt_trnsfr_amt_couter;
        this.mtd_credt_trnsfr_cnt_couter = mtd_credt_trnsfr_cnt_couter;
        this.mtd_debit_trnsfr_amt_couter = mtd_debit_trnsfr_amt_couter;
        this.mtd_debit_trnsfr_cnt_couter = mtd_debit_trnsfr_cnt_couter;
        this.mtd_credt_trnsfr_amt_online = mtd_credt_trnsfr_amt_online;
        this.mtd_credt_trnsfr_cnt_online = mtd_credt_trnsfr_cnt_online;
        this.mtd_debit_trnsfr_amt_online = mtd_debit_trnsfr_amt_online;
        this.mtd_debit_trnsfr_cnt_online = mtd_debit_trnsfr_cnt_online;
        this.mtd_credt_trnsfr_amt = mtd_credt_trnsfr_amt;
        this.mtd_credt_trnsfr_cnt = mtd_credt_trnsfr_cnt;
        this.mtd_debit_trnsfr_amt = mtd_debit_trnsfr_amt;
        this.mtd_debit_trnsfr_cnt = mtd_debit_trnsfr_cnt;
        this.mtd_outbank_debit_trnsfr_amt = mtd_outbank_debit_trnsfr_amt;
        this.mtd_outbank_debit_trnsfr_cnt = mtd_outbank_debit_trnsfr_cnt;
        this.mtd_outbank_credt_trnsfr_amt = mtd_outbank_credt_trnsfr_amt;
        this.mtd_outbank_credt_trnsfr_cnt = mtd_outbank_credt_trnsfr_cnt;
        this.mtd_bill_payment_amt = mtd_bill_payment_amt;
        this.mtd_bill_payment_cnt = mtd_bill_payment_cnt;
        this.mtd_saving_amt = mtd_saving_amt;
        this.mtd_saving_cnt = mtd_saving_cnt;
        this.mtd_loan_payment_amt = mtd_loan_payment_amt;
        this.mtd_loan_payment_cnt = mtd_loan_payment_cnt;
        this.mtd_credit_cash_amt = mtd_credit_cash_amt;
        this.mtd_credit_cash_cnt = mtd_credit_cash_cnt;
        this.mtd_debit_cash_amt = mtd_debit_cash_amt;
        this.mtd_debit_cash_cnt = mtd_debit_cash_cnt;
        this.mtd_debit_oversea_amt = mtd_debit_oversea_amt;
        this.mtd_credit_oversea_amt = mtd_credit_oversea_amt;
        this.mtd_debit_oversea_cnt = mtd_debit_oversea_cnt;
        this.mtd_credit_oversea_cnt = mtd_credit_oversea_cnt;
        this.qtd_credt_trnsfr_amt_couter = qtd_credt_trnsfr_amt_couter;
        this.qtd_credt_trnsfr_cnt_couter = qtd_credt_trnsfr_cnt_couter;
        this.qtd_debit_trnsfr_amt_couter = qtd_debit_trnsfr_amt_couter;
        this.qtd_debit_trnsfr_cnt_couter = qtd_debit_trnsfr_cnt_couter;
        this.qtd_credt_trnsfr_amt_online = qtd_credt_trnsfr_amt_online;
        this.qtd_credt_trnsfr_cnt_online = qtd_credt_trnsfr_cnt_online;
        this.qtd_debit_trnsfr_amt_online = qtd_debit_trnsfr_amt_online;
        this.qtd_debit_trnsfr_cnt_online = qtd_debit_trnsfr_cnt_online;
        this.qtd_credt_trnsfr_amt = qtd_credt_trnsfr_amt;
        this.qtd_credt_trnsfr_cnt = qtd_credt_trnsfr_cnt;
        this.qtd_debit_trnsfr_amt = qtd_debit_trnsfr_amt;
        this.qtd_debit_trnsfr_cnt = qtd_debit_trnsfr_cnt;
        this.qtd_outbank_debit_trnsfr_amt = qtd_outbank_debit_trnsfr_amt;
        this.qtd_outbank_debit_trnsfr_cnt = qtd_outbank_debit_trnsfr_cnt;
        this.qtd_outbank_credt_trnsfr_amt = qtd_outbank_credt_trnsfr_amt;
        this.qtd_outbank_credt_trnsfr_cnt = qtd_outbank_credt_trnsfr_cnt;
        this.qtd_bill_payment_amt = qtd_bill_payment_amt;
        this.qtd_bill_payment_cnt = qtd_bill_payment_cnt;
        this.qtd_saving_amt = qtd_saving_amt;
        this.qtd_saving_cnt = qtd_saving_cnt;
        this.qtd_loan_payment_amt = qtd_loan_payment_amt;
        this.qtd_loan_payment_cnt = qtd_loan_payment_cnt;
        this.qtd_credit_cash_amt = qtd_credit_cash_amt;
        this.qtd_credit_cash_cnt = qtd_credit_cash_cnt;
        this.qtd_debit_cash_amt = qtd_debit_cash_amt;
        this.qtd_debit_cash_cnt = qtd_debit_cash_cnt;
        this.qtd_debit_oversea_amt = qtd_debit_oversea_amt;
        this.qtd_credit_oversea_amt = qtd_credit_oversea_amt;
        this.qtd_debit_oversea_cnt = qtd_debit_oversea_cnt;
        this.qtd_credit_oversea_cnt = qtd_credit_oversea_cnt;
        this.ytd_credt_trnsfr_amt_couter = ytd_credt_trnsfr_amt_couter;
        this.ytd_credt_trnsfr_cnt_couter = ytd_credt_trnsfr_cnt_couter;
        this.ytd_debit_trnsfr_amt_couter = ytd_debit_trnsfr_amt_couter;
        this.ytd_debit_trnsfr_cnt_couter = ytd_debit_trnsfr_cnt_couter;
        this.ytd_credt_trnsfr_amt_online = ytd_credt_trnsfr_amt_online;
        this.ytd_credt_trnsfr_cnt_online = ytd_credt_trnsfr_cnt_online;
        this.ytd_debit_trnsfr_amt_online = ytd_debit_trnsfr_amt_online;
        this.ytd_debit_trnsfr_cnt_online = ytd_debit_trnsfr_cnt_online;
        this.ytd_credt_trnsfr_amt = ytd_credt_trnsfr_amt;
        this.ytd_credt_trnsfr_cnt = ytd_credt_trnsfr_cnt;
        this.ytd_debit_trnsfr_amt = ytd_debit_trnsfr_amt;
        this.ytd_debit_trnsfr_cnt = ytd_debit_trnsfr_cnt;
        this.ytd_outbank_debit_trnsfr_amt = ytd_outbank_debit_trnsfr_amt;
        this.ytd_outbank_debit_trnsfr_cnt = ytd_outbank_debit_trnsfr_cnt;
        this.ytd_outbank_credt_trnsfr_amt = ytd_outbank_credt_trnsfr_amt;
        this.ytd_outbank_credt_trnsfr_cnt = ytd_outbank_credt_trnsfr_cnt;
        this.ytd_bill_payment_amt = ytd_bill_payment_amt;
        this.ytd_bill_payment_cnt = ytd_bill_payment_cnt;
        this.ytd_saving_amt = ytd_saving_amt;
        this.ytd_saving_cnt = ytd_saving_cnt;
        this.ytd_loan_payment_amt = ytd_loan_payment_amt;
        this.ytd_loan_payment_cnt = ytd_loan_payment_cnt;
        this.ytd_credit_cash_amt = ytd_credit_cash_amt;
        this.ytd_credit_cash_cnt = ytd_credit_cash_cnt;
        this.ytd_debit_cash_amt = ytd_debit_cash_amt;
        this.ytd_debit_cash_cnt = ytd_debit_cash_cnt;
        this.ytd_debit_oversea_amt = ytd_debit_oversea_amt;
        this.ytd_credit_oversea_amt = ytd_credit_oversea_amt;
        this.ytd_debit_oversea_cnt = ytd_debit_oversea_cnt;
        this.ytd_credit_oversea_cnt = ytd_credit_oversea_cnt;
        this.ytd_dda_rlse_amt = ytd_dda_rlse_amt;
        this.ytd_rlse_amt = ytd_rlse_amt;
        this.ytd_rlse_shrtrm_amt = ytd_rlse_shrtrm_amt;
        this.ytd_rlse_lngtrm_amt = ytd_rlse_lngtrm_amt;
        this.ytd_credit_cash_instore_amt = ytd_credit_cash_instore_amt;
        this.ytd_dda_rlse_amt_ratio = ytd_dda_rlse_amt_ratio;
        this.ytd_credit_trnsfr_amt_ratio = ytd_credit_trnsfr_amt_ratio;
        this.ytd_outbank_trns_fr_ratio = ytd_outbank_trns_fr_ratio;
        this.cob_dt = cob_dt;
    }

    public String getAcn() {
        return acn;
    }

    public void setAcn(String acn) {
        this.acn = acn;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public BigDecimal getMtd_credt_trnsfr_amt_couter() {
        return mtd_credt_trnsfr_amt_couter;
    }

    public void setMtd_credt_trnsfr_amt_couter(BigDecimal mtd_credt_trnsfr_amt_couter) {
        this.mtd_credt_trnsfr_amt_couter = mtd_credt_trnsfr_amt_couter;
    }

    public BigDecimal getMtd_credt_trnsfr_cnt_couter() {
        return mtd_credt_trnsfr_cnt_couter;
    }

    public void setMtd_credt_trnsfr_cnt_couter(BigDecimal mtd_credt_trnsfr_cnt_couter) {
        this.mtd_credt_trnsfr_cnt_couter = mtd_credt_trnsfr_cnt_couter;
    }

    public BigDecimal getMtd_debit_trnsfr_amt_couter() {
        return mtd_debit_trnsfr_amt_couter;
    }

    public void setMtd_debit_trnsfr_amt_couter(BigDecimal mtd_debit_trnsfr_amt_couter) {
        this.mtd_debit_trnsfr_amt_couter = mtd_debit_trnsfr_amt_couter;
    }

    public BigDecimal getMtd_debit_trnsfr_cnt_couter() {
        return mtd_debit_trnsfr_cnt_couter;
    }

    public void setMtd_debit_trnsfr_cnt_couter(BigDecimal mtd_debit_trnsfr_cnt_couter) {
        this.mtd_debit_trnsfr_cnt_couter = mtd_debit_trnsfr_cnt_couter;
    }

    public BigDecimal getMtd_credt_trnsfr_amt_online() {
        return mtd_credt_trnsfr_amt_online;
    }

    public void setMtd_credt_trnsfr_amt_online(BigDecimal mtd_credt_trnsfr_amt_online) {
        this.mtd_credt_trnsfr_amt_online = mtd_credt_trnsfr_amt_online;
    }

    public BigDecimal getMtd_credt_trnsfr_cnt_online() {
        return mtd_credt_trnsfr_cnt_online;
    }

    public void setMtd_credt_trnsfr_cnt_online(BigDecimal mtd_credt_trnsfr_cnt_online) {
        this.mtd_credt_trnsfr_cnt_online = mtd_credt_trnsfr_cnt_online;
    }

    public BigDecimal getMtd_debit_trnsfr_amt_online() {
        return mtd_debit_trnsfr_amt_online;
    }

    public void setMtd_debit_trnsfr_amt_online(BigDecimal mtd_debit_trnsfr_amt_online) {
        this.mtd_debit_trnsfr_amt_online = mtd_debit_trnsfr_amt_online;
    }

    public BigDecimal getMtd_debit_trnsfr_cnt_online() {
        return mtd_debit_trnsfr_cnt_online;
    }

    public void setMtd_debit_trnsfr_cnt_online(BigDecimal mtd_debit_trnsfr_cnt_online) {
        this.mtd_debit_trnsfr_cnt_online = mtd_debit_trnsfr_cnt_online;
    }

    public BigDecimal getMtd_credt_trnsfr_amt() {
        return mtd_credt_trnsfr_amt;
    }

    public void setMtd_credt_trnsfr_amt(BigDecimal mtd_credt_trnsfr_amt) {
        this.mtd_credt_trnsfr_amt = mtd_credt_trnsfr_amt;
    }

    public BigDecimal getMtd_credt_trnsfr_cnt() {
        return mtd_credt_trnsfr_cnt;
    }

    public void setMtd_credt_trnsfr_cnt(BigDecimal mtd_credt_trnsfr_cnt) {
        this.mtd_credt_trnsfr_cnt = mtd_credt_trnsfr_cnt;
    }

    public BigDecimal getMtd_debit_trnsfr_amt() {
        return mtd_debit_trnsfr_amt;
    }

    public void setMtd_debit_trnsfr_amt(BigDecimal mtd_debit_trnsfr_amt) {
        this.mtd_debit_trnsfr_amt = mtd_debit_trnsfr_amt;
    }

    public BigDecimal getMtd_debit_trnsfr_cnt() {
        return mtd_debit_trnsfr_cnt;
    }

    public void setMtd_debit_trnsfr_cnt(BigDecimal mtd_debit_trnsfr_cnt) {
        this.mtd_debit_trnsfr_cnt = mtd_debit_trnsfr_cnt;
    }

    public BigDecimal getMtd_outbank_debit_trnsfr_amt() {
        return mtd_outbank_debit_trnsfr_amt;
    }

    public void setMtd_outbank_debit_trnsfr_amt(BigDecimal mtd_outbank_debit_trnsfr_amt) {
        this.mtd_outbank_debit_trnsfr_amt = mtd_outbank_debit_trnsfr_amt;
    }

    public BigDecimal getMtd_outbank_debit_trnsfr_cnt() {
        return mtd_outbank_debit_trnsfr_cnt;
    }

    public void setMtd_outbank_debit_trnsfr_cnt(BigDecimal mtd_outbank_debit_trnsfr_cnt) {
        this.mtd_outbank_debit_trnsfr_cnt = mtd_outbank_debit_trnsfr_cnt;
    }

    public BigDecimal getMtd_outbank_credt_trnsfr_amt() {
        return mtd_outbank_credt_trnsfr_amt;
    }

    public void setMtd_outbank_credt_trnsfr_amt(BigDecimal mtd_outbank_credt_trnsfr_amt) {
        this.mtd_outbank_credt_trnsfr_amt = mtd_outbank_credt_trnsfr_amt;
    }

    public BigDecimal getMtd_outbank_credt_trnsfr_cnt() {
        return mtd_outbank_credt_trnsfr_cnt;
    }

    public void setMtd_outbank_credt_trnsfr_cnt(BigDecimal mtd_outbank_credt_trnsfr_cnt) {
        this.mtd_outbank_credt_trnsfr_cnt = mtd_outbank_credt_trnsfr_cnt;
    }

    public BigDecimal getMtd_bill_payment_amt() {
        return mtd_bill_payment_amt;
    }

    public void setMtd_bill_payment_amt(BigDecimal mtd_bill_payment_amt) {
        this.mtd_bill_payment_amt = mtd_bill_payment_amt;
    }

    public BigDecimal getMtd_bill_payment_cnt() {
        return mtd_bill_payment_cnt;
    }

    public void setMtd_bill_payment_cnt(BigDecimal mtd_bill_payment_cnt) {
        this.mtd_bill_payment_cnt = mtd_bill_payment_cnt;
    }

    public BigDecimal getMtd_saving_amt() {
        return mtd_saving_amt;
    }

    public void setMtd_saving_amt(BigDecimal mtd_saving_amt) {
        this.mtd_saving_amt = mtd_saving_amt;
    }

    public BigDecimal getMtd_saving_cnt() {
        return mtd_saving_cnt;
    }

    public void setMtd_saving_cnt(BigDecimal mtd_saving_cnt) {
        this.mtd_saving_cnt = mtd_saving_cnt;
    }

    public BigDecimal getMtd_loan_payment_amt() {
        return mtd_loan_payment_amt;
    }

    public void setMtd_loan_payment_amt(BigDecimal mtd_loan_payment_amt) {
        this.mtd_loan_payment_amt = mtd_loan_payment_amt;
    }

    public BigDecimal getMtd_loan_payment_cnt() {
        return mtd_loan_payment_cnt;
    }

    public void setMtd_loan_payment_cnt(BigDecimal mtd_loan_payment_cnt) {
        this.mtd_loan_payment_cnt = mtd_loan_payment_cnt;
    }

    public BigDecimal getMtd_credit_cash_amt() {
        return mtd_credit_cash_amt;
    }

    public void setMtd_credit_cash_amt(BigDecimal mtd_credit_cash_amt) {
        this.mtd_credit_cash_amt = mtd_credit_cash_amt;
    }

    public BigDecimal getMtd_credit_cash_cnt() {
        return mtd_credit_cash_cnt;
    }

    public void setMtd_credit_cash_cnt(BigDecimal mtd_credit_cash_cnt) {
        this.mtd_credit_cash_cnt = mtd_credit_cash_cnt;
    }

    public BigDecimal getMtd_debit_cash_amt() {
        return mtd_debit_cash_amt;
    }

    public void setMtd_debit_cash_amt(BigDecimal mtd_debit_cash_amt) {
        this.mtd_debit_cash_amt = mtd_debit_cash_amt;
    }

    public BigDecimal getMtd_debit_cash_cnt() {
        return mtd_debit_cash_cnt;
    }

    public void setMtd_debit_cash_cnt(BigDecimal mtd_debit_cash_cnt) {
        this.mtd_debit_cash_cnt = mtd_debit_cash_cnt;
    }

    public BigDecimal getMtd_debit_oversea_amt() {
        return mtd_debit_oversea_amt;
    }

    public void setMtd_debit_oversea_amt(BigDecimal mtd_debit_oversea_amt) {
        this.mtd_debit_oversea_amt = mtd_debit_oversea_amt;
    }

    public BigDecimal getMtd_credit_oversea_amt() {
        return mtd_credit_oversea_amt;
    }

    public void setMtd_credit_oversea_amt(BigDecimal mtd_credit_oversea_amt) {
        this.mtd_credit_oversea_amt = mtd_credit_oversea_amt;
    }

    public BigDecimal getMtd_debit_oversea_cnt() {
        return mtd_debit_oversea_cnt;
    }

    public void setMtd_debit_oversea_cnt(BigDecimal mtd_debit_oversea_cnt) {
        this.mtd_debit_oversea_cnt = mtd_debit_oversea_cnt;
    }

    public BigDecimal getMtd_credit_oversea_cnt() {
        return mtd_credit_oversea_cnt;
    }

    public void setMtd_credit_oversea_cnt(BigDecimal mtd_credit_oversea_cnt) {
        this.mtd_credit_oversea_cnt = mtd_credit_oversea_cnt;
    }

    public BigDecimal getQtd_credt_trnsfr_amt_couter() {
        return qtd_credt_trnsfr_amt_couter;
    }

    public void setQtd_credt_trnsfr_amt_couter(BigDecimal qtd_credt_trnsfr_amt_couter) {
        this.qtd_credt_trnsfr_amt_couter = qtd_credt_trnsfr_amt_couter;
    }

    public BigDecimal getQtd_credt_trnsfr_cnt_couter() {
        return qtd_credt_trnsfr_cnt_couter;
    }

    public void setQtd_credt_trnsfr_cnt_couter(BigDecimal qtd_credt_trnsfr_cnt_couter) {
        this.qtd_credt_trnsfr_cnt_couter = qtd_credt_trnsfr_cnt_couter;
    }

    public BigDecimal getQtd_debit_trnsfr_amt_couter() {
        return qtd_debit_trnsfr_amt_couter;
    }

    public void setQtd_debit_trnsfr_amt_couter(BigDecimal qtd_debit_trnsfr_amt_couter) {
        this.qtd_debit_trnsfr_amt_couter = qtd_debit_trnsfr_amt_couter;
    }

    public BigDecimal getQtd_debit_trnsfr_cnt_couter() {
        return qtd_debit_trnsfr_cnt_couter;
    }

    public void setQtd_debit_trnsfr_cnt_couter(BigDecimal qtd_debit_trnsfr_cnt_couter) {
        this.qtd_debit_trnsfr_cnt_couter = qtd_debit_trnsfr_cnt_couter;
    }

    public BigDecimal getQtd_credt_trnsfr_amt_online() {
        return qtd_credt_trnsfr_amt_online;
    }

    public void setQtd_credt_trnsfr_amt_online(BigDecimal qtd_credt_trnsfr_amt_online) {
        this.qtd_credt_trnsfr_amt_online = qtd_credt_trnsfr_amt_online;
    }

    public BigDecimal getQtd_credt_trnsfr_cnt_online() {
        return qtd_credt_trnsfr_cnt_online;
    }

    public void setQtd_credt_trnsfr_cnt_online(BigDecimal qtd_credt_trnsfr_cnt_online) {
        this.qtd_credt_trnsfr_cnt_online = qtd_credt_trnsfr_cnt_online;
    }

    public BigDecimal getQtd_debit_trnsfr_amt_online() {
        return qtd_debit_trnsfr_amt_online;
    }

    public void setQtd_debit_trnsfr_amt_online(BigDecimal qtd_debit_trnsfr_amt_online) {
        this.qtd_debit_trnsfr_amt_online = qtd_debit_trnsfr_amt_online;
    }

    public BigDecimal getQtd_debit_trnsfr_cnt_online() {
        return qtd_debit_trnsfr_cnt_online;
    }

    public void setQtd_debit_trnsfr_cnt_online(BigDecimal qtd_debit_trnsfr_cnt_online) {
        this.qtd_debit_trnsfr_cnt_online = qtd_debit_trnsfr_cnt_online;
    }

    public BigDecimal getQtd_credt_trnsfr_amt() {
        return qtd_credt_trnsfr_amt;
    }

    public void setQtd_credt_trnsfr_amt(BigDecimal qtd_credt_trnsfr_amt) {
        this.qtd_credt_trnsfr_amt = qtd_credt_trnsfr_amt;
    }

    public BigDecimal getQtd_credt_trnsfr_cnt() {
        return qtd_credt_trnsfr_cnt;
    }

    public void setQtd_credt_trnsfr_cnt(BigDecimal qtd_credt_trnsfr_cnt) {
        this.qtd_credt_trnsfr_cnt = qtd_credt_trnsfr_cnt;
    }

    public BigDecimal getQtd_debit_trnsfr_amt() {
        return qtd_debit_trnsfr_amt;
    }

    public void setQtd_debit_trnsfr_amt(BigDecimal qtd_debit_trnsfr_amt) {
        this.qtd_debit_trnsfr_amt = qtd_debit_trnsfr_amt;
    }

    public BigDecimal getQtd_debit_trnsfr_cnt() {
        return qtd_debit_trnsfr_cnt;
    }

    public void setQtd_debit_trnsfr_cnt(BigDecimal qtd_debit_trnsfr_cnt) {
        this.qtd_debit_trnsfr_cnt = qtd_debit_trnsfr_cnt;
    }

    public BigDecimal getQtd_outbank_debit_trnsfr_amt() {
        return qtd_outbank_debit_trnsfr_amt;
    }

    public void setQtd_outbank_debit_trnsfr_amt(BigDecimal qtd_outbank_debit_trnsfr_amt) {
        this.qtd_outbank_debit_trnsfr_amt = qtd_outbank_debit_trnsfr_amt;
    }

    public BigDecimal getQtd_outbank_debit_trnsfr_cnt() {
        return qtd_outbank_debit_trnsfr_cnt;
    }

    public void setQtd_outbank_debit_trnsfr_cnt(BigDecimal qtd_outbank_debit_trnsfr_cnt) {
        this.qtd_outbank_debit_trnsfr_cnt = qtd_outbank_debit_trnsfr_cnt;
    }

    public BigDecimal getQtd_outbank_credt_trnsfr_amt() {
        return qtd_outbank_credt_trnsfr_amt;
    }

    public void setQtd_outbank_credt_trnsfr_amt(BigDecimal qtd_outbank_credt_trnsfr_amt) {
        this.qtd_outbank_credt_trnsfr_amt = qtd_outbank_credt_trnsfr_amt;
    }

    public BigDecimal getQtd_outbank_credt_trnsfr_cnt() {
        return qtd_outbank_credt_trnsfr_cnt;
    }

    public void setQtd_outbank_credt_trnsfr_cnt(BigDecimal qtd_outbank_credt_trnsfr_cnt) {
        this.qtd_outbank_credt_trnsfr_cnt = qtd_outbank_credt_trnsfr_cnt;
    }

    public BigDecimal getQtd_bill_payment_amt() {
        return qtd_bill_payment_amt;
    }

    public void setQtd_bill_payment_amt(BigDecimal qtd_bill_payment_amt) {
        this.qtd_bill_payment_amt = qtd_bill_payment_amt;
    }

    public BigDecimal getQtd_bill_payment_cnt() {
        return qtd_bill_payment_cnt;
    }

    public void setQtd_bill_payment_cnt(BigDecimal qtd_bill_payment_cnt) {
        this.qtd_bill_payment_cnt = qtd_bill_payment_cnt;
    }

    public BigDecimal getQtd_saving_amt() {
        return qtd_saving_amt;
    }

    public void setQtd_saving_amt(BigDecimal qtd_saving_amt) {
        this.qtd_saving_amt = qtd_saving_amt;
    }

    public BigDecimal getQtd_saving_cnt() {
        return qtd_saving_cnt;
    }

    public void setQtd_saving_cnt(BigDecimal qtd_saving_cnt) {
        this.qtd_saving_cnt = qtd_saving_cnt;
    }

    public BigDecimal getQtd_loan_payment_amt() {
        return qtd_loan_payment_amt;
    }

    public void setQtd_loan_payment_amt(BigDecimal qtd_loan_payment_amt) {
        this.qtd_loan_payment_amt = qtd_loan_payment_amt;
    }

    public BigDecimal getQtd_loan_payment_cnt() {
        return qtd_loan_payment_cnt;
    }

    public void setQtd_loan_payment_cnt(BigDecimal qtd_loan_payment_cnt) {
        this.qtd_loan_payment_cnt = qtd_loan_payment_cnt;
    }

    public BigDecimal getQtd_credit_cash_amt() {
        return qtd_credit_cash_amt;
    }

    public void setQtd_credit_cash_amt(BigDecimal qtd_credit_cash_amt) {
        this.qtd_credit_cash_amt = qtd_credit_cash_amt;
    }

    public BigDecimal getQtd_credit_cash_cnt() {
        return qtd_credit_cash_cnt;
    }

    public void setQtd_credit_cash_cnt(BigDecimal qtd_credit_cash_cnt) {
        this.qtd_credit_cash_cnt = qtd_credit_cash_cnt;
    }

    public BigDecimal getQtd_debit_cash_amt() {
        return qtd_debit_cash_amt;
    }

    public void setQtd_debit_cash_amt(BigDecimal qtd_debit_cash_amt) {
        this.qtd_debit_cash_amt = qtd_debit_cash_amt;
    }

    public BigDecimal getQtd_debit_cash_cnt() {
        return qtd_debit_cash_cnt;
    }

    public void setQtd_debit_cash_cnt(BigDecimal qtd_debit_cash_cnt) {
        this.qtd_debit_cash_cnt = qtd_debit_cash_cnt;
    }

    public BigDecimal getQtd_debit_oversea_amt() {
        return qtd_debit_oversea_amt;
    }

    public void setQtd_debit_oversea_amt(BigDecimal qtd_debit_oversea_amt) {
        this.qtd_debit_oversea_amt = qtd_debit_oversea_amt;
    }

    public BigDecimal getQtd_credit_oversea_amt() {
        return qtd_credit_oversea_amt;
    }

    public void setQtd_credit_oversea_amt(BigDecimal qtd_credit_oversea_amt) {
        this.qtd_credit_oversea_amt = qtd_credit_oversea_amt;
    }

    public BigDecimal getQtd_debit_oversea_cnt() {
        return qtd_debit_oversea_cnt;
    }

    public void setQtd_debit_oversea_cnt(BigDecimal qtd_debit_oversea_cnt) {
        this.qtd_debit_oversea_cnt = qtd_debit_oversea_cnt;
    }

    public BigDecimal getQtd_credit_oversea_cnt() {
        return qtd_credit_oversea_cnt;
    }

    public void setQtd_credit_oversea_cnt(BigDecimal qtd_credit_oversea_cnt) {
        this.qtd_credit_oversea_cnt = qtd_credit_oversea_cnt;
    }

    public BigDecimal getYtd_credt_trnsfr_amt_couter() {
        return ytd_credt_trnsfr_amt_couter;
    }

    public void setYtd_credt_trnsfr_amt_couter(BigDecimal ytd_credt_trnsfr_amt_couter) {
        this.ytd_credt_trnsfr_amt_couter = ytd_credt_trnsfr_amt_couter;
    }

    public BigDecimal getYtd_credt_trnsfr_cnt_couter() {
        return ytd_credt_trnsfr_cnt_couter;
    }

    public void setYtd_credt_trnsfr_cnt_couter(BigDecimal ytd_credt_trnsfr_cnt_couter) {
        this.ytd_credt_trnsfr_cnt_couter = ytd_credt_trnsfr_cnt_couter;
    }

    public BigDecimal getYtd_debit_trnsfr_amt_couter() {
        return ytd_debit_trnsfr_amt_couter;
    }

    public void setYtd_debit_trnsfr_amt_couter(BigDecimal ytd_debit_trnsfr_amt_couter) {
        this.ytd_debit_trnsfr_amt_couter = ytd_debit_trnsfr_amt_couter;
    }

    public BigDecimal getYtd_debit_trnsfr_cnt_couter() {
        return ytd_debit_trnsfr_cnt_couter;
    }

    public void setYtd_debit_trnsfr_cnt_couter(BigDecimal ytd_debit_trnsfr_cnt_couter) {
        this.ytd_debit_trnsfr_cnt_couter = ytd_debit_trnsfr_cnt_couter;
    }

    public BigDecimal getYtd_credt_trnsfr_amt_online() {
        return ytd_credt_trnsfr_amt_online;
    }

    public void setYtd_credt_trnsfr_amt_online(BigDecimal ytd_credt_trnsfr_amt_online) {
        this.ytd_credt_trnsfr_amt_online = ytd_credt_trnsfr_amt_online;
    }

    public BigDecimal getYtd_credt_trnsfr_cnt_online() {
        return ytd_credt_trnsfr_cnt_online;
    }

    public void setYtd_credt_trnsfr_cnt_online(BigDecimal ytd_credt_trnsfr_cnt_online) {
        this.ytd_credt_trnsfr_cnt_online = ytd_credt_trnsfr_cnt_online;
    }

    public BigDecimal getYtd_debit_trnsfr_amt_online() {
        return ytd_debit_trnsfr_amt_online;
    }

    public void setYtd_debit_trnsfr_amt_online(BigDecimal ytd_debit_trnsfr_amt_online) {
        this.ytd_debit_trnsfr_amt_online = ytd_debit_trnsfr_amt_online;
    }

    public BigDecimal getYtd_debit_trnsfr_cnt_online() {
        return ytd_debit_trnsfr_cnt_online;
    }

    public void setYtd_debit_trnsfr_cnt_online(BigDecimal ytd_debit_trnsfr_cnt_online) {
        this.ytd_debit_trnsfr_cnt_online = ytd_debit_trnsfr_cnt_online;
    }

    public BigDecimal getYtd_credt_trnsfr_amt() {
        return ytd_credt_trnsfr_amt;
    }

    public void setYtd_credt_trnsfr_amt(BigDecimal ytd_credt_trnsfr_amt) {
        this.ytd_credt_trnsfr_amt = ytd_credt_trnsfr_amt;
    }

    public BigDecimal getYtd_credt_trnsfr_cnt() {
        return ytd_credt_trnsfr_cnt;
    }

    public void setYtd_credt_trnsfr_cnt(BigDecimal ytd_credt_trnsfr_cnt) {
        this.ytd_credt_trnsfr_cnt = ytd_credt_trnsfr_cnt;
    }

    public BigDecimal getYtd_debit_trnsfr_amt() {
        return ytd_debit_trnsfr_amt;
    }

    public void setYtd_debit_trnsfr_amt(BigDecimal ytd_debit_trnsfr_amt) {
        this.ytd_debit_trnsfr_amt = ytd_debit_trnsfr_amt;
    }

    public BigDecimal getYtd_debit_trnsfr_cnt() {
        return ytd_debit_trnsfr_cnt;
    }

    public void setYtd_debit_trnsfr_cnt(BigDecimal ytd_debit_trnsfr_cnt) {
        this.ytd_debit_trnsfr_cnt = ytd_debit_trnsfr_cnt;
    }

    public BigDecimal getYtd_outbank_debit_trnsfr_amt() {
        return ytd_outbank_debit_trnsfr_amt;
    }

    public void setYtd_outbank_debit_trnsfr_amt(BigDecimal ytd_outbank_debit_trnsfr_amt) {
        this.ytd_outbank_debit_trnsfr_amt = ytd_outbank_debit_trnsfr_amt;
    }

    public BigDecimal getYtd_outbank_debit_trnsfr_cnt() {
        return ytd_outbank_debit_trnsfr_cnt;
    }

    public void setYtd_outbank_debit_trnsfr_cnt(BigDecimal ytd_outbank_debit_trnsfr_cnt) {
        this.ytd_outbank_debit_trnsfr_cnt = ytd_outbank_debit_trnsfr_cnt;
    }

    public BigDecimal getYtd_outbank_credt_trnsfr_amt() {
        return ytd_outbank_credt_trnsfr_amt;
    }

    public void setYtd_outbank_credt_trnsfr_amt(BigDecimal ytd_outbank_credt_trnsfr_amt) {
        this.ytd_outbank_credt_trnsfr_amt = ytd_outbank_credt_trnsfr_amt;
    }

    public BigDecimal getYtd_outbank_credt_trnsfr_cnt() {
        return ytd_outbank_credt_trnsfr_cnt;
    }

    public void setYtd_outbank_credt_trnsfr_cnt(BigDecimal ytd_outbank_credt_trnsfr_cnt) {
        this.ytd_outbank_credt_trnsfr_cnt = ytd_outbank_credt_trnsfr_cnt;
    }

    public BigDecimal getYtd_bill_payment_amt() {
        return ytd_bill_payment_amt;
    }

    public void setYtd_bill_payment_amt(BigDecimal ytd_bill_payment_amt) {
        this.ytd_bill_payment_amt = ytd_bill_payment_amt;
    }

    public BigDecimal getYtd_bill_payment_cnt() {
        return ytd_bill_payment_cnt;
    }

    public void setYtd_bill_payment_cnt(BigDecimal ytd_bill_payment_cnt) {
        this.ytd_bill_payment_cnt = ytd_bill_payment_cnt;
    }

    public BigDecimal getYtd_saving_amt() {
        return ytd_saving_amt;
    }

    public void setYtd_saving_amt(BigDecimal ytd_saving_amt) {
        this.ytd_saving_amt = ytd_saving_amt;
    }

    public BigDecimal getYtd_saving_cnt() {
        return ytd_saving_cnt;
    }

    public void setYtd_saving_cnt(BigDecimal ytd_saving_cnt) {
        this.ytd_saving_cnt = ytd_saving_cnt;
    }

    public BigDecimal getYtd_loan_payment_amt() {
        return ytd_loan_payment_amt;
    }

    public void setYtd_loan_payment_amt(BigDecimal ytd_loan_payment_amt) {
        this.ytd_loan_payment_amt = ytd_loan_payment_amt;
    }

    public BigDecimal getYtd_loan_payment_cnt() {
        return ytd_loan_payment_cnt;
    }

    public void setYtd_loan_payment_cnt(BigDecimal ytd_loan_payment_cnt) {
        this.ytd_loan_payment_cnt = ytd_loan_payment_cnt;
    }

    public BigDecimal getYtd_credit_cash_amt() {
        return ytd_credit_cash_amt;
    }

    public void setYtd_credit_cash_amt(BigDecimal ytd_credit_cash_amt) {
        this.ytd_credit_cash_amt = ytd_credit_cash_amt;
    }

    public BigDecimal getYtd_credit_cash_cnt() {
        return ytd_credit_cash_cnt;
    }

    public void setYtd_credit_cash_cnt(BigDecimal ytd_credit_cash_cnt) {
        this.ytd_credit_cash_cnt = ytd_credit_cash_cnt;
    }

    public BigDecimal getYtd_debit_cash_amt() {
        return ytd_debit_cash_amt;
    }

    public void setYtd_debit_cash_amt(BigDecimal ytd_debit_cash_amt) {
        this.ytd_debit_cash_amt = ytd_debit_cash_amt;
    }

    public BigDecimal getYtd_debit_cash_cnt() {
        return ytd_debit_cash_cnt;
    }

    public void setYtd_debit_cash_cnt(BigDecimal ytd_debit_cash_cnt) {
        this.ytd_debit_cash_cnt = ytd_debit_cash_cnt;
    }

    public BigDecimal getYtd_debit_oversea_amt() {
        return ytd_debit_oversea_amt;
    }

    public void setYtd_debit_oversea_amt(BigDecimal ytd_debit_oversea_amt) {
        this.ytd_debit_oversea_amt = ytd_debit_oversea_amt;
    }

    public BigDecimal getYtd_credit_oversea_amt() {
        return ytd_credit_oversea_amt;
    }

    public void setYtd_credit_oversea_amt(BigDecimal ytd_credit_oversea_amt) {
        this.ytd_credit_oversea_amt = ytd_credit_oversea_amt;
    }

    public BigDecimal getYtd_debit_oversea_cnt() {
        return ytd_debit_oversea_cnt;
    }

    public void setYtd_debit_oversea_cnt(BigDecimal ytd_debit_oversea_cnt) {
        this.ytd_debit_oversea_cnt = ytd_debit_oversea_cnt;
    }

    public BigDecimal getYtd_credit_oversea_cnt() {
        return ytd_credit_oversea_cnt;
    }

    public void setYtd_credit_oversea_cnt(BigDecimal ytd_credit_oversea_cnt) {
        this.ytd_credit_oversea_cnt = ytd_credit_oversea_cnt;
    }

    public BigDecimal getYtd_dda_rlse_amt() {
        return ytd_dda_rlse_amt;
    }

    public void setYtd_dda_rlse_amt(BigDecimal ytd_dda_rlse_amt) {
        this.ytd_dda_rlse_amt = ytd_dda_rlse_amt;
    }

    public BigDecimal getYtd_rlse_amt() {
        return ytd_rlse_amt;
    }

    public void setYtd_rlse_amt(BigDecimal ytd_rlse_amt) {
        this.ytd_rlse_amt = ytd_rlse_amt;
    }

    public BigDecimal getYtd_rlse_shrtrm_amt() {
        return ytd_rlse_shrtrm_amt;
    }

    public void setYtd_rlse_shrtrm_amt(BigDecimal ytd_rlse_shrtrm_amt) {
        this.ytd_rlse_shrtrm_amt = ytd_rlse_shrtrm_amt;
    }

    public BigDecimal getYtd_rlse_lngtrm_amt() {
        return ytd_rlse_lngtrm_amt;
    }

    public void setYtd_rlse_lngtrm_amt(BigDecimal ytd_rlse_lngtrm_amt) {
        this.ytd_rlse_lngtrm_amt = ytd_rlse_lngtrm_amt;
    }

    public String getCob_dt() {
        return cob_dt;
    }

    public void setCob_dt(String cob_dt) {
        this.cob_dt = cob_dt;
    }

	public BigDecimal getYtd_dda_rlse_amt_ratio() {
		return ytd_dda_rlse_amt_ratio;
	}

	public void setYtd_dda_rlse_amt_ratio(BigDecimal ytd_dda_rlse_amt_ratio) {
		this.ytd_dda_rlse_amt_ratio = ytd_dda_rlse_amt_ratio;
	}

	public BigDecimal getYtd_credit_trnsfr_amt_ratio() {
		return ytd_credit_trnsfr_amt_ratio;
	}

	public void setYtd_credit_trnsfr_amt_ratio(BigDecimal ytd_credit_trnsfr_amt_ratio) {
		this.ytd_credit_trnsfr_amt_ratio = ytd_credit_trnsfr_amt_ratio;
	}

	public BigDecimal getYtd_outbank_trns_fr_ratio() {
		return ytd_outbank_trns_fr_ratio;
	}

	public void setYtd_outbank_trns_fr_ratio(BigDecimal ytd_outbank_trns_fr_ratio) {
		this.ytd_outbank_trns_fr_ratio = ytd_outbank_trns_fr_ratio;
	}

	public BigDecimal getYtd_credit_cash_instore_amt() {
		return ytd_credit_cash_instore_amt;
	}

	public void setYtd_credit_cash_instore_amt(BigDecimal ytd_credit_cash_instore_amt) {
		this.ytd_credit_cash_instore_amt = ytd_credit_cash_instore_amt;
	}
	
    
}