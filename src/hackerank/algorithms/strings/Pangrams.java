package hackerank.algorithms.strings;

import java.util.Scanner;

/**
Roy wanted to increase his typing speed for programming contests. So, his friend advised him to type the sentence
"The quick brown fox jumps over the lazy dog" repeatedly because it is a pangram.
( pangrams are sentences constructed by using every letter of the alphabet at least once. )

After typing the sentence several times, Roy became bored with it. So he started to look for other pangrams.

Given a sentence s, tell Roy if it is a pangram or not.

Input Format

Input consists of a line containing s.

Constraints
Length of s can be atmost 103 (1?|s|?103) and it may contain spaces, lowercase and uppercase letters. Lowercase and uppercase instances of a letter are considered same.

Output Format

Output a line containing pangram if s is a pangram, otherwise output not pangram.
 */
public class Pangrams {
    
    private static char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    
    private static boolean isPangram(String sentence){
        for(char alphabet : alphabets){
            if(!sentence.contains(""+alphabet)){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        System.out.println("Entered sentence = "+sentence);
        
        if(sentence != null && isPangram(sentence.toLowerCase())){
            System.out.println("pangram");
        }else{
            System.out.println("not pangram");
        } 
        
        scanner.close();
    }
}
