import Model.Stop;
import org.junit.Assert;
import org.junit.Test;

public class StopTest {
    @Test

    public void testStop(){
        Stop s1 = new Stop("Stop1", 0, 3.25, 7.30, 7.30);
        Assert.assertEquals(0, s1.getTripPriceByStopId("Stop1"), 0.00);
        Assert.assertEquals(3.25, s1.getTripPriceByStopId("Stop2"), 0.00);
        Assert.assertEquals(7.30, s1.getTripPriceByStopId("Stop3"), 0.00);
        Assert.assertEquals(7.3, s1.getTripInCompletedPrice(), 0.00);

    }


}
