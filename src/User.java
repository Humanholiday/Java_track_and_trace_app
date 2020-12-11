import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class User
{
    //Attributes
    private String name;
    private LocalDate dob;
    private String emailAddress;
    private String phoneNumber;
    private int age;

    //constructor

    public User(String name, LocalDate dob, String emailAddress, String phoneNumber)
    {
        this.name = name;
        this.dob = dob;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        // CALCULATES THE YEARS BETWEEN DOB AND THE CURRENT DATE AND STORES AS AGE VARIABLE
        this.age = Period.between(dob, LocalDate.now()).getYears(); //JACK
    }

    // methods

    // utility methods

    //https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html        //VICKY
// Date formatter so we can format dob in correct format
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // getters

    public String getName()
    {
        return this.name;
    }

    public LocalDate getDob()
    {
        return this.dob;
    }

    public String getEmailAddress()
    {
        return this.emailAddress;
    }

    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }

    public int getAge()
    {
        //DONT THINK THIS IS NEEDED AS IT RE ASSIGNS THE AGE DEPENDING ON THE CURRENT DATE WHEN THE METHOD IS CALLED
        // I THINK THAT WE ONLY NEED TO KNOW THE AGE ON THE DATE THE EVENT OCCURRED, IN WHICH CASE IT IS REDUNDANT - JH
        //this.age = Period.between(this.dob, LocalDate.now()).getYears();

        return this.age;
    }

    // views

    public String displayUser()
    {
        // Print out user details in required format
        return String.format("Name: %s\n\t" +     // %s represents a string
                        "Date of Birth: %s\n\t" +
                        "Email: %s\n\t" +
                        "Contact Number: %s\n\t" +
                        "Age: %d",                            // %d represents a decimal
                name,
                dob.format(formatter),
                emailAddress,
                phoneNumber,
                age);
    }

    public String displayUserShortHand()
    {
        return
                this.name + " | Contact Number " + this.phoneNumber;
    }

}

