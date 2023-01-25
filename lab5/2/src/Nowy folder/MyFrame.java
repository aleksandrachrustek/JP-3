import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MyFrame extends JFrame implements MouseListener {
    JTextArea t;
    JButton abc,def,ghi,jkl,mno,pqr,stuv,wxyz,C,CE,DM,dzielenie,dodawanie,odejmowanie,znakRownosci;
    JScrollPane scrollpane;
    public static String text="";
    public boolean czyDuzaLitera=false;
    ArrayList<JButton> buttons = new ArrayList<>();
    String czesc1,czesc2, wynik, znak, calytekst;

    MyFrame(){
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setTitle("Lab 5: zadanie 2");
        super.setSize(new Dimension(500,650));
        super.setLocationRelativeTo(null);
        super.setLayout(null);
        super.setVisible(true);

        t = new JTextArea();
        t.setFont(new Font("Helvetica", Font.PLAIN, 13));
        t.setEditable(false);
        add(scrollpane = new JScrollPane(t));
        scrollpane.setBounds(57,40,370,100);
        scrollpane.setForeground(new Color(150,190,250));

        add(DM = new JButton("D/M"));
        DM.setBounds(80,170,100,70);
        DM.setBackground(new Color(240,150,120));
        DM.setFont(new Font("Helvetica", Font.BOLD, 15));
        DM.addMouseListener(this);
        add(CE = new JButton("CE"));
        CE.setBounds(190,170,100,70);
        CE.setBackground(new Color(240,150,120));
        CE.setFont(new Font("Helvetica", Font.BOLD, 15));
        CE.addMouseListener(this);
        add(C = new JButton("C"));
        C.setBounds(300,170,100,70);
        C.setBackground(new Color(240,150,120));
        C.setFont(new Font("Helvetica", Font.BOLD, 15));
        C.addMouseListener(this);
        add(abc = new JButton("abc"));
        abc.setBounds(80,250,100,70);
        abc.setBackground(new Color(150,180,250));
        abc.setFont(new Font("Helvetica", Font.PLAIN, 15));
        abc.addMouseListener(this);
        add(def = new JButton("def"));
        def.setBounds(190,250,100,70);
        def.setBackground(new Color(150,180,250));
        def.setFont(new Font("Helvetica", Font.PLAIN, 15));
        def.addMouseListener(this);
        add(ghi = new JButton("ghi"));
        ghi.setBounds(300,250,100,70);
        ghi.setBackground(new Color(150,180,250));
        ghi.setFont(new Font("Helvetica", Font.PLAIN, 15));
        ghi.addMouseListener(this);
        add(jkl = new JButton("jkl"));
        jkl.setBounds(80,330,100,70);
        jkl.setBackground(new Color(150,180,250));
        jkl.setFont(new Font("Helvetica", Font.PLAIN, 15));
        jkl.addMouseListener(this);
        add(mno = new JButton("mno"));
        mno.setBounds(190,330,100,70);
        mno.setBackground(new Color(150,180,250));
        mno.setFont(new Font("Helvetica", Font.PLAIN, 15));
        mno.addMouseListener(this);
        //mno.addActionListener(this);
        add(pqr = new JButton("pqr"));
        pqr.setBounds(300,330,100,70);
        pqr.setBackground(new Color(150,180,250));
        pqr.setFont(new Font("Helvetica", Font.PLAIN, 15));
        pqr.addMouseListener(this);
        add(stuv = new JButton("stuv"));
        stuv.setBounds(80,410,100,70);
        stuv.setBackground(new Color(150,180,250));
        stuv.setFont(new Font("Helvetica", Font.PLAIN, 15));
        stuv.addMouseListener(this);
        add(wxyz = new JButton("wxyz"));
        wxyz.setBounds(190,410,100,70);
        wxyz.setBackground(new Color(150,180,250));
        wxyz.setFont(new Font("Helvetica", Font.PLAIN, 15));
        wxyz.addMouseListener(this);
        add(znakRownosci = new JButton("="));
        znakRownosci.setBounds(300,410,100,70);
        znakRownosci.setBackground(new Color(120,250,150));
        znakRownosci.setFont(new Font("Helvetica", Font.BOLD, 16));
        znakRownosci.addMouseListener(this);
        add(dodawanie = new JButton("+"));
        dodawanie.setBounds(80,490,100,70);
        dodawanie.setBackground(new Color(120,250,150));
        dodawanie.setFont(new Font("Helvetica", Font.BOLD, 16));
        dodawanie.addMouseListener(this);
        add(odejmowanie = new JButton("-"));
        odejmowanie.setBounds(190,490,100,70);
        odejmowanie.setBackground(new Color(120,250,150));
        odejmowanie.setFont(new Font("Helvetica", Font.BOLD, 16));
        odejmowanie.addMouseListener(this);
        add(dzielenie = new JButton("/"));
        dzielenie.setBounds(300,490,100,70);
        dzielenie.setBackground(new Color(120,250,150));
        dzielenie.setFont(new Font("Helvetica", Font.BOLD, 16));
        dzielenie.addMouseListener(this);
        buttons.add(abc);
        buttons.add(def);
        buttons.add(ghi);
        buttons.add(jkl);
        buttons.add(mno);
        buttons.add(pqr);
        buttons.add(stuv);
        buttons.add(wxyz);
        buttons.add(dodawanie);
        buttons.add(odejmowanie);
        buttons.add(dzielenie);
        buttons.add(znakRownosci);
        buttons.add(DM);
        buttons.add(CE);
        buttons.add(C);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object src = e.getSource();
        int i = 0;
        for (int n = 0; n < buttons.size(); n++) {
            if (src == buttons.get(n)) {
                i = n;
            }
        }
        if (i == 0) {
            if (e.getClickCount() == 1 && czyDuzaLitera) text += "A";
            else if (e.getClickCount() == 1 && !czyDuzaLitera) text += "a";

        }
        if (i == 0) {
            if (e.getClickCount() % 3 == 2 && czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "B";
            } else if (e.getClickCount() % 3 == 2 && !czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "b";
            }
        }
        if (i == 0) {
            if (e.getClickCount() % 3 == 0 && czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "C";
            } else if (e.getClickCount() % 3 == 0 && !czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "c";
            }
        }
        if (i == 0) {
            if (e.getClickCount() % 3 == 1 && czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "A";
            } else if (e.getClickCount() % 3 == 1 && !czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "a";
            }
        }
        if (i == 1) {
            if (e.getClickCount() == 1 && czyDuzaLitera) text += "D";
            else if (e.getClickCount() == 1 && !czyDuzaLitera) text += "d";

        }
        if (i == 1) {
            if (e.getClickCount() % 3 == 2 && czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "E";
            } else if (e.getClickCount() % 3 == 2 && !czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "e";
            }
        }
        if (i == 1) {
            if (e.getClickCount() % 3 == 0 && czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "F";
            } else if (e.getClickCount() % 3 == 0 && !czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "f";
            }
        }
        if (i == 1) {
            if (e.getClickCount() % 3 == 1 && czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "D";
            } else if (e.getClickCount() % 3 == 1 && !czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "D";
            }
        }
        if (i == 2) {
            if (e.getClickCount() == 1 && czyDuzaLitera) text += "G";
            else if (e.getClickCount() == 1 && !czyDuzaLitera) text += "g";
        }
        if (i == 2) {
            if (e.getClickCount() % 3 == 2 && czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "H";
            } else if (e.getClickCount() % 3 == 2 && !czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "h";
            }
        }
        if (i == 2) {
            if (e.getClickCount() % 3 == 0 && czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "I";
            } else if (e.getClickCount() % 3 == 0 && !czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "i";
            }
        }
        if (i == 2) {
            if (e.getClickCount() % 3 == 1 && czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "G";
            } else if (e.getClickCount() % 3 == 1 && !czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "g";
            }
        }
        if (i == 3) {
            if (e.getClickCount() == 1 && czyDuzaLitera) text += "J";
            else if (e.getClickCount() == 1 && !czyDuzaLitera) text += "j";
        }
        if (i == 3) {
            if (e.getClickCount() % 3 == 2 && czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "K";
            } else if (e.getClickCount() % 3 == 2 && !czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "k";
            }
        }
        if (i == 3) {
            if (e.getClickCount() % 3 == 0 && czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "L";
            } else if (e.getClickCount() % 3 == 0 && !czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "l";
            }
        }
        if (i == 3) {
            if (e.getClickCount() % 3 == 1 && czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "J";
            } else if (e.getClickCount() % 3 == 1 && !czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "j";
            }
        }
        if (i == 4) {
            if (e.getClickCount() == 1 && czyDuzaLitera) text += "M";
            else if (e.getClickCount() == 1 && !czyDuzaLitera) text += "m";
        }
        if (i == 4) {
            if (e.getClickCount() % 3 == 2 && czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "N";
            } else if (e.getClickCount() % 3 == 2 && !czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "n";
            }
        }
        if (i == 4) {
            if (e.getClickCount() % 3 == 0 && czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "O";
            } else if (e.getClickCount() % 3 == 0 && !czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "o";
            }
        }
        if (i == 4) {
            if (e.getClickCount() % 3 == 1 && czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "M";
            } else if (e.getClickCount() % 3 == 1 && !czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "m";
            }
        }
        if (i == 5) {
            if (e.getClickCount() == 1 && czyDuzaLitera) text += "P";
            else if (e.getClickCount() == 1 && !czyDuzaLitera) text += "p";
        }
        if (i == 5) {
            if (e.getClickCount() % 3 == 2 && czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "Q";
            } else if (e.getClickCount() % 3 == 2 && !czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "q";
            }
        }
        if (i == 5) {
            if (e.getClickCount() % 3 == 0 && czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "R";
            } else if (e.getClickCount() % 3 == 0 && !czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "r";
            }
        }
        if (i == 5) {
            if (e.getClickCount() % 3 == 1 && czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "P";
            } else if (e.getClickCount() % 3 == 1 && !czyDuzaLitera) {
                text = text.substring(0, text.length() - 1);
                text += "p";
            }
        }
        if(i==6){
            if(e.getClickCount()==1 && czyDuzaLitera) text+="S";
            else if(e.getClickCount()==1 && !czyDuzaLitera) text+="s";
        }
        if(i==6){
            if(e.getClickCount()%4==2 && czyDuzaLitera) {
                text = text.substring(0,text.length()-1);
                text+="T";
            }
            else if(e.getClickCount()%4==2 && !czyDuzaLitera) {
                text = text.substring(0,text.length()-1);
                text+="t";
            }
        }
        if(i==6){
            if(e.getClickCount()%4==3 && czyDuzaLitera) {
                text = text.substring(0,text.length()-1);
                text+="U";
            }
            else if(e.getClickCount()%4==3 && !czyDuzaLitera){
                text = text.substring(0,text.length()-1);
                text+="u";
            }
        }
        if(i==6){
            if(e.getClickCount()%4==0 && czyDuzaLitera) {
                text = text.substring(0,text.length()-1);
                text+="V";
            }
            else if(e.getClickCount()%4==0 && !czyDuzaLitera) {
                text = text.substring(0,text.length()-1);
                text+="v";
            }
        }
        if(i==6){
            if(e.getClickCount()%4==1 && czyDuzaLitera) {
                text = text.substring(0,text.length()-1);
                text+="S";
            }
            else if(e.getClickCount()%4==1 && !czyDuzaLitera) {
                text = text.substring(0,text.length()-1);
                text+="s";
            }
        }
        if(i==7){
            if(e.getClickCount()==1 && czyDuzaLitera) text+="W";
            else if(e.getClickCount()==1 && !czyDuzaLitera) text+="w";
        }
        if(i==7){
            if(e.getClickCount()%4==2 && czyDuzaLitera) {
                text = text.substring(0,text.length()-1);
                text+="X";
            }
            else if(e.getClickCount()%4==2 && !czyDuzaLitera) {
                text = text.substring(0,text.length()-1);
                text+="x";
            }
        }
        if(i==7){
            if(e.getClickCount()%4==3 && czyDuzaLitera) {
                text = text.substring(0,text.length()-1);
                text+="Y";
            }
            else if(e.getClickCount()%4==3 && !czyDuzaLitera){
                text = text.substring(0,text.length()-1);
                text+="y";
            }
        }
        if(i==7){
            if(e.getClickCount()%4==0 && czyDuzaLitera) {
                text = text.substring(0,text.length()-1);
                text+="Z";
            }
            else if(e.getClickCount()%4==0 && !czyDuzaLitera) {
                text = text.substring(0,text.length()-1);
                text+="z";
            }
        }
        if(i==7){
            if(e.getClickCount()%4==1 && czyDuzaLitera) {
                text = text.substring(0,text.length()-1);
                text+="W";
            }
            else if(e.getClickCount()%4==1 && !czyDuzaLitera) {
                text = text.substring(0,text.length()-1);
                text+="w";
            }
        }
        if(i==12) {czyDuzaLitera=!czyDuzaLitera;}
        if(i==13) {
            if(text.length()>0) {
                    text=text.substring(0,text.length()-1);
                    t.setText(calytekst+text);
            }else text="";
        }
        if(i==14){
            text="";
            calytekst="";
            znak="";
            t.setText(calytekst+text);
        }
        if(i==8){
            czesc1=text;
            znak="+";
            calytekst=calytekst+czesc1+znak;
            text="";
            t.setText(calytekst);

        }
        if(i==9){
            czesc1=text;
            znak="-";
            calytekst=calytekst+czesc1+znak;
            text="";
            t.setText(calytekst);
        }
        if(i==10){
            czesc1=text;
            znak="/";
            calytekst=calytekst+czesc1+znak;
            text="";
            t.setText(calytekst);
        }
        if(i==11){
            czesc2=text;
            if(znak.equals("+")){
                wynik=czesc1+czesc2;
            } else if(znak.equals("-")){
                wynik=odejmowanieStringow(czesc1,czesc2);
            } else if (znak.equals("/")){
                wynik=dzielenieStringow(czesc1,czesc2);
                if(wynik.isEmpty()) System.out.println("nie ma czesci wspolnej");
            }
            calytekst=calytekst+czesc2+"="+wynik;
            t.setText(calytekst);
            czesc1="";
            czesc2="";
            text="";
        }t.setText(calytekst+text);
    }

    String odejmowanieStringow(String s1, String s2){ return s1.replace(s2,"");}
    String dzielenieStringow(String s1, String s2){

        String wspolne="";
        int a=0;
        for(int j=0;j<s1.length();j++) {
            for (int k = j + 1; k <= s1.length(); k++) {
                String odjety = s1.substring(j, k);

                if (odjety.length() > a && s2.contains(odjety)) {
                    a = odjety.length();
                    wspolne = odjety;
                }
            }
        }return wspolne;
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}

