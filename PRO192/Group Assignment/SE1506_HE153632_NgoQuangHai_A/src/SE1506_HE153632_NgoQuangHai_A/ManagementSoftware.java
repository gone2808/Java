/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE1506_HE153632_NgoQuangHai_A;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class ManagementSoftware {
    private List<Customer> myList = new LinkedList();
    private int listSize=0;
    private int slotCount=0;
    private int[] available= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private int[] from=      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private int[] to=        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private int[] mask=      {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private final int slotlength=7,fromlength=6,tolength=6,NAClength=20;
    
    /**
    * @param fileCustomer
    */
    public void writeCustomer(int ID,int roomID,String name,int age){
    //  File fileStudent = new File("List of Students.txt");
        String currPath = System.getProperty("user.dir");
        File f = new File(currPath + "\\src\\SE1506_HE153632_NgoQuangHai_A\\Customers.txt");
        try {

       //fileStudent.createNewFile();
             FileWriter fwDemo = new FileWriter(f, true);
            BufferedWriter bfDemo = new BufferedWriter(fwDemo);
            bfDemo.write(ID+"\t"+roomID+"\t"+name+"\t"+age+"\n");
            bfDemo.flush();
            bfDemo.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
     }
    public void readCustomer(){
        String currPath = System.getProperty("user.dir");
        File f = new File(currPath + "\\src\\SE1506_HE153632_NgoQuangHai_A\\Customers.txt");
        try {
            FileReader frDemo = new FileReader(f);
            BufferedReader brDemo = new BufferedReader(frDemo);
            String line="";
            int i = 0;
            while((line=brDemo.readLine())!=null){
    //    System.out.println(++i+":"+line);
                String word[]= line.split("[\t]+");
                myList.add( new Customer(++listSize,Integer.parseInt(word[1]),word[2],Integer.parseInt(word[3])));
            }
            frDemo.close();
            brDemo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
     }
    /**
     * FileSlot
     */
    public void readSlot(){
        String currPath = System.getProperty("user.dir");
        File f = new File(currPath + "\\src\\SE1506_HE153632_NgoQuangHai_A\\Slots.txt");
        try {
            FileReader frDemo = new FileReader(f);
            BufferedReader brDemo = new BufferedReader(frDemo);
            String line="";
            int i = 0;
            while((line=brDemo.readLine())!=null){
    //    System.out.println(++i+":"+line);
                String word[]= line.split("[\t]+");
                from[Integer.parseInt(word[0])]=Integer.parseInt(word[1]);
                to[Integer.parseInt(word[0])]=Integer.parseInt(word[2]);
                Main.from[Integer.parseInt(word[0])]=Integer.parseInt(word[1]);
                Main.to[Integer.parseInt(word[0])]=Integer.parseInt(word[2]);
                mask[Integer.parseInt(word[0])]=mask[Integer.parseInt(word[0])-1]*2;
                available[Integer.parseInt(word[0])]=10;
                slotCount=Integer.parseInt(word[0]);
            }
            frDemo.close();
            brDemo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
     }
     /**
      * FileRegister
      */
    public void writeRegisters(String date,int hour,int ID,int slot){
    //  File fileStudent = new File("List of Students.txt");
        String currPath = System.getProperty("user.dir");
        File f = new File(currPath + "\\src\\SE1506_HE153632_NgoQuangHai_A\\Registers.txt");
        try {

       //fileStudent.createNewFile();
             FileWriter fwDemo = new FileWriter(f, true);
            BufferedWriter bfDemo = new BufferedWriter(fwDemo);
            bfDemo.write(date+"\t"+hour+"\t"+ID+"\t"+slot+"\n");
            bfDemo.flush();
            bfDemo.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
     }
     public void readRegisters(String date,int hour){
        String currPath = System.getProperty("user.dir");
        File f = new File(currPath + "\\src\\SE1506_HE153632_NgoQuangHai_A\\Registers.txt");
        try {
            FileReader frDemo = new FileReader(f);
            BufferedReader brDemo = new BufferedReader(frDemo);
            String line="";
            int i = 0;
            while((line=brDemo.readLine())!=null){
    //    System.out.println(++i+":"+line);
                String word[]= line.split("[\t]+");
                if(word[0].equals(date))
                    if(hour<from[Integer.parseInt(word[3])])
                    {
                          this.setBookStatus(Integer.parseInt(word[2]),Integer.parseInt(word[3])); 
                    }
            }
            frDemo.close();
            brDemo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
     }
    public void clear()
    {
        myList.clear();
        listSize=0;
    }
    
    public void add(int roomID, String name, int age)
    {
        this.myList.add(new Customer(++listSize,roomID,name,age));
        this.writeCustomer(listSize, roomID, name, age);
    }
    public int getSize()
    {
        return myList.size();
    }

    public int getAvailable(int Index) {
        return available[Index];
    }
    
    public void setAvailable(int Index,int Value) {
        available[Index]=Value;
    }

    public int getSlotCount() {
        return slotCount;
    }
    
    
    public void display() {
        System.out.println("List of all customers:");
        System.out.println("ID  Room ID   Name                Age ");
        for(Customer c: myList)
            System.out.println(c.toString());
    }

    public boolean displaySlot(int customerID,int currentHour) {
        boolean flag=false;
        System.out.println("Slot   From  To    NoAvailableComputers");
        for(int i=1;i<=slotCount;i++)
            if(from[i]>currentHour)
            {
                if(available[i]>0) flag=true;
                String res="";

                res+=Integer.toString(i);
                int missing = slotlength-Integer.toString(i).length();
                for(int j=0;j<missing;j++) res+=" ";

                res+=Integer.toString(from[i]);
                missing = fromlength-Integer.toString(from[i]).length();
                for(int j=0;j<missing;j++) res+=" ";

                res+=Integer.toString(to[i]);
                missing = tolength-Integer.toString(to[i]).length();
                for(int j=0;j<missing;j++) res+=" ";


                res+=Integer.toString(available[i]);
                missing = NAClength-Integer.toString(available[i]).length();
                for(int j=0;j<missing;j++) res+=" ";
                if(this.checkBooked(customerID, i))
                {
                    res=Main.ANSI_GREEN_BACKGROUND+res;
                }
                else 
                if(available[i]==0) 
                {
                    res=Main.ANSI_RED_BACKGROUND+res;
                }
                
                System.out.println(res);
                
            }
        return flag;
    }

    public boolean checkBooked(int customerID,int cSlot) {
        return ((myList.get(customerID-1).getBookStatus()&mask[cSlot])!=0);
    }

    public void setBookStatus(int customerID, int cSlot) {
       myList.get(customerID - 1).setBookStatus(myList.get(customerID - 1).getBookStatus()|mask[cSlot]);
       this.setAvailable(cSlot, this.getAvailable(cSlot)-1);
    }

    void displayBookStatus(int customerID, int currentHour) {
        System.out.println("Time slots register by "+myList.get(customerID-1).getName());
        System.out.println("Slot   From  To    ");
        for(int i=1;i<=slotCount;i++)
            if(from[i]>currentHour)
            {
                if(((myList.get(customerID-1).getBookStatus()&mask[i])!=0))
                {
                    String res="";

                    res+=Integer.toString(i);
                    int missing = slotlength-Integer.toString(i).length();
                    for(int j=0;j<missing;j++) res+=" ";

                    res+=Integer.toString(from[i]);
                    missing = fromlength-Integer.toString(from[i]).length();
                    for(int j=0;j<missing;j++) res+=" ";

                    res+=Integer.toString(to[i]);
                    missing = tolength-Integer.toString(to[i]).length();
                    for(int j=0;j<missing;j++) res+=" ";
                    
                    res=Main.ANSI_GREEN_BACKGROUND+res;
                    System.out.println(res);
                }
            }
    }
    
}
