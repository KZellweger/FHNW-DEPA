package sample;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin Zellweger
 * @Date 15.09.20
 */
public class ColorSubject {
    private List<Observer> observers = new ArrayList<>();
    private Color color = Color.BLACK;
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        notifyObservers();
    }

    public void setColor(int r, int g, int b) {
        this.color = new Color(rgbToFactor(r), rgbToFactor(g), rgbToFactor(b),1.0);
        notifyObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyObservers(){
        for(Observer observer: observers){
            observer.update();
        }
    }

    public Integer intFromFactor(double factor){
        return (int) Math.round(255 * factor);
    }

    private double rgbToFactor(int integerValue){
        return 1.0 / 255 * integerValue;
    }
}
