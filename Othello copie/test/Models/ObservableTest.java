package Models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leopoldmols
 */
public class ObservableTest {
    
    public ObservableTest() {
    }

    /**
     * Test of registerObserver method, of class Observable.
     */
    @Test
    public void testRegisterObserver() {
        System.out.println("registerObserver");
        Observer obs = null;
        Observable instance = new ObservableImpl();
        instance.registerObserver(obs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeObserver method, of class Observable.
     */
    @Test
    public void testRemoveObserver() {
        System.out.println("removeObserver");
        Observer obs = null;
        Observable instance = new ObservableImpl();
        instance.removeObserver(obs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notifyObservers method, of class Observable.
     */
    @Test
    public void testNotifyObservers() {
        System.out.println("notifyObservers");
        Observable instance = new ObservableImpl();
        instance.notifyObservers();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ObservableImpl implements Observable {

        public void registerObserver(Observer obs) {
        }

        public void removeObserver(Observer obs) {
        }

        public void notifyObservers() {
        }
    }
    
}
