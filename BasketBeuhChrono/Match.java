package tabs;
import java.sql.Date;
public class Match extends Table{
    int id_Match ;
    int id_Team1 ;
    int id_Team2 ;
    Date date_match;

    public Match(int id_Match, int id_Team1, int id_Team2, Date date_match) {
        this.id_Match = id_Match;
        this.id_Team1 = id_Team1;
        this.id_Team2 = id_Team2;
        this.date_match = date_match;
    }
    public Match(){ }
    public Match(int id_Match) {
        this.id_Match = id_Match;
    }
    public Match(int id_Team1, int id_Team2, Date date_match) {
        this.id_Team1 = id_Team1;
        this.id_Team2 = id_Team2;
        this.date_match = date_match;
    }
    public int getId_Match() {
        return id_Match;
    }
    public void setId_Match(int id_Match) {
        this.id_Match = id_Match;
    }
    public int getId_Team1() {
        return id_Team1;
    }
    public void setId_Team1(int id_Team1) {
        this.id_Team1 = id_Team1;
    }
    public int getId_Team2() {
        return id_Team2;
    }
    public void setId_Team2(int id_Team2) {
        this.id_Team2 = id_Team2;
    }
    // public int getScore1() {
    //     return score1;
    // }
    // public void setScore1(int score1) {
    //     this.score1 = score1;
    // }
    // public int getScore2() {
    //     return score2;
    // }
    // public void setScore2(int score2) {
    //     this.score2 = score2;
    // }
    public Date getDate_match() {
        return date_match;
    }
    public void setDate_match(Date date_match) {
        this.date_match = date_match;
    }

    
}