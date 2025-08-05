package dao.request;

public class CorpStatementRequest {
    private String requestId;
    private String cif;
    private String account;
    private String fromDate;
    private String toDate;
    private String accStatementType;

    // ✅ No-args constructor for deserialization
    public CorpStatementRequest() {
        this.accStatementType = ""; // Default value for safety
    }

    public CorpStatementRequest(String requestId, String cif, String account, String fromDate, String toDate, String accStatementType) {
        this.requestId = requestId;
        this.cif = cif;
        this.account = account;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.accStatementType = accStatementType == null ? "" : accStatementType; // Prevent null values
    }

    public CorpStatementRequest(String requestId, String cif, String account, String fromDate, String toDate) {
        this(requestId, cif, account, fromDate, toDate, ""); // Call the other constructor
    }

    public String getAccStatementType() {
        return accStatementType == null ? "" : accStatementType;
    }

    public void setAccStatementType(String accStatementType) {
        this.accStatementType = accStatementType;
    }
        
    public String getRequestId() {
        return requestId;
    }

    public String getCif() {
        return cif;
    }

    public String getAccount() {
        return account;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }

//	public String getAccStatementType() {
//		return accStatementType;
//	}
//
//	public void setAccStatementType(String accStatementType) {
//		this.accStatementType = accStatementType;
//	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}   
    
}
