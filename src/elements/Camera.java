package elements;

import primitives.*;

public class Camera { 
	

	//cameras origin point
	private Point3D _p0;
	
	//three vectors defining the camera
	private Vector _vUp;
	private Vector _vTo;
	private Vector _vRight;
	
	// ***************** Constructors ********************** //
	
	/**
	 * regular constructor, calculates vRight using the other two vectors received
	 * @param _p0
	 * @param _vUp
	 * @param _vTo
	 * @throws IllegalArgumentException
	 */
	public Camera(Point3D _p0, Vector _vUp, Vector _vTo) throws IllegalArgumentException {
		if(_vUp.equals(Vector.ZeroVector) || _vTo.equals(Vector.ZeroVector))
			throw new IllegalArgumentException("All vectors must not be zero");
		if(_vUp.dot_product(_vTo) != 0)
			throw new IllegalArgumentException("Vectors must be perpendicular");
		this._p0 = _p0;
		this._vUp = _vUp.normalization();
		this._vTo = _vTo.normalization();
		this._vRight = this._vTo.cross_product(this._vUp).normalization();
		
	}
	
	/**
	 * copy constructor
	 * @param c
	 */
	public Camera(Camera c)
	{
		this._p0 = c._p0;
		this._vRight = c._vRight;
		this._vTo = c._vTo;
		this._vUp = c._vUp;
	}
	
	// ***************** Administration  ******************** // 
	
	public Point3D get_p0() {
		return _p0;
	}

	public Vector get_vUp() {
		return _vUp;
	}

	public Vector get_vTo() {
		return _vTo;
	}

	public Vector get_vRight() {
		return _vRight;
	}

	@Override
	public String toString()
	{
	return "Vto: " + _vTo + "\n" + "Vup: " + _vUp + "\n" + "Vright:" + _vRight + ".";
	}
	
	// ***************** Operations ******************** // 
	
	/**
	 * constructs a ray through the given pixel 
	 * and returns that ray
	 * 
	 * @param Nx
	 * @param Ny
	 * @param i
	 * @param j
	 * @param screenDistance
	 * @param screenWidth
	 * @param screenHeight
	 * @return
	 */
	public Ray constructRayThroughPixel(int Nx, int Ny, int i, int j, double screenDistance, double screenWidth, double screenHeight)
	{
		Point3D Pc = this._p0.add(_vTo.multiply(screenDistance));
		double Ry = screenHeight/Ny;
		double Rx = screenWidth/Nx;
		double Yj = ((double)j - (double)Ny/2)*Ry + Ry/2;
		double Xi = ((double)i - (double)Nx/2)*Rx + Rx/2;
		Point3D Pij = Pc.add(_vRight.multiply(Xi).subtract(_vUp.multiply(Yj)));
		Vector Vij = new Vector(Pij.subtract(this._p0));
		return new Ray(new Point3D(this._p0), new Vector(Vij));
	}
}

