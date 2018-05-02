package primitives;

public class Color {
	private int red;
	private int green;
	private int blue;
	
	// ***************** Constructors ********************** //
	/**
	 * Default Constructors
	 */
	public Color() {
		red = 0;
		green = 0;
		blue = 0;
	}
	/**
	 * Constructors that get red green and blue
	 * @param r
	 * @param g
	 * @param b
	 */
	public Color(int r,int g,int b) {
		red = r;
		green = g;
		blue = b;
	}
	public void scale(double d) {
		if(d < 0) {
			throw new IllegalArgumentException("number must be more then 0");
		}
		red *= d;
		green *= d;
		blue *= d;
	}
	public void add(Color c) {
		red += c.red;
		green += c.green;
		blue += c.blue;
	}
	public void reduce(double d) {
		if(d <= 0) {
			throw new IllegalArgumentException("number must be more then 0");
		}
		scale(1/d);
	}
	
	// ***************** Getters/Setters ********************** //
	public int getRed() {
		return red;
	}
	public void setRed(int red) {
		this.red = red;
	}
	public int getGreen() {
		return green;
	}
	public void setGreen(int green) {
		this.green = green;
	}
	public int getBlue() {
		return blue;
	}
	public void setBlue(int blue) {
		this.blue = blue;
	}
	public java.awt.Color getColor() {
		int r,g,b;
		r = (red > 255) ? 255 : red;
		g = (green > 255) ? 255 : green;
		b = (blue > 255) ? 255 : blue;
		return new java.awt.Color(r, g, b);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Color other = (Color) obj;
		if (blue != other.blue)
			return false;
		if (green != other.green)
			return false;
		if (red != other.red)
			return false;
		return true;
	}
}
