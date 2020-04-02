import java.util.ArrayList;

public class DEF_Company extends Company {
    private String companyName;
    private ArrayList<Observer> fullFacilityUserList;
    private ArrayList<Observer> partialFacilityUserList;

    public DEF_Company(){
        this.companyName = "DEF";
        this.fullFacilityUserList = new ArrayList<>();
        this.partialFacilityUserList = new ArrayList<>();
    }

    public void addFullFacilityUsers(Observer obj){
        this.fullFacilityUserList.add(obj);
    }

    public void addPartialFacilityUsers(Observer obj){
        this.partialFacilityUserList.add(obj);
    }
}
