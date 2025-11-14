public class LifelineSite extends Site {
    private double tax;
    private double base;
    private double _units;
    private double _rate;

    public LifelineSite() {
        _units = 0;
        _rate = 0;
    }

    @Override
    public double getBaseAmount() {
        base = _units * _rate * 0.5;

        return base;
    }

    @Override
    public double getTaxAmount() {
        tax = base * Site.TAX_RATE * 0.2;
        return tax;
    }
}
