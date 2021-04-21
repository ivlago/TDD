package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntervalTest {
  
  private Point left1 = new Point(-2.2);
  private Point right1 = new Point(4.4);
  private Point left2 = new Point(0.0);
  private Point right2 = new Point(5.0);
  private Point left3 = new Point(7.8);
  private Point right3 = new Point(10.6);

  private IntervalBuilder intervalBuilder;
  private IntervalBuilder intervalBuilder2;
  private IntervalBuilder intervalBuilder3;

  @BeforeEach
  public void before(){
    this.left1 = new Point(-2.2);
    this.right1 = new Point(4.4);
    this.intervalBuilder = new IntervalBuilder();
    this.left2 = new Point(0.0);
    this.right2 = new Point(5.0);
    this.intervalBuilder2 = new IntervalBuilder();
    this.left3 = new Point(7.8);
    this.right3 = new Point(10.6);
    this.intervalBuilder3 = new IntervalBuilder();
  }

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWithIncludedValueThenTrue() {
    Interval interval = this.intervalBuilder.open(left1.getEquals()).open(right1.getEquals()).build();
    assertFalse(interval.include(left1.getLess()));
    assertFalse(interval.include(left1.getEquals()));
    assertTrue(interval.include(left1.getGreater()));
    assertTrue(interval.include(right1.getLess()));
    assertFalse(interval.include(right1.getEquals()));
    assertFalse(interval.include(right1.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenInc3ludeWithIncludedValueThenTrue() {
    Interval interval = this.intervalBuilder.closed(left1.getEquals()).open(right1.getEquals()).build();
    assertFalse(interval.include(left1.getLess()));
    assertTrue(interval.include(left1.getEquals()));
    assertTrue(interval.include(left1.getGreater()));

    assertTrue(interval.include(right1.getLess()));
    assertFalse(interval.include(right1.getEquals()));
    assertFalse(interval.include(right1.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWit3hIncludedValueThenTrue() {
    Interval interval = this.intervalBuilder.open(left1.getEquals()).closed(right1.getEquals()).build();
    assertFalse(interval.include(left1.getLess()));
    assertFalse(interval.include(left1.getEquals()));
    assertTrue(interval.include(left1.getGreater()));

    assertTrue(interval.include(right1.getLess()));
    assertTrue(interval.include(right1.getEquals()));
    assertFalse(interval.include(right1.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWithInclude5dValueThenTrue() {
    Interval interval = this.intervalBuilder.closed(left1.getEquals()).closed(right1.getEquals()).build();
    assertFalse(interval.include(left1.getLess()));
    assertTrue(interval.include(left1.getEquals()));
    assertTrue(interval.include(left1.getGreater()));

    assertTrue(interval.include(right1.getLess()));
    assertTrue(interval.include(right1.getEquals()));
    assertFalse(interval.include(right1.getGreater()));
  }

}