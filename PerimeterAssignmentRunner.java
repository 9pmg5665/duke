import edu.duke.*;
import java.io.File;

/**
 * Gets Perimeter from multiple points in a CSV??? file.
 * 
 * @Connor Berry 
 * @Confirmed to work on BlueJay at 8/11/2018
 */

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int totalPoints = 0;
        for (Point currPt : s.getPoints()) {
            totalPoints = totalPoints +1;
        }
        return totalPoints;
    }

    public double getAverageLength(Shape s) {
         // Start with totalPerim = 0
        double totalPerim = 0.0;
        int totalCount = 0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            totalCount=totalCount+1;
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim/totalCount;
    }

    public double getLargestSide(Shape s) {
         // Start with totalPerim = 0
         double gargant = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            double prevDist = prevPt.distance(prevPt);
            // Update totalPerim by currDist
            if (currDist > prevDist){
                if(gargant < currDist){
            gargant = currDist;
        }
            }
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return gargant;
    }

    public double getLargestX(Shape s) {
          // Start with totalPerim = 0
         double gargant = 0.0;
         double prevX = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currX = currPt.getX();
            // Update totalPerim by currDist
            if (currX > prevX){
                if (gargant < currX){
            gargant = currX;
        }
            }
      
            prevX = currX;
        }
            return gargant;
    }

    public double getLargestPerimeterMultipleFiles(){
        DirectoryResource dr = new DirectoryResource();
        double lessP = 0.0;
        double bigP = 0.0;
        double gargant = 0.0;
       for (File f : dr.selectedFiles()) {
    FileResource fr = new FileResource(f);
    Shape s = new Shape(fr);
    for (Point currPt : s.getPoints()) {
        lessP = getPerimeter(s);
        if (bigP < lessP){
            bigP = lessP;
            gargant = lessP;
        }
        bigP = lessP;
    }
        if (gargant < bigP){
            gargant = bigP;
        }
    
}
return gargant;
}
    public String getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        double lessP = 0.0;
        double bigP = 0.0;
        String prevname = null;
        String currname = null;
        String goodname = null;
       for (File f : dr.selectedFiles()) {
    FileResource fr = new FileResource(f);
    Shape s = new Shape(fr);
    currname = f.getName();
    if (prevname == null){
    prevname = f.getName();
    }
    for (Point currPt : s.getPoints()) {
        lessP = getPerimeter(s);
        if (bigP < lessP){
            bigP = lessP;
            goodname = currname;
        }
        bigP = lessP;
    }
       
    
}
return goodname;
    }

    public void testPerimeter() {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        System.out.println("point Count = " + getNumPoints(s));
        System.out.println("average Count = " + getAverageLength(s));
        System.out.println("Longest Side = " + getLargestSide(s));
        System.out.println("Biggest X = " + getLargestX(s));
        testPerimeterMultipleFiles();
        LargestPerimeter();
    }
    
    public void testPerimeterMultipleFiles() {
        System.out.println("Biggest perimeter = " + 
        getLargestPerimeterMultipleFiles());
    }

    public void LargestPerimeter() {
        System.out.println("The biggest file is" + getFileWithLargestPerimeter());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
            
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
