package ws.getCustomerEmail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ws.getCustomerEmail.request.GetEmailRequest;
import ws.getCustomerEmail.request.RequestWrapper;
import ws.getCustomerEmail.response.EmailType;
import ws.getCustomerEmail.response.GetCustomerEmailResponse;
import ws.getCustomerEmail.response.ResponseWrapper;

import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class GetCustomerEmail2Controller {

    private static final Logger log = LoggerFactory.getLogger(GetCustomerEmail2Controller.class);
    private static final EmailSampleData data = new EmailSampleData();





    @Value("${ws.error:false}")
    private boolean wsError;


    @RequestMapping(value="/getCustomerEmail2", method = RequestMethod.POST)
    public ResponseEntity<ResponseWrapper>  getEmails(@RequestBody RequestWrapper request) {


        System.out.println("value WS Error:" + wsError);
        //request.stream().forEach(c -> c.setCustNo(c.getCustNo() + 1));

        //List<GetCustomerEmailResponse> response = new ArrayList<>();
        ResponseWrapper response = new ResponseWrapper();
        GetCustomerEmailResponse data = null;
        if (wsError) {
            response.setOtherErr();
        } else {
            HashMap<Integer, HashMap<Integer,GetCustomerEmailResponse>> map = getFakeData();
            for (GetEmailRequest requestData: request.getRequest()) {
                int storeNo = requestData.getStoreNo();
                int custNo = requestData.getCustNo();
                HashMap<Integer, GetCustomerEmailResponse> storeMap = map.get(storeNo);
                if (storeMap != null) {
                    data = storeMap.get(custNo);
                    if (data == null) {
                        data = new GetCustomerEmailResponse(custNo, storeNo);
                        data.setNoUser();
                    }
                } else {
                    data = new GetCustomerEmailResponse(custNo, storeNo);
                    data.setNoUser();
                }
                response.getResponse().add(data);
            }
        }

        return new ResponseEntity<ResponseWrapper>(response, HttpStatus.OK);
    }

    public HashMap<Integer,HashMap<Integer,GetCustomerEmailResponse>> getFakeData() {
        HashMap<Integer, HashMap<Integer, GetCustomerEmailResponse>> store = new HashMap<>();
        HashMap<Integer, GetCustomerEmailResponse> customer = new HashMap<>();

        int cust1 = 701531;
        int cust2 = 701532;
        int cust3 = 701533;
        int cust4 = 701534;
        int cust5 = 701535;
        int cust6 = 701536;
        int cust7 = 701537;
        int cst8 = 701888;
        int cst9 = 701999;
        int store1 = 6;
        GetCustomerEmailResponse obj1 = new GetCustomerEmailResponse(cust1, store1);
        obj1.setEmailType(getMockEmailType(SECONDARY_EMAIL.NONE));

        GetCustomerEmailResponse obj2 = new GetCustomerEmailResponse(cust2, store1);
        obj2.setEmailType(getMockEmailType(SECONDARY_EMAIL.SINGLE));

        GetCustomerEmailResponse obj3 = new GetCustomerEmailResponse(cust3, store1);
        obj3.setEmailType(getMockEmailType(SECONDARY_EMAIL.MULTIPLE));

        GetCustomerEmailResponse obj4 = new GetCustomerEmailResponse(cust4, store1);
        ArrayList<EmailType> emailType = new ArrayList<EmailType>();
        emailType.add(new EmailType("FAK"));
        obj4.setEmailType(emailType);

        GetCustomerEmailResponse obj5 = new GetCustomerEmailResponse(cust5, store1);
        obj5.setTooManyRows();

        GetCustomerEmailResponse obj6 = new GetCustomerEmailResponse(cust6, store1);
        EmailType et = new EmailType("FAK", "1234asdas@sdkaldk.ss");
        ArrayList<EmailType> list = new ArrayList<>();
        list.add(et);
        obj6.setEmailType(list);

        EmailType et7 = new EmailType(data.getNonExistingAddress(), data.getSingleNonExisting());
        GetCustomerEmailResponse obj7 = new GetCustomerEmailResponse(cust7, store1, et7);

        EmailType et8 = new EmailType(data.getNonExistingAddress(), data.getMultipleNonExisting());
        GetCustomerEmailResponse obj8 = new GetCustomerEmailResponse(cst8, store1, et8);

        EmailType et9 = new EmailType(data.getExistingAddress(), data.getMultipleMix());
        GetCustomerEmailResponse obj9 = new GetCustomerEmailResponse(cst9, store1, et9);



        customer.put(cust1, obj1);
        customer.put(cust2, obj2);
        customer.put(cust3, obj3);
        customer.put(cust4, obj4);
        customer.put(cust5, obj5);
        customer.put(cust6, obj6);
        customer.put(cust7, obj7);
        customer.put(cst8, obj8);
        customer.put(cst9, obj9);

        store.put(store1, customer);
        return store;
    }

    private ArrayList<EmailType> getMockEmailType(SECONDARY_EMAIL value) {

        ArrayList<EmailType> list = new ArrayList<>();
        //EmailType[] list = new EmailType[1];
        EmailType type = new EmailType("FAK","mm.dms3.test2@zoznam.sk");
        type.setSecondaryEmails(new ArrayList<>());
        if (value.equals(SECONDARY_EMAIL.SINGLE)) {
            type.getSecondaryEmails().add("jakub.rautner@interway.sk");
        } else if (value.equals(SECONDARY_EMAIL.MULTIPLE)) {
            type.getSecondaryEmails().add("jakub.rautner@interway.sk");
            type.getSecondaryEmails().add("kkdecopreco@kam.sksd");
            type.getSecondaryEmails().add("kksdkdkldecopreco@kam.sksd");
        }
        list.add(type);
        //list[0] = type;
        return list;
    }




    private enum SECONDARY_EMAIL {
        NONE, MULTIPLE, SINGLE
    }
}
