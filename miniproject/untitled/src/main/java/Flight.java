import java.util.ArrayList;

public class Flight {
    
    //properties
    private String flightDestination;
    private FlightsEnum flightIDTag;
    private int uniqueFlightNumber;
    private int flightDuration;
    private int flightPrice;
    private ArrayList<Passenger> passengers;

    
    //constructor

    public Flight(int uniqueFlightNumber, String flightDestination, int flightDuration, int flightPrice, FlightsEnum flightIDTag){
        this.flightDestination = flightDestination;
        this.uniqueFlightNumber = uniqueFlightNumber;
        this.flightDuration = flightDuration;
        this.flightPrice = flightPrice;
        this.flightIDTag = flightIDTag;
        this.passengers = new ArrayList<>();
    }

    public static FlightsEnum valueOf(String next) {
        switch (next) {
            case "KBL":
                return FlightsEnum.KABUL;
            case "AMS":
                return FlightsEnum.AMSTERDAM;
            case "EWR":
                return FlightsEnum.NEW_YORK;
            case "OPO":
                return FlightsEnum.PORTO;
            case "SYD":
                return FlightsEnum.SYDNEY;
            default:
                return null;
        }
    }


    //getters and setters

    public String getFlightDestination() {
        return flightDestination;
    }

    public void setFlightDestination(String flightDestination) {
        this.flightDestination = flightDestination;
    }

    public int getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(int flightDuration) {
        this.flightDuration = flightDuration;
    }

    public int getUniqueFlightNumber() {
        return uniqueFlightNumber;
    }

    public void setUniqueFlightNumber(int uniqueFlightNumber) {
        this.uniqueFlightNumber = uniqueFlightNumber;
    }

    public int getFlightPrice() {
        return flightPrice;
    }

    public void setFlightPrice(int flightPrice) {
        this.flightPrice = flightPrice;
    }

    public FlightsEnum getFlightIDTag() {
        return flightIDTag;
    }

    public void setFlightIDTag(FlightsEnum flightIDTag) {
        this.flightIDTag = flightIDTag;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    //behaviours

    public void addPassengerToFlight(Passenger passenger){
        this.passengers.add(passenger);
        System.out.println(passenger.getName() + " has been successfully booked onto flight " + this.getFlightIDTag().getFlightIDCode());
    }

    public void cancelFlightForPassenger(Passenger passenger){
        this.passengers.remove(passenger);
        System.out.println(passenger.getName() + " has been successfully removed from flight " + this.getFlightIDTag().getFlightIDCode());
    }

    @Override
    public String toString(){
             return    this.getFlightIDTag().getFlightIDCode() +
                        this.getUniqueFlightNumber() + ", " +
                        this.getFlightDestination() + ", " +
                        this.getFlightDuration() + " H" + ", " + "£" +
                        this.getFlightPrice();

    }
}
