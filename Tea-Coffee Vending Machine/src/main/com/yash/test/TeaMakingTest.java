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

import main.com.yash.TeaMaking;
import main.com.yash.container.Container;
import main.com.yash.container.ContainerHandler;
import main.com.yash.exceptions.EmptyContainerException;

@RunWith(MockitoJUnitRunner.class)
public class TeaMakingTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@InjectMocks
	TeaMaking teaMaking;

	@Mock
	ContainerHandler containerHandler;

	@Mock
	Container containerMock;

	@Test
	public void shouldMakeOneCupOfTea() {

		when(containerHandler.getContainer()).thenReturn(containerMock);
		when(containerMock.getTeaQuantity()).thenReturn(1994);
		when(containerMock.getMilkQuantity()).thenReturn(9956);
		when(containerMock.getWaterQuantity()).thenReturn(14935);
		when(containerMock.getSugarQuantity()).thenReturn(7983);
		when(containerMock.getTeaCost()).thenReturn(10);

		teaMaking.makeDrinks(1);

		verify(containerMock, Mockito.times(1)).getTeaQuantity();
		verify(containerMock, Mockito.times(3)).getMilkQuantity();
		verify(containerMock, Mockito.times(2)).getWaterQuantity();
		verify(containerMock, Mockito.times(1)).getSugarQuantity();
		verify(containerMock, Mockito.times(2)).getTeaCost();

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
		teaMaking.makeDrinks(100);

	}

	@Test
	public void shouldReturnExceptionWhenWaterIsEmpty() {

		when(containerHandler.getContainer()).thenReturn(containerMock);
		when(containerMock.getTeaQuantity()).thenReturn(1793);
		when(containerMock.getMilkQuantity()).thenReturn(4000);
		when(containerMock.getWaterQuantity()).thenReturn(0);
		when(containerMock.getSugarQuantity()).thenReturn(7983);

		exception.expect(EmptyContainerException.class);
		exception.expectMessage("Container is empty");
		teaMaking.makeDrinks(50);

	}

	@Test
	public void shouldReturnExceptionWhenMilkIsEmpty() {

		when(containerHandler.getContainer()).thenReturn(containerMock);
		when(containerMock.getTeaQuantity()).thenReturn(1793);
		when(containerMock.getMilkQuantity()).thenReturn(0);
		when(containerMock.getWaterQuantity()).thenReturn(4000);
		when(containerMock.getSugarQuantity()).thenReturn(7983);

		exception.expect(EmptyContainerException.class);
		exception.expectMessage("Container is empty");
		teaMaking.makeDrinks(100);

	}

	@Test
	public void shouldReturnExceptionWhenSugarIsEmpty() {

		when(containerHandler.getContainer()).thenReturn(containerMock);
		when(containerMock.getTeaQuantity()).thenReturn(1793);
		when(containerMock.getMilkQuantity()).thenReturn(2000);
		when(containerMock.getWaterQuantity()).thenReturn(4000);
		when(containerMock.getSugarQuantity()).thenReturn(0);

		exception.expect(EmptyContainerException.class);
		exception.expectMessage("Container is empty");
		teaMaking.makeDrinks(10);

	}

	@Test
	public void shouldRefillTeaContainer() {

		when(containerHandler.getContainer()).thenReturn(containerMock);
		when(containerMock.getTeaQuantity()).thenReturn(1994);
		when(containerMock.getMilkQuantity()).thenReturn(9956);
		when(containerMock.getWaterQuantity()).thenReturn(14935);
		when(containerMock.getSugarQuantity()).thenReturn(7983);

		teaMaking.makeDrinks(1);
		containerHandler.refillContainer(1);

		verify(containerMock, Mockito.times(1)).getTeaQuantity();
		verify(containerMock, Mockito.times(3)).getMilkQuantity();
		verify(containerMock, Mockito.times(2)).getWaterQuantity();
		verify(containerMock, Mockito.times(1)).getSugarQuantity();

	}

	@Test
	public void shouldReturnOneTeaContent() {
		when(containerMock.getCoffeeQuantity()).thenReturn(1994);
		when(containerMock.getMilkQuantity()).thenReturn(9956);
		when(containerMock.getWaterQuantity()).thenReturn(14935);
		when(containerMock.getSugarQuantity()).thenReturn(7983);

		when(containerMock.getTeaCost()).thenReturn(10);
		when(containerMock.getTotalCost()).thenReturn(10);

		containerMock.getCoffeeQuantity();
		containerMock.getMilkQuantity();
		containerMock.getWaterQuantity();
		containerMock.getSugarQuantity();

		containerMock.getTeaCost();
		containerMock.getTotalCost();

		verify(containerMock).getCoffeeQuantity();
		verify(containerMock).getMilkQuantity();
		verify(containerMock).getWaterQuantity();
		verify(containerMock).getSugarQuantity();

	}

	@Test
	public void shouldReturnOneTeaWastage() {
		when(containerMock.getWastageTea()).thenReturn(5);
		when(containerMock.getWastageMilk()).thenReturn(1);
		when(containerMock.getWastageWater()).thenReturn(4);
		when(containerMock.getWastageSugar()).thenReturn(2);

		containerMock.getWastageTea();
		containerMock.getWastageMilk();
		containerMock.getWastageSugar();
		containerMock.getWastageWater();

		verify(containerMock).getWastageTea();
		verify(containerMock).getWastageMilk();
		verify(containerMock).getWastageSugar();
		verify(containerMock).getWastageWater();

	}

}
