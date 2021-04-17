
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdasAndExpressions {


    public static void main ( String[] args ) {
        List < Invoice > invoices = new ArrayList <> ( );

        invoices.add ( new Invoice ( "83" , "Elektrische schuurmachine" , 7 , 57.98 ) );
        invoices.add ( new Invoice ( "24" , "Power zaag" , 18 , 99.99 ) );
        invoices.add ( new Invoice ( "7" , "Voor Hamer" , 11 , 21.50 ) );
        invoices.add ( new Invoice ( "77" , "Hamer" , 76 , 11.99 ) );
        invoices.add ( new Invoice ( "39" , "Grasmaaier" , 3 , 79.50 ) );
        invoices.add ( new Invoice ( "68" , "Schroevendraaier" , 16 , 6.99 ) );
        invoices.add ( new Invoice ( "56" , "Decoupeer zaag" , 21 , 11.00 ) );
        invoices.add ( new Invoice ( "3" , "Moersleutel" , 34 , 7.50 ) );


        System.out.println ( "--------------------------------------------------------------------------" );
        System.out.println ( "a)  Gebruik lambdas and streams om de Invoice objects te sorteren volgens PartDescription, en toon de resultaten." );
        System.out.println ( "--------------------------------------------------------------------------" );

        //Nieuwe method "InvoiceCleanedUpFormat" in Invoice class om single line output te geven
        invoices.stream ( ).sorted ( Comparator.comparing ( Invoice::getPartDescription ) ).forEach ( i -> System.out.println ( i.InvoiceCleanedUpFormat ( ) ) );
        System.out.println ( "--------------------------------------------------------------------------" );
        System.out.println ( "b)  Gebruik lambdas and streams om de Invoice objects te sorteren volgens Price, en toon de resultaten. " );
        System.out.println ( "--------------------------------------------------------------------------" );

        invoices.stream ( ).sorted ( Comparator.comparingDouble ( Invoice::getPricePerItem ) ).forEach ( i -> System.out.println ( i.getPartDescription ( ) + "= " + i.getPricePerItem ( ) ) );

        System.out.println ( "--------------------------------------------------------------------------" );
        System.out.println ( "c)  Gebruik lambdas and streams om iedere Invoice te mappen op haar PartDescription en Quantity, sorteer de resultaten volgens Quantity, en toon de resultaten." );
        System.out.println ( "--------------------------------------------------------------------------" );

        invoices.stream ( ).sorted ( Comparator.comparing ( Invoice::getQuantity ) ).forEach ( i -> System.out.println ( i.getPartDescription ( ) + "= " + i.getQuantity ( ) ) );

        System.out.println ( "--------------------------------------------------------------------------" );
        System.out.println ( "d)  Gebruik lambdas and streams om iedere Invoice te mappen op haar PartDescription en de waarde (bedrag) van de Invoice (dus, Quantity * Price). Sorteer de resultaten volgens Invoice value." );
        System.out.println ( "--------------------------------------------------------------------------" );

        invoices.stream ( )
                .sorted ( Comparator.comparing ( Invoice::getInvoiceAmount ) )
                .forEach ( i -> System.out.println ( i.getPartDescription ( ) + "= " + String.format ( "%.2f" , i.getInvoiceAmount ( ) ) ) );

        System.out.println ( "--------------------------------------------------------------------------" );
        System.out.println ( " e)  Wijzig deel (d) om de Invoice values te selecteren in €200 to €500." );
        System.out.println ( "--------------------------------------------------------------------------" );

        invoices.stream ( )
                .filter ( i -> i.getInvoiceAmount ( ) >= 200 && i.getInvoiceAmount ( ) <= 500 )
                .sorted ( Comparator.comparing ( Invoice::getInvoiceAmount ) )
                .forEach ( i -> System.out.println ( i.getPartDescription ( ) + "= " + String.format ( "%.2f" , i.getInvoiceAmount ( ) ) ) );





    }
}
