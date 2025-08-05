package dao.request;

public class BudgetRequest extends PfmStatisticOverviewRequest{
    public BudgetRequest(String requestId, String sessionId, String customerId, String periodFrom, String periodTo, String periodType, String category) {
        super(requestId, sessionId, customerId, periodFrom, periodTo, periodType);
        this.category = category;
    }

    private String category;

    public String getCategory() {
        return category;
    }
}