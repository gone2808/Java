/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS04;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Hourly extends Employee{
       private int hoursWorked;
   public Hourly(String eName, String eAddress, String ePhone, String socSecNumber, double rate)   
   {
                  super(eName, eAddress, ePhone, socSecNumber, rate);
      hoursWorked = 0;
   }
   public void addHours(int moreHours) {
      hoursWorked += moreHours;
   }

   public double pay() {
      double payment = payRate * hoursWorked;
      hoursWorked = 0;
      return payment;
   }

    public String display() {
        String result = super.display();
        result += "\nCurrent hours: " + hoursWorked;
        return result;
   }

}
