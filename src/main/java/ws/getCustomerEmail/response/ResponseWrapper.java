package ws.getCustomerEmail.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;

@JsonPropertyOrder({"errorMessage", "errorCode"})
public class ResponseWrapper {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ArrayList<GetCustomerEmailResponse> response;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorMessage;

    public ResponseWrapper() {
        this.response = new ArrayList<>();
    }

    public ArrayList<GetCustomerEmailResponse> getResponse() {
        return response;
    }

    public void setResponse(ArrayList<GetCustomerEmailResponse> response) {
        this.response = response;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setOtherErr() {
        this.errorCode = "OTHERERR";
        this.errorMessage = "This is test error";
        this.response = null;
    }
}
