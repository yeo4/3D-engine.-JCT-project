package renderer;

import java.util.Map;

import elements.LightSource;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import geometries.Geometry;
import primitives.*;
import scene.*;

public class Render {
	private Scene _scene;
	private ImageWriter _imageWriter;

	public Render(ImageWriter _imageWriter, Scene _scene) {
		this._scene = _scene;
		this._imageWriter = _imageWriter;
	}

	public void renderImage() {
		for (int i = 0; i < _imageWriter.getNx(); i++) {
			for (int j = 0; j < _imageWriter.getNy(); j++) {
				Ray r = _scene.getCamera().constructRayThroughPixel(_imageWriter.getNx(), _imageWriter.getNy(), i, j,
						_scene.getScreenDistance(), _imageWriter.getWidth(), _imageWriter.getHeight());
				Map<Geometry, List<Point3D>> intersectionPoints = new HashMap<Geometry, List<Point3D>>(
						_scene.getRayIntersections(r));

				if (intersectionPoints.isEmpty()) {
					_imageWriter.writePixel(i, j, _scene.getBackground().getColor());
				} else {
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
		for (int i = 0; i <= _imageWriter.getNx() - 1; i++) {
			for (int j = _imageWriter.getNy() - 1; j >= 0; j--) {
				if (i % interval == 0 || j % interval == 0) {
					System.out.println(i + "," + j);
					_imageWriter.writePixel(i, j, new Color(255, 255, 255).getColor());
				}
			}
		}
		System.out.println("Finish");
	}

	public void writeToImage() {
		_imageWriter.writeToimage();
	}

	private Color calcColor(Geometry geometry, Point3D point) {
		Color color = _scene.getAmbientLight().getIntensity();
		color = color.add(geometry.get_emission());

		Vector v = point.subtract(_scene.getCamera().get_p0()).normalization();
		Vector n = geometry.getNormal(point);
		int nShininess = geometry.get_material().getnShininess();
		double kd = geometry.get_material().get_Kd();
		double ks = geometry.get_material().get_Ks();
		
		for (LightSource lightSource : this._scene.getLights()) {
			Vector l = lightSource.getL(point);
			if (n.dot_product(l) * n.dot_product(v) > 0) {
				if (!occluded(l, point, geometry)) {
					Color lightIntensity = lightSource.getIntensity(point);
					color.add(calcDiffusive(kd, l, n, lightIntensity),
					calcSpecular(ks, l, n, v, nShininess, lightIntensity));
				}
			}
		}
		
		return color;
	}

	private boolean occluded(Vector l, Point3D point, Geometry geometry) {
		Vector lightDirection = l.multiply(-1); // from point to light source
		Vector normal = geometry.getNormal(point);
		Vector epsVector = normal.multiply((normal.dot_product(lightDirection) > 0) ? 2*Math.pow(2,Coordinate.getACCURACY()) : -2*Math.pow(2,Coordinate.getACCURACY()));
		Point3D geometryPoint = point.add(epsVector);
		Ray lightRay = new Ray(geometryPoint, lightDirection);
		return _scene.getGeometries().hasIntersections(lightRay);
	}

	private Color calcSpecular(double ks, Vector l, Vector n, Vector v, int nShininess, Color lightIntensity) {
		Vector r = l.add(n.multiply(-2 * l.dot_product(n))).normalization();
		double vr = v.dot_product(r);
		if (vr > 0)
			return new Color(0, 0, 0);
		return new Color(lightIntensity).scale(ks * Math.pow(Math.abs(vr), nShininess));
	}

	private Color calcDiffusive(double kd, Vector l, Vector n, Color lightIntensity) {
		return new Color(lightIntensity).scale(kd * Math.abs(l.dot_product(n)));
	}

	private Map<Geometry, Point3D> getClosestPoint(Map<Geometry, List<Point3D>> intersectionPoints) {
		Point3D From = _scene.getCamera().get_p0();
		double minDisSquare = Integer.MAX_VALUE;
		Map<Geometry, Point3D> closest = new HashMap<>();

		for (Map.Entry<Geometry, List<Point3D>> entry : intersectionPoints.entrySet())
			for (Point3D p : entry.getValue()) {

				double dSquare = From.distanceSquare(p);

				if (dSquare <= minDisSquare) {
					closest.clear();
					closest.put(entry.getKey(), new Point3D(p));
					minDisSquare = dSquare;
				}
			}

		if (closest.size() == 1)
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
