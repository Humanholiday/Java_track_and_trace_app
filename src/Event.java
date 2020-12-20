import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Event
{
    // Attributes

    // System.identityHashCode(yourObject) gives the hash code of the event as an integer.   -JH
    // hashCode() gives the same value but is easier to override
    private Integer eventID = System.identityHashCode(this);
    private User user;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private int partyNumber;
    private Establishment establishment;

    // Constructors

    public Event (User user, LocalDate date, LocalTime time, int partyNumber, Establishment establishment)
    {
        this.user = user;
        this.eventDate = date;
        this.eventTime = time;
        this.partyNumber = partyNumber;
        this.establishment = establishment;
    }

    // USES CONSTRUCTOR OVERLOADING TO ASSIGN CURRENT DATE AND TIME IF THOSE VALUES ARE NOT PRESENT IN CONSTRUCTOR - JH

    public Event(User user, Integer partyNumber, Establishment establishment)
    {
        this(user, LocalDate.now(), LocalTime.now(), partyNumber, establishment);
    }


    // utility methods

    //https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html        //VICKY
// Date formatter so we can format dob in correct format
    // Researched Date formatter so we can format dob in correct format, link to webpage below - VW
    //https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");


    // methods

    //getters
    public Event getEvent()
    {
        return this;
    }
    public User getUser()
    {
        return this.user;
    }
    public Establishment getEstablishment()
    {
        return this.establishment;
    }
    public Integer getEventID()
    {
        return this.eventID;
    }
    public String getEventDate()
    {
        return this.eventDate.format(formatter);   //******** NEW - FORMAT DATE
    }
    public LocalTime getEventTime()
    {
        return this.eventTime;
    }
    public Integer getPartyNumber()
    {
        return this.partyNumber;
    }


    //setters

    public void setEventID(int eventID) { this.eventID = eventID; }
    public void setEventDate(LocalDate eventDate) { this.eventDate = eventDate; }
    public void setPartyNumber(int partyNumber) { this.partyNumber = partyNumber; }

    public void setUser(User user)
    {
        this.user = user;
    }

    public void setEstablishment(Establishment establishment)
    {
        this.establishment = establishment;
    }

    //views

    public String displayEvent()
    {
        // Used String.format to create a sting that can be declared in a System.out.println in order to print the information from User, Establishment
        // and Event, in the correct format - VW

        return String.format("Event ID: %d \n" +
                        "\tRecorded User\n \t\tName: %s\n \t\tDate of Birth: %s\n \t\tEmail: %s\n  \t\tContact Number: %s\n \t\tAge %d\n" +
                        "\tEvent Date: %s\n \tEvent Time: %s\n \tParty Size: %d\n" +
                        "\tEstablishment:\n \t\tName %s\n \t\tAddress: %s",
                //eventID,
                eventID,
                user.getName(),
                user.getDob(),
                user.getEmailAddress(),
                user.getPhoneNumber(),
                user.getAge(),
                eventDate.format(formatter),
                eventTime,
                partyNumber,
                establishment.getName(),
                establishment.getAddress()
        );

    };

    public void controllerStore()
    {
        // pass info in this class to controller to store the information
    }


    public static void main(String[] args)
    {

    }
}
