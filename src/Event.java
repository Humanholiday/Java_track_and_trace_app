import java.time.*; // Java package to work with the date and time API
import java.time.LocalDate;
import java.time.LocalTime;


public class Event
{
    // Attributes
    private int eventID;
    private User user;
    private LocalDate eventDate;
    private int partyNumber;
    private Establishment establishment;

    // Constructors
    public Event (User user, LocalDate date, int partyNumber, Establishment establishment)
    {
        this.eventID =                  // need to research way to auto generate unique event
        this.user = user;
        this.eventDate = date;
        this.partyNumber = partyNumber;
        this.establishment = establishment;
    }

    public Event(User user, Integer partyNumber, Establishment establishment)
    {
        this.eventID =                         // need to research way to auto generate unique event
        this.user = user;
        this.partyNumber = partyNumber;
        this.establishment = establishment;
    }

    // methods
    public User getUser()
    {
        return this.user;
    }
    public String getEventDate()
    {
        return this.eventDate;
    }
    public String getEventTime()
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

    public void setEventID(int eventID) { this.eventID = eventID; }
    public void setEventDate(LocalDate eventDate) { this.eventDate = eventDate; }
    public void setPartyNumber(int partyNumber) { this.partyNumber = partyNumber; }

    public void setUser(User user)
    {
        this.user = user;
    }

    public void setEstablishmnet(Establishment establishmnet)
    {
        this.establishment = establishmnet;
    }

    public void printEvent()
    {
        System.out.print
                (
                        "Event ID:  " + this.eventID +
                                "\n\tRecorded User" +
                                this.user.printUser() +    // tbc reference User method
                                "\n\tDate: " + this.eventDate +
                                "\n\tTime: " +                   // check with Mike
                                "\n\tParty Size: " + partyNumber +
                                "\n\tEstablishment" +
                                this.establishment.printEstablishment()    // tbc reference User method
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
