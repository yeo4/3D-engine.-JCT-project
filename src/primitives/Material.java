package primitives;

public class Material {
	//final?
	
	private double _Kd,_Ks,_Kr,_Kt;
	private int nShininess;
	
	// ***************** Constructors ********************** //

	public Material(double _Kd, double _Ks, int nShininess, double _Kr, double _Kt) {
		this._Kd = _Kd;
		this._Ks = _Ks;
		this._Kr = _Kr;
		this._Kt = _Kt;
		this.nShininess = nShininess;
	}
	public Material(Material material) {
		this._Kd = material._Kd;
		this._Ks = material._Ks;
		this._Kr = material._Kr;
		this._Kt = material._Kt;
		this.nShininess = material.nShininess;
	}
	// ***************** Operations ******************** // 
	// ***************** Getters/Setters ********************** //
	public double get_Kd() {
		return _Kd;
	}

	public void set_Kd(double _Kd) {
		this._Kd = _Kd;
	}

	public double get_Ks() {
		return _Ks;
	}

	public void set_Ks(double _Ks) {
		this._Ks = _Ks;
	}

	public int getnShininess() {
		return nShininess;
	}

	public void setnShininess(int nShininess) {
		this.nShininess = nShininess;
	}
	public double get_Kr() {
		return _Kr;
	}
	public void set_Kr(double _Kr) {
		this._Kr = _Kr;
	}
	public double get_Kt() {
		return _Kt;
	}
	public void set_Kt(double _Kt) {
		this._Kt = _Kt;
	}
	
}
