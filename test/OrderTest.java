import junit.framework.TestCase;
import org.junit.Assert;

import java.math.BigDecimal;
import java.util.Arrays;

public class OrderTest extends TestCase {

    public void testAddProduct1() {
        AbstractOrder Order1 = new Order();
        Order1.AddProduct("1 book",1,new BigDecimal(12.49),Arrays.asList(TAX.EXEMPTIONS));
        Order1.AddProduct("1 music CD",1,new BigDecimal(14.99),Arrays.asList(TAX.BASIC));
        Order1.AddProduct("1 chocolate bar",1,new BigDecimal(0.85),Arrays.asList(TAX.EXEMPTIONS));

        Assert.assertEquals(1.50,Order1.GetTotalDuty().doubleValue(),0.0);


    }
    public void testAddProduct2() {
        AbstractOrder Order2 = new Order();
        Order2.AddProduct("1 imported box of chocolates",1,new BigDecimal(10.00),Arrays.asList(TAX.EXEMPTIONS,TAX.IMPORTED));
        Order2.AddProduct("1 imported bottle of perfume",1,new BigDecimal(47.50),Arrays.asList(TAX.BASIC,TAX.IMPORTED));

        Assert.assertEquals(7.65,Order2.GetTotalDuty().doubleValue(),0.0);


    }

    public void testAddProduct3() {
        AbstractOrder Order3 = new Order();
        Order3.AddProduct("1 imported bottle of perfume",1,new BigDecimal(27.99),Arrays.asList(TAX.BASIC,TAX.IMPORTED));
        Order3.AddProduct("1 bottle of perfume",1,new BigDecimal(18.99),Arrays.asList(TAX.BASIC));
        Order3.AddProduct("1 packet of headache pills",1,new BigDecimal(9.75),Arrays.asList(TAX.EXEMPTIONS));
        Order3.AddProduct("imported box of chocolates",1,new BigDecimal(11.25),Arrays.asList(TAX.EXEMPTIONS,TAX.IMPORTED));

        Assert.assertEquals(6.70,Order3.GetTotalDuty().doubleValue(),0.0);


    }

}