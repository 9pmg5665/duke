import edu.duke.FileResource;
import edu.duke.StorageResource;
import edu.duke.DirectoryResource;
public class Part1 {
    
    
    public int findStopCodon(String dna, int startindex, String stopcodon){
       int currIndex = dna.indexOf(stopcodon,startindex+3);
       while (currIndex != -1) {
        int diff = currIndex - startindex;
        if (diff % 3 == 0){
        return currIndex;
        }
        else{
        currIndex = dna.indexOf(stopcodon, currIndex);
        }
        }
        return -1; 
    }
    public String findGene(String dna, int where){
        int startindex = dna.indexOf("ATG", where);
        if (startindex == -1){
        return "";
        }
        int taaIndex = findStopCodon(dna, startindex, "TAA");
        int tagIndex = findStopCodon(dna, startindex, "TAG");
        int tgaIndex = findStopCodon(dna, startindex, "TGA");
        int temp = Math.min(taaIndex, tagIndex);
        int minIndex = Math.min(temp, tgaIndex);
                if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)){
            minIndex = tgaIndex;
        }
        else {
        minIndex = taaIndex;
        }
        
        if(minIndex == -1|| (tagIndex != -1 && tagIndex< minIndex)){
        minIndex=tagIndex;
        }
        
        if(minIndex ==-1){
        return "";
        }
        
    return dna.substring(startindex,minIndex+3);
    }
    public String cgRatio(String dna){
    int temp = 0;
    int startIndex = 0;
    while (startIndex != -1){
    
        
    startIndex = dna.indexOf("C", startIndex);
    
    if(startIndex != -1){
    temp = temp+1;
    startIndex = startIndex+1;
        }
    }
    startIndex = 0;
    while (startIndex != -1){
    
        
    startIndex = dna.indexOf("G", startIndex);
    
    if(startIndex != -1){
    temp = temp+1;
    startIndex = startIndex+1;
        }
    }
    System.out.println(dna.length());
    return (Integer.toString(temp));
    }
    
    public String ctgRatio(String dna){
    int temp = 0;
    int startIndex = 0;
    while (startIndex != -1){
    
        
    startIndex = dna.indexOf("CTG", startIndex);
    
    if(startIndex != -1){
    temp = temp+1;
    startIndex = startIndex+3;
        }
    }
    
    
    return ("CTG appears "+temp+" times.");
    }
    
    
    public StorageResource getAllGenes(String dna){
        StorageResource geneList = new StorageResource();
        int startIndex = 0;
    while(true){
    String currentGene = findGene(dna,startIndex);
    if(currentGene.isEmpty()){
    break;
    }
    System.out.println(currentGene);
    geneList.add(currentGene);
    startIndex = dna.indexOf(currentGene, startIndex) +
        currentGene.length();
    }
    return geneList;
    }
    
    public void testOn(String dna){
    System.out.println("Testing printAllGenes on " + dna);
    StorageResource genes = getAllGenes(dna);
    for (String g: genes.data()){
        System.out.println(g );
    }
    
    }
    public void processGenes (StorageResource sr){
        int tempI = 0;
        int tempI2 = 0;
        int tempI3 = 0;
        
        for (String t : sr.data()){
            if(t.length()>tempI3){
                tempI3 = t.length();
            }
        if(t.length() > 9){
        System.out.println(t);
            if(Integer.parseInt(cgRatio(t))>(7/20)){
            tempI2=tempI2+1;
            System.out.println(t);
            }
        tempI = tempI +1;
        }
        
    }
    System.out.println(tempI);
    System.out.println(tempI2);
    System.out.println(tempI3);
}
    public void testProcessGenes(){
    FileResource fr = new FileResource("GRch38dnapart.fa");
    StorageResource dnaHold = new StorageResource();
    for(String line : fr.lines()){
    dnaHold.add(line);
    System.out.println(line);
    test(line);
    }
    processGenes(dnaHold);
    }
    
    public void test(String dna){
    System.out.println(cgRatio(dna));
    System.out.println(ctgRatio(dna));
    }
    
    
    
}
