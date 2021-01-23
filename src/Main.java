import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

// NEW MAIN CLASS CREATED IN ORDER TO RUN TESTS

public class Main {

    //MAIN METHOD FOR APPLICATION

    public static void main(String[] args) throws IOException
    {
            IO menu = new IO();
            menu.runMenu();
    }


    // DEBUG METHOD FOR APPLICATION - CALLED FROM APPLICATION MENU

    public static void debug(IO io)
    {

        System.out.println("\n\nRunning debug method - ");

        //****** HARD CODE 7 USERS *****//

        //CREATE ARRAY OF OBJECTS
        User[] users = new User[7];
        //INITIALISE ID STRING FOR OUTPUT
        String user = null;

        /* USER 1 */

//WRAP IN TRY CATCH
        try
        {
            //UPDATE ID STRING FOR CURRENT OBJECT
            user = "user1";
            //ADD OBJECT TO ARRAY
            users[0] = new User
                    ("Jack Healy", LocalDate.of(1985, 6, 8),
                            "jackhealy85@gmail.com", "07515708720");

            //IF NO EXCEPTIONS, PRINT OUT SUCCESS MESSAGE
            System.out.println("\n" + user + " " + users[0].getName() + " created");
        }
        catch (Exception e)
        //IF EXCEPTIONS PRINT OUT DETAILS INCLUDING CURRENT OBJECT ID
        { System.out.println(user + " " + e.getMessage()); }

        /* USER 2 */

        try
        {
            user = "user2";
            users[1] = new User
                    ("Jennifer Paraphernalia", LocalDate.of(1991, 2, 5),
                            "jp!gmail.com", "07465729206");

            System.out.println(user + " " + users[1].getName() + " created");
        }
        catch (Exception e)
        { System.out.println(user + " " + e.getMessage()); }

        /* USER 3 */

        try
        {
            user = "user3";
            users[2] = new User
                    ("Jacob Gandhi", LocalDate.of(1969, 4, 56565),
                            "gandhi@hotmail.com", "07846289444");

            System.out.println(user + " " + users[2].getName() + " created");
        }
        catch (Exception e)
        { System.out.println(user + " " + e.getMessage()); }

        /* USER 4 */

        try
        {
            user = "user4";
            users[3] = new User
                    ("Jemma Stopthat", LocalDate.of(1979, 2, 1),
                            "stopthat@talktalk.net", "07629572058");

            System.out.println(user + " " + users[3].getName() + " created");
        }
        catch (Exception e)
        { System.out.println(user + " " + e.getMessage()); }

        /* USER 5 */

        try
        {
            user = "user5";
            users[4] = new User
                    ("Jonty Stanislawski", LocalDate.of(1901, 1, 35),
                            "jontybadboy@durham.gov.uk", "01912783894");

            System.out.println(user + " " + users[4].getName() + " created");
        }
        catch (Exception e)
        { System.out.println(user + " " + e.getMessage()); }

        /* USER 6 */

        try
        {
            user = "user6";
            users[5] = new User
                    ("Jentina Jokes", LocalDate.of(1945, 2, 3),
                            "jj92787@sky.net", "07517398720");

            System.out.println(user + " " + users[5].getName() + " created");
        }
        catch (Exception e)
        { System.out.println(user + " " + e.getMessage()); }

        /* USER 7 */

        try
        {
            user = "user7";
            users[6] = new User
                    ("Jerry Jason", LocalDate.of(1985, 6, 5),
                            "jjson£gmail.com", "070372759564");

            System.out.println(user + " " + users[6].getName() + " created");
        }
        catch (Exception e)
        { System.out.println(user + " " + e.getMessage()); }



        //***** HARD CODE 7 ESTABLISHMENTS *****//

        //CREATE ARRAY OF OBJECTS
        Establishment[] establishments = new Establishment[7];
        //INITIALISE ID STRING FOR OUTPUT
        String establishment = null;

        /* ESTABLISHMENT 1 */

        //WRAP IN TRY CATCH
        try {
            //UPDATE ID STRING FOR CURRENT OBJECT
            establishment = "establishment1";
            //ADD OBJECT TO ARRAY
            establishments[0] = new Establishment("Some Coffee House", "1 King Street",
                    "FA1 3KE,", 5);
            //IF NO EXCEPTIONS, PRINT OUT SUCCESS MESSAGE
            System.out.println("\n" + establishment + " " + establishments[0].getName() + " created");
        }
        catch (Exception e)
        //IF EXCEPTIONS PRINT OUT DETAILS INCLUDING CURRENT OBJECT ID
        { System.out.println("\n" + establishment + " " + e.getMessage()); }

        /* ESTABLISHMENT 2 */

        try {
            establishment = "establishment2";
            establishments[1] = new Establishment("Some Restaurant Place", "1 Queen Street",
                    "FA2 3KE", 5);
            System.out.println(establishment + " " + establishments[1].getName() + " created");
        }
        catch (Exception e)
        { System.out.println(establishment + " " + e.getMessage()); }

        /* ESTABLISHMENT 3 */

        try {
            establishment = "establishment3";
            establishments[2] = new Establishment("Some Book Place", "1 Regal Street",
                    "FA4 3KE", 20);
            System.out.println(establishment + " " + establishments[2].getName() + " created");
        }
        catch (Exception e)
        { System.out.println(establishment + " " + e.getMessage()); }

        /* ESTABLISHMENT 4 */

        try {
            establishment = "establishment4";
            establishments[3] = new Establishment("Some Gourmet Place", "1 Viceroy Street",
                    "FA5 3KE", 5);
            System.out.println(establishment + " " + establishments[3].getName() + " created");
        }
        catch (Exception e)
        { System.out.println(establishment + " " + e.getMessage()); }

        /* ESTABLISHMENT 5 */

        try {
            establishment = "establishment5";
            establishments[4] = new Establishment("Some Cuisine Place", "1 Empress Street",
                    "FA6 3KE", 5);
            System.out.println(establishment + " " + establishments[4].getName() + " created");
        }
        catch (Exception e)
        { System.out.println(establishment + " " + e.getMessage()); }

        /* ESTABLISHMENT 6 */

        try {
            establishment = "establishment6";
            establishments[5] = new Establishment("Some Aperitif Place", "1 Court Jester Street",
                    "FA7 3KE", 5);
            System.out.println(establishment + " " + establishments[5].getName() + " created");
        }
        catch (Exception e)
        { System.out.println(establishment + " " + e.getMessage()); }

        /* ESTABLISHMENT 7 */

        try {
            establishment = "establishment7";
            establishments[6] = new Establishment("Some Down-in-one Place", "1 Archbishop Street",
                    "FA8 3KE", 5);
            System.out.println(establishment + " " + establishments[6].getName() + " created" + "\n");
        }
        catch (Exception e)
        { System.out.println(establishment + " " + e.getMessage() + "\n"); }



        //***** HARD CODE 7 EVENTS *****//

        //CREATE ARRAY OF OBJECTS
        Event[] events = new Event[7];
        //INITIALISE ID STRING FOR OUTPUT
        String event = null;

        /* EVENT 1 */

        //WRAP IN TRY CATCH
        try {
            //UPDATE ID STRING FOR CURRENT OBJECT
            event = "event1";
            //ADD OBJECT TO ARRAY
            events[0] = new Event
                    (users[0], LocalDate.of(2020, 12, 10),
                            LocalTime.of(12, 30), 400, establishments[0]);
            //IF NO EXCEPTIONS, PRINT OUT SUCCESS MESSAGE
            System.out.println(event + " " + events[0].getEventID() + " created");
        }
        catch (Exception e)
        //IF EXCEPTIONS PRINT OUT DETAILS INCLUDING CURRENT OBJECT ID
        { System.out.println(event + " " + e.getMessage()); }

        /* EVENT 2 */

        try {
            event = "event2";
            events[1] = new Event
                    (users[1], LocalDate.of(2020, 11, 9),
                            LocalTime.of(25, 30), 400, establishments[1]);
            System.out.println(event + " " + events[1].getEventID() + " created");
        }
        catch (Exception e)
        { System.out.println(event + " " + e.getMessage()); }

        /* EVENT 3 */

        try {
            event = "event3";
            events[2] = new Event
                    (users[2], LocalDate.of(2021, 13, 6),
                            LocalTime.of(12, 61), 400, establishments[2]);
            System.out.println(event + " " + events[2].getEventID() + " created");
        }
        catch (Exception e)
        { System.out.println(event + " " + e.getMessage()); }

        /* EVENT 4 */

        try {
            event = "event4";
            events[3] = new Event
                    (users[3], LocalDate.of(2020, 9, 7),
                            LocalTime.of(12, 45), 400, establishments[3]);
            System.out.println(event + " " + events[3].getEventID() + " created");
        }
        catch (Exception e)
        { System.out.println(event + " " + e.getMessage()); }

        /* EVENT 5 */

        try {
            event = "event5";
            events[4] = new Event
                    (users[4], LocalDate.of(2020, 6, 7),
                            LocalTime.of(13, 2), 400, establishments[4]);
            System.out.println(event + " " + events[4].getEventID() + " created");
        }
        catch (Exception e)
        { System.out.println(event + " " + e.getMessage()); }

        /* EVENT 6 */

        try {
            event = "event6";
            events[5] = new Event
                    (users[5], LocalDate.of(2022, 1, 3),
                            LocalTime.of(19, 35), 400, establishments[5]);
            System.out.println(event + " " + events[5].getEventID() + " created");
        }
        catch (Exception e)
        { System.out.println(event + " " + e.getMessage()); }

        /* EVENT 7 */

        try {
            event = "event7";
            events[6] = new Event
                    (users[6], LocalDate.of(2021, 1, 4),
                            LocalTime.of(18, 15), 400, establishments[6]);
            System.out.println(event + " " + events[6].getEventID() + " created" + "\n");
        }
        catch (Exception e)
        { System.out.println(event + " " + e.getMessage() + "\n"); }

        //LOOP THROUGH USERS ARRAY AND PRINT DISPLAY EACH USER
        for(int i = 0; i < users.length; i++)
        {
            try
            {
                System.out.println(users[i].displayUserShortHand() + "\n");
            }
            //CATCH ANY EXCEPTIONS AND PRINT MESSAGE INCLUDING INDEX OF ERRONEOUS OBJECT
            catch (Exception e)
            { System.out.println("User object at index " + i + " is " + e.getMessage() + "\n"); }

        }

        //LOOP THROUGH ESTABLISHMENTS ARRAY AND PRINT DISPLAY EACH ESTABLISHMENT
        for(int i = 0; i < establishments.length; i++)
        {
            try
            {
                System.out.println(establishments[i].displayEstablishment() + "\n");
            }
            catch (Exception e)
            { System.out.println("Establishment object at index " + i + " is " + e.getMessage() + "\n"); }

        }

        //LOOP THROUGH EVENTS ARRAY AND PRINT EACH EVENT
        for(int i = 0; i < events.length; i++)
        {
            try
            {
                System.out.println(events[i].displayEvent() + "\n");
            }
            catch (Exception e)
            { System.out.println("Event object at index " + i + " is " + e.getMessage() + "\n"); }

        }

        //****** TESTING CSV INPUT

        //CREATE A DEBUG EVENT AND ESTABLISHMENT TO ADD TO CSV

           Event debugEvent = new Event(
                   users[6],
                   LocalDate.now(),
                   LocalTime.now(),
                   400,
                   establishments[6]);

        Establishment debugEstablishment = new Establishment(
                "Some Down-in-one Place",
                "1 Archbishop Street",
                "FA8 3KE",
                5);

        //ADD EVENT  TO CSV WITH CURRENT LOCAL DATE TIME
        // THIS SHOULD ADD TO CSV AND PRINT A SUCCESS MESSAGE

        try
        {
            //ADD EVENT TO CSV
            boolean eventResult = io.ioController.addEvent(debugEvent);

            //IF RESULT IS TRUE, PRINT A SUCCESS MESSAGE
            if(eventResult) {
                System.out.println(event + " " + debugEvent.getEventID() + " created" + "\n");
            }
            //IF RESULT IS FALSE PRINT A DUPLICATE ENTRY MESSAGE
            if(!eventResult)
            {
                System.out.println("Event " + debugEvent.getEventID() + " is a duplicate entry and has not been added" + "\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println(event + " " + e.getMessage() + "\n");
        }

        //ADD EVENT A SECOND TIME
        // THIS SHOULD FAIL AND PRINT A MESSAGE TO SAY THEY ARE DUPLICATE ENTRIES

        try
        {
            //ADD EVENT TO CSV
            boolean eventResult = io.ioController.addEvent(debugEvent);

            //IF RESULT IS TRUE, PRINT A SUCCESS MESSAGE
            if(eventResult) {
                System.out.println(event + " " + debugEvent.getEventID() + " created" + "\n");
            }
            //IF RESULT IS FALSE PRINT A DUPLICATE ENTRY MESSAGE
            if(!eventResult)
            {
                System.out.println("Event " + debugEvent.getEventID() + " is a duplicate entry and has not been added" + "\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println(event + " " + e.getMessage() + "\n");
        }









//
//        //CREATE AN ESTABLISHMENT OBJECT - JH
//
//        Establishment TwoEgg = new Establishment
//                (
//                        "The Two Egg Arena",
//                        "1263 Sycamore Terrace",
//                        "NE1 7RT",
//                        2633
//                );
////



        // TEST TO ADD ESTABLISHMENT
//        System.out.println(Controller.addEstablishment(TwoEgg));

        //TEST TO DISPLAY ESTABLISHMENTS
//        ArrayList<Establishment> establishments = Controller.getEstablishments();
//
//        for(Establishment establishment : establishments)
//        {
//            System.out.println(establishment.displayEstablishment());
//        }




//        Establishment FiveSausage = new Establishment      // NEED TO INVESTIGATE HOW TO ADD STRING[] AS CONSTRUCTOR
//                (
//                        "The Five Sausage Arena",
//                        "15 BRIGHT CLOSE, NE30 EBDF",
//                        4567
//                );


        //BELOW ARE VARIOUS METHODS TO TEST THE BEHAVIOUR OF THE CLASSES - JH

//        System.out.println(Jack.displayUser());
//        System.out.println();
//        System.out.println(Jack.displayUserShortHand());
//        System.out.println();
//        System.out.println(Jack.getAge());
//        System.out.println();
//        System.out.println(TwoEgg.displayEstablishment());
//        System.out.println();
//        System.out.println(TheBigOne.getUser().getName());
//        System.out.println();
//        System.out.println(TheBigOne.getPartyNumber());
//        System.out.println(TheBigOne.getUser().displayUser());
//        System.out.println(TheBigOne.getEventId());
//        System.out.println(TheBigOne.getEstablishment().displayEstablishment());
//        System.out.println(TheBigOne.displayEvent());
//        System.out.println(TheBigOne.getEventDate());
//        System.out.println(TheBigOne.getEventTime());



    }
}
