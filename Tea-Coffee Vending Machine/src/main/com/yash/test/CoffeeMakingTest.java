package main.com.yash.test;

import static org.junit.Assert.assertFalse;
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

import main.com.yash.CoffeeMaking;
import main.com.yash.container.Container;
import main.com.yash.container.ContainerHandler;
import main.com.yash.exceptions.EmptyContainerException;

@RunWith(MockitoJUnitRunner.class)
public class CoffeeMakingTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@InjectMocks
	CoffeeMaking coffeeMaking;

	@Mock
	ContainerHandler containerHandler;

	@Mock
	Container containerMock;

	@Test
	public void shouldMakeCoffee() {

		when(containerHandler.getContainer()).thenReturn(containerMock);
		when(containerMock.getCoffeeQuantity()).thenReturn(1995);
		when(containerMock.getMilkQuantity()).thenReturn(9912);
		when(containerMock.getWaterQuantity()).thenReturn(14977);
		when(containerMock.getSugarQuantity()).thenReturn(7983);
		when(containerMock.getCoffeeCost()).thenReturn(15);

		coffeeMaking.makeDrinks(1);

		verify(containerMock, Mockito.times(2)).getCoffeeQuantity();
		verify(containerMock, Mockito.times(2)).getMilkQuantity();
		verify(containerMock, Mockito.times(2)).getWaterQuantity();
		verify(containerMock, Mockito.times(2)).getSugarQuantity();
		verify(containerMock, Mockito.times(2)).getCoffeeCost();

	}

	@Test
	public void shouldReturnExceptionWhenTeaIsEmpty() {

		when(containerHandler.getContainer()).thenReturn(containerMock);
		when(containerMock.getCoffeeQuantity()).thenReturn(0);
		when(containerMock.getMilkQuantity()).thenReturn(9956);
		when(containerMock.getWaterQuantity()).thenReturn(14935);
		when(containerMock.getSugarQuantity()).thenReturn(7983);

		exception.expect(EmptyContainerException.class);
		exception.expectMessage("Container is empty");
		coffeeMaking.makeDrinks(100);

	}

	@Test
	public void shouldReturnExceptionWhenWaterIsEmpty() {

		when(containerHandler.getContainer()).thenReturn(containerMock);
		when(containerMock.getCoffeeQuantity()).thenReturn(1793);
		when(containerMock.getMilkQuantity()).thenReturn(4000);
		when(containerMock.getWaterQuantity()).thenReturn(0);
		when(containerMock.getSugarQuantity()).thenReturn(7983);

		exception.expect(EmptyContainerException.class);
		exception.expectMessage("Container is empty");
		coffeeMaking.makeDrinks(50);

	}

	@Test
	public void shouldReturnExceptionWhenMilkIsEmpty() {

		when(containerHandler.getContainer()).thenReturn(containerMock);
		when(containerMock.getCoffeeQuantity()).thenReturn(1793);
		when(containerMock.getMilkQuantity()).thenReturn(0);
		when(containerMock.getWaterQuantity()).thenReturn(4000);
		when(containerMock.getSugarQuantity()).thenReturn(7983);

		exception.expect(EmptyContainerException.class);
		exception.expectMessage("Container is empty");
		coffeeMaking.makeDrinks(100);

	}

	@Test
	public void shouldReturnExceptionWhenSugarIsEmpty() {

		when(containerHandler.getContainer()).thenReturn(containerMock);
		when(containerMock.getCoffeeQuantity()).thenReturn(1793);
		when(containerMock.getMilkQuantity()).thenReturn(2000);
		when(containerMock.getWaterQuantity()).thenReturn(4000);
		when(containerMock.getSugarQuantity()).thenReturn(0);

		exception.expect(EmptyContainerException.class);
		exception.expectMessage("Container is empty");
		coffeeMaking.makeDrinks(10);

	}

	@Test
	public void shouldReturnOneCoffeeContent() {
		when(containerMock.getCoffeeQuantity()).thenReturn(1995);
		when(containerMock.getMilkQuantity()).thenReturn(9912);
		when(containerMock.getWaterQuantity()).thenReturn(14977);
		when(containerMock.getSugarQuantity()).thenReturn(7983);

		when(containerMock.getCoffeeCost()).thenReturn(15);
		when(containerMock.getTotalCost()).thenReturn(15);

		containerMock.getCoffeeQuantity();
		containerMock.getMilkQuantity();
		containerMock.getWaterQuantity();
		containerMock.getSugarQuantity();

		containerMock.getCoffeeCost();
		containerMock.getTotalCost();

		verify(containerMock).getCoffeeQuantity();
		verify(containerMock).getMilkQuantity();
		verify(containerMock).getWaterQuantity();
		verify(containerMock).getSugarQuantity();

	}

	@Test
	public void shouldReturnOneCoffeeWastage() {
		when(containerMock.getWastageCoffee()).thenReturn(1);
		when(containerMock.getWastageMilk()).thenReturn(8);
		when(containerMock.getWastageWater()).thenReturn(3);
		when(containerMock.getWastageSugar()).thenReturn(2);

		containerMock.getWastageCoffee();
		containerMock.getWastageMilk();
		containerMock.getWastageSugar();
		containerMock.getWastageWater();

		verify(containerMock).getWastageCoffee();
		verify(containerMock).getWastageMilk();
		verify(containerMock).getWastageSugar();
		verify(containerMock).getWastageWater();

	}

}
