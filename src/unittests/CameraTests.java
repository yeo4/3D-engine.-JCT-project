package unittests;
import elements.*;
import primitives.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class CameraTests {

	
	@Test
	public void testConstructRay() throws Exception {
		/*
		int Nx = 150;
		int Ny = 150;
		int i = 3;
		int j = 3;
		double screenDistance = 100;
		double screenWidth = 3;
		double screenHeight = 3;
		Point3D p = new Point3D(0,0,0);
		Point3D p1 = new Point3D(1,0,0);
		Vector v1 = new Vector(p1);
		Point3D p2 = new Point3D(0,1,0);
		Vector v2 = new Vector(p2);
		Camera c = new Camera(p,v1,v2);
		Ray r = c.constructRayThroughPixel( Nx, Ny, i, j, screenDistance, screenWidth, screenHeight);
		Point3D p4 = new Point3D(1/Math.sqrt(6), 1/Math.sqrt(6), -Math.sqrt(2/3));
		Vector v4 = new Vector(p4);
		assertEquals(r.getDirection().length(), 50*Math.sqrt(6));
		assertEquals(r.getDirection(), v4);
		*/
		final int WIDTH = 3;
		final int HEIGHT = 3;
		
		Point3D[][] screen = new Point3D [HEIGHT][WIDTH];
		
		Camera camera = new Camera(new Point3D(0.0 ,0.0 ,0.0), new Vector (0.0, 1.0, 0.0), new Vector (0.0, 0.0, -1.0));
		
		System.out.println("Camera:\n" + camera);
		
		for (int i = 0; i < HEIGHT; i++)
		{
			for (int j = 0; j < WIDTH; j++)
			{
				Ray ray = camera.constructRayThroughPixel(WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);
				
				screen[i][j] = ray.getP3D().add(ray.getDirection());
				System.out.print(screen[i][j]);
				System.out.println(ray.getDirection());
				
				// Checking z-coordinate
				/*if(Double.compare(screen[i][j].getZ().get(), -1.0) == 0)
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
					fail("Wrong x coordinate");*/
			}
			System.out.println("---");
		}
		
	}

}
