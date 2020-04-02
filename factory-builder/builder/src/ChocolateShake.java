public class ChocolateShake implements ShakeBuilder {

    private double shakeId;

    private String shakeName;
    private String shakeType;
    private String shakeExtraItem;

    private double shakePrice;
    private double shakeTypePrice;
    private double shakeExtraItemPrice;
    private double shakeTotalPrice;

    public ChocolateShake(double id)
    {
        this.shakeId = id;
        this.shakeName = "Chocolate Shake";
        this.shakePrice = 230;


    }

    public void setShakeId(double id) {
        this.shakeId = id;

    }

    @Override
    public void setShakeType(String type) {
        this.shakeType = type;

        if(type.equals("lactose_free")) this.shakeTypePrice = 60;

        else if(type.equals("milk")) this.shakeTypePrice = 0;

        else System.out.println("Item not Available");
    }

    @Override
    public void setShakeExtraItem(String item) {

        this.shakeExtraItem = item;

        if(item.equals("candy")) this.shakeExtraItemPrice = 50;
        else if (item.equals("cookie")) this.shakeExtraItemPrice = 40;

        else System.out.println("This item is not available");

    }

    @Override
    public String getShakeName() {
        return shakeName;
    }

    @Override
    public double getShakeTypePrice() {
        return shakeTypePrice;
    }

    @Override
    public double getShakeExtraItemPrice() {
        return shakeExtraItemPrice;
    }

    @Override
    public double getShakePrice() {
        return shakePrice;
    }

    @Override
    public String getShakeType() {
        return shakeType;
    }

    @Override
    public String getShakeExtraItem() {
        return shakeExtraItem;
    }

    @Override
    public double getTotalPrice() {

        shakeTotalPrice = shakePrice+shakeTypePrice+shakeExtraItemPrice;

        return shakeTotalPrice;
    }

    @Override
    public double getShakeId() {
        return shakeId;
    }

    @Override
    public String toString() {
        return "Shake Id = "+this.getShakeId()+"\n"+
                "Shake Name = "+this.getShakeName()+"\n"+
                "Shake Type = "+this.getShakeType()+"\n"+
                "Shake Extra Item = "+this.getShakeExtraItem()+"\n"+
                "Shake Price = "+this.getShakePrice()+"\n"+
                "Shake Type Price = "+this.getShakeTypePrice()+"\n"+
                "Shake Extra Item Price = "+this.getShakeExtraItemPrice()+"\n"+
                "Total Price = "+this.getTotalPrice()+"\n";
    }
}
