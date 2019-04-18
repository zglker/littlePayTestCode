import Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TripCalculation {

    private Map<String, Stop> stopMap;
    private List<TripRecord> tripRecords;
    public TripCalculation(List<TripRecord> tripRecords, Map<String, Stop> stopMap) {
        this.tripRecords = tripRecords;
        this.stopMap = stopMap;
    }

    /**
     * get list of trips
     * @return
     */
    public List<Trip> calculateTrips() {
        TripRecord tripRecord = null;
        List<Trip> trips = new ArrayList<Trip>();

        while(tripRecords.size() > 0)
        {
            //get a new record and remove it from tripRecords list
            if(tripRecord == null)
            {
                tripRecord = tripRecords.get(0);
                tripRecords.remove(tripRecord);
            }

            Client client = new Client(tripRecord.getPAN());
            //initialize trip, default as incomplete
            Trip trip = new Trip(client, stopMap.get(tripRecord.getShopId()), tripRecord.getDateTimeUTC(), tripRecord.getCompanyId(), tripRecord.getBusId());

            //try to find same client's next tripRecord
            TripRecord tripRecord1 = findNextTripRecordOfClient(tripRecords, client);


            //next record of this client exists
            if(tripRecord1 != null)
            {
                tripRecords.remove(tripRecord1);
                //trip complete or cancelled
                if(tripRecord1.isTapType() == false)
                {
                    trip.setTapOffStop(stopMap.get(tripRecord1.getShopId()));
                    trip.setFinished(tripRecord1.getDateTimeUTC());
                    tripRecord = null;
                }
                //incomplete trip
                else{
                    tripRecord = tripRecord1;
                }
            }
            //this is the last record for such client
            else{
                tripRecord = null;
            }
            trips.add(trip);
        }
        return trips;
    }


    /**
     * find same client's next tripRecord
     * @param tripRecords
     * @param client
     * @return
     */
    private static TripRecord findNextTripRecordOfClient(List<TripRecord> tripRecords, Client client) {
        for (TripRecord tripRecord : tripRecords)
        {
            if(tripRecord.getPAN().equals(client.getPAN()))
            {
                return tripRecord;
            }
        }
        return null;
    }
}
