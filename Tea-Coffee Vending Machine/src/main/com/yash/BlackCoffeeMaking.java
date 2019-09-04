package main.com.yash;

import java.util.function.IntPredicate;

import org.apache.log4j.Logger;

import main.com.yash.constants.Constant;
import main.com.yash.container.ContainerHandler;
import main.com.yash.exceptions.EmptyContainerException;
import main.com.yash.interfaces.DrinkService;

public class BlackCoffeeMaking implements DrinkService {

	ContainerHandler containerHandler = ContainerHandler.getInstance();

	private static final Logger LOGGER = Logger.getLogger(BlackCoffeeMaking.class);

	@Override
	public boolean makeDrinks(int numberOfCups) {

		if (checkContainerStatus(numberOfCups)) {
			containerHandler.getContainer().setSugarQuantity(
					containerHandler.getContainer().getSugarQuantity() - (Constant.SUGAR_CONSUMED * numberOfCups));
			containerHandler.getContainer().setWaterQuantity(
					containerHandler.getContainer().getWaterQuantity() - (Constant.WATER_CONSUMED * numberOfCups));
			containerHandler.getContainer().setCoffeeQuantity(
					containerHandler.getContainer().getCoffeeQuantity() - (Constant.COFFEE_CONSUMED * numberOfCups));

			containerHandler.getContainer().setWastageCoffee(
					containerHandler.getContainer().getWastageCoffee() + (Constant.ZERO * numberOfCups));
			containerHandler.getContainer().setWastageSugar(
					containerHandler.getContainer().getWastageSugar() + (Constant.SUGAR_WASTE * numberOfCups));
			containerHandler.getContainer().setWastageWater(
					containerHandler.getContainer().getWastageWater() + (Constant.WATER_WASTE * numberOfCups));

			containerHandler.getContainer().setBlackCoffeeCost(Constant.BLACKCOFFEECOST * numberOfCups);
			containerHandler.getContainer().setTotalCost(containerHandler.getContainer().getTotalCost()
					+ containerHandler.getContainer().getBlackCoffeeCost());

			LOGGER.info("Black Coffee is ready for you :) !! please pay Rs." + " "
					+ containerHandler.getContainer().getBlackCoffeeCost());

		} else {
			throw new EmptyContainerException();

		}
		return true;

	}

	@Override
	public boolean checkContainerStatus(int numberOfCups) {
		IntPredicate hasCoffee = capacity -> containerHandler.getContainer()
				.getCoffeeQuantity() > (Constant.COFFEE_CONSUMED * numberOfCups) ? true : false;
		IntPredicate hasWater = capacity -> containerHandler.getContainer()
				.getWaterQuantity() > (Constant.WATER_CONSUMED * numberOfCups) ? true : false;
		IntPredicate hasSugar = capacity -> containerHandler.getContainer()
				.getSugarQuantity() > (Constant.SUGAR_CONSUMED * numberOfCups) ? true : false;
		return (hasCoffee).and(hasWater).and(hasSugar).test(numberOfCups);
	}

}
