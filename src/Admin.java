public class Admin extends Compte {

    private Comptes comptes = Comptes.getInstance();

    public Admin() {
    }

    public String getNom() {
        return super.getNom();
    }

    public void setNom(String nom) {
        super.setNom(nom);
    }

    public String getMot() {
       return super.getMot();
    }

    public void setMot(String mot) {
        super.setMot(mot);
    }

    public void afficherInfo() {
        System.out.println();
        System.out.println("-------------------");
        System.out.println("Name: " + getNom());
        System.out.println("-------------------");
    }

    public void ajouterProgrammer(Programmeur programmeur) {
        comptes.ajouterProgrammeur(programmeur);
    }

    public void ajouterEntreprise(Enterprise enterprise) {
        comptes.ajouterEntreprise(enterprise);
    }

    public void ajouterAdmin(Admin admin) {
        comptes.ajouterAdmin(admin);
    }

    public void effacerAccount(String name) {
        comptes.effacerAccount(name);
    }

    public Compte modifierCompte(String name) {
        return comptes.modifierCompte(name);
    }

    public void afficherProgrammers() {
        comptes.afficherProgrammers();
    }


}
