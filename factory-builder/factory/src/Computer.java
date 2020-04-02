public abstract class Computer {

    public abstract String getCPU();
    public abstract String getMMU();
    public abstract String getName();
    public abstract String getResolution();

    public String toString()
    {
        return "Resolution= "+this.getResolution()+"\n"+
                "CPU = "+this.getCPU()+"\n"+
                "MMU = "+this.getMMU()+"\n"+
                "Name = "+this.getName()+"\n";
    }
}
