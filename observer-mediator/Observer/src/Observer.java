public interface Observer {
    public void setServerCondition(ServerCondition serverCondition);
    public void addCompany(Company company);
    public void update();
    public boolean isPartial();
    public boolean isPay();
    public void setPay(boolean b);
    public void setCompanyCount(int count);
}
