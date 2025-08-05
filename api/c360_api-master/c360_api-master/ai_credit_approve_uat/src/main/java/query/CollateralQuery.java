package query;

import payload.request.CusProfileRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CollateralQuery {
    String SQL_TEMPLATE = "SELECT  \n" +
            "            id_core AS b_i_7_2,  -- ID TSBĐ trên Core\n" +
            "            colla_sub_type AS b_i_7_3, -- Loại TSBĐ\n" +
            "            COALESCE(addr,colla_desc) AS b_i_7_4,        -- Mô tả tài sản đảm bảo: mô tả địa chỉ TSBĐ (Bất động sản)/ tên TSBĐ (loại tài sản khác)\n" +
            "            plg_legal_name AS b_i_7_5,  -- Chủ sở hữu TSBĐ\n" +
            "            COALESCE(cms_valuation_date,los_valuation_date) AS b_i_7_6, --Thông tin ngày định giá gần nhất của TSBĐ\n" +
            "            COALESCE(cms_val,los_val) AS b_i_7_7,       -- Giá trị định giá của TSBĐ\n" +
            "            boa_percentage AS b_i_7_8,                                        \n" +
            "            sum(pledge_amount) AS b_i_7_9, -- tổng mức bảo đảm chia sẻ\n" +
            "            COALESCE(cms_valuer,los_valuer) AS b_i_7_10,        -- Đơn vị định giá tài sản đảm bảo\n" +
            "            expire_date_sercu AS b_i_7_11 -- Ngày hết hạn bảo hiểm\n" +
            "FROM customer360.c360_colla_to_ln_dtls \n" +
            "WHERE cob_dt ='2025-06-25' /*t-1*/\n" +
            "            AND cif_ln_core  = ? /*cif*/\n" +
            "GROUP BY id_core, colla_sub_type, COALESCE(addr,colla_desc),plg_legal_name,COALESCE(cms_valuation_date,los_valuation_date),\n" +
            "            COALESCE(cms_val,los_val),boa_percentage,COALESCE(cms_valuer,los_valuer),expire_date_sercu";
    CusProfileRequest request;

    public CollateralQuery(CusProfileRequest request) {
        this.request = request;
    }

    public PreparedStatement returnQuery(Connection c) throws SQLException {
        String customerId = request.getCustomerId();
        PreparedStatement statement = c.prepareStatement(SQL_TEMPLATE);
        statement.setString(1,customerId);
        return statement;
    }
}