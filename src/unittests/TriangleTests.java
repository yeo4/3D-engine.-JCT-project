package unittests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Test;

import elements.*;
import geometries.*;
import primitives.*;

public class TriangleTests {

    @Test
    public void TriangleIntersectionPointsTest() throws Exception {
            final int WIDTH = 3;
            final int HEIGHT = 3;
            Ray[][] rays = new Ray[HEIGHT][WIDTH];
            Camera camera = new Camera(new Point3D(0.0, 0.0, 0.0),
                new Vector(0.0, 1.0, 0.0),
                new Vector(0.0, 0.0, -1.0));
            Point3D a = new Point3D(0, 1, -2);
            Point3D b = new Point3D(1, -1, -2);
            Point3D c = new Point3D(-1, -1, -2);

            Triangle triangle = new Triangle(a,b,c);
            Triangle triangle2 = new Triangle(new Point3D(0, 10, -2),new Point3D(1, -1, -2),new Point3D(-1, -1, -2));
            List <Point3D> intersectionPointsTriangle = new ArrayList < Point3D > ();
            List <Point3D> intersectionPointsTriangle2 = new ArrayList < Point3D > ();
            System.out.println("Camera:\n " + camera);
                for (int i = 0; i < HEIGHT; i++) {
                    for (int j = 0; j < WIDTH; j++) {
                        rays[i][j] = camera.constructRayThroughPixel(WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);
                        List <Point3D> rayIntersectionPoints = triangle.findIntersections(rays[i][j]);
                        List <Point3D> rayIntersectionPoints2 = triangle2.findIntersections(rays[i][j]);
                        for (Point3D iPoint: rayIntersectionPoints)
                            intersectionPointsTriangle.add(iPoint);
                        for (Point3D iPoint: rayIntersectionPoints2)
                            intersectionPointsTriangle2.add(iPoint);
                    }
                }
                System.out.println("intersectionPointsTriangle.size()" + intersectionPointsTriangle.size());
                assertTrue(intersectionPointsTriangle.size() == 1); 
                System.out.println("intersectionPointsTriangle2.size()" + intersectionPointsTriangle2.size());
                assertTrue(intersectionPointsTriangle2.size() == 2); 
                System.out.println("Intersection Points:");
                for (Point3D iPoint: intersectionPointsTriangle)
                    System.out.println(iPoint); System.out.println("--");
                    for (Point3D iPoint: intersectionPointsTriangle2)
                        System.out.println(iPoint);
                }
 }
