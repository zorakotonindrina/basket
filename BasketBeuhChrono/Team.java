package tabs;

import connect.Connexion;
import tabs.Gameur;
import tabs.Table;

public class Team extends Table{
    

    int id_Team;
    String nom_Team;
    //int points ;
    

    public Team( ){ }
    // public Team(int points,int ok) {
    //     this.points = points;
    // }
    public Team(int id_Team) {
        this.id_Team = id_Team;
    }
    public Team(int id_Team, String nom_Team) {
        this.id_Team = id_Team;
        this.nom_Team = nom_Team;
    }
    public Team(String nom_Team) {
        this.nom_Team = nom_Team;
    }
    public int getId_Team() {
        return id_Team;
    }
    public void setId_Team(int id_Team) {
        this.id_Team = id_Team;
    }
    public String getNom_Team() {
        return nom_Team;
    }
    public void setNom_Team(String nom_Team) {
        this.nom_Team = nom_Team;
    }
    // public int getPoints() {
    //     return points;
    // }
    // public void setPoints(int points) {
    //     this.points = points;
    // }

    public Gameur[] getMyGameurs(Connexion con)throws Exception {
        if(con == null){
            con=new Connexion();
            }
            boolean test=false;
            //int valiny=false;
        try {
            Gameur temp=new Gameur();
            Gameur[] allg=temp.getAllGameurs(con);
            int k=0;
            for (int i = 0; i < allg.length; i++) {
                if(allg[i].getId_Team()==this.getId_Team()){
                    k ++;
                }
            }
            Gameur[] myg=new Gameur[k];
            int h=0;
            for (int i = 0; i < allg.length; i++) {
                if(allg[i].getId_Team()==this.getId_Team()){
                    myg[h]=allg[i];
                    h++;
                }
            }
            test=true;
            return myg;
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }finally{
            if(test == true){
                //con.getCon().close();
            } 
        }
        return null;

       
    }


    public int getPoints(Connexion con) throws Exception{
        if(con == null){
            con=new Connexion();
            }
            boolean test=false;
            
        try {
                int essai=0;
                Gameur[] tabg=this.getMyGameurs(con);
                for (int i = 0; i < tabg.length; i++) {
                    essai = essai + tabg[i].getPoints(con, "T"); 
                }
                test = true;
                return essai;

        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }finally{
            if(test == true){
                //con.getCon().close();
            } 
        }
        return 0;

    }

    public int getRebonds(Connexion con) throws Exception{
        if(con == null){
            con=new Connexion();
            }
            boolean test=false;
            
        try {
                int essai=0;
                Gameur[] tabg=this.getMyGameurs(con);
                for (int i = 0; i < tabg.length; i++) {
                    essai = essai + tabg[i].getSomeRebons(con); 
                }
                test = true;
                return essai;

        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }finally{
            if(test == true){
                //con.getCon().close();
            } 
        }
        return 0;

    }
     
}