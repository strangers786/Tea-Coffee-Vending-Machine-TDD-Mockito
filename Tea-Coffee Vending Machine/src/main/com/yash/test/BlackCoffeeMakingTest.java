package main.com.yash.test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import main.com.yash.BlackCoffeeMaking;
import main.com.yash.container.Container;
import main.com.yash.container.ContainerHandler;
import main.com.yash.exceptions.EmptyContainerException;

@RunWith(MockitoJUnitRunner.class)
public class BlackCoffeeMakingTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@InjectMocks
	BlackCoffeeMaking blackCoffeeMaking;

	@Mock
	ContainerHandler containerHandler;

	@Mock
	Container containerMock;

	@Test
	public void shouldMakeOneCupOfCoffee() {

		when(containerHandler.getContainer()).thenReturn(containerMock);
		when(containerMock.getCoffeeQuantity()).thenReturn(1997);
		when(containerMock.getWaterQuantity()).thenReturn(14888);
		when(containerMock.getSugarQuantity()).thenReturn(7983);
		when(containerMock.getBlackCoffeeCost()).thenReturn(10);

		blackCoffeeMaking.makeDrinks(1);

		verify(containerMock, Mockito.times(2)).getCoffeeQuantity();
		verify(containerMock, Mockito.times(2)).getWaterQuantity();
		verify(containerMock, Mockito.times(2)).getSugarQuantity();
		verify(containerMock, Mockito.times(2)).getBlackCoffeeCost();

	}

	@Test
	public void shouldReturnExceptionWhenTeaIsEmpty() {

		when(containerHandler.getContainer()).thenReturn(containerMock);
		when(containerMock.getCoffeeQuantity()).thenReturn(0);
		when(containerMock.getWaterQuantity()).thenReturn(14500);
		when(containerMock.getSugarQuantity()).thenReturn(7983);

		exception.expect(EmptyContainerException.class);
		exception.expectMessage("Container is empty");
		blackCoffeeMaking.makeDrinks(100);

	}

	@Test
	public void shouldReturnExceptionWhenWaterIsEmpty() {

		when(containerHandler.getContainer()).thenReturn(containerMock);
		when(containerMock.getCoffeeQuantity()).thenReturn(1793);
		when(containerMock.getWaterQuantity()).thenReturn(0);
		when(containerMock.getSugarQuantity()).thenReturn(7983);

		exception.expect(EmptyContainerException.class);
		exception.expectMessage("Container is empty");
		blackCoffeeMaking.makeDrinks(50);

	}

	@Test
	public void shouldReturnExceptionWhenMilkIsEmpty() {

		when(containerHandler.getContainer()).thenReturn(containerMock);
		when(containerMock.getCoffeeQuantity()).thenReturn(1793);
		when(containerMock.getWaterQuantity()).thenReturn(4000);
		when(containerMock.getSugarQuantity()).thenReturn(7983);

		exception.expect(EmptyContainerException.class);
		exception.expectMessage("Container is empty");
		blackCoffeeMaking.makeDrinks(100);

	}

	@Test
	public void shouldReturnExceptionWhenSugarIsEmpty() {

		when(containerHandler.getContainer()).thenReturn(containerMock);
		when(containerMock.getCoffeeQuantity()).thenReturn(1793);
		when(containerMock.getWaterQuantity()).thenReturn(4000);
		when(containerMock.getSugarQuantity()).thenReturn(0);

		exception.expect(EmptyContainerException.class);
		exception.expectMessage("Container is empty");
		blackCoffeeMaking.makeDrinks(10);

	}

	@Test
	public void shouldReturnOneCoffeeContent() {
		when(containerMock.getCoffeeQuantity()).thenReturn(1995);
		when(containerMock.getWaterQuantity()).thenReturn(14977);
		when(containerMock.getSugarQuantity()).thenReturn(7983);

		when(containerMock.getBlackCoffeeCost()).thenReturn(10);
		when(containerMock.getTotalCost()).thenReturn(10);

		containerMock.getCoffeeQuantity();
		containerMock.getWaterQuantity();
		containerMock.getSugarQuantity();

		containerMock.getBlackCoffeeCost();
		containerMock.getTotalCost();

		verify(containerMock).getCoffeeQuantity();
		verify(containerMock).getWaterQuantity();
		verify(containerMock).getSugarQuantity();

	}

	@Test
	public void shouldReturnOneCoffeeWastage() {
		when(containerMock.getWastageCoffee()).thenReturn(0);
		when(containerMock.getWastageWater()).thenReturn(12);
		when(containerMock.getWastageSugar()).thenReturn(2);

		containerMock.getWastageCoffee();
		containerMock.getWastageSugar();
		containerMock.getWastageWater();

		verify(containerMock).getWastageCoffee();
		verify(containerMock).getWastageSugar();
		verify(containerMock).getWastageWater();

	}

}
