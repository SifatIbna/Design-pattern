public class Square extends Shapes {

    private String shapeName;

    private double armLength;

    private Computer computer;

    public Square (Computer computer,double armLength)
    {
        this.computer = computer;
        this.armLength = armLength;
        this.shapeName = "square" ;
    }

    @Override
    public String getShapeName() {
        return shapeName;
    }

    @Override
    public double getPerimeter() {
        return 4*armLength;
    }

    @Override
    public double getSurfaceArea() {
        return armLength*armLength;
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
