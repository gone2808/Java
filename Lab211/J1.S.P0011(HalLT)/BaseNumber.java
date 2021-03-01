/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseConvert;

import static java.lang.Integer.toString;
import java.util.*;
import java.util.regex.Pattern;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class BaseNumber {
    final static char[] Mydigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    public static String Base(String msg) {
        Scanner sc = new Scanner(System.in);
        String s;
        do {
            System.out.println(msg);
            try {
                s = sc.nextLine();
                if (s.equalsIgnoreCase("2") || s.equalsIgnoreCase("10") || s.equalsIgnoreCase("16")
                        || s.equalsIgnoreCase("8"))
                    return s;
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (true);
    }

    public static String Input(String inBase) {
        Scanner sc = new Scanner(System.in);
        do {
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
        } while (true);
    }

    public static String getOct(String msg) {
        Scanner sc = new Scanner(System.in);
        String Oct_pattern = "^-{0,1}[0-7]+$";
        String x;
        do {
            System.out.println(msg);
            try {
                x = sc.nextLine();
                if (Pattern.matches(Oct_pattern, x)) {
                    return x;
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } while (true);
    }

    public static String getBin(String msg) {
        Scanner sc = new Scanner(System.in);
        String Bin_pattern = "^[01]+$";
        String x;
        do {
            System.out.println(msg);
            try {
                x = sc.nextLine();
                if (Pattern.matches(Bin_pattern, x)) {
                    return x;
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } while (true);
    }

    public static String getHex(String msg) {
        Scanner sc = new Scanner(System.in);
        String Hex_pattern = "^-{0,1}[\\da-fA-F]+$";
        String x;
        do {
            System.out.println(msg);
            try {
                x = sc.nextLine();
                if (Pattern.matches(Hex_pattern, x)) {
                    return x;
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } while (true);
    }

    public static String getDec(String msg) {
        Scanner sc = new Scanner(System.in);
        String DEC_pattern = "^-{0,1}[0-9]+$";
        String x;
        do {
            System.out.println(msg);
            try {
                x = sc.nextLine();
                if (Pattern.matches(DEC_pattern, x)) {
                    return x;
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } while (true);
    }

    public static String BaseConvertion(String inBase, String s, String outbase) throws BaseException {
        String DecValue;

        if (inBase.equalsIgnoreCase(outbase)) {
            return s;
        }

        if (inBase.equals("2")) {
            DecValue = Integer.toString(TwoComplementBinToDec(s));
            if (outbase.equals("10")) {
                return DecValue;
            } else {
                return MytoString(Integer.parseInt(DecValue), 16);

            }

        }
        if (outbase.equals("2")) {
            return DecToTwoComplementBin(s);
        } else
            return MytoString(MyparseInt(s, Integer.parseInt(inBase)), Integer.parseInt(outbase));
    }

    public static int MyparseInt(String s, int radix) throws BaseException {
        int result = 0;
        boolean negative = false;
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        if (len > 0) {
            char firstChar = s.charAt(0);
            if (firstChar < '0') {
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+')
                    throw new BaseException("Wrong format");

                if (len == 1)
                    throw new BaseException("Wrong format");
                i++;
            }
            
            
            multmin = limit / radix;
            while (i < len) {

                digit = Character.digit(s.charAt(i++), radix);
//                 System.out.println("Check: "+digit);
//                if (digit < 0) {
//                    throw new BaseException("");
//                }
                if (result < multmin) {
                    throw new BaseException("Out of Limits");
                }
                result *= radix;
                if (result < limit + digit) {
                    throw new BaseException("Out of Limits");
                }
                result -= digit;
            }
        } else {
            throw new BaseException("countDigit = 0");
        }
        return negative ? result : -result;
    }

    public static String MytoString(int i, int radix) {

        if (radix == 10) {
            return Integer.toString(i);
        }

        char buf[] = new char[33];

        boolean negative = (i < 0);
        int charPos = 32;

        if (!negative) {
            i = -i;
        }

        while (i <= -radix) {
            buf[charPos--] = Mydigits[-(i % radix)];
            i = i / radix;
        }
        buf[charPos] = Mydigits[-i];

        if (negative) {
            buf[--charPos] = '-';
        }

        return new String(buf, charPos, (33 - charPos));
    }

    public static int TwoComplementBinToDec(String s) throws BaseException {
        boolean Negative = (s.charAt(0) == '1');
        if (!Negative) {
            return MyparseInt(s, 2);
        } else {
            String temp = "";
            int k = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '0') {
                    temp = "0" + temp;
                } else {
                    k = --i;
                    temp = "1" + temp;
                    break;
                }
            }

            for (int i = k; i >= 0; i--) {
                if (s.charAt(i) == '1') {
                    temp = "0" + temp;
                } else {
                    temp = "1" + temp;
                }
            }

//             System.out.println(temp);
            return Negative ? (-1) * MyparseInt(temp, 2) : MyparseInt(temp, 2);
        }
    }

    public static String DecToTwoComplementBin(String s) {
        boolean Negative = (s.charAt(0) == '-');
        String res = "0" + MytoString(Integer.parseInt(s), 2);

        if (!Negative) {
            return res;
        } else {
            String temp = "";
            int pos = -1;
            for (int i = res.length() - 1; i >= 0; i--) {
                if (res.charAt(i) == '1') {
                    temp = "1" + temp;
                    pos = i--;
                    break;
                } else {
                    temp = "0" + temp;
                }
            }

            for (int i = pos; i >= 0; i--) {
                if (res.charAt(i) == '1') {
                    temp = "0" + temp;
                } else {
                    temp = "1" + temp;
                }
            }

            return temp;

        }
    }
}
