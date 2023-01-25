import javax.swing.*;
import java.awt.*;

public class Wykres extends JPanel {
    Wykres(){
        this.setBounds(400,60,450,450);
        this.setBackground(Color.WHITE);
        setVisible(true);
        MyFrame.update();
    }
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D wykresSlupkowy = (Graphics2D)g;
        int x=55;
        for(int m=0;m<MyFrame.listaSlupkow.size();m++){
            wykresSlupkowy.setColor(MyFrame.listaSlupkow.get(m).color);
            wykresSlupkowy.fillRect(x,400-MyFrame.wysokosciSlupkow.get(m),20,MyFrame.wysokosciSlupkow.get(m));
            wykresSlupkowy.drawString(String.valueOf(m+1),x+10,420);
            x+=30;
        }
        wykresSlupkowy.setColor(Color.BLACK);
        wykresSlupkowy.drawLine(45,400,445,400);
        wykresSlupkowy.drawLine(45,400,45,60);
    }
}
