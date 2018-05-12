package renderer;

import java.util.*;
import geometries.Geometry;
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
			for(int j=0;j<_imageWriter.getNy();j++) {
                Ray r = _scene.getCamera().constructRayThroughPixel(_imageWriter.getNx(),_imageWriter.getNy(), i, j, _scene.getScreenDistance(), _imageWriter.getWidth(), _imageWriter.getHeight());
                Map<Geometry,List<Point3D>> intersectionPoints = new HashMap<Geometry,List<Point3D>>(_scene.getRayIntersections(r));
				
                if(intersectionPoints.isEmpty()) {
                	_imageWriter.writePixel(i, j, _scene.getBackground().getColor());
                }else {
                	Map<Geometry, Point3D> closestPoint = getClosestPoint(intersectionPoints);
                	Map.Entry<Geometry, Point3D> onlyEntry = closestPoint.entrySet().iterator().next();
                	_imageWriter.writePixel(i, j, calcColor(onlyEntry.getKey(), onlyEntry.getValue()).getColor());
                }
			}
			System.out.println(i + "/" + _imageWriter.getNx());
		}
		System.out.println("Finish Render()");
	}
	
	public void printGrid(double interval) {
        for (int i = 0; i <= _imageWriter.getNx()-1; i++){
            for (int j = _imageWriter.getNy()-1; j >= 0; j--){
                if (i % interval == 0 || j % interval == 0) {
                	System.out.println(i + "," + j);
                	_imageWriter.writePixel(i,j, new Color(255,255,255).getColor());
                }
            }
        }
        System.out.println("Finish");
	}
	public void writeToImage() {
		_imageWriter.writeToimage();
	}
	private Color calcColor(Geometry g, Point3D p3d) {
		Color color = _scene.getAmbientLight().getIntensity();
		color = color.add(g.get_emission());
		return color;
	}
	
	double minDisSquare; // find alternative;
	
	private Map<Geometry, Point3D> getClosestPoint(Map<Geometry, List<Point3D>> intersectionPoints ) {
		/*if(Points3D.size() == 0) {
			throw new NullPointerException("Array can't be null");
		}*/
		double d[] = {Integer.MAX_VALUE};
		Point3D From = _scene.getCamera().get_p0();
	    minDisSquare = Integer.MAX_VALUE;
		Map<Geometry, Point3D> closest = new HashMap<>();
		
		intersectionPoints.forEach((geometry, list) -> {
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i) != null) {
					if(From.distanceSquare(list.get(i)) <= minDisSquare) {
						 closest.clear();
						 closest.put(geometry, new Point3D(list.get(i)));
						 minDisSquare = From.distanceSquare(list.get(i));
					}
				}
			}
		});
		
		if(closest.size() == 1)
			return closest;
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
