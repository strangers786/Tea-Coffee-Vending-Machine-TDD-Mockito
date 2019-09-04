package main.com.yash;

import java.util.function.IntPredicate;

import org.apache.log4j.Logger;

import main.com.yash.constants.Constant;
import main.com.yash.container.ContainerHandler;
import main.com.yash.exceptions.EmptyContainerException;
import main.com.yash.interfaces.DrinkService;

public class CoffeeMaking implements DrinkService {

	ContainerHandler containerHandler = ContainerHandler.getInstance();

	private static final Logger LOGGER = Logger.getLogger(CoffeeMaking.class);

	@Override
	public boolean makeDrinks(int numberOfCups) {

		if (checkContainerStatus(numberOfCups)) {
			containerHandler.getContainer().setMilkQuantity(containerHandler.getContainer().getMilkQuantity()
					- (Constant.MILK_CONSUMED_FOR_COFFEE * numberOfCups));
			containerHandler.getContainer().setSugarQuantity(containerHandler.getContainer().getSugarQuantity()
					- (Constant.SUGAR_CONSUMED_FOR_COFFEE * numberOfCups));
			containerHandler.getContainer().setWaterQuantity(containerHandler.getContainer().getWaterQuantity()
					- (Constant.WATER_CONSUMED_FOR_COFFEE * numberOfCups));
			containerHandler.getContainer().setCoffeeQuantity(containerHandler.getContainer().getCoffeeQuantity()
					- (Constant.COFFEE_CONSUMED_FOR_COFFEE * numberOfCups));

			containerHandler.getContainer().setWastageCoffee(containerHandler.getContainer().getWastageCoffee()
					+ (Constant.COFFEE_WASTE_FOR_COFFEE * numberOfCups));
			containerHandler.getContainer().setWastageSugar(containerHandler.getContainer().getWastageSugar()
					+ (Constant.SUGAR_WASTE_FOR_COFFEE * numberOfCups));
			containerHandler.getContainer().setWastageMilk(containerHandler.getContainer().getWastageMilk()
					+ (Constant.SUGAR_WASTE_FOR_COFFEE * numberOfCups));
			containerHandler.getContainer().setWastageWater(containerHandler.getContainer().getWastageWater()
					+ (Constant.WATER_WASTE_FOR_COFFEE * numberOfCups));

			containerHandler.getContainer().setCoffeeCost(Constant.COFFEECOST * numberOfCups);
			containerHandler.getContainer().setTotalCost(
					containerHandler.getContainer().getTotalCost() + containerHandler.getContainer().getCoffeeCost());

			LOGGER.info("Coffee is ready for you :) !! please pay Rs." + " "
					+ containerHandler.getContainer().getCoffeeCost());

		} else {
			throw new EmptyContainerException();

		}
		return true;

	}

	@Override
	public boolean checkContainerStatus(int numberOfCups) {
		IntPredicate hasMilk = capacity -> containerHandler.getContainer()
				.getMilkQuantity() > (Constant.MILK_CONSUMED_FOR_COFFEE * numberOfCups) ? true : false;
		IntPredicate hasCoffee = capacity -> containerHandler.getContainer()
				.getCoffeeQuantity() > (Constant.COFFEE_CONSUMED_FOR_COFFEE * numberOfCups) ? true : false;
		IntPredicate hasWater = capacity -> containerHandler.getContainer()
				.getWaterQuantity() > (Constant.WATER_CONSUMED_FOR_COFFEE * numberOfCups) ? true : false;
		IntPredicate hasSugar = capacity -> containerHandler.getContainer()
				.getSugarQuantity() > (Constant.SUGAR_WASTE_FOR_COFFEE * numberOfCups) ? true : false;
		return hasMilk.and(hasCoffee).and(hasWater).and(hasSugar).test(numberOfCups);
	}

}
