
/**
 * Write a description of WhichCountriesExport here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class WhichCountriesExport {

    public void listExporters(CSVParser parser, String exportOfInterest){
        for(CSVRecord record : parser){
        
            String export = record.get("Exports");
        
            if(export.contains(exportOfInterest)){
            
                String country = record.get("Country");
                System.out.println(country);
            
            }
        }
    
    }
    public void countryInfo(CSVParser parser, String country){
    for (CSVRecord record : parser){
        String countryCheck = record.get("Country");
        if(countryCheck.contains(country)){
    String export = record.get("Exports");
    String exportValue = record.get("Value (dollars)");
    System.out.println(country + ": " + export + ": " + exportValue + ".");
}
    }
}
public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
for(CSVRecord record : parser){
        
            String export = record.get("Exports");
            String country = record.get("Country");
        
            if(export.contains(exportItem1) && export.contains(exportItem2)){
                
                
                System.out.println(country);
            
            
            }
        }

}
    public void numberOfExporters(CSVParser parser, String exportItem){
        int temp = 0;
    for(CSVRecord record : parser){
        
            String export = record.get("Exports");
        
            if(export.contains(exportItem)){
            
                temp = temp+1;
            
            }
        }
                System.out.println(temp);
    }
    public void bigExporters(CSVParser parser, String money){
    for (CSVRecord record : parser){
        String moneyCheck = record.get("Value (dollars)");
        if(moneyCheck.length()> money.length()){
            String country = record.get("Country");
    System.out.println(country + moneyCheck);
}
    }
    }
    public void whoExportsCoffee(){
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    listExportersTwoProducts(parser, "cotton", "flowers");
    parser = fr.getCSVParser();
    numberOfExporters(parser, "cocoa");
    parser = fr.getCSVParser();
    countryInfo(parser,"Nauru");
    parser = fr.getCSVParser();
    bigExporters(parser, "$999,999,999,999");
    }
    
}
