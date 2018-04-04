package ws.getCustomerEmail;

import java.util.ArrayList;

public class EmailSampleData {

    public ArrayList<String> getSingleExisting() {
        ArrayList<String> list = new ArrayList<>();
        list.add("mm.dms3.test2@zoznam.sk");
        return list;
    }

    public ArrayList<String> getSingleNonExisting() {
        ArrayList<String> list = new ArrayList<>();
        list.add("kdebolo@sadkkaksjd.sk");
        return list;
    }

    public ArrayList<String> getMultipleExisting() {
        ArrayList<String> list = new ArrayList<>();
        list.add("mm.dms3.test2@zoznam.sk");
        list.add("mm.dms3.test@zoznam.sk");
        list.add("jakub.rautner@interway.sk");
        return list;
    }

    public ArrayList<String> getMultipleNonExisting() {
        ArrayList<String> list = new ArrayList<>();
        list.add("dasdaad22323232d@zoznam.sk");
        list.add("mm.dms3.test@zsadadad.ec");
        list.add("jakub.rautner@dfdasdwwa.ss");
        return list;
    }

    public ArrayList<String> getMultipleMix() {
        ArrayList<String> list = new ArrayList<>();
        list.add("dasdaad22323232d@zoznam.sk");
        list.add("mm.dms3.test2@zoznam.sk");
        list.add("jakub.rautner@dfdasdwwa.ss");
        return list;
    }

    public String getNonExistingAddress() {
        String address = "mm.dms3.test@zsadadad.ec";
        return address;
    }

    public String getExistingAddress() {
        String address = "mm.dms3.test2@zoznam.sk";
        return address;
    }

}
