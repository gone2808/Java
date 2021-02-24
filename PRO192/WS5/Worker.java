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
public class Worker extends Person{
    private double hrs;
    final double RATE = 5.5;

    public Worker() {
    }

    public Worker(String name, double hrs) {
        super(name);
        this.hrs = hrs;
    }

    @Override
    public void display() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.format("Name: %-15s - Salary: %-15f\n",getName(),getSalary());
    }

    @Override
    public double getSalary() {
        return RATE*hrs;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
