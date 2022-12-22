public class Horaire {
    private String heureDebut;
    private String heureFin;
    private String timezone;

    public Horaire() {
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void displayInfo() {
        System.out.println("Start time: " + heureDebut);
        System.out.println("End time: " + heureFin);
        System.out.println("Timezone: " + timezone);
    }
}
