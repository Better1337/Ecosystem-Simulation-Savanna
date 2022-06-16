

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Mapa extends JPanel implements ActionListener { //Stworzenie List zwierząt
    ArrayList<Animal.Lew> lwy = new ArrayList<>();
    ArrayList<Animal.Antylopa> antylopa = new ArrayList<>();
    ArrayList<Animal.Hiena> hiena = new ArrayList<>();
    ArrayList<Animal.Tygrys> tygrys = new ArrayList<>();
    ArrayList<Plants.WysokaTrawa> wysokaTrawa;
    ArrayList<Plants.NiskaTrawa> niskaTrawa = new ArrayList<>();

    public void paint(Graphics g) { //Umieszczanie zwierząt na mapie
        super.paintComponent(g);

        for (Animal.Lew l : lwy) {
            l.paint(g);
        }
        for (Animal.Antylopa a : antylopa) {
            a.paint(g);
        }
        for (Animal.Hiena h : hiena) {
            h.paint(g);
        }
        for (Animal.Tygrys t : tygrys) {
            t.paint(g);
        }
        for (Plants.WysokaTrawa w : wysokaTrawa) {
            w.paint(g);
        }
        for (Plants.NiskaTrawa n : niskaTrawa) {
            n.paint(g);
        }

        for(Plants.WysokaTrawa w: wysokaTrawa) { // Wywoływanie metody kolizji pomiędzy zwierzętami
            for (Plants.NiskaTrawa n : niskaTrawa) {
                for (Animal.Lew l : lwy) {
                    for (Animal.Tygrys t : tygrys) {
                        for (Animal.Antylopa a : antylopa) {
                            for (Animal.Hiena h : hiena) {
                                Animal.Collision(a, h, t, l, w, n);
                            }
                        }
                    }
                }
            }
        }



    }

    private static Integer rozmiar;

    public static Integer getRozmiar() {
        return rozmiar;
    }

    public Mapa() {
        ApplicationData appData = new ApplicationData(); //Wywoływanie metody, w której użytkownik podaje dane do programu
        appData.Plansza();
        appData.Lwy();
        appData.Hieny();
        appData.Tygrysy();
        appData.Antylopy();
        appData.WysokaTrawa();
        appData.NiskaTrawa();

        HashMap<String, Integer> ilosc = appData.getIlosc();
        rozmiar = ilosc.get("RozmiarPlanszy");
        JFrame frame = new JFrame("Simulation"); //Tworzenie mapy
        frame.setSize(ilosc.get("RozmiarPlanszy")+40, ilosc.get("RozmiarPlanszy")+40);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        for (int i = 0; i < ilosc.get("IloscLwow"); i++) { //Uzupełnianie listy zwierząt, ilością podaną przez użytkownika
            lwy.add(new Animal.Lew());
        }
        for (int i = 0; i < ilosc.get("IloscAntylop"); i++) {
            antylopa.add(new Animal.Antylopa());
        }
        for (int i = 0; i < ilosc.get("IloscHien"); i++) {
            hiena.add(new Animal.Hiena());
        }
        for (int i = 0; i < ilosc.get("IloscTygrysow"); i++) {
            tygrys.add(new Animal.Tygrys());
        }
        wysokaTrawa = new ArrayList<>();
        for (int i = 0; i < ilosc.get("IloscWysokie"); i++) {
            wysokaTrawa.add(new Plants.WysokaTrawa());
        }
        for (int i = 0; i < ilosc.get("IloscNiskie"); i++) {
            niskaTrawa.add(new Plants.NiskaTrawa());
        }

        Timer t = new Timer(16, this); // Czas określający aktualizacje malowania obiektów na mapie
        t.start();
        frame.add(this);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) { //Aktualizacja malowania obiektów na mapie
        repaint();
    }
}
