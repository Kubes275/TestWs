package ws.getCustomerEmail.request;

import java.util.ArrayList;
import java.util.List;

public class RequestWrapper {

    private List<GetEmailRequest> request;

    public RequestWrapper() {
        this.request = new ArrayList<>();
    }
    public RequestWrapper(List<GetEmailRequest> request) {
        this.request = request;
    }

    public List<GetEmailRequest> getRequest() {
        return request;
    }

    public void setRequest(List<GetEmailRequest> request) {
        this.request = request;
    }

}
