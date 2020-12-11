import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Event
{
    // Attributes

    private long eventID;
    private User user;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private int partyNumber;
    private Establishment establishment;

    // Constructors

    public Event (User user, LocalDate date, LocalTime time, int partyNumber, Establishment establishment)
    {
        //CALLS PRIVATE GETID() METHOD -JH
        this.eventID = getID();
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


    // method to generate a unique 10 digit ID using the current time in milliseconds limited to 10 digits - JH
    // unless it hasn't changed since the last id in which case it adds 1
    private static final long LIMIT = 10000000000L;     //JACK
    private static long last = 0;

    private static long getID()
    {
        // 10 digits.
        long id = System.currentTimeMillis() % LIMIT;
        if ( id <= last ) {
            id = (last + 1) % LIMIT;
        }
        return last = id;
    }


    // methods

    //getters

    public User getUser()
    {
        return this.user;
    }
    public LocalDate getEventDate()
    {
        return this.eventDate;
    }
    public LocalTime getEventTime()
    {
        return this.eventTime;
    }
    public Integer getPartyNumber()
    {
        return this.partyNumber;
    }
    public Establishment getEstablishment()
    {
        return this.establishment;
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
