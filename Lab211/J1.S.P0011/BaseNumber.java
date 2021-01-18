/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0011;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class BaseNumber {
    
    public static String BaseConvertion(String inBase,String s,String outbase){
            if (inBase.equalsIgnoreCase(outbase)) {
                return s;
            }
            return Integer.toString(
                    Integer.parseInt(s, Integer.parseInt(inBase)), Integer.parseInt(outbase)
            );    
    }
    
    public static String Base(String msg){
        Scanner sc = new Scanner(System.in);
        String s;
        do {            
            System.out.println(msg);
            try {
                s=sc.nextLine();
                if(s.equalsIgnoreCase("2") || s.equalsIgnoreCase("10") || s.equalsIgnoreCase("16") || s.equalsIgnoreCase("8"))
                    return s;
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (true);
    }
    public static String Input(String inBase){
        Scanner sc = new Scanner(System.in);
        do{
            try {
                if (inBase.equalsIgnoreCase("2")) {  
                    return getBin("Input Bin: ");
                }
                if (inBase.equalsIgnoreCase("10")) {
                    
                    return getDec("Input Dec: ");
                }
                if (inBase.equalsIgnoreCase("8")) {
                    
                    return getOct("Input Oct: ");
                }
                if (inBase.equalsIgnoreCase("16")) {
                    
                    return getHex("Input Hex: ");
                }
                
            } catch (Exception e) {
                System.out.println(e);
            }
        }while(true);
    }
    
     public static String getOct(String msg){
        Scanner sc = new Scanner(System.in);
        String Oct_pattern="^[0-7]+$";
        String x;
        do{
            System.out.println(msg);
            try {
                x = sc.nextLine();
                if (Pattern.matches(Oct_pattern, x)) {
                    return x;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }while(true);
    }
    
    public static String getBin(String msg){
        Scanner sc = new Scanner(System.in);
        String Bin_pattern="^[01]+$";
        String x;
        do{
            System.out.println(msg);
            try {
                x = sc.nextLine();
                if (Pattern.matches(Bin_pattern, x)) {
                    return x;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }while(true);
    }
    public static String getHex(String msg){
        Scanner sc = new Scanner(System.in);
        String Hex_pattern="^[\\da-fA-F]+$";
        String x;
        do{
            System.out.println(msg);
            try {
                x = sc.nextLine();
                if (Pattern.matches(Hex_pattern, x)) {
                    return x;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }while(true);
    }
    public static String getDec(String msg){
        Scanner sc = new Scanner(System.in);
        String DEC_pattern = "^[-{0,1}][0-9]+$";
        String x;
        do{
            System.out.println(msg);
            try {
                x = sc.nextLine();
                if (Pattern.matches(DEC_pattern, x)) {
                    return x;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }while(true);
    }
}
