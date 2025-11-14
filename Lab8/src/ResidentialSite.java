public class ResidentialSite extends Site {
    private double tax;
    private double base;
    private double _units;
    private double _rate;

    public ResidentialSite () {
        _units = 0;
        _rate = 0;
    }

    @Override
    public double getBaseAmount() {
        base = _units * _rate;

        return base;
    }

    @Override
    public double getTaxAmount() {
        tax = base * Site.TAX_RATE;
        return tax;
    }
}
