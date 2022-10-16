/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Aster
 */
public class Grocery {
    private String name;
    
    public Grocery() {
        name = "";
    }
    
    public Grocery(String name) {
        name = this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
