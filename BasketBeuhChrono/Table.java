package tabs;
import java.lang.reflect.*;
import java.util.*;
import javax.naming.spi.DirStateFactory.Result;
import java.sql.*;
import java.sql.Date;
import connect.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
public class Table{

    public Table(){

    }

    public void update(Connexion con,Table ex,String primaryKey )throws Exception
    {
        if(con == null){
            con=new Connexion();
            }
        boolean test=false;
        try {
            String nom_table=this.getClass().getSimpleName();
            String nom_table2=ex.getClass().getSimpleName();
            int indice=getIndiceAtr(primaryKey, this);
            String key= String.valueOf(this.getClass().getDeclaredFields()[indice].get(this));
            key=changeMaj(key);
            // System.out.println(" efa niova " +key);
            String requette="UPDATE "+nom_table + " SET ";

            String reqplus="";
            if(nom_table.compareToIgnoreCase(nom_table2) == 0){
                for (int i = 0; i <ex.getClass().getDeclaredFields().length ; i++) {
                    String valor= String.valueOf(ex.getClass().getDeclaredFields()[i].get(ex));
                    if(valor.compareTo("0")!=0 && valor.compareTo("0.0")!=0 && valor.compareTo("null")!=0 && valor.compareTo("")!=0){
                        reqplus=reqplus + ex.getClass().getDeclaredFields()[i].getName()+"=\'"+valor+"\',";
                    }
                }
            }
            if(reqplus.length()>0){
                reqplus=reqplus.substring(0, reqplus.length()-1);
            }
            requette = requette + reqplus + " WHERE " + primaryKey + "= '" + key +"'";
            Statement stat=con.getCon().createStatement();
            stat.executeUpdate(requette);
            // con.getCon().commit();
             System.out.println(requette);
            test =true;
            
        } catch (Exception e) {
            //TODO: handle exception
            // con.getCon().rollback();
            e.printStackTrace();
        }
        finally{
            if(test==true){
                // con.getCon().close();
            }
        }
        

    }

    public void delete(Connexion con,String primaryKey)throws Exception
    {   if(con == null){
        con=new Connexion();
        }
        boolean test=false;
        try {
            String nom_table=this.getClass().getSimpleName();
            int indice=getIndiceAtr(primaryKey, this);
            String key= String.valueOf(this.getClass().getDeclaredFields()[indice].get(this));
            String requette= "DELETE FROM "+ nom_table + " WHERE " +primaryKey +" = '" + key +"'";
            Statement stat=con.getCon().createStatement();
            stat.executeUpdate(requette);
            con.getCon().commit();
            System.out.println(requette);
            test=true;
        } catch (Exception e) {
            //TODO: handle exception


            //con.getCon().rollback();
            e.printStackTrace();
        }
        finally{
            if(test==true){
                // con.getCon().close();
            }
        }
    }
    
    


    public Object[] select(Connexion con)throws Exception
    {
        if(con == null){
            con=new Connexion();
        }
        String nom_table=this.getClass().getSimpleName();
        Object[] tabObj=Set_Instance(con, nom_table, this);
        // System.out.println(tabObj[0].getClass().getName());
        return tabObj;
    }

    public void insert(Connexion con, String primaryKey)throws Exception
    {  

        if(con == null){
            con=new Connexion();
        }
        boolean test=false;
        try {
            
            String nom_table=this.getClass().getSimpleName();
            // System.out.println(nom_table);
            int limite=6;
            int id=getId(con,limite,nom_table);
            int key=getIndiceAtr(primaryKey, this);
            // System.out.println(key);
            // System.out.println(id);
            int c=this.getClass().getDeclaredFields().length;
            if(this instanceof Gameur){
                Gameur g=new Gameur();
                c=g.lenghFields();
            }

           
            try {
                this.getClass().getDeclaredFields()[key].set(this, id);
                // System.out.println("ok");
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            

            String requette= "INSERT INTO "+ nom_table + " VALUES(";
            for (int i = 0; i < c; i++) {
                String valeur=String.valueOf(this.getClass().getDeclaredFields()[i].get(this));
                if(i == key){
                    valeur=String.valueOf(id);
                }
                if(valeur.compareToIgnoreCase("null") != 0){
                    requette = requette +"\'"+valeur+"\'";
                }
                
                if(i+1<c){
                    requette=requette +",";
                }
            }
            requette=requette+")";
            Statement stat=con.getCon().createStatement();
            stat.executeUpdate(requette);
            // con.getCon().commit();
            System.out.println(requette);
            test=true;
        }  catch (Exception e) {
            //TODO: handle exception


           /// con.getCon().rollback();
            e.printStackTrace();
        }
        finally{
            if(test==true){
                // con.getCon().close();
            }
        }

    }

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------


    public int getIndiceAtr(String attribu, Object ob){
        int indice_atr=0;
        for (int j = 0; j < ob.getClass().getDeclaredFields().length ; j++) {
            if(ob.getClass().getDeclaredFields()[j].getName().compareToIgnoreCase(attribu) == 0){
                indice_atr = j;
            } 
        }
        return indice_atr;
    }


    public int countLign_Table(Connexion con, String nom_tab) throws Exception
    {
        
            int rep=0;
            if(con == null){
                con=new Connexion();
            }
            boolean test=false;
            try {
                Statement stat=con.getCon().createStatement();
                ResultSet count=stat.executeQuery("select count(*) from "+ nom_tab );
                count.next();
                rep= Integer.valueOf(count.getString(1));
                count.close();   
                
            } catch (Exception e) {
                // TODO: handle exception


                // /con.getCon().rollback();
                e.printStackTrace();  
            }
            finally{
                if(test == true){
                    // con.getCon().close();
                } 
            }  
        return rep;
    }
    
    public int countColone_Table(Connexion con,String nom_table) throws Exception
    {  
        if(con == null){
            con=new Connexion();
        }
        boolean test=false;
        int rep=0;
         try {
            Statement stat=con.getCon().createStatement();
            ResultSet res=stat.executeQuery("SELECT * FROM "+ nom_table);
            ResultSetMetaData rm= res.getMetaData();
            rep = rm.getColumnCount();
            res.close();
            test=true;
        
        } catch (Exception e) {
            // TODO: handle exception


            // con.getCon().rollback();
            e.printStackTrace();  
        }
        finally{
            if(test == true){
                // con.getCon().close();
            } 
        }

        return rep;
    }

    public String[][] getTable(Connexion con ,String nom_Table)throws Exception{
        if(con == null){
            con=new Connexion();
        }
        int lign=countLign_Table(con,nom_Table);
        int col =countColone_Table(con,nom_Table);
        String[][] rep= new String[lign][col];
        boolean test=false;
        try {
            Statement stat=con.getCon().createStatement();
            ResultSet resultat= stat.executeQuery("SELECT * FROM " + nom_Table);
            resultat.next();
                
                //System.out.println(lign );
                //System.out.println(col );
                for (int i = 0; i < lign; i++) {
                    for (int j = 1; j <= col; j++) {
                        rep[i][j-1]=resultat.getString(j);
                        // System.out.println(rep[i][j-1]);
                        
                    }
                    resultat.next();
                }
                resultat.close();
            
        }  catch (Exception e) {
            // TODO: handle exception

            // con.getCon().rollback();
            e.printStackTrace();  
        }
        finally{
            if(test == true){
                // con.getCon().close();
            } 
        }

    
            return rep;
    }

    public Object[] Set_Instance(Connexion con,String nom_table,Object objEx) throws Exception
    {   
        if(con == null){
        con=new Connexion();
        }
        String [][] resString= getTable(con,nom_table);
        Object[] table= new Object[resString.length];
        Field[] attribu= objEx.getClass().getDeclaredFields();
        int Count_attribu= attribu.length;
        // System.out.println("Table an io zany "+objEx.getClass().getName());
        for (int i = 0; i < resString.length; i++) {
            table[i] = new Object(); 
            table[i] = objEx.getClass().getDeclaredConstructor().newInstance();
            for (int j = 0; j < resString[i].length; j++) {
                if(attribu[j].getType().getSimpleName().compareTo("double") == 0){
                    double data= Double.parseDouble(resString[i][j]);
                    extracted_Double(table, i, j, data);
                }
                else if(attribu[j].getType().getSimpleName().compareTo("Date") == 0){

                    Date data= Date.valueOf(resString[i][j]);
                    // System.out.println("Misy date");
                    extracted_Date(table, i, j, data);
                } 
                else if(attribu[j].getType().getSimpleName().compareTo("int") == 0){
                    int data=0;
                    if(resString[i][j] == null){
                        data = 0;
                        extracted(table, i, j, data);
                    }else{
                        data =  Integer.parseInt(resString[i][j]);
                        extracted(table, i, j, data);
                    }
                
                } 
                else if(attribu[j].getType().getSimpleName().compareTo("String") == 0){
                    String data= resString[i][j];
                    // System.out.println("Misy string");
                    extracted_String(table, i, j, data);
                } 
                
            }
            
            
        }
        return table;

        
    }

    
    

    private void extracted(Object[] table, int i, int j, int data) throws Exception
     {
        table[i].getClass().getDeclaredFields()[j].set(table[i], data);
        // System.out.println(table[i].getClass().getDeclaredFields()[j].getName() + data);
    }
    private void extracted_String(Object[] table, int i, int j, String data) throws Exception
    {
       table[i].getClass().getDeclaredFields()[j].set(table[i], data);
    //    System.out.println(table[i].getClass().getDeclaredFields()[j].getName() + data);
   }
   private void extracted_Double(Object[] table, int i, int j, double data) throws Exception
    {
       table[i].getClass().getDeclaredFields()[j].set(table[i], data);
    //    System.out.println(table[i].getClass().getDeclaredFields()[j].getName() + data);
   }

   private void extracted_Date(Object[] table, int i, int j, Date data) throws Exception
    {
       table[i].getClass().getDeclaredFields()[j].set(table[i], data);
    //    System.out.println(table[i].getClass().getDeclaredFields()[j].getName() + data);
   }


   public String getString(int nombre,int limite){
        String strn=String.valueOf(nombre);
       
        int taille=strn.length();
        // System.out.println(taille);
        String zero="0";
        for (int i = 1; i < limite-taille; i++) {
            zero=zero + "0";
        }
        strn= zero + strn;
        return strn;
   }

public int getId(Connexion con,int limite,String nom_table)throws Exception
{
    if(con == null){
        con=new Connexion();
        }
        boolean test=false;
        int rep=0;
    try {
        //System.out.println(nom_table);
        int isa=countLign_Table(con, nom_table);
        int nombre=isa + 1;
        rep=nombre;
       //System.out.println(rep);
        test=true;
        
        
    } catch (Exception e) {
        // TODO: handle exception
    }finally{
        if(test == true){
           // con.getCon().close();
        } 
    }
    return rep;
        
}

   public String DatetoFormatDataBase(String sDate){
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    return simpleDateFormat.format(Date.valueOf(sDate)).toString();
    }
    
    public String changeMaj(String mot){
        String m=mot.substring(0,1).toUpperCase();
        String n=mot.substring(1, mot.length());
        String rep=m+n;
        return rep;
    }

   
    public Object selectMe(Connexion con, String primaryKey)throws Exception
    {
        if(con == null){
            con=new Connexion();
            }
            boolean test=false;
            Object resp=new Object();
        try {
            
            Object[] t=this.select(con);
            ///resp = t[0].getClass().getDeclaredConstructor().newInstance();
            int key=getIndiceAtr(primaryKey, this);
            for (int i = 0; i < t.length; i++) {  
                if(String.valueOf(t[i].getClass().getDeclaredFields()[key].get(t[i])).compareToIgnoreCase(String.valueOf(this.getClass().getDeclaredFields()[key].get(this))) == 0){
                    resp= t[i];
                }
            }
            test=true;
            
        } catch (Exception e) {


            // TODO: handle exception

        }finally{
            if(test == true){
                //con.getCon().close();
            } 
        }
        return resp;

    }


    String getAction(String req){
        String val="";
        String[] rep=req.split(" ");
        val=rep[0]; 
        // System.out.println(val);
        return val;
    }

    public Match[] change_toMatch(Object[] tabObj){
        Match[] res= new Match[tabObj.length];
         for (int i = 0; i < res.length; i++) {

            if(tabObj[i]instanceof Match){
                res[i]= new Match();
                res[i]=(Match)tabObj[i];
            }
           
        }
        return res;
    }

    public Gameur[] change_toGameur(Object[] tabObj){
        Gameur[] res= new Gameur[tabObj.length];
         for (int i = 0; i < res.length; i++) {

            if(tabObj[i]instanceof Gameur){
                res[i]= new Gameur();
                res[i]=(Gameur)tabObj[i];
            }
           
        }
        return res;
    }

    public Team[] change_toTeam(Object[] tabObj){
        Team[] res= new Team[tabObj.length];
         for (int i = 0; i < res.length; i++) {

            if(tabObj[i]instanceof Team){
                res[i]= new Team();
                res[i]=(Team)tabObj[i];
            }
           
        }
        return res;
    }

    public Movement[] change_toMovement(Object[] tabObj){
        Movement[] res= new Movement[tabObj.length];
         for (int i = 0; i < res.length; i++) {

            if(tabObj[i]instanceof Movement){
                res[i]= new Movement();
                res[i]=(Movement)tabObj[i];
            }
           
        }
        return res;
    }

    public Pass[] change_toPass(Object[] tabObj){
        Pass[] res= new Pass[tabObj.length];
         for (int i = 0; i < res.length; i++) {

            if(tabObj[i]instanceof Pass){
                res[i]= new Pass();
                res[i]=(Pass)tabObj[i];
            }
           
        }
        return res;
    }

    


   
}

