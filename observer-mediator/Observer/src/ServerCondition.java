public interface ServerCondition {
    public void setPreviousServerCondition(ServerCondition serverCondition);
    public void addPremiumObserver(Observer obj);
    public void addRegularObserver(Observer obj);
    public void notifyPremiumObserver();
    public void notifyRegularObserver();
    public String getMsgForRegularUser();
    public String getMsgForPremiumUser();
    public void postMessageRegularUser();
    public void postMessagePremiumUser();
    public void setMsgForRegularUser(String msg);
    public void setMsgForPremiumUser(String msg);
}
