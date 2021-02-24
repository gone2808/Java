/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS08;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Student implements Comparable<Student>{
    private String name;
    private int age;
    private int mark;

    public Student() {
    }

    public Student(String name, int age, int mark) {
        this.name = name;
        this.age = age;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
    
    
    public void display(){
        System.out.format("%-15s%-20d%-10d\n",name,age,mark);
    }

    @Override
    public int compareTo(Student another) {
        if(this.mark>another.getMark()) return 1;
        else if(this.mark<another.getMark()){
            return -1;
        }
        else{
            return this.name.compareTo(another.getName());
        }
    }

    
}
