package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class ResultRecord {
    private String started;
    private String finished;
    private String durationSecs;
    private String fromStopId;
    private String toStopId;
    private String chargeAmount;
    private String companyId;
    private String busId;
    private String PAN;
    private TripStatus status;

    public ResultRecord() {
        this.started = null;
        this.finished = null;
        this.durationSecs = "";
        this.fromStopId = null;
        this.toStopId = null;
        this.chargeAmount = null;
        this.companyId = null;
        this.busId = null;
        this.PAN = null;
        this.status = null;
    }

    public void setStarted(String started) {
        this.started = started;
    }

    public void setFinished(String finished) {
        this.finished = finished;
    }

    /**
     * set durationsecs based on finished date and started date
     */
    public void setDurationSecs(){

        long seconds = 0;
        if(this.finished == null)
        {
            this.durationSecs = "Unknown";
        }else{
            try {
                SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                Date startDate = simpleDateFormat.parse(this.started);
                Date endDate = simpleDateFormat.parse(this.finished);
                seconds = Math.abs(endDate.getTime() - startDate.getTime())/1000;
                this.durationSecs = String.valueOf(seconds);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }

    public void setFromStopId(String fromStopId) {
        this.fromStopId = fromStopId;
    }

    public void setToStopId(String toStopId) {
        this.toStopId = toStopId;
    }

    public void setChargeAmount(String chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public void setPAN(String PAN) {
        this.PAN = PAN;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  started + "," +
                (finished == null ? "Unknown" : finished) + "," +
                durationSecs + "," +
                fromStopId + "," +
                toStopId + "," +
                "$" +chargeAmount + "," +
                companyId + "," +
                busId + "," +
                PAN+"\t" + "," +
                status + '\n';
    }
}
