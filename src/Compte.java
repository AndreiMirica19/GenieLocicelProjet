public abstract class Compte {
    private String nom;
    private String mot;

    public Compte() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }

    abstract void afficherInfo();
}
