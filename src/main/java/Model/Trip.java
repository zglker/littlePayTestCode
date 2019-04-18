package Model;

public class Trip {
    private Client client;
    private Stop tapOnStop;
    private Stop tapOffStop;
    private TripStatus tripStatus;
    private String started;
    private String finished;
    private double chargeAmount;
    private String companyId;
    private String busId;


    public Trip(Client client, Stop tapOnStop, String started, String companyId, String busId) {
        this.client = client;
        this.tapOnStop = tapOnStop;
        this.started = started;
        this.finished=null;
        this.tapOffStop = null;
        this.chargeAmount = tapOnStop.getTripInCompletedPrice();
        this.companyId = companyId;
        this.busId = busId;
        this.tripStatus = TripStatus.INCOMPLETE;
    }

    public Stop getTapOnStop() {
        return tapOnStop;
    }

    public Stop getTapOffStop() {
        return tapOffStop;
    }

    public void setTapOffStop(Stop tapOffStop) {
        this.tapOffStop = tapOffStop;
        //cancelled trip || completed trip
        this.setTripStatus(tapOffStop.getId().equals(this.getTapOnStop().getId()) ? TripStatus.CANCELLED : TripStatus.COMPLETED);
        this.chargeAmount = this.tapOnStop.getTripPriceByStopId(tapOffStop.getId());

    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public void setFinished(String finished) {
        this.finished = finished;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }

    public Client getClient() {
        return client;
    }

    public String getStarted() {
        return started;
    }

    public String getFinished() {
        return finished;
    }

    public double getChargeAmount() {
        return chargeAmount;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getBusId() {
        return busId;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "client=" + client.getPAN() +
                ", tapOnStop=" + tapOnStop.getId() +
                ", tapOffStop=" + (tapOffStop != null ? tapOffStop.getId() : null) +
                ", tripStatus=" + tripStatus +
                ", started='" + started + '\'' +
                ", finished='" + finished + '\'' +
                ", chargeAmount=" + chargeAmount +
                ", companyId='" + companyId + '\'' +
                ", busId='" + busId + '\'' +
                '}';
    }

}