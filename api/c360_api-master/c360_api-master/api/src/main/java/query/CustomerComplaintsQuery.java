package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.request.CustomerComplaintsRequest;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dao.request.CustomerComplaintsRequest;

public class CustomerComplaintsQuery {

    private static final String SQL_TEMPLATE_1 = "SELECT  stt, thoi_gian_lien_he, ten_kh, tu_so, cif, yc_khieu_nai, ma_loi, contact, atm_id, so_luot_kh_phan_anh, nghiep_vu, nghiep_vu_chi_tiet, kenh_gd, doi_tuong, phan_loai_don_vi_giai_quyet, don_vi_giai_quyet_cn, don_vi_giai_quyet_cap_2_pgd, nguyen_nhan, ket_qua, phan_loai_nguyen_nhan, note, ngay_bat_dau, ngay_ket_thuc, phan_loai_kh, cob_dt " +
            "FROM outsite.customer_complaints WHERE cif = ?";

    private static final String SQL_TEMPLATE_2 = "SELECT stt, thoi_gian_lien_he, ten_kh, tu_so, cif, yc_khieu_nai, ma_loi, contact, atm_id, so_luot_kh_phan_anh, nghiep_vu, nghiep_vu_chi_tiet, kenh_gd, doi_tuong, phan_loai_don_vi_giai_quyet, don_vi_giai_quyet_cn, don_vi_giai_quyet_cap_2_pgd, nguyen_nhan, ket_qua, phan_loai_nguyen_nhan, note,ngay_bat_dau, ngay_ket_thuc, phan_loai_kh, cob_dt " +
            "FROM outsite.customer_complaints WHERE tu_so IN (%s)";

    private static final String SQL_TEMPLATE_3 = "SELECT stt, thoi_gian_lien_he, ten_kh, tu_so, cif, yc_khieu_nai, ma_loi, contact, atm_id, so_luot_kh_phan_anh, nghiep_vu, nghiep_vu_chi_tiet, kenh_gd, doi_tuong, phan_loai_don_vi_giai_quyet, don_vi_giai_quyet_cn, don_vi_giai_quyet_cap_2_pgd, nguyen_nhan, ket_qua, phan_loai_nguyen_nhan, note,ngay_bat_dau, ngay_ket_thuc, phan_loai_kh, cob_dt " +
            "FROM outsite.customer_complaints WHERE cif = ? or tu_so IN (%s)";

    private CustomerComplaintsRequest request;

    public CustomerComplaintsQuery(CustomerComplaintsRequest request) {
        this.request = request;
    }

    public PreparedStatement returnSql(Connection connection) throws SQLException {

        // Case when CIF is provided, no phones
        if (request.getCif() != null && (request.getPhones() == null || request.getPhones().isEmpty())) {
            PreparedStatement statement = connection.prepareStatement(SQL_TEMPLATE_1);
            statement.setString(1, request.getCif());
            return statement;
        }

        // Case when Phones are provided and no CIF
        if (request.getPhones() != null && !request.getPhones().isEmpty() && request.getCif() == null) {
            // Create placeholders for the IN clause
            StringBuilder placeholdersBuilder = new StringBuilder();
            for (int i = 0; i < request.getPhones().size(); i++) {
                placeholdersBuilder.append("?");
                if (i < request.getPhones().size() - 1) {
                    placeholdersBuilder.append(",");
                }
            }
            String placeholders = placeholdersBuilder.toString();

            // Build query with phone numbers
            String sql = String.format(SQL_TEMPLATE_2, placeholders);
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set phone numbers
            for (int i = 0; i < request.getPhones().size(); i++) {
                statement.setString(i + 1, request.getPhones().get(i));
            }
            return statement;
        }

        // Case when both CIF and Phones are provided
        if (request.getCif() != null && request.getPhones() != null && !request.getPhones().isEmpty()) {
            // Create placeholders for the IN clause
            StringBuilder placeholdersBuilder = new StringBuilder();
            for (int i = 0; i < request.getPhones().size(); i++) {
                placeholdersBuilder.append("?");
                if (i < request.getPhones().size() - 1) {
                    placeholdersBuilder.append(",");
                }
            }
            String placeholders = placeholdersBuilder.toString();

            // Build query with both CIF and phone numbers
            String sql = String.format(SQL_TEMPLATE_3, placeholders);
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set CIF
            statement.setString(1, request.getCif());

            // Set phone numbers
            int parameterIndex = 2;
            for (int i = 0; i < request.getPhones().size(); i++) {
                statement.setString(parameterIndex++, request.getPhones().get(i));
            }
            return statement;
        }

        // Case when neither CIF nor Phones are provided
        throw new IllegalArgumentException("Either CIF or Phones must be provided.");
    }
}