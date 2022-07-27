/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1_;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Rawan
 */
public class Project1_ {

    /**
     * @param args the command line arguments
     */
     private static Scanner input = new Scanner(System.in);
     private static ArrayList<Meeting> allMeetings = new ArrayList<>();
     private static ArrayList<Person> allUsers = new ArrayList<>();
     private static Person currentUser = null;
    
    public static void main(String[] args) {
        
       // TODO code application logic here
       String username;
            
        System.out.println("Create list of user, -1 to continue with menu");
        System.out.println("Enter username: ");
        username = input.next();
        allUsers.add(new Person(username));
        while (!username.equals("-1")) {
            System.out.println("Enter username: ");
            username = input.next();
            if (!username.equals("-1"))
                allUsers.add(new Person(username));
        }
                     
        while (true) {
            printMenu();
            System.out.println("Choose an option: ");
            int option = input.nextInt();
            if(option >= 0 && option <=8){
              if(option == 0){
                  System.out.println("Enter username: ");
                  String name = input.next();
                  if(allUsers.contains(checkUser(name))){
                     currentUser = checkUser(name);                     
                    }
                  else 
                     System.out.println("Invalid Username.");                 
                }                             
              if(option == 1)
                createMeeting(currentUser);
              if(option == 2)
                cancelMeeting(currentUser);
              if(option == 3)
                attendMeeting(currentUser);
              if(option == 4)
                leaveMeeting(currentUser);
              if(option == 5)
                DisplayMyMeetings(currentUser);
              if(option == 6)
                DisplayOrganizedMeetings(currentUser);
              if(option == 7)
                currentUser = null;               
              if(option == 8){
                System.out.println("Bye.");
                break;
               }
        
            }
            else
                System.out.println("Enter a valid option: ");
        }            
                
    }
    public static void printMenu(){
         System.out.println();
         System.out.println("The following menu is given for you: "+"\n0)Login "+
                "\n1)Create and host a new meeting \n2)Cancel a meeting \n3)Attend an existing meeting"
                + " \n4)Leave a meeting \n5)Display my meetings"
                + " \n6) Display meeting organized by me \n7)Log out \n8)Exist");
         System.out.println();
    }
    public static void createMeeting(Person user){
        System.out.println("Enter name of meeting: ");
        String n = input.next();        
        // eg 23 03 2020        
        System.out.println("Enter date of meeting: (dd mm yyyy)");
        int[] date = new int[3];
        for(int i = 0; i<date.length; i++){
            date[i] = input.nextInt();
        }
             
        Meeting m1 = new Meeting(user, n, LocalDate.of(date[2],date[1],date[0]));       
        allMeetings.add(m1);      
        user.organizeMeeting(m1);
       
        System.out.println(m1.getNameOfMeeting() + " meeting on "+ m1.getAppointment()+ " created successfully." );
    }
    public static void cancelMeeting(Person user){
        user.displayMyOrganizations();
        System.out.println("Enter name of meeting to be cancelled: ");
        String mname = input.next();
        for(int i = 0; i<allMeetings.size(); i++){
            if(allMeetings.get(i).getNameOfMeeting().equals(mname)){
                user.cancelMeeting(allMeetings.get(i));
                allMeetings.remove(i);
                System.out.println("All attendees of " + mname + " have been removed. "
                        + "Meeting " + mname + " is cancelled.");
            }
            else
                System.out.println("Meeting not found.");
        }                        
    }
    public static void attendMeeting(Person user){
        boolean check = allMeetings.isEmpty();
        if(check == true)
            System.out.println("No meetings available");
        else{
          for (Meeting n: allMeetings) {
            System.out.println(n.getNameOfMeeting()+" meeting"+" by: "+n.getHost().getName()+ " on "+n.getAppointment());
          }
          System.out.println("Would you like to attend any meeting? ");
          System.out.println("Yes/No: ");
          String choice = input.next();
         if(choice.equalsIgnoreCase("Yes")){
            System.out.println("Enter meeting name: ");
            String name = input.next();
            for (Meeting m : allMeetings) {               
                if (m.getNameOfMeeting().equals(name)){                    
                    m.addAttendee(user);
                    System.out.println("The meeting has been added to your agenda.");
                }              
                else
                    System.out.println("Meeting not found.");
            }
         }
         else {
            System.out.println("Thank You!");
          }
         
        }
        
    }
    public static void leaveMeeting(Person user){
        boolean check = user.getMyMeetings().isEmpty();
        if(check == true)
            System.out.println("No meetings available");
        else{
          user.displayMyMeetings();
          System.out.println("Which meeting would you like to leave? ");
          String name = input.next();
          for (Meeting n : allMeetings) {
            if (n.getNameOfMeeting().equals(name)){
                user.removeMeeting(n);
                n.removeAttendee(user);
                System.out.println("You left the meeting!");
            }
            else
                System.out.println("Meeting not found.");
          }
        }
        
    }
    public static void DisplayMyMeetings(Person user){
       boolean check = user.getMyMeetings().isEmpty();
       if(check == true)
           System.out.println("Your agenda is empty.");
       else
           user.displayMyMeetings();
    }
    public static void DisplayOrganizedMeetings(Person user){
        boolean check = user.getiOrganize().isEmpty();
        if(check == true)
            System.out.println("You haven't organized any meeting yet!");
        else
            user.displayMyOrganizations();
    }
    public static Person checkUser(String name) {
        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getName().equals(name)) {
                return allUsers.get(i);

            }
        }
        return null;
    }
 
} 
