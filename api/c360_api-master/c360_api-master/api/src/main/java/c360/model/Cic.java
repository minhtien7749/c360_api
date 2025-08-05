 package c360.model;
 
 public class Cic {
	    private String cif;
	    private String cust_name;
	    private String cic_code;
	    private String id_code;
	    private String address;
	    private String credit_at_bank;
	    private String current_outstanding;
	    private String current_group_debt;
	    private String bad_debt_12m;
	    private int collateral_value;
	    private String credit_card_at_bank;
	    private String credit_card_limit;
	    private String credit_card_late_payment_12m;
	    private int credit_score;
	    private String file_name;
	    private String update_dt;
	    private String cob_dt;

	    public Cic(String cif, String cust_name, String cic_code, String id_code, String address, String credit_at_bank, String current_outstanding, String current_group_debt, String bad_debt_12m, int collateral_value, String credit_card_at_bank, String credit_card_limit, String credit_card_late_payment_12m, int credit_score, String file_name, String update_dt, String cob_dt) {
	        this.cif = cif;
	        this.cust_name = cust_name;
	        this.cic_code = cic_code;
	        this.id_code = id_code;
	        this.address = address;
	        this.credit_at_bank = credit_at_bank;
	        this.current_outstanding = current_outstanding;
	        this.current_group_debt = current_group_debt;
	        this.bad_debt_12m = bad_debt_12m;
	        this.collateral_value = collateral_value;
	        this.credit_card_at_bank = credit_card_at_bank;
	        this.credit_card_limit = credit_card_limit;
	        this.credit_card_late_payment_12m = credit_card_late_payment_12m;
	        this.credit_score = credit_score;
	        this.file_name = file_name;
	        this.update_dt = update_dt;
	        this.cob_dt = cob_dt;
	    }

	    public String getCif() {
	        return cif;
	    }

	    public void setCif(String cif) {
	        this.cif = cif;
	    }

	    public String getCust_name() {
	        return cust_name;
	    }

	    public void setCust_name(String cust_name) {
	        this.cust_name = cust_name;
	    }

	    public String getCic_code() {
	        return cic_code;
	    }

	    public void setCic_code(String cic_code) {
	        this.cic_code = cic_code;
	    }

	    public String getId_code() {
	        return id_code;
	    }

	    public void setId_code(String id_code) {
	        this.id_code = id_code;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public String getCredit_at_bank() {
	        return credit_at_bank;
	    }

	    public void setCredit_at_bank(String credit_at_bank) {
	        this.credit_at_bank = credit_at_bank;
	    }

	    public String getCurrent_outstanding() {
	        return current_outstanding;
	    }

	    public void setCurrent_outstanding(String current_outstanding) {
	        this.current_outstanding = current_outstanding;
	    }

	    public String getCurrent_group_debt() {
	        return current_group_debt;
	    }

	    public void setCurrent_group_debt(String current_group_debt) {
	        this.current_group_debt = current_group_debt;
	    }

	    public String getBad_debt_12m() {
	        return bad_debt_12m;
	    }

	    public void setBad_debt_12m(String bad_debt_12m) {
	        this.bad_debt_12m = bad_debt_12m;
	    }

	    public int getCollateral_value() {
	        return collateral_value;
	    }

	    public void setCollateral_value(int collateral_value) {
	        this.collateral_value = collateral_value;
	    }

	    public String getCredit_card_at_bank() {
	        return credit_card_at_bank;
	    }

	    public void setCredit_card_at_bank(String credit_card_at_bank) {
	        this.credit_card_at_bank = credit_card_at_bank;
	    }

	    public String getCredit_card_limit() {
	        return credit_card_limit;
	    }

	    public void setCredit_card_limit(String credit_card_limit) {
	        this.credit_card_limit = credit_card_limit;
	    }

	    public String getCredit_card_late_payment_12m() {
	        return credit_card_late_payment_12m;
	    }

	    public void setCredit_card_late_payment_12m(String credit_card_late_payment_12m) {
	        this.credit_card_late_payment_12m = credit_card_late_payment_12m;
	    }

	    public int getCredit_score() {
	        return credit_score;
	    }

	    public void setCredit_score(int credit_score) {
	        this.credit_score = credit_score;
	    }

	    public String getFile_name() {
	        return file_name;
	    }

	    public void setFile_name(String file_name) {
	        this.file_name = file_name;
	    }

	    public String getUpdate_dt() {
	        return update_dt;
	    }

	    public void setUpdate_dt(String update_dt) {
	        this.update_dt = update_dt;
	    }

	    public String getCob_dt() {
	        return cob_dt;
	    }

	    public void setCob_dt(String cob_dt) {
	        this.cob_dt = cob_dt;
	    }
	}