/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1_;

/**
 *
 * @author Rawan
 */
public class SalariedEmployee extends Employee {
    double bonus;
    double deduction;
    
    public SalariedEmployee(){
        
    }
    public SalariedEmployee(String n , int a , double sal, String ran, String j, double b, double d){
         super(n,a,sal,ran,j);
         bonus = b;
         deduction = d;
         
    }
    @Override
    public double getSalary(){
        return salary + bonus - deduction;
    }
    public void specialFunction(){
    
    } 
}
