package Models;

/**
 * This class represents the Observable.
 *
 * @author leopoldmols
 */
public interface Observable
{

    void registerObserver(Observer obs);

    void removeObserver(Observer obs);

    void notifyObservers();
}
