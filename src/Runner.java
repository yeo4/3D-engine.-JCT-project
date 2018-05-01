import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class Runner {
	public static void main(String[] args) {
		ImageWriter _imageWriter = new ImageWriter("Test", 10, 10, 5, 5);
		Scene _scene = new Scene("s");
		Render r = new Render(_imageWriter,_scene);
		r.printGrid(3);
		r.writeToImage();
	}
}
