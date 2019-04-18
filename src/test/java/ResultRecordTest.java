import Model.ResultRecord;
import Model.TripStatus;
import org.junit.Assert;
import org.junit.Test;


public class ResultRecordTest {

    @Test
    public void testResultRecord(){
        ResultRecord resultRecord = new ResultRecord();
        resultRecord.setStarted("22-01-2018 13:00:00");
        resultRecord.setFinished("22-01-2018 13:08:05");
        resultRecord.setDurationSecs();
        resultRecord.setFromStopId("Shop1");
        resultRecord.setToStopId("Shop2");
        resultRecord.setChargeAmount("3.3");
        resultRecord.setStatus(TripStatus.COMPLETED);
        resultRecord.setCompanyId("Company22");
        resultRecord.setBusId("Bus33");
        resultRecord.setPAN("122000000000003");
        System.out.println(resultRecord.toString());
        Assert.assertEquals("22-01-2018 13:00:00,22-01-2018 13:08:05,485,Shop1,Shop2,$3.3,Company22,Bus33,122000000000003\t,COMPLETED\n", resultRecord.toString());
    }



}