package dao.request;

public class LimitApprovedBalRequest {
	  private String requestId;
	    private String cif;
	    private String period;
	    private String fromDate;
	    private String cobDt;
	    

		public LimitApprovedBalRequest(String requestId, String cif, String period, String fromDate, String cobDt) {
			super();
			this.requestId = requestId;
			this.cif = cif;
			this.period = period;
			this.fromDate = fromDate;
			this.cobDt = cobDt;

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
		public String getPeriod() {
			return period;
		}
		public void setPeriod(String period) {
			this.period = period;
		}
		public String getFromDate() {
			return fromDate;
		}
		public void setFromDate(String fromDate) {
			this.fromDate = fromDate;
		}
		public String getCobDt() {
			return cobDt;
		}
		public void setCobDt(String cobDt) {
			this.cobDt = cobDt;
		}    
	    
}
