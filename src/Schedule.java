import java.util.GregorianCalendar;

public class Schedule {
    private String startTime;
    private String endTime;
    private String timezone;

    public Schedule() {
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void displayInfo() {
        System.out.println("Start time: " + startTime);
        System.out.println("End time: " + endTime);
        System.out.println("Timezone: " + timezone);
    }
}
