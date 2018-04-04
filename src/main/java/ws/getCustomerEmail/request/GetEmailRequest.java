package ws.getCustomerEmail.request;

import java.util.ArrayList;
import java.util.List;

public class GetEmailRequest {

    private List<String> emailType;
    private int custNo;
    private int storeNo;

    public GetEmailRequest() {
        this.emailType = new ArrayList<>();
        emailType.add("FAK");
    }

    public List<String> getEmailType() {
        return emailType;
    }

    public void setEmailType(List<String> emailType) {
        this.emailType = emailType;
    }

    public int getCustNo() {
        return custNo;
    }

    public void setCustNo(int custNo) {
        this.custNo = custNo;
    }

    public int getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(int storeNo) {
        this.storeNo = storeNo;
    }
}
