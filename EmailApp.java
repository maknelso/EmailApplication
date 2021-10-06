/*
Generate an email with syntax
Determine department (if none - blank)
Generate random String for password
Set methods to change pass, set mailbox capacity, define alternative email
Get method to display name, email, mailbox
*/

package emailapp;

public class EmailApp{
    public static void main(String[] args){
        // Creating the object to interact with email.java
        Email em1 = new Email("John", "Smith");
        System.out.println(em1.showInfo());

        em1.setAlternateEmail("js@gmail.com");
        System.out.println(em1.getAlternateEmail());    
    }
}
