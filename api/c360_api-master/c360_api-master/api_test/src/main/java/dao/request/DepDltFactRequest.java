package dao.request;
import java.util.List;

public class DepDltFactRequest {
		private String requestId;
	    private String cif;
	    private String branch;
	    private List<String> irnList;
	    private List<String> crcd;
	    private String period;
	    private String grp;
	    private String fromDate;
	    private String toDate;
	        
		public DepDltFactRequest(String requestId, String cif, String branch, List<String> irnList,String grp,
				List<String> crcd,String period, String fromDate, String toDate) {
			this.requestId = requestId;
			this.cif = cif;
			this.branch = branch;
			this.irnList = irnList;
			this.grp = grp;
			this.period = period;
			this.crcd = crcd;
			this.fromDate = fromDate;
			this.toDate = toDate;
		}
		
		public String getGrp() {
			return grp;
		}
		public void setGrp(String grp) {
			this.grp = grp;
		}

		
		public List<String> getIrnList() {
			return irnList;
		}

		public void setIrnList(List<String> irnList) {
			this.irnList = irnList;
		}

		public List<String> getCrcd() {
			return crcd;
		}
		public void setCrcd(List<String> crcd) {
			this.crcd = crcd;
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
