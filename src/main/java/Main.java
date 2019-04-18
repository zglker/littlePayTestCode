import Model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {
    final static double cancelledTripPrice = 0;

    public static void main(String args[])
    {
        resolve();
    }

    private static void resolve() {

        //read all records to List
        List<TripRecord> tripRecords = getTripRecordFromCSV();

        //initialize calculation
        List<Stop> stops = new ArrayList<Stop>();
        //prepare stops
        Stop stop1 = new Stop("Stop1", cancelledTripPrice, 3.25, 7.30, 7.30);
        Stop stop2 = new Stop("Stop2", 3.25, cancelledTripPrice, 5.50, 5.50);
        Stop stop3 = new Stop("Stop3", 7.30, 5.50, cancelledTripPrice, 7.30);

        stops.add(stop1);
        stops.add(stop2);
        stops.add(stop3);
        Map<String, Stop> stopMap = stops.stream().collect(Collectors.toMap(s -> String.valueOf(s.getId()), s -> s));

        TripCalculation tripCalculation = new TripCalculation(tripRecords, stopMap);

        //get list of trips
        List<Trip> trips = tripCalculation.calculateTrips();

        // write all resultRecords to a csv based on trips;
        saveResultRecordsToCSVFromTrips(trips);
    }

    /**
     * write all resultRecords to csv based on trips;
     * @param trips
     */
    private static void saveResultRecordsToCSVFromTrips(List<Trip> trips) {
        try {

            PrintWriter pw= new PrintWriter(new File("trips.csv"));
            StringBuilder sb=new StringBuilder();
            //prepare head of the file
            sb.append("Started");
            sb.append(",");
            sb.append("Finished");
            sb.append(",");
            sb.append("DurationSecs");
            sb.append(",");
            sb.append("FromStopId");
            sb.append(",");
            sb.append("ToStopId");
            sb.append(",");
            sb.append("ChargeAmount");
            sb.append(",");
            sb.append("CompanyId");
            sb.append(",");
            sb.append("BusID");
            sb.append(",");
            sb.append("PAN");
            sb.append(",");
            sb.append("Status");
            sb.append("\n");

            for(Trip trip : trips)
            {
                // record trips in the way requested
                ResultRecord resultRecord = new ResultRecord();
                resultRecord.setStarted(trip.getStarted());
                resultRecord.setFinished(trip.getFinished());
                resultRecord.setDurationSecs();
                resultRecord.setFromStopId(trip.getTapOnStop().getId());
                resultRecord.setToStopId(trip.getTapOffStop() != null ? trip.getTapOffStop().getId() : "Unknown");
                resultRecord.setChargeAmount(String.valueOf(trip.getChargeAmount()));
                resultRecord.setStatus(trip.getTripStatus());
                resultRecord.setCompanyId(trip.getCompanyId());
                resultRecord.setBusId(trip.getBusId());
                resultRecord.setPAN(trip.getClient().getPAN());
                sb.append(resultRecord.toString());

            }
            pw.write(sb.toString());
            pw.close();
            System.out.println("Done.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * get list of tripRecord from csv
     * @return
     */
    private static List<TripRecord> getTripRecordFromCSV() {
        List<TripRecord> tripRecords = new ArrayList<TripRecord>();
        try{

            InputStream inputFS = Main.class.getResourceAsStream("test.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
            // skip the header
            tripRecords = br.lines().skip(1).map(line->{

                String[] p = line.split(",");
                TripRecord tr = new TripRecord(p);
                return tr;
            }).collect(Collectors.toList());
            br.close();
        } catch (IOException e) {
            System.out.println("File not find.");
        }
        return tripRecords;

    }
}
