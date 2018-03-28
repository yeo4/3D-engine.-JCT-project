package tests;
import primitives.Coordinate;
import primitives.Point2D;
import primitives.Point3D;
import primitives.Vector;

public class FirstMainTestPrimitives {

	public static void main(String[] args) {
		System.out.println("/********************CoordinateTest*****************/");
		if(!CoordinateTest()) {
			System.err.println("Error test in CoordinateTest");
		}else {
			System.err.println("CoordinateTest was good");
		}
		System.out.println("/********************Point2DTest*****************/");
		if(!Point2DTest()) {
			System.err.println("Error test in Point2DTest");
		}else {
			System.err.println("Point2DTest was good");
		}
	}
	private static boolean CoordinateTest() {
		Coordinate c1 = new Coordinate(5);
		System.out.println("Coordinate: " + c1);

		Coordinate c2 = new Coordinate(6);

		if (c1.equals(c2)) {
			System.out.println("Test failed: 5 == 6");
			return false;
		}
		else {
			System.out.println("Test successful: 5 != 6");
		}

		Coordinate c3 = new Coordinate(5.0000000001);
		if (c1.equals(c3))
			System.out.println("Test successful: 5 == 5");
		else {
			System.out.println("Test failed: 5 != 5");
				return false;
		}
		
		return true;
	}
	private static boolean Point2DTest() {
		Point2D P1 = new Point2D(1,2);
		Point2D P2 = new Point2D(P1);
		Point2D P3 = new Point2D(9,8);

		if(P1.equals(P2)) {
			System.out.println("Test successful: [1,2] == [1,2]");
		}else {
			System.out.println("Test failed: [1,2] != [1,2]");
			return false;
		}
		if(P1.distance(P3) == 10) {
			System.out.println("Test successful: [1,2] <---> [9,8] == 10");
		}else {
			System.out.println("Test successful: [1,2] <---> [9,8] == 10");
			return false;
		}
		return true;
	}
	private static boolean Point3DTest() {
		return true;
	}
	private boolean RayTest() {
		return true;
	}
	private boolean VectorTest() {
		return true;
	}
	
}
