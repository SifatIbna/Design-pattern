public class Rectangle extends Shapes {

    private double length;
    private double width;

    private String shapeName;

    private Computer computer;

    public Rectangle (Computer computer,double length,double width)
    {
        this.computer = computer;
        this.length = length;
        this.width = width;

        this.shapeName = "rectangle" ;
    }

    @Override
    public String getShapeName() {
        return shapeName;
    }

    @Override
    public double getPerimeter() {
        return 2*(length+width);
    }

    @Override
    public double getSurfaceArea() {
        return length*width;
    }

    @Override
    public String getComputerResolution() {
        return computer.getResolution();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
