package workshop03;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Molecule {
    private String structure;
    private String name;
    private Double weight;

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    
    
    //Default constructor
    public Molecule() {
    }

    public Molecule(String structure, String name, Double weight) {
        this.structure = structure;
        this.name = name;
        this.weight = weight;
    }
    
    public void display(){
        System.out.format("%-15s%-15s%.3f\n",structure,name,weight);
    }
    
}
