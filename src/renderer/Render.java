package renderer;

import java.util.ArrayList;

import primitives.*;
import scene.*;

public class Render {
	private Scene _scene;
	private ImageWriter _imageWriter;
	
	public Render(ImageWriter _imageWriter,Scene _scene) {
		this._scene = _scene;
		this._imageWriter = _imageWriter;
	}
	public void renderImage() {
	//	for(int i=0;i<_scene.)
	}
	
	public void printGrid() {
		
	}
	public void writeToImage() {
		
	}
	private Color calcColor(Point3D p3d) {
		return _scene.get_ambientLight().getIntensity();
	}
	private Point3D getClosestPoint(ArrayList<Point3D> Points3D) {
		
		return null;
	}
	public Scene get_scene() {
		return _scene;
	}
	public void set_scene(Scene _scene) {
		this._scene = _scene;
	}
	public ImageWriter get_imageWriter() {
		return _imageWriter;
	}
	public void set_imageWriter(ImageWriter _imageWriter) {
		this._imageWriter = _imageWriter;
	}
}
