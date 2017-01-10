package jdbc.tests;


import java.sql.Driver;

import org.junit.Assert;
import org.junit.Test;
/**
 * @author Marc Magdi
 *
 */
public class IntegrationTest {

	public static Class<?> getSpecifications(){
		return Driver.class;
	}

	@Test
	public void test() {
		Assert.assertNotNull("Failed to create Driver implemenation",
					(Driver)TestRunner.getImplementationInstance());
	}

}
