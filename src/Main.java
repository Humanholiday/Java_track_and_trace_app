import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

// NEW MAIN CLASS CREATED IN ORDER TO RUN TESTS

public class Main {

    //MAIN METHOD FOR APPLICATION - JH

    public static void main(String[] args) throws IOException {

            IO menu = new IO();
            menu.runMenu();
//
//
//
//        //CREATE A USER OBJECT - JH
//
//        User Jack = new User
//                (
//                        "Jack Healy",
//                        LocalDate.of(1985, 6, 8) ,
//                        "jackhealy85@gmail.com",
//                        "07515708720"
//                );
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
//
//        //CREATE AN EVENT OBJECT - JH
//
//        Event TheBigOne = new Event
//                (
//                        Jack,
//                        LocalDate.of(2020, 12, 10),
//                        LocalTime.of(12, 30),
//                        400,
//                        TwoEgg
//                );


        // TEST TO ADD ESTABLISHMENT
//        System.out.println(Controller.addEstablishment(TwoEgg));

        //TEST TO DISPLAY ESTABLISHMENTS
//        ArrayList<Establishment> establishments = Controller.getEstablishments();
//
//        for(Establishment establishment : establishments)
//        {
//            System.out.println(establishment.displayEstablishment());
//        }



//        // sample of Establishments to save in out CSV File
//        Establishment[] Establishments = new Establishment[][3];
//        Establishment[0] = new Establishment("Some Coffee House", "1 King Street", "FA1 3KE,", 5);
//        Establishment[1] = new Establishment("Some Restaurant Place", "1 Queen Street", "FA2 3KE", 5);
//        Establishment[2] = new Establishment("Some Book Place", "1 Regal Street", "FA4 3KE", 20);
//        Establishment estab = new Establishment("Harry Potters House", new String[]{"1 Privet Drive","NE1 4YU"},2); System.out.println(estab.getEstablishmentDetails());

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




         //****** - CREATE EVENTS.CSV HEADER ROW

                    // create "header" row first
//            csvWriter.append("Event ID");
//            csvWriter.append(",");               // comma separators
//            csvWriter.append("User Name");
//            csvWriter.append(",");
//            csvWriter.append("Date of Birth");
//            csvWriter.append(",");
//            csvWriter.append("Email");
//            csvWriter.append(",");
//            csvWriter.append("Contact Number");
//            csvWriter.append(",");
//            csvWriter.append("Age");
//            csvWriter.append(",");
//            csvWriter.append("Event Date");
//            csvWriter.append(",");
//            csvWriter.append("Event Time");
//            csvWriter.append(",");
//            csvWriter.append("Party Size");
//            csvWriter.append(",");
//            csvWriter.append("Establishment Name");
//            csvWriter.append(",");
//            csvWriter.append("FirstLine Address");
//            csvWriter.append(",");
//            csvWriter.append("Postcode");
//            csvWriter.append(",");
//            csvWriter.append("Max Occupancy");
//            csvWriter.append("\n");             // new line character
//
//            csvWriter.flush();
//            csvWriter.close();
    }
}
