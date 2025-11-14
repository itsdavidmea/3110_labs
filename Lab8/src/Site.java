public  abstract class Site {

    protected static final double TAX_RATE = 20.0;

    public Site() {

    }


    public double getBillableAmount() {
        return getBaseAmount() + getTaxAmount();
    }

    public double getBaseAmount(){};

    public double getTaxAmount(){};

}