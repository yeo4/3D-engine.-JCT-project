package geometries;

public abstract class RadialGeometry extends Geometry {
	protected double _radius;
	
	// ***************** Constructors ********************** //
	
	public RadialGeometry(double r) throws Exception{
		if(r<=0)
			throw new Exception("Radius must be positive");
		_radius = r;
	}
	
	public RadialGeometry() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RadialGeometry(RadialGeometry rg){
		_radius = rg._radius;
	}

	// ***************** Getters/Setters ********************** // 
	
	public double get_radius() {
		return _radius;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(_radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
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
