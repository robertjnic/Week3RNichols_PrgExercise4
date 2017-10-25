/** Program: Pig-Latin Program
* File: PigLatin.java
* Summary: Pulls a word from a file and converts to Pig-Latin
* Author: Robert J. Nichols
* Date: October 19, 2017 
**/
import java.util.Scanner;
public class PigLatin {

    public static void main(String[] args) throws Exception {
        
        // Create file instance.
        java.io.File file = new java.io.File("PigLatin_txt.txt");
        
        // Create a scanner for the file.
        Scanner input = new Scanner(file);

        // Read data from a file.
        while(input.hasNext()){
            String sentence = input.nextLine();
            String[] words = sentence.split(" ");    
            final String vowels = "aeiouAEIOU";
            
            for (String word : words){
                
                String originalWord = word; //Store the original word.
                word = word.toUpperCase();
                
                String beforeVowel = ""; 
                int sl = 0; //Stored location within word
                
                while(sl < word.length() && !vowels.contains("" + word.charAt(sl)))
                {
                    beforeVowel += word.charAt(sl);
                    sl++;
                }
                
                if(word.length() < 2){
                    sl = 0;
                    word+= "W";
                }
                
                if(sl == 0 && word.length() > 3){
                    sl = 1;
                    word += word.charAt(0) + "W";
                }              
                System.out.printf("%-30.30s %-30.30s %n", originalWord, word.substring(sl) + beforeVowel + "AY");
            }
        }
        input.close();
    }
}
