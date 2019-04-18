package Model;

public class Stop {
    private String id;
    private double tripToStop1Price;
    private double tripToStop2Price;
    private double tripToStop3Price;
    private double tripInCompletedPrice;

    public Stop(String id, double tripToStop1Price, double tripToStop2Price, double tripToStop3Price, double tripInCompletedPrice){
        this.id = id;
        this.tripToStop1Price = tripToStop1Price;
        this.tripToStop2Price = tripToStop2Price;
        this.tripToStop3Price = tripToStop3Price;
        this.tripInCompletedPrice = tripInCompletedPrice;
    }

    public double getTripInCompletedPrice() {
        return tripInCompletedPrice;
    }

    public String getId() {
        return id;
    }

    public double getTripPriceByStopId(String stopId){
        double price = 0;
        if ("Stop1".equals(stopId)) {
            price = this.tripToStop1Price;
        } else if ("Stop2".equals(stopId)) {
            price = this.tripToStop2Price;
        } else if ("Stop3".equals(stopId)) {
            price = this.tripToStop3Price;
        }
        return price;

    }
}
