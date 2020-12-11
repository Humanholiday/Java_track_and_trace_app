public class Establishment
{

    // Attributes
    private String name;
    private String firstLineAddress;
    private String postCode;
    private long maxOccupancy;
    private String address;


    // Constructors
    public Establishment(String name, String firstLineAddress, String postCode, long maxOccupancy)
    {
        this.name = name;
        this.firstLineAddress = firstLineAddress;
        this.postCode = postCode;
        this.maxOccupancy = maxOccupancy;
        // CONCATENATES THE FIRST LINE AND POSTCODE VARIABLES INTO ONE ADDRESS STRING
        this.address = new String(firstLineAddress + ", " + postCode); //JACK
    }

    // PASSES ADDRESS IN AS A STRING ARRAY - UNSURE IF THIS IS THE CORRECT APPROACH
    // AND UNSURE OF THE JUSTIFICATION FOR DOING IT THIS WAY - JH

    public Establishment(String name, String[] address, int maxOccupancy)     //VICKY
    {
        this.name = name;
        this.firstLineAddress = address[0];
        this.postCode = address[1];
        this.maxOccupancy = maxOccupancy;
        this.address = new String(address[0] + ", " + address[1]); //JACK
    }


    // Methods

    //getters

    public String getName()
    {
        return this.name;
    }

    public String getAddress()
    {
        return this.address;
    }

    public long getMaxOccupancy()
    {
        return this.maxOccupancy;
    }

    //views

    public String displayEstablishment()
    {
        {
            // Print out event details in required format
            return String.format("Name: %s\n\t" +     // %s represents a string
                            "Address: %s",
                    name,
                    address);
        }
    }
}
