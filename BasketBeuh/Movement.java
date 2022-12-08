package tabs;
import connect.Connexion;
public class Movement extends Table{
   
    int id_Movement ;
    int id_Gameur ;
    String type ;
    int level ;
    double temps; 
    int id_Match;
    

    public Movement(int id_Gameur, String type, int level, double temps, int id_Match) {
        this.id_Gameur = id_Gameur;
        this.type = type;
        this.level = level;
        this.temps = temps;
        this.id_Match = id_Match;
    }
    
    public Movement(){
        
    }
    public Movement(int level,int ok) {
        this.level = level;
    }

    public Movement(int id_Movement) {
        this.id_Movement = id_Movement;
    }
   
    public int getId_Movement() {
        return id_Movement;
    }
    public void setId_Movement(int id_Movement) {
        this.id_Movement = id_Movement;
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


    public double getTemps() {
        return temps;
    }


    public void setTemps(double temps) {
        this.temps = temps;
    }

    public Movement dernier_Pass(Connexion con)throws Exception
    {
        if(con == null){
            con=new Connexion();
            }
            boolean test=false;
            
        try {
            Object[] movobj=this.select(con);
            int count=movobj.length;
            Movement[] tabmov=new Movement[count];
            for (int i = 0; i <count; i++) {
                  tabmov[i]=(Movement)movobj[i];
            }
            int id=0;
            for (int i = 0; i < tabmov.length; i++) {
                if(tabmov[i].getType().compareToIgnoreCase("P") == 0){
                    id=i;
                }
            }
            Movement dp=new Movement();
            dp=tabmov[id];
            test =true;
            return dp;
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
}