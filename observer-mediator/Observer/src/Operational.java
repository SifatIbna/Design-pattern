import java.util.ArrayList;

public class Operational implements ServerCondition  {
    private ServerCondition previousCondition;

    private Observer premiumUser;
    private Observer regularUser;

    private String msgForPremiumUser;
    private String msgForRegularUser;

    private final Object object = new Object();

    @Override
    public void setMsgForRegularUser(String msg) {
        this.msgForRegularUser = msg;
    }

    @Override
    public void setMsgForPremiumUser(String msg) {
        this.msgForPremiumUser = msg;
    }

    public Operational(){
        premiumUser = new Premium();
        regularUser = new Regular();
        msgForRegularUser = null;
        msgForPremiumUser = null;
    }

    public void setPreviousServerCondition(ServerCondition previousCondition){
        this.previousCondition = previousCondition;
    }

    public void addPremiumObserver(Observer obj){
        this.premiumUser = obj;
    }

    public void addRegularObserver(Observer obj){
         this.regularUser = obj;
    }

    @Override
    public void notifyPremiumObserver() {
        synchronized (object) {
            this.premiumUser.update();
        }
    }

    @Override
    public void notifyRegularObserver() {
        synchronized (object) {
            this.regularUser.update();
        }
    }

    public String getMsgForPremiumUser(){
        return this.msgForPremiumUser;
    }

    public String getMsgForRegularUser(){
        return this.msgForRegularUser;
    }

    public void postMessageRegularUser(){

         //   msgForRegularUser = "Your Cost is : X$ ";

            notifyRegularObserver();
    }

    public void postMessagePremiumUser(){
        notifyPremiumObserver();
    }
}
