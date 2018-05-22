package elements;

import primitives.*;

public class PointLight extends Light implements LightSource {

	protected Point3D _position;
	protected double _Kc, _Kl, _Kq;

	// ***************** Constructors ********************** //

	public PointLight(Color _color, Point3D _position, double _Kc, double _Kl, double _Kq) {
		super(_color);

		if (_Kc < 1)
			throw new IllegalArgumentException("Kc must be bigger than 1");
		this._position = new Point3D(_position);
		this._Kc = _Kc;
		this._Kl = _Kl;
		this._Kq = _Kq;
	}

	public PointLight(PointLight PL) {
		this(PL._color, PL._position, PL._Kc, PL._Kl, PL._Kq);
	}

	// ***************** Operations ******************** //

	@Override
	public Vector getL(Point3D point) {
		return point.subtract(this._position).normalization();
	}

	@Override
	public Vector getD(Point3D point) {
		return getL(point);
	}

	@Override
	public Color getIntensity(Point3D point) {
		double distenceSquare = point.distanceSquare(this._position);
		double d;
		if (this._Kl == 0)
			d = this._Kc + this._Kq * distenceSquare;
		else
			d = this._Kc + this._Kl * Math.sqrt(distenceSquare) + this._Kq * distenceSquare;

		return new Color(this._color).reduce(d);
	}

	// ***************** Getters/Setters ********************** //

	public Point3D getPosition() {
		return _position;
	}

	public void setPosition(Point3D _position) {
		this._position = _position;
	}

	public double get_Kc() {
		return _Kc;
	}

	public void setKc(double _Kc) {
		this._Kc = _Kc;
	}

	public double getKl() {
		return _Kl;
	}

	public void setKl(double _Kl) {
		this._Kl = _Kl;
	}

	public double getKq() {
		return _Kq;
	}

	public void setKq(double _Kq) {
		this._Kq = _Kq;
	}

}
