
import java.awt.*;


public class Animal {
    public static class Antylopa { //Klasa  zwięrzęcia przechowywująca jego statystyki, położenie oraz metode umieszczania go na mapie
        int strenght = 0;
        int wielkosc = 1;
        int status = 1;
        Integer rozmiar = Mapa.getRozmiar();


        int x = (int) (Math.random() * rozmiar - 1);
        int y = (int) (Math.random() * rozmiar - 1);
        int vx = (int) (Math.random() * (10 + 1) - 5);
        int vy = (int) (Math.random() * (10 + 1) - 5);


        public void paint(Graphics g) { //Metoda umieszczania na mapie
            switch (status) {
                case 0 -> {
                    g.setColor(Color.LIGHT_GRAY);
                    g.fillOval(x, y, 10, 10);
                    vx = 0;
                    vy = 0;
                    strenght = 0;
                }
                case 1 -> {
                    g.setColor(Color.green);
                    g.fillOval(x, y, 10, 10);
                }
            }
            x += vx;
            y += vy;
            if (x < 0 || x >= rozmiar) {
                vx *= -1;
            }
            if (y < 0 || y >= rozmiar) {
                vy *= -1;
            }


            g.fillOval(x, y, 10, 10);
        }
    }

    public static class Hiena { //Klasa zwięrzęcia przechowywująca jego statystyki, położenie oraz metode umieszczania go na mapie
        int strenght = 1;
        int wielkosc = 1;
        int status = 1;
        Integer rozmiar = Mapa.getRozmiar();

        int x = (int) (Math.random() * rozmiar - 1);
        int y = (int) (Math.random() * rozmiar - 1);
        int vx = (int) (Math.random() * (10 + 1) - 5);
        int vy = (int) (Math.random() * (10 + 1) - 5);


        public void paint(Graphics g) { //Metoda umieszczania na mapie
            switch (status) {
                case 0 -> {
                    g.setColor(Color.LIGHT_GRAY);
                    g.fillOval(x, y, 10, 10);
                    vx = 0;
                    vy = 0;
                    strenght = 0;
                }
                case 1 -> {
                    g.setColor(Color.red);
                    g.fillOval(x, y, 10, 10);
                }
            }
            x += vx;
            y += vy;
            if (x < 0 || x >= rozmiar) {
                vx *= -1;
            }
            if (y < 0 || y >= rozmiar) {
                vy *= -1;
            }


            g.fillOval(x, y, 10, 10);
        }
    }

    public static class Lew { //Klasa  zwięrzęcia przechowywująca jego statystyki, położenie oraz metode umieszczania go na mapie
        int strenght = 3;
        int wielkosc = 3;
        int status = 1;
        Integer rozmiar = Mapa.getRozmiar();


        int x = (int) (Math.random() * rozmiar - 1);
        int y = (int) (Math.random() * rozmiar - 1);
        int vx = (int) (Math.random() * (10 + 1) - 5);
        int vy = (int) (Math.random() * (10 + 1) - 5);


        public void paint(Graphics g) { //Metoda umieszczania na mapie
            switch (status) {
                case 0 -> {
                    g.setColor(Color.LIGHT_GRAY);
                    g.fillOval(x, y, 10, 10);
                    vx = 0;
                    vy = 0;
                    strenght = 0;
                }
                case 1 -> {
                    g.setColor(Color.yellow);
                    g.fillOval(x, y, 10, 10);
                }
            }
            x += vx;
            y += vy;
            if (x < 0 || x >= rozmiar) {
                vx *= -1;
            }
            if (y < 0 || y >= rozmiar) {
                vy *= -1;
            }


            g.fillOval(x, y, 10, 10);
        }
    }

    public static class Tygrys { //Klasa  zwięrzęcia przechowywująca jego statystyki, położenie oraz metode umieszczania go na mapie
        int strenght = 2;
        int wielkosc = 2;

        int status = 1;
        Integer rozmiar = Mapa.getRozmiar();


        int x = (int) (Math.random() * rozmiar - 1);
        int y = (int) (Math.random() * rozmiar - 1);
        int vx = (int) (Math.random() * (10 + 1) - 5);
        int vy = (int) (Math.random() * (10 + 1) - 5);


        public void paint(Graphics g) { //Metoda umieszczania na mapie
            switch (status) {
                case 0 -> {
                    g.setColor(Color.LIGHT_GRAY);
                    g.fillOval(x, y, 10, 10);
                    vx = 0;
                    vy = 0;
                    strenght = 0;
                }
                case 1 -> {
                    g.setColor(Color.blue);
                    g.fillOval(x, y, 10, 10);
                }
            }
            x += vx;
            y += vy;
            if (x < 0 || x >= rozmiar) {
                vx *= -1;
            }
            if (y < 0 || y >= rozmiar) {
                vy *= -1;
            }


            g.fillOval(x, y, 10, 10);
        }
    }

    public static void Collision(Antylopa a, Hiena h, Tygrys t, Lew l, Plants.WysokaTrawa w, Plants.NiskaTrawa n) { //Przedstawienie zwierząt jako obiektów na mapie oraz schemat ich interakcji
        Rectangle z1 = new Rectangle(a.x, a.y, 10, 10);                                                 //miedzy sobą oraz schemat ich interakcji miedzy sobą
        Rectangle z2 = new Rectangle(h.x, h.y, 10, 10);
        Rectangle z3 = new Rectangle(t.x, t.y, 10, 10);
        Rectangle z4 = new Rectangle(l.x, l.y, 10, 10);
        Rectangle z5 = new Rectangle(w.x, w.y, 15, 15);
        Rectangle z6 = new Rectangle(n.x, n.y, 15, 15);

        //Interkacja miedzy zwięrzętami i roślinami
        if (z1.intersects(z2)) {
            if (a.strenght > h.strenght) {
                h.status = 0;
            } else
                a.status = 0;
                h.strenght++;
                h.wielkosc++;
        }
        if (z1.intersects(z3)) {
            if (a.strenght > t.strenght) {
                t.status = 0;
            } else
                a.status = 0;
                t.strenght++;
                t.wielkosc++;
        }
        if (z1.intersects(z4)) {
            if (a.strenght > l.strenght) {
                l.status = 0;
            } else
                a.status = 0;
                l.strenght++;
                l.wielkosc++;
        }
        if (z2.intersects(z3)) {
            if (h.strenght > t.strenght) {
                t.status = 0;
                h.strenght++;
                h.wielkosc++;
            } else
                h.status = 0;
                t.strenght++;
                t.wielkosc++;
        }
        if (z2.intersects(z4)) {
            if (h.strenght >l.strenght) {
                l.status = 0;
                h.strenght++;
                h.wielkosc++;
            } else
                h.status = 0;
                l.strenght++;
                l.wielkosc++;
        }
        if (z3.intersects(z4)) {
            if (t.strenght > l.strenght) {
                l.status = 0;
                t.strenght++;
                t.wielkosc++;
            } else
                t.status = 0;
                l.strenght++;
                l.wielkosc++;
        }
        if(z5.intersects(z1)){
            if(a.wielkosc <= w.wielkosc) {
                for (int i = 0; i <= 7; i++) {
                    a.vx = 0;
                    a.vy = 0;
                    a.strenght = 1000;
                }
                a.vx = (int) (Math.random() * (10 + 1) - 5);
                a.vy = (int) (Math.random() * (10 + 1) - 5);
                a.strenght = 0;
            }
        }
        if(z5.intersects(z2)) {
            if(h.wielkosc <= w.wielkosc) {
                for (int i = 0; i <= 7; i++) {
                    h.vx = 0;
                    h.vy = 0;
                    h.strenght = 1000;
                }
                h.vx = (int) (Math.random() * (10 + 1) - 5);
                h.vy = (int) (Math.random() * (10 + 1) - 5);
                h.strenght = 1;
            }
        }
        if(z5.intersects(z3)) {
            if (t.wielkosc <= w.wielkosc) {
                for (int i = 0; i <= 7; i++) {
                    t.vx = 0;
                    t.vy = 0;
                    t.strenght = 1000;
                }
                t.vx = (int) (Math.random() * (10 + 1) - 5);
                t.vy = (int) (Math.random() * (10 + 1) - 5);
                t.strenght = 2;
            }
        }
        if(z5.intersects(z4)) {
            if(l.wielkosc <= w.wielkosc) {
                for (int i = 0; i <= 7; i++) {
                    l.vx = 0;
                    l.vy = 0;
                    l.strenght = 1000;
                }
                l.vx = (int) (Math.random() * (10 + 1) - 5);
                l.vy = (int) (Math.random() * (10 + 1) - 5);
                l.strenght = 3;
            }
        }
        if(z6.intersects(z1)) {
            if(a.wielkosc <= n.wielkosc) {
                for (int i = 0; i <= 7; i++) {
                    a.vx = 0;
                    a.vy = 0;
                    a.strenght = 1000;
                }
                a.vx = (int) (Math.random() * (10 + 1) - 5);
                a.vy = (int) (Math.random() * (10 + 1) - 5);
                a.strenght = 0;
            }
        }
        if(z6.intersects(z2)) {
            if(h.wielkosc <= n.wielkosc) {
                for (int i = 0; i <= 7; i++) {
                    h.vx = 0;
                    h.vy = 0;
                    h.strenght = 1000;
                }
                h.vx = (int) (Math.random() * (10 + 1) - 5);
                h.vy = (int) (Math.random() * (10 + 1) - 5);
                h.strenght = 1;
            }
        }
        if(z6.intersects(z3)) {
            if (t.wielkosc <= n.wielkosc) {
                for (int i = 0; i <= 7; i++) {
                    t.vx = 0;
                    t.vy = 0;
                    t.strenght = 1000;
                }
                t.vx = (int) (Math.random() * (10 + 1) - 5);
                t.vy = (int) (Math.random() * (10 + 1) - 5);
                t.strenght = 2;
            }
        }
        if(z6.intersects(z4)) {
            if (l.wielkosc <= n.wielkosc) {
                for (int i = 0; i <= 7; i++) {
                    l.vx = 0;
                    l.vy = 0;
                    l.strenght = 1000;
                }
                l.vx = (int) (Math.random() * (10 + 1) - 5);
                l.vy = (int) (Math.random() * (10 + 1) - 5);
                l.strenght = 3;
            }
        }
    }
}





