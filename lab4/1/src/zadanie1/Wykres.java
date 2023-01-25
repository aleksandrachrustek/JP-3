import javax.swing.*;
import java.awt.*;

public class Wykres extends JPanel {
    int k0=0;
    Wykres(){
        this.setBounds(50,50,800,800);
        this.setBackground(Color.WHITE);
        setVisible(true);
    }
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D wykresKolowy = (Graphics2D)g;
        for(int m=0;m<MyFrame.listaWycinkow.size();m++){
            wykresKolowy.setPaint(MyFrame.listaWycinkow.get(m).c);
            wykresKolowy.fillArc(60,30,250,250,k0,Integer.parseInt(String.valueOf(MyFrame.angles.get(m))));
            k0+=Integer.parseInt(String.valueOf(MyFrame.angles.get(m)));
        }
    }
}
