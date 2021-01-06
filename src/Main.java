import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

// NEW MAIN CLASS CREATED IN ORDER TO RUN TESTS

public class Main {

    //MAIN METHOD FOR APPLICATION - JH

    public static void main(String[] args) throws IOException
    {

            IO menu = new IO();
            menu.runMenu();

            IO debugIO  = new IO();
            debug(debugIO);

    }


    // DEBUG METHOD FOR APPLICATION

    public static void debug(IO io)
    {

//        //Hard code 7 user objects
        User[] users = new User[7];
        users[0] = new User
                ("Jack Healy", LocalDate.of(1985, 6, 8) ,
                        "jackhealy85@gmail.com", "07515708720");
        users[1] = new User
                ("Jack Healy", LocalDate.of(1985, 6, 8) ,
                        "jackhealy85@gmail.com", "07515708720");
        users[2]= new User
                ("Jack Healy", LocalDate.of(1985, 6, 8) ,
                        "jackhealy85@gmail.com", "07515708720");
        users[3] = new User
                ("Jack Healy", LocalDate.of(1985, 6, 8) ,
                        "jackhealy85@gmail.com", "07515708720");
        users[4]= new User
                ("Jack Healy", LocalDate.of(1985, 4, 8) ,
                        "jackhealy85@gmail.com", "07515708720");
        users[5] = new User
                ("Jack Healy", LocalDate.of(1985, 6, 8) ,
                        "jackhealy85@gmail.com", "07515708720");
        users[6] = new User
                ("Jack Healy", LocalDate.of(1985, 6, 8) ,
                        "jackhealy85@gmail.com", "07515708720");

        // hard code 7 establishments
        Establishment[] establishments = new Establishment[7];
        establishments[0] = new Establishment("Some Coffee House", "1 King Street",
                                                  "FA1 3KE,", 5);
        establishments[1] = new Establishment("Some Restaurant Place", "1 Queen Street",
                                                "FA2 3KE", 5);
        establishments[2]= new Establishment("Some Book Place", "1 Regal Street",
                                                "FA4 3KE", 20);
        establishments[3] = new Establishment("Some Book Place", "1 Regal Street",
                                                "FA4 3KE", 20);
        establishments[4] = new Establishment("Some Book Place", "1 Regal Street",
                                                "FA4 3KE", 20);
        establishments[5] = new Establishment("Some Book Place", "1 Regal Street",
                                                "FA4 3KE", 20);
        establishments[6]= new Establishment("Some Book Place", "1 Regal Street",
                                                "FA4 3KE", 20);


        //hard code 7 events
        Event[] events = new Event[7];
        events[0] = new Event
                (users[0], LocalDate.of(2020, 12, 10),
                        LocalTime.of(12, 30), 400, establishments[0]);
        events[1] = new Event
                (users[1], LocalDate.of(2020, 12, 10),
                        LocalTime.of(12, 30), 400, establishments[1]);
        events[2]= new Event
                (users[2], LocalDate.of(2020, 12, 10),
                        LocalTime.of(12, 30), 400, establishments[2]);
        events[3] = new Event
                (users[3], LocalDate.of(2020, 12, 10),
                        LocalTime.of(12, 30), 400, establishments[3]);
        events[4] = new Event
                (users[4], LocalDate.of(2020, 12, 10),
                        LocalTime.of(12, 30), 400, establishments[4]);
        events[5] = new Event
                (users[5], LocalDate.of(2020, 12, 10),
                        LocalTime.of(12, 30), 400, establishments[5]);
        events[6] = new Event
                (users[6], LocalDate.of(2020, 12, 10),
                        LocalTime.of(12, 30), 400, establishments[6]);
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
