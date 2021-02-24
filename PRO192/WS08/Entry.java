/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS08;

import java.io.File;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Entry {

    public static void main(String[] args) {
        Menu menu = new Menu(3);
        menu.add("Add new Students");
        menu.add("List");
        menu.add("Quit");
        int choice;
        StudentList list = new StudentList(50);
        do {
            System.out.println("\nStudent Manager");
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    list.add();
                    break;
                case 2:
                    list.print();
                    break;
            }
        } while (choice!=3 );
    }
}
