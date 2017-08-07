package jp.gr.java_conf.hangedman.rest.resources.v1;

import static org.junit.Assert.fail;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class EmployeesResourceTest extends JerseyTest {

	@Override
	protected Application configure() {
		return new ResourceConfig(EmployeesResource.class);
	}
	/**

	@Test
	public void testIndex() {
		System.out.println("START testIndex()");
		String response = target("employee").request().get(String.class);
		System.out.println(response);
		System.out.println("FINISH testIndex()");
	}
	 * @Test public void testShow() { fail("まだ実装されていません"); }
	 * 
	 * @Test public void testCreate() { fail("まだ実装されていません"); }
	 * 
	 * @Test public void testUpdate() { fail("まだ実装されていません"); }
	 * 
	 * @Test public void testDestroy() { fail("まだ実装されていません"); }
	 */
}
