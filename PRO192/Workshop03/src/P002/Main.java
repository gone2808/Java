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
public class Main {
    public static void main(String[] args) {
        System.out.println("Atomic Information: ");
        Scanner sc = new Scanner(System.in);
        Atom[] atoms = new Atom[1000];
        int number,capicity=0;
        String symbol;
        String fullname;
        double weight;
        
        do{
            System.out.print("\nEnter atomic number : ");
            number = Integer.parseInt(sc.nextLine());
            if(number == 0){
                showInfor(atoms);
                break;
            }
            
            System.out.print("Enter symbol : ");
            symbol = sc.nextLine();
            System.out.print("Enter full name : ");
            fullname = sc.nextLine();
            System.out.print("Enter atomic weight : ");
            weight = Double.parseDouble(sc.nextLine());
            atoms[capicity++] = new Atom(number, symbol, fullname, weight);
            
        }while(true);
    }

    private static void showInfor(Atom[] atoms) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for(Atom A:atoms){
            if(A!=null) A.display();
        }
    }
}
