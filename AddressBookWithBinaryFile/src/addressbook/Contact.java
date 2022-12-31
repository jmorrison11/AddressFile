package addressbook;
import java.io.Serializable;

public class Contact implements Serializable
{
    private String name;
    private long phoneNumber;
    private String email;
    
    public Contact()
    {
        name = "";
        phoneNumber = 0;
        email = "0";
    }
    
    public Contact(String inName, long inPhoneNumber, String inEmail)
    {
        setName(inName);
        setPhoneNumber(inPhoneNumber);
        setEmail(inEmail);
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setPhoneNumber(long inPhoneNumber)
    {
        if(inPhoneNumber > 9999999999L)
        {
            phoneNumber = 0;
        }
        else
        {
            phoneNumber = inPhoneNumber;
        }
    }
    
    public void setEmail(String inEmail)
    {
        if(inEmail.contains("@"))
        {
            email = inEmail;
        }
        else
        {
            email = "";
        }
    }
    
    public String getName()
    {
        return name;
    }
    
    public long getPhoneNumber()
    {
        return phoneNumber;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    @Override
    public String toString()
    {
        String text = "Name: " + name + "\nPhone Number: " + phoneNumber + "\nEmail: " + email;
        return text;
    }
    
    @Override
    public boolean equals(Object object)
    {
        boolean result;
        
        if (this == object)
        {
            result = true;
        }
        else if (object == null)
        {
            result = false;
        }
        else if(getClass() != object.getClass()) // else if (object instanceof Contact)
        {
            result = false;
        }
        else
        {
            Contact otherContact = (Contact) object;
            
            if(name.equals(otherContact.name)) 
                    //&& phoneNumber == phoneNumber
                    //&& email.equals(otherContact.email))
            {
                result = true;
            }
            else
            {
                result = false;
            }
        }
        
        return result;
    }
}
