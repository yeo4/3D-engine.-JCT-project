package tests;
import java.math.BigDecimal;
import java.math.RoundingMode;

import primitives.*;

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
		System.out.println("/********************Point3DTest*****************/");
		if(!Point3DTest()) {
			System.err.println("Error test in Point3DTest");
		}else {
			System.err.println("Point3DTest was good");
		}
		System.out.println("/********************RayTest*****************/");
		if(!RayTest()) {
			System.err.println("Error test in RayTest");
		}else {
			System.err.println("RayTest was good");
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
		Point3D P1 = new Point3D(1,2,4);
		Point3D P2 = new Point3D(P1);
		Point3D P3 = new Point3D(9,8,12);
		
		if(P1.equals(P2)) {
			System.out.println("Test successful: [1,2,4] == [1,2,4]");
		}else {
			System.out.println("Test failed: [1,2,4] != [1,2,4]");
			return false;
		}
		if(round(P1.distance(P3),3) == 12.806) {
			System.out.println("Test successful: [1,2,4] <---> [9,8,12] ~= 12.806");
		}else {
			System.out.println("Test failed: [1,2,4] <---> [9,8,12] !~ 12.806");
			return false;
		}
		
		Vector v = new Vector(new Point3D(5, 6, 7));
		if(P1.add(v).equals(new Point3D(6,8,11))) {
			System.out.println("Test successful: (1,2,4) + [(5,6,7)] == (6,8,11)");
		}else {
			System.out.println("Test failed: (1,2,4) + [(5,6,7)] != (6,8,11)");
			return false;
		}
		if(P1.subtract(new Point3D(1,2,3)).equals(new Vector(new Point3D(0, 0, 1)))) {
			System.out.println("Test successful: (1,2,4) - [(1,2,3)] == (0,0,1)");
		}else {
			System.out.println("Test failed: (1,2,4) - [(1,2,3)] != (0,0,1)");
			return false;
		}
		return true;
	}
	private static boolean RayTest() {
		Ray r1 = new Ray(new Point3D(1,2,3), new Vector(new Point3D(2,3,4)));
		Ray r2 = new Ray(r1);
		if(r1.equals(r2)) {
			System.out.println("Test successful: "+r1.toString()+" == " + r1.toString());
		}else {
			System.out.println("Test failed: "+r1.toString()+" != " + r1.toString());
			return false;
		}

		return true;
	}
	private static boolean VectorTest() {
		return true;
	}
	
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
