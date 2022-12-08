package frame;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.io.*;
import connect.*;
import tabs.*;
import listner.*;
public class Fenetre extends JFrame{

    String pp="Pause";
    Match matchs;
    Gameur actif;
    boolean is_Paused =false;
    public Fenetre(Match m) throws Exception {
        this.matchs=m;
        //this.is_Paused=;
        
        //this.actif.setWithBall(true);
        Connexion con=new Connexion();
        Team equipe1=new Team(matchs.getId_Team1());
        equipe1=(Team)equipe1.selectMe(con, "id_Team");
       
        Team equipe2=new Team(matchs.getId_Team2());
        equipe2=(Team)equipe2.selectMe(con,"id_Team");
        System.out.println( equipe1.getNom_Team()+"  VS  " +equipe2.getNom_Team());
        JButton pause=new JButton("Pause/Play");

        JLabel lpp=new JLabel(this.getPp());
        pause.addMouseListener(new Pause(this));
        lpp.setBounds(650, 10, 100, 100);
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        JLabel  lbl1=new JLabel("TEAM :" + equipe1.getNom_Team());
        //JLabel score1=new JLabel("Score  : " + equipe1.getPoints());
        JLabel  lbl2=new JLabel("TEAM :" + equipe2.getNom_Team());
        //JLabel score2=new JLabel("Score  : " + equipe2.getPoints());
        lbl1.setBounds(150, 60, 100, 100);
        //score1.setBounds(100, 100, 100, 60);
        //this.setLayout(null);
        lbl2.setBounds(800, 100, 100, 100);
        //score2.setBounds(800, 120, 100, 60);
        jp1.add(lbl1);
        //jp1.add(score1);
        
        //jp1.setBackground(Color.blue);

        jp2.add(lbl2);
        //jp2.add(score2);
        //jp2.setBackground(Color.GREEN);
       
        Gameur[] gam1=equipe1.getMyGameurs(con);
        Gameur[] gam2=equipe2.getMyGameurs(con);
        Button[] boot1=new Button[5];
        Button[] boot2=new Button[5];
        int x=50;
        for (int i = 0; i < boot1.length; i++) {
            boot1[i]=new Button(gam1[i],this);
            boot1[i].setBounds(x, 150, 80, 35);
            if(this.getIs_Paused()==false){
                boot1[i].addKeyListener(new ListenGameur(gam1[i],this));
            }
           
            jp1.add(boot1[i]);
            x = x +80;
        }
        int x2=400;
        for (int j = 0; j < boot2.length; j++) {
            boot2[j]=new Button(gam2[j],this);
            boot2[j].setBounds(x2 + 300, 200, 80, 35);
            if(this.getIs_Paused()==false){
                boot2[j].addKeyListener(new ListenGameur(gam2[j],this));
            }
            jp2.add(boot2[j]);
            x2 = x2+80;
        }
        pause.setBounds(550, 10, 150, 100);
        jp1.setBounds(50, 50, 450, 400);
        jp1.setLayout(null);
        jp2.setBounds(450, 50, 450, 400);
        jp2.setLayout(null);
        this.add(pause);
        this.add(lpp);
        this.add(jp1);
        this.add(jp2);

        this.requestFocus();
        this.setVisible(true);
    }
        
   
    


    
    public boolean getIs_Paused() {
        return is_Paused;
    }
    public void setIs_Paused(boolean is_Paused) {
        this.is_Paused = is_Paused;
    }
    public Match getMatchs() {
        return matchs;
    }
    public void setMatchs(Match matchs) {
        this.matchs = matchs;
    }
    public Gameur getActif() {
        return actif;
    }
    public void setActif(Gameur actif) {
        this.actif = actif;
        //actif.setWithBall(true);
        System.out.println( actif.getNom() + "  a le ballon");
    }

    public String getPp() {
        if(is_Paused == true){
            return "Play";
        }
        if(is_Paused == false){
            return "Pause";
        }
        return null;
    }

    public void setPp(String pp) {
        this.pp = pp;
    }
    

}