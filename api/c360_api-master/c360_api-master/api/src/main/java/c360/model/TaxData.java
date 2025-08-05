package c360.model;

public class TaxData {
	private String cobDt;
	private String id;
	private String mst;
	private String nguoiNopThue;
	private String cucThue;
	private String chiCucThue;
	private String soThongBaoCongKhai;
	private String rptDt;
	private String bienPhapCuongCheDangApDung;
	private String soTienNoThueVnd;
	private String link;
	private String status;
	
	public TaxData(String cobDt, String id, String mst, String nguoiNopThue, String cucThue, String chiCucThue,
			String soThongBaoCongKhai, String rptDt, String bienPhapCuongCheDangApDung, String soTienNoThueVnd,
			String link, String status) {
		super();
		this.cobDt = cobDt;
		this.id = id;
		this.mst = mst;
		this.nguoiNopThue = nguoiNopThue;
		this.cucThue = cucThue;
		this.chiCucThue = chiCucThue;
		this.soThongBaoCongKhai = soThongBaoCongKhai;
		this.rptDt = rptDt;
		this.bienPhapCuongCheDangApDung = bienPhapCuongCheDangApDung;
		this.soTienNoThueVnd = soTienNoThueVnd;
		this.link = link;
		this.status = status;
	}

	public String getCobDt() {
		return cobDt;
	}

	public void setCobDt(String cobDt) {
		this.cobDt = cobDt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMst() {
		return mst;
	}
	public void setMst(String mst) {
		this.mst = mst;
	}
	public String getNguoiNopThue() {
		return nguoiNopThue;
	}
	public void setNguoiNopThue(String nguoiNopThue) {
		this.nguoiNopThue = nguoiNopThue;
	}
	public String getCucThue() {
		return cucThue;
	}
	public void setCucThue(String cucThue) {
		this.cucThue = cucThue;
	}
	public String getChiCucThue() {
		return chiCucThue;
	}
	public void setChiCucThue(String chiCucThue) {
		this.chiCucThue = chiCucThue;
	}
	public String getSoThongBaoCongKhai() {
		return soThongBaoCongKhai;
	}
	public void setSoThongBaoCongKhai(String soThongBaoCongKhai) {
		this.soThongBaoCongKhai = soThongBaoCongKhai;
	}
	public String getRptDt() {
		return rptDt;
	}
	public void setRptDt(String rptDt) {
		this.rptDt = rptDt;
	}
	public String getBienPhapCuongCheDangApDung() {
		return bienPhapCuongCheDangApDung;
	}
	public void setBienPhapCuongCheDangApDung(String bienPhapCuongCheDangApDung) {
		this.bienPhapCuongCheDangApDung = bienPhapCuongCheDangApDung;
	}
	public String getSoTienNoThueVnd() {
		return soTienNoThueVnd;
	}
	public void setSoTienNoThueVnd(String soTienNoThueVnd) {
		this.soTienNoThueVnd = soTienNoThueVnd;
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
