import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        ArrayList<OrderShakes> orderShakes = new ArrayList<OrderShakes>();

        int orderId = 0;
        int totalItem = 0;

        int chocolateShakeId = 0;
        int coffeeShakeId = 0;
        int strawberryShakeId = 0;
        int vanillaShakeId = 0;
        int zeroShakeId = 0;

        Scanner input = new Scanner(System.in);

        while(true)
        {
            System.out.println("To open an order press 'O' "+"\n"+
                                "To close an order press 'E' " +"\n");

            String orderType = input.nextLine();

            if(orderType.equals("E") && totalItem == 0)
            {
                System.out.println("Order At least one item ");
            }

            else if(orderType.equals("O"))
            {
                orderId++;

                OrderShakes orderShake = new OrderShakes(orderId);

                while (true)
                {
                    System.out.println("Items : "+"\n"+
                                        "Chocolate Shake"+"\n"+
                                        "Coffee Shake"+"\n"+
                                        "Strawberry Shake"+"\n"+
                                        "Vanilla Shake "+"\n"+
                                        "Zero Shake "+"\n");
                    String item = input.nextLine();

                    if(item.equals("Chocolate Shake"))
                    {
                        chocolateShakeId++;


                        ChocolateShake chocolateShake = new ChocolateShake(chocolateShakeId);

                        System.out.println("Enter Type ="+"\n");
                        String type = input.nextLine();

                        chocolateShake.setShakeType(type);

                        //else System.out.println("this item is not available");

                        System.out.println("Enter extra item: "+"\n");
                        String extraItem = input.nextLine();

                        chocolateShake.setShakeExtraItem(extraItem);

                        orderShake.addChocolateShake(chocolateShake);
                        totalItem++;

                        System.out.println("To exit the Order press E"+"\n");
                        String exit = input.nextLine();
                        if(exit.equals("E") && totalItem !=0) break;

                    }

                   else if(item.equals("Coffee Shake"))
                    {
                        coffeeShakeId++;
                        CoffeeShake coffeeShake = new CoffeeShake(coffeeShakeId);

                        System.out.println("Enter Type ="+"\n");
                        String type = input.nextLine();

                        coffeeShake.setShakeType(type);

                        //else System.out.println("this item is not available");

                        System.out.println("Enter extra item: "+"\n");
                        String extraItem = input.nextLine();

                        coffeeShake.setShakeExtraItem(extraItem);

                        orderShake.addCoffeeShake(coffeeShake);
                        totalItem++;

                        System.out.println("To exit the Order press E"+"\n");
                        String exit = input.nextLine();
                        if(exit.equals("E") && totalItem !=0) break;

                    }

                   else if(item.equals("Strawberry Shake"))
                    {
                        strawberryShakeId++;


                        StrawberryShake strawberryShake = new StrawberryShake(strawberryShakeId);

                        System.out.println("Enter Type ="+"\n");
                        String type = input.nextLine();

                        strawberryShake.setShakeType(type);

                        //else System.out.println("this item is not available");

                        System.out.println("Enter extra item: "+"\n");
                        String extraItem = input.nextLine();

                        strawberryShake.setShakeExtraItem(extraItem);

                        orderShake.addStrawberryShake(strawberryShake);
                        totalItem++;

                        System.out.println("To exit the Order press E"+"\n");
                        String exit = input.nextLine();
                        if(exit.equals("E") && totalItem !=0) break;

                    }

                   else if(item.equals("Vanilla Shake"))
                    {
                        vanillaShakeId++;


                       VanillaShake vanillaShake = new VanillaShake(vanillaShakeId);

                        System.out.println("Enter Type ="+"\n");
                        String type = input.nextLine();

                        vanillaShake.setShakeType(type);

                        //else System.out.println("this item is not available");

                        System.out.println("Enter extra item: "+"\n");
                        String extraItem = input.nextLine();

                        vanillaShake.setShakeExtraItem(extraItem);

                        orderShake.addVanillaShake(vanillaShake);
                        totalItem++;

                        System.out.println("To exit the Order press E"+"\n");
                        String exit = input.nextLine();
                        if(exit.equals("E") && totalItem !=0) break;

                    }

                    if(item.equals("Zero Shake"))
                    {
                        zeroShakeId++;


                       ZeroShake zeroShake = new ZeroShake(zeroShakeId);

                        System.out.println("Enter Type ="+"\n");
                        String type = input.nextLine();

                        zeroShake.setShakeType(type);

                        //else System.out.println("this item is not available");

                        System.out.println("Enter extra item: "+"\n");
                        String extraItem = input.nextLine();

                        zeroShake.setShakeExtraItem(extraItem);

                        orderShake.addZeroShake(zeroShake);
                        totalItem++;

                        System.out.println("To exit the Order press E"+"\n");
                        String exit = input.nextLine();
                        if(exit.equals("E") && totalItem !=0) break;

                    }

                    System.out.println("Want to add more items?");
                    String ans = input.nextLine();

                    if(ans.equals("no")) break;


                }

                orderShake.setTotalItem(totalItem);
                orderShakes.add(orderShake);
                for(OrderShakes or : orderShakes)
                {
                    or.PrintOrder();
                }

                totalItem =0;
                chocolateShakeId = 0;
                coffeeShakeId = 0;
                strawberryShakeId = 0;
                vanillaShakeId = 0;
                zeroShakeId = 0;
            }

            else
                System.out.println("Input correct symbols");
        }

    }
}
