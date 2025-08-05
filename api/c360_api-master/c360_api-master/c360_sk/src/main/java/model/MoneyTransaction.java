package model;

public class MoneyTransaction {
	
	 private String acn;
	 private String ofscid;
	 private String ofsname;
	 private String bank_code;
	 private String short_name;
	 private String trx_type;
	 private String ofsbrn;
	 private String trans_type_flag;
	 private String mtd_total_amount_transaction_lc;
	 private String count_mtd_transaction;
	 private String cob_dt;
	 
	public MoneyTransaction(String acn, String ofscid, String ofsname, String bank_code, String short_name,
			String trx_type, String ofsbrn, String trans_type_flag, String mtd_total_amount_transaction_lc,
			String count_mtd_transaction, String cob_dt) {
		this.acn = acn;
		this.ofscid = ofscid;
		this.ofsname = ofsname;
		this.bank_code = bank_code;
		this.short_name = short_name;
		this.trx_type = trx_type;
		this.ofsbrn = ofsbrn;
		this.trans_type_flag = trans_type_flag;
		this.mtd_total_amount_transaction_lc = mtd_total_amount_transaction_lc;
		this.count_mtd_transaction = count_mtd_transaction;
		this.cob_dt = cob_dt;
	}

	public String getAcn() {
		return acn;
	}

	public void setAcn(String acn) {
		this.acn = acn;
	}

	public String getOfscid() {
		return ofscid;
	}

	public void setOfscid(String ofscid) {
		this.ofscid = ofscid;
	}

	public String getOfsname() {
		return ofsname;
	}

	public void setOfsname(String ofsname) {
		this.ofsname = ofsname;
	}

	public String getBank_code() {
		return bank_code;
	}

	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}

	public String getShort_name() {
		return short_name;
	}

	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}

	public String getTrx_type() {
		return trx_type;
	}

	public void setTrx_type(String trx_type) {
		this.trx_type = trx_type;
	}

	public String getOfsbrn() {
		return ofsbrn;
	}

	public void setOfsbrn(String ofsbrn) {
		this.ofsbrn = ofsbrn;
	}

	public String getTrans_type_flag() {
		return trans_type_flag;
	}

	public void setTrans_type_flag(String trans_type_flag) {
		this.trans_type_flag = trans_type_flag;
	}

	public String getMtd_total_amount_transaction_lc() {
		return mtd_total_amount_transaction_lc;
	}

	public void setMtd_total_amount_transaction_lc(String mtd_total_amount_transaction_lc) {
		this.mtd_total_amount_transaction_lc = mtd_total_amount_transaction_lc;
	}

	public String getCount_mtd_transaction() {
		return count_mtd_transaction;
	}

	public void setCount_mtd_transaction(String count_mtd_transaction) {
		this.count_mtd_transaction = count_mtd_transaction;
	}

	public String getCob_dt() {
		return cob_dt;
	}

	public void setCob_dt(String cob_dt) {
		this.cob_dt = cob_dt;
	}
	
}
