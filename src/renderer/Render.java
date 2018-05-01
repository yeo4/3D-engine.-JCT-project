package renderer;

import java.util.List;

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
		for(int i=0;i<_imageWriter.getNx();i++) {
			for(int j=0;j<_imageWriter.getNx();j++) {
                Ray r = _scene.getCamera().constructRayThroughPixel(_imageWriter.getNx(),_imageWriter.getNy(), i, j, _scene.getScreenDistance(), _imageWriter.getWidth(), _imageWriter.getHeight());
                List<Point3D> intersectionPoints = _scene.getRayIntersections(r);
                if(intersectionPoints.isEmpty()) {
                	_imageWriter.writePixel(i, j, _scene.getBackground());
                }else {
                	Point3D closestPoint = getClosestPoint(intersectionPoints);
                	_imageWriter.writePixel(i, j, calcColor(closestPoint));
                }
			}
		}
	}
	
	public void printGrid(double interval) {
        for (int i = 1; i <= _imageWriter.getWidth()-1; i++){
            for (int j = _imageWriter.getHeight()-1; j > 0; j--){
                if (i % interval == 0 || j % interval == 0) {
                	System.out.println(i + "," + j);
                	_imageWriter.writePixel(i,j, _scene.getBackground());
                }
            }
        }
        System.out.println("Finish");
	}
	public void writeToImage() {
		_imageWriter.writeToimage();
	}
	private Color calcColor(Point3D p3d) {
		return _scene.getAmbientLight().getIntensity();
	}
	private Point3D getClosestPoint(List<Point3D> Points3D) {
		if(Points3D.size() == 0) {
			throw new NullPointerException("Array can't be null");
		}
		Point3D From = _scene.getCamera().get_p0();
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
