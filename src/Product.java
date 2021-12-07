import java.math.BigDecimal;
import java.util.List;

public class Product extends AbstractProduct {

    public Product(String ProductName, Integer ProductQty, BigDecimal ProductPrice, List<TAX> Taxes) {

        super(ProductName,ProductQty,ProductPrice,Taxes);
    }

}