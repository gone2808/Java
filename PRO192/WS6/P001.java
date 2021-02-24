/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class P001 {

    public static String fixFirstLowtoUp(String s1) {
        if ("".equals(s1)) {
            return s1;
        }
        if (s1.charAt(0) >= 'a' && s1.charAt(0) <= 'z') {
            return (s1.charAt(0) + "").toUpperCase() + s1.substring(1, s1.length());
        }
        return s1;
    }

    public static String fixFirstUptoLow(String s1) {
        if ("".equals(s1)) {
            return s1;
        }
        if (s1.charAt(0) >= 'A' && s1.charAt(0) <= 'Z') {
            return (s1.charAt(0) + "").toLowerCase() + s1.substring(1, s1.length());
        }
        return s1;
    }

    public static String fixLastLowtoUp(String s1) {
        if ("".equals(s1)) {
            return s1;
        }
        if (s1.charAt(s1.length() - 1) >= 'a' && s1.charAt(s1.length() - 1) <= 'z') {
            return s1.substring(0, s1.length() - 1) + (s1.charAt(s1.length() - 1) + "").toUpperCase();
        }
        return s1;
    }

    public static void F01(String s) {
        if (s.contains("me")) {
            System.out.println("me :Found");
        } else {
            System.out.println("\"me\" : Not Found");
        }

        if (s.contains("why")) {
            System.out.println("me :Found");
        } else {
            System.out.println("\"why\" : Not Found");
        }

        if (s.contains("well")) {
            System.out.println("me :Found");
        } else {
            System.out.println("\"well\" : Not Found");
        }
        System.out.println("");
    }

    public static void F02(String s) {
        int count = 0;
        int i = 0;
        while (s.indexOf("you", i) != -1) {
            count++;
            i = s.indexOf("you", i) + 1;
        }
        System.out.println("\"you\" apper: " + count);
    }

    public static String F03(String s) {
        String deli = "[\\s]+";
        String[] word = s.split(deli);
        String res = "";
        for (int i = 0; i < word.length; i++) {
            word[i] = fixFirstLowtoUp(word[i]);
            res += (word[i] + " ");
        }
        return res;

    }

    public static String F04(String s) {
        String deli = "[\\s]+";
        String[] word = s.split(deli);
        String res = "";
        for (int i = 0; i < word.length; i++) {
            word[i] = fixFirstUptoLow(word[i]);
            word[i] = fixLastLowtoUp(word[i]);
            res += (word[i] + " ");
        }
        return res;

    }

    public static void F05(String s) {
        String deli = "[\\s]+";
        String[] word = s.split(deli);
        Arrays.sort(word);
        for (String w : word) {
            System.out.println(w);
        }
    }

    public static String F06(String s, char c) {
        if ("".equals(s)) {
            return s;
        }
        int index = s.indexOf(c + "");
        if (index >= 0) {
            return s.substring(0, index ) + s.substring(index+1, s.length());
        }

        return s;
    }

    public static void F07(String s) {
        String deli = "[\\s]+";
        String[] word = s.split(deli);
        if (word.length == 0) {
            System.out.println("Empty words");
            return;
        }

        System.out.println("Number of words: " + word.length);

    }

    public static void F08(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                System.out.print(s.charAt(i));
            } else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                System.out.print(s.charAt(i));
            }
        }
        System.out.println("");
    }

    public static void F09(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            System.out.print(s.charAt(i));
        }
        System.out.println("");
    }

    public static String F10(String s) {
        s = s.replace("a", "A");
        s = s.replace("b", "B");
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.print("1, \n");
        F01(s);
        System.out.print("2, ");
        F02(s);
        System.out.println("3," + F03(s));
        System.out.println("4, " + F04(s));
        System.out.print("5, \n");
        F05(s);
        System.out.print("Nhap c: ");
        char c= sc.nextLine().charAt(0);
        System.out.println("6, " + F06(s, c));
        System.out.print("7, ");
        F07(s);
        System.out.print("8, ");
        F08(s);
        System.out.print("9, ");
        F09(s);
        System.out.println("10, " + F10(s));

    }
}
