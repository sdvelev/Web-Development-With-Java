package bg.uni.fmi.lab02.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TaskSeven {

    public static List<FlightLeg> extractFlightLegs(Map<String, List<FlightLeg>> collection, String airport) {

        List<FlightLeg> toReturn = new ArrayList<>();

        for (Map.Entry<String, List<FlightLeg>> currentEntry : collection.entrySet()) {

            for (FlightLeg current : currentEntry.getValue()) {

                if (current.getFromAirport().equals(airport) || current.getToAirport().equals(airport)) {

                    toReturn.add(current);
                }
            }
        }

        return toReturn;
    }


    public static void main(String[] args) {

        Map<String, List<FlightLeg>> collection = new HashMap<>();

        FlightLeg flightLeg1 = new FlightLeg("LBSF", "EBBR", LocalDate.now());
        FlightLeg flightLeg2 = new FlightLeg("EBBR", "LBSF", LocalDate.now());
        FlightLeg flightLeg3 = new FlightLeg("LBSF", "KSDI", LocalDate.now());

        List<FlightLeg> flightLegs = new ArrayList<>();

        flightLegs.add(flightLeg1);
        flightLegs.add(flightLeg2);
        flightLegs.add(flightLeg3);

        collection.put("9H-VCA", flightLegs);

        System.out.println(extractFlightLegs(collection, "LBSF"));
        System.out.println(extractFlightLegs(collection, "KSDI"));
    }
}
