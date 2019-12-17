package Models;


/**
 * This class represents the Observable.
 *
 * @author leopoldmols
 */
public interface Observable
{

    /**
     * Register a new observer to the observable list
     * 
     * @param obs the observer to add
     */
    void registerObserver(Observer obs);

    /**
     * Remove an observer from the obersvable list
     * 
     * @param obs tthe observer to remove
     */
    void removeObserver(Observer obs);

    /**
     * Notifies the observers that something has changed on the playing board
     * to let them know that they have to update their states
     */
    void notifyObservers();
}