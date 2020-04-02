import static java.lang.StrictMath.sqrt;

public class Triangle extends Shapes {

    private  double arm1;
    private double arm2;
    private double arm3;

    private String shapeName;

    private Computer com;

    public Triangle(Computer com,double arm1,double arm2,double arm3)
    {
        this.com = com;

        this.arm1 = arm1;

        this.arm2 = arm2;

        this.arm3 = arm3;

        this.shapeName = "triangle";

    }
    @Override
    public String getShapeName() {
        return shapeName;
    }

    @Override
    public double getPerimeter() {


        return arm1+arm2+arm3;
    }

    @Override
    public double getSurfaceArea() {

        double p = (arm1+arm2+arm3)/2.0 ;

        //p = p*(p-arm1)*(p-arm2)*(p-arm3);

        double area = Math.sqrt(p*(p-arm1)*(p-arm2)*(p-arm3));


        return p;
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
