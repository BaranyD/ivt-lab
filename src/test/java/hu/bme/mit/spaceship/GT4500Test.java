package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class GT4500Test {

  private GT4500 ship;

  private TorpedoStore mockStore1;
  private TorpedoStore mockStore2;


  @BeforeEach
  public void init(){
    mockStore1 = mock(TorpedoStore.class);
    mockStore2 = mock(TorpedoStore.class);
    this.ship = new GT4500(mockStore1, mockStore2);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(mockStore1.fire(1)).thenReturn(true);
    when(mockStore1.fire(2)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);

    verify(mockStore1,times(1)).fire(1);
    verify(mockStore2,times(0)).fire(1);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(mockStore1.fire(1)).thenReturn(true);
    when(mockStore2.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);

    verify(mockStore1,times(1)).fire(1);
    verify(mockStore2,times(1)).fire(1);
  }

}
