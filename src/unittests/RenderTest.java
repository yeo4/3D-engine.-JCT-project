package unittests;

import java.util.Date;

import org.junit.Test;

import elements.*;
import geometries.*;
import primitives.*;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class RenderTest {
	@Test
	public void basicRendering(){
			int X = 500;
			int Y = 500;
			Date d = new Date();
			ImageWriter _imageWriter = new ImageWriter("Test6", X, Y, X, Y);
			Scene _scene = new Scene("s");
			_scene.setBackground(new Color(0,0,0));
			_scene.setCamera(new Camera(new Point3D(0,0,0), new Vector(0,1,0), new Vector(0,0,-1)));
			_scene.setAmbientLight(new AmbientLight(new Color(255,255,255), 1));
			
			_scene.addGeometry(new Sphere(2, new Point3D(0,0,-4)));
		  	_scene.addGeometry(new Triangle(new Point3D(0, 4, -4),new Point3D(4, 0, -4),new Point3D(4, 4, -4)));
		  	_scene.addGeometry(new Triangle(new Point3D(0, 4, -4),new Point3D(-4, 0, -4),new Point3D(-4, 4, -4)));
		  	_scene.addGeometry(new Triangle(new Point3D(0, -4, -4),new Point3D(-4, 0, -4),new Point3D(-4, -4, -4)));
		  	_scene.addGeometry(new Triangle(new Point3D(0, -4, -4),new Point3D(4, 0, -4),new Point3D(4, -4, -4)));
			
			Render r = new Render(_imageWriter,_scene);

			r.renderImage();
			r.printGrid(10);
			r.writeToImage();
			Date d2 = new Date();
			System.out.println(d2.getTime() - d.getTime());
			System.out.println("Finish");
	
	}
}