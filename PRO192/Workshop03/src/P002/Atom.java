/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P002;

import java.util.Scanner;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Atom {
    private int number;
    private String symbol;
    private String fullname;
    private double weight;

    public static int capicity;
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Atom() {
    }
    
    
    public Atom(int number, String symbol, String fullname, double weight) {
        this.number = number;
        this.symbol = symbol;
        this.fullname = fullname;
        this.weight = weight;
        capicity++;
    }
    
    
    
    public void display(){
        System.out.format("%-5d%-15s%-15s%.3f\n",number,symbol,fullname,weight);
    }
}

