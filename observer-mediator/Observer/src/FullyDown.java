import java.util.ArrayList;

public class FullyDown implements ServerCondition {
    private ServerCondition previousServerCondition;

    private Observer premiumUser;
    private Observer regularUser;

    private String msgForRegularUser;
    private String msgForPremiumUser;

    @Override
    public void setPreviousServerCondition(ServerCondition serverCondition) {
        this.previousServerCondition = serverCondition;
    }

    @Override
    public void addPremiumObserver(Observer obj) {
        this.premiumUser=obj;

    }

    @Override
    public void addRegularObserver(Observer obj) {
        this.regularUser = obj;
    }

    @Override
    public void notifyPremiumObserver() {
        premiumUser.update();
    }

    @Override
    public void notifyRegularObserver() {
        regularUser.update();
    }

    @Override
    public void setMsgForRegularUser(String msg) {
        this.msgForRegularUser = msg;
    }

    @Override
    public void setMsgForPremiumUser(String msg) {
        this.msgForPremiumUser = msg;
    }

    @Override
    public String getMsgForRegularUser() {
        return this.msgForRegularUser;
    }

    @Override
    public String getMsgForPremiumUser() {
        return this.msgForPremiumUser;
    }

    @Override
    public void postMessageRegularUser() {
        notifyRegularObserver();
    }

    @Override
    public void postMessagePremiumUser() {
        notifyPremiumObserver();
    }

}
