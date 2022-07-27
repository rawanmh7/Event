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
public abstract class Employee {
    String name;
    int age;
    double salary;
    String rank;
    String job;
    
    public Employee(){
        
    }
    public Employee(String name, int age, double salary, String rank, String job){
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.rank = rank;
        this.job = job;
        
    }

    public abstract double getSalary(); 

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    
}
