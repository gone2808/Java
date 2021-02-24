/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS5;

import java.util.Scanner;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Entry {
    public static void main(String[] args) {
       Person [] e = new Person[10];
        int n = 0, c = 0;
        do{
            System.out.println("0 - display the list: ");
            System.out.println("1 - add a worker: ");
            System.out.println("2 - add a Officer: ");
            Scanner in = new Scanner(System.in);
            c = Utility.GetInt((""), 0, 2);
            if(c == 1){
                //accept information of worker
                //System.out.print("Enter worker name: ");
                String name = Utility.GetString("Enter worker name: ", false);
                //System.out.print("Enter worker working hours: ");
                double hrs = Utility.GetDouble("Enter worker working hours: ", 0, 24);
                e[n] = new Worker(name, hrs);
                
                n++;
            }else if(c == 2){
                //accept information of Officer
                //System.out.print("Enter Officer name: ");
                String name = Utility.GetString("Enter Officer name: ", false);
                //System.out.print("Enter officer salary: ");
                double salary = Utility.GetDouble("Enter officer salary: ", 0, Double.MAX_VALUE);
                e[n] = new Officer(name, salary);
                n++;
            }
        }while(c != 0);
        //print all objects of e
        for(int i = 0; i < n; i++){
            //print the instance of Worker only
            e[i].display();
        }


    }
}
