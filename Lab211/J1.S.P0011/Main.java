/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0011;

import java.util.Scanner;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Main {
    public static void main(String[] args) {
        String sBase = BaseNumber.Base("Source Base: ");
        String input = BaseNumber.Input(sBase);
        String dBase = BaseNumber.Base("Destination Base: ");
        System.out.println(BaseNumber.BaseConvertion(sBase,input, dBase));
    }
}
