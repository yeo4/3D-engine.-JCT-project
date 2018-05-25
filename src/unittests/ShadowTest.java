package unittests;

import java.util.Date;

import org.junit.Test;

import elements.AmbientLight;
import elements.Camera;
import elements.PointLight;
import elements.SpotLight;
import geometries.*;
import primitives.*;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class ShadowTest {
	@Test
	public void ShadowTest(){
			int X = 500;
			int Y = 500;
			Date d = new Date();
			ImageWriter _imageWriter = new ImageWriter("ShadowTest", X, Y, X, Y);
			Scene _scene = new Scene("s");
			_scene.setScreenDistance(50);
			_scene.setBackground(new Color(0,0,0));
			_scene.setCamera(new Camera(new Point3D(0,0,0), new Vector(0,1,0), new Vector(0,0,-1)));
			_scene.setAmbientLight(new AmbientLight(new Color(0,0,0), 1));
			
			_scene.addLight(new PointLight(new Color(255,175,255),new Point3D(-6,-6,0), 1, 0, 0));
			_scene.addGeometry(new Sphere(3, new Point3D(0,0, -6), new Color(30,0,100), new Material(1,1,10)));
			_scene.addGeometry(new Plane(new Point3D(0,0,-10),new Vector(0,0,-1),new Color(0,0,0), new Material(1,1,10)));
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
	  public void shadowTest() {
	    Scene _scene = new Scene("Test shadow");
	    _scene.setCamera(new Camera( new Point3D(0, 0, 0),new Vector(0, -1, 0), new Vector(0, 0, 1)));
	    _scene.setScreenDistance(100);
	    _scene.setBackground(new Color(0,0,0));
	    _scene.setAmbientLight(new AmbientLight(new Color(0,0,0), 1));
	    Sphere sphere = new Sphere( 60,new Point3D(0, 0, 80), new Color(241, 6, 151),new Material(0.9,0.8,300));
	    Triangle triangle1 = new Triangle(new Point3D(-250,-250,120),new Point3D(-250,250,120),new Point3D(250,-250,120),new Color(0,0,0),new Material(0.9, 0.8, 100));
	    Triangle triangle2 = new Triangle(new Point3D(250,250,120),new Point3D(-250,250,120),new Point3D(250,-250,120),new Color(0,0,0),new Material(0.9, 0.8, 100));
	    _scene.addGeometry(sphere);
	    _scene.addGeometry(triangle1);
	    _scene.addGeometry(triangle2);
	    _scene.addLight(new SpotLight( new Color(255,255,255),new Point3D(25,0,0),1,0,0, new Vector(-25,0,80)));
	    ImageWriter imageWriter = new ImageWriter("shadow test", 500, 500, 500, 500);
	    Render testRender = new Render(imageWriter, _scene);
	    testRender.renderImage();
	    testRender.writeToImage();
	    
	  }
}
