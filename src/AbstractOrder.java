import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractOrder {
    private List<AbstractProduct> products = new ArrayList<AbstractProduct>();
    public abstract void AddProduct(String ProductName, Integer ProductQty, BigDecimal ProductPrice, List<TAX> Taxes);
    public abstract void PrintReceipt();
    public abstract void PrintLine();
    protected abstract BigDecimal GetTotal();
    protected abstract BigDecimal GetTotalDuty();
    protected abstract BigDecimal RoundValues(BigDecimal value);

}