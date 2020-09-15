package sample;

/**
 * @author Kevin Zellweger
 * @Date 15.09.20
 */
public abstract class Observer {
    protected ColorSubject colorSubject;
    public abstract void update();
}
