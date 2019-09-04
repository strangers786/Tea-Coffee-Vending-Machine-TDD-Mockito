package main.com.yash.test;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import main.com.yash.container.Container;
import main.com.yash.container.ContainerHandler;
import main.com.yash.controllers.FrontController;
import main.com.yash.controllers.UseInput;

@RunWith(MockitoJUnitRunner.class)
public class FrontControllerTest {

	@InjectMocks
	FrontController frontController;

	@Mock
	ContainerHandler containerHandler;

	@Mock
	Container container;

	@Mock
	UseInput userInput;

	@Test
	public void shouldLaunchForOrderDrinksThenTeaThenOneCup() {
		when(userInput.useInput()).thenReturn(1, 1, 1, 2);
		doNothing().when(containerHandler).OrderedDrink(1, 1);

		frontController.machineLauncher();

		verify(containerHandler).OrderedDrink(1, 1);

	}

	@Test
	public void shouldLaunchForOrderDrinksThenCoffeeThenOneCup() {
		when(userInput.useInput()).thenReturn(1, 2, 1, 2);
		doNothing().when(containerHandler).OrderedDrink(2, 1);

		frontController.machineLauncher();

		verify(containerHandler).OrderedDrink(2, 1);

	}

	@Test
	public void shouldLaunchToCheckContainerStatus() {
		when(userInput.useInput()).thenReturn(2, 2);
		doNothing().when(containerHandler).containerStatus();

		frontController.machineLauncher();

		verify(containerHandler).containerStatus();

	}

	@Test
	public void shouldLaunchToRefillContainer() {
		when(userInput.useInput()).thenReturn(4, 1, 2);
		doNothing().when(containerHandler).refillContainer(1);

		frontController.machineLauncher();

		verify(containerHandler).refillContainer(1);

	}

	@Test
	public void shouldLaunchToGetTotalCost() {

		when(userInput.useInput()).thenReturn(5, 2);
		when(containerHandler.getContainer()).thenReturn(container);
		when(container.getTotalCost()).thenReturn(10);

		frontController.machineLauncher();

		verify(container).getTotalCost();

	}

	@Test
	public void shouldLaunchToGetReset() {

		when(userInput.useInput()).thenReturn(3, 2);
		doNothing().when(containerHandler).containerReset();

		frontController.machineLauncher();

		verify(containerHandler).containerReset();

	}

	@Test
	public void shouldLaunchToExitSystem() {

		when(userInput.useInput()).thenReturn(6, 2);

		frontController.machineLauncher();

	}

	@Test
	public void shouldLaunchForAnyDefaultValue() {
		when(userInput.useInput()).thenReturn(7, 2);

		frontController.machineLauncher();

	}

}
