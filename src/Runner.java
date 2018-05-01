import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class Runner {
	public static void main(String[] args) {
		ImageWriter _imageWriter = new ImageWriter("Test3", 100, 100, 20, 20);
		Scene _scene = new Scene("s");
		Render r = new Render(_imageWriter,_scene);
		r.printGrid(1.5);
		r.writeToImage();
	}
}
