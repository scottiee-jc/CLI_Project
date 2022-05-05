import java.util.HashMap;
import java.util.Map;

public class FlightDataBase {
    public static int counter = 5;
    public static Map<Integer, Flight> flights = new HashMap<>(){{
        put(0, new Flight(5762, "Kabul", 17, 634, FlightsEnum.KABUL));
        put(1, new Flight(7812, "Amsterdam", 1,  85, FlightsEnum.AMSTERDAM));
        put(2, new Flight(2235, "Sydney", 26,  829, FlightsEnum.SYDNEY));
        put(3, new Flight(7199, "Porto", 14, 29, FlightsEnum.PORTO));
        put(4, new Flight(2762, "New York", 12,  415, FlightsEnum.NEW_YORK));
    }};
}


// code for if we wanted to check the no. length value is correct for passport and passenger numbers
//
// public boolean check(String input){
//    int numDigits = 0;
//    int numLetters = 0;
//    for(int i=0; i<input.length();i++){
//        if(Character.isLetter(input.charAt(i))) numLetters++;
//        if(Character.isDigit(input.charAt(i))) numDigits++;
//    }
//    return (numDigits >= 5) && (numLetters >= 5);
//}


// then get the input again and assign it to a message
// while(!check(message)){
// e.g. String input =
// }