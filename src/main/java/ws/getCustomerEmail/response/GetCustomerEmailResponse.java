package ws.getCustomerEmail.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

public class GetCustomerEmailResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorMessage;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer storeNo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer custNo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ArrayList<EmailType> emailType;

    public GetCustomerEmailResponse() {

    }
    public GetCustomerEmailResponse(int custNo, int storeNo) {
        this.storeNo = storeNo;
        this.custNo = custNo;
    }

    public GetCustomerEmailResponse(int custNo, int storeNo, EmailType et) {
        this.storeNo = storeNo;
        this.custNo = custNo;
        this.emailType = new ArrayList<>();
        this.emailType.add(et);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Integer getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(Integer storeNo) {
        this.storeNo = storeNo;
    }

    public Integer getCustNo() {
        return custNo;
    }

    public void setCustNo(Integer custNo) {
        this.custNo = custNo;
    }

    public ArrayList<EmailType> getEmailType() {
        return emailType;
    }

    public void setEmailType(ArrayList<EmailType> emailType) {
        this.emailType = emailType;
    }

    public void setNoUser() {
        this.errorCode = "NOUSER";
        this.errorMessage = "No user found";
    }

    public void setTooManyRows() {
        this.errorCode = "TOOMANYROWS";
        this.errorMessage = "Too many rows";
    }

}
