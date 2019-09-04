package main.com.yash.controllers;

import org.apache.log4j.Logger;

import main.com.yash.container.ContainerHandler;

public class FrontController {

	UseInput useInput = new UseInput();
	ContainerHandler containerHandler = ContainerHandler.getInstance();

	private static final Logger LOGGER = Logger.getLogger(FrontController.class);

	public void machineLauncher() {
		int orderedAgain = 1;
		do {
			LOGGER.info(
					"According to your Necessi-TEAs\n1 Order Drinks\n2 Container Status\n3 Container Reset\n4 Container Refill\n5 Total cost to be paid\n6 Exit");

			int userInput = useInput.useInput();
			switch (userInput) {

			case 1:
				LOGGER.info("\nMenu Card:\n1 Tea\n2 Coffee\n3 Black Coffee\n4 Black Tea ?");
				int drinkType = useInput.useInput();
				LOGGER.info("How many cups do you want ?");
				int numberOfCups = useInput.useInput();
				containerHandler.OrderedDrink(drinkType, numberOfCups);
				break;
			case 2:
				containerHandler.containerStatus();
				break;
			case 3:
				containerHandler.containerReset();
				break;
			case 4:
				LOGGER.info(
						"Which container do you want to refill ?\n1 Tea Container\n2 Coffee Container\n3 Sugar Container\n4 Milk Container\n5 Water Container");
				containerHandler.refillContainer(useInput.useInput());
				break;
			case 5:
				LOGGER.info("Total Cost to be paid :" + containerHandler.getContainer().getTotalCost());
				break;
			case 6:
				LOGGER.info("Have a good day ! Visit Again !!");
				orderedAgain = 2;
				break;
			default:
				LOGGER.info("Sorry! we can't help you with the give option");
				break;

			}
			if (orderedAgain != 2) {
				LOGGER.info("\nDo you want to continue ?\n1 Yes\n2 No");
				orderedAgain = useInput.useInput();
			}
		} while (orderedAgain == 1);

	}

}
