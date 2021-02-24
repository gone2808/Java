    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE1506_HE153632_NgoQuangHai_A;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Customer {
    private int ID;
    private int roomID;
    private String name;
    private int age;
    private int bookStatus;
    private final int IDlength=4,roomIDlength=10,namelength=20,agelength=4;
    public Customer() {
    }

    public Customer(int ID,int roomID, String name, int age) {
        this.ID = ID;
        this.roomID = roomID;
        this.name = name;
        this.age = age;
        this.bookStatus=0;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
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

    public int getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(int bookStatus) {
        this.bookStatus = bookStatus;
    }
    @Override
    public String toString()
    {
        String res="";
        
        res+=Integer.toString(ID);
        int missing = IDlength-Integer.toString(ID).length();
        for(int i=0;i<missing;i++) res+=" ";
        
        res+=Integer.toString(roomID);
        missing = roomIDlength-Integer.toString(roomID).length();
        for(int i=0;i<missing;i++) res+=" ";
        
        res+=name;
        missing = namelength-name.length();
        for(int i=0;i<missing;i++) res+=" ";
        
        res+=Integer.toString(age);
        missing = agelength-Integer.toString(age).length();
        for(int i=0;i<missing;i++) res+=" ";
        return res;
    }
}
