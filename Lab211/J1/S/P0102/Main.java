/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0102;

import java.util.*;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Main {
    public static void main(String[] args) {
        Date d1 = J1.S.P0103.Utility.GetDate("Enter the first date: ");
        System.out.println(Utility.DoW(d1));
    }
}
