package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import primitives.Point3D;
import primitives.Vector;

public class MainForTests {

	public static void main(String[] args) {
		Vector v1 = new Vector(new Point3D(1, 8, 9));
		Vector v2 = new Vector(v1);
		Vector v3 = new Vector(new Point3D(99, 23, 7));
		Vector v7= new Vector(new Point3D(1, 8, 10));

	//	System.out.println(v1.subtract(v2));
	//	System.out.println(v1.subtract(v7));

		
		String Func = "multiply";
		String s = "" +
		"		Vector v1 = new Vector(new Point3D(1, 8, 9));\r\n" + 
		"		Vector v2 = new Vector(v1);\r\n" + 
		"		Vector v3 = new Vector(new Point3D(99, 23, 7));\r\n" + 
		"		\r\n" + 
		"		Vector v4 = new Vector(new Point3D("+Math.random()*100+", "+Math.random()*100+", "+Math.random()*100+"));\r\n" + 
		"		Vector v5 = new Vector(new Point3D("+Math.random()*100+", "+Math.random()*100+", "+Math.random()*100+"));\r\n" + 
		"		Vector v6 = new Vector(new Point3D("+Math.random()*100+", "+Math.random()*100+", "+Math.random()*100+"));\r\n" + 
		"		\r\n" + 
		"		assertEquals(v1."+Func+"("+Math.random()*100+"),new Vector(new Point3D(2,16,18)));\r\n" + 
		"		assertEquals(v1."+Func+"("+Math.random()*100+"),new Vector(new Point3D(100, 31, 16)));\r\n" + 
		"		\r\n" + 
		"		assertNotEquals(v1."+Func+"("+Math.random()*100+"),new Vector(new Point3D("+Math.random()*100+", "+Math.random()*100+", "+Math.random()*100+")));\r\n" + 
		"		assertNotEquals(v2."+Func+"("+Math.random()*100+"),new Vector(new Point3D("+Math.random()*100+", "+Math.random()*100+", "+Math.random()*100+")));\r\n" + 
		"		assertNotEquals(v4."+Func+"("+Math.random()*100+"),new Vector(new Point3D("+Math.random()*100+", "+Math.random()*100+", "+Math.random()*100+")));\r\n" + 
		"";
	//	System.out.println(s);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
