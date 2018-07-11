package elements;

import primitives.*;

public class AmbientLight extends Light{
	
	//ambient constant
	private double Ka;
	
	// ***************** Constructors ********************** //
	
	/**
	 * regular constructor
	 * @param _color
	 * @param ka
	 */
	public AmbientLight(Color _color,double ka) {
		super(_color);
		this.Ka = ka;
	}
	
	/**
	 * copy constructor
	 * @param ambientLight
	 */
	public AmbientLight(AmbientLight ambientLight) {
		super(ambientLight._color);
		this.Ka = ambientLight.Ka;
	}
	
	/**
	 * default constructor
	 */
	public AmbientLight() {
		super(new Color(25,100,100));
		this.Ka = 0.8;
	}
	
	
	// ***************** Getters/Setters ********************** //
	
	/**
	 * gets the intensity of the ambient light
	 * 
	 */
	public Color getIntensity() {
		_color.scale(Ka);
		return new Color(_color);
	}
	
	public double getKa() {
		return Ka;
	}
	
	public void setKa(double ka) {
		Ka = ka;
	}

}
