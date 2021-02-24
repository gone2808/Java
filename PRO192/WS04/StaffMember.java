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
abstract class StaffMember {
        private String name;
    private String address;
    protected String phone;

    public String getName()
	{ return name;}
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getAddress()
	{return address;}
	
    public void setAddress(String address)
    {
        this.address = address;
    }
    

    public StaffMember(String eName,
        String eAddress, String ePhone) {
        name = eName;
        address = eAddress;
        phone = ePhone;
   }

    public String display() {
      String result = "Name: " + name + "\n";
      result += "Address: " + address + "\n";
      result += "Phone: " + phone;
      return result;
   }

    public abstract double pay();

}
