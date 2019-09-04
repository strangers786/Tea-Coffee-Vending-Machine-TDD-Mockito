package main.com.yash.container;

import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import main.com.yash.constants.Constant;
import main.com.yash.exceptions.EmptyContainerException;
import main.com.yash.interfaces.DrinkService;

public class ContainerHandler {
	private static ContainerHandler containerHandler;
	private static final Logger LOGGER = Logger.getLogger(ContainerHandler.class);

	Container container = new Container();

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	private ContainerHandler() {
	}

	public static ContainerHandler getInstance() {
		if (containerHandler == null) {
			containerHandler = new ContainerHandler();
		}
		return containerHandler;
	}

	public void fillContainer() {
		JSONParser jsonParser = new JSONParser();
		try (FileReader reader = new FileReader(
				"D:/Workstation/Tea-Coffee Vending Machine/src/main/com/yash/resources/container.json")) {

			Object obj = jsonParser.parse(reader);
			JSONObject containerJson = (JSONObject) obj;
			container.setTeaQuantity(Integer.parseInt(containerJson.get("teaQuantity").toString()));
			container.setCoffeeQuantity(Integer.parseInt(containerJson.get("coffeeQuantity").toString()));
			container.setMilkQuantity(Integer.parseInt(containerJson.get("milkQuantity").toString()));
			container.setWaterQuantity(Integer.parseInt(containerJson.get("waterQuantity").toString()));
			container.setSugarQuantity(Integer.parseInt(containerJson.get("sugarQuantity").toString()));

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

	public void refillContainer(int containerInput) {
		switch (containerInput) {
		case 1:
			container.setTeaQuantity(Constant.TEAQUANTITY);
			break;
		case 2:
			container.setMilkQuantity(Constant.MILKQUANTITY);
			break;
		case 3:
			container.setCoffeeQuantity(Constant.COFFEEQUANTITY);
			break;
		case 4:
			container.setSugarQuantity(Constant.SUGARQUANTITY);
			break;
		case 5:
			container.setWaterQuantity(Constant.WATERQUANTITY);
			break;
		default:
			System.out.println("No such container present");
		}
		LOGGER.info("Container Refill Done.");

	}

	public void containerStatus() {
		String composition = Constant.SPACE + "Remaining" + Constant.SPACE + "Waste" + "\nTEA    :"
				+ container.getTeaQuantity() + " " + "gm" + Constant.SPACE + container.getWastageTea() + " " + "gm"
				+ "\nSUGAR  :" + container.getSugarQuantity() + " " + "gm" + Constant.SPACE
				+ container.getWastageSugar() + " " + "gm" + "\nWATER  :" + container.getWaterQuantity() + " " + "ml"
				+ Constant.SPACE + container.getWastageWater() + " " + "ml" + "\nMILK   :" + container.getMilkQuantity()
				+ " " + "ml" + Constant.SPACE + container.getWastageMilk() + " " + "ml" + "\nCOFFEE :"
				+ container.getCoffeeQuantity() + " " + "gm" + Constant.SPACE + container.getWastageCoffee() + " "
				+ "ml";
		LOGGER.info(composition);
	}

	public void containerReset() {
		container.setTeaQuantity(Constant.TEAQUANTITY);
		container.setSugarQuantity(Constant.SUGARQUANTITY);
		container.setWaterQuantity(Constant.WATERQUANTITY);
		container.setMilkQuantity(Constant.MILKQUANTITY);
		container.setCoffeeQuantity(Constant.COFFEEQUANTITY);

		container.setWastageCoffee(Constant.ZERO);
		container.setWastageMilk(Constant.ZERO);
		container.setWastageSugar(Constant.ZERO);
		container.setWastageWater(Constant.ZERO);
		container.setWastageTea(Constant.ZERO);

		container.setTotalCost(Constant.ZERO);

		LOGGER.info("Machine Reset Done");
	}

	public void OrderedDrink(int drinkType, int numberOfCups) {

		main.com.yash.container.VendingFactory vendingFactory = new VendingFactory();
		DrinkService instance = vendingFactory.getInstance(drinkType);
		try {
			instance.makeDrinks(numberOfCups);
		} catch (EmptyContainerException e) {
			LOGGER.info(e.getMessage());
		}

	}
}
