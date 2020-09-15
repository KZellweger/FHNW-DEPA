package sample;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin Zellweger
 * @Date 15.09.20
 */
public class ColorSubject {
    private List<Observer> observers = new ArrayList<>();
    private Color color = new Color(Color.BLACK);
    public Paint getColor() {
        return color;
    }

    public void setColor(javafx.scene.paint.Paint color) {
        this.color = color;
        notifyObservers();
    }

    public void setColor(int r, int g, int b) {
        this.color = new Color(r, g, b);
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
