/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0008;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextCounter content = new TextCounter(sc.nextLine());
        content.cout();
        System.out.println(content.getWords());
        System.out.println(content.getCharacters());
        
        
        
    }
}
