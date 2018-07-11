package scene;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import elements.*;
import geometries.*;
import primitives.*;

public class Scene {
	private String _sceneName;
	private Color _background;
	private AmbientLight _ambientLight;
	private List<LightSource> _lights;
	private Geometries _geometries;
	private Camera _camera;
	private double _screenDistance;
	
	// at what distance will objects be in focus
	private double _focalLength;
	
	// this value essentially decides how "fast" objects 
	// becomes out of focus when moving away from the focal distance
	private double _aperatureRadius;

	/**
	 * 
	 * @param _sceneName
	 * @throws IllegalArgumentException
	 */
	public Scene(String _sceneName) throws IllegalArgumentException  {
		this._ambientLight = new AmbientLight();
		this._sceneName = _sceneName;
		this._background = new Color(100, 100, 100);
		this._geometries = new Geometries();
		this._camera = new Camera(new Point3D(0,0,5), new Vector(0,1,0), new Vector(0,0,-1));
		this._screenDistance = 50;
		this._lights = new ArrayList<>();
		this._focalLength = 50;
		this._aperatureRadius = 10;
	}
	
	/**
	 * 
	 * @param sceneName
	 * @param background
	 * @param ambientLight
	 * @param geometries
	 * @param camera
	 * @param screenDistance
	 * @param lightsSource
	 * @param focalLength
	 * @param aperatureRadius
	 * @throws Exception
	 */
	public Scene(String sceneName, Color background, AmbientLight ambientLight, Geometries geometries, Camera camera, double screenDistance, List<LightSource> lightsSource, double focalLength,double aperatureRadius) throws Exception {
		super();
		this._sceneName = sceneName;
		this._background = new Color(background);
		this._ambientLight = new AmbientLight(ambientLight);
		this._geometries = new Geometries(_geometries);
		this._camera = new Camera(camera);
		this._screenDistance = screenDistance;
		this._lights = lightsSource;
		this._focalLength = focalLength;
		this._aperatureRadius = aperatureRadius;
	}
	
	/**
	 * 
	 * @param s
	 * @throws IllegalArgumentException
	 */
	public Scene(Scene s) throws IllegalArgumentException {
		super();
		this._sceneName = s._sceneName;
		this._background = new Color(s._background);
		this._ambientLight = new AmbientLight(s._ambientLight);
		this._geometries = new Geometries(s._geometries);
		this._camera = new Camera(s._camera);
		this._screenDistance = s._screenDistance;
		this._focalLength = s._focalLength;
		this._aperatureRadius = s._aperatureRadius;

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
	
	public double get_focalLength() {
		return _focalLength;
	}

	public void set_focalLength(double _focalLength) {
		this._focalLength = _focalLength;
	}

	public double get_aperatureRadius() {
		return _aperatureRadius;
	}

	public void set_aperatureRadius(double _aperatureRadius) {
		this._aperatureRadius = _aperatureRadius;
	}

	public void setGeomtries(Geometries _geometries) {
		this._geometries = _geometries;
	}

	/**
	 * add given geometry to the list 
	 * (essentially adding it to the scene)
	 * @param g
	 */
	public void addGeometry(Geometry g) {
		_geometries.add(g);
	}
	
	/**
	 * gets ray intersections with the geometries in the scene
	 * @param r
	 * @return Map<Geometry,List<Point3D>> ray intersections
	 */
	public Map<Geometry,List<Point3D>> getRayIntersections(Ray r){
		return _geometries.findIntersections(r);
	}
	
	public List<LightSource> getLights() {
		return _lights;
	}

	/**
	 * size of list of lights
	 * (how many lights in the scene
	 * @return integer
	 */
	public int lightsSize() {
		return _lights.size();
	}

	/**
	 * adds given light to the scene
	 * @param e
	 * @return list of lights in the scene
	 */
	public boolean addLight(LightSource e) {
		return _lights.add(e);
	}
	
	/**
	 * remove given light to the scene
	 * @param e
	 * @return list of lights in the scene
	 */
	public boolean removeLight(Object o) {
		return _lights.remove(o);
	}

	/**
	 * returns the light at the given index of the list of lights in the scene
	 * @param index
	 * @return light source
	 */
	public LightSource getLightByIndex(int index) {
		return _lights.get(index);
	}

	/**
	 * removes the light at the given index of the list of lights in the scene
	 * @param index
	 * @return light source
	 */
	public LightSource removeLightByIndex(int index) {
		return _lights.remove(index);
	}

}
