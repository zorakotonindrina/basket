package tabs;
import java.util.Random;
import javax.swing.Action;
import connect.Connexion;
import tabs.Gameur;
public class Statistique {
    int id_match;
    Team e1;
    Team e2;
    Gameur[] ge1;
    Gameur[] ge2;
    public Statistique(int id_match) throws Exception
     {
        this.id_match = id_match;
        Connexion con=new Connexion();
        Match m=new Match(id_match);
        m=(Match)m.selectMe(con, "id_Match");
        
        Team equipe1=new Team(m.getId_Team1());
        equipe1=(Team)equipe1.selectMe(con, "id_Team");
        this.e1=equipe1;
        Team equipe2=new Team(m.getId_Team2());
        equipe2=(Team)equipe2.selectMe(con,"id_Team");
        this.e2=equipe2;
        Gameur[] gam1=equipe1.getMyGameurs(con);
        Gameur[] gam2=equipe2.getMyGameurs(con);
        ge1=gam1;
        ge2=gam2;

    }
    public int getId_match() {
        return id_match;
    }
    public void setId_match(int id_match) {
        this.id_match = id_match;
    }
    public Team getE1() {
        return e1;
    }
    public void setE1(Team e1) {
        this.e1 = e1;
    }
    public Team getE2() {
        return e2;
    }
    public void setE2(Team e2) {
        this.e2 = e2;
    }
    public Gameur[] getGe1() {
        return ge1;
    }
    public void setGe1(Gameur[] ge1) {
        this.ge1 = ge1;
    }
    public Gameur[] getGe2() {
        return ge2;
    }
    public void setGe2(Gameur[] ge2) {
        this.ge2 = ge2;
    }
    

}
