package primitives;

public class Color {
	private int _red;
	private int _green;
	private int _blue;

	// ***************** Constructors ********************** //
	/**
	 * Default Constructor
	 */
	public Color() {
		_red = 0;
		_green = 0;
		_blue = 0;
	}

	/**
	 * Constructor that get red green and blue
	 * 
	 * @param r
	 * @param g
	 * @param b
	 */
	public Color(int r, int g, int b) {
		if (r < 0 || g < 0 || b < 0) {
			throw new IllegalArgumentException("R:" + (r < 0) + "G:" + (g < 0) + "B:" + (b < 0));
		}
		_red = r;
		_green = g;
		_blue = b;
	}

	/**
	 * Copy Constructor
	 * 
	 * @param other
	 */
	public Color(Color other) {
		_red = other._red;
		_green = other._green;
		_blue = other._blue;
	}

	/**
	 * Copy Constructor
	 * 
	 * @param color
	 */
	public Color(java.awt.Color color) {
		_red = color.getRed();
		_green = color.getGreen();
		_blue = color.getBlue();
	}

	// ***************** Getters/Setters ********************** //
	public int getRed() {
		return _red;
	}

	public void setRed(int red) {
		this._red = red;
	}

	public int getGreen() {
		return _green;
	}

	public void setGreen(int green) {
		this._green = green;
	}

	public int getBlue() {
		return _blue;
	}

	public void setBlue(int blue) {
		this._blue = blue;
	}

	public java.awt.Color getColor() {
		int r, g, b;
		r = (_red > 255) ? 255 : _red;
		g = (_green > 255) ? 255 : _green;
		b = (_blue > 255) ? 255 : _blue;
		return new java.awt.Color(r, g, b);
	}

	// ***************** Administration ******************** //

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Color other = (Color) obj;
		if (_blue != other._blue)
			return false;
		if (_green != other._green)
			return false;
		if (_red != other._red)
			return false;
		return true;
	}

	// ***************** Operations ******************** //
	/**
	 * @param AWT
	 *            colors to add to our color
	 * @return our color with adding colors
	 */
	public Color add(java.awt.Color... colors) {
		for (java.awt.Color color : colors) {
			_red = color.getRed();
			_green = color.getGreen();
			_blue = color.getBlue();
		}

		return this;
	}

	/**
	 * @param colors
	 *            to add to our color
	 * @return our color with adding colors
	 */
	public Color add(Color... colors) {
		for (Color color : colors) {
			_red += color._red;
			_green += color._green;
			_blue += color._blue;
		}

		return this;
	}

	public Color scale(double d) {
		if (d < 0) {
			throw new IllegalArgumentException("number must be more then 0");
		}
		_red *= d;
		_green *= d;
		_blue *= d;

		return this;
	}

	public Color reduce(double d) {
		if (d <= 0) {
			throw new IllegalArgumentException("number must be more then 0");
		}
		scale(1 / d);

		return this;
	}
}
