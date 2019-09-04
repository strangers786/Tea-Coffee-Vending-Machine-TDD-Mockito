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

import main.com.yash.BlackTeaMaking;
import main.com.yash.container.Container;
import main.com.yash.container.ContainerHandler;
import main.com.yash.exceptions.EmptyContainerException;

@RunWith(MockitoJUnitRunner.class)
public class BlackTeaMakingTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@InjectMocks
	BlackTeaMaking blackTeaMaking;

	@Mock
	ContainerHandler containerHandler;

	@Mock
	Container containerMock;

	@Test
	public void shouldMakeBlackTea() {

		when(containerHandler.getContainer()).thenReturn(containerMock);
		when(containerMock.getTeaQuantity()).thenReturn(1997);
		when(containerMock.getWaterQuantity()).thenReturn(14888);
		when(containerMock.getSugarQuantity()).thenReturn(7983);
		when(containerMock.getBlackTeaCost()).thenReturn(5);

		blackTeaMaking.makeDrinks(1);

		verify(containerMock, Mockito.times(1)).getTeaQuantity();
		verify(containerMock, Mockito.times(2)).getWaterQuantity();
		verify(containerMock, Mockito.times(2)).getSugarQuantity();
		verify(containerMock, Mockito.times(2)).getBlackTeaCost();

	}

	@Test
	public void shouldReturnExceptionWhenTeaIsEmpty() {

		when(containerHandler.getContainer()).thenReturn(containerMock);
		when(containerMock.getTeaQuantity()).thenReturn(0);
		when(containerMock.getWaterQuantity()).thenReturn(14935);
		when(containerMock.getSugarQuantity()).thenReturn(7983);

		exception.expect(EmptyContainerException.class);
		exception.expectMessage("Container is empty");
		blackTeaMaking.makeDrinks(100);

	}

	@Test
	public void shouldReturnExceptionWhenWaterIsEmpty() {

		when(containerHandler.getContainer()).thenReturn(containerMock);
		when(containerMock.getTeaQuantity()).thenReturn(1793);
		when(containerMock.getWaterQuantity()).thenReturn(0);
		when(containerMock.getSugarQuantity()).thenReturn(7983);

		exception.expect(EmptyContainerException.class);
		exception.expectMessage("Container is empty");
		blackTeaMaking.makeDrinks(50);

	}

	@Test
	public void shouldReturnExceptionWhenSugarIsEmpty() {

		when(containerHandler.getContainer()).thenReturn(containerMock);
		when(containerMock.getTeaQuantity()).thenReturn(1793);
		when(containerMock.getWaterQuantity()).thenReturn(4000);
		when(containerMock.getSugarQuantity()).thenReturn(0);

		exception.expect(EmptyContainerException.class);
		exception.expectMessage("Container is empty");
		blackTeaMaking.makeDrinks(10);

	}

	@Test
	public void shouldReturnOneCoffeeContent() {
		when(containerMock.getTeaQuantity()).thenReturn(1995);
		when(containerMock.getWaterQuantity()).thenReturn(14977);
		when(containerMock.getSugarQuantity()).thenReturn(7983);

		when(containerMock.getBlackTeaCost()).thenReturn(5);
		when(containerMock.getTotalCost()).thenReturn(5);

		containerMock.getTeaQuantity();
		containerMock.getWaterQuantity();
		containerMock.getSugarQuantity();

		containerMock.getBlackTeaCost();
		containerMock.getTotalCost();

		verify(containerMock).getTeaQuantity();
		verify(containerMock).getWaterQuantity();
		verify(containerMock).getSugarQuantity();

	}

	@Test
	public void shouldReturnOneCoffeeWastage() {
		when(containerMock.getWastageTea()).thenReturn(0);
		when(containerMock.getWastageWater()).thenReturn(12);
		when(containerMock.getWastageSugar()).thenReturn(2);

		containerMock.getWastageTea();
		containerMock.getWastageSugar();
		containerMock.getWastageWater();

		verify(containerMock).getWastageTea();
		verify(containerMock).getWastageSugar();
		verify(containerMock).getWastageWater();

	}

}