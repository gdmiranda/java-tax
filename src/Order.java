import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Order extends AbstractOrder {

    private List<AbstractProduct> products = new ArrayList<AbstractProduct>();
    public void AddProduct(String ProductName, Integer ProductQty, BigDecimal ProductPrice,List<TAX> Taxes) {
        this.products.add(new Product(ProductName,ProductQty,ProductPrice,Taxes));

    }
    public void PrintReceipt() {
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%s : %.2f\n",products.get(i).getProductName(), products.get(i).getProductTotalPrice());
        }
        System.out.printf("%s : %.2f\n","Sales Taxes: ",this.GetTotalDuty());
        System.out.printf("%s : %.2f\n","Total: ",this.GetTotal());

    }
    protected BigDecimal GetTotal( ){

        BigDecimal Total = new BigDecimal(0.0);
        for (int i = 0; i < products.size(); i++) {

            Total = Total.add(products.get(i).getProductTotalPrice());
        }

       return Total;



    }
    protected BigDecimal GetTotalDuty( ){
        BigDecimal TotalDuty = new BigDecimal(0.0);
        for (int i = 0; i < products.size(); i++) {
            TotalDuty =  TotalDuty.add(products.get(i).getDuty());
        }

        return TotalDuty;

    }
    protected BigDecimal RoundValues(BigDecimal value) {
        value =  value.divide(new BigDecimal("0.05"));
        value = new BigDecimal(Math.ceil(value.doubleValue()));
        value = value.multiply(new BigDecimal("0.05"));
        return value;
    }
    public void PrintLine() {
        System.out.println("------------------------------------------" );
    }

}