package scene;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import elements.*;
import geometries.*;
import primitives.*;

public class Scene {
	private String _sceneName;
	private Color _background;
	private List<Geometry> _geometries;
	private Camera _camera;
	private double _screenDistance;
	
	public Scene(String _sceneName) throws Exception {
		super();
		this._sceneName = _sceneName;
		_background = new Color(255, 255, 255);
		_camera = new Camera(new Point3D(0,	 0, 0), new Vector(0,0,0),new Vector(0,1,0));
		_screenDistance = 10;
		_geometries = new ArrayList<>();
	}

	public String get_sceneName() {
		return _sceneName;
	}

	public Color get_background() {
		return _background;
	}

	public void set_background(Color _background) {
		this._background = _background;
	}

	public Camera get_camera() {
		return _camera;
	}

	public void set_camera(Camera _camera) {
		this._camera = _camera;
	}

	public double get_screenDistance() {
		return _screenDistance;
	}

	public void set_screenDistance(double _screenDistance) {
		this._screenDistance = _screenDistance;
	}

	public void addGeometry(Geometry g) {
		_geometries.add(g);
		render();
	}
	private void render() {
		
	}
}
