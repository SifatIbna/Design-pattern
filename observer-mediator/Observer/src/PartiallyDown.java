import java.util.ArrayList;

public class PartiallyDown implements ServerCondition {

    private ServerCondition previousServerCondition ;

    private Observer premiumUser;
    private Observer regularUser;

    private String msgForPremiumUser;
    private String msgForRegularUser;

    private final Object object = new Object();

    public PartiallyDown(){
        premiumUser = new Premium();
        regularUser = new Regular();
    }

    public void setPreviousServerCondition(ServerCondition serverCondition){
        this.previousServerCondition = serverCondition;
    }

    public void addPremiumObserver(Observer obj) {
        synchronized (object) {
            this. premiumUser = obj;
        }
    }

    public void addRegularObserver(Observer obj) {
        synchronized (object) {
             regularUser = obj;
        }
    }

    public void notifyPremiumObserver() {
        synchronized (object) {
            premiumUser.update();
        }
    }

    public void notifyRegularObserver() {
        synchronized (object) {
            this.regularUser.update();
        }
    }

    public String getMsgForRegularUser(){
        return this.msgForRegularUser;
    }

    public String getMsgForPremiumUser(){
        return this.msgForPremiumUser;
    }

    @Override
    public void setMsgForRegularUser(String msg) {
        this.msgForRegularUser = msg;
    }

    @Override
    public void setMsgForPremiumUser(String msg) {
        this.msgForPremiumUser = msg;
    }

    public void postMessageRegularUser(){

     //   notifyPremiumObserver();
        notifyRegularObserver();
    }

    public void postMessagePremiumUser(){

        notifyPremiumObserver();
    }
}
