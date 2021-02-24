/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop03;
import java.util.Scanner;
/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Workshop03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Molecular Information:");
        
        Scanner sc = new Scanner(System.in);
        Molecule[] molecules = new Molecule[1000];
        
        int capicity=0;
        
        String Structure;
        String Name;
        double Weight;
        
        do{
            System.out.print("Enter structure : ");
            Structure = sc.nextLine();
            
            if("0".equals(Structure)){
                showInfor(molecules);
                break;
            }
            else{
                System.out.print("Enter full name : ");
                Name = sc.nextLine();
                
                System.out.print("Enter weight : ");
                Weight = Double.parseDouble(sc.nextLine());
                //++String a=sc.nextLine();
                molecules[capicity++] = new Molecule(Structure,Name,Weight);
                System.out.println("");
            }
        }
        while(true);
    }

    private static void showInfor(Molecule[] molecules) {
          for(Molecule M : molecules){
              if(M!=null) M.display();
        }
    }

   

       
    
    
    
}
