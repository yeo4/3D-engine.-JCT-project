import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;
import primitives.*;
import geometries.*;

public class Runner {
	public static void main(String[] args) {
		ImageWriter _imageWriter = new ImageWriter("Test", 100, 100, 500, 500);
		Scene _scene = new Scene("s");
		Render r = new Render(_imageWriter,_scene);
		r.renderImage();
		r.printGrid(10);
		r.writeToImage();
	}
}
