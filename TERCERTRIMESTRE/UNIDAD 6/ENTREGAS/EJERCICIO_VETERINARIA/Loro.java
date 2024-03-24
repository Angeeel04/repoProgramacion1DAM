public class Loro extends Animal{
	String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Loro() {
		super();
		color = "";
	}

	public Loro(String nombre, int edad, String color) {
		super(nombre, edad);
		this.color = color;
	}
}