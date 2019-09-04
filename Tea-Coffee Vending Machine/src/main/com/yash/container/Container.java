package main.com.yash.container;

public class Container {

	private int teaQuantity;
	private int coffeeQuantity;
	private int sugarQuantity;
	private int waterQuantity;
	private int milkQuantity;

	private int teaCost;
	private int coffeeCost;
	private int blackCoffeeCost;
	private int blackTeaCost;

	private int wastageTea = 0;
	private int wastageWater = 0;
	private int wastageMilk = 0;
	private int WastageSugar = 0;
	private int wastageCoffee = 0;

	public int totalCost;

	public int getWastageTea() {
		return wastageTea;
	}

	public void setWastageTea(int wastageTea) {
		this.wastageTea = wastageTea;
	}

	public int getWastageWater() {
		return wastageWater;
	}

	public void setWastageWater(int wastageWater) {
		this.wastageWater = wastageWater;
	}

	public int getWastageMilk() {
		return wastageMilk;
	}

	public void setWastageMilk(int wastageMilk) {
		this.wastageMilk = wastageMilk;
	}

	public int getWastageSugar() {
		return WastageSugar;
	}

	public void setWastageSugar(int wastageSugar) {
		WastageSugar = wastageSugar;
	}

	public int getWastageCoffee() {
		return wastageCoffee;
	}

	public void setWastageCoffee(int wastageCoffee) {
		this.wastageCoffee = wastageCoffee;
	}

	public int getTeaQuantity() {
		return teaQuantity;
	}

	public void setTeaQuantity(int teaQuantity) {
		this.teaQuantity = teaQuantity;
	}

	public int getCoffeeQuantity() {
		return coffeeQuantity;
	}

	public void setCoffeeQuantity(int coffeeQuantity) {
		this.coffeeQuantity = coffeeQuantity;
	}

	public int getSugarQuantity() {
		return sugarQuantity;
	}

	public void setSugarQuantity(int sugarQuantity) {
		this.sugarQuantity = sugarQuantity;
	}

	public int getWaterQuantity() {
		return waterQuantity;
	}

	public void setWaterQuantity(int waterQuantity) {
		this.waterQuantity = waterQuantity;
	}

	public int getMilkQuantity() {
		return milkQuantity;
	}

	public void setMilkQuantity(int milkQuantity) {
		this.milkQuantity = milkQuantity;
	}

	public int getTeaCost() {
		return teaCost;
	}

	public void setTeaCost(int teaCost) {
		this.teaCost = teaCost;
	}

	public int getCoffeeCost() {
		return coffeeCost;
	}

	public void setCoffeeCost(int coffeeCost) {
		this.coffeeCost = coffeeCost;
	}

	public int getBlackCoffeeCost() {
		return blackCoffeeCost;
	}

	public void setBlackCoffeeCost(int blackCoffeeCost) {
		this.blackCoffeeCost = blackCoffeeCost;
	}

	public int getBlackTeaCost() {
		return blackTeaCost;
	}

	public void setBlackTeaCost(int blackTeaCost) {
		this.blackTeaCost = blackTeaCost;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

}
