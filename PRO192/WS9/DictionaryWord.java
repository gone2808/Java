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
public class DictionaryWord implements Comparable<DictionaryWord>{
    private String word;
    private String meanings;
    private int no;

    
    public DictionaryWord(String word, String meanings) {
        
        this.word = word;
        this.meanings = meanings;
    }
    
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeanings() {
        return meanings;
    }

    public void setMeanings(String meanings) {
        this.meanings = meanings;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public boolean equals(Object obj) {
        DictionaryWord c = (DictionaryWord) obj;
        return this.word.equals(c.getWord());
    }

    @Override
    public int hashCode() {
       return word.hashCode();
    }

    

    
    
    @Override
    public int compareTo(DictionaryWord another) {
        return this.word.compareTo(another.getWord());
    }

    @Override
    public String toString() {
        return this.no+"  "+this.word+"  "+this.meanings+"\n"; //To change body of generated methods, choose Tools | Templates.
    }
      
    
    
}
