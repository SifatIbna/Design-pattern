import java.util.ArrayList;

public class OrderShakes {

    private int orderId ;
    private int totalItem;

    private ArrayList<ChocolateShake> chocolateShakes;
    private ArrayList<CoffeeShake> coffeeShakes;
    private ArrayList<StrawberryShake> strawberryShakes;
    private ArrayList<VanillaShake> vanillaShakes;
    private ArrayList<ZeroShake> zeroShakes;



    public OrderShakes(int orderId)
    {
        this.orderId = orderId;

        chocolateShakes = new ArrayList<ChocolateShake>();
        coffeeShakes = new ArrayList<CoffeeShake>();
        strawberryShakes = new ArrayList<StrawberryShake>();
        vanillaShakes = new ArrayList<VanillaShake>();
        zeroShakes =  new ArrayList<ZeroShake>();
    }

    public void setTotalItem(int item)
    {
        this.totalItem = item;
    }

    public int getTotalItem()
    {
        return totalItem;
    }

    public int getOrderId()
    {
        return orderId;
    }

    public void addChocolateShake(ChocolateShake chocolateShake)

    {
        this.chocolateShakes.add(chocolateShake);
    }

    public void addCoffeeShake(CoffeeShake coffeeShake)
    {
        this.coffeeShakes.add(coffeeShake);
    }

    public void addStrawberryShake(StrawberryShake strawberryShake)
    {
        this.strawberryShakes.add(strawberryShake);
    }

    public void addVanillaShake(VanillaShake vanillaShake)
    {
        this.vanillaShakes.add(vanillaShake);
    }

    public void addZeroShake(ZeroShake zeroShake)
    {
        this.zeroShakes.add(zeroShake);
    }

    public void PrintOrder()
    {
        System.out.println("Order Id = "+orderId);

        for (ChocolateShake ch:chocolateShakes)
        {
            System.out.println(ch);
        }

        for (StrawberryShake st : strawberryShakes)
        {
            System.out.println(st);
        }

        for (CoffeeShake co : coffeeShakes)
        {
            System.out.println(co);
        }

        for(VanillaShake va : vanillaShakes)
        {
            System.out.println(va);
        }

        for (ZeroShake ze : zeroShakes)
        {
            System.out.println(ze);
        }

        System.out.println("Total Item = "+totalItem);


    }
}
