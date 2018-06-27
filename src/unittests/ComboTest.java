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
	
//	@Test
//	public void Combo4(){
//			int X = 500;
//			int Y = 500;
//			Date d = new Date();
//			ImageWriter _imageWriter = new ImageWriter("Combo4", X, Y, X, Y);
//			Scene _scene = new Scene("s");
//			_scene.setScreenDistance(300);
//			_scene.setBackground(new Color(0,0,0));
//			_scene.setCamera(new Camera(new Point3D(0,0,0), new Vector(0,1,0), new Vector(0,0,-1)));
//			_scene.setAmbientLight(new AmbientLight(new Color(0,0,0), 1));
//			_scene.set_aperatureRadius(20);
//			_scene.set_focalLength(500);
//			_scene.addLight(new PointLight(new Color(100,30,30),new Point3D(0, 0,0), 1, 0,0));
//			_scene.addGeometry(new Sphere(200, new Point3D(100, 0, -1500), new Color(100, 0, 200), new Material(1, 1, 20, 0, 0.2)));
//			_scene.addGeometry(new Sphere(200, new Point3D(400, 0, -1500), new Color(100, 0, 100), new Material(1, 1, 20, 0, 0.2)));
//			_scene.addGeometry(new Sphere(200, new Point3D(250, -200, -1500), new Color(150, 100, 50), new Material(1, 1, 20, 0, 0.2)));
////			_scene.addGeometry(new FramedStraightRectangles(-200 , 800, -500, 500, -10000, 10000, new Point3D(200,0,-2000), new Vector(0,0,1), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
////			_scene.addGeometry(new FramedStraightRectangles(-10000 , 10000, -500, 500, -2000, -1000, new Point3D(800,0,-2000), new Vector(1,0,0), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
////			_scene.addGeometry(new FramedStraightRectangles(-200 , 800, -10000, 10000, -2000, -1000, new Point3D(200,-500,-2000), new Vector(0,1,0), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
//			//_scene.addGeometry(new FramedStraightRectangles(-200 , 800, -500, 500, -10000, 10000, new Point3D(200,0,-2000), new Vector(0,0,1), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
//			//_scene.addGeometry(new FramedStraightRectangles(-10000 , 10000, -500, 500, -2000, -1000, new Point3D(800,0,-2000), new Vector(1,0,0), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
//			//_scene.addGeometry(new FramedStraightRectangles(-200 , 800, -10000, 10000, -2000, -1000, new Point3D(200,500,-2000), new Vector(0,1,0), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
//
//			_scene.addGeometry(new Rectangle( new Point3D(-200,-500,-2000), new Point3D(800,-500,-2000),new Point3D(-200,500,-2000), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
//			_scene.addGeometry(new Rectangle( new Point3D(800,-500,-2000), new Point3D(800,-500,-1000), new Point3D(800,500,-2000), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
//			_scene.addGeometry(new Rectangle( new Point3D(-200,-500,-2000), new Point3D(800,-500,-2000),new Point3D(-200,-500,-1000), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
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
	
//	@Test
//	public void Combo6(){
//			int X = 500;
//			int Y = 500;
//			Date d = new Date();
//			ImageWriter _imageWriter = new ImageWriter("Combo6", X, Y, X, Y);
//			Scene _scene = new Scene("s");
//			_scene.setScreenDistance(300);
//			_scene.set_aperatureRadius(5);
//			_scene.set_focalLength(530);
//			_scene.setBackground(new Color(0,0,0));
//			_scene.setCamera(new Camera(new Point3D(0,0,0), new Vector(0,1,0), new Vector(0,0,-1)));
//			_scene.setAmbientLight(new AmbientLight(new Color(0,0,0), 1));
//			
////			_scene.addGeometry(new Sphere(200, new Point3D(100, -200, -1500), new Color(100, 0, 200), new Material(1, 1, 20, 0, 0.2)));
////			_scene.addGeometry(new Sphere(200, new Point3D(400, -200, -1500), new Color(100, 0, 100), new Material(1, 1, 20, 0, 0.2)));
////			_scene.addGeometry(new Sphere(200, new Point3D(250, -400, -1500), new Color(150, 100, 50), new Material(1, 1, 20, 0, 0.2)));
////
////			_scene.addGeometry(new Sphere(375, new Point3D(-1500, -400, -5000), new Color(175, 35, 35), new Material(1, 1, 20, 0, 0)));
////			_scene.addGeometry(new Sphere(375, new Point3D(-2000, -400, -5000), new Color(15, 175, 10), new Material(1, 1, 20, 0, 0)));
////			_scene.addGeometry(new Sphere(375, new Point3D(-1750, -850, -5000), new Color(60, 40, 175), new Material(1, 1, 20, 0, 0)));
////
////			
////			_scene.addGeometry(new XZboard(new Point3D(0,600,0), new Vector(0,1,0), new Color(0,0,0), new Material(0,0,20,0.5,0), new Color(0,0,0), new Color(40,40,40),200));
////
////			
////			_scene.addGeometry(new Rectangle( new Point3D(-200,-700,-2000), new Point3D(800,-700,-2000),new Point3D(-200,300,-2000), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
////			_scene.addGeometry(new Rectangle( new Point3D(800,-700,-2000), new Point3D(800,-700,-1000), new Point3D(800,300,-2000), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
////			_scene.addGeometry(new Rectangle( new Point3D(-200,-700,-2000), new Point3D(800,-700,-2000),new Point3D(-200,-700,-1000), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
////
////			_scene.addGeometry(new Rectangle( new Point3D(-2600,-1400,-5500), new Point3D(-800,-1400,-5500),new Point3D(-2600,600,-5500), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
////			_scene.addGeometry(new Rectangle( new Point3D(-2600,-1400,-5500), new Point3D(-2600,-1400,-4000), new Point3D(-2600,600,-5500), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
////			_scene.addGeometry(new Rectangle( new Point3D(-800,-1400,-5500), new Point3D(-2600,-1400,-5500),new Point3D(-800,-1400,-4000), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
//			
//			
////			_scene.addGeometry(new Cylinder(1000, new Point3D(-5500, -6500, -15000), new Vector(0,1,0), 2000, new Color(60, 40, 175), new Material(1, 1, 20, 0, 0)   ));
////			_scene.addGeometry(new Cylinder(1000, new Point3D(-7250, -6500, -15000), new Vector(0,1,0), 2000, new Color(130, 130, 175), new Material(1, 1, 20, 0, 0)   ));
////			_scene.addGeometry(new Sphere(1000, new Point3D(-6375, -9000, -14300), new Color(120, 100, 0), new Material(1, 0, 20, 0, 0)));
////			_scene.addGeometry(new Cylinder(750, new Point3D(-6375, -11000, -15000), new Vector(1,0,0), 5000, new Color(130, 35, 35), new Material(1, 1, 20, 0, 0)   ));
////			
////			_scene.addGeometry(new Sphere(4250, new Point3D(-6375, -9000, -18000), new Color(100, 75, 100), new Material(1, 0, 20, 0, 0)));
//		
//			_scene.addLight(new PointLight(new Color(10,80,10),new Point3D(0,2000,0), 1, 0,0));
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
	public void Board(){
			int X = 500;
			int Y = 500;
			Date d = new Date();
			ImageWriter _imageWriter = new ImageWriter("Board", X, Y, X, Y);
			Scene _scene = new Scene("s");
			_scene.setScreenDistance(300);
			_scene.set_aperatureRadius(10);
			_scene.set_focalLength(1300);
			_scene.setBackground(new Color(0,0,0));
			_scene.setCamera(new Camera(new Point3D(0,0,0), new Vector(0,1,0), new Vector(0,0,-1)));
			_scene.setAmbientLight(new AmbientLight(new Color(0,0,0), 1));
			
			_scene.addLight(new PointLight(new Color(100,30,30),new Point3D(0,1000,0), 1, 0,0));

			
			_scene.addGeometry(new XZboard(new Point3D(0,100,0), new Vector(0,1,0), new Color(0,0,0), new Material(0.5,1,20,0.5,0), new Color(0,0,0), new Color(55,55,55),150));
			_scene.addGeometry(new XZboard(new Point3D(0,-100,0), new Vector(0,1,0), new Color(0,0,0), new Material(0.5,1,20,0.5,0), new Color(0,0,0), new Color(55,55,55),150));

			
//			_scene.addGeometry(new Sphere(200, new Point3D(100, 0, -1500), new Color(100, 0, 200), new Material(1, 1, 20, 0, 0.2)));
//			_scene.addGeometry(new Sphere(200, new Point3D(400, 0, -1500), new Color(100, 0, 100), new Material(1, 1, 20, 0, 0.2)));
//			_scene.addGeometry(new Sphere(200, new Point3D(250, -200, -1500), new Color(150, 100, 50), new Material(1, 1, 20, 0, 0.2)));
//
//			_scene.addGeometry(new Rectangle( new Point3D(-200,-500,-2000), new Point3D(800,-500,-2000),new Point3D(-200,500,-2000), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
//			_scene.addGeometry(new Rectangle( new Point3D(800,-500,-2000), new Point3D(800,-500,-1000), new Point3D(800,500,-2000), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
//			_scene.addGeometry(new Rectangle( new Point3D(-200,-500,-2000), new Point3D(800,-500,-2000),new Point3D(-200,-500,-1000), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));

			
			
			_scene.addGeometry(new Sphere(30, new Point3D(-90, 0, -200), new Color(150, 0, 100), new Material(1, 1, 20, 0, 0.2)));
			_scene.addGeometry(new Cylinder(50, new Point3D(-90, 0, -200), new Vector(0,1,0), 120 , new Color(100, 0, 200), new Material(1, 1, 20, 0, 0.5)));
			
			
			
			Render r = new Render(_imageWriter,_scene);

			r.renderImage();
			r.writeToImage();
			Date d2 = new Date();
			System.out.println(d2.getTime() - d.getTime());
			System.out.println("Finish");
	}*/
	
	
	@Test
	public void Combo7(){
			int X = 500;
			int Y = 500;
			Date d = new Date();
			ImageWriter _imageWriter = new ImageWriter("Combo7", X, Y, X, Y);
			Scene _scene = new Scene("s");
			_scene.setScreenDistance(300);
			_scene.set_aperatureRadius(5);
			_scene.set_focalLength(290);
			_scene.setBackground(new Color(0,0,0));
			_scene.setCamera(new Camera(new Point3D(0,0,0), new Vector(0,1,0), new Vector(0,0,-1)));
			_scene.setAmbientLight(new AmbientLight(new Color(0,0,0), 1));
			
	
//			_scene.addGeometry(new Rectangle( new Point3D(-200,-700,-2000), new Point3D(800,-700,-2000),new Point3D(-200,300,-2000), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
//			_scene.addGeometry(new Rectangle( new Point3D(800,-700,-2000), new Point3D(800,-700,-1000), new Point3D(800,300,-2000), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
//			_scene.addGeometry(new Rectangle( new Point3D(-200,-700,-2000), new Point3D(800,-700,-2000),new Point3D(-200,-700,-1000), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
//
//			_scene.addGeometry(new Rectangle( new Point3D(-2600,-1400,-5500), new Point3D(-800,-1400,-5500),new Point3D(-2600,600,-5500), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
//			_scene.addGeometry(new Rectangle( new Point3D(-2600,-1400,-5500), new Point3D(-2600,-1400,-4000), new Point3D(-2600,600,-5500), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
//			_scene.addGeometry(new Rectangle( new Point3D(-800,-1400,-5500), new Point3D(-2600,-1400,-5500),new Point3D(-800,-1400,-4000), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
			
			
		
			_scene.addLight(new PointLight(new Color(40,255,40),new Point3D(200,0,0), 1, 0,0));
			
			Point3D ceilingP = new Point3D(0,800,0);
			
			_scene.addGeometry(new XZboard(new Point3D(0,-45,0), new Vector(0,1,0), new Color(0,0,0), new Material(1,0,20,0.3,0), new Color(30,30,30), new Color(100,100,100),40));
			_scene.addGeometry(new XZboard(ceilingP, new Vector(0,1,0), new Color(0,0,0), new Material(1,0,20,0,0), new Color(50,50,50), new Color(130,130,130),400));
		//	_scene.addGeometry(new Plane(ceilingP, new Vector(0,1,0), new Color(50,50,100), new Material(0,0,20,0,0)));

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
	
	@Test
	public void Combo8(){
			int X = 500;
			int Y = 500;
			Date d = new Date();
			ImageWriter _imageWriter = new ImageWriter("Combo8", X, Y, X, Y);
			Scene _scene = new Scene("s");
			_scene.setScreenDistance(300);
			_scene.set_aperatureRadius(5);
			_scene.set_focalLength(2240);
			_scene.setBackground(new Color(0,0,0));
			_scene.setCamera(new Camera(new Point3D(0,0,0), new Vector(0,1,0), new Vector(0,0,-1)));
			_scene.setAmbientLight(new AmbientLight(new Color(0,0,0), 1));
			
	
//			_scene.addGeometry(new Rectangle( new Point3D(-200,-700,-2000), new Point3D(800,-700,-2000),new Point3D(-200,300,-2000), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
//			_scene.addGeometry(new Rectangle( new Point3D(800,-700,-2000), new Point3D(800,-700,-1000), new Point3D(800,300,-2000), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
//			_scene.addGeometry(new Rectangle( new Point3D(-200,-700,-2000), new Point3D(800,-700,-2000),new Point3D(-200,-700,-1000), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
//
//			_scene.addGeometry(new Rectangle( new Point3D(-2600,-1400,-5500), new Point3D(-800,-1400,-5500),new Point3D(-2600,600,-5500), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
//			_scene.addGeometry(new Rectangle( new Point3D(-2600,-1400,-5500), new Point3D(-2600,-1400,-4000), new Point3D(-2600,600,-5500), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
//			_scene.addGeometry(new Rectangle( new Point3D(-800,-1400,-5500), new Point3D(-2600,-1400,-5500),new Point3D(-800,-1400,-4000), new Color(0,0,0), new Material(0.5,1,20,0.5,0) ));
			
			
		
			_scene.addLight(new PointLight(new Color(40,255,40),new Point3D(200,0,0), 1, 0,0));
			
			Point3D ceilingP = new Point3D(0,800,0);
			
			_scene.addGeometry(new XZboard(new Point3D(0,-45,0), new Vector(0,1,0), new Color(0,0,0), new Material(1,0,20,0.3,0), new Color(30,30,30), new Color(100,100,100),40));
			_scene.addGeometry(new XZboard(ceilingP, new Vector(0,1,0), new Color(0,0,0), new Material(1,0,20,0,0), new Color(50,50,50), new Color(130,130,130),400));
		//	_scene.addGeometry(new Plane(ceilingP, new Vector(0,1,0), new Color(50,50,100), new Material(0,0,20,0,0)));

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

