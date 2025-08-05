package query;

import model.CreditApprove;
import payload.request.CreditApprovalRequest;

import javax.swing.text.DateFormatter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CreditApprovalQuery {
    String QUERY_FIRST_DAY_OF_YEAR = "SELECT * FROM customerc360_output.ai_ptdt_dtls WHERE cob_dt = ? AND cif = ? ";
    String QUERY_FROM_TO = "with cif_tbl as (\n" +
            "            --- loại hình kh\n" +
            "            select\n" +
            "                acn,\n" +
            "                ccode\n" +
            "            from datalake.profile.prf_cif\n" +
            "            where cob_dt = ? /*to_dt*/ AND acn = ? /*cif*/\n" +
            "            )\n" +
            "        , disbursement_tbl as (\n" +
            "            --- doanh số nhận nợ vay trong kỳ\n" +
            "            select\n" +
            "                sum(case when loaikyhan='NH' then tamt_lc else 0 end) gn_nh,---giải ngân ngắn hạn\n" +
            "                sum(case when loaikyhan<>'NH' then tamt_lc else 0 end) gn_tdh---giải ngân trung,dài hạn\n" +
            "            from datalake.customer360.c360_loan_disbursement_transaction_dly\n" +
            "            where cob_dt between ? /*from_dt*/ and ? /*to_dt*/\n" +
            "               AND cif_gn = ? /*cif*/\n" +
            "            )\n" +
            "        , ln_tbl as (\n" +
            "            -- dư nợ vay\n" +
            "            select\n" +
            "                sum(case when cast(trmm as decimal(18,2))<=12 then cast(dly_ostd_bal_amt_in_lc as decimal(18,2))  end) short_term_end_bal,\n" +
            "                sum(case when cast(trmm as decimal(18,2))>12 then cast(dly_ostd_bal_amt_in_lc as decimal(18,2))  end) long_mid_term_end_bal,\n" +
            "                sum(cast(ytd_avg_bal_amt_in_lc as decimal(18,2))) ytd_avg_bal\n" +
            "            from datalake.customer360.c360_lon_dtls_fact\n" +
            "            where cob_dt = ? /*to_dt*/\n" +
            "               AND cus_cif_nbr = ? /*cif*/\n" +
            "            )\n" +
            "        , tf_tbl as (\n" +
            "            -- tài trợ thương mại\n" +
            "            select\n" +
            "                sum(case when prd_nm_vn = 'Phát hành L/C Nhập khẩu (Có UPAS)' then 1 else 0 end) as issue_lc_num,\n" +
            "                sum(case when prd_nm_vn = 'Phát hành L/C Nhập khẩu (Có UPAS)' then trd_amt_in_lc2 else 0 end) as issue_lc_amt,\n" +
            "                sum(case when prd_nm_vn in ('Chiết khấu BCT theo L/C xuất khẩu','Chiết khấu BCT theo Nhờ thu xuất khẩu','Chiết khấu BCT theo TTR xuất khẩu') then 1 else 0 end) as tf_discount_num,\n" +
            "                sum(case when prd_nm_vn in ('Chiết khấu BCT theo L/C xuất khẩu','Chiết khấu BCT theo Nhờ thu xuất khẩu','Chiết khấu BCT theo TTR xuất khẩu') then trd_amt_in_lc2 else 0 end) as tf_discount_amt,\n" +
            "                sum(case when prd_nm_vn in ('Phát hành Bảo lãnh nước ngoài','Phát hành Bảo lãnh trong nước','Phát hành Tái bảo lãnh') then 1 else 0 end) as issue_gtee_num,\n" +
            "                sum(case when prd_nm_vn in ('Phát hành Bảo lãnh nước ngoài','Phát hành Bảo lãnh trong nước','Phát hành Tái bảo lãnh') then trd_amt_in_lc2 else 0 end) as issue_gtee_amt,\n" +
            "                sum(case when prd_nm_vn in ('Invoice Bao thanh toán Nội địa','Invoice Bao thanh toán Tài trợ chuỗi','Invoice Bao thanh toán Xuất khẩu') then 1 else 0 end) as factoring_num,\n" +
            "                sum(case when prd_nm_vn in ('Invoice Bao thanh toán Nội địa','Invoice Bao thanh toán Tài trợ chuỗi','Invoice Bao thanh toán Xuất khẩu') then trd_amt_in_lc2 else 0 end) as factoring_amt\n" +
            "            from datalake.tradefinance.trd_fin_trns_dtls_amt\n" +
            "            where cob_dt between ? /*from_dt*/ and ? /*to_dt*/\n" +
            "               AND cus_cif_nbr_trd_amt = ?/*cif*/\n" +
            "            )\n" +
            "        , toi_tbl as (\n" +
            "            select\n" +
            "                sum(coalesce(cast(mtd_ln_nii_alco_amt_in_lc  as decimal(18,2)),0)) lon_nii,\n" +
            "                sum(coalesce(cast(mtd_dpst_nii_alco_amt_in_lc  as decimal(18,2)),0)) dep_nii,\n" +
            "                sum(coalesce(cast(mtd_tttm_noii_amt  as decimal (18,2)),0)) tf_toi,\n" +
            "                sum(cast(mtd_toi_amt  as decimal(18,2))) toi\n" +
            "            from datalake.customer360.c360_cus_toi_amt_fact\n" +
            "            where cob_dt IN ( %s ) /*liệt kê các ngày cuối tháng từ fr_dt đến to_dt*/\n" +
            "               and cus_cif_nbr = ? /*cif*/\n" +
            "            )\n" +
            "        select\n" +
            "            cif_tbl.acn as cif,\n" +
            "            cif_tbl.ccode,\n" +
            "            coalesce(disbursement_tbl.gn_nh,0) as b_i_3_2_13,\n" +
            "            coalesce(ln_tbl.short_term_end_bal,0) as b_i_3_2_14,\n" +
            "            coalesce(disbursement_tbl.gn_tdh,0) as b_i_3_2_15,\n" +
            "            coalesce(ln_tbl.long_mid_term_end_bal,0) as b_i_3_2_16,\n" +
            "            coalesce(ln_tbl.ytd_avg_bal,0) as b_i_3_2_17,\n" +
            "            coalesce(tf_tbl.issue_lc_num,0) as b_i_3_2_18,\n" +
            "            coalesce(tf_tbl.issue_lc_amt,0) as b_i_3_2_19,\n" +
            "            coalesce(tf_tbl.tf_discount_num,0) as b_i_3_2_20,\n" +
            "            coalesce(tf_tbl.tf_discount_amt,0) as b_i_3_2_21,\n" +
            "            coalesce(tf_tbl.issue_gtee_num,0) as b_i_3_2_22,\n" +
            "            coalesce(tf_tbl.issue_gtee_amt,0) as b_i_3_2_23,\n" +
            "            coalesce(tf_tbl.factoring_num,0) as b_i_3_2_24,\n" +
            "            coalesce(tf_tbl.factoring_amt,0) as b_i_3_2_25,\n" +
            "            coalesce(disbursement_tbl.gn_nh,0) + coalesce(disbursement_tbl.gn_tdh,0) + coalesce(tf_tbl.issue_lc_amt,0) + coalesce(tf_tbl.tf_discount_amt,0) + coalesce(tf_tbl.issue_gtee_amt,0) + coalesce(tf_tbl.factoring_amt,0) as b_i_3_2_26,\n" +
            "            coalesce(toi_tbl.lon_nii,0) as b_i_3_2_39,\n" +
            "            coalesce(toi_tbl.dep_nii,0) as b_i_3_2_40,\n" +
            "            coalesce(toi_tbl.tf_toi,0) as b_i_3_2_41,\n" +
            "            coalesce(toi_tbl.toi - toi_tbl.lon_nii - toi_tbl.dep_nii - toi_tbl.tf_toi,0) as b_i_3_2_42,\n" +
            "            coalesce(toi_tbl.toi,0) as b_i_3_2_43,\n" +
            "            case when coalesce(ln_tbl.ytd_avg_bal,0)>0 then coalesce(toi_tbl.toi,0)*1.00/coalesce(ln_tbl.ytd_avg_bal,0) else null end as b_i_3_2_45\n" +
            "        from cif_tbl\n" +
            "        cross join disbursement_tbl\n" +
            "        cross join ln_tbl\n" +
            "        cross join tf_tbl\n" +
            "        cross join toi_tbl\n";
    CreditApprovalRequest request;

    public CreditApprovalQuery(CreditApprovalRequest request) {
        this.request = request;
    }

    private String generatePlaceholderString(ArrayList<String> items) {
        if (items.isEmpty()) {
            return "";
        }
        StringBuilder placeholders = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            placeholders.append("?");
            if (i < items.size() - 1) {
                placeholders.append(", ");
            }
        }
        return placeholders.toString();
    }

    public ArrayList<String> genLastDayOfMonth(String fromDate, String endDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(fromDate, formatter);
        LocalDate toDate = LocalDate.parse(endDate,formatter);
        ArrayList<String> listDate = new ArrayList<>();

        LocalDate current = startDate.withDayOfMonth(1);
        while (!current.isAfter(toDate)){
            LocalDate lastDay = current.withDayOfMonth(current.lengthOfMonth());
            String temp = lastDay.format(formatter);
            listDate.add(temp);
            current = current.plusMonths(1);
        }
        return listDate;

    }
    public Boolean checkDate(String fromDate, String endDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(fromDate,formatter);
        LocalDate toDate = LocalDate.parse(endDate,formatter);
        return (startDate.getDayOfMonth() == 1)&& (toDate.getDayOfMonth() == toDate.lengthOfMonth());
    }

    public Boolean checkFirstDayOfYear(String fromDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(fromDate,formatter);
        return (startDate.getDayOfYear() == 1);
    }

    public PreparedStatement returnQuery(Connection c) throws SQLException {
        String fromDate = request.getFromDate();
        String endDate = request.getEndDate();
        String customerId = request.getCustomerId();
        if (checkFirstDayOfYear(fromDate)){
            PreparedStatement statement = c.prepareStatement(QUERY_FIRST_DAY_OF_YEAR);
            statement.setString(1,endDate);
            statement.setString(2,customerId);
            return statement;
        } else {
            ArrayList<String> listDay = genLastDayOfMonth(fromDate, endDate);
            String query = String.format(QUERY_FROM_TO, generatePlaceholderString(listDay));
            PreparedStatement statement = c.prepareStatement(query);
            int params = 1;
            statement.setString(params++,endDate);
            statement.setString(params++,customerId);
            statement.setString(params++,fromDate);
            statement.setString(params++,endDate);
            statement.setString(params++,customerId);
            statement.setString(params++,endDate);
            statement.setString(params++,customerId);
            statement.setString(params++,fromDate);
            statement.setString(params++,endDate);
            statement.setString(params++,customerId);
            for (int i = 0 ; i < listDay.size(); i ++){
                statement.setString(params++,listDay.get(i));
            }
            statement.setString(params++,customerId);
            return statement;
        }

    }
}