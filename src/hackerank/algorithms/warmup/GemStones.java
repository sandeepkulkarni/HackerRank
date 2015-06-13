package hackerank.algorithms.warmup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * John has discovered various rocks. Each rock is composed of various elements, and each element is represented by a
   lowercase latin letter from 'a' to 'z'. An element can be present multiple times in a rock.
   An element is called a 'gem-element' if it occurs at least once in each of the rocks.

   Given the list of N rocks with their compositions, display the number of gem-elements that exist in those rocks.

Input Format
The first line consists of N, the number of rocks.
Each of the next N lines contain rocks' composition. Each composition consists of lowercase letters of English alphabet.

Output Format
Print the number of gem-elements that are common in these rocks. If there are none, print 0.

Constraints
1 ? N ? 100
Each composition consists of only small latin letters ('a'-'z').
1 ? Length of each composition ? 100

Sample Input
 3
 abcdde
 baccd
 eeabg

Sample Output
 2

Explanation
 Only "a", "b" are the two kind of gem-elements, since these are the only characters that occur in each of the rocks' composition.

 */
public class GemStones {
    
    private static List<String> rocks = new ArrayList<String>();
    private static Set<String> elements = new HashSet<String>();

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);                
        int noOfRocks = scanner.nextInt();
        //Populate Rocks
        for(int i=0; i < noOfRocks; i++) {
            if(scanner.hasNext()){
                populateRocks(scanner.next());
            }
        }        
        //Populate Elements
        populateElements(rocks);
        //get gem-element count
        int gemCount = getGemCount(noOfRocks);
        System.out.println(gemCount);
        scanner.close();
    }
    
    private static void populateRocks(String rock){
        rocks.add(rock);
    }
    
    private static void populateElements(List<String> rocks){
        for(String rock : rocks){
            for(int i=0;i<rock.length();i++){
                elements.add(""+rock.charAt(i));
            }
        }
    }
    
    private static int getGemCount(int noOfRocks){
        int gemCount = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        //First loop should be of unique elements (alphabets) is imp else we get stuck in rock loop 
        //as a rock can have multiple times same element
        for(String element : elements){    
            for(String rock : rocks){
                CharSequence s = ""+element;
                if(rock.contains(s)){
                    if(map.containsKey(element)){
                        int count = map.get(element);
                        count++;
                        map.put(element,count);
                    }else{
                        map.put(element,1);
                    }                    
                }
            }
        }
        
        System.out.println("Map - "+map);
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() == noOfRocks){
                gemCount++;
            }
        }       
        
        return gemCount;
    }    
}
