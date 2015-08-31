package OSS.client;

import com.google.gwt.junit.client.GWTTestCase;

public class SandboxGwtTest extends GWTTestCase {
    @Override
    public String getModuleName() {
        return "OSS.Project";
    }

    public void testSandbox() {
        assertTrue(true);
    }
}
