import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;


/**
 * calculates babynames in a csv, but really can do a lot of number stats.
 * 
 * @Connor Berry 
 * @Confirmed to work on BlueJay at 8/11/2018
 */


public class Babyname {
    
    public void printNames(){
    FileResource fr = new FileResource();
    for (CSVRecord rec : fr.getCSVParser(false)){
        int numBorn = Integer.parseInt(rec.get(2));
        if(numBorn <= 100){
        System.out.println("Name "+rec.get(0)+
        " Gender "+rec.get(1)+
        " Num born "+rec.get(2)
        );
    }
   }
  }
    public void totalBirths(){
    FileResource fr = new FileResource();
    int totalBirths = 0;
    int totalBoys = 0;
    int totalGirls = 0;
    int girlCount = 0;
    int boyCount = 0;
    for (CSVRecord rec : fr.getCSVParser(false)){
    int numBorn = Integer.parseInt(rec.get(2));
    totalBirths += numBorn;
    if(rec.get(1).equals("M")){
    totalBoys += numBorn;
    boyCount = boyCount + 1;
    }
    else {
    totalGirls += numBorn;
    girlCount = girlCount + 1;
    }
    
  }
  System.out.println("total births = " + totalBirths);
  System.out.println("total girls = " + totalGirls);
  System.out.println("total boys = " + totalBoys);
  System.out.println("The number of girl names is " + girlCount);
  System.out.println("The number of boy names is " + boyCount);
    }
    public void getRank(int year, String name, String gender){
       int Count = 0;
        FileResource fr = new FileResource();
    for (CSVRecord rec : fr.getCSVParser(false)){
    if (rec.get(1).equals(gender)){
    Count = 1 + Count;
    }
    
    if (rec.get(0).equals(name)){
    break;
    }
    }
    
    System.out.println("The Rank of "+ name + " in the year "+ year + " is " + Count + ".");

 
}

    public void getName(int year, int rank, String gender){
       int maleCount = 0;
       int femCount = 0;
        FileResource fr = new FileResource();
    for (CSVRecord rec : fr.getCSVParser(false)){
    if (rec.get(1).equals(gender)){
    maleCount = 1 + maleCount;
    }
    if (rec.get(1)=="F"){
    femCount = 1 + femCount;
    }
    if ((maleCount == rank)||(femCount == rank)){
    System.out.println(rec.get(0));
    }
    }
}

public void whatIsNameInYear(String name, int year, int newYear, String gender){
        int Count = 0;
       String namehold;
        FileResource fr = new FileResource();
    for (CSVRecord rec : fr.getCSVParser(false)){
    if (rec.get(1).equals(gender)){
    Count = 1 + Count;
    if(rec.get(0).equals(name)){
    break;
    }
}
    
    
}
    int Count2 = 0;
        FileResource fr2 = new FileResource();
    for (CSVRecord rec2 : fr2.getCSVParser(false)){
    if (rec2.get(1).equals(gender)){
    Count2 = 1 + Count2;
    if(Count2 == Count){
        System.out.println(name + " in "+ year + " is the same year in as "
        + rec2.get(0)+ " " + newYear + ".");
        break;
    }
    }
    
    
    
}
}

public String yearOfHighestRank(String name, String Gender){
int iterate = 0;
int greatIterate = 0;
String High = null;
DirectoryResource dr = new DirectoryResource();
for (File f : dr.selectedFiles()){
    FileResource fr = new FileResource(f);
        iterate = 0;
    for(CSVRecord rec : fr.getCSVParser(false)){
if(rec.get(1).equals(Gender)){
iterate = iterate+1;
if(rec.get(0).equals(name)){
System.out.println("The Highest Rank is " + iterate + " at " + f.getName());
if(greatIterate == 0){
greatIterate = iterate;
High = f.getName();
}
if(iterate < greatIterate){
greatIterate = iterate;
High = f.getName();
}
}
}
}
}
return High;
}

public void getAverageRank(String name, String gender){
double iterate = 0.0;
double greatIterate = 0.0;
double avgHold = 0.0;
String High = null;
DirectoryResource dr = new DirectoryResource();
for (File f : dr.selectedFiles()){
    FileResource fr = new FileResource(f);
    for(CSVRecord rec : fr.getCSVParser(false)){
        if(rec.get(1).equals(gender)){
iterate = iterate+1;

if(rec.get(0).equals(name)){
    avgHold = avgHold + 1;
    System.out.println(iterate+" "+avgHold);
    break;
}
}
}
}
greatIterate = iterate/avgHold;
System.out.println(greatIterate);
}

public void getTotalBirthsRankedHigher(int year, String name, String gender){
int record = 0;
String High = null;
DirectoryResource dr = new DirectoryResource();
for (File f : dr.selectedFiles()){
    FileResource fr = new FileResource(f);
    for(CSVRecord rec : fr.getCSVParser(false)){
        if(rec.get(1).equals(gender)){


if(rec.get(0).equals(name)){
    break;
}
record = record + Integer.parseInt(rec.get(2));
}
}
}
System.out.println(record);

}

public void tester (){
//totalBirths();
//getRank(2012, "Frank", "M");
//getName(1982, 450, "M");
whatIsNameInYear("Susan", 1972, 2014, "F");
//System.out.println(yearOfHighestRank("Mich", "M"));
//getAverageRank("Robert", "M");
//getTotalBirthsRankedHigher(1990, "Drew", "M");
}


}
