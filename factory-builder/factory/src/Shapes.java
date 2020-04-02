public abstract class Shapes {

    public abstract String getShapeName();

    public abstract double getPerimeter();

    public abstract double getSurfaceArea();

    public abstract String getComputerResolution();

    public String toString()
    {
        return "Shape = "+this.getShapeName()+"\n"+
                "Resolution = "+this.getComputerResolution()+"\n"+
                "Surface Area = "+this.getSurfaceArea()+"\n"+
                "Perimeter = "+this.getPerimeter()+"\n" ;
    }
}
