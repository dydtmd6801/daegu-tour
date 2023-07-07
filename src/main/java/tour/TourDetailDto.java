package tour;

public class TourDetailDto {

    private String overview;
    private String infoCenter;
    private String parkingInfo;
    private String contentId;

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getInfoCenter() {
        return infoCenter;
    }

    public void setInfoCenter(String infoCenter) {
        this.infoCenter = infoCenter;
    }

    public String getParkingInfo() {
        return parkingInfo;
    }

    public void setParkingInfo(String parkingInfo) {
        this.parkingInfo = parkingInfo;
    }
}
