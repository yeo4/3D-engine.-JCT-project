package elements;

import primitives.*;

public class Camera { 
	private Point3D _p0;
	private Vector _vUp;
	private Vector _vTo;
	private Vector _vRight;
	
	public Camera(Point3D _p0, Vector _vUp, Vector _vTo) throws Exception {
		if(_vUp == Vector.ZeroVector || _vTo == Vector.ZeroVector)
			throw new Exception("All vectors must not be zero");
		if(_vUp.dot_product(_vTo) != 0)
			throw new Exception("Vectors must be perpendicular");
		this._p0 = _p0;
		this._vUp = _vUp.normalization();
		this._vTo = _vTo.normalization();
		this._vRight = this._vTo.cross_product(this._vUp).normalization();
		
	}
}

