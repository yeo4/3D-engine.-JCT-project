package unittests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CameraTests.class, CoordinateTests.class, VectorTests.class })
public class AllTests {

}
