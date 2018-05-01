package scene;
import java.util.List;

import elements.*;
import geometries.*;
import primitives.*;

public class Scene {
	private String _sceneName;
	private Color _background; // Need?
	private AmbientLight _ambientLight;
	private Geometries _geometries;
	private Camera _camera;
	private double _screenDistance;

	public Scene(String _sceneName) throws IllegalArgumentException  {
		this._sceneName = _sceneName;
		this._background = new Color(255, 255, 255);
		this._geometries = new Geometries();
		this._camera = new Camera(new Point3D(0,0,0), new Vector(0,1,0), new Vector(0,0,-1));
		this._screenDistance = 50;
	}
	
	public Scene(String _sceneName, Color _background, Geometries _geometries, Camera _camera, double _screenDistance) throws Exception {
		super();
		this._sceneName = _sceneName;
		this._background = _background;
		_geometries = new Geometries(_geometries);
		this._camera = _camera;
		this._screenDistance = _screenDistance;
	}
	
	public Scene(Scene s) throws IllegalArgumentException {
		super();
		this._sceneName = s._sceneName;
		this._background = s._background;
		this._geometries = new Geometries(s._geometries);
		this._camera = s._camera;
		this._screenDistance = s._screenDistance;
	}

	public String getSceneName() {
		return _sceneName;
	}

	public Color getBackground() {
		return _background;
	}

	public void setBackground(Color _background) {
		this._background = _background;
	}

	public Camera getCamera() {
		return _camera;
	}

	public void setCamera(Camera _camera) {
		this._camera = _camera;
	}

	public double getScreenDistance() {
		return _screenDistance;
	}

	public void setScreenDistance(double _screenDistance) {
		this._screenDistance = _screenDistance;
	}

	public AmbientLight getAmbientLight() {
		return _ambientLight;
	}

	public void setAmbientLight(AmbientLight _ambientLight) {
		this._ambientLight = _ambientLight;
	}
	public Geometries getGeometries() {
		return _geometries;
	}
	
	public void setGeomtries(Geometries _geometries) {
		this._geometries = _geometries;
	}

	public void addGeometry(Geometry g) {
		_geometries.add(g);
	}
	public List<Point3D> getRayIntersections(Ray r){
		return _geometries.findIntersections(r);
	}

}
