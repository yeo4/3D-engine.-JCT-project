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
		_imageWriter.writeToimage();
	}
	private Color calcColor(Point3D p3d) {
		return _scene.get_ambientLight().getIntensity();
	}
	private Point3D getClosestPoint(ArrayList<Point3D> Points3D) {
		if(Points3D.size() == 0) {
			throw new NullPointerException("Array can't be null");
		}
		Point3D From = _scene.get_camera().get_p0();
		Point3D Closest = new Point3D(Points3D.get(0));
		double minDisSqre = From.distanceSquare(Closest);
		for (int i = 1; i<Points3D.size();i++) {
			if(Points3D.get(i) != null) {
				if(From.distanceSquare(Points3D.get(i)) < minDisSqre) {
					 Closest = new Point3D(Points3D.get(i));
					 minDisSqre = From.distanceSquare(Closest);
				}
			}
		}
		return Closest;
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
