import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.*; 

public class Result implements Comparable <Result>{
   public String name;
   public String type;
   public int time;

   public Result(String name, String type, int time){
      this.name = name;
      this.type = type;
      this.time = time;
   }
   public Result(){}
   
   public int compareTo(Result m){
      return this.time - m.time;
   }

   public ArrayList<Result> getResult(ArrayList<String> somelist, String somedisciplin){
      ArrayList<Result> tmplist = new ArrayList<Result>();
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
         if(tokens[0].equals("|result|")){
            //System.out.println(Arrays.toString(tokens));
            //look for same type of result (disciplin)
            if(tokens[1].equals(somedisciplin)){
               tmplist.add(new Result(name, tokens[1], Integer.parseInt(tokens[2])));
               //System.out.println("we added an element to the list "+tmplist.size());
            }
         }
      }
      return tmplist;
   
   }

   
   
//instantiate our result list etc
   public static void main(String[] args)throws FileNotFoundException {
      ArrayList<Result> Resultlist = new ArrayList<Result>();
      Filer F1 = new Filer();
      //member files
      File[] memberfilelist = new File[0];
      //content of file
      ArrayList<String> filecontent = new ArrayList<String>();
      //empty result to access our methods only
      Result R1 = new Result();
      //find all our member files and load
      memberfilelist = F1.listFiles("Member");
      //go through our memberlist and load results
      for (File f : memberfilelist){
         //load file
         System.out.println(f.getName());
         filecontent = F1.loadFile("./Member/"+f.getName());
         //load result for specific disciplin and add to our Resultlist
         Resultlist.addAll(0,R1.getResult(filecontent, "crawl"));
      }   
      //sorting our results
      for (Result m : Resultlist){
               System.out.println(m.name + " with the time " +m.time);
      }
      System.out.println("-----sorted from here--------");
      Collections.sort(Resultlist);
      for (Result m : Resultlist){
         System.out.println(m.name + " with the time " + m.time);
      }
   }
 
//    public void addResult(String highscore, String event, String placement,String time) throws FileNotFoundException {
//    
//       Filer F1 = new Filer();
//       ArrayList<String> Resultlist = new ArrayList<String>();
//       Resultlist = F1.loadFile("Resultat.txt");
//       ArrayList<String> Row = new ArrayList<String>();
//       Row.add(type);
//       Row.add(time);
//       Resultlist.add(Row);
//       
//       F1.writeFile("Resultat.txt", Resultlist);
//       
//    
//    }

//    public ArrayList<String> getResult(int line) throws FileNotFoundException {
//       Filer F1 = new Filer();
//       ArrayList<ArrayList<String>> Resultlist = new ArrayList<ArrayList<String>>();
//       Resultlist = F1.loadFile("Resultat.txt");
//       return Resultlist.get(line);
//    }
// 
//    public void showHighscore() throws FileNotFoundException {
//    
//       Filer F1 = new Filer();
//       ArrayList<ArrayList<String>> Resultlist = new ArrayList<ArrayList<String>>();
//       Resultlist = F1.loadFile("Resultat.txt");
//    }

}