package c360.model;

import java.util.ArrayList;

public class DepDtlFactDto {
	public String getYtdAvgBalAmtTotal() {
		return ytdAvgBalAmtTotal;
	}

	public void setYtdAvgBalAmtTotal(String ytdAvgBalAmtTotal) {
		this.ytdAvgBalAmtTotal = ytdAvgBalAmtTotal;
	}

	public String getYtdAvgBalAmtTcTotal() {
		return ytdAvgBalAmtTcTotal;
	}

	public void setYtdAvgBalAmtTcTotal(String ytdAvgBalAmtTcTotal) {
		this.ytdAvgBalAmtTcTotal = ytdAvgBalAmtTcTotal;
	}

	public String getYtdOnlAvgBalAmtTotal() {
		return ytdOnlAvgBalAmtTotal;
	}

	public void setYtdOnlAvgBalAmtTotal(String ytdOnlAvgBalAmtTotal) {
		this.ytdOnlAvgBalAmtTotal = ytdOnlAvgBalAmtTotal;
	}

	public String getYtdOnlAvgBalAmtTcTotal() {
		return ytdOnlAvgBalAmtTcTotal;
	}

	public void setYtdOnlAvgBalAmtTcTotal(String ytdOnlAvgBalAmtTcTotal) {
		this.ytdOnlAvgBalAmtTcTotal = ytdOnlAvgBalAmtTcTotal;
	}

	public String getDlyBalAmtTotal() {
		return dlyBalAmtTotal;
	}

	public void setDlyBalAmtTotal(String dlyBalAmtTotal) {
		this.dlyBalAmtTotal = dlyBalAmtTotal;
	}

	public String getDlyBalAmtTcTotal() {
		return dlyBalAmtTcTotal;
	}

	public void setDlyBalAmtTcTotal(String dlyBalAmtTcTotal) {
		this.dlyBalAmtTcTotal = dlyBalAmtTcTotal;
	}

	public String getYtdNiiAmtTotal() {
		return ytdNiiAmtTotal;
	}

	public void setYtdNiiAmtTotal(String ytdNiiAmtTotal) {
		this.ytdNiiAmtTotal = ytdNiiAmtTotal;
	}

	public String getYtdNimAmtTotal() {
		return ytdNimAmtTotal;
	}

	public void setYtdNimAmtTotal(String ytdNimAmtTotal) {
		this.ytdNimAmtTotal = ytdNimAmtTotal;
	}

	public String getCob_dt() {
		return cob_dt;
	}

	public void setCob_dt(String cob_dt) {
		this.cob_dt = cob_dt;
	}

	public ArrayList<DepDtlFact> getDetail() {
		return detail;
	}

	public void setDetail(ArrayList<DepDtlFact> detail) {
		this.detail = detail;
	}

	private String ytdAvgBalAmtTotal;
	private String ytdAvgBalAmtTcTotal;
	private String ytdOnlAvgBalAmtTotal;
	private String ytdOnlAvgBalAmtTcTotal;
	private String dlyBalAmtTotal;
	private String dlyBalAmtTcTotal;
	private String ytdNiiAmtTotal;
	private String ytdNimAmtTotal;
	private String cob_dt;
	private ArrayList<DepDtlFact> detail;
	
	public DepDtlFactDto(
			String ytdAvgBalAmtTotal, 
			String ytdAvgBalAmtTcTotal, 
			String ytdOnlAvgBalAmtTotal,
			String ytdOnlAvgBalAmtTcTotal, 
			String dlyBalAmtTotal, 
			String dlyBalAmtTcTotal, 
			String ytdNiiAmtTotal,
			String ytdNimAmtTotal, 
			String cob_dt, 
			ArrayList<DepDtlFact> detail
	) {
		super();
		this.ytdAvgBalAmtTotal = ytdAvgBalAmtTotal;
		this.ytdAvgBalAmtTcTotal = ytdAvgBalAmtTcTotal;
		this.ytdOnlAvgBalAmtTotal = ytdOnlAvgBalAmtTotal;
		this.ytdOnlAvgBalAmtTcTotal = ytdOnlAvgBalAmtTcTotal;
		this.dlyBalAmtTotal = dlyBalAmtTotal;
		this.dlyBalAmtTcTotal = dlyBalAmtTcTotal;
		this.ytdNiiAmtTotal = ytdNiiAmtTotal;
		this.ytdNimAmtTotal = ytdNimAmtTotal;
		this.cob_dt = cob_dt;
		this.detail = detail;
	}
}
