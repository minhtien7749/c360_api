package dao.request;


public class LonStatisticRequest {
	  private String requestId;
	    private String cif;
	    private String branch;
	    private String period;
	    private String fromDate;
	    private String toDate;
	    

		public LonStatisticRequest(String requestId, String cif, String branch,String period,String fromDate, String toDate) {
			super();
			this.requestId = requestId;
			this.cif = cif;
			this.branch = branch;
			this.period = period;
			this.fromDate = fromDate;
			this.toDate = toDate;
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


		public String getBranch() {
			return branch;
		}


		public void setBranch(String branch) {
			this.branch = branch;
		}


		public String getFromDate() {
			return fromDate;
		}


		public void setFromDate(String fromDate) {
			this.fromDate = fromDate;
		}


		public String getToDate() {
			return toDate;
		}


		public void setToDate(String toDate) {
			this.toDate = toDate;
		}


		public String getPeriod() {
			return period;
		}


		public void setPeriod(String period) {
			this.period = period;
		}
		
		
		
		
}
