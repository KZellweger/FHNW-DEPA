package sample;

/**
 * @author Kevin Zellweger
 * @Date 15.09.20
 */
public abstract class Observer {
    //TODO: make color Subject parameter of update method, then you can use an interface
    protected ColorSubject colorSubject;
    public abstract void update();
}
