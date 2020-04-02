import java.util.ArrayList;

public abstract class Company {
    private String companyName;
    private ArrayList<Observer> fullFacilityUsers;
    private ArrayList<Observer> partialFacilityUsers;

    public Company(){
        this.companyName = null;
        this.fullFacilityUsers = new ArrayList<>();
        this.partialFacilityUsers = new ArrayList<>();
    }

    public void addFullFacilityUsers(Observer obj){
        this.fullFacilityUsers.add(obj);
    }

    public void addPartialFacilityUsers(Observer obj){
        this.partialFacilityUsers.add(obj);
    }
}
