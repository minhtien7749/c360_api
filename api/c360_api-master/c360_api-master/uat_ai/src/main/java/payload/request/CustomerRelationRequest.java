package payload.request;

import query.CusRelatedQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomerRelationRequest {
    String requestId;
    public String customerId;
    public ArrayList<String> ids;
    public ArrayList<String> relation;

    public CustomerRelationRequest(String requestId, String customerId, ArrayList<String> ids, ArrayList<String> relation) {
        this.requestId = requestId;
        this.customerId = customerId;
        this.ids = ids;
        this.relation = relation;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public ArrayList<String> getIds() {
        return ids;
    }

    public ArrayList<String> getRelation() {
        return relation;
    }
    public HashMap<String, String> convertHash(){
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < ids.size(); i ++){
            map.put(ids.get(i),relation.get(i));
        }
        return map;
    }
    public static void main(String args[]){
        ArrayList<String> c = new ArrayList<>();
        c.add("1");
        ArrayList<String> d = new ArrayList<>();
        d.add("hello");
        CustomerRelationRequest request = new CustomerRelationRequest("1","22222",c,d);
        HashMap<String, String> map = request.convertHash();
        if (map.get("1") != null){
            System.out.print(100);
        }

    }
}
