package ws.getCustomerEmail.response;

import java.util.ArrayList;

public class EmailType {

    private String type;
    private String primaryEmail;
    private ArrayList<String> secondaryEmails;

    public EmailType(String type, String primaryEmail) {
        this.type = type;
        this.primaryEmail = primaryEmail;
        this.secondaryEmails = new ArrayList<>();
    }

    public EmailType() {
        this.type = "FAK";
        this.primaryEmail = null;
        this.secondaryEmails = new ArrayList<>();
    }

    public EmailType(String primaryAdress) {
        this.type = "FAK";
        this.primaryEmail = primaryAdress;
        this.secondaryEmails = new ArrayList<>();
    }

    public EmailType(String primaryAdress, ArrayList<String> secondaryEmails) {
        this.type = "FAK";
        this.primaryEmail = primaryAdress;
        this.secondaryEmails = secondaryEmails;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public ArrayList<String> getSecondaryEmails() {
        return secondaryEmails;
    }

    public void setSecondaryEmails(ArrayList<String> secondaryEmails) {
        this.secondaryEmails = secondaryEmails;
    }
}
