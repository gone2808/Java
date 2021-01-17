/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0007;

import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Graph<T> {
    private Map<T, List<T> > map = new HashMap<>();
    
    public void addVerTex(T s){
        map.put(s, new LinkedList<>());
    }
    public void addEdge(T source, T destination, boolean bidirectional){
        if(!map.containsKey(source)){
            addVerTex(source);
        }
        if(!map.containsKey(destination)){
            addVerTex(destination);
        }
        
        map.get(source).add(destination);
        //For directed map
        if(bidirectional == true){
            map.get(destination).add(source);
        }
    }
    
    public int getVertexCount(){
        //.keyset -> tra ve set chua cac vertex -> .size -> size cua set chua cac vertex
        return map.keySet().size();
    }
    //
    public int getDegreeOfGraph(boolean bidirection){
        int count = 0;
        for(T v:map.keySet()){
            count+=map.get(v).size();
        }
        if(bidirection==true){
            count/=2;
        }
        return count;
    }
    public boolean hasEage(T s,T d){
        if(map.get(s).contains(d)) return true;
        return false;
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(T v:map.keySet()){
            builder.append(v.toString()+": ");
            for(T w:map.get(v)){
                builder.append(w.toString()+" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
    
}
