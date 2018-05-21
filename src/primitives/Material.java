package primitives;

public class Material {
	//final?
	
	private double _Kd,_Ks;
	private int nShininess;
	
	// ***************** Constructors ********************** //

	public Material(double _Kd, double _Ks, int nShininess) {
		this._Kd = _Kd;
		this._Ks = _Ks;
		this.nShininess = nShininess;
	}
	public Material(Material material) {
		this._Kd = material._Kd;
		this._Ks = material._Ks;
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
	
}
