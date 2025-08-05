package model;

public class TaxData {
	private String cob_dt;
	private String stt;
	private String mst;
	private String nguoi_nop_thue;
	private String cuc_thue;
	private String chi_cuc_thue;
	private String so_thong_bao_cong_khai;
	private String rpt_dt;
	private String bien_phap_cuong_che_dang_ap_dung;
	private String so_tien_no_thue_vnd;
	private String link;
	private String status;
	
	
	
	public TaxData(String cob_dt, String stt, String mst, String nguoi_nop_thue, String cuc_thue, String chi_cuc_thue,
			String so_thong_bao_cong_khai, String rpt_dt, String bien_phap_cuong_che_dang_ap_dung,
			String so_tien_no_thue_vnd, String link, String status) {
		super();
		this.cob_dt = cob_dt;
		this.stt = stt;
		this.mst = mst;
		this.nguoi_nop_thue = nguoi_nop_thue;
		this.cuc_thue = cuc_thue;
		this.chi_cuc_thue = chi_cuc_thue;
		this.so_thong_bao_cong_khai = so_thong_bao_cong_khai;
		this.rpt_dt = rpt_dt;
		this.bien_phap_cuong_che_dang_ap_dung = bien_phap_cuong_che_dang_ap_dung;
		this.so_tien_no_thue_vnd = so_tien_no_thue_vnd;
		this.link = link;
		this.status = status;
	}
	public String getCob_dt() {
		return cob_dt;
	}
	public void setCob_dt(String cob_dt) {
		this.cob_dt = cob_dt;
	}
	public String getStt() {
		return stt;
	}
	public void setStt(String stt) {
		this.stt = stt;
	}
	public String getMst() {
		return mst;
	}
	public void setMst(String mst) {
		this.mst = mst;
	}
	public String getNguoi_nop_thue() {
		return nguoi_nop_thue;
	}
	public void setNguoi_nop_thue(String nguoi_nop_thue) {
		this.nguoi_nop_thue = nguoi_nop_thue;
	}
	public String getCuc_thue() {
		return cuc_thue;
	}
	public void setCuc_thue(String cuc_thue) {
		this.cuc_thue = cuc_thue;
	}
	public String getChi_cuc_thue() {
		return chi_cuc_thue;
	}
	public void setChi_cuc_thue(String chi_cuc_thue) {
		this.chi_cuc_thue = chi_cuc_thue;
	}
	public String getSo_thong_bao_cong_khai() {
		return so_thong_bao_cong_khai;
	}
	public void setSo_thong_bao_cong_khai(String so_thong_bao_cong_khai) {
		this.so_thong_bao_cong_khai = so_thong_bao_cong_khai;
	}
	public String getRpt_dt() {
		return rpt_dt;
	}
	public void setRpt_dt(String rpt_dt) {
		this.rpt_dt = rpt_dt;
	}
	public String getBien_phap_cuong_che_dang_ap_dung() {
		return bien_phap_cuong_che_dang_ap_dung;
	}
	public void setBien_phap_cuong_che_dang_ap_dung(String bien_phap_cuong_che_dang_ap_dung) {
		this.bien_phap_cuong_che_dang_ap_dung = bien_phap_cuong_che_dang_ap_dung;
	}
	public String getSo_tien_no_thue_vnd() {
		return so_tien_no_thue_vnd;
	}
	public void setSo_tien_no_thue_vnd(String so_tien_no_thue_vnd) {
		this.so_tien_no_thue_vnd = so_tien_no_thue_vnd;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

	
}
