package frame;
import javax.swing.*;
import tabs.Gameur;
import java.awt.Color;
import java.awt.event.*;
import java.io.*;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import frame.*;
import java.awt.event.*;
import java.io.*;
import java.awt.Color;
import listner.*;
public class Button extends JButton{
    Gameur joueur;
    Fenetre f;
   
    public Button(Gameur g,Fenetre f) throws Exception
    {
        try {
            
            this.joueur=g;
            this.setText(joueur.getNom());
            if(f.getIs_Paused() == false){
                this.addMouseListener(new ListenButton(f,g));
            }else{
                throw new Exception("Game paused"); 
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: handle exception
        }
        
        
        // this.requestFocus();
        // this.setFocusable(true);

    }

    public Gameur getJoueur() {
        return joueur;
    }

    public void setJoueur(Gameur joueur) {
        this.joueur = joueur;
    }

    public Fenetre getF() {
        return f;
    }

    public void setF(Fenetre f) {
        this.f = f;
    }

}
