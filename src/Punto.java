import java.util.Locale;

public class Punto {
	
	private double x,y;
	
	public Punto(double x, double y) {
		this.x=x;
		this.y=y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return String.format(Locale.US, "(%.1f,%.1f)",x,y);
	}
	
	
}
