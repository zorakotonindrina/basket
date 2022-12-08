package listner;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import connect.Connexion;
import frame.Fenetre;
import java.awt.event.*;
import tabs.*;
public class ListenGameur implements  KeyListener{
      public ListenGameur(Gameur go, Fenetre f) {
            this.go = go;
            this.f = f;
      }
      Gameur go;
      Fenetre f;
      String envoye;
    public ListenGameur(Gameur g) {
            this.go = g;
      }     
      public void keyReleased(KeyEvent e) {}
      public void keyTyped(KeyEvent e) {}
      public void keyPressed(KeyEvent e) 
      {

           // Gameur go=f.getActif();
           try {
            //System.out.println(e.getKeyCode()+"  "+go.getNom());
            Movement mov=new Movement();
            int id1=f.getMatchs().getId_Team1();
            int id2=f.getMatchs().getId_Team2();
            int idAdva=0;
            if(go.getId_Team()==id1){
                  idAdva=id2;
            }else{
                  idAdva=id1;
            }

            Connexion con=new Connexion();
            Team adva=new Team(idAdva);
            adva=(Team)adva.selectMe(con,"id_Team");
            Gameur[] gam=adva.getMyGameurs(con);
            Gameur gc=gam[0];

            
            
                  if((go != null)&&(f.getIs_Paused() == false)){
                        
                        Object[] movobj=mov.select(con);
                        int count=movobj.length;
                        Movement[] tabmov=new Movement[count];
                        for (int i = 0; i <count; i++) {
                              tabmov[i]=(Movement)movobj[i];
                        }

                        Movement dp=new Movement();
                        dp=dp.dernier_Pass(con);




                        if (e.getKeyCode() == 48)// tira tsy maty 
                        {    
                              go.shoot(con, 0, 1,f.getMatchs().getId_Match());
                              System.out.println(go.getNom() +"  Tira tsy maty");
                        } 
                        else if (e.getKeyCode() == 49)// tira lancer
                        {
                              String dernier=tabmov[count-1].getType();
                              Gameur g2=new Gameur(tabmov[count-1].getId_Gameur());
                              g2=(Gameur)g2.selectMe(con, "id_Gameur");
                              if(dernier.compareToIgnoreCase("P") == 0){
                                    if((go.getId_Gameur() != g2.getId_Gameur()) &&(go.getId_Team() == g2.getId_Team())){
                                          Movement pd=new Movement(1,0);
                                          dp.update(con,pd,"id_Movement");
                                          System.out.println("  Pass descicive");
                                    }
                              }
                              go.shoot(con, 1, 1,f.getMatchs().getId_Match());
                              System.out.println(go.getNom() +"  Tira lancer");
                              
                             
                              gc.getBall(con);
                              f.setActif(gc);
                              this.setGo(gc);


                        }
                        else if (e.getKeyCode() == 50)// <tira 2 pts
                        {

                              String dernier=tabmov[count-1].getType();
                              Gameur g2=new Gameur(tabmov[count-1].getId_Gameur());
                              g2=(Gameur)g2.selectMe(con, "id_Gameur");
                              if(dernier.compareToIgnoreCase("P") == 0){
                                    if((go.getId_Gameur() != g2.getId_Gameur()) &&(go.getId_Team() == g2.getId_Team())){
                                          Movement pd=new Movement(1,0);
                                          dp.update(con,pd,"id_Movement");
                                          System.out.println("  Pass descicive");
                                    }
                              }
                              go.shoot(con, 2, 1,f.getMatchs().getId_Match());
                              System.out.println(go.getNom() +"  Tira 2 pts");
                              
                              
                              
                              gc.getBall(con);
                              f.setActif(gc);
                              this.setGo(gc);
                        }
                        else if (e.getKeyCode() == 51)// <
                        {
                              String dernier=tabmov[count-1].getType();
                              Gameur g2=new Gameur(tabmov[count-1].getId_Gameur());
                              g2=(Gameur)g2.selectMe(con, "id_Gameur");
                              if(dernier.compareToIgnoreCase("P") == 0){
                                    if((go.getId_Gameur() != g2.getId_Gameur()) &&(go.getId_Team() == g2.getId_Team())){
                                          Movement pd=new Movement(1,0);
                                          dp.update(con,pd,"id_Movement");
                                          System.out.println("  Pass descicive");
                                    }
                              }
                              go.shoot(con, 3, 1,f.getMatchs().getId_Match());
                              System.out.println(go.getNom() +"  Tira 3 pts");
                              
                              
                              gc.getBall(con);
                              f.setActif(gc);
                              this.setGo(gc);
                              
                        }
                        else if (e.getKeyCode() == 66)// >
                        {
                              String dernier=tabmov[count-1].getType();
                              int lvl=tabmov[count-1].getLevel();
                              Gameur g2=new Gameur(tabmov[count-1].getId_Gameur());
                              g2=(Gameur)g2.selectMe(con, "id_Gameur");
                              if(dernier.compareToIgnoreCase("T") == 0){
                                    if((lvl == 0)&&(go.getId_Team()==g2.getId_Team())){
                                          go.rebound(con, 0, 1,f.getMatchs().getId_Match() );
                                          System.out.println(go.getNom() +"  Rebonds Offen meme equipe");
                                          //go.setWithBall(true);
                                    }
                                    if((lvl == 0)&&(go.getId_Team()!=g2.getId_Team())){
                                          go.rebound(con, 1, 1,f.getMatchs().getId_Match() );
                                          System.out.println(go.getNom() +"  Rebonds Defff pas meme equipe");
                                          //go.setWithBall(true);
                                    }

                              }
                              if(dernier.compareToIgnoreCase("P") == 0){
                                    if(go.getId_Gameur() != g2.getId_Gameur()){
                                          g2.pass_pass(con, go, 1);
                                          System.out.println(go.getNom() +"  Naazo pass");
                                    }
                              }
                        } 
                        if (e.getKeyCode() == 80)
                        {

                                    go.pass(con, 0, 1,f.getMatchs().getId_Match());
                                    System.out.println(go.getNom() +"  pass");
                                    //go.setWithBall(false);
                             // }
                              
                        }

                  }else{
                        throw new Exception("Jeu encore en pause");
                  }
             
           } catch (Exception ex) {
                  System.out.println(ex.getMessage());
                  //ex.printStackTrace();
            // TODO: handle exception
           }
           
      }
      public Gameur getGo() {
            return go;
      }
      public void setGo(Gameur go) {
            this.go = go;
      }
      public String getEnvoye() {
            return envoye;
      }
      public void setEnvoye(String envoye) {
            this.envoye = envoye;
      }
      public Fenetre getF() {
            return f;
      }
      public void setF(Fenetre f) {
            this.f = f;
      }

}