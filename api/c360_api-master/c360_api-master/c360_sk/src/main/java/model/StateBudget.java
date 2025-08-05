package model;

public class StateBudget {
	private String docdt;
	private String doccd;
	private String docid;
	private String refno;
	private String taxpn;
	private String taxcd;
	private String taxpa;
	private String ptaxpn;
	private String ptaxpa;
	private String treacd;
	private String cid;
	private String namSend;
	private String city;
	private String origtrno;
	private String period;
	private String cont;
	private String amt ;
	private String itm;
	private String bsn;
	private String colacc;
	private String uid;
	private String uidapp;
	private String taxtyp;
	private String tseq;
	private String tjd;
	private String colagc;
	private String brcd;
	private String brchName;
	private String sendCorr;
	private String namRev;
	private String taxref;
	private String zutblcolagctDesc;
	private String areap;
	private String sndr;
	private String zrmkorg;
	private String decno;
	private String decdate;
	private String zutblareaDesc;
	private String benname;
	private String instnam;
	private String time;
	private String sendistl;
	private String cobDt;
	
	
	public StateBudget(String docdt, String doccd, String docid, String refno, String taxpn, String taxcd, String taxpa,
			String ptaxpn, String ptaxpa, String treacd, String cid, String namSend, String city, String origtrno,
			String period, String cont, String amt, String itm, String bsn, String colacc, String uid, String uidapp,
			String taxtyp, String tseq, String tjd, String colagc, String brcd, String brchName, String sendCorr,
			String namRev, String taxref, String zutblcolagctDesc, String areap, String sndr, String zrmkorg,
			String decno, String decdate, String zutblareaDesc, String benname ,String instnam , String time, String sendistl ,String cobDt) {
		this.docdt = docdt;
		this.doccd = doccd;
		this.docid = docid;
		this.refno = refno;
		this.taxpn = taxpn;
		this.taxcd = taxcd;
		this.taxpa = taxpa;
		this.ptaxpn = ptaxpn;
		this.ptaxpa = ptaxpa;
		this.treacd = treacd;
		this.cid = cid;
		this.namSend = namSend;
		this.city = city;
		this.origtrno = origtrno;
		this.period = period;
		this.cont = cont;
		this.amt = amt;
		this.itm = itm;
		this.bsn = bsn;
		this.colacc = colacc;
		this.uid = uid;
		this.uidapp = uidapp;
		this.taxtyp = taxtyp;
		this.tseq = tseq;
		this.tjd = tjd;
		this.colagc = colagc;
		this.brcd = brcd;
		this.brchName = brchName;
		this.sendCorr = sendCorr;
		this.namRev = namRev;
		this.taxref = taxref;
		this.zutblcolagctDesc = zutblcolagctDesc;
		this.areap = areap;
		this.sndr = sndr;
		this.zrmkorg = zrmkorg;
		this.decno = decno;
		this.decdate = decdate;
		this.zutblareaDesc = zutblareaDesc;
		this.benname = benname;
		this.instnam = instnam; 
		this.time = time;
		this.sendistl= sendistl;
		this.cobDt = cobDt;
	}
	
	
	public String getBenname() {
		return benname;
	}

	public void setBenname(String benname) {
		this.benname = benname;
	}

	public String getInstnam() {
		return instnam;
	}

	public void setInstnam(String instnam) {
		this.instnam = instnam;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}


	public String getSendistl() {
		return sendistl;
	}




	public void setSendistl(String sendistl) {
		this.sendistl = sendistl;
	}




	public String getDocdt() {
		return docdt;
	}
	public void setDocdt(String docdt) {
		this.docdt = docdt;
	}
	public String getDoccd() {
		return doccd;
	}
	public void setDoccd(String doccd) {
		this.doccd = doccd;
	}
	public String getDocid() {
		return docid;
	}
	public void setDocid(String docid) {
		this.docid = docid;
	}
	public String getRefno() {
		return refno;
	}
	public void setRefno(String refno) {
		this.refno = refno;
	}
	public String getTaxpn() {
		return taxpn;
	}
	public void setTaxpn(String taxpn) {
		this.taxpn = taxpn;
	}
	public String getTaxcd() {
		return taxcd;
	}
	public void setTaxcd(String taxcd) {
		this.taxcd = taxcd;
	}
	public String getTaxpa() {
		return taxpa;
	}
	public void setTaxpa(String taxpa) {
		this.taxpa = taxpa;
	}
	public String getPtaxpn() {
		return ptaxpn;
	}
	public void setPtaxpn(String ptaxpn) {
		this.ptaxpn = ptaxpn;
	}
	public String getPtaxpa() {
		return ptaxpa;
	}
	public void setPtaxpa(String ptaxpa) {
		this.ptaxpa = ptaxpa;
	}
	public String getTreacd() {
		return treacd;
	}
	public void setTreacd(String treacd) {
		this.treacd = treacd;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getNamSend() {
		return namSend;
	}
	public void setNamSend(String namSend) {
		this.namSend = namSend;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getOrigtrno() {
		return origtrno;
	}
	public void setOrigtrno(String origtrno) {
		this.origtrno = origtrno;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public String getAmt() {
		return amt;
	}
	public void setAmt(String amt) {
		this.amt = amt;
	}
	public String getItm() {
		return itm;
	}
	public void setItm(String itm) {
		this.itm = itm;
	}
	public String getBsn() {
		return bsn;
	}
	public void setBsn(String bsn) {
		this.bsn = bsn;
	}
	public String getColacc() {
		return colacc;
	}
	public void setColacc(String colacc) {
		this.colacc = colacc;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUidapp() {
		return uidapp;
	}
	public void setUidapp(String uidapp) {
		this.uidapp = uidapp;
	}
	public String getTaxtyp() {
		return taxtyp;
	}
	public void setTaxtyp(String taxtyp) {
		this.taxtyp = taxtyp;
	}
	public String getTseq() {
		return tseq;
	}
	public void setTseq(String tseq) {
		this.tseq = tseq;
	}
	public String getTjd() {
		return tjd;
	}
	public void setTjd(String tjd) {
		this.tjd = tjd;
	}
	public String getColagc() {
		return colagc;
	}
	public void setColagc(String colagc) {
		this.colagc = colagc;
	}
	public String getBrcd() {
		return brcd;
	}
	public void setBrcd(String brcd) {
		this.brcd = brcd;
	}
	public String getBrchName() {
		return brchName;
	}
	public void setBrchName(String brchName) {
		this.brchName = brchName;
	}
	public String getSendCorr() {
		return sendCorr;
	}
	public void setSendCorr(String sendCorr) {
		this.sendCorr = sendCorr;
	}
	public String getNamRev() {
		return namRev;
	}
	public void setNamRev(String namRev) {
		this.namRev = namRev;
	}
	public String getTaxref() {
		return taxref;
	}
	public void setTaxref(String taxref) {
		this.taxref = taxref;
	}
	public String getZutblcolagctDesc() {
		return zutblcolagctDesc;
	}
	public void setZutblcolagctDesc(String zutblcolagctDesc) {
		this.zutblcolagctDesc = zutblcolagctDesc;
	}
	public String getAreap() {
		return areap;
	}
	public void setAreap(String areap) {
		this.areap = areap;
	}
	public String getSndr() {
		return sndr;
	}
	public void setSndr(String sndr) {
		this.sndr = sndr;
	}
	public String getZrmkorg() {
		return zrmkorg;
	}
	public void setZrmkorg(String zrmkorg) {
		this.zrmkorg = zrmkorg;
	}
	public String getDecno() {
		return decno;
	}
	public void setDecno(String decno) {
		this.decno = decno;
	}
	public String getDecdate() {
		return decdate;
	}
	public void setDecdate(String decdate) {
		this.decdate = decdate;
	}
	public String getZutblareaDesc() {
		return zutblareaDesc;
	}
	public void setZutblareaDesc(String zutblareaDesc) {
		this.zutblareaDesc = zutblareaDesc;
	}
	public String getCobDt() {
		return cobDt;
	}
	public void setCobDt(String cobDt) {
		this.cobDt = cobDt;
	}
	
}