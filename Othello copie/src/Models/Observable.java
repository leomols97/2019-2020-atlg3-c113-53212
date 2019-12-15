package Models;

/**
 * This class represents the Observable.
 *
 * @author leopoldmols
 */
public interface Observable
{

    /**
     *
     * @param obs
     */
    void registerObserver(Observer obs);

    /**
     *
     * @param obs
     */
    void removeObserver(Observer obs);

    /**
     *
     */
    void notifyObservers();
}
