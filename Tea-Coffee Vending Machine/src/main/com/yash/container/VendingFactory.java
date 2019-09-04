package main.com.yash.container;

import main.com.yash.BlackCoffeeMaking;
import main.com.yash.BlackTeaMaking;
import main.com.yash.CoffeeMaking;
import main.com.yash.TeaMaking;
import main.com.yash.interfaces.DrinkService;

public class VendingFactory {

	public DrinkService getInstance(int drinkType) {

		if (drinkType == 1) {
			return new TeaMaking();
		} else if (drinkType == 2) {
			return new CoffeeMaking();
		} else if (drinkType == 3) {
			return new BlackCoffeeMaking();
		} else {
			return new BlackTeaMaking();
		}
	}

}
