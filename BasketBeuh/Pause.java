package frame;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.io.*;
import java.util.Date;
public class Pause implements MouseListener{
    Fenetre f;
    public Pause(Fenetre f) {
        this.f = f;
    }
    public void mouseClicked(MouseEvent e){ }
    public void mouseEntered(MouseEvent e){ }
    public void	mouseExited(MouseEvent e){ }
    public void	mousePressed(MouseEvent e){
        if( f.getIs_Paused() == false){
            f.setIs_Paused(true);
            f.setPp("Play");
            System.out.println("Pausee" + f.getIs_Paused());
        }
        else if(f.getIs_Paused() == true){
            f.setIs_Paused(false);
            f.setPp("Pause");
            System.out.println("Pausee" + f.getIs_Paused());
        }
       
    }
    public void	mouseReleased(MouseEvent e){ }
    public Fenetre getF() {
        return f;
    }
    public void setF(Fenetre f) {
        this.f = f;
    }


    

}
