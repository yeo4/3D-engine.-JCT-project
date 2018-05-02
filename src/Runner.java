import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;
import primitives.*;
import geometries.*;

public class Runner {
	public static void main(String[] args) {
		ImageWriter _imageWriter = new ImageWriter("Test5", 100, 100, 100, 100);
		Scene _scene = new Scene("s");
		_scene.addGeometry(new Sphere(0.001,new Point3D(0, 0, 1)));
		Render r = new Render(_imageWriter,_scene);
		r.renderImage();
		r.writeToImage();
		System.out.println("Finish");
	}
}
