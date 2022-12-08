package tabs;
public class Action extends Table{
    int id_Action ;
    int id_Gameur ;
    String type ;
    int level ;
    int temps; 
    int id_Match;
    public Action(int id_Gameur, String type, int level, int temps, int id_Match) {
        this.id_Gameur = id_Gameur;
        this.type = type;
        this.level = level;
        this.temps = temps;
        this.id_Match = id_Match;
    }

    public Action(int id_Action) {
        this.id_Action = id_Action;
    }
   
    public int getId_Action() {
        return id_Action;
    }
    public void setId_Action(int id_Action) {
        this.id_Action = id_Action;
    }
    public int getId_Gameur() {
        return id_Gameur;
    }
    public void setId_Gameur(int id_Gameur) {
        this.id_Gameur = id_Gameur;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getId_Match() {
        return id_Match;
    }
    public void setId_Match(int id_Match) {
        this.id_Match = id_Match;
    }
}