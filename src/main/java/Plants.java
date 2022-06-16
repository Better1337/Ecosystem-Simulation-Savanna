import java.awt.*;

public class Plants {
    public static class WysokaTrawa { //Klasa  rośliny przechowywująca jej statystyki, położenie oraz metode umieszczania go na mapie
        int wielkosc = 6;
        int x, y;
        Integer rozmiar = Mapa.getRozmiar();

        public WysokaTrawa() {
            x = (int) (Math.random() * rozmiar - 1);
            y = (int) (Math.random() * rozmiar - 1);
        }

        public void paint(Graphics g) { //Metoda umieszczania na mapie
            g.setColor(Color.magenta);
            g.fillOval(x, y, 20, 20);
        }
    }
        public static class NiskaTrawa {
            int wielkosc = 3;
            int x, y;
            Integer rozmiar = Mapa.getRozmiar();

            public NiskaTrawa() {
                x = (int) (Math.random() * rozmiar - 1);
                y = (int) (Math.random() * rozmiar - 1);
            }

            public void paint(Graphics g) { //Metoda umieszczania na mapie
                g.setColor(Color.cyan);
                g.fillOval(x, y, 15, 15);
            }
    }
}


