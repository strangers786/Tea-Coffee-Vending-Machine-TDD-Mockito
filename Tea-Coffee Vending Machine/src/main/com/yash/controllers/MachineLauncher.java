package main.com.yash.controllers;

import main.com.yash.container.ContainerHandler;

public class MachineLauncher {

	public static void main(String args[]) {
		ContainerHandler.getInstance().fillContainer();
		FrontController machineLauncher = new FrontController();
		machineLauncher.machineLauncher();

	}

}
