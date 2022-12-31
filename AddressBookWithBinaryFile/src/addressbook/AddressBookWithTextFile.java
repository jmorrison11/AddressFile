package addressbook;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class AddressBookWithTextFile
{
    private static final String FILE_NAME = "AddressBook.txt";
    
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
        //Scanner fileInput = null;
        ArrayList<Contact> contacts = new ArrayList<>();
        Contact contact;
        String line;
        String[] tokens;
        String name;
        long phoneNumber;
        String email;
        
        try (Scanner fileInput = new Scanner(new File(FILE_NAME)))
        {
            //fileInput = new Scanner(new File(FILE_NAME));

            while(fileInput.hasNext())
            {
                line = fileInput.nextLine();
                tokens = line.split(",");
                contact = new Contact();

                name = tokens[0];
                phoneNumber = Long.parseLong(tokens[1]);
                email = tokens[2];
                
                contact.setName(name);
                contact.setPhoneNumber(phoneNumber);
                contact.setEmail(email);

                contacts.add(contact);
            }
            
            System.out.println("Your Address Book has been loaded into the system.");
        }
        catch (FileNotFoundException exception)
        {
            System.out.println("Error, " + FILE_NAME + " could not be found.");
            System.out.println("More details: " + exception.getMessage());
        }
//        finally
//        {
//            fileInput.close();
//        }
        
        System.out.println();
        
        return contacts;
    }
    
    public static void saveContactsToFile(ArrayList<Contact> contacts)
    {
        // Save info to file.
        //PrintWriter writer = null;
        Contact contact;
        
        try (PrintWriter writer = new PrintWriter(new File(FILE_NAME)))
        {
            //File file = new File(FILE_NAME);
            //writer = new PrintWriter(file);
            
            // Write the list contents to a file.
            for(int index = 0; index < contacts.size(); index++)
            {
                // Get the next object from the list.
                contact = contacts.get(index);
                writer.println(contact.getName() + "," + contact.getPhoneNumber() + "," + contact.getEmail());
            }
            
            System.out.println("Your address book has been saved.");
        }
        catch(FileNotFoundException exception)
        {
            System.out.println("Error, file not found." + exception.getMessage());
        }
//        finally
//        {
//            // Close the PrintWriter
//            writer.close();
//        }
        
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
