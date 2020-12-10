import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.*; 

public class Competition extends Result {
   public int placement;
   public String title;
   
      public Competition(String name, String type, int time, int placement, String title){
      this.name = name;
      this.type = type;
      this.time = time;
      this.placement = placement;
      this.title = title;
   }
   public Competition(){}
   
   
   public ArrayList<Competition> getcompResult(ArrayList<String> somelist, String somedisciplin){
      ArrayList<Competition> tmplist = new ArrayList<Competition>();
      //go through the whole file content
      String name ="noname";
      for (int i = 0; i<somelist.size(); i++){
         //use # as delimiter in string
         String[] tokens = somelist.get(i).split("#");
         //look for member info
         if(tokens[0].equals("|member|")){
            name = tokens[1];
            //System.out.println(name);
         }
         //look for result info
         if(tokens[0].equals("|competition|")){
            //System.out.println(Arrays.toString(tokens));
            //look for same type of result (disciplin)
            if(tokens[1].equals(somedisciplin)){
               tmplist.add(new Competition(name, tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]),tokens[4]));
               //System.out.println("we added an element to the list "+tmplist.size());
            }
         }
      }
      return tmplist;
   
   }





public static void main(String[] args)throws FileNotFoundException {

//just for testing stuff here
      ArrayList<Competition> Resultlist = new ArrayList<Competition>();
      Filer F1 = new Filer();
      //member files
      File[] memberfilelist = new File[0];
      //content of file
      ArrayList<String> filecontent = new ArrayList<String>();
      //empty result to access our methods only
      Competition R1 = new Competition();
      //find all our member files and load
      memberfilelist = F1.listFiles("Member");
      //go through our memberlist and load results
      for (File f : memberfilelist){
         //load file
         System.out.println(f.getName());
         filecontent = F1.loadFile("./Member/"+f.getName());
         //load result for specific disciplin and add to our Resultlist
         Resultlist.addAll(0,R1.getcompResult(filecontent, "crawl"));
      }   
      //sorting our results inherited comparable from result
      for (Competition m : Resultlist){
               System.out.println(m.name + " with the time " +m.time+ " with the placement of " +m.placement);
      }
      System.out.println("-----sorted with time--------");
      Collections.sort(Resultlist);
      for (Competition m : Resultlist){
         System.out.println(m.name + " with the time " + m.time + " with the placement of " +m.placement);
      }
      System.out.println("-----sorted with placement--------");
      //sorting our results with comparator
      PlacementCompare placecompare = new PlacementCompare();
      Collections.sort(Resultlist, placecompare);
      for (Competition m : Resultlist){
               System.out.println(m.name + " with the time " +m.time+ " with the placement of " +m.placement);
      }
      
      
      
      
}




}