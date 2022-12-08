package tabs;
public class Pass extends Table{
    
    public Pass(int id_Gameur1, int id_Gameur2, double temps, int id_Match) {
        this.id_Gameur1 = id_Gameur1;
        this.id_Gameur2 = id_Gameur2;
        this.temps = temps;
        this.id_Match = id_Match;
    }
    int id_Pass;
    int id_Gameur1;
    int id_Gameur2;
    double temps;
    int id_Match;

    public Pass(){ }

    public Pass(int id_Pass) {
        this.id_Pass = id_Pass;
    }
    public Pass(int id_Gameur1, int id_Gameur2, int id_Match) {
        this.id_Gameur1 = id_Gameur1;
        this.id_Gameur2 = id_Gameur2;
        this.id_Match = id_Match;
    }
    public int getId_Pass() {
        return id_Pass;
    }
    public void setId_Pass(int id_Pass) {
        this.id_Pass = id_Pass;
    }
    public int getId_Gameur1() {
        return id_Gameur1;
    }
    public void setId_Gameur1(int id_Gameur1) {
        this.id_Gameur1 = id_Gameur1;
    }
    public int getId_Gameur2() {
        return id_Gameur2;
    }
    public void setId_Gameur2(int id_Gameur2) {
        this.id_Gameur2 = id_Gameur2;
    }
    public int getId_Match() {
        return id_Match;
    }
    public void setId_Match(int id_Match) {
        this.id_Match = id_Match;
    }
    public double getTemps() {
        return temps;
    }
    public void setTemps(double temps) {
        this.temps = temps;
    }
}