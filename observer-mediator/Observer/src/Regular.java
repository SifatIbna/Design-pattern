import java.util.ArrayList;

public class Regular implements Observer {

    private ServerCondition serverCondition;
    private ArrayList<Company> companyArrayList;

    private int companyCount;
    private boolean isPay;

    public Regular(){
        this.companyArrayList = new ArrayList<>();
        isPay = false;
        this.companyCount = 1;
    }

    public void setPay(boolean b){
        this.isPay = b;
    }

    @Override
    public void setServerCondition(ServerCondition serverCondition) {
        this.serverCondition = serverCondition;
        serverCondition.addRegularObserver(this);
    }

    @Override
    public void addCompany(Company company) {
        companyArrayList.add(company);
    }

    @Override
    public void setCompanyCount(int count) {
        this.companyCount = count;
    }

    @Override
    public void update() {
//        String newMessage =(String) serverCondition.getMsgForRegularUser();
        //if(.equals(null)) System.out.println("No new Message");
        String newMessage = serverCondition.getMsgForRegularUser();

        if (newMessage != null) System.out.println(newMessage);
    }

    @Override
    public boolean isPartial() {
        if (isPay()) return true;
        return false;
    }

    @Override
    public boolean isPay() {
        return isPay;
    }
}
