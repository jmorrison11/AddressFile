package addressbook;
import java.util.Scanner;
import java.util.ArrayList;

public class AddressBook
{
    public static void main(String[] args)
    {
        // Declare ArrayLists for storing contact info here.
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Long> phoneNumbers = new ArrayList<Long>();
        ArrayList<String> emails = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        int option;
        
        // Keep displaying the menu until the user decides to quit.
        do
        {
            option = getMenuOption(input);
            
            if (option == 1)
            {
                // Add Contact.
                addContact(names, phoneNumbers, emails, input);
            }
            else if (option == 2)
            {
                // Edit Contact.
            }
            else if (option == 3)
            {
                // Remove Contact.
            }
            else if (option == 4)
            {
                // Display Contacts.
                displayContacts(names, phoneNumbers, emails);
            }
        } while (option != 5);
        
        // User has chosen to quit the program.
        System.out.println("You have chosen to quit.  Have a nice day!");
    }
    
    public static void addContact(ArrayList<String> names, ArrayList<Long> phoneNumbers, ArrayList<String> emails, Scanner input)
    {
        System.out.println("You have chosen to add a contact.");
        
        // Get name.
        System.out.print("What is the person's name? ");
        String name = input.next();
        
        // Get phone number.
        System.out.print("What is the person's phone number? ");
        long phoneNumber = input.nextLong();
        
        // Get email.
        System.out.print("What is the person's email address? ");
        String email = input.next();
        
        // Add data to ArrayLists.
        names.add(name);
        phoneNumbers.add(phoneNumber);
        emails.add(email);
        System.out.println();
    }
    
    public static void displayContacts(ArrayList<String> names, ArrayList<Long> phoneNumbers, ArrayList<String> emails)
    {
        System.out.println("Here are the contacts in your address book:");
        
        for (int index = 0; index < names.size(); index++)
        {
            System.out.println("Name: " + names.get(index));
            System.out.println("Phone Number: " + phoneNumbers.get(index));
            System.out.println("Email Address: " + emails.get(index));
        }
        
        System.out.println();
    }
    
    public static int getMenuOption(Scanner input)
    {
        // Display menu.
        System.out.println("--- MAIN MENU ---");
        System.out.println("1. Add Contact");
        System.out.println("2. Edit Contact");
        System.out.println("3. Remove Contact");
        System.out.println("4. Display Contacts");
        System.out.println("5. Quit");
        System.out.print("Choose an option: ");
        
        // Get menu option from user.
        int option = input.nextInt();
        
        // Reprompt if user chose an invalid option.
        while (option < 1 || option > 5)
        {
            System.out.print("Error: please choose an option between 1 and 5: ");
            option = input.nextInt();
        }
        
        // Menu option is valid at this point.  Return it.
        System.out.println();
        return option;
    }
}
