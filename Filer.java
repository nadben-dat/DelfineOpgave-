import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Filer {
//find things in an array list of array list
public static void main(String[] args) throws FileNotFoundException {
   Filer F1 = new Filer();
   F1.writeFile("medlem2.txt",F1.loadFile("medlem.txt"));
   F1.printList(F1.loadFile("medlem.txt"));
}

public void printList(ArrayList<ArrayList<String>> somelist){
for (int i = 0; i<somelist.size(); i++){
   System.out.println((i+1)+":"+String.join(" ", somelist.get(i)));
} 
}

public ArrayList<ArrayList<String>> loadFile(String somefile)throws FileNotFoundException {
//load file into arraylist of arraylist
    ArrayList<ArrayList<String>> outer = new ArrayList<ArrayList<String>>();
    ArrayList<String> inner = new ArrayList<String>();        

try {
   //open file for reading
   Scanner input = new Scanner(new File (somefile));
   inner = new ArrayList<String>(inner); // create a new inner list that has the same content as  
                                           // the original inner list
   while (input.hasNext())
   {
      Scanner words = new Scanner(input.nextLine());
      input.useDelimiter("|");
      while (words.hasNext())
      {  
         //add all words to inner array list
         //System.out.println(words.next());
         inner.add(words.next());    
      }
      //add our inner array list to the outer
      outer.add(inner); // add second list
      inner = new ArrayList<String>(); //new array list
   }
   }
   catch (FileNotFoundException e) {}    

    return(outer);
}

private boolean canRead(String somefile){
File f = new File(somefile);
return f.canRead();
}

public void writeFile(String somefile, ArrayList<ArrayList<String>> somelist)
throws FileNotFoundException {
//open existing file for writing or make new one
   try {
      PrintStream somestream;
      FileOutputStream fos = new FileOutputStream(somefile); //true for at appende
      if (canRead(somefile))
      {
         //we have a file we can use
         //System.out.println("we have a file we can use");
         somestream = new PrintStream(fos);
      }
      else
      {
         //cant read the file so lets assume it doesnt exist
         somestream = new PrintStream(fos);
      }
      //write something in file
      for (int i = 0; i<somelist.size(); i++){
         String outputline = String.join(" ", somelist.get(i));
         somestream.println(outputline);
      }    
      }
    catch (FileNotFoundException e) {} 
}
      
public void listfiles (){
File folder = new File("Events");
File[] listOfFiles = folder.listFiles();

for (int i = 0; i < listOfFiles.length; i++) {
  if (listOfFiles[i].isFile()) {
    System.out.println("File " + listOfFiles[i].getName());
  } else if (listOfFiles[i].isDirectory()) {
    System.out.println("Directory " + listOfFiles[i].getName());
  }
}

}      
  }




