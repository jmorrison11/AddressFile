package addressbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.ArrayList;

public class AddressBookWithBinaryFile
{
    private static final String FILE_NAME = "AddressBook.bin";
    
    public static void main(String[] args)
    {
        // Declare ArrayLists for storing contact info here.
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        Scanner input = new Scanner(System.in);
        int option;
        
        // Keep displaying the menu until the user decides to quit.
        do
        {
            option = getMenuOption(input);
            
            if (option == 1)
            {
                // Add Contact.
                addContact(contacts, input);
            }
            else if (option == 2)
            {
                // Edit Contact.
                
            }
            else if (option == 3)
            {
                // Remove Contact.
                removeContact(contacts, input);
            }
            else if (option == 4)
            {
                // Display Contacts.
                displayContacts(contacts);
            }
            else if (option == 5)
            {
                // Save contacts to file.
                saveContactsToFile(contacts);
            }
            else if (option == 6)
            {
                // Load contacts from file.
                contacts = loadFromFile();
            }
        } while (option != 7);
        
        // User has chosen to quit the program.
        System.out.println("You have chosen to quit.  Have a nice day!");
    }
    
    public static ArrayList<Contact> loadFromFile()
    {
        ArrayList<Contact> contacts = new ArrayList<>();
        
        try(
            FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        )
        {
            contacts = (ArrayList<Contact>) objectInputStream.readObject();
            System.out.println("Contacts loaded successfully!");
        }
        catch(IOException exception)
        {
            System.out.println("Error reading from file: " + exception.getMessage());
        }
        catch(ClassNotFoundException exception)
        {
            System.out.println("Error reading from file: " + exception.getMessage());
        }
        
        System.out.println();
        return contacts;
    }
    
    public static void saveContactsToFile(ArrayList<Contact> contacts)
    {
        try (
            FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        )
        {
            objectOutputStream.writeObject(contacts);
            System.out.println("Your contacts have been saved to a file.");
        }
        catch(IOException exception)
        {
            System.out.println("An IOException ocurred: " + exception.getMessage());
        }
        
        System.out.println();
    }
    
    public static void removeContact(ArrayList<Contact> contacts, Scanner input)
    {
        System.out.println("You have chosen to remove a contact.");
        System.out.print("What is the contact's name? ");
        input.nextLine();
        String name = input.nextLine();
        Contact searchContact;
        searchContact = new Contact();
        searchContact.setName(name);
        Contact contact;
        boolean found = false;
        
        for (int index = 0; index < contacts.size() && !found; index++)
        {
            contact = contacts.get(index);
            
            if (searchContact.equals(contact))
            {
                contacts.remove(index);
                found = true;
                System.out.println("Your contact has been removed!");
            }
        }
     
        if (!found)
        {
            System.out.println("No one with that name was found in your address book!");
        }
    }
    
    public static void addContact(ArrayList<Contact> contacts, Scanner input)
    {
        System.out.println("You have chosen to add a contact.");
        
        // Get name.
        input.nextLine();
        System.out.print("What is the person's name? ");
        String name = input.nextLine();
        
        // Get phone number.
        System.out.print("What is the person's phone number? ");
        long phoneNumber = input.nextLong();
        
        // Get email.
        System.out.print("What is the person's email address? ");
        String email = input.next();
        
        // Add data to ArrayLists.
        Contact contact = new Contact(name, phoneNumber, email);
        contacts.add(contact);
        System.out.println();
    }
    
    public static void displayContacts(ArrayList<Contact> contacts)
    {
        System.out.println("Here are the contacts in your address book:");
        Contact contact;
        
        for (int index = 0; index < contacts.size(); index++)
        {
            contact = contacts.get(index);
            System.out.println(contact);
            System.out.println();
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
        System.out.println("5. Save to File");
        System.out.println("6. Load from File");
        System.out.println("7. Quit");
        System.out.print("Choose an option: ");
        
        // Get menu option from user.
        int option = input.nextInt();
        
        // Reprompt if user chose an invalid option.
        while (option < 1 || option > 7)
        {
            System.out.print("Error: please choose an option between 1 and 7: ");
            option = input.nextInt();
        }
        
        // Menu option is valid at this point.  Return it.
        System.out.println();
        return option;
    }
}
