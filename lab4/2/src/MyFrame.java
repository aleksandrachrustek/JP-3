import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Random;

public class MyFrame extends JFrame implements ItemListener{
    private final ArrayList<JTextField> textFields;
    private final ArrayList<Checkbox> checkboxes;
    static ArrayList<Integer> listaDoWykresu;
    static ArrayList<Color> kolory = new ArrayList<>();
    static ArrayList<Slupek> listaSlupkow;
    static ArrayList<Integer> wysokosciSlupkow;
    Wykres wykres;
    static int ilosc;
    static int max;
    Random random = new Random();

    public MyFrame() {
        super("Lab 4: zadanie 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(250,100);
        setSize(1000,600);
        setVisible(true);
        setLayout(null);

        textFields = new ArrayList<>();
        checkboxes = new ArrayList<>();
        int y1=30;
        int y2=30;
        for(int i=0;i<10;i++){
            textFields.add(new JTextField(15));
            textFields.get(i).setBounds(50,y1,200,22);
            add(textFields.get(i));
            y1+=50;
            checkboxes.add(new Checkbox());
            checkboxes.get(i).setBounds(35,y2,22,22);
            add(checkboxes.get(i));
            checkboxes.get(i).addItemListener(this);
            y2+=50;
            float red = random.nextFloat();
            float green = random.nextFloat();
            float blue = random.nextFloat();
            kolory.add(new Color(red,green,blue));
        }
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        listaDoWykresu = new ArrayList<>();
        for(int m=0;m<10;m++){
            boolean state=checkboxes.get(m).getState();
            if(state){
                listaDoWykresu.add(Integer.valueOf(textFields.get(m).getText()));
            }
        }
        ilosc=listaDoWykresu.size();
        update();
        rysowanieWykresu();
    }
    public static void wysokoscSlupka() {
        wysokosciSlupkow = new ArrayList<>();
        if(listaDoWykresu.size()!=0){
            for (Integer integer : listaDoWykresu) {
                if (integer > max)
                    max = integer;
            }
            for(int m=0;m<ilosc;m++){
                wysokosciSlupkow.add((listaDoWykresu.get(m)*280/max));
            }
        }
    }
    public static void update(){
        wysokoscSlupka();
        listaSlupkow = new ArrayList<>();
        for (int n = 0; n < ilosc; n++) {
            listaSlupkow.add(new Slupek(wysokosciSlupkow.get(n),kolory.get(n)));
        }
    }
    public void rysowanieWykresu(){
        wykres = new Wykres();
        super.add(wykres);
        wykres.repaint();
    }
}
