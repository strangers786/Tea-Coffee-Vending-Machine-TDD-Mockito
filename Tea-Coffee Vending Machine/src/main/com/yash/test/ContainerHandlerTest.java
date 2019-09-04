
package main.com.yash.test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import main.com.yash.container.Container;
import main.com.yash.container.ContainerHandler;
import main.com.yash.container.VendingFactory;
import main.com.yash.controllers.UseInput;
import main.com.yash.interfaces.DrinkService;

@RunWith(MockitoJUnitRunner.class)
public class ContainerHandlerTest {

	@InjectMocks
	ContainerHandler containerHandler;

	@Mock
	VendingFactory vendingFactory;

	@Mock
	UseInput userInput;

	@Mock
	DrinkService drinkService;

	@Mock
	Container containerMock;

	@Test
	public void shouldResetContainer() {
		containerHandler.containerReset();

	}

	@Test
	public void shouldCheckContainerStatus() {
		containerHandler.containerStatus();

	}

	@Test
	public void shouldFillContainer() {
		containerHandler.fillContainer();

	}

	@Test
	public void shouldOrderDrinkTea() {
		when(vendingFactory.getInstance(1)).thenReturn(drinkService);
		when(drinkService.makeDrinks(1)).thenReturn(true);

		containerHandler.OrderedDrink(1, 1);
		drinkService.makeDrinks(1);
		verify(drinkService).makeDrinks(1);

	}

	@Test
	public void shouldOrderDrinkCoffee() {
		when(vendingFactory.getInstance(2)).thenReturn(drinkService);
		when(drinkService.makeDrinks(1)).thenReturn(true);

		containerHandler.OrderedDrink(2, 1);
		drinkService.makeDrinks(1);
		verify(drinkService).makeDrinks(1);

	}

	@Test
	public void shouldOrderDrinkBlackCoffee() {
		when(vendingFactory.getInstance(3)).thenReturn(drinkService);
		when(drinkService.makeDrinks(1)).thenReturn(true);

		containerHandler.OrderedDrink(3, 1);
		drinkService.makeDrinks(1);
		verify(drinkService).makeDrinks(1);

	}

	@Test
	public void shouldOrderDrinkBlackTea() {
		when(vendingFactory.getInstance(4)).thenReturn(drinkService);
		when(drinkService.makeDrinks(1)).thenReturn(true);

		containerHandler.OrderedDrink(4, 1);
		drinkService.makeDrinks(1);
		verify(drinkService).makeDrinks(1);

	}

	@Test
	public void shouldRefillAllContainer() {
		containerHandler.refillContainer(1);
		containerHandler.refillContainer(2);
		containerHandler.refillContainer(3);
		containerHandler.refillContainer(4);
		containerHandler.refillContainer(5);
		containerHandler.refillContainer(6);

	}

}
