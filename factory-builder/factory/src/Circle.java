public class Circle extends Shapes{

    private String shapeName;

    private double radius;

    private Computer com;

    public Circle(Computer com,double radius)
    {

        this.com = com;
        this.radius = radius;
        this.shapeName = "circle";
    }


    @Override
    public String getShapeName() {
        return shapeName;
    }

    @Override
    public double getPerimeter() {

        double per = 2*3.1416*radius;
        return per;
    }

    @Override
    public double getSurfaceArea() {

        double area = 3.1416*radius*radius ;
        return area;
    }

    @Override
    public String getComputerResolution() {
        return com.getResolution();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
