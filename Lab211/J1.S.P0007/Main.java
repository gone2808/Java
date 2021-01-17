/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0007;

import java.util.*;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Main {
    public static void main(String[] args) {
        Graph<Integer> g = new Graph<Integer>();
        //Graph as GuideLine
        g.addEdge(1, 4, true);
        g.addEdge(2, 4, true);
        g.addEdge(2, 5, true);
        g.addEdge(3, 5, true);
        g.addEdge(4, 5, true);
        
        int sVertex=Utility.GetInt("Enter start point: ",1 , 5);
        int dVertex=Utility.GetInt("Enter the end point: ", 1, 5);
        
        if(g.hasEage(sVertex,dVertex)==true){
            System.out.println("This is an edge.");
        }
        else System.out.println("This isn't an edge.");
        
    }
}
