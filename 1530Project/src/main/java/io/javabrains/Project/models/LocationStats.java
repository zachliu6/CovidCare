package io.javabrains.Project.models;

public class LocationStats {

    private String state;
    private String country;
    private int latestTotalCases;
    private int dailyChange;
    private int[] seven_day_cases;
    public int twoDayCases;
    public int threeDayCases;
    public int fourDayCases;
    public int fiveDayCases;
    public int sixDayCases;
    public int sevenDayCases;
    private int prevDayCases;


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
                ", latestTotalCases=" + latestTotalCases + '\'' +
                ", latestTotalCases=" + twoDayCases +
                '}';
    }
    public void setSeverDayCases(int[] seven_days_cases) {
        this.seven_day_cases=seven_days_cases;
    }

    public int[] getSeverDayCases() {
        return seven_day_cases;
    }

    public void setTwoDaycases(int twoDayCases) {
        this.twoDayCases = twoDayCases;
    }
    public int getTwoDaycases() {
        return twoDayCases;
    }

    public void setThreeDaycases(int threeDayCases) {
        this.threeDayCases = threeDayCases;
    }
    public int getThreeDaycases() {
        return threeDayCases;
    }

    public void setFourDaycases(int fourDayCases) {
        this.fourDayCases = fourDayCases;
    }
    public int getFourDaycases() {
        return fourDayCases;
    }
    public void setFiveDaycases(int fiveDayCases) {
        this.fiveDayCases = fiveDayCases;
    }
    public int getFiveDaycases() {
        return fiveDayCases;
    }

    public void setSixDaycases(int sixDayCases) {
        this.sixDayCases = sixDayCases;
    }
    public int getSixDaycases() {
        return sixDayCases;
    }

    public void setSevenDaycases(int sevenDayCases) {
        this.sevenDayCases = sevenDayCases;
    }
    public int getSevenDaycases() {
        return sevenDayCases;
    }

    public void setPrevDayCases(int prevDayCases) {
        this.prevDayCases=prevDayCases;
    }

    public int getPrevDayCases(){
        return prevDayCases;
    }
}
