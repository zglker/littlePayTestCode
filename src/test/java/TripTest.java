import Model.Client;
import Model.Stop;
import Model.Trip;
import Model.TripStatus;
import org.junit.Assert;
import org.junit.Test;

public class TripTest {
    @Test
    public void testTrip(){
        Client client = new Client("5500005555555559");
        Stop stop1 = new Stop("Stop1", 0, 3.25, 7.30, 7.30);
        Stop stop2 = new Stop("Stop2", 3.25, 0, 5.50, 5.50);

        Trip trip = new Trip(client, stop1, "22-03-2018 13:15:02", "Company1", "Bus1");

        //incomplete
        Assert.assertEquals(stop1, trip.getTapOnStop());
        Assert.assertEquals(null, trip.getTapOffStop());
        Assert.assertEquals(7.30, trip.getChargeAmount(), 0.00);
        Assert.assertEquals(null, trip.getFinished());
        Assert.assertEquals(TripStatus.INCOMPLETE, trip.getTripStatus());

        //completed trip
        trip.setTapOffStop(stop2);
        trip.setFinished("22-03-2018 13:25:02");
        Assert.assertEquals(3.25, trip.getChargeAmount(), 0.00);
        Assert.assertEquals(TripStatus.COMPLETED, trip.getTripStatus());

        //cancelled trip
        Trip trip1 = new Trip(client, stop1, "22-03-2018 13:15:02", "Company1", "Bus1");
        trip1.setTapOffStop(stop1);
        trip1.setFinished("22-03-2018 13:25:02");
        Assert.assertEquals(0, trip1.getChargeAmount(), 0.00);
        Assert.assertEquals(TripStatus.CANCELLED, trip1.getTripStatus());

    }
}
