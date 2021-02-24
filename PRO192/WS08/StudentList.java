/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS08;

import java.io.BufferedWriter;
import java.io.File;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class StudentList {
    private Student[] list=null;
    private int count=0;

    public StudentList(int size) {
        if(size<10) size=10; // 
        list = new Student[size];
    }
    
    public void add(){
        if(count==list.length) System.out.println("List is full!");
        else{
            String Name;
            int Age;
            int Mark;
            Scanner sc = new Scanner(System.in);
            Name = Utility.GetString("Enter Student's name: ", false);
            Age = Utility.GetInt("Enter student's age: ", 1, 30);
            Mark = Utility.GetInt("Enter Student's mark: ", 0, 10);
            list[count++] = new Student(Name, Age, Mark);
            System.out.println("New student have been added!");
        }
    }
    public void print(){
        if(count==0){
            System.out.println("Emtpy list.");
            return;
        }
        
        Arrays.sort(list);
        System.out.println("List of Students");
        for(int i=0;i<count;i++){
            list[i].display();
        }
    }
    
}
