package listner;
import javax.swing.*;
import frame.Fenetre;
import tabs.Gameur;
import java.awt.Color;
import java.awt.event.*;
import java.io.*;
import java.util.Date;
public class ListenButton implements MouseListener{
    Fenetre f;
    Gameur g;



    public ListenButton(Fenetre f, Gameur g) {
        this.f = f;
        this.g = g;
    }
    public void mouseClicked(MouseEvent e){ 
        try {
            if(f.getIs_Paused() == false){
                f.setActif(g);
                //g.setWithBall(true);
                //.getActif().setWithBall(true);
                //System.out.println(g.getNom()+"actif");
                f.requestFocus();
            }else{
                throw new Exception("Jeu en pause");
            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            // TODO: handle exception
        }
       
        
    }
    public void mouseEntered(MouseEvent e){ }
    public void	mouseExited(MouseEvent e){ }
    public void	mousePressed(MouseEvent e){
        
    }
    public void	mouseReleased(MouseEvent e){ }
    public Fenetre getF() {
        return f;
    }
    public void setF(Fenetre f) {
        this.f = f;
    }


    

}
