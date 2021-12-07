import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public abstract class AbstractProduct {

    private String ProductName;
    private Integer ProductQty;
    private BigDecimal ProductPrice;
    private BigDecimal Duty = new BigDecimal("0.00");
    private BigDecimal ProductTotalPrice;

    public AbstractProduct(String ProductName, Integer ProductQty, BigDecimal ProductPrice, List<TAX> Taxes ) {
        this.ProductName = ProductName;
        this.ProductQty = ProductQty;
        this.ProductPrice = ProductPrice;
        this.Duty = CalculateDuty(Taxes);
    }

    public String getProductName() {
        return ProductName;
    }
    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public Integer getProductQty() {
        return ProductQty;
    }
    public void setProductQty(Integer ProductQty) {
        this.ProductQty = ProductQty;
    }

    public BigDecimal getProductPrice() {
        return ProductPrice;
    }
    public BigDecimal getDuty() {
        return Duty;
    }
    public void setProductPrice(BigDecimal ProductPrice) {
        this.ProductPrice = ProductPrice;
    }
    public BigDecimal getProductTotalPrice() {
        BigDecimal c = new BigDecimal(0.0);
        c = this.getProductPrice().add(this.getDuty());
       this.ProductTotalPrice = c;
       return this.ProductTotalPrice;
    }

    public BigDecimal CalculateDuty(List<TAX> Taxes ) {
        BigDecimal c = new BigDecimal(0.0);
        for (int i = 0; i < Taxes.size(); i++) {

            switch (Taxes.get(i).ValueEnum){
                case 0:
                    c = this.getProductPrice().multiply(new BigDecimal(0.10));
                    c = c.divide(new BigDecimal("0.05"));
                    c = new BigDecimal(Math.ceil(c.doubleValue()));
                    c = c.multiply(new BigDecimal("0.05"));
                    this.Duty =this.Duty.add(c);
                   break;
                case 1:
                    c = this.getProductPrice().multiply(new BigDecimal(0.05));
                    c = c.divide(new BigDecimal("0.05"));
                    c = new BigDecimal(Math.ceil(c.doubleValue()));
                    c = c.multiply(new BigDecimal("0.05"));
                    this.Duty =this.Duty.add(c);
                    break;
                case 2:
                    c = this.getProductPrice().multiply(new BigDecimal(0.00));
                    this.Duty =this.Duty.add(c);
                    break;
            }

        }

        return this.Duty;
    }

}
