package application;

import entities.Sale;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault( Locale.US );
        Scanner sc = new Scanner( System.in );

        System.out.print( "Enter the file path: " );
        String path = sc.nextLine();

        File file = new File( path );

        Sale sale;

        List<Sale> sales = new ArrayList<>();

        try ( BufferedReader bf = new BufferedReader( new FileReader( file ) ) ) {

            String line = bf.readLine();
            while ( line != null ) { 
                String[] fields = line.split( "," );

                int month = Integer.parseInt( fields[ 0 ] );
                int year  = Integer.parseInt( fields[ 1 ] );
                String seller = fields[ 2 ];
                int items = Integer.parseInt( fields[ 3 ] );
                double total = Double.parseDouble( fields[ 4 ] );

                sale = new Sale( month, year, seller, items, total );

                sales.add( sale );

                line = bf.readLine();
            } 

            Map< String, Double > totalBySeller = sales.stream()
                .collect( Collectors.groupingBy( 
                        s -> s.getSeller(), 
                        Collectors.summingDouble( s -> s.getTotal() )
                    ));

            System.out.println( "\nTotal sales by seller: " );
            for ( String key : totalBySeller.keySet() ) {
                System.out.println( key + ": " + String.format( "%.2f", totalBySeller.get( key ) ) );
            }

        } catch (Exception e) {
            sc.close();
            System.out.println( "ERROR: " + e.getMessage() );
        } finally {
            sc.close();
        }
    }
}
