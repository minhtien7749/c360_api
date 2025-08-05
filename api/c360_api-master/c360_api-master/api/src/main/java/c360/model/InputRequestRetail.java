package c360.model;

public class InputRequestRetail {
	private String requestId ;
    private String appId;
    private String userLogin;
    private String timeLogin;

    public InputRequestRetail(String requestId, String appId, String userLogin, String timeLogin, String cif){
        this.requestId = requestId;
        this.appId = appId;
        this.userLogin = userLogin;
        this.timeLogin = timeLogin;
        this.cif = cif;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getTimeLogin() {
        return timeLogin;
    }

    public void setTimeLogin(String timeLogin) {
        this.timeLogin = timeLogin;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    @Override
    public String toString() {
        return "InputRequest{" +
                "requestId='" + requestId + '\'' +
                ", appId='" + appId + '\'' +
                ", userLogin='" + userLogin + '\'' +
                ", timeLogin='" + timeLogin + '\'' +
                ", cif='" + cif + '\'' +
                '}';
    }

    private String cif;

}
