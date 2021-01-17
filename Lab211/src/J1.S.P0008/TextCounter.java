/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0008;

import java.util.*;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class TextCounter {
    private final String  content;
    private HashMap<String, Integer> words;
    private HashMap<Character, Integer> characters;

    public TextCounter(String content) {
        this.content = content;
        this.words = new HashMap<>();
        this.characters = new HashMap<>();
    }

    public HashMap<String, Integer> getWords() {
        return words;
    }

    public HashMap<Character, Integer> getCharacters() {
        return characters;
    }
    
    void cout(){
        this.words.clear();
        this.characters.clear();
        
        String delim="\\s+";
        
        String[] wordArr = this.content.split(delim);
        
        for (String word : wordArr) {
            if(!words.containsKey(word)){
                words.put(word, 1);
            }
            else{
                words.replace(word, words.get(word)+1);
            }
            
            
            for(int i=0;i<word.length();i++){
                if(!characters.containsKey(word.charAt(i))){
                    characters.put(word.charAt(i), 1);
                }
                else{
                    characters.replace(word.charAt(i), characters.get(word.charAt(i))+1);
                }
            }
        }
        
        
    }
    
    
    
    
}
