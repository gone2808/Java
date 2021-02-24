/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE1506_HE153632_NgoQuangHai_A;

//Import
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Main {
    /**
     * vendor ANSI
     */
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    /**
     * 
     */
    static ManagementSoftware myManagementSoftware = new ManagementSoftware();
    static int currentHour=0,customerID=0,choice=0;
    public static int[] from=      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public static int[] to=        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
 /**
  * @param args
  */
    public static void main(String[] args) {
        
        /// Group Info
        System.out.println("Assignment:\n");
        System.out.println("Class ID: SE1506\n");
        System.out.println("Group: 4\n");
        System.out.println("1. Bach Ngoc Minh Chau");
        System.out.println("2. Nguyen Tien Duc");
        System.out.println("3. Ngo Quang Hai\n");
        /// Menu
        
        do
        {
            System.out.println("Menu");
            System.out.println("1. Add a new customer.");
            System.out.println("2. Register time slot in advance.");
            System.out.println("3. List time slots registered by the given customer.");
            System.out.println("4. Quit.\n");
            choice = Utility.GetInt("Please enter 1, 2, 3, or 4:", 1, 4);
            switch(choice)
            {
                case 1:
                    /** 
                     * Refresh
                     */
                    myManagementSoftware.clear();
                    myManagementSoftware.readCustomer();
                    myManagementSoftware.readSlot();
                    /**
                     * Res
                     */
                    int roomID=Utility.GetInt("Enter Room ID (from 100 to 310): ", 100, 310);
                    String name=Utility.GetString("Enter name: ", false);
                    int age=Utility.GetInt("Enter age: ",1,90);
                    myManagementSoftware.add(roomID,name,age);
                    myManagementSoftware.display();
                    Utility.GetString("Press enter key to continue!", true);
                    break;
                case 2:
                     /** 
                     * Refresh
                     */
                    myManagementSoftware.clear();
                    myManagementSoftware.readCustomer();
                    myManagementSoftware.readSlot();
                     /**
                     * Date
                     */
                    LocalDate myDate= LocalDate.now();
                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
                    String myDateFormatted=myDate.format(myFormatObj);
                    LocalTime myTime= LocalTime.now();
                    myFormatObj = DateTimeFormatter.ofPattern("HH"); 
                    String myTimeFormatted=myTime.format(myFormatObj);
                    currentHour=Integer.parseInt(myTimeFormatted);
                    System.out.println("Booking on " + myDateFormatted + " at " + myTimeFormatted +"h");
                    /**
                     * Display
                     */
                    myManagementSoftware.display();
                    /**
                     * Refresh Registers
                     */
                    
                    myManagementSoftware.readRegisters(myDateFormatted, currentHour);
                    
                    customerID=Utility.GetInt("Enter customer ID: ",1,myManagementSoftware.getSize());
                    boolean available=myManagementSoftware.displaySlot(customerID,currentHour);
                    boolean checkStatue=false;
                    for(int i=1;i<=myManagementSoftware.getSlotCount();i++)
                            if(from[i]> currentHour)
                            {
                                if(!myManagementSoftware.checkBooked(customerID,i) && myManagementSoftware.getAvailable(i)>0)
                                {
                                   checkStatue=true;
                                }
                            }
                    if(!checkStatue) available=false;
                    if(!available)
                    {
                        System.out.println("No slot available!");
                    }
                    else
                    {
                        boolean book=false;
                        int minSlot=1;
                        for(int i=1;i<=myManagementSoftware.getSlotCount();i++)
                            if(from[i]> currentHour)
                            {
                                minSlot=i;
                                break;
                            }
                        do
                        {   
                            int cSlot=Utility.GetInt("Enter slot: ",minSlot,myManagementSoftware.getSlotCount());
                                if(myManagementSoftware.checkBooked(customerID,cSlot))
                                {
                                    System.out.println("That slot is already booked!");
                                }
                                else
                                    if(myManagementSoftware.getAvailable(cSlot)==0)
                                    {
                                        System.out.println("No any available computer!");
                                    }
                                    else
                                    {
                                        myManagementSoftware.setBookStatus(customerID,cSlot);
                                        myManagementSoftware.writeRegisters(myDateFormatted, currentHour, customerID, cSlot);
                                        book=true;
                                    }
                        }while(!book);
                        myManagementSoftware.displayBookStatus(customerID,currentHour);
                        
                    }
                    Utility.GetString("Press any key to continue!", true);
                    break;
                case 3:
                    /**
                     * refresh
                     */
                    myManagementSoftware.clear();
                    myManagementSoftware.readCustomer();
                    myManagementSoftware.readSlot();
                    /**
                     * date
                     */
                    myDate= LocalDate.now();
                    myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
                    myDateFormatted=myDate.format(myFormatObj);
                    myTime= LocalTime.now();
                    myFormatObj = DateTimeFormatter.ofPattern("HH"); 
                    myTimeFormatted=myTime.format(myFormatObj);
                    currentHour=Integer.parseInt(myTimeFormatted);
                    /**
                     * refresh Registers
                     */
                    myManagementSoftware.readRegisters(myDateFormatted, currentHour);
                    
                    System.out.println("Date time: " + myDateFormatted + " at " + myTimeFormatted +"h");
                    myManagementSoftware.display();
                    customerID=Utility.GetInt("Enter customer ID: ",1,myManagementSoftware.getSize());
                    myManagementSoftware.displayBookStatus(customerID,currentHour);
                    Utility.GetString("Press enter key to continue!", true);
                    break;
                case 4:
                    break;
            }
        }
        while(choice != 4);
    }
    
}
