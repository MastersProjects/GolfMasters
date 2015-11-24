package ch.golfmasters.junit;
import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ch.golfmasters.listener.AddPointListener;

/**
 * JUnit Test für die Funktion check input
 * @author Chiramed Phong Penglerd, Elia Perenzin
 * @version 1.0
 */
@SuppressWarnings("deprecation")
@RunWith(Parameterized.class)
public class CheckPointInput {
	private static AddPointListener pointListener;
	private String point;
	private boolean result;
	
	public CheckPointInput(String point, boolean result) {
		this.point = point;
		this.result = result;
	}

	@BeforeClass
	  public static void setUpBeforeClass() throws Exception {
	    CheckPointInput.pointListener = new AddPointListener(null, null, 0, null, null, null, null, null, null, null);
	  }
	
	@AfterClass
	  public static void tearDownAfterClass() throws Exception {
		CheckPointInput.pointListener = null;
	  }

	@Parameters
	  public static Collection<Object[]> values() {
	    return Arrays.asList(new Object[][] {
	     {"8", false}, {"7", true}, {"6", true}, {"0", false}, {"-1", false}, {"abc", false}, {"10", false}, {"1", true}});
	  }

	@Test
	public void test() {
		Assert.assertEquals(pointListener.checkInput(point), result);
	}
}
