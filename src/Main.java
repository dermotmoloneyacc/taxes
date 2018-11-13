/*
Using the tax data from 2014 answer the following questions;

What was the total number of income tax returns filed in the US in 2014?
What was the total amount of income tax collected in the US in 2014?
What zip code had the lowest per capita adjusted gross income in the US?
What was the average income per capita in this zip code?
What zip code had the highest per capita adjusted gross income in the US?
What was the average income per capita in this zip code?
What zip code paid the most federal tax in the US?
What was the average per capita income in your zip code?
*/
package edu.acc.java2.taxes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static String myState;
    public static void main(String[] args) {
                
        if (args.length != 1) {
            System.out.println("Usage: java -jar taxes.jar {path-to-file}");
            return;
         }
            
        List<ZipCode> zips = loadZipsFrom(args[0]);
        if (zips.isEmpty()) {
            System.out.println("Couldn't load data!");
            return;
        }
        /*  System.out.println(z.getId());
            System.out.println(z.getAgiStub());
            System.out.println(z.getTotalTax());
            System.out.println(z.getTotalReturns());
            System.out.println(z.getState());
            System.out.println("**************************************");
            System.out.println(stateTotalReturns);
            System.out.println(stateTotalTax);
            System.out.println(stateTotalTax.getAsDouble());
            System.out.println(perCapita);
            System.out.println(perCapita2);
            System.out.println("**************************************");
             
        */
                
        List <String> zipList = zips.stream()
        .map(ZipCode::getZipCode)
        .distinct()
        .sorted()
        .collect(Collectors.toList());
        //zipList.forEach(System.out::println);
               
        List<String> stateList = zips.stream()
        .map(ZipCode::getState)
        .distinct()
        .sorted()
        .collect(Collectors.toList());
        //stateList.forEach(System.out::println);
        
        List<usState> usStates = new ArrayList<>();
        
        
        for (String s : stateList) {
            usState x = new usState();
            String summZip = "0";
            //System.out.println(s);
            OptionalDouble stateTotalTax;
            stateTotalTax = zips.stream()
                .filter(z -> z.getState().equals(s))
                .filter(z -> z.getZipCode().startsWith(summZip))
                .mapToDouble(ZipCode::getTotalTax)
                .reduce((y,z) -> y + z);
        x.setTotalTax(stateTotalTax.getAsDouble());
        x.setState(s);
        
            
        int stateTotalReturns = zips.stream()
            .filter(z -> z.getState().equals(s))
            .filter(z -> z.getZipCode().startsWith(summZip))
            .map(ZipCode::getTotalReturns)
            .reduce((y,z) -> y + z).get();
        x.setTotalReturns(stateTotalReturns);
        
        Optional<Double> stateAdjustedGross = zips.stream()
            .filter(z -> z.getState().equals(s))
            .filter(z -> z.getZipCode().startsWith(summZip))
            .map(ZipCode::getAdjustedGross)
            .reduce((y,z) -> y + z);
                       
           
//     double perCapita = (stateAdjustedGross.getasDouble()/stateTotalTax.getAsDouble());
        
//      int perCapita2 = (int)(perCapita);
//    x.setPerCapita(perCapita2);
        
        usStates.add(x);
            
        }
       for (usState z : usStates) {
                System.out.printf("%s had %.2f taxes and %d returns and %d percapita\n", 
                        z.getState(), z.getTotalTax(), z.getTotalReturns(), z.getPerCapita());
       }
       
        OptionalDouble totalTax = usStates.stream()
                       .mapToDouble(usState::getTotalTax)
                       .max();
        
        System.out.printf("Maximum tax paid is %.2f\n", totalTax.getAsDouble());               
        System.out.println();
        
       }
    
    private static List<ZipCode> loadZipsFrom(String file) {
        List<ZipCode> ZipCodeList = new ArrayList<>(100_000);        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine(); // discard the header line
            String line;
            while ((line = br.readLine()) != null) {
                String[] cols = line.split(",");
                ZipCode z = new ZipCode();
                z.setId(Integer.parseInt(cols[0]));
                z.setState(cols[1]);
                z.setZipCode(cols[2]);
                z.setAgiStub(Integer.parseInt(cols[3]));          
                z.setPerCapita(0);
                z.setTotalReturns(Integer.parseInt(cols[4]));
                z.setTotalTax(Integer.parseInt(cols[68]));
                z.setAdjustedGross(Integer.parseInt(cols[14]));
                z.setReturnsTaxDue(Integer.parseInt(cols[123]));
                z.setTaxDue(Integer.parseInt(cols[124]));
                ZipCodeList.add(z);
            }
        } catch (IOException ioe) {}
        return ZipCodeList;          
    }
    
    
}
