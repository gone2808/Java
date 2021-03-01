/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0052;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import static java.lang.Math.sqrt;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Utility {
    public static final int MaxN=(int) (1e5+5);
    
    public static boolean is_Prime(int x){
        if(x<2) return false;
        for(int i=2;i<=sqrt(x);i++)
            if(x%i==0) return false;
        return true;
    }
    
    public static int countDigit(int x){
        int count=0;
        while(x>0){
            count++;
            x/=10;
        }
        return count;
    }
    
    public static int GetInt(String msg, int min,int max){
        int i;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print(msg);
            try {
                i=Integer.parseInt(sc.nextLine());
                if(i>=min && i<=max)
                    return i;
                
            } catch (Exception e) {
                System.out.println(e);
            }
        }while(true);    
    }
    
    public static double GetDouble(String msg,double min,double max){
        double i;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print(msg);
            try {
                i = Double.parseDouble(sc.nextLine());
                if (i > min && i <= max) {
                    return i;
                }
            }catch (Exception e) {
                System.out.print(e);
            }
        }while(true);
    }
    public static String GetString(String msg,boolean isEmpty){
        String s;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print(msg);
            try {
                s=sc.nextLine();
                if(isEmpty){
                    return s;
                }
                else if(!s.isEmpty()){
                    return s;
                }
            } catch (Exception e) {
                System.out.print(e);
            }
        }while(true);
    }
    
    public static boolean GetYesNo(String msg){
        String s;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print(msg);
            try {
                s=sc.next("[yn]");
                break;
            } catch (Exception e) {
                System.out.print(e);
                sc.nextLine();
            }
        }while(true);
        
        return s.charAt(0) == 'y';
    }
    
    public static Date GetDate(String msg){
        Date date = new Date();
        SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
        SDF.setLenient(false);
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println(msg);
            String sDate = sc.nextLine();
            try {
                date = SDF.parse(sDate);
                return date;
            } catch (Exception e) {
                System.out.print(e);
            }
        }while(true);
        
    }
    
    public static String getPhone(String msg){
        String PHONE_PATTERN="^[\\d]{10,13}";
        String s;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println(msg);
            try {
                s = sc.nextLine();
                if(Pattern.matches(PHONE_PATTERN, s))
                    return s;
            } catch (Exception e) {
                System.out.print(e);
            }
        }while(true);
            
    }
    public static String getEmail(String msg){
        
        String EMAIL_PATTERN = "^[A-Za-z]\\S+@\\w+(\\.\\w+){1,3}$";        
        String s;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println(msg);
            try {
                s = sc.nextLine();
                if(Pattern.matches(EMAIL_PATTERN, s)==true)
                    return s;
            } catch (Exception e) {
                System.out.print(e);
            }
        }while(true);
    }
    
    public static int MyBinarySearch(int[] arr,int l,int r, int x){
        
        while(l<r){
            int m=l+(r-l)/2; 
            if(arr[m]<x){
                l=m+1;
            }
            else{
                r=m;
            }
        }
        if(arr[l]==x) return l  ;
        return -1; 
    }
    public static void MyQuickSort(int[] arr,int l,int r){
        int p = l+(r-l)/2;
        int i=l,j=r;
        while(i<j){
            while(arr[i]<arr[p]) i++;
            while(arr[j]>arr[p]) j--;
            if(i<=j){
                int temp = arr[j];
                arr[j]=arr[i];
                arr[i] = temp;
                i++;
                j--;
            }
        }
        if(i<r) MyQuickSort(arr, i, r);
        if(l<j) MyQuickSort(arr, l, j);
        
    }
    public static void mergeArr(int[] arr,int l,int m ,int r){
        int n1=m-l+1;
        int n2=r-m;
        int[] La = new int[n1];
        int[] Ra = new int[n2];
        int[] C = new int[n1+n2+1];
        int i,j,size=0;
        for(i=0;i<n1;i++){
            La[i]=arr[i+l];
        }
        for(j=0;j<n2;j++){
            Ra[j]=arr[m+1+j];
        }
        i=0;
        j=0;
        while(i<n1 && j<n2){
            if(La[i]>Ra[j]){
                C[size++]=Ra[j++];
            }
            else{
                C[size++]=La[i++];
            }
        }
        while(i<n1){
            C[size++]=La[i++];
        }
        while(j<n2){
            C[size++]=Ra[j++];
        }
        for(i=0;i<size;i++) arr[i+l]=C[i];
    }
    public static void MyMergeSort(int[] arr,int l,int r){   
        if(l<r){
            int m = l+(r-l)/2;
            MyMergeSort(arr, l, m);
            MyMergeSort(arr, m+1, r);
            mergeArr(arr, l, m, r);
            
        }
    }
    
    
    
}
