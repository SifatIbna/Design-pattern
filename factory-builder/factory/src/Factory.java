public class Factory {


    private static String [] split;
    private static int length;
    private static int width;

    public static Computer getComputer(String CPU,String MMU,String Name,String resolution)
    {
        split = resolution.split(" ");
        length = Integer.parseInt(split[0]);
        width = Integer.parseInt(split[1]);

        return new PC(CPU,MMU,Name,resolution);

    }


    public static Shapes getShape(Computer computer,String shape,double len) {



        if (shape.equals("circle") && len>0 && len<=length && len<=width) {
            return new Circle(computer, len);
        }

        else if(shape.equals("square")&& len>0 && len <=length && len <= width){
            return new Square(computer,len);
        }

        return null;
    }

    public static Shapes getShape(Computer computer,String shape,double len,double wid) {

        if(shape.equals("rectangle")) {
            if (len > 0 && width > 0 && len <= length && wid <= width) {
                return new Rectangle(computer, len, wid);
            }
        }

        return null;
    }


    public static Shapes getShape(Computer computer,String shape,double arm1,double arm2,double arm3)
    {   if(shape.equals("triangle")) {
        if (arm1 > 0 && arm2 > 0 && arm3 > 0) {
            if (arm1 <= length && arm1 <= width) {
                if (arm2 <= length && arm2 <= width) {
                    if (arm3 <= length && arm3 <= width) {
                        if (arm1 + arm2 > arm3 || arm1 + arm3 > arm2 || arm2 + arm3 > arm1) {
                            return new Triangle(computer, arm1, arm2, arm3);
                        }
                    }
                }
            }
        }
    }

        return null;

    }
}
