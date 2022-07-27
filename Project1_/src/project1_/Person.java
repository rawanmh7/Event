/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1_;

import java.util.ArrayList;
import java.time.LocalDate;


/**
 *
 * @author Rawan
 */
public class Person {
     private String name;
     private int id = 1000;
     private static int count = 0;
     private ArrayList<Meeting> myMeetings = new ArrayList<>(); // meetings to attend
     private ArrayList<Meeting> iOrganize = new ArrayList<>(); // meetings hosted by user
     
    public Person(String name){
        this.name = name;
         id+=count;
         count++;        
    }     
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Meeting> getMyMeetings() {
        return myMeetings;
    }

    public ArrayList<Meeting> getiOrganize() {
        return iOrganize;
    }
    
    public boolean equals(Object o) {
        Person p = (Person) o;
        if ((name.equals(p.name)) && (id == p.id))
            return true;
        else
            return false;
    }
    public boolean addMeeting(Meeting m){
        for(Meeting n : myMeetings){
            if(n.getAppointment().equals(m.getAppointment()))
                return false;
        }
        myMeetings.add(m);
        return true; 
    }
    public void removeMeeting(Meeting m){
        myMeetings.remove(m);
    }
    public void organizeMeeting(Meeting m){
        if(iOrganize.contains(m)){
            System.out.println("Meeting already exist.");
        } else {
            iOrganize.add(m);
            
        }       
    }
    public void cancelMeeting(Meeting m){
        for (Person p: m.getAttendees()) {
            p.myMeetings.remove(m);
        }      
        iOrganize.remove(m);
    }
    public void displayMyMeetings(){
        for ( Meeting n : myMeetings) {
            System.out.println("The "+n.getNameOfMeeting()+
                    " meeting hosted by: "+n.getHost().getName() + " on: " + n.getAppointment());
        }
    }
    public void displayMyOrganizations(){
        for ( Meeting n : iOrganize) {
            System.out.println("The "+n.getNameOfMeeting()+
                    " meeting hosted by: "+n.getHost().getName() + " on: " + n.getAppointment());
        }
    }
    public String toString() {
        return "Name: " + name + " id: " + id;
    }

}
