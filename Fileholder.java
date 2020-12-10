import java.util.*;
import java.io.*;


public class Fileholder{


Formatter file;

   public void createFile(String name){
   
      try{
      
         file = new Formatter(name + ".txt");
         System.out.println("Arrangement created...");
      }
      catch(Exception e){
      
         System.out.println("Arrangement not created");
      
      }
   }
   
   
   public void writeFile(String text){
   
      file.format(text);
   
   
   }
   
   public void closeFile(){
   
      file.close();
   
   }
   
   public void deleteFile(String fileName){
   
      try{
      
         File file = new File( fileName +".txt");
      
         file.delete();
         System.out.println("Arrangement deleted\n");
      
      }
      catch(Exception e){
      
         System.out.println("Arrangement not deleted\n");
      
      }
   
   
   }
   
   
   //Til readFile
   StringBuffer stringBufferOfData = new StringBuffer();
   Scanner in = new Scanner(System.in);

   String fileName;

   
   public boolean readFile(){
   
      System.out.print("Please enter the arrangement name: ");
      fileName = in.nextLine();
      System.out.println();
      Scanner fileToRead;
      
      
      try{
         fileToRead = new Scanner(new File(fileName + ".txt")); //point the scanner method to a file
         
         //check if there is a next line and it is not null and then read it in
         for (String line; fileToRead.hasNextLine() && (line = fileToRead.nextLine()) != null; ) {
            System.out.println(line);//print each line as its read
            stringBufferOfData.append(line).append("\r\n");//this small line here is to appened all text read in from the file to a string buffer which will be used to edit the contents of the file
         }
         
         fileToRead.close();
            
      }
         
      catch(Exception e){
         
         System.out.println("The file " +fileName+ " could not be found!!" );
         
      }
      
      return true;
   }

   public void writeToFile(){
   
      try {
         BufferedWriter bufwriter = new BufferedWriter(new FileWriter(fileName +".txt"));
         bufwriter.write(stringBufferOfData.toString());//writes the edited string buffer to the new file
         bufwriter.close();//closes the file
      } catch (Exception e) {//if an exception occurs
         System.out.println("Error occured while attempting to write to file: " + e.getMessage());
      }
   
   }
   
   public void replacement(){
      System.out.print("Please enter the contents of a line you would like to edit: ");
      String lineToEdit = in.nextLine();
   
      System.out.print("Please enter the the replacement text: ");
      String replacementText = in.nextLine();
   
      int startIndex = stringBufferOfData.indexOf(lineToEdit); // Vi får starts punktet for den linje vi kan vil ersatte
      int endIndex = startIndex + lineToEdit.length(); //now we add the staring index of the text with text length to get the end index
   
      stringBufferOfData.replace(startIndex, endIndex, replacementText); // Det her man bytter på orderne
   
      System.out.println("Here is the new edited text:\n" + stringBufferOfData); // for at se om orderne var replaced
   
   }

  




}