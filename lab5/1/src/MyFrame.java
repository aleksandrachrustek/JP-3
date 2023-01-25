import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

public class MyFrame extends JFrame implements DocumentListener, ActionListener {
    int A,B,C,D,E,F,G,H,I,J,K,L;
    static String t = "";
    String znakOperacji;
    int wynik;
    boolean czyWcisniety = false;
    boolean m = true;
    JTextArea area1, area2, area3, area4, area5, area6, area7, area8, area9, area10, r, znak;
    JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11;
    JScrollPane scrollpane;
    JButton button;

    MyFrame(){
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setTitle("lab 5: zadanie 1");
        super.setSize(new Dimension(600,600));
        super.setLayout(null);
        super.setLocationRelativeTo(null);

        add(area1 = new JTextArea());
        area1.setBounds(150,40,80,30);
        area1.getDocument().addDocumentListener(this);
        add(label1 = new JLabel("a1"));
        label1.setBounds(185,10,80,30);
        add(area2 = new JTextArea());
        area2.setBounds(250,40,80,30);
        area2.getDocument().addDocumentListener(this);
        add(label2 = new JLabel("a2"));
        label2.setBounds(285,10,80,30);
        add(area3 = new JTextArea());
        area3.setBounds(350,40,80,30);
        area3.getDocument().addDocumentListener(this);
        add(label3 = new JLabel("a3"));
        label3.setBounds(385,10,80,30);
        add(area4 = new JTextArea());
        area4.setBounds(150,100,80,30);
        area4.getDocument().addDocumentListener(this);
        add(label4 = new JLabel("b1"));
        label4.setBounds(185,70,80,30);
        add(area5 = new JTextArea());
        area5.setBounds(250,100,80,30);
        area5.getDocument().addDocumentListener(this);
        add(label5 = new JLabel("b2"));
        label5.setBounds(285,70,80,30);
        add(area6 = new JTextArea());
        area6.setBounds(350,100,80,30);
        area6.getDocument().addDocumentListener(this);
        add(label6 = new JLabel("b3"));
        label6.setBounds(385,70,80,30);
        add(area7 = new JTextArea());
        area7.setBounds(100,490,80,30);
        area7.setEditable(false);
        add(label7 = new JLabel("c0"));
        label7.setBounds(135,460,80,30);
        add(area8 = new JTextArea());
        area8.setBounds(200,490,80,30);
        area8.setEditable(false);
        add(label8 = new JLabel("c1"));
        label8.setBounds(235,460,80,30);
        add(area9 = new JTextArea());
        area9.setBounds(300,490,80,30);
        area9.setEditable(false);
        add(label9 = new JLabel("c2"));
        label9.setBounds(340,460,80,30);
        add(area10 = new JTextArea());
        area10.setBounds(400,490,80,30);
        area10.setEditable(false);
        add(label10 = new JLabel("c3"));
        label10.setBounds(435,460,80,30);
        add(znak = new JTextArea());
        znak.setBounds(320,150,85,35);
        znak.getDocument().addDocumentListener(this);
        add(label11 = new JLabel("Symbol operacji (+,-,*)"));
        label11.setBounds(170,157,160,30);
        add(scrollpane = new JScrollPane(r = new JTextArea()));
        r.setEditable(false);
        scrollpane.setBounds(150,260,270,200);
        add(button = new JButton("Rozwiąż"));
        button.setBounds(215,200,145,35);
        button.setBackground(Color.orange);
        super.setVisible(true);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            jesliPuste();
            t = "";
            czyWcisniety = true;
            aktualizuj();
        }
    }

    public void aktualizuj(){
        jesliPuste();
        try{
            C=Integer.parseInt(area1.getText());
            D=Integer.parseInt(area2.getText());
            E=Integer.parseInt(area3.getText());
            F=Integer.parseInt(area4.getText());
            G=Integer.parseInt(area5.getText());
            H=Integer.parseInt(area6.getText());
            A=(C*100)+(D*10)+E;
            B=(F*100)+(G*10)+H;
            znakOperacji = znak.getText();
            I=0;
            J=0;
            K=0;
            L=0;
            t+="\nA1="+C+"   A2="+D+"   A3="+E+"\nA="+A;
            t+="\nB1="+F+"   B2="+G+"   B3="+H+"\nB="+B;

            if(znak.getText().equals("+")) {
                wynik = Integer.parseInt(""+A+B);
                m = true;
            }else if (znak.getText().equals("-")) {
                wynik = Integer.parseInt(""+(A-B));
                m = true;
            }else if (znak.getText().equals("*")) {
                wynik = Integer.parseInt(""+(A*B));
                m = true;
            }else {
                wynik = 0;
                m = false;}
            if(m){
                I=wynik/1000;
                J=(wynik-(I*1000))/100;
                K=(wynik-(I*1000)-(J*100))/10;
                L=wynik-(I*1000)-(J*100)-(K*10);
                area7.setText(""+I);
                area8.setText(""+J);
                area9.setText(""+K);
                area10.setText(""+L);
                if(!znak.getText().equals("")){
                    t+="\n";
                    t+="\nC1="+I+"   C2="+J+"   C3="+K+"   C4="+L+"\nC="+wynik;
                    t+="\n";
                    t+="\nA"+znakOperacji+"B=C";
                    t+="\n"+A+znakOperacji+B+"="+wynik;
                }
            } else{t="Wprowadzony znak jest niepoprawny";}
            r.setText(t);
        } catch(NumberFormatException x){r.setText("Dane nie spełniają warunków liczb Integer");}
    }

    public void jesliPuste(){
        if (area3.getText().equals("")){
            area3.setText("0");
            C=0;}
        if (area4.getText().equals("")){
            area4.setText("0");
            D=0;}
        if (area5.getText().equals("")){
            area5.setText("0");
            E=0;}
        if (area6.getText().equals("")){
            area6.setText("0");
            F=0;}
        if (area7.getText().equals("")){
            area7.setText("0");
            G=0;}
        if (area8.getText().equals("")){
            area8.setText("0");
            H=0;}
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        t="";
        try { if(czyWcisniety){aktualizuj();}
        } catch(Exception x) {x.printStackTrace();}
    }
    @Override
    public void changedUpdate(DocumentEvent e) {
        t="";
        try {if(czyWcisniety){aktualizuj();}
        } catch(Exception x) {x.printStackTrace();}
    }
    @Override
    public void removeUpdate(DocumentEvent e) {
        t="";
        try {if(czyWcisniety){aktualizuj();}
        } catch(Exception x) {x.printStackTrace();}
    }
}
