import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class MyFrame extends JFrame implements ActionListener, ItemListener {
    private final JTextField textField;
    private final JButton button1;
    private final JButton button2;
    private final JButton button3;
    private final Choice listaPrzewijana;
    static ArrayList<String> lista = new ArrayList<>();
    static ArrayList<Wycinek> listaWycinkow = new ArrayList<>();
    static ArrayList<Color> kolory = new ArrayList<>();
    static ArrayList<Integer> angles = new ArrayList<>();
    String cyfra, wybranyElement;
    int indeks;
    static int suma=0;
    Wykres wykres;

    public MyFrame() {
        super("Lab 4: zadanie 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(250,100);
        setSize(1000,600);
        setVisible(true);
        setLayout(null);

        add(textField = new JTextField(15));
        textField.setBounds(70,70,200,22);
        textField.addActionListener(this);

        listaPrzewijana = new Choice ();
        listaPrzewijana.setBounds(350,70,300,500);
        listaPrzewijana.setForeground(Color.BLACK);
        listaPrzewijana.setBackground(Color.WHITE);
        add(listaPrzewijana);
        listaPrzewijana.addItemListener(this);

        add(button1 = new JButton("Dodaj"));
        button1.addActionListener(this);
        button1.setBounds(740,50,200,100);
        button1.setBackground(new Color(100,100,220));
        add(button2 = new JButton("Usuń"));
        button2.addActionListener(this);
        button2.setBounds(740,200,200,100);
        button2.setBackground(new Color(100,100,220));
        add(button3 = new JButton("Edytuj"));
        button3.addActionListener(this);
        button3.setBounds(740,350,200,100);
        button3.setBackground(new Color(100,100,220));

    }
    public static void suma(){
        suma=0;
        for (Object s: lista) {
            suma+= parseInt(s.toString());
        }
    }
    public static void countArcAngle(int suma){
        angles.clear();
        for(int n=0;n<lista.size();n++){
            if(!(suma==0)){
                int angle=(int)(((float)(Integer.parseInt(lista.get(n)))/ (float)suma)*360);
                angles.add(n,angle);
            }
        }

    }
    public static void kolory(){
        int roznica = lista.size()- kolory.size();
        for(int i=0;i<roznica;i++){
            Random random = new Random();
            float red = random.nextFloat();
            float green = random.nextFloat();
            float blue = random.nextFloat();
            kolory.add(new Color(red,green,blue));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            cyfra = textField.getText();
            listaPrzewijana.add(cyfra);
            lista.add(cyfra);
            update();
            rysowanieWykresu();
        }
        if(e.getSource()==button2){
            if(listaPrzewijana.getSelectedObjects().length>0){
                listaPrzewijana.remove(wybranyElement);
                lista.remove(wybranyElement);
                update();
                rysowanieWykresu();
            }
        }
        if(e.getSource()==button3){
            cyfra = textField.getText();
            if(listaPrzewijana.getSelectedObjects().length!=0){
                listaPrzewijana.remove(wybranyElement);
                listaPrzewijana.insert(cyfra,indeks);
                lista.remove(wybranyElement);
                lista.add(indeks,cyfra);
                update();
                rysowanieWykresu();
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        wybranyElement=(String)e.getItem();
        indeks=listaPrzewijana.getSelectedIndex();
    }
    public static void update(){
        kolory();
        suma();
        countArcAngle(suma);
        listaWycinkow = new ArrayList<>();
        for (int j=0;j<angles.size();j++) {
            listaWycinkow.add(new Wycinek(angles.get(j),kolory.get(j)));
        }
    }
    public void rysowanieWykresu(){
        wykres = new Wykres();
        wykres.setBounds(100,150,400,300);
        super.add(wykres);
        wykres.repaint();
    }
}