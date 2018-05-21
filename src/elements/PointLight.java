package elements;

import primitives.*;

public class PointLight extends Light implements LightSource{

	protected Point3D _position;
	protected double _Kc, _Kl, _Kq;
	
	
	// ***************** Constructors ********************** //

	public PointLight(Color _color, Point3D _position, double _Kc, double _Kl, double _Kq) {
		super(_color);
		this._position = new Point3D(_position);
		this._Kc = _Kc;
		this._Kl = _Kl;
		this._Kq = _Kq;
	}
	
	public PointLight(PointLight PL) {
		this(PL._color,PL._position,PL._Kc,PL._Kl,PL._Kq);
	}
	
	// ***************** Operations ******************** //
	
	
	@Override
	public Color getIntensity(Point3D point) {
		// TODO Auto-generated method stub
		return null;
	}

	// ***************** Getters/Setters ********************** // 
	
	public Point3D get_position() {
		return _position;
	}

	public void set_position(Point3D _position) {
		this._position = _position;
	}

	public double get_Kc() {
		return _Kc;
	}

	public void set_Kc(double _Kc) {
		this._Kc = _Kc;
	}

	public double get_Kl() {
		return _Kl;
	}

	public void set_Kl(double _Kl) {
		this._Kl = _Kl;
	}

	public double get_Kq() {
		return _Kq;
	}

	public void set_Kq(double _Kq) {
		this._Kq = _Kq;
	}

	@Override
	public Vector getL(Point3D point) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getD(Point3D point) {
		// TODO Auto-generated method stub
		return null;
	}

}
