package pl.javastart.vatcalc;

class VatDto {
    private double nettoPrice;
    private double vat;
    private double bruttoPrice;

    public VatDto(double nettoPrice, double vat, double bruttoPrice) {
        this.nettoPrice = nettoPrice;
        this.vat = vat;
        this.bruttoPrice = bruttoPrice;
    }

    public double getNettoPrice() {
        return nettoPrice;
    }

    public void setNettoPrice(double nettoPrice) {
        this.nettoPrice = nettoPrice;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public double getBruttoPrice() {
        return bruttoPrice;
    }

    public void setBruttoPrice(double bruttoPrice) {
        this.bruttoPrice = bruttoPrice;
    }
}
