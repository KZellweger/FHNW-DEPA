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
        this.color = new Color(r, g, b,100);
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

}
