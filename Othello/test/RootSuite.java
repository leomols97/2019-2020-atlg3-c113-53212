/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controller.ControllerSuite;
import Main.MainSuite;
import Models.ModelsSuite;
import View.ViewSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author leopoldmols
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ViewSuite.class, MainSuite.class, ModelsSuite.class, ControllerSuite.class})
public class RootSuite {
    
}
