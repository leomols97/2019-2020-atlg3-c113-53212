/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author leopoldmols
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Controller.ControllerSuite.class, Main.MainSuite.class, Models.ModelsSuite.class, View.ViewSuite.class, GuiFx.GuiFxSuite.class})
public class RootSuite {
    
}
