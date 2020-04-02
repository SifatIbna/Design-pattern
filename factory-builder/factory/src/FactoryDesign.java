public class FactoryDesign {

    public static void main(String[] args) {

        Computer computerB = Factory.getComputer("2.4 Ghz","500GB","ComputerB","350 250");
        Computer computerA = Factory.getComputer("2.6GHz","600GB","ComputerB","200 200");
        Computer computerC = Factory.getComputer("2.2GHz","1TB","ComputerC","550 450");

        Shapes shape1 = Factory.getShape(computerB,"triangle",1,1,1);
        Shapes shape2 = Factory.getShape(computerA,"circle",5);
        Shapes shape3 = Factory.getShape(computerC,"rectangle",23,26);
        Shapes shape4 = Factory.getShape(computerA,"square",45);


        System.out.println(shape1);
        System.out.println(shape2);
        System.out.println(shape3);
        System.out.println(shape4);



        //System.out.println(computerB);
    }
}
