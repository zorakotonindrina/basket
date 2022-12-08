package main;
import java.sql.Date;
import java.time.LocalDate;
import connect.*;
import frame.Fenetre;
import tabs.*;
public class Main{
    public static void main(String[] args) {

        
        try {
            Connexion con=new Connexion();
            // Date dat=Date.valueOf(LocalDate.now());
            // Gameur g=new Gameur(1);
            // Object[] tabg=g.select(con);
            // g=(Gameur)g.selectMe(con, "id_Gameur");
            // System.out.println(tabg.length);
            Match m=new Match(2,1, 2, Date.valueOf(LocalDate.now()));
           //m.insert(con, "id_Match");
            //Movement mov=new Movement(1, "P", 0, 1.1, 2);
           // mov.insert(con,"id_Movement");
            //m=(Match)m.selectMe(con, "id_Match");
            //Fenetre f = new Fenetre(m);
            Statistique stat=new Statistique(2);
            System.out.println(stat.getE1().getPoints(con));
            System.out.println(stat.getE2().getPoints(con));
            // Team t=new Team(2);
            // t=(Team)t.selectMe(con, "id_Team");
            // System.out.println(t.getPoints(con));
            // Gameur g=new Gameur(4);
            // g=(Gameur)g.selectMe(con, "id_Gameur");
            // System.out.println(g.getPoints(con, "T"));

           

            // Team t=new Team( "E1");
            // t.insert(con,"id_Team");
            // Team t2=new Team("EA");
            // t2.insert(con,"id_Team");


            // Gameur g1=new Gameur("J1", 1);
            // g1.insert(con,"id_Gameur");
            // Gameur g2=new Gameur("J2", 1);
            // g2.insert(con,"id_Gameur");
            // Gameur g3=new Gameur("J3", 1);
            // g3.insert(con,"id_Gameur");
            // Gameur g4=new Gameur("J4", 1);
            // g4.insert(con,"id_Gameur");
            // Gameur g5=new Gameur("J5", 1);
            // g5.insert(con,"id_Gameur");
            // Gameur g6=new Gameur("EA1", 2);
            // g6.insert(con,"id_Gameur");
            // Gameur g7=new Gameur("EA2", 2);
            // g7.insert(con,"id_Gameur");
            // Gameur g8=new Gameur("EA3", 2);
            // g8.insert(con,"id_Gameur");
            // Gameur g9=new Gameur("EA4", 2);
            // g9.insert(con,"id_Gameur");
            // Gameur g10=new Gameur("EA5", 2);
            // g10.insert(con,"id_Gameur");



        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
}