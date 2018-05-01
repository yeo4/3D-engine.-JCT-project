package elements;

import primitives.*;

public class AmbientLight extends Light{
	private double Ka;

	public AmbientLight(Color _color,double ka) {
		super(_color);
		this.Ka = ka;
	}
	public AmbientLight() {
		super(new Color(255,255,255));
		this.Ka = 1;
	}
	
	@Override
	public Color getIntensity() {
		Color c = new Color();
		c.scale(Ka);
		//Need to do new()?
		return c;
	}
	
	public double getKa() {
		return Ka;
	}
	public void setKa(double ka) {
		Ka = ka;
	}

}
