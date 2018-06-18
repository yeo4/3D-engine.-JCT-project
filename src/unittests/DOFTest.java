package unittests;

import java.util.Date;

import org.junit.Test;

import elements.AmbientLight;
import elements.Camera;
import elements.PointLight;
import geometries.Rectangle;
import geometries.Sphere;
import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class DOFTest {
	@Test
	public void Dof(){
			int X = 500;
			int Y = 500;
			Date d = new Date();
			ImageWriter _imageWriter = new ImageWriter("Dof", X, Y, X, Y);
			Scene _scene = new Scene("s");
			_scene.setScreenDistance(500);
			_scene.setBackground(new Color(0,0,0));
			_scene.setCamera(new Camera(new Point3D(0,0,0), new Vector(0,1,0), new Vector(0,0,-1)));
			_scene.setAmbientLight(new AmbientLight(new Color(0,0,0), 1));
			_scene.set_aperatureRadius(20);
			_scene.set_focalLength(550);
			_scene.addLight(new PointLight(new Color(100,30,30),new Point3D(0, 0,0), 1, 0,0));
			_scene.addGeometry(new Sphere(100, new Point3D(0, 0, -1500), new Color(100, 0, 100), new Material(1, 1, 20, 0, 0)));
			_scene.addGeometry(new Sphere(100, new Point3D(-250, 0, -800), new Color(100, 0, 100), new Material(1, 1, 20, 0, 0)));

			
			Render r = new Render(_imageWriter,_scene);

			r.renderImage();
			r.writeToImage();
			Date d2 = new Date();
			System.out.println(d2.getTime() - d.getTime());
			System.out.println("Finish");
		
		System.out.println("Finish All");


	}
}
