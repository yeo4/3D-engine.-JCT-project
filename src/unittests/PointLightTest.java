package unittests;

import java.util.Date;

import org.junit.Test;

import elements.AmbientLight;
import elements.Camera;
import elements.PointLight;
import geometries.*;
import primitives.*;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class PointLightTest {
	@Test
	public void PointLightTestCircle(){
			int X = 500;
			int Y = 500;
			Date d = new Date();
			ImageWriter _imageWriter = new ImageWriter("PointLightTestCircle", X, Y, X, Y);
			Scene _scene = new Scene("s");
			_scene.setScreenDistance(50);
			_scene.setBackground(new Color(0,0,0));
			_scene.setCamera(new Camera(new Point3D(0,0,0), new Vector(0,1,0), new Vector(0,0,-1)));
			_scene.setAmbientLight(new AmbientLight(new Color(0,0,0), 1));
			
			_scene.addLight(new PointLight(new Color(255,175,255),new Point3D(-6,-6,0), 1, 0, 0));
			_scene.addGeometry(new Sphere(10, new Point3D(0,0, -15), new Color(30,0,100), new Material(1,1,10,0,0)));
			
		  	//_scene.addGeometry(new Triangle(new Point3D(0, -4, -4), new Point3D(4, 0, -4),new Point3D(4, -4, -4), new Color(30,100,30), new Material(1,1,1)));
		  	//_scene.addGeometry(new Triangle(new Point3D(0, -4, -4), new Point3D(4, 0, -4),new Point3D(4, -4, -4), new Color(30,100,30), new Material(1,1,1)));
		  	
			Render r = new Render(_imageWriter,_scene);

			r.renderImage();
			r.writeToImage();
			Date d2 = new Date();
			System.out.println(d2.getTime() - d.getTime());
			System.out.println("Finish");
	
	}
	
	@Test
	public void PointLightTestPlane(){
			int X = 500;
			int Y = 500;
			Date d = new Date();
			ImageWriter _imageWriter = new ImageWriter("PointLightTestPlane", X, Y, X, Y);
			Scene _scene = new Scene("s");
			_scene.setScreenDistance(50);
			_scene.setBackground(new Color(0,0,0));
			_scene.setCamera(new Camera(new Point3D(0,0,0), new Vector(0,1,0), new Vector(0,0,-1)));
			_scene.setAmbientLight(new AmbientLight(new Color(0,0,0), 1));
			
			_scene.addLight(new PointLight(new Color(255,255,255),new Point3D(0,0,0), 1, 0, 0.01));
			_scene.addGeometry(new Plane(new Point3D(0,0, -5), new Vector(0,0,-1), new Color(00,0,0), new Material(1,1,5,0,0)));
			
		  	//_scene.addGeometry(new Triangle(new Point3D(0, -4, -4), new Point3D(4, 0, -4),new Point3D(4, -4, -4), new Color(30,100,30), new Material(1,1,1)));
		  	//_scene.addGeometry(new Triangle(new Point3D(0, -4, -4), new Point3D(4, 0, -4),new Point3D(4, -4, -4), new Color(30,100,30), new Material(1,1,1)));
		  	
			Render r = new Render(_imageWriter,_scene);

			r.renderImage();
			r.writeToImage();
			Date d2 = new Date();
			System.out.println(d2.getTime() - d.getTime());
			System.out.println("Finish");
	
	}
}
