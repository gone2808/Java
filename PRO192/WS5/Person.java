/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS5;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public abstract class Person {
   private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
   public abstract void display();
   public abstract double getSalary();
}
