package unittests;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;
import static org.junit.Assert.*;

import primitives.Point3D;
import primitives.Vector;

public class VectorTests {	
	@Test
	public void testAdd() {
		
		Vector v1 = new Vector(new Point3D(1, 8, 9));
		Vector v2 = new Vector(v1);
		Vector v3 = new Vector(new Point3D(99, 23, 7));
		
		Vector v4 = new Vector(new Point3D(99, 23, 6));
		Vector v5 = new Vector(new Point3D(43, 20, 2));
		Vector v6 = new Vector(new Point3D(13, 16, 9));
		
		assertEquals(v1.add(v2),new Vector(new Point3D(2,16,18)));
		assertEquals(v1.add(v3),new Vector(new Point3D(100, 31, 16)));
		
		assertNotEquals(v1.add(v4),new Vector(new Point3D(100, 31, 5)));
		assertNotEquals(v2.add(v5),new Vector(new Point3D(76, 20, 31)));
		assertNotEquals(v4.add(v6),new Vector(new Point3D(456, 1, 0.001)));
	}
	@Test
	public void testSubtract() {
		Vector v1 = new Vector(new Point3D(1, 8, 9));
		Vector v2 = new Vector(v1);
		Vector v3 = new Vector(new Point3D(99, 23, 7));
		Vector v7= new Vector(new Point3D(1, 8, 10));

		//GOOD :)
		assertEquals(v1.subtract(v3),new Vector(new Point3D(-98,-15,2)));
		assertEquals(v1.subtract(v2),new Vector(new Point3D(0, 0, 0)));
		assertEquals(v1.subtract(v7),new Vector(new Point3D(0, 0, -1)));

		//Bad :(
		Vector v4 = new Vector(new Point3D(7.658219799672194, 58.456507400958614, 68.55669208791834));
		Vector v5 = new Vector(new Point3D(99.14289620008331, 33.205966061252724, 98.32520130644419));
		Vector v6 = new Vector(new Point3D(41.071748604250644, 84.58979024175107, 34.86594461045808));
		
		
		assertNotEquals(v1.subtract(v4),new Vector(new Point3D(98.62287282020971, 99.41815644944673, 51.949060534840065)));
		assertNotEquals(v2.subtract(v5),new Vector(new Point3D(52.06751846619897, 96.77522361647556, 13.087110079289276)));
		assertNotEquals(v4.subtract(v6),new Vector(new Point3D(41.99428706091619, 26.682322395630464, 58.195068177703305)));
	}

	
	@Test
	public void testScalling() {
		
		Vector tmp = new Vector(new Point3D(5.0,40.0,45.0));
		Vector v1 = new Vector(new Point3D(1, 8, 9));
		Vector v2 = new Vector(v1);
		Vector v3 = new Vector(new Point3D(99, 23, 7));
		Vector v4 = new Vector(new Point3D(99, 23, 6));
		Vector v5 = new Vector(new Point3D(43, 20, 2));
		Vector v6 = new Vector(new Point3D(13, 16, 9));
		Vector v7= new Vector(new Point3D(1, 8, 10));

		assertEquals(v1.multiply(5),tmp);
		assertEquals(v1.multiply(1),v1);
		assertEquals(v1.multiply(0),Vector.ZeroVector);

		assertNotEquals(v1.multiply(75.81810079780537),new Vector(new Point3D(17.652432270975428, 36.601357103894614, 32.088472979786374)));
		assertNotEquals(v2.multiply(5.386265390704937),new Vector(new Point3D(74.84379614629526, 69.3207443893657, 48.92079036530127)));
		assertNotEquals(v4.multiply(27.63651124744715),new Vector(new Point3D(28.028328003205782, 55.0166184298199, 62.103054375326415)));
	}
	
	
	@Test
	public void testDotProduct() {
		Vector v1 = new Vector(new Point3D(1, 8, 9));
		Vector v2 = new Vector(v1);
		Vector 	v4 = new Vector(new Point3D(0, -4, 0));
		Vector v5 = new Vector(new Point3D(0, 1, 0));
		Vector v6 = new Vector(new Point3D(1, 1, 0));
		Vector v7 = new Vector(new Point3D(-1, 1, 0));

		assertEquals(v1.dot_product(v2),146.0,0);
		assertEquals(v4.dot_product(new Vector(new Point3D(0, 4, 0))),-16.0,0);
		assertEquals(v5.dot_product(new Vector(new Point3D(0, 1, 0))),1.0,0);
		assertEquals(v6.dot_product(new Vector(new Point3D(1, 0, 0))),1.0,0);
		assertEquals(v7.dot_product(new Vector(new Point3D(1, 0, 0))),-1.0,0);
		
		assertNotEquals(v5.dot_product(new Vector(new Point3D(0, 1, 2))),0.0);
		assertNotEquals(v6.dot_product(new Vector(new Point3D(1, 0, 1))),8.0);
		assertNotEquals(v7.dot_product(new Vector(new Point3D(1, 0, 1))),-8.0);
	}
	
	@Test
	public void testLength() {
		Vector v1 = new Vector(new Point3D(1, 8, 9));
		Vector 	v4 = new Vector(new Point3D(0, -4, 0));
		Vector v5 = new Vector(new Point3D(0, 1, 0));
		Vector v6 = new Vector(new Point3D(1, 1, 0));
		Vector v7 = new Vector(new Point3D(-1, 1, 8));

		assertEquals(v1.length(),12.083045973594572,0.001);
		assertEquals(v4.length(),4.0,0);
		assertEquals(v5.length(),1.0,0);
		assertEquals(v6.length(),1.4142135623730951,0.001);
		assertEquals(v7.length(),8.12403840463596,0.001);
		
		assertNotEquals(v5.length(),1.1,0);
		assertNotEquals(v6.length(),7,0.001);
		assertNotEquals(v7.length(),99,0.001);
		
	}
	@Test
	public void testNormalize() {
		Vector v1 = new Vector(new Point3D(1, 8, 9));
		Vector 	v4 = new Vector(new Point3D(0, -4, 0));
		Vector v5 = new Vector(new Point3D(0, 1, 0));
		Vector v6 = new Vector(new Point3D(1, 1, 0));
		Vector v7 = new Vector(new Point3D(-1, 1, 8));

		assertEquals(v1.normalization(),new Vector(0.0827605888602368,0.6620847108818944,0.7448452997421311));
		assertEquals(v4.normalization(),new Vector(0.0,-1.0,0.0));
		assertEquals(v5.normalization(),new Vector(0.0,1.0,0.0));
		assertEquals(v6.normalization(),new Vector(0.7071067811865475,0.7071067811865475,0.0));
		assertEquals(v7.normalization(),new Vector(-0.12309149097933272,0.12309149097933272,0.9847319278346618));

		assertNotEquals(v1.normalization(),new Vector(0.8,0.7,1.1));
		assertNotEquals(v4.normalization(),new Vector(0.0,-1.0,1.0));

	}
	@Test
	public void testCrossProduct() {
		Vector v1 = new Vector(new Point3D(1, 8, 9));
		Vector 	v4 = new Vector(new Point3D(0, -4, 0));
		Vector v5 = new Vector(new Point3D(0, 1, 0));
		Vector v6 = new Vector(new Point3D(1, 1, 0));
		Vector v7 = new Vector(new Point3D(-1, 1, 8));

		assertEquals(v1.cross_product(v4),new Vector(36,0,-4));
		assertEquals(v4.cross_product(v7),new Vector(-32,0,-4));
		assertEquals(v5.cross_product(v4),new Vector(0,0,0));
		assertEquals(v1.cross_product(v5),new Vector(-9,0,1.0));
		assertEquals(v7.cross_product(v6),new Vector(-8,8,-2));
		assertEquals(v4.cross_product(v4),new Vector(0,0,0));

		
		assertNotEquals(v5.cross_product(v4),new Vector(0,5,0));
		assertNotEquals(v1.cross_product(v5),new Vector(9,0,1.0));
		assertNotEquals(v7.cross_product(v6),new Vector(8,8,-2));

		
	}

}
