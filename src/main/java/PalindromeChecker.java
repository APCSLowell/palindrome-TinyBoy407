import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
  //String lines[] = loadStrings("palindromes.txt");
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else
    {
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
public boolean palindrome(String word)
{
  if(noCapitals(word).equals(reverse(word))){
    return true;
  }
  else{
    return false;
  }
}

public String reverse(String str)
{
    String sNew = new String();
    for(int i = str.length(); i > 0; i--){
      if(!str.substring(i-1,i).equals(" ") && Character.isLetter(str.charAt(i-1))){
        sNew += str.substring(i-1,i);
     }
  }
    return sNew.toLowerCase();
}

public String noCapitals(String word){
  return noSpaces(word).toLowerCase();
}

public String noSpaces(String word){
  String result = new String();
  for(int i = 0; i < word.length(); i++)
     if(!word.substring(i,i+1).equals(" ") && Character.isLetter(word.charAt(i)))
       result=result + word.substring(i,i+1);
  return result;
}
}
