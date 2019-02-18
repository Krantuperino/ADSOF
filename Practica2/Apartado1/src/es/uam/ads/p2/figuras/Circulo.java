package es.uam.ads.p2.figuras;

public class Circulo extends Figura{
    private double radio;

    public Circulo(double x){
        radio = x;
    }

     public String toString() {
        return "Circulo [area=" + getArea() + ", perimetro=" + getPerimetro() + "]";
    }

    public double getRadio(){
        return radio;
    } 

    public double getPerimetro() {
        return 2 * Math.PI * radio;
    }

    public double getArea() {
        return Math.PI * radio * radio;
    }
}