package main.com.yash.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TeaMakingTest.class, CoffeeMakingTest.class, BlackCoffeeMakingTest.class, BlackTeaMakingTest.class,
		FrontControllerTest.class, ContainerHandlerTest.class,

})

public class VendingMachineSuite {

}
