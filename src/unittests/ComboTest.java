package unittests;

import java.util.Date;

import org.junit.Test;

import elements.AmbientLight;
import elements.Camera;
import elements.PointLight;
import elements.SpotLight;
import geometries.Cylinder;
import geometries.Plane;
import geometries.Rectangle;
import geometries.FramedStraightRectangles;
import geometries.Sphere;
import geometries.Triangle;
import geometries.Tube;
import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class ComboTest {
/*	@Test
	public void Combo1(){
			int X = 500;
			int Y = 500;
			Date d = new Date();
			ImageWriter _imageWriter = new ImageWriter("Combo1", X, Y, X, Y);
			Scene _scene = new Scene("s");
			_scene.setScreenDistance(50);
			_scene.setBackground(new Color(0,0,0));
			_scene.setCamera(new Camera(new Point3D(0,0,0), new Vector(0,1,0), new Vector(0,0,-1)));
			_scene.setAmbientLight(new AmbientLight(new Color(0,0,0), 1));
			
			_scene.addLight(new PointLight(new Color(255,175,255),new Point3D(-6,-6,0), 1, 0, 0));
			_scene.addGeometry(new Sphere(100, new Point3D(0,0, -150), new Color(30,0,100), new Material(0.5,0,10,0,0.5)));
			_scene.addGeometry(new Sphere(80, new Point3D(0,0, -150), new Color(100,0,70), new Material(0.5,0,10,0,0)));
			_scene.addGeometry(new Tube(110, new Point3D(0,0,-150), new Vector(1,0,0),new Color(100,0,0),new Material(0.5,0,10,0,0.5) ));
			//_scene.addGeometry(new Plane(new Point3D(0,250,0),new Vector(0,1,-0.1),new Color(0,0,0), new Material(0,0,1,1,0)));
			//_scene.addGeometry(new Sphere(20, new Point3D(100,0, -0), new Color(30,0,100), new Material(0.5,0,10,0,0.5)));

			

			
			
			Render r = new Render(_imageWriter,_scene);

			r.renderImage();
			r.writeToImage();
			Date d2 = new Date();
			System.out.println(d2.getTime() - d.getTime());
			System.out.println("Finish");
	}*/
	
//	@Test
//	public void Combo2(){
//			int X = 500;
//			int Y = 500;
//			Date d = new Date();
//			ImageWriter _imageWriter = new ImageWriter("Combo2", X, Y, X, Y);
//			Scene _scene = new Scene("s");
//			_scene.setScreenDistance(100);
//			_scene.setBackground(new Color(0,0,0));
//			_scene.setCamera(new Camera(new Point3D(0,0,0), new Vector(0,-1,0), new Vector(0,0,1)));
//			_scene.setAmbientLight(new AmbientLight(new Color(0,0,0), 1));
//			
//			_scene.addLight(new SpotLight(new Color(200,200,200),new Point3D(50,-1,-12), 1, 0, 0, new Vector(-25, 0, 80)));
//			//_scene.addGeometry(new Sphere(100, new Point3D(0,0, -150), new Color(30,0,100), new Material(0.5,0,10,0,0.5)));
//			
//			_scene.addGeometry(new Triangle(new Point3D(-250,-250,120), new Point3D(-250,250,120), new Point3D(250,-250,120),new Color(0,0,0),new Material(0.9,0.8,100,0,0) ));
//			_scene.addGeometry(new Triangle(new Point3D(250,250,120), new Point3D(-250,250,120), new Point3D(250,-250,120),new Color(0,0,0),new Material(0.9,0.8,100,0,0) ));
//			_scene.addGeometry(new Sphere(60, new Point3D(0,0, 80), new Color(0,0,70), new Material(0.9,0.5,30,0,0)));
//			//_scene.addGeometry(new Plane(new Point3D(0,250,0),new Vector(0,1,-0.1),new Color(0,0,0), new Material(0,0,1,1,0)));
//			//_scene.addGeometry(new Sphere(20, new Point3D(100,0, -0), new Color(30,0,100), new Material(0.5,0,10,0,0.5)));
//
//			
//
//			
//			
//			Render r = new Render(_imageWriter,_scene);
//
//			r.renderImage();
//			r.writeToImage();
//			Date d2 = new Date();
//			System.out.println(d2.getTime() - d.getTime());
//			System.out.println("Finish");
//	}
	
//	@Test
//	public void Combo3(){
//			int X = 500;
//			int Y = 500;
//			Date d = new Date();
//			ImageWriter _imageWriter = new ImageWriter("Combo3", X, Y, X, Y);
//			Scene _scene = new Scene("s");
//			_scene.setScreenDistance(300);
//			_scene.setBackground(new Color(0,0,0));
//			_scene.setCamera(new Camera(new Point3D(0,0,0), new Vector(0,1,0), new Vector(0,0,-1)));
//			_scene.setAmbientLight(new AmbientLight(new Color(0,0,0), 1));
//			
//			_scene.addLight(new PointLight(new Color(255,100,100),new Point3D(200,200,-650), 1, 0, 0.000001));
//			_scene.addGeometry(new Sphere(300, new Point3D(0, 0, -1500), new Color(0, 0, 100), new Material(1, 1, 20, 0, 0.5)));
//			_scene.addGeometry(new Sphere(150, new Point3D(0, 0, -1500), new Color(100, 20, 20), new Material(1, 1, 20, 0.5, 0)));
//
//			_scene.addGeometry(new Triangle(new Point3D(2000, -1000, -2000), new Point3D(-1000, 2000, -2000),
//					new Point3D(700, 700, -875), new Color(20, 20, 20), new Material(0.5, 0.3, 10, 1, 0)));
//
//			_scene.addGeometry(new Triangle(new Point3D(2000, -1000, -2000), new Point3D(-1000, 2000, -2000),
//					new Point3D(-1000, -1000, -2000), new Color(20, 20, 20), new Material(0.55, 0.25, 10, 0.5, 0)));
//
//			
//			
//			
//			Render r = new Render(_imageWriter,_scene);
//
//			r.renderImage();
//			r.writeToImage();
//			Date d2 = new Date();
//			System.out.println(d2.getTime() - d.getTime());
//			System.out.println("Finish");
//	}
	
	@Test
	public void Combo4(){
			int X = 500;
			int Y = 500;
			Date d = new Date();
			ImageWriter _imageWriter = new ImageWriter("Combo4", X, Y, X, Y);
			Scene _scene = new Scene("s");
			_scene.setScreenDistance(300);
			_scene.setBackground(new Color(0,0,0));
			_scene.setCamera(new Camera(new Point3D(0,0,0), new Vector(0,1,0), new Vector(0,0,-1)));
			_scene.setAmbientLight(new AmbientLight(new Color(0,0,0), 1));
			_scene.set_aperatureRadius(20);
			_scene.set_focalLength(500);
			_scene.addLight(new PointLight(new Color(100,30,30),new Point3D(0, 0,0), 1, 0,0));
			_scene.addGeometry(new Sphere(200, new Point3D(100, 0, -1500), new Color(100, 0, 200), new Material(1, 1, 20, 0, 0.2)));
			_scene.addGeometry(new Sphere(200, new Point3D(400, 0, -1500), new Color(100, 0, 100), new Material(1, 1, 20, 0, 0.2)));
			_scene.addGeometry(new Sphere(200, new Point3D(250, -200, -1500), new Color(150, 100, 50), new Material(1, 1, 20, 0, 0.2)));
//			_scene.addGeometry(new FramedStraightRectangles(-200 , 800, -500, 500, -10000, 10000, new Point3D(200,0,-2000), new Vector(0,0,1), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
//			_scene.addGeometry(new FramedStraightRectangles(-10000 , 10000, -500, 500, -2000, -1000, new Point3D(800,0,-2000), new Vector(1,0,0), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
//			_scene.addGeometry(new FramedStraightRectangles(-200 , 800, -10000, 10000, -2000, -1000, new Point3D(200,-500,-2000), new Vector(0,1,0), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
			//_scene.addGeometry(new FramedStraightRectangles(-200 , 800, -500, 500, -10000, 10000, new Point3D(200,0,-2000), new Vector(0,0,1), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
			//_scene.addGeometry(new FramedStraightRectangles(-10000 , 10000, -500, 500, -2000, -1000, new Point3D(800,0,-2000), new Vector(1,0,0), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
			//_scene.addGeometry(new FramedStraightRectangles(-200 , 800, -10000, 10000, -2000, -1000, new Point3D(200,500,-2000), new Vector(0,1,0), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));

			_scene.addGeometry(new Rectangle( new Point3D(-200,-500,-2000), new Point3D(800,-500,-2000),new Point3D(-200,500,-2000), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
			_scene.addGeometry(new Rectangle( new Point3D(800,-500,-2000), new Point3D(800,-500,-1000), new Point3D(800,500,-2000), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
			_scene.addGeometry(new Rectangle( new Point3D(-200,-500,-2000), new Point3D(800,-500,-2000),new Point3D(-200,-500,-1000), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));

			
			Render r = new Render(_imageWriter,_scene);

			r.renderImage();
			r.writeToImage();
			Date d2 = new Date();
			System.out.println(d2.getTime() - d.getTime());
			System.out.println("Finish");
	}
	
//	@Test
//	public void Combo5(){
//			int X = 500;
//			int Y = 500;
//			Date d = new Date();
//			ImageWriter _imageWriter = new ImageWriter("Combo5", X, Y, X, Y);
//			Scene _scene = new Scene("s");
//			_scene.setScreenDistance(300);
//			_scene.setBackground(new Color(0,0,0));
//			_scene.setCamera(new Camera(new Point3D(0,0,0), new Vector(0,1,0), new Vector(0,0,-1)));
//			_scene.setAmbientLight(new AmbientLight(new Color(0,0,0), 1));
//			
//			_scene.addLight(new PointLight(new Color(100,30,30),new Point3D(5000, 5000,5000), 1, 0,0));
//			
//			_scene.addGeometry(new Sphere(150, new Point3D(-100, -100, -1500), new Color(100, 0, 200), new Material(1, 1, 20, 0, 0.2)));
//			_scene.addGeometry(new Sphere(150, new Point3D(100, -100, -1500), new Color(100, 0, 100), new Material(1, 1, 20, 0, 0.2)));
//			_scene.addGeometry(new Sphere(150, new Point3D(0, -240, -1500), new Color(150, 100, 50), new Material(1, 1, 20, 0, 0.2)));
//			
//			_scene.addGeometry(new Rectangle( new Point3D(0,-500,-2000), new Point3D(500,-500,-1500), new Point3D(-500,-500,-1500), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
//			_scene.addGeometry(new Rectangle( new Point3D(0,-500,-2000), new Point3D(0,210,-2000), new Point3D(-500,-500,-1500), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
//			_scene.addGeometry(new Rectangle( new Point3D(0,-500,-2000), new Point3D(0,210,-2000),new Point3D(500,-500,-1500), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
//
//			
//			Render r = new Render(_imageWriter,_scene);
//
//			r.renderImage();
//			r.writeToImage();
//			Date d2 = new Date();
//			System.out.println(d2.getTime() - d.getTime());
//			System.out.println("Finish");
//	}
	
	/*@Test
	public void Combo6(){
			int X = 500;
			int Y = 500;
			Date d = new Date();
			ImageWriter _imageWriter = new ImageWriter("Combo6", X, Y, X, Y);
			Scene _scene = new Scene("s");
			_scene.setScreenDistance(300);
			_scene.setBackground(new Color(0,0,0));
			_scene.setCamera(new Camera(new Point3D(0,600,0), new Vector(0,1,0), new Vector(0,0,-1)));
			_scene.setAmbientLight(new AmbientLight(new Color(0,0,0), 1));
			
			_scene.addLight(new PointLight(new Color(100,30,30),new Point3D(0, 0,0), 1, 0,0));
			
			_scene.addGeometry(new Sphere(200, new Point3D(100, 0, -2000), new Color(100, 0, 200), new Material(1, 1, 20, 0, 0.2)));
			_scene.addGeometry(new Sphere(200, new Point3D(400, 0, -2000), new Color(100, 0, 100), new Material(1, 1, 20, 0, 0.2)));
			_scene.addGeometry(new Sphere(200, new Point3D(250, -200, -2000), new Color(150, 100, 50), new Material(1, 1, 20, 0, 0.2)));

			_scene.addGeometry(new Sphere(200, new Point3D(-100, 0, -2000), new Color(75, 100, 75), new Material(1, 1, 20, 0, 0.2)));
			_scene.addGeometry(new Sphere(200, new Point3D(-400, 0, -2000), new Color(80, 80, 100), new Material(1, 1, 20, 0, 0.2)));
			_scene.addGeometry(new Sphere(200, new Point3D(-250, -200, -2000), new Color(40, 100, 150), new Material(1, 1, 20, 0, 0.2)));

			
			_scene.addGeometry(new Rectangle( new Point3D(-800,-500,-2500), new Point3D(800,-500,-2500),new Point3D(-800,500,-2500), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
			_scene.addGeometry(new Rectangle( new Point3D(800,-500,-2500), new Point3D(800,-500,-1500), new Point3D(800,500,-2500), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
			_scene.addGeometry(new Rectangle( new Point3D(-800,-500,-2500), new Point3D(800,-500,-2500),new Point3D(-800,-500,-1500), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
			_scene.addGeometry(new Rectangle( new Point3D(-800,-500,-2500), new Point3D(-800,-500,-1500), new Point3D(-800,500,-2500), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));

			
			
			Render r = new Render(_imageWriter,_scene);

			r.renderImage();
			r.writeToImage();
			Date d2 = new Date();
			System.out.println(d2.getTime() - d.getTime());
			System.out.println("Finish");
	}*/
}


//@Override
//public Color get_emission(Point3D p) {
//	if(Math.abs(Math.floor(p.getX().get())) % 2 == 1 ^ Math.abs(Math.floor(p.getY().get())) % 2 == 1)
//	{
//		return new Color(55,55,55);
//	}
//	
//	return super.get_emission(p);
//}