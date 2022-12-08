package tabs;
import java.util.Random;
import javax.swing.Action;
import connect.Connexion;
public class Gameur extends Table{
    int id_Gameur;
    String nom ;
    int id_Team ;
    boolean withBall;
    public Gameur(){ }
    public int lenghFields(){
        return 3;
    }
    public Gameur(String nom, int id_Team) {
        this.nom = nom;
        this.id_Team = id_Team;
    }
    public Gameur(int id_Gameur) {
        this.id_Gameur = id_Gameur;
    }
    public Gameur(int id_Gameur, String nom, int id_Team) {
        this.id_Gameur = id_Gameur;
        this.nom = nom;
        this.id_Team = id_Team;
    }
    public int getId_Gameur() {
        return id_Gameur;
    }
    public void setId_Gameur(int id_Gameur) {
        this.id_Gameur = id_Gameur;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getId_Team() {
        return id_Team;
    }
    public void setId_Team(int id_Team) {
        this.id_Team = id_Team;
    }
    public boolean isWithBall() {
        return withBall;
    }
    public void setWithBall(boolean withBall) {
        this.withBall = withBall;
    }



    public Gameur[] getAllGameurs(Connexion con) throws Exception {
        if(con == null){
            con=new Connexion();
            }
            boolean test=false;
            //int valiny=false;
        try {
            Object[] allt=this.select(con);
            Gameur[] allg=new Gameur[allt.length]; 
            for (int i = 0; i < allg.length; i++) {
                allg[i]=(Gameur)allt[i];
            }

            test=true;
            return allg;
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


    public void shoot(Connexion con,int level,double min,int id_match) throws Exception {
        if(con == null){
            con=new Connexion();
            }
            boolean test=false;
        try {
            // if(this.withBall==true){
                Movement mov=new Movement(this.id_Gameur,"T",level,min,id_match);
                mov.insert(con,"id_Movement");
                // Team myteam=new Team(this.getId_Team());
                // myteam=(Team)myteam.selectMe(con, "id_Team");
                // if(level != 0){
                //     int pts=myteam.getPoints() + level;
                //     Team newt=new Team(pts, 0);
                //     myteam.update(con, newt, "id_Team");
                // }
                
            //     this.withBall=false;
            // }else{
            //     throw new Exception("Vous n'avez pas de ball "); 
            // }
            test=true;
            
        } catch (Exception e) {
            //e.printStackTrace();
            // TODO: handle exception
        }finally{
            if(test == true){
                //con.getCon().close();
            } 
        }
    }

    public void getBall(Connexion con) throws Exception{
        if(con == null){
            con=new Connexion();
            }
            boolean test=false;
            
        try {
            
            // if(this.withBall=false){
                this.withBall=true;
            // }else{
            //     throw new Exception("Vous avez deja le ball "); 
            // }
            test=true;
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }finally{
            if(test == true){
                //con.getCon().close();
            } 
        }

    }



    public void rebound(Connexion con,int level,double min,int id_match) throws Exception {
        if(con == null){
            con=new Connexion();
            }
            boolean test=false;
            
        try {
            //if(this.withBall==false){
                Movement mov=new Movement(this.id_Gameur,"R",level,min,id_match);
               mov.insert(con,"id_Movement");
                this.withBall=true;
            // }else{
            //     throw new Exception("Vous avez deja le ball "); 
            // }
            test=true;
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }finally{
            if(test == true){
                //con.getCon().close();
            } 
        }

    }

    public void pass(Connexion con,int level,double min,int id_match) throws Exception{
        if(con == null){
            con=new Connexion();
            }
            boolean test=false;
            
        try {
            //if(this.withBall==true){
                Movement mov=new Movement(this.id_Gameur,"P",level,min,id_match);
               mov.insert(con,"id_Movement");
                this.withBall=false;
            // }else{
            //     throw new Exception("Vous n'avez pas de ball "); 
            // }
            test =true;
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }finally{
            if(test == true){
                //con.getCon().close();
            } 
        }

    }

    public void getpass(Connexion con,int level,double min,int id_match) throws Exception{
        if(con == null){
            con=new Connexion();
            }
            boolean test=false;
            
        try {
            //if(this.withBall==false){
                Movement mov=new Movement(this.id_Gameur,"getpass",level,min,id_match);
               mov.insert(con,"id_Movement");
                this.withBall=true;
            // }else{
            //     throw new Exception("Vous avez deja le ball "); 
            // }
            test =true;
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }finally{
            if(test == true){
                //con.getCon().close();
            } 
        }

    }

    public void pass_pass(Connexion con,Gameur g2,int id_match) throws Exception{
        if(con == null){
            con=new Connexion();
            }
            boolean test=false;
            
        try {
            //if((this.withBall==true)&&(g2.withBall==false)){
                Pass pa=new Pass(this.id_Gameur, g2.getId_Gameur(),id_match);
                pa.insert(con,"id_Pass");
                this.withBall=false;
                g2.withBall=true;
            // }else if(this.withBall==false){
            //     throw new Exception("Vous n' avez pas de ball "); 
            // }
            // else if(g2.withBall==true){
            //     throw new Exception("L'autre joueur a deja  le ball "); 
            // }   
            
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }finally{
            if(test == true){
                //con.getCon().close();
            } 
        }

    }


    public Movement[] getActions(Connexion con) throws Exception{
        if(con == null){
            con=new Connexion();
            }
            boolean test=false;
            
        try {
                Movement mov=new Movement();
                Object[] movobj=mov.select(con);
                int count=movobj.length;
                int essai=0;
                  Movement[] tabmov=new Movement[count];
                  for (int i = 0; i <count; i++) {
                        tabmov[i]=(Movement)movobj[i];
                        
                  }
                  
                  for (int j = 0; j < tabmov.length; j++) {
                      if(tabmov[j].getId_Gameur() == this.getId_Gameur()){
                        essai ++;
                      }
                  }
                  Movement[] rep=new Movement[essai];
                  int h=0;
                  for (int j= 0; j < tabmov.length; j++) {
                    if(tabmov[j].getId_Gameur() == this.getId_Gameur()){
                      rep[h]=tabmov[j];
                      h++;
                    }
                }

            test = true;
            return rep;

            
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


    public int getTentative(Connexion con,String type) throws Exception{
        if(con == null){
            con=new Connexion();
            }
            boolean test=false;
            
        try {
                int essai=0;
                Movement[] tabmov=this.getActions(con);
                for (int i = 0; i < tabmov.length; i++) {
                    if(tabmov[i].getType().compareToIgnoreCase(type) == 0){
                        essai ++;
                    }
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

    public int getTentativeOk(Connexion con,String type) throws Exception{
        if(con == null){
            con=new Connexion();
            }
            boolean test=false;
            
        try {
            int essai=0;
            Movement[] tabmov=this.getActions(con);
            for (int i = 0; i < tabmov.length; i++) {
                if(tabmov[i].getType().compareToIgnoreCase(type) == 0){
                    if(tabmov[i].getLevel() != 0){
                        essai ++;
                    }
                }
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




    public int getPoints(Connexion con,String type) throws Exception{
        if(con == null){
            con=new Connexion();
            }
            boolean test=false;
            
        try {
                int essai=0;
                Movement[] tabmov=this.getActions(con);
                for (int i = 0; i < tabmov.length; i++) {
                    if(tabmov[i].getType().compareToIgnoreCase(type) == 0){
                        essai =essai + tabmov[i].getLevel();
                    }
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




    public int getTentativeNull(Connexion con,String type) throws Exception{
        if(con == null){
            con=new Connexion();
            }
            boolean test=false;
            
        try {
                int essai=0;
                Movement[] tabmov=this.getActions(con);
                for (int i = 0; i < tabmov.length; i++) {
                    if(tabmov[i].getType().compareToIgnoreCase(type) == 0){
                        if(tabmov[i].getLevel() == 0){
                            essai ++;
                        }
                    }
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



    // public double poucentage(Connexion con){

    // }




    





}