package main.com.yash;

import java.util.function.IntPredicate;

import org.apache.log4j.Logger;

import main.com.yash.constants.Constant;
import main.com.yash.container.ContainerHandler;
import main.com.yash.exceptions.EmptyContainerException;
import main.com.yash.interfaces.DrinkService;

public class TeaMaking implements DrinkService {

	ContainerHandler containerHandler = ContainerHandler.getInstance();

	private static final Logger LOGGER = Logger.getLogger(TeaMaking.class);

	public boolean makeDrinks(int numberOfCups) {

		if (checkContainerStatus(numberOfCups)) {
			containerHandler.getContainer().setMilkQuantity(containerHandler.getContainer().getMilkQuantity()
					- (Constant.MILK_CONSUMED_FOR_TEA * numberOfCups));
			containerHandler.getContainer().setSugarQuantity(containerHandler.getContainer().getSugarQuantity()
					- (Constant.SUGAR_CONSUMED_FOR_TEA * numberOfCups));
			containerHandler.getContainer().setWaterQuantity(containerHandler.getContainer().getWaterQuantity()
					- (Constant.WATER_CONSUMED_FOR_TEA * numberOfCups));
			containerHandler.getContainer().setTeaQuantity(
					containerHandler.getContainer().getTeaQuantity() - (Constant.TEA_CONSUMED_FOR_TEA * numberOfCups));

			containerHandler.getContainer().setWastageTea(
					containerHandler.getContainer().getWastageTea() + (Constant.TEA_WASTE_FOR_TEA * numberOfCups));
			containerHandler.getContainer().setWastageSugar(
					containerHandler.getContainer().getWastageSugar() + (Constant.SUGAR_WASTE_FOR_TEA * numberOfCups));
			containerHandler.getContainer().setWastageMilk(
					containerHandler.getContainer().getWastageMilk() + (Constant.MILK_WASTE_FOR_TEA * numberOfCups));
			containerHandler.getContainer().setWastageWater(
					containerHandler.getContainer().getWastageWater() + (Constant.WATER_WASTE_FOR_TEA * numberOfCups));

			containerHandler.getContainer().setTeaCost(Constant.TEACOST * numberOfCups);
			containerHandler.getContainer().setTotalCost(
					containerHandler.getContainer().getTotalCost() + containerHandler.getContainer().getTeaCost());

			LOGGER.info(
					"Tea is ready for you :) !! please pay Rs." + " " + containerHandler.getContainer().getTeaCost());

		} else {
			throw new EmptyContainerException();

		}
		return true;

	}

	@Override
	public boolean checkContainerStatus(int numberOfCups) {
		IntPredicate hasMilk = capacity -> containerHandler.getContainer()
				.getMilkQuantity() > (Constant.MILK_CONSUMED_FOR_TEA * numberOfCups) ? true : false;
		IntPredicate hasTea = capacity -> containerHandler.getContainer()
				.getTeaQuantity() > (Constant.TEA_CONSUMED_FOR_TEA * numberOfCups) ? true : false;
		IntPredicate hasWater = capacity -> containerHandler.getContainer()
				.getWaterQuantity() > (Constant.WATER_CONSUMED_FOR_TEA * numberOfCups) ? true : false;
		IntPredicate hasSugar = capacity -> containerHandler.getContainer()
				.getSugarQuantity() > (Constant.SUGAR_CONSUMED_FOR_TEA * numberOfCups) ? true : false;
		return hasMilk.and(hasTea).and(hasWater).and(hasSugar).test(numberOfCups);
	}

}
