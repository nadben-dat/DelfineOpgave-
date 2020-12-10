import java.util.*;
import java.util.Scanner; 
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.util.ArrayList ; 


public class MemberTest{

   public void deletemember (int line) throws FileNotFoundException{
   
   Filer F1 = new Filer ();
   ArrayList<ArrayList<String>> Memberlist = new ArrayList<ArrayList<String>> ();
   
   Memberlist = F1.loadFile ("medlem2.txt");
   
   Memberlist.remove(line);
   
   F1.writeFile("medlem2.txt", Memberlist);
   
   }

}