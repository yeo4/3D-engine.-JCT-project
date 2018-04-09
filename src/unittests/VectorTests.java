package unittests;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.Test;
import static org.junit.Assert.*;

import primitives.Point3D;
import primitives.Vector;

class VectorTests {

	
	public boolean tmp() {
		Vector v1 = new Vector(new Point3D(1, 8, 9));
		Vector v2 = new Vector(v1);
		Vector v3 = new Vector(new Point3D(99, 23, 7));

		if(v1.equals(v2)) {
			System.out.println("Test successful: "+v1.toString()+" == " + v2.toString());
		}else {
			System.out.println("Test failed: "+v1.toString()+" != " + v2.toString());
			return false;
		}
		System.out.println(v1.add(v2));
		if(v1.add(v2).equals(new Vector(new Point3D(2,16,18)))) {
			System.out.println("Test successful: "+v1.add(v2)+" == " + new Vector(new Point3D(2,16,18)));
		}else {
			System.out.println("Test failed: "+v1.add(v2)+" != " + new Vector(new Point3D(2,16,18)));
			return false;
		}
		if(v1.add(v3).equals(new Vector(new Point3D(100, 31, 16)))) {
			System.out.println("Test successful: "+v1.add(v3)+" == " + new Vector(new Point3D(100, 31, 16)));
		}else {
			System.out.println("Test failed: "+v1.add(v3)+" != " + new Vector(new Point3D(100, 31, 16)));
			return false;
		}
		Vector tmp = new Vector(new Point3D(-98,-15,2));
		if(v1.subtract(v3).equals(tmp)) {
			System.out.println("Test successful: "+v1.subtract(v3)+" == " + tmp);
		}else {
			System.out.println("Test failed: "+v1.subtract(v3)+" != " + tmp);
			return false;
		}
		 tmp = new Vector(new Point3D(-151.0,884.0,-769.0));
		 if(v1.cross_product(v3).equals(tmp)) {
			System.out.println("Test successful: "+v1.cross_product(v3)+" == " + tmp);
		}else {
			System.out.println("Test failed: "+v1.cross_product(v3)+" != " + tmp);
			return false;
		}
		tmp = new Vector(new Point3D(5.0,40.0,45.0));
		if(v1.multiply(5).equals(tmp)) {
			System.out.println("Test successful: "+v1.multiply(5)+" == " + tmp);
		}else {
			System.out.println("Test failed: "+v1.multiply(5)+" != " + tmp);
			return false;
		}
		
		
		System.out.println("/**dot_product**/");
		
		if(round(v1.dot_product(v2),3)  == 146) {
			System.out.println("Test successful: "+v1.dot_product(v2)+" == " + 146);
		}else {
			System.out.println("Test failed: "+v1.dot_product(v2)+" != " + 146);
			return false;
		}
		tmp = new Vector(new Point3D(0, -4, 0));
		if(round(tmp.dot_product(new Vector(new Point3D(0, 4, 0))),3) == -16) {
			System.out.println("Test successful: "+tmp.dot_product(new Vector(new Point3D(0, 4, 0)))+" == " + -16);
		}else {
			System.out.println("Test failed: "+tmp.dot_product(new Vector(new Point3D(0, 4, 0)))+" != " + -16);
			return false;
		}
		
		tmp = new Vector(new Point3D(0, 1, 0));
		if(round(tmp.dot_product(new Vector(new Point3D(1, 0, 0))),3) == 0) {
			System.out.println("Test successful: "+tmp.dot_product(new Vector(new Point3D(1, 0, 0)))+" == " + 0);
		}else {
			System.out.println("Test failed: "+tmp.dot_product(new Vector(new Point3D(1, 0, 0)))+" != " + 0);
			return false;
		}
		
		tmp = new Vector(new Point3D(1, 1, 0));
		if(round(tmp.dot_product(new Vector(new Point3D(1, 0, 0))),3) == 1) {
			System.out.println("Test successful: "+tmp.dot_product(new Vector(new Point3D(1, 0, 0)))+" == " + 1);
		}else {
			System.out.println("Test failed: "+tmp.dot_product(new Vector(new Point3D(1, 0, 0)))+" != " + 1);
			return false;
		}

		
		tmp = new Vector(new Point3D(-1, 1, 0));
		if(round(tmp.dot_product(new Vector(new Point3D(1, 0, 0))),3) == -1) {
			System.out.println("Test successful: "+tmp.dot_product(new Vector(new Point3D(1, 0, 0)))+" == " + -1);
		}else {
			System.out.println("Test failed: "+tmp.dot_product(new Vector(new Point3D(1, 0, 0)))+" != " + -1);
			return false;
		}
		return false;
	}
	@Test
	public void testAdd() {
		Vector v1 = new Vector(new Point3D(1, 8, 9));
		Vector v2 = new Vector(v1);
		Vector v3 = new Vector(new Point3D(99, 23, 7));
		
		Vector v4 = new Vector(new Point3D(97, 23, 7));
		Vector v5 = new Vector(new Point3D(43, 20, 2));
		Vector v6 = new Vector(new Point3D(99, 23, 7));

		
		assertEquals(v1.add(v2),new Vector(new Point3D(2,16,18)));
		assertEquals(v1.add(v3),new Vector(new Point3D(100, 31, 16)));
		
		assertNotEquals(v1.add(v4),new Vector(new Point3D(100, 31, 5)));
		assertNotEquals(v1.add(v5),new Vector(new Point3D(76, 20, 31)));
		assertNotEquals(v1.add(v6),new Vector(new Point3D(456, 1, 0.001)));
	}
	@Test
	public void testSubtract() {
		fail("Not yet implemented");
	}

	public double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}


}
