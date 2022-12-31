package addressbook;

public class ContactTester
{
    public static void main(String[] args)
    {
        Contact contact1 = new Contact();
        contact1.setName("Alice Allison");
        contact1.setPhoneNumber(3333333333L);
        contact1.setEmail("alice@css.edu");
        
        Contact contact2 = new Contact();
        contact2.setName("Bob Robertson");
        contact2.setPhoneNumber(4444444444L);
        contact2.setEmail("bob@css.edu");
        
        Contact contact3 = new Contact("Cindy Cooper", 5555555555L, "cindy@css.edu");
        Contact contact4 = new Contact("Cindy Cooper", 5555555555L, "cindy@css.edu");
        
        if (contact3.equals(contact4))
        {
            System.out.println(contact3.getName() + " equals " + contact4.getName());
        }
        else
        {
            System.out.println(contact3.getName() + " does NOT equal " + contact4.getName());
        }
        
        // Print out all our contacts.
        //printContact(contact1);
        //printContact(contact2);
        //printContact(contact3);
    }
    
    public static void printContact(Contact contact)
    {
        System.out.println("Contact Information:");
        System.out.println(contact);
        System.out.println();
    }
}
