/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseConvert;
import java.lang.*;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Test {
    public static void main(String[] args) {
    // character array chararray1 with offset 2
    char[] chararr1 = new char[] { 't', 'u', 't', 's' };
    String str1 = String.valueOf(chararr1, 2, 2);
    // character array chararray2 with offset 1
    char[] chararr2 = new char[] { '2', '1', '5' };
    String str2 = String.valueOf(chararr2, 1, 2);
    // prints the string representations
    System.out.println(str1);
    System.out.println(str2);
}

}
