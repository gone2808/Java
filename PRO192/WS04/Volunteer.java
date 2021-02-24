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
public class Volunteer extends StaffMember{
        public Volunteer(String eName, String eAddress, String ePhone)
   {
            super(eName, eAddress, ePhone);
   }

        @Override
   public double pay() {
      return 0.0;
   }

}
