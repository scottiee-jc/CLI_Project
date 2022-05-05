import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, welcome to flight booker!");
        System.out.println("Please press 1 to continue");
        int number = scanner.nextInt();

        int menuSelection = 0;

        do {
            displaymenu();

            menuSelection = scanner.nextInt();

            switch (menuSelection) {
                case 1 -> {
                    System.out.println("You have selected option 1, add a new flight:");
                    addNewFlight(scanner);
                }
                case 2 -> {
                    System.out.println("You have selected option 2, list all flights:");
                    listAllFlights(scanner);
                }
                case 3 -> {
                    System.out.println("You have selected option 3, add a new passenger:");
                    addNewPassenger(scanner);
                }
                case 4 -> {
                    System.out.println("You have selected option 4, book a flight:");
                    bookPassenger(scanner);
                }
                case 5 -> {
                    System.out.println("You have selected option 5, cancel a flight:");
                    cancelFlight(scanner);
                }
                case 6 -> {
                    System.out.println("Good bye!");
                }
            }
        } while (menuSelection != 6);


    }

    private static void displaymenu() {
        System.out.println("==========");
        System.out.println("Select an option:");
        System.out.println("1) Add a new flight");
        System.out.println("2) List all available flights");
        System.out.println("3) Add a new passenger");
        System.out.println("4) Book a passenger onto a flight");
        System.out.println("5) Cancel a flight you are booked on");
        System.out.println("6) Quit");
        System.out.println("==========");
    }



    private static void addNewFlight(Scanner scanner){
        System.out.println("Input flight number: \n");
        int inputFlightNumber;
        while(!scanner.hasNextInt()) {
            String input = scanner.next();
            System.out.printf("\"%s\" is not a valid flight number\n", input);
            System.out.println("Please enter a valid flight number: ");
        }
        inputFlightNumber = scanner.nextInt();

        System.out.println("Input flight destination: \n");
        String inputFlightDestination = scanner.nextLine();

        System.out.println("Input flight duration: \n");
        int inputFlightDuration;
        while(!scanner.hasNextInt()) {
            String input = scanner.next();
            System.out.printf("\"%s\" is not a valid duration\n", input);
            System.out.println("Please enter a valid duration: ");
        }
        inputFlightDuration = scanner.nextInt();

        System.out.println("Input flight price: \n");
        int inputFlightPrice;
        while(!scanner.hasNextInt()) {
            String input = scanner.next();
            System.out.printf("\"%s\" is not a price\n", input);
            System.out.println("Please enter a valid price: ");
        }
        inputFlightPrice = scanner.nextInt();

        System.out.println("Please enter a flight ID tag: \n");
        FlightsEnum inputFlightIDTag = Flight.valueOf(scanner.next());

        FlightDataBase.flights.put(++FlightDataBase.counter, new Flight(inputFlightNumber, inputFlightDestination,inputFlightDuration, inputFlightPrice, inputFlightIDTag));
        System.out.println("Flight successfully added to database");

    }

    private static void listAllFlights(Scanner scanner){
        System.out.println(FlightDataBase.flights.values().toString());
    }

    private static void addNewPassenger(Scanner scanner){
        System.out.println("Input name: \n");
        scanner.nextLine();
        String inputPassengerName = scanner.nextLine();
        System.out.println("Input phone number: \n");
        scanner.nextLine();
        String inputPhoneNumber = scanner.nextLine();
        System.out.println("Input passport number: \n");
        int inputPassportNumber;
        while(!scanner.hasNextInt()){
            String input = scanner.next();
            System.out.printf("\"%s\" is not a valid passport number\n", input);
            System.out.println("Please enter a valid passport number: ");
        }
        inputPassportNumber = scanner.nextInt();
        PassengerDataBase.passengers.put(++PassengerDataBase.counter, new Passenger(inputPassengerName, inputPhoneNumber, inputPassportNumber));

    }

    private static void bookPassenger(Scanner scanner){
        System.out.println("Input Passport Number: ");
        scanner.nextLine();
        int inputPassportNumber;
        while(!scanner.hasNextInt()){
            String input = scanner.next();
            System.out.printf("\"%s\" is not a valid passport number\n", input);
            System.out.println("Please enter a valid passport number or exit and 'Add a new passenger'");
        }
        inputPassportNumber = scanner.nextInt();
        Passenger passengerToBook = null;
        for(Passenger passenger : PassengerDataBase.passengers.values()) {
            if(passenger.getPassportNumber() == inputPassportNumber) {
                passenger = passengerToBook;
            }
        }
        System.out.println("Here is a list of available flights:");
        System.out.println(FlightDataBase.flights.values().toString());

        System.out.println("Input the number of the flight to book onto:");
        int inputFlightNumber = scanner.nextInt();
        Flight flightToBook = null;
        for(Flight flight : FlightDataBase.flights.values()) {
            if(flight.getUniqueFlightNumber() == inputFlightNumber){
                flight = flightToBook;
            }
        }
        flightToBook.addPassengerToFlight(passengerToBook);

        displaymenu();
    }

    private static void cancelFlight(Scanner scanner) {

        while (!scanner.hasNextInt() || !scanner.hasNextLine()) { // issue is the string
            String input = scanner.next();
            System.out.printf("\"%s\" is not a valid passport number\n", input);
            System.out.println("Please enter a valid passport number...");
            String input2 = scanner.next();
            System.out.printf("\"%s\" is not a valid flight number\n", input2);
            System.out.println("Please enter a valid flight number...");
        }
        System.out.println("Input Passport Number: ");
        int inputPassportNumber = scanner.nextInt();
        System.out.println("Input Flight Number you were booked on: ");
        int flightNumber = scanner.nextInt();
        //Flight number list
        if (FlightDataBase.flights.containsKey(flightNumber)) {
            FlightDataBase.flights.remove(flightNumber);
            System.out.println("Are you sure you want to be removed from this flight? (y/n): ");
            String yn = scanner.nextLine();
            if (yn.equals("y") || yn.equals("Y")){
                scanner.nextLine();
            } else if (yn.equals("n")||yn.equals("N")) {
                displaymenu();
            }
        System.out.println("You have been successfully removed from flight " + flightNumber);
        } else {
            System.out.println("Could not find flight number " + flightNumber + " with passport number " + inputPassportNumber);
        }
  }}



