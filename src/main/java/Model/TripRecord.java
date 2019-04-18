package Model;

public class TripRecord {

    private String id;
    private String dateTimeUTC;
    private boolean tapType;
    private String shopId;
    private String companyId;
    private String busId;
    private String PAN;

    public TripRecord(String[] p) {
        this.id = p[0];
        this.dateTimeUTC = p[1];
        this.tapType = p[2].equals("ON");
        this.shopId = p[3];
        this.companyId = p[4];
        this.busId = p[5];
        this.PAN = p[6];
    }

    public String getDateTimeUTC() {
        return dateTimeUTC;
    }

    public boolean isTapType() {
        return tapType;
    }

    public String getShopId() {
        return shopId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getBusId() {
        return busId;
    }

    public String getPAN() {
        return PAN;
    }

    @Override
    public String toString() {
        return "TripRecord{" +
                "id='" + id + '\'' +
                ", dateTimeUTC='" + dateTimeUTC + '\'' +
                ", tapType=" + tapType +
                ", shopId='" + shopId + '\'' +
                ", companyId='" + companyId + '\'' +
                ", busId='" + busId + '\'' +
                ", PAN='" + PAN + '\'' +
                '}';
    }
}
