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
public class Officer extends Person{
    private double bSalary;

    public Officer() {
    }

    public Officer(String name, double bSalary) {
        super(name);
        this.bSalary = bSalary;
    }

    @Override
    public void display() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.format("Name: %-15s - Salary: %-15f\n",getName(),getSalary());
    }

    @Override
    public double getSalary() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return bSalary;
    }
    
    
}
