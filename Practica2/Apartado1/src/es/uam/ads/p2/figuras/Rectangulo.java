package es.uam.ads.p2.figuras;

public class Rectangulo extends Figura{
    private double base;
    private double altura;

    public Rectangulo(double x, double y){
        base = x;
        altura = y;
    }

    public String toString() {
        return "Rectangulo [area=" + getArea() + ", perimetro=" + getPerimetro() + "]";
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    public double getPerimetro() {
        return (base * 2) + (altura * 2);
    }

    public double getArea() {
        return base * altura;
    }

    public boolean isCuadrado() {
        if(base == altura)
            return true;

        return false;
    }
}