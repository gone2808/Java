/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS7;

import java.util.Arrays;

/**
 *
 * @author Ryuunosuke Akasaka
 */
class RightTriangle{
	int a, b, c;

//Constructor
public RightTriangle(int a, int b, int c)  
    throws IllegalTriangleException, IllegalRightTriangleException{
	//implement it
         this.a=a;
         this.b=b;
         this.c=c;
         int[] arr = {a,b,c};
         Arrays.sort(arr);
//         if((arr[0]*arr[0]+arr[1]*arr[1])==(arr[2]*arr[2])){           
//         }
//         else if(a+b>c && b+c>a && c+a>b) {
//             throw new IllegalRightTriangleException("This is not a right triangle");
//         }
//         else throw new IllegalTriangleException("This is not a triangle!");
//         
//         
         if(a+b>c && b+c>a && c+a>b){ 
            if((arr[0]*arr[0]+arr[1]*arr[1])!=(arr[2]*arr[2]))
                
            throw new IllegalRightTriangleException("This is not a right triangle");
         }
         else throw new IllegalTriangleException("This is not a triangle!"); 
}

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
    



}
