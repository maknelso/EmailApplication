/*
Generate an email with syntax
Determine department (if none - blank)
Generate random String for password
Set methods to change pass, set mailbox capacity, define alternative email
Get method to display name, email, mailbox
*/

package emailapp;
import java.util.Scanner;

public class Email{
    // encapsulation - declare private and provide public get and set methods
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "company.com";
    
    // Constructor to receive firstName and lastName
    // Initialize 'new' object before it is used
    public Email(String firstName, String lastName){
        // this - refers to the class level variable
        this.firstName = firstName; // local variable passed from parameter
        this.lastName = lastName;
        // System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);
        
        // Call a method asking for department - return the department
        this.department = setDepartment();
        // this is actually not necessary because there is no other variable named department
        // System.out.println("Department: " + this.department);  
        
        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // Combine elements to generate email: firstname.lastname@department.company.com
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        // System.out.println("Your email is: " + email);
    }

    // Ask for the department
    private String setDepartment(){
        // sysout to auto print System.out.println()
        // \n prints out a new line
        System.out.println("New worker: " + firstName + ". Department Codes: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();

        if(depChoice == 1){ return "sales"; }
        else if(depChoice == 2){ return "dev"; }
        else if(depChoice == 3){ return "acct"; }
        else { return ""; }

        // in.close();
    }

    // Generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        // generate a random number and look at it as an array
        // find the value of this array at any given number
        // create a new array of char named password
        char[] password = new char[length];

        // iterate through passwordSet length
        for(int i = 0; i < length; i++){
            // cast it as int because Math.random() returns a double - Math.random() returns a double number between 0 and 1 (e.g. 0.891475)
            int rand = (int) (Math.random() * passwordSet.length());
            // pass that random number into our array one at a time
            password[i] = passwordSet.charAt(rand);
        }
        // password is a set of char, so we need to modify as new String
        // "new" means create a new String object with the content you have passed
        return new String(password);
    }

    // Do not need to put in constructor because mailbox capacity and alternate email is already defined

    // Setters:
    // Set mailbox capacity
    // encapsulation - set it public for set
    // hide actual properties
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail){
        // no need for this because there is no ambiguity but it is best practice to use it for set method
        this.alternateEmail = altEmail;
    }

    // Change the password 
    public void changePassword(String password){
        this.password = password;
    }

    // Getters:
    public int getMailboxCapacity(){
        return mailboxCapacity;
    }

    public String getAlternateEmail(){
        return alternateEmail;
    }

    public String getPassword(){
        return password;
    }

    // Return useful information
    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName +
            "\nCOMPANY EMAIL: " + email +
            "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
