package es.uam.ads.p2.figuras;

public abstract class Figura {

    public abstract double getPerimetro();

    public abstract double getArea();

    public boolean esMayor(Figura fig1) {
        if(this.getArea() > fig1.getArea())
            return true;
        return false;
    }
}