public class PC extends Computer {

    private String CPU;
    private String MMU;
    private String Name;
    private String Resolution;

    public PC(String CPU,String MMU,String Name,String Resolution)
    {
        this.CPU = CPU;
        this.MMU = MMU;
        this.Name = Name;
        this.Resolution = Resolution;
    }

    @Override
    public String getCPU() {
        return CPU;
    }

    @Override
    public String getMMU() {
        return MMU;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public String getResolution() {
        return Resolution;
    }
}
