package primitives;

public class Color {
	private int red;
	private int green;
	private int blue;
	
	public Color() {
		red = 0;
		green = 0;
		blue = 0;
	}
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
		r = (red > 255) ? red : 255;
		g = (green > 255) ? green : 255;
		b = (blue > 255) ? blue : 255;
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
