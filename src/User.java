import java.time.LocalDate;
import java.time.Period;

public class User {
    //Attributes
    private String name;
    private int dob;
    private String emailAddress;
    private int phoneNumber;
    private int age;

    public User(String name, int dob, String emailAddress, int phoneNumber, int age)
    {
        this.name = name;
        this.dob = dob;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public int getDob()
    {
        return dob;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public int getPhoneNumber()
    {
        return phoneNumber;
    }

    public int getAge()
    {
        LocalDate today = LocalDate.now();
        LocalDate dob = LocalDate.of(); //need to research age calculator initialisation
        Period p = Period.between(birthday, today);
        return age;
    }

    public void displayUser()
    {
        System.out.println
                (
        "Name:  " + this.name +
                "\n\tDate of Birth:" + this.dob +
                "\n\tEmail: " + this.emailAddress +
                "\n\tContact Number: " + this.phoneNumber +
                "\n\tAge: " + this.age
                );
    }

    public void displayUserShortHand()
    {
        System.out.println
                (this.name + "|" + this.phoneNumber);
    }


}

