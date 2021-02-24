package io.javabrains.Project.models;

public class LocationStats {

    private String state;
    private String country;
    private int latestTotalCases;
    private int dailyChange;

    public int getDailyChange() {
        return dailyChange;
    }

    public void setDailyChange(int dailyChange) {
        this.dailyChange = dailyChange;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLatestTotalCases() {
        return latestTotalCases;
    }

    public void setLatestTotalCases(int latestTotalCases) {
        this.latestTotalCases = latestTotalCases;
    }

    @Override
    public String toString() {
        return "LocationStats{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", latestTotalCases=" + latestTotalCases +
                '}';
    }
}
