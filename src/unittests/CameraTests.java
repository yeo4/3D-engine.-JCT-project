package unittests;
import elements.*;
import primitives.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class CameraTests {

	
	@Test
	public void testConstructRay() throws Exception  {
		final int WIDTH = 3;
		final int HEIGHT = 3;
		
		Point3D[][] screen = new Point3D [HEIGHT+1][WIDTH+1];
		
		Camera camera = new Camera(new Point3D(0.0 ,0.0 ,0.0), new Vector (0.0, 1.0, 0.0), new Vector (0.0, 0.0, -1.0));
		
		System.out.println("Camera:\n" + camera);
		
		for (int i = 1; i < HEIGHT + 1; i++)
		{
			for (int j = 1; j < WIDTH + 1; j++)
			{
				Ray ray = camera.constructRayThroughPixel(WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);
				
				screen[i][j] = ray.getP3D().add(ray.getDirection());
				System.out.print(screen[i][j]);
				System.out.println(ray.getDirection());
				
				//Checking z-coordinate
				if(Double.compare(screen[i][j].getZ().get(), -1.0) == 0)
			 		assertTrue(true);
				else
					fail("Wrong z coordinate" + screen[i][j].getZ().get() );
				
				// Checking all options
				double x = screen[i][j].getX().get();
				double y = screen[i][j].getX().get();
				
				if (Double.compare(x, 3) == 0 || Double.compare(x, 0) == 0 || Double.compare(x, -3) == 0){
					if (Double.compare(y, 3) == 0 || Double.compare(y, 0) == 0 || Double.compare(y, -3) == 0){
						assertTrue(true);
					}
					else
						fail("Wrong y coordinate");
				} else
					fail("Wrong x coordinate");
			}
			System.out.println("---");
		}
		
	}

}
