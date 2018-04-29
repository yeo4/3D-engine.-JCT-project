package unittests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
            Triangle triangle = new Triangle(new Point3D(0, 1, -2),new Point3D(1, -1, -2),new Point3D(-1, -1, -2));
            Triangle triangle2 = new Triangle(new Point3D(0, 10, -2),new Point3D(1, -1, -2),new Point3D(-1, -1, -2));
            // special case test: one ray goes through a vertex and another through an edge of the triangle
            //so i expect ZERO intersection points
            Triangle triangle3 = new Triangle(new Point3D(3, 3, -1), new Point3D(2, 0, -1),new Point3D(4, 0, -1));
            // special case test: one ray is encompassed in triangle so i expect ZERO intersection points
            Triangle triangle4 = new Triangle(new Point3D(0, 0, -1), new Point3D(2, 0, -2),new Point3D(-2, 0, -2));
            
            List <Point3D> intersectionPointsTriangle = new ArrayList < Point3D > ();
            List <Point3D> intersectionPointsTriangle2 = new ArrayList < Point3D > ();
            List <Point3D> intersectionPointsTriangle3 = new ArrayList < Point3D > ();
            List <Point3D> intersectionPointsTriangle4 = new ArrayList < Point3D > ();
            
            System.out.println("Camera:\n " + camera);
                for (int i = 0; i < HEIGHT; i++) {
                    for (int j = 0; j < WIDTH; j++) {
                        rays[i][j] = camera.constructRayThroughPixel(WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);
                        List <Point3D> rayIntersectionPoints = triangle.findIntersections(rays[i][j]);
                        List <Point3D> rayIntersectionPoints2 = triangle2.findIntersections(rays[i][j]);
                        List <Point3D> rayIntersectionPoints3 = triangle3.findIntersections(rays[i][j]);
                        List <Point3D> rayIntersectionPoints4 = triangle4.findIntersections(rays[i][j]);
                        for (Point3D iPoint: rayIntersectionPoints)
                            intersectionPointsTriangle.add(iPoint);
                        for (Point3D iPoint: rayIntersectionPoints2)
                            intersectionPointsTriangle2.add(iPoint);
                        for (Point3D iPoint: rayIntersectionPoints3)
                            intersectionPointsTriangle3.add(iPoint);
                        for (Point3D iPoint: rayIntersectionPoints4)
                            intersectionPointsTriangle4.add(iPoint);
                    }
                }
                
                assertTrue(intersectionPointsTriangle.size() == 1); 
                assertTrue(intersectionPointsTriangle2.size() == 2);
                assertTrue(intersectionPointsTriangle3.size() == 0);
                assertTrue(intersectionPointsTriangle4.size() == 0);
    }
 }
