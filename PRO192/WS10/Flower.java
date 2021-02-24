/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS10;

import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Flower {
    private String Name;
    private double Price;
    private String Color;

    public Flower() {
    }

    public Flower(String Name, double Price, String Color) {
        this.Name = Name;
        this.Price = Price;
        this.Color = Color;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        
        Name = Utility.GetString("Enter Flower's Name: ", false);
        
        Price = Utility.GetDouble("Enter Flower's Price: ", 0.0001, Double.MAX_VALUE);
        
        Color = Utility.GetString("Enter Flower's Color", false);
    }

    @Override
    public String toString() {
        return this.Name+" "+this.Price+" "+this.Color;
    }

    @Override
    public boolean equals(Object Otherobj) {
        if(this == Otherobj) return true;
        if(Otherobj == null) return false;
        
        if(!(this.getClass() == Otherobj.getClass())) return false;
        
        Flower o = (Flower) Otherobj;
        
        return Objects.equals(this.getName(), o.getName()) 
                && ( this.getPrice() == o.getPrice() )
                && Objects.equals(this.getColor(), o.getColor());
        
    }
    
    
    
}
