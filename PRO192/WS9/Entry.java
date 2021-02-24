/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS9;

import java.util.*;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Entry {
    public static void main(String[] args) {
        
    HashSet<DictionaryWord> sortedSet2 = new HashSet<>();
       
       
    
    sortedSet2.add(new DictionaryWord("burglar","Break into a home to steal things"));
    sortedSet2.add(new DictionaryWord("forget","Makes an illegal copy of something"));
    sortedSet2.add(new DictionaryWord("hacker","Breaks into a computer system"));
    sortedSet2.add(new DictionaryWord("hijacker","Takes control of an airplane"));
    sortedSet2.add(new DictionaryWord("kidnapper","Holds someone for ransom money"));
    sortedSet2.add(new DictionaryWord("mugger","Attacks and steals money from someone"));
    sortedSet2.add(new DictionaryWord("murderer","Kill another person"));
    sortedSet2.add(new DictionaryWord("back robber","Steals money from a bank"));
    sortedSet2.add(new DictionaryWord("back robber","Steals money from a bank"));
    sortedSet2.add(new DictionaryWord("back robber","Steals money from a bank")); 
      
    int c2=1;
    
    Iterator iter2=sortedSet2.iterator();
    
        while (iter2.hasNext()) {
            DictionaryWord word2 = (DictionaryWord)iter2.next();
            word2.setNo(c2++);
            System.out.println(word2.toString());
      
        }
        
        System.out.println("\n\n\n");
//        **************************************************
    TreeSet<DictionaryWord> sortedSet = new TreeSet<>();
       
       
    
    sortedSet.add(new DictionaryWord("burglar","Break into a home to steal things"));
    sortedSet.add(new DictionaryWord("forget","Makes an illegal copy of something"));
    sortedSet.add(new DictionaryWord("hacker","Breaks into a computer system"));
    sortedSet.add(new DictionaryWord("hijacker","Takes control of an airplane"));
    sortedSet.add(new DictionaryWord("kidnapper","Holds someone for ransom money"));
    sortedSet.add(new DictionaryWord("mugger","Attacks and steals money from someone"));
    sortedSet.add(new DictionaryWord("murderer","Kill another person"));
    sortedSet.add(new DictionaryWord("back robber","Steals money from a bank"));
    sortedSet.add(new DictionaryWord("back robber","Steals money from a bank"));
    sortedSet.add(new DictionaryWord("back robber","Steals money from a bank")); 
      
    int c=1;
    
    Iterator iter=sortedSet.iterator();
    
        while (iter.hasNext()) {
            DictionaryWord word = (DictionaryWord)iter.next();
            word.setNo(c++);
            System.out.println(word.toString());
      
        }
    }
    
    
}
