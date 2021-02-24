/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS10;

import java.util.*;


/**
 *
 * @author Ryuunosuke Akasaka
 */
public class ListFlower {
    private LinkedList<Flower> list = new LinkedList<Flower>();
    private int count=0;
    private int size=0;
 
    public void listSize(int size){
        this.size = size;
    }
    
    
    
    public void add(){
        if(count==size) {
            System.out.println("List is full");
        }
        else{
            String newName;
            double newPrice;
            String newColor;
            
            newName = Utility.GetString("Enter new Flower's name: ", false);
            newPrice = Utility.GetDouble("Enter new Flower's Price: ", 0, Double.MAX_VALUE);
            newColor = Utility.GetString("Enter new Flower's", true);
            
            }
        }
}
