import java.util.ArrayList;

public class Premium implements Observer {

    private ServerCondition serverCondition;

    private ArrayList<Company> companyArrayList;

    private boolean partial;
    private int companyCount;

    public Premium(){
        this.partial = false;
        this.companyArrayList = new ArrayList<>();
        this.companyCount = 0;
    }

    @Override
    public boolean isPay() {
        return true;
    }

    public void setServerCondition(ServerCondition serverCondition){
        this.serverCondition = serverCondition;
    }

    @Override
    public void setPay(boolean b) {

    }

    @Override
    public void setCompanyCount(int count) {
        this.companyCount = count;
    }

    public void addCompany(Company company){
        this.companyArrayList.add(company);

    }

    public void update(){

        String newMessage =  serverCondition.getMsgForPremiumUser();

        if(newMessage != null) System.out.println(newMessage);

    }

    public boolean isPartial(){

        if(companyCount>1) {
            this.partial = true;
            return true;
        }
        return false;
    }
}
