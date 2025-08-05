package dao.request;

import java.util.List;

public class CustomerComplaintsRequest {
    private String requestId;
    private String cif;
    private List<String> phones;  
    
    
	public CustomerComplaintsRequest(String requestId, String cif, List<String> phones) {
		super();
		this.requestId = requestId;
		this.cif = cif;
		this.phones = phones;
	}
	
	public List<String> getPhones() {
		return phones;
	}
	public void setPhones(List<String> phones) {
		this.phones = phones;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
}
