import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;
import primitives.*;

import java.util.Date;

import elements.AmbientLight;
import geometries.*;

public class Runner {
	public static void main(String[] args) {
		int X = 1000;
		int Y = 500;
		Date d = new Date();
		ImageWriter _imageWriter = new ImageWriter("Test6", X, Y, X, Y);
		Scene _scene = new Scene("s");
		_scene.setBackground(new Color(30,255,80));
		_scene.setAmbientLight(new AmbientLight(new Color(200,50,88), 1));
	//	_scene.addGeometry(new Triangle(new Triangle(new Point3D(0, 2, -2),new Point3D(1, -8, -8),new Point3D(-1, -1, -2))));
		_scene.addGeometry(new Tube(0.001, new Point3D(0, 0, 0),new Vector(0, 0, 1)));

		Render r = new Render(_imageWriter,_scene);

		r.renderImage();
		//r.printGrid(20);
		r.writeToImage();
		Date d2 = new Date();
		System.out.println(d2.getTime() - d.getTime());
		System.out.println("Finish");
	}
}

// 100X100 = 188
// 1000X1000 = 1772;