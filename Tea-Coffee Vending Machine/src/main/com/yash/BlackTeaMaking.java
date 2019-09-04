package main.com.yash;

import java.util.function.IntPredicate;

import org.apache.log4j.Logger;

import main.com.yash.constants.Constant;
import main.com.yash.container.ContainerHandler;
import main.com.yash.exceptions.EmptyContainerException;
import main.com.yash.interfaces.DrinkService;

public class BlackTeaMaking implements DrinkService {

	ContainerHandler containerHandler = ContainerHandler.getInstance();

	private static final Logger LOGGER = Logger.getLogger(BlackTeaMaking.class);

	@Override
	public boolean makeDrinks(int numberOfCups) {

		if (checkContainerStatus(numberOfCups)) {
			containerHandler.getContainer().setSugarQuantity(
					containerHandler.getContainer().getSugarQuantity() - (Constant.SUGAR_CONSUMED * numberOfCups));
			containerHandler.getContainer().setWaterQuantity(
					containerHandler.getContainer().getWaterQuantity() - (Constant.WATER_CONSUMED * numberOfCups));
			containerHandler.getContainer().setTeaQuantity(
					containerHandler.getContainer().getTeaQuantity() - (Constant.TEA_CONSUMED * numberOfCups));

			containerHandler.getContainer()
					.setWastageTea(containerHandler.getContainer().getWastageTea() + (Constant.ZERO * numberOfCups));
			containerHandler.getContainer().setWastageSugar(
					containerHandler.getContainer().getWastageSugar() + (Constant.SUGAR_WASTE * numberOfCups));
			containerHandler.getContainer().setWastageWater(
					containerHandler.getContainer().getWastageWater() + (Constant.WATER_WASTE * numberOfCups));

			containerHandler.getContainer().setBlackTeaCost(Constant.BLACKTEACOST * numberOfCups);
			containerHandler.getContainer().setTotalCost(
					containerHandler.getContainer().getTotalCost() + containerHandler.getContainer().getBlackTeaCost());

			LOGGER.info("Black Tea is ready for you :) !! please pay Rs." + " "
					+ containerHandler.getContainer().getBlackTeaCost());

		} else {
			throw new EmptyContainerException();
		}
		return true;

	}

	@Override
	public boolean checkContainerStatus(int numberOfCups) {
		IntPredicate hasTea = capacity -> containerHandler.getContainer()
				.getTeaQuantity() > (Constant.TEA_CONSUMED * numberOfCups) ? true : false;
		IntPredicate hasWater = capacity -> containerHandler.getContainer()
				.getWaterQuantity() > (Constant.WATER_CONSUMED * numberOfCups) ? true : false;
		IntPredicate hasSugar = capacity -> containerHandler.getContainer()
				.getSugarQuantity() > (Constant.SUGAR_CONSUMED * numberOfCups) ? true : false;
		return (hasTea).and(hasWater).and(hasSugar).test(numberOfCups);
	}

}
