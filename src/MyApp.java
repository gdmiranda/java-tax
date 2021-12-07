import java.math.BigDecimal;
import java.util.Arrays;

public class MyApp {

    public static void main(String[] args) {
        // INPUT Input 1: 1 book at 12.49 1 music CD at 14.99 1 chocolate bar at 0.85
        //Output 1: 1 book: 12.49 1 music CD: 16.49 1 chocolate bar: 0.85 Sales Taxes: 1.50 Total: 29.83
       AbstractOrder Order1 = new Order();
        Order1.AddProduct("1 book",1,new BigDecimal(12.49),Arrays.asList(TAX.EXEMPTIONS));
        Order1.AddProduct("1 music CD",1,new BigDecimal(14.99),Arrays.asList(TAX.BASIC));
        Order1.AddProduct("1 chocolate bar",1,new BigDecimal(0.85),Arrays.asList(TAX.EXEMPTIONS));
        Order1.PrintReceipt();

        //Input 2: 1 imported box of chocolates at 10.00 1 imported bottle of perfume at 47.50
        //Output 2: 1 imported box of chocolates: 10.50 1 imported bottle of perfume: 54.65 Sales Taxes: 7.65 Total: 65.15

        AbstractOrder Order2 = new Order();
        Order2.AddProduct("1 imported box of chocolates",1,new BigDecimal(10.00),Arrays.asList(TAX.EXEMPTIONS,TAX.IMPORTED));
        Order2.AddProduct("1 imported bottle of perfume",1,new BigDecimal(47.50),Arrays.asList(TAX.BASIC,TAX.IMPORTED));

        Order2.PrintLine();
        Order2.PrintReceipt();

        //Input 3: 1 imported bottle of perfume at 27.99 1 bottle of perfume at 18.99 1 packet of headache pills at 9.75 1 imported box of chocolates at 11.25
        //Output 3: 1 imported bottle of perfume: 32.19 1 bottle of perfume: 20.89 1 packet of headache pills: 9.75 1 imported box of chocolates: 11.85 Sales Taxes: 6.70 Total: 74.68

        AbstractOrder Order3 = new Order();
        Order3.AddProduct("1 imported bottle of perfume",1,new BigDecimal(27.99),Arrays.asList(TAX.BASIC,TAX.IMPORTED));
        Order3.AddProduct("1 bottle of perfume",1,new BigDecimal(18.99),Arrays.asList(TAX.BASIC));
        Order3.AddProduct("1 packet of headache pills",1,new BigDecimal(9.75),Arrays.asList(TAX.EXEMPTIONS));
        Order3.AddProduct("imported box of chocolates",1,new BigDecimal(11.25),Arrays.asList(TAX.EXEMPTIONS,TAX.IMPORTED));
        Order3.PrintLine();
        Order3.PrintReceipt();




    }

}