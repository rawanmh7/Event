/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1_;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

/**
 *
 * @author Rawan
 */
public class Meeting {
    private LocalDate appointment;
    private String nameOfMeeting;
    private Person Host;
    private ArrayList<Person> attendees = new ArrayList<>();
    
    public Meeting(Person Host, String nameOfMeeting, LocalDate date){
        this.Host = Host;
        this.nameOfMeeting = nameOfMeeting;
        appointment = date;
        Host.organizeMeeting(this); 
       
    }
    public String getAppointment() {
        // change date to string format
      String stringDate = appointment.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
      return stringDate;
    }
    public Person getHost() {
        return Host;
    }
    public String getNameOfMeeting() {
        return nameOfMeeting;
    }    
    public ArrayList<Person> getAttendees() {
        return attendees;
    }
    public void setAppointment(LocalDate date) {
        if(date.isAfter(appointment))
            appointment = date;
        else
            System.out.println("Invalid request.");
    }
    public boolean equals(Object o) {
        Meeting m = (Meeting) o;
        if ((Host.equals(m.Host))&&(appointment.equals(m.appointment))
                &&(attendees.equals(m.attendees)))
            return true;
        else
            return false; 
    }
    public void addAttendee(Person p){
        boolean isAdded;
        if(!attendees.contains(p)){
            isAdded = p.addMeeting(this);
            if(isAdded == true)
                attendees.add(p);
        }
    }
    public boolean removeAttendee(Person p){
        if(attendees.contains(p)){
            p.removeMeeting(this); 
            attendees.remove(p);
            return true;
        }
        else
            return false;
    }
    public void removeAllAttendees(){
        for(int i = 0; i<attendees.size(); i++){
            attendees.remove(i);
        }        
    }
    public String toString() {     
        return "Host: " + getHost() +"\n"
                + "name: " +  getNameOfMeeting()+"\n"
                + "attendees: " + getAttendees();
    }
      
}
