package unittests;

import java.util.Date;

import org.junit.Test;

import elements.AmbientLight;
import elements.Camera;
import elements.PointLight;
import geometries.Cylinder;
import geometries.Sphere;
import geometries.XYboard;
import geometries.XZboard;
import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class FinalTest {

	@Test
	public void Final(){
		int X = 500;
		int Y = 500;
		Date d = new Date();
		ImageWriter _imageWriter = new ImageWriter("Final", X, Y, X, Y);
		Scene _scene = new Scene("s");
		_scene.setScreenDistance(300);
		_scene.set_aperatureRadius(5);
		_scene.set_focalLength(290);
		_scene.setBackground(new Color(0,0,0));
		_scene.setCamera(new Camera(new Point3D(0,0,0), new Vector(0,1,0), new Vector(0,0,-1)));
		_scene.setAmbientLight(new AmbientLight(new Color(0,0,0), 1));		
		
	
		_scene.addLight(new PointLight(new Color(40,255,40),new Point3D(200,0,0), 1, 0,0));
		
		Point3D ceilingP = new Point3D(0,800,0);
		
		_scene.addGeometry(new XZboard(new Point3D(0,-45,0), new Vector(0,1,0), new Color(0,0,0), new Material(1,0,20,0.3,0), new Color(30,30,30), new Color(100,100,100),40));
		_scene.addGeometry(new XZboard(ceilingP, new Vector(0,1,0), new Color(0,0,0), new Material(1,0,20,0,0), new Color(50,50,50), new Color(130,130,130),400));

		_scene.addGeometry(new XYboard(new Point3D(0,0,-3000), new Vector(0,0,1), new Color(0,0,0), new Material(0.5,0,20,0,0), new Color(20,20,20), new Color(70,70,70),400));

		
		 
		for(int i = 0, j = -170; i < 6; i++ ){
			double r = 60 + 10 * i;
			double y = 150 + 7*i;
			_scene.addGeometry(new Sphere(r, new Point3D(j, y,-350 - 400 * (i)), new Color(0, 0, 255), new Material(1, 0, 20, 0 ,0)));
			
			_scene.addGeometry(new Cylinder(8 + 2 * i, new Point3D(j, (ceilingP.getY().get() + y + r) / 2,-350 - 400 * (i)), new Vector(0,1,0), ceilingP.getY().get() - r - y, new Color(0, 0, 255), new Material(1, 0, 20, 0 ,0)));
			
			j = -155 + 25 * (i*i-1);
		}
		
		Render r = new Render(_imageWriter,_scene);

		r.renderImage();
		r.writeToImage();
		Date d2 = new Date();
		System.out.println(d2.getTime() - d.getTime());
		System.out.println("Finish");
	}
}
