/**
 *
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The Class ModelTest.
 *
 * @author Jean-Aymeric Diet
 */
public class ModelTest {
	private Model model;

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Tear down after class.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@Before
	public void setUp() throws Exception {
		this.model = new Model();
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link model.Model#getMessage()}.
	 */
	@Test
	public void testGetMessage() {
		Assert.assertEquals("", this.model.getMessage());
	}

	/**
	 * Test method for {@link model.Model#loadMessage(java.lang.String)}.
	 */
	@Test
	public void testGetMessageString() {
		this.model.loadMessage("01");
		Assert.assertEquals("O------------------O\nIVVVVVVVVVVVVVVVVVVI\nIVVV@VVVVVVVVVQVVVVI\nIVVVVVVVVVVVVVVVVVVI\nIVVVVVVVVVVVVVVVVVVI\nIVVVVVVVVVVVVVVVVVVI\nI1OOOOVVVVVVVVVVVVVI\nI1OAVOVVVVVVVVVVVVVI\nI1OBVOVVVVVVVVYVVVVI\nI1OCVOVVVVVVVVVVVVVI\nI1ODVOVVVVVVVVVVVVVI\nO-OOOO-------------O", this.model.getMessage());
		this.model.loadMessage("02");
		Assert.assertEquals("VVVVVVVVVVVVVVO---OVVVVVVVVVVVVVVVIVVVOOO-------O-----OVVVVIIVV1VVVVOVVVVVVVVVVIIV1DVVVVQVVVVVVVV@VYIVV1VVVVOVVVVVVVVVVIO-------O-----OVVVVIVVVVVVVVVVVVVVIVVVOOVVVVIVVIVVVVVVO---OVVVVVIVVIVVVVVVVVVVVVVVOVVVVVVOVVVVVVVVVVVVVOOOOOOVVVVVVVVVVV", this.model.getMessage());
		this.model.loadMessage("03");
		Assert.assertEquals("O------------------OIV@VVVVVVVVVVVVVVVVIO----------------OVIIVVVVVVVVVVVVVVVVVVIIVVVO--------------OIVVVYVVVVVVVVVVVVVVVIVVVO--------------OIVVVIVVVVVVVVVVVBVVIIVVV1VVVVVVVVVVVVVVIOOVVI11O----1------OVO--O--OQVVVVVVVVAVIVVVVVVVO-----------O", this.model.getMessage());
		this.model.loadMessage("04");
		Assert.assertEquals("O-------OO---OOOOOOVIVVVVVVVOVVAVVVVOOOOIVVVVVVVOVVVOOOOO--OIVVOOOVVOOVVOVVVVVVOOOOOVVVVVOVV1VOOVVVOOV1OVVVVVOOOOOOVVVIOIVVVVVVVOOVVVVVVVVIOIVVVVOOOOVVBVVVVOOOOIVVVOOVVVVVOOVVVVVVIIVVVVVVVVVVOOOVVVVVIOOVVVVVVOVV1YOOVVVQIVOOO----OOOOOOOO---O", this.model.getMessage());
		this.model.loadMessage("05");
		Assert.assertEquals("VVO--------------OVVVOOVVVVVVAQVOOVVVOOVOO1VVVVVVVVVOOVVV1OOIVVVVVOOVVVVVVVVVVVIIVVVVVOOVVVVVVVVVVVIIVVVVVVVVVVVVVVOOVVIIDVVVVVVVV@VVVVOOVBIIVVVVOOVVVVVVVVVVVVIIVVVVOOVVVVVOOVVVVVIOO1VVVVVVVVVOOVVV1OOVOOVVVVVVVCYVVVVVOOVVVO--------------OVV", this.model.getMessage());
	}

}
