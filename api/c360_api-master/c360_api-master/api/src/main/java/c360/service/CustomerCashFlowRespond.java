package c360.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import c360.model.*;
import c360.database.*;
import c360.service.*;
public class CustomerCashFlowRespond {
    public static ArrayList<CustomerCashFlow> getRespond(InputRequestCorporate request) {
        ArrayList<CustomerCashFlow> customercashflows = new ArrayList<>();
        String sql = "select acn ,\n" +
                " -- branch,\n" +
                "sum(mtd_credt_trnsfr_amt_couter) as mtd_credt_trnsfr_amt_couter,\n" +
                "sum(mtd_credt_trnsfr_cnt_couter) as mtd_credt_trnsfr_cnt_couter,\n" +
                "sum(mtd_debit_trnsfr_amt_couter) as mtd_debit_trnsfr_amt_couter,\n" +
                "sum(mtd_debit_trnsfr_cnt_couter) as mtd_debit_trnsfr_cnt_couter,\n" +
                "sum(mtd_credt_trnsfr_amt_online) as mtd_credt_trnsfr_amt_online,\n" +
                "sum(mtd_credt_trnsfr_cnt_online) as mtd_credt_trnsfr_cnt_online,\n" +
                "sum(mtd_debit_trnsfr_amt_online) as mtd_debit_trnsfr_amt_online,\n" +
                "sum(mtd_debit_trnsfr_cnt_online) as mtd_debit_trnsfr_cnt_online,\n" +
                "sum(mtd_credt_trnsfr_amt) as mtd_credt_trnsfr_amt,\n" +
                "sum(mtd_credt_trnsfr_cnt) as mtd_credt_trnsfr_cnt,\n" +
                "sum(mtd_debit_trnsfr_amt) as mtd_debit_trnsfr_amt,\n" +
                "sum(mtd_debit_trnsfr_cnt) as mtd_debit_trnsfr_cnt,\n" +
                "sum(mtd_outbank_debit_trnsfr_amt) as mtd_outbank_debit_trnsfr_amt,\n" +
                "sum(mtd_outbank_debit_trnsfr_cnt) as mtd_outbank_debit_trnsfr_cnt,\n" +
                "sum(mtd_outbank_credt_trnsfr_amt) as mtd_outbank_credt_trnsfr_amt,\n" +
                "sum(mtd_outbank_credt_trnsfr_cnt) as mtd_outbank_credt_trnsfr_cnt,\n" +
                "sum(mtd_bill_payment_amt) as mtd_bill_payment_amt,\n" +
                "sum(mtd_bill_payment_cnt) as mtd_bill_payment_cnt,\n" +
                "sum(mtd_saving_amt) as mtd_saving_amt,\n" +
                "sum(mtd_saving_cnt) as mtd_saving_cnt,\n" +
                "sum(mtd_loan_payment_amt) as mtd_loan_payment_amt,\n" +
                "sum(mtd_loan_payment_cnt) as mtd_loan_payment_cnt,\n" +
                "sum(mtd_credit_cash_amt) as mtd_credit_cash_amt,\n" +
                "sum(mtd_credit_cash_cnt) as mtd_credit_cash_cnt,\n" +
                "sum(mtd_debit_cash_amt) as mtd_debit_cash_amt,\n" +
                "sum(mtd_debit_cash_cnt) as mtd_debit_cash_cnt,\n" +
                "sum(mtd_debit_oversea_amt) as mtd_debit_oversea_amt,\n" +
                "sum(mtd_credit_oversea_amt) as mtd_credit_oversea_amt,\n" +
                "sum(mtd_debit_oversea_cnt) as mtd_debit_oversea_cnt,\n" +
                "sum(mtd_credit_oversea_cnt) as mtd_credit_oversea_cnt,\n" +
                "sum(qtd_credt_trnsfr_amt_couter) as qtd_credt_trnsfr_amt_couter,\n" +
                "sum(qtd_credt_trnsfr_cnt_couter) as qtd_credt_trnsfr_cnt_couter,\n" +
                "sum(qtd_debit_trnsfr_amt_couter) as qtd_debit_trnsfr_amt_couter,\n" +
                "sum(qtd_debit_trnsfr_cnt_couter) as qtd_debit_trnsfr_cnt_couter,\n" +
                "sum(qtd_credt_trnsfr_amt_online) as qtd_credt_trnsfr_amt_online,\n" +
                "sum(qtd_credt_trnsfr_cnt_online) as qtd_credt_trnsfr_cnt_online,\n" +
                "sum(qtd_debit_trnsfr_amt_online) as qtd_debit_trnsfr_amt_online,\n" +
                "sum(qtd_debit_trnsfr_cnt_online) as qtd_debit_trnsfr_cnt_online,\n" +
                "sum(qtd_credt_trnsfr_amt) as qtd_credt_trnsfr_amt,\n" +
                "sum(qtd_credt_trnsfr_cnt) as qtd_credt_trnsfr_cnt,\n" +
                "sum(qtd_debit_trnsfr_amt) as qtd_debit_trnsfr_amt,\n" +
                "sum(qtd_debit_trnsfr_cnt) as qtd_debit_trnsfr_cnt,\n" +
                "sum(qtd_outbank_debit_trnsfr_amt) as qtd_outbank_debit_trnsfr_amt,\n" +
                "sum(qtd_outbank_debit_trnsfr_cnt) as qtd_outbank_debit_trnsfr_cnt,\n" +
                "sum(qtd_outbank_credt_trnsfr_amt) as qtd_outbank_credt_trnsfr_amt,\n" +
                "sum(qtd_outbank_credt_trnsfr_cnt) as qtd_outbank_credt_trnsfr_cnt,\n" +
                "sum(qtd_bill_payment_amt) as qtd_bill_payment_amt,\n" +
                "sum(qtd_bill_payment_cnt) as qtd_bill_payment_cnt,\n" +
                "sum(qtd_saving_amt) as qtd_saving_amt,\n" +
                "sum(qtd_saving_cnt) as qtd_saving_cnt,\n" +
                "sum(qtd_loan_payment_amt) as qtd_loan_payment_amt,\n" +
                "sum(qtd_loan_payment_cnt) as qtd_loan_payment_cnt,\n" +
                "sum(qtd_credit_cash_amt) as qtd_credit_cash_amt,\n" +
                "sum(qtd_credit_cash_cnt) as qtd_credit_cash_cnt,\n" +
                "sum(qtd_debit_cash_amt) as qtd_debit_cash_amt,\n" +
                "sum(qtd_debit_cash_cnt) as qtd_debit_cash_cnt,\n" +
                "sum(qtd_debit_oversea_amt) as qtd_debit_oversea_amt,\n" +
                "sum(qtd_credit_oversea_amt) as qtd_credit_oversea_amt,\n" +
                "sum(qtd_debit_oversea_cnt) as qtd_debit_oversea_cnt,\n" +
                "sum(qtd_credit_oversea_cnt) as qtd_credit_oversea_cnt,\n" +
                "sum(ytd_credt_trnsfr_amt_couter) as ytd_credt_trnsfr_amt_couter,\n" +
                "sum(ytd_credt_trnsfr_cnt_couter) as ytd_credt_trnsfr_cnt_couter,\n" +
                "sum(ytd_debit_trnsfr_amt_couter) as ytd_debit_trnsfr_amt_couter,\n" +
                "sum(ytd_debit_trnsfr_cnt_couter) as ytd_debit_trnsfr_cnt_couter,\n" +
                "sum(ytd_credt_trnsfr_amt_online) as ytd_credt_trnsfr_amt_online,\n" +
                "sum(ytd_credt_trnsfr_cnt_online) as ytd_credt_trnsfr_cnt_online,\n" +
                "sum(ytd_debit_trnsfr_amt_online) as ytd_debit_trnsfr_amt_online,\n" +
                "sum(ytd_debit_trnsfr_cnt_online) as ytd_debit_trnsfr_cnt_online,\n" +
                "sum(ytd_credt_trnsfr_amt) as ytd_credt_trnsfr_amt,\n" +
                "sum(ytd_credt_trnsfr_cnt) as ytd_credt_trnsfr_cnt,\n" +
                "sum(ytd_debit_trnsfr_amt) as ytd_debit_trnsfr_amt,\n" +
                "sum(ytd_debit_trnsfr_cnt) as ytd_debit_trnsfr_cnt,\n" +
                "sum(ytd_outbank_debit_trnsfr_amt) as ytd_outbank_debit_trnsfr_amt,\n" +
                "sum(ytd_outbank_debit_trnsfr_cnt) as ytd_outbank_debit_trnsfr_cnt,\n" +
                "sum(ytd_outbank_credt_trnsfr_amt) as ytd_outbank_credt_trnsfr_amt,\n" +
                "sum(ytd_outbank_credt_trnsfr_cnt) as ytd_outbank_credt_trnsfr_cnt,\n" +
                "sum(ytd_bill_payment_amt) as ytd_bill_payment_amt,\n" +
                "sum(ytd_bill_payment_cnt) as ytd_bill_payment_cnt,\n" +
                "sum(ytd_saving_amt) as ytd_saving_amt,\n" +
                "sum(ytd_saving_cnt) as ytd_saving_cnt,\n" +
                "sum(ytd_loan_payment_amt) as ytd_loan_payment_amt,\n" +
                "sum(ytd_loan_payment_cnt) as ytd_loan_payment_cnt,\n" +
                "sum(ytd_credit_cash_amt) as ytd_credit_cash_amt,\n" +
                "sum(ytd_credit_cash_cnt) as ytd_credit_cash_cnt,\n" +
                "sum(ytd_debit_cash_amt) as ytd_debit_cash_amt,\n" +
                "sum(ytd_debit_cash_cnt) as ytd_debit_cash_cnt,\n" +
                "sum(ytd_debit_oversea_amt) as ytd_debit_oversea_amt,\n" +
                "sum(ytd_credit_oversea_amt) as ytd_credit_oversea_amt,\n" +
                "sum(ytd_debit_oversea_cnt) as ytd_debit_oversea_cnt,\n" +
                "sum(ytd_credit_oversea_cnt) as ytd_credit_oversea_cnt,\n" +
                "sum(ytd_dda_rlse_amt) as ytd_dda_rlse_amt,\n" +
                "sum(ytd_rlse_amt) as ytd_rlse_amt,\n" +
                "sum(ytd_rlse_shrtrm_amt) as ytd_rlse_shrtrm_amt,\n" +
                "sum(ytd_rlse_lngtrm_amt) as ytd_rlse_lngtrm_amt,\n" +
                "sum(ytd_credit_cash_instore_amt) as ytd_credit_cash_instore_amt,\n" +
                "sum(ytd_dda_rlse_amt) / sum(ytd_rlse_amt) as ytd_dda_rlse_amt_ratio,\n" +
                "sum(ytd_credt_trnsfr_amt) / sum(ytd_rlse_amt) as ytd_credit_trnsfr_amt_ratio,\n" +
                "sum(ytd_outbank_debit_trnsfr_amt)/sum(ytd_credt_trnsfr_amt) as ytd_outbank_trns_fr_ratio," +
                "cob_dt\n" +
                " from customer360.c360_cashflow_summary %s";
        String sqlBranch = "select acn ,\n" +
                "  branch,\n" +
                "sum(mtd_credt_trnsfr_amt_couter) as mtd_credt_trnsfr_amt_couter,\n" +
                "sum(mtd_credt_trnsfr_cnt_couter) as mtd_credt_trnsfr_cnt_couter,\n" +
                "sum(mtd_debit_trnsfr_amt_couter) as mtd_debit_trnsfr_amt_couter,\n" +
                "sum(mtd_debit_trnsfr_cnt_couter) as mtd_debit_trnsfr_cnt_couter,\n" +
                "sum(mtd_credt_trnsfr_amt_online) as mtd_credt_trnsfr_amt_online,\n" +
                "sum(mtd_credt_trnsfr_cnt_online) as mtd_credt_trnsfr_cnt_online,\n" +
                "sum(mtd_debit_trnsfr_amt_online) as mtd_debit_trnsfr_amt_online,\n" +
                "sum(mtd_debit_trnsfr_cnt_online) as mtd_debit_trnsfr_cnt_online,\n" +
                "sum(mtd_credt_trnsfr_amt) as mtd_credt_trnsfr_amt,\n" +
                "sum(mtd_credt_trnsfr_cnt) as mtd_credt_trnsfr_cnt,\n" +
                "sum(mtd_debit_trnsfr_amt) as mtd_debit_trnsfr_amt,\n" +
                "sum(mtd_debit_trnsfr_cnt) as mtd_debit_trnsfr_cnt,\n" +
                "sum(mtd_outbank_debit_trnsfr_amt) as mtd_outbank_debit_trnsfr_amt,\n" +
                "sum(mtd_outbank_debit_trnsfr_cnt) as mtd_outbank_debit_trnsfr_cnt,\n" +
                "sum(mtd_outbank_credt_trnsfr_amt) as mtd_outbank_credt_trnsfr_amt,\n" +
                "sum(mtd_outbank_credt_trnsfr_cnt) as mtd_outbank_credt_trnsfr_cnt,\n" +
                "sum(mtd_bill_payment_amt) as mtd_bill_payment_amt,\n" +
                "sum(mtd_bill_payment_cnt) as mtd_bill_payment_cnt,\n" +
                "sum(mtd_saving_amt) as mtd_saving_amt,\n" +
                "sum(mtd_saving_cnt) as mtd_saving_cnt,\n" +
                "sum(mtd_loan_payment_amt) as mtd_loan_payment_amt,\n" +
                "sum(mtd_loan_payment_cnt) as mtd_loan_payment_cnt,\n" +
                "sum(mtd_credit_cash_amt) as mtd_credit_cash_amt,\n" +
                "sum(mtd_credit_cash_cnt) as mtd_credit_cash_cnt,\n" +
                "sum(mtd_debit_cash_amt) as mtd_debit_cash_amt,\n" +
                "sum(mtd_debit_cash_cnt) as mtd_debit_cash_cnt,\n" +
                "sum(mtd_debit_oversea_amt) as mtd_debit_oversea_amt,\n" +
                "sum(mtd_credit_oversea_amt) as mtd_credit_oversea_amt,\n" +
                "sum(mtd_debit_oversea_cnt) as mtd_debit_oversea_cnt,\n" +
                "sum(mtd_credit_oversea_cnt) as mtd_credit_oversea_cnt,\n" +
                "sum(qtd_credt_trnsfr_amt_couter) as qtd_credt_trnsfr_amt_couter,\n" +
                "sum(qtd_credt_trnsfr_cnt_couter) as qtd_credt_trnsfr_cnt_couter,\n" +
                "sum(qtd_debit_trnsfr_amt_couter) as qtd_debit_trnsfr_amt_couter,\n" +
                "sum(qtd_debit_trnsfr_cnt_couter) as qtd_debit_trnsfr_cnt_couter,\n" +
                "sum(qtd_credt_trnsfr_amt_online) as qtd_credt_trnsfr_amt_online,\n" +
                "sum(qtd_credt_trnsfr_cnt_online) as qtd_credt_trnsfr_cnt_online,\n" +
                "sum(qtd_debit_trnsfr_amt_online) as qtd_debit_trnsfr_amt_online,\n" +
                "sum(qtd_debit_trnsfr_cnt_online) as qtd_debit_trnsfr_cnt_online,\n" +
                "sum(qtd_credt_trnsfr_amt) as qtd_credt_trnsfr_amt,\n" +
                "sum(qtd_credt_trnsfr_cnt) as qtd_credt_trnsfr_cnt,\n" +
                "sum(qtd_debit_trnsfr_amt) as qtd_debit_trnsfr_amt,\n" +
                "sum(qtd_debit_trnsfr_cnt) as qtd_debit_trnsfr_cnt,\n" +
                "sum(qtd_outbank_debit_trnsfr_amt) as qtd_outbank_debit_trnsfr_amt,\n" +
                "sum(qtd_outbank_debit_trnsfr_cnt) as qtd_outbank_debit_trnsfr_cnt,\n" +
                "sum(qtd_outbank_credt_trnsfr_amt) as qtd_outbank_credt_trnsfr_amt,\n" +
                "sum(qtd_outbank_credt_trnsfr_cnt) as qtd_outbank_credt_trnsfr_cnt,\n" +
                "sum(qtd_bill_payment_amt) as qtd_bill_payment_amt,\n" +
                "sum(qtd_bill_payment_cnt) as qtd_bill_payment_cnt,\n" +
                "sum(qtd_saving_amt) as qtd_saving_amt,\n" +
                "sum(qtd_saving_cnt) as qtd_saving_cnt,\n" +
                "sum(qtd_loan_payment_amt) as qtd_loan_payment_amt,\n" +
                "sum(qtd_loan_payment_cnt) as qtd_loan_payment_cnt,\n" +
                "sum(qtd_credit_cash_amt) as qtd_credit_cash_amt,\n" +
                "sum(qtd_credit_cash_cnt) as qtd_credit_cash_cnt,\n" +
                "sum(qtd_debit_cash_amt) as qtd_debit_cash_amt,\n" +
                "sum(qtd_debit_cash_cnt) as qtd_debit_cash_cnt,\n" +
                "sum(qtd_debit_oversea_amt) as qtd_debit_oversea_amt,\n" +
                "sum(qtd_credit_oversea_amt) as qtd_credit_oversea_amt,\n" +
                "sum(qtd_debit_oversea_cnt) as qtd_debit_oversea_cnt,\n" +
                "sum(qtd_credit_oversea_cnt) as qtd_credit_oversea_cnt,\n" +
                "sum(ytd_credt_trnsfr_amt_couter) as ytd_credt_trnsfr_amt_couter,\n" +
                "sum(ytd_credt_trnsfr_cnt_couter) as ytd_credt_trnsfr_cnt_couter,\n" +
                "sum(ytd_debit_trnsfr_amt_couter) as ytd_debit_trnsfr_amt_couter,\n" +
                "sum(ytd_debit_trnsfr_cnt_couter) as ytd_debit_trnsfr_cnt_couter,\n" +
                "sum(ytd_credt_trnsfr_amt_online) as ytd_credt_trnsfr_amt_online,\n" +
                "sum(ytd_credt_trnsfr_cnt_online) as ytd_credt_trnsfr_cnt_online,\n" +
                "sum(ytd_debit_trnsfr_amt_online) as ytd_debit_trnsfr_amt_online,\n" +
                "sum(ytd_debit_trnsfr_cnt_online) as ytd_debit_trnsfr_cnt_online,\n" +
                "sum(ytd_credt_trnsfr_amt) as ytd_credt_trnsfr_amt,\n" +
                "sum(ytd_credt_trnsfr_cnt) as ytd_credt_trnsfr_cnt,\n" +
                "sum(ytd_debit_trnsfr_amt) as ytd_debit_trnsfr_amt,\n" +
                "sum(ytd_debit_trnsfr_cnt) as ytd_debit_trnsfr_cnt,\n" +
                "sum(ytd_outbank_debit_trnsfr_amt) as ytd_outbank_debit_trnsfr_amt,\n" +
                "sum(ytd_outbank_debit_trnsfr_cnt) as ytd_outbank_debit_trnsfr_cnt,\n" +
                "sum(ytd_outbank_credt_trnsfr_amt) as ytd_outbank_credt_trnsfr_amt,\n" +
                "sum(ytd_outbank_credt_trnsfr_cnt) as ytd_outbank_credt_trnsfr_cnt,\n" +
                "sum(ytd_bill_payment_amt) as ytd_bill_payment_amt,\n" +
                "sum(ytd_bill_payment_cnt) as ytd_bill_payment_cnt,\n" +
                "sum(ytd_saving_amt) as ytd_saving_amt,\n" +
                "sum(ytd_saving_cnt) as ytd_saving_cnt,\n" +
                "sum(ytd_loan_payment_amt) as ytd_loan_payment_amt,\n" +
                "sum(ytd_loan_payment_cnt) as ytd_loan_payment_cnt,\n" +
                "sum(ytd_credit_cash_amt) as ytd_credit_cash_amt,\n" +
                "sum(ytd_credit_cash_cnt) as ytd_credit_cash_cnt,\n" +
                "sum(ytd_debit_cash_amt) as ytd_debit_cash_amt,\n" +
                "sum(ytd_debit_cash_cnt) as ytd_debit_cash_cnt,\n" +
                "sum(ytd_debit_oversea_amt) as ytd_debit_oversea_amt,\n" +
                "sum(ytd_credit_oversea_amt) as ytd_credit_oversea_amt,\n" +
                "sum(ytd_debit_oversea_cnt) as ytd_debit_oversea_cnt,\n" +
                "sum(ytd_credit_oversea_cnt) as ytd_credit_oversea_cnt,\n" +
                "sum(ytd_dda_rlse_amt) as ytd_dda_rlse_amt,\n" +
                "sum(ytd_rlse_amt) as ytd_rlse_amt,\n" +
                "sum(ytd_rlse_shrtrm_amt) as ytd_rlse_shrtrm_amt,\n" +
                "sum(ytd_rlse_lngtrm_amt) as ytd_rlse_lngtrm_amt,\n" +
                "sum(ytd_credit_cash_instore_amt) as ytd_credit_cash_instore_amt,\n" +
                "sum(ytd_dda_rlse_amt) / sum(ytd_rlse_amt) as ytd_dda_rlse_amt_ratio,\n" +
                "sum(ytd_credt_trnsfr_amt) / sum(ytd_rlse_amt) as ytd_credit_trnsfr_amt_ratio,\n" +
                "sum(ytd_outbank_debit_trnsfr_amt)  / sum(ytd_credt_trnsfr_amt) as ytd_outbank_trns_fr_ratio," +
                "cob_dt\n" +
                " from customer360.c360_cashflow_summary %s";
        String cifName = "acn";
        try {
            JdbcUtil jdbc = new JdbcUtil();
            SqlQuery sqlObj = new SqlQuery(request, sql, sqlBranch, "c360_cashflow_summary");
            Connection c = jdbc.getConnection();
            boolean hasGroupBy = true;
            PreparedStatement stm = sqlObj.SQLPrepareFinal(cifName, c, hasGroupBy);
            ResultSet rc = stm.executeQuery();
            while (rc.next()) {
                String acn = rc.getString("acn");
                BigDecimal mtd_credt_trnsfr_amt_couter = rc.getBigDecimal("mtd_credt_trnsfr_amt_couter");
                BigDecimal mtd_credt_trnsfr_cnt_couter = rc.getBigDecimal("mtd_credt_trnsfr_cnt_couter");
                BigDecimal mtd_debit_trnsfr_amt_couter = rc.getBigDecimal("mtd_debit_trnsfr_amt_couter");
                BigDecimal mtd_debit_trnsfr_cnt_couter = rc.getBigDecimal("mtd_debit_trnsfr_cnt_couter");
                BigDecimal mtd_credt_trnsfr_amt_online = rc.getBigDecimal("mtd_credt_trnsfr_amt_online");
                BigDecimal mtd_credt_trnsfr_cnt_online = rc.getBigDecimal("mtd_credt_trnsfr_cnt_online");
                BigDecimal mtd_debit_trnsfr_amt_online = rc.getBigDecimal("mtd_debit_trnsfr_amt_online");
                BigDecimal mtd_debit_trnsfr_cnt_online = rc.getBigDecimal("mtd_debit_trnsfr_cnt_online");
                BigDecimal mtd_credt_trnsfr_amt = rc.getBigDecimal("mtd_credt_trnsfr_amt");
                BigDecimal mtd_credt_trnsfr_cnt = rc.getBigDecimal("mtd_credt_trnsfr_cnt");
                BigDecimal mtd_debit_trnsfr_amt = rc.getBigDecimal("mtd_debit_trnsfr_amt");
                BigDecimal mtd_debit_trnsfr_cnt = rc.getBigDecimal("mtd_debit_trnsfr_cnt");
                BigDecimal mtd_outbank_debit_trnsfr_amt = rc.getBigDecimal("mtd_outbank_debit_trnsfr_amt");
                BigDecimal mtd_outbank_debit_trnsfr_cnt = rc.getBigDecimal("mtd_outbank_debit_trnsfr_cnt");
                BigDecimal mtd_outbank_credt_trnsfr_amt = rc.getBigDecimal("mtd_outbank_credt_trnsfr_amt");
                BigDecimal mtd_outbank_credt_trnsfr_cnt = rc.getBigDecimal("mtd_outbank_credt_trnsfr_cnt");
                BigDecimal mtd_bill_payment_amt = rc.getBigDecimal("mtd_bill_payment_amt");
                BigDecimal mtd_bill_payment_cnt = rc.getBigDecimal("mtd_bill_payment_cnt");
                BigDecimal mtd_saving_amt = rc.getBigDecimal("mtd_saving_amt");
                BigDecimal mtd_saving_cnt = rc.getBigDecimal("mtd_saving_cnt");
                BigDecimal mtd_loan_payment_amt = rc.getBigDecimal("mtd_loan_payment_amt");
                BigDecimal mtd_loan_payment_cnt = rc.getBigDecimal("mtd_loan_payment_cnt");
                BigDecimal mtd_credit_cash_amt = rc.getBigDecimal("mtd_credit_cash_amt");
                BigDecimal mtd_credit_cash_cnt = rc.getBigDecimal("mtd_credit_cash_cnt");
                BigDecimal mtd_debit_cash_amt = rc.getBigDecimal("mtd_debit_cash_amt");
                BigDecimal mtd_debit_cash_cnt = rc.getBigDecimal("mtd_debit_cash_cnt");
                BigDecimal mtd_debit_oversea_amt = rc.getBigDecimal("mtd_debit_oversea_amt");
                BigDecimal mtd_credit_oversea_amt = rc.getBigDecimal("mtd_credit_oversea_amt");
                BigDecimal mtd_debit_oversea_cnt = rc.getBigDecimal("mtd_debit_oversea_cnt");
                BigDecimal mtd_credit_oversea_cnt = rc.getBigDecimal("mtd_credit_oversea_cnt");
                BigDecimal qtd_credt_trnsfr_amt_couter = rc.getBigDecimal("qtd_credt_trnsfr_amt_couter");
                BigDecimal qtd_credt_trnsfr_cnt_couter = rc.getBigDecimal("qtd_credt_trnsfr_cnt_couter");
                BigDecimal qtd_debit_trnsfr_amt_couter = rc.getBigDecimal("qtd_debit_trnsfr_amt_couter");
                BigDecimal qtd_debit_trnsfr_cnt_couter = rc.getBigDecimal("qtd_debit_trnsfr_cnt_couter");
                BigDecimal qtd_credt_trnsfr_amt_online = rc.getBigDecimal("qtd_credt_trnsfr_amt_online");
                BigDecimal qtd_credt_trnsfr_cnt_online = rc.getBigDecimal("qtd_credt_trnsfr_cnt_online");
                BigDecimal qtd_debit_trnsfr_amt_online = rc.getBigDecimal("qtd_debit_trnsfr_amt_online");
                BigDecimal qtd_debit_trnsfr_cnt_online = rc.getBigDecimal("qtd_debit_trnsfr_cnt_online");
                BigDecimal qtd_credt_trnsfr_amt = rc.getBigDecimal("qtd_credt_trnsfr_amt");
                BigDecimal qtd_credt_trnsfr_cnt = rc.getBigDecimal("qtd_credt_trnsfr_cnt");
                BigDecimal qtd_debit_trnsfr_amt = rc.getBigDecimal("qtd_debit_trnsfr_amt");
                BigDecimal qtd_debit_trnsfr_cnt = rc.getBigDecimal("qtd_debit_trnsfr_cnt");
                BigDecimal qtd_outbank_debit_trnsfr_amt = rc.getBigDecimal("qtd_outbank_debit_trnsfr_amt");
                BigDecimal qtd_outbank_debit_trnsfr_cnt = rc.getBigDecimal("qtd_outbank_debit_trnsfr_cnt");
                BigDecimal qtd_outbank_credt_trnsfr_amt = rc.getBigDecimal("qtd_outbank_credt_trnsfr_amt");
                BigDecimal qtd_outbank_credt_trnsfr_cnt = rc.getBigDecimal("qtd_outbank_credt_trnsfr_cnt");
                BigDecimal qtd_bill_payment_amt = rc.getBigDecimal("qtd_bill_payment_amt");
                BigDecimal qtd_bill_payment_cnt = rc.getBigDecimal("qtd_bill_payment_cnt");
                BigDecimal qtd_saving_amt = rc.getBigDecimal("qtd_saving_amt");
                BigDecimal qtd_saving_cnt = rc.getBigDecimal("qtd_saving_cnt");
                BigDecimal qtd_loan_payment_amt = rc.getBigDecimal("qtd_loan_payment_amt");
                BigDecimal qtd_loan_payment_cnt = rc.getBigDecimal("qtd_loan_payment_cnt");
                BigDecimal qtd_credit_cash_amt = rc.getBigDecimal("qtd_credit_cash_amt");
                BigDecimal qtd_credit_cash_cnt = rc.getBigDecimal("qtd_credit_cash_cnt");
                BigDecimal qtd_debit_cash_amt = rc.getBigDecimal("qtd_debit_cash_amt");
                BigDecimal qtd_debit_cash_cnt = rc.getBigDecimal("qtd_debit_cash_cnt");
                BigDecimal qtd_debit_oversea_amt = rc.getBigDecimal("qtd_debit_oversea_amt");
                BigDecimal qtd_credit_oversea_amt = rc.getBigDecimal("qtd_credit_oversea_amt");
                BigDecimal qtd_debit_oversea_cnt = rc.getBigDecimal("qtd_debit_oversea_cnt");
                BigDecimal qtd_credit_oversea_cnt = rc.getBigDecimal("qtd_credit_oversea_cnt");
                BigDecimal ytd_credt_trnsfr_amt_couter = rc.getBigDecimal("ytd_credt_trnsfr_amt_couter");
                BigDecimal ytd_credt_trnsfr_cnt_couter = rc.getBigDecimal("ytd_credt_trnsfr_cnt_couter");
                BigDecimal ytd_debit_trnsfr_amt_couter = rc.getBigDecimal("ytd_debit_trnsfr_amt_couter");
                BigDecimal ytd_debit_trnsfr_cnt_couter = rc.getBigDecimal("ytd_debit_trnsfr_cnt_couter");
                BigDecimal ytd_credt_trnsfr_amt_online = rc.getBigDecimal("ytd_credt_trnsfr_amt_online");
                BigDecimal ytd_credt_trnsfr_cnt_online = rc.getBigDecimal("ytd_credt_trnsfr_cnt_online");
                BigDecimal ytd_debit_trnsfr_amt_online = rc.getBigDecimal("ytd_debit_trnsfr_amt_online");
                BigDecimal ytd_debit_trnsfr_cnt_online = rc.getBigDecimal("ytd_debit_trnsfr_cnt_online");
                BigDecimal ytd_credt_trnsfr_amt = rc.getBigDecimal("ytd_credt_trnsfr_amt");
                BigDecimal ytd_credt_trnsfr_cnt = rc.getBigDecimal("ytd_credt_trnsfr_cnt");
                BigDecimal ytd_debit_trnsfr_amt = rc.getBigDecimal("ytd_debit_trnsfr_amt");
                BigDecimal ytd_debit_trnsfr_cnt = rc.getBigDecimal("ytd_debit_trnsfr_cnt");
                BigDecimal ytd_outbank_debit_trnsfr_amt = rc.getBigDecimal("ytd_outbank_debit_trnsfr_amt");
                BigDecimal ytd_outbank_debit_trnsfr_cnt = rc.getBigDecimal("ytd_outbank_debit_trnsfr_cnt");
                BigDecimal ytd_outbank_credt_trnsfr_amt = rc.getBigDecimal("ytd_outbank_credt_trnsfr_amt");
                BigDecimal ytd_outbank_credt_trnsfr_cnt = rc.getBigDecimal("ytd_outbank_credt_trnsfr_cnt");
                BigDecimal ytd_bill_payment_amt = rc.getBigDecimal("ytd_bill_payment_amt");
                BigDecimal ytd_bill_payment_cnt = rc.getBigDecimal("ytd_bill_payment_cnt");
                BigDecimal ytd_saving_amt = rc.getBigDecimal("ytd_saving_amt");
                BigDecimal ytd_saving_cnt = rc.getBigDecimal("ytd_saving_cnt");
                BigDecimal ytd_loan_payment_amt = rc.getBigDecimal("ytd_loan_payment_amt");
                BigDecimal ytd_loan_payment_cnt = rc.getBigDecimal("ytd_loan_payment_cnt");
                BigDecimal ytd_credit_cash_amt = rc.getBigDecimal("ytd_credit_cash_amt");
                BigDecimal ytd_credit_cash_cnt = rc.getBigDecimal("ytd_credit_cash_cnt");
                BigDecimal ytd_debit_cash_amt = rc.getBigDecimal("ytd_debit_cash_amt");
                BigDecimal ytd_debit_cash_cnt = rc.getBigDecimal("ytd_debit_cash_cnt");
                BigDecimal ytd_debit_oversea_amt = rc.getBigDecimal("ytd_debit_oversea_amt");
                BigDecimal ytd_credit_oversea_amt = rc.getBigDecimal("ytd_credit_oversea_amt");
                BigDecimal ytd_debit_oversea_cnt = rc.getBigDecimal("ytd_debit_oversea_cnt");
                BigDecimal ytd_credit_oversea_cnt = rc.getBigDecimal("ytd_credit_oversea_cnt");
                BigDecimal ytd_dda_rlse_amt = rc.getBigDecimal("ytd_dda_rlse_amt");
                BigDecimal ytd_rlse_amt = rc.getBigDecimal("ytd_rlse_amt");
                BigDecimal ytd_rlse_shrtrm_amt = rc.getBigDecimal("ytd_rlse_shrtrm_amt");
                BigDecimal ytd_rlse_lngtrm_amt = rc.getBigDecimal("ytd_rlse_lngtrm_amt");
                BigDecimal ytd_credit_cash_instore_amt = rc.getBigDecimal("ytd_credit_cash_instore_amt");
                BigDecimal ytd_dda_rlse_amt_ratio = rc.getBigDecimal("ytd_dda_rlse_amt_ratio");
                BigDecimal ytd_credit_trnsfr_amt_ratio = rc.getBigDecimal("ytd_credit_trnsfr_amt_ratio");
                BigDecimal ytd_outbank_trns_fr_ratio =  rc.getBigDecimal("ytd_outbank_trns_fr_ratio");
                String cob_dt = rc.getString("cob_dt");
                if (request.getBranch() != null){
                    String branch  = rc.getString("branch");
                    customercashflows.add(new CustomerCashFlow(acn,branch,mtd_credt_trnsfr_amt_couter,mtd_credt_trnsfr_cnt_couter,mtd_debit_trnsfr_amt_couter,mtd_debit_trnsfr_cnt_couter,mtd_credt_trnsfr_amt_online,mtd_credt_trnsfr_cnt_online,
                            mtd_debit_trnsfr_amt_online,mtd_debit_trnsfr_cnt_online,mtd_credt_trnsfr_amt,mtd_credt_trnsfr_cnt,mtd_debit_trnsfr_amt,mtd_debit_trnsfr_cnt,mtd_outbank_debit_trnsfr_amt,mtd_outbank_debit_trnsfr_cnt,
                            mtd_outbank_credt_trnsfr_amt,mtd_outbank_credt_trnsfr_cnt,mtd_bill_payment_amt,mtd_bill_payment_cnt,mtd_saving_amt,mtd_saving_cnt,mtd_loan_payment_amt,mtd_loan_payment_cnt,mtd_credit_cash_amt,mtd_credit_cash_cnt,
                            mtd_debit_cash_amt,mtd_debit_cash_cnt,mtd_debit_oversea_amt,mtd_credit_oversea_amt,mtd_debit_oversea_cnt,mtd_credit_oversea_cnt,qtd_credt_trnsfr_amt_couter,qtd_credt_trnsfr_cnt_couter,qtd_debit_trnsfr_amt_couter,
                            qtd_debit_trnsfr_cnt_couter,qtd_credt_trnsfr_amt_online,qtd_credt_trnsfr_cnt_online,qtd_debit_trnsfr_amt_online,qtd_debit_trnsfr_cnt_online,qtd_credt_trnsfr_amt,qtd_credt_trnsfr_cnt,qtd_debit_trnsfr_amt,qtd_debit_trnsfr_cnt,
                            qtd_outbank_debit_trnsfr_amt,qtd_outbank_debit_trnsfr_cnt,qtd_outbank_credt_trnsfr_amt,qtd_outbank_credt_trnsfr_cnt,
                            qtd_bill_payment_amt,qtd_bill_payment_cnt,qtd_saving_amt,qtd_saving_cnt,qtd_loan_payment_amt,qtd_loan_payment_cnt,
                            qtd_credit_cash_amt,qtd_credit_cash_cnt,qtd_debit_cash_amt,qtd_debit_cash_cnt,qtd_debit_oversea_amt,qtd_credit_oversea_amt,
                            qtd_debit_oversea_cnt,qtd_credit_oversea_cnt,ytd_credt_trnsfr_amt_couter,ytd_credt_trnsfr_cnt_couter,
                            ytd_debit_trnsfr_amt_couter,ytd_debit_trnsfr_cnt_couter,ytd_credt_trnsfr_amt_online,ytd_credt_trnsfr_cnt_online,
                            ytd_debit_trnsfr_amt_online,ytd_debit_trnsfr_cnt_online,ytd_credt_trnsfr_amt,ytd_credt_trnsfr_cnt,ytd_debit_trnsfr_amt,
                            ytd_debit_trnsfr_cnt,ytd_outbank_debit_trnsfr_amt,ytd_outbank_debit_trnsfr_cnt,ytd_outbank_credt_trnsfr_amt,
                            ytd_outbank_credt_trnsfr_cnt,ytd_bill_payment_amt,ytd_bill_payment_cnt,ytd_saving_amt,ytd_saving_cnt,
                            ytd_loan_payment_amt,ytd_loan_payment_cnt,ytd_credit_cash_amt,ytd_credit_cash_cnt,ytd_debit_cash_amt,ytd_debit_cash_cnt,
                            ytd_debit_oversea_amt,ytd_credit_oversea_amt,ytd_debit_oversea_cnt,ytd_credit_oversea_cnt,ytd_dda_rlse_amt,ytd_rlse_amt,
                            ytd_rlse_shrtrm_amt,ytd_rlse_lngtrm_amt,ytd_credit_cash_instore_amt,ytd_dda_rlse_amt_ratio,ytd_credit_trnsfr_amt_ratio,ytd_outbank_trns_fr_ratio,cob_dt));
                }
                else {
                    customercashflows.add(new CustomerCashFlow(acn,null,mtd_credt_trnsfr_amt_couter,mtd_credt_trnsfr_cnt_couter,mtd_debit_trnsfr_amt_couter,mtd_debit_trnsfr_cnt_couter,mtd_credt_trnsfr_amt_online,mtd_credt_trnsfr_cnt_online,
                            mtd_debit_trnsfr_amt_online,mtd_debit_trnsfr_cnt_online,mtd_credt_trnsfr_amt,mtd_credt_trnsfr_cnt,mtd_debit_trnsfr_amt,mtd_debit_trnsfr_cnt,mtd_outbank_debit_trnsfr_amt,mtd_outbank_debit_trnsfr_cnt,
                            mtd_outbank_credt_trnsfr_amt,mtd_outbank_credt_trnsfr_cnt,mtd_bill_payment_amt,mtd_bill_payment_cnt,mtd_saving_amt,mtd_saving_cnt,mtd_loan_payment_amt,mtd_loan_payment_cnt,mtd_credit_cash_amt,mtd_credit_cash_cnt,
                            mtd_debit_cash_amt,mtd_debit_cash_cnt,mtd_debit_oversea_amt,mtd_credit_oversea_amt,mtd_debit_oversea_cnt,mtd_credit_oversea_cnt,qtd_credt_trnsfr_amt_couter,qtd_credt_trnsfr_cnt_couter,qtd_debit_trnsfr_amt_couter,
                            qtd_debit_trnsfr_cnt_couter,qtd_credt_trnsfr_amt_online,qtd_credt_trnsfr_cnt_online,qtd_debit_trnsfr_amt_online,qtd_debit_trnsfr_cnt_online,qtd_credt_trnsfr_amt,qtd_credt_trnsfr_cnt,qtd_debit_trnsfr_amt,qtd_debit_trnsfr_cnt,
                            qtd_outbank_debit_trnsfr_amt,qtd_outbank_debit_trnsfr_cnt,qtd_outbank_credt_trnsfr_amt,qtd_outbank_credt_trnsfr_cnt,
                            qtd_bill_payment_amt,qtd_bill_payment_cnt,qtd_saving_amt,qtd_saving_cnt,qtd_loan_payment_amt,qtd_loan_payment_cnt,
                            qtd_credit_cash_amt,qtd_credit_cash_cnt,qtd_debit_cash_amt,qtd_debit_cash_cnt,qtd_debit_oversea_amt,qtd_credit_oversea_amt,
                            qtd_debit_oversea_cnt,qtd_credit_oversea_cnt,ytd_credt_trnsfr_amt_couter,ytd_credt_trnsfr_cnt_couter,
                            ytd_debit_trnsfr_amt_couter,ytd_debit_trnsfr_cnt_couter,ytd_credt_trnsfr_amt_online,ytd_credt_trnsfr_cnt_online,
                            ytd_debit_trnsfr_amt_online,ytd_debit_trnsfr_cnt_online,ytd_credt_trnsfr_amt,ytd_credt_trnsfr_cnt,ytd_debit_trnsfr_amt,
                            ytd_debit_trnsfr_cnt,ytd_outbank_debit_trnsfr_amt,ytd_outbank_debit_trnsfr_cnt,ytd_outbank_credt_trnsfr_amt,
                            ytd_outbank_credt_trnsfr_cnt,ytd_bill_payment_amt,ytd_bill_payment_cnt,ytd_saving_amt,ytd_saving_cnt,
                            ytd_loan_payment_amt,ytd_loan_payment_cnt,ytd_credit_cash_amt,ytd_credit_cash_cnt,ytd_debit_cash_amt,ytd_debit_cash_cnt,
                            ytd_debit_oversea_amt,ytd_credit_oversea_amt,ytd_debit_oversea_cnt,ytd_credit_oversea_cnt,ytd_dda_rlse_amt,ytd_rlse_amt,
                            ytd_rlse_shrtrm_amt,ytd_rlse_lngtrm_amt,ytd_credit_cash_instore_amt,ytd_dda_rlse_amt_ratio,ytd_credit_trnsfr_amt_ratio,ytd_outbank_trns_fr_ratio,cob_dt));
                }

            } c.close();
            }
        catch (SQLException e){
            System.out.println(e.getErrorCode());
        }

        return customercashflows;
        }


}