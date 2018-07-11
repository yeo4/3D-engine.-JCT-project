package geometries;

import primitives.*;

public abstract class RadialGeometry extends Geometry {
	protected double _radius;
	
	// ***************** Constructors ********************** //
	
	/**
	 * 
	 * @param r
	 * @param emission
	 * @param material
	 */
	public RadialGeometry(double r, Color emission, Material material){
		if(r<=0)
			throw new IllegalArgumentException("Radius must be positive");
		_radius = r;
		this._emission = new Color(emission);
		this._material = new Material(material);
	}
	
	/**
	 * 
	 * @param rg
	 */
	public RadialGeometry(RadialGeometry rg){
		_radius = rg._radius;
		this._emission = new Color(rg._emission);
		this._material = new Material(rg._material);
	}

	// ***************** Getters/Setters ********************** // 
	
	public double get_radius() {
		return _radius;
	}

	/*public void set_radius(double _radius) {
		this._radius = _radius;
	}*/
	
	// ***************** Administration  ******************** // 
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RadialGeometry other = (RadialGeometry) obj;
		if (Double.doubleToLongBits(_radius) != Double.doubleToLongBits(other._radius))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString() + "RadialGeometry [_radius=" + _radius + "]";
	}


	
}
