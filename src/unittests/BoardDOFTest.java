package unittests;

import java.util.Date;

import org.junit.Test;

import elements.AmbientLight;
import elements.Camera;
import elements.PointLight;
import elements.SpotLight;
import geometries.*;
import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class BoardDOFTest {
	@Test
	public void BoardDOFT(){
			int X = 500;
			int Y = 500;
			Date d = new Date();
			ImageWriter _imageWriter = new ImageWriter("BoardDOFT", X, Y, X, Y);
			Scene _scene = new Scene("s");
			_scene.setScreenDistance(300);
			_scene.set_aperatureRadius(10);
			_scene.set_focalLength(200);
			_scene.setBackground(new Color(0,0,0));
			_scene.setCamera(new Camera(new Point3D(0,0,0), new Vector(0,1,0), new Vector(0,0,-1)));
			_scene.setAmbientLight(new AmbientLight(new Color(0,0,0), 1));
			
			_scene.addLight(new PointLight(new Color(100,30,30),new Point3D(0,1000,0), 1, 0,0));

			
			_scene.addGeometry(new XZboard(new Point3D(0,-200,0), new Vector(0,1,0), new Color(0,0,0), new Material(0.5,1,20,0,0), new Color(0,0,0), new Color(55,55,55),150));
			
			_scene.addGeometry(new Sphere(30, new Point3D(-90, 0, -200), new Color(150, 0, 100), new Material(1, 1, 20, 0, 0.2)));
			_scene.addGeometry(new Cylinder(50, new Point3D(-90, 0, -200), new Vector(0,1,0), 120 , new Color(100, 0, 200), new Material(1, 1, 20, 0, 0.5)));
			
			
			
			Render r = new Render(_imageWriter,_scene);

			r.renderImage();
			r.writeToImage();
			Date d2 = new Date();
			System.out.println(d2.getTime() - d.getTime());
			System.out.println("Finish");
	}
}
