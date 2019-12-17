package Models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leopoldmols
 */
public class ObserverTest {
    
    public ObserverTest() {
    }

    /**
     * Test of update method, of class Observer.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Observer instance = new ObserverImpl();
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ObserverImpl implements Observer {

        public void update() {
        }
    }
    
}
