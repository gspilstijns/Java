
import java.util.*;
import java.util.stream.Collectors;

public class LambdasAndExpressions {



    public static void main(String[] args) {
        List<Invoice> invoices =  new ArrayList<>();

        invoices.add ( new Invoice ( "83" , "Elektrische schuurmachine" , 7 , 57.98 ));
        invoices.add ( new Invoice ( "24" , "Power zaag" , 18 , 99.99 ));
        invoices.add ( new Invoice ( "7" , "Voor Hamer" , 11 , 21.50 ));
        invoices.add ( new Invoice ( "77" , "Hamer" , 76 , 11.99 ));
        invoices.add ( new Invoice ( "39" , "Grasmaaier" , 3 , 79.50 ) );
        invoices.add ( new Invoice ( "68" , "Schroevendraaier" , 16 , 6.99 ) );
        invoices.add ( new Invoice ( "56" , "Decoupeer zaag" , 21 , 11.00 ) );
        invoices.add ( new Invoice ( "3" , "Moersleutel" , 34 , 7.50 ));


        //sort based on quantity
       invoices.sort ( Comparator.comparingInt ( Invoice::getQuantity ) );
        invoices.forEach ( System.out::println);
        System.out.println ("--------------------------------------------------------------------------" );
        //sort based on partDescription
       invoices.sort ( Comparator.comparing ( Invoice::getPartDescription ) );
       invoices.forEach ( System.out::println );
        System.out.println ("--------------------------------------------------------------------------" );

       invoices.stream ().sorted (Comparator.comparingDouble (Invoice::getPricePerItem  )).forEach ( i -> System.out.println ( i.getPricePerItem () +  ", " + i.getPartDescription() ) );
        System.out.println ("--------------------------------------------------------------------------" );

        Map <String, Integer> map = invoices.stream().collect( Collectors.toMap(Invoice::getPartDescription, Invoice::getQuantity));
        map.entrySet().stream().sorted( Map.Entry.comparingByValue ( ) ).forEach( System.out::println );
        System.out.println ("--------------------------------------------------------------------------" );
        Map <String, Double> mapAmmount = invoices.stream().collect(Collectors.toMap(Invoice::getPartDescription, Invoice::getInvoiceAmount));
        mapAmmount.entrySet ().stream().sorted( Map.Entry.comparingByValue ( ) ).forEach( i -> System.out.println(i.getKey() + "=" + String.format("%.2f", i.getValue())));
        System.out.println ("--------------------------------------------------------------------------" );

        invoices.stream().filter(e->e.getInvoiceAmount()>=200 && e.getInvoiceAmount()<=500)
                .collect(Collectors.toMap(Invoice::getPartDescription, Invoice::getInvoiceAmount))
                .entrySet ()
                .stream()
                .sorted( Map.Entry.comparingByValue ( ) )
                .forEach(i -> System.out.println(i.getKey() + "=" + String.format("%.2f", i.getValue())));
    }
}
