import java.util.ArrayList;

public class ABC_Company extends Company {
    private String companyName;
    private ArrayList<Observer> fullFacilityUserList;
    private ArrayList<Observer> partialFacilityUserList;

    public ABC_Company(){
        this.companyName = "ABC";
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
