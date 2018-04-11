package elements;

import primitives.*;

public class Camera { 
	
	//TEST123
	
	private Point3D _p0;
	private Vector _vUp;
	private Vector _vTo;
	private Vector _vRight;
	
	// ***************** Constructors ********************** //
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

	// ***************** Administration  ******************** // 
	
	@Override
	public String toString()
	{
	return "Vto: " + _vTo + "\n" + "Vup: " + _vUp + "\n" + "Vright:" + _vRight + ".";
	}
	
	// ***************** Operations ******************** // 
	public Ray constructRayThroughPixel(int Nx, int Ny, int i, int j, double screenDistance, double screenWidth, double screenHeight)
	{
		Point3D Pc = this._p0.add(_vTo.multiply(screenDistance));
		double Ry = screenHeight/Ny;
		double Rx = screenWidth/Nx;
		double Yj = ((double)j - (double)Ny/2)*Ry - Ry/2;
		double Xi = ((double)i - (double)Nx/2)*Rx - Rx/2;
		Point3D Pij = Pc.add(_vRight.multiply(Xi).subtract(_vUp.multiply(Yj)));
		Vector Vij = new Vector(Pij.subtract(this._p0));
		return new Ray(new Point3D(this._p0), new Vector(Vij));
	}
}

