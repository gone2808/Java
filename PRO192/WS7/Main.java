/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS7;

import java.util.Scanner;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Main {
    public static void main(String[] args) {
        int a, b, c;
        Scanner nhap = new Scanner(System.in);
        while (true) {
            //enter integer a here with input validation
            a = Utility.GetInt("Input right format of side a:",1,Integer.MAX_VALUE);
            //enter integer b here with input validation
            b = Utility.GetInt("Input right format of side b:",1,Integer.MAX_VALUE);
            //enter integer c here with input validation
            c = Utility.GetInt("Input right format of side c:",1,Integer.MAX_VALUE);
            try {
                //call constructor of RightTriangle class
                RightTriangle rt = new RightTriangle(a, b, c);
                System.out.println("This is a right triangle!");
            } catch (IllegalTriangleException e2) {
                System.out.println(e2.getMessage()); 
//                “This is not a triangle!”
            } catch (IllegalRightTriangleException e1) {
                System.out.println(e1.getMessage());
//                “This is not a right triangle”
            }
            //continue?
            System.out.print("Continue?(Y/N):");
            //Enter a character
            char chon;
            do{
            chon = nhap.next().charAt(0);
            }
            while(chon!='N' && chon!='Y');
            if(chon != 'Y')
                break;
        }
    }

}
