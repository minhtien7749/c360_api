package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.request.LnDetailRequest;

public class LnDetailQuery {
	private final  String SQL_TEMPLATE = "select cus_cif_nbr,act_nbr ,trm as trm ,full_brnch_cd,brnch_cd,cus_cif_nbr,ft.crcd,cast(dly_ostd_bal_amt_in_lc as double) as dly_ostd_bal_amt_in_lc, cast(dly_ostd_bal_amt_in_tc as double) as dly_ostd_bal_amt_in_tc, cast(mtd_avg_bal_amt_in_lc as double) as mtd_avg_bal_amt_in_lc, cast(ytd_avg_bal_amt_in_lc as double) as ytd_avg_bal_amt_in_lc, cast(qtd_avg_bal_amt_in_lc as double) as qtd_avg_bal_amt_in_lc,next_due_dt,loan_clsfy,intrst_rate, ft.mdt ,open_dt,ft.type,type_nm,user_ad, ft.cob_dt \r\n"
			+ "from customer360.c360_lon_dtls_fact ft \r\n"
//			+ "left join profile.prf_ln ln on ft.act_nbr = ln.cid and ft.cob_dt = ln.cob_dt "
			+ "where cob_dt = ? and cus_cif_nbr=? ";

	private LnDetailRequest request;

    public LnDetailQuery(LnDetailRequest request) {
        this.request = request;
    }
        
    public PreparedStatement returnSql(Connection connection) throws SQLException {

        	PreparedStatement statement = connection.prepareStatement(SQL_TEMPLATE);
            System.out.println("sc sql");
            int parameterIndex = 1;
            statement.setString(parameterIndex ++, request.getCob_dt());
            statement.setString(parameterIndex ++, request.getCif());

        System.out.println("sc2");
        return statement;
        }
    }