package fr.tp.inf112.robotsim.model;

public class Component {

	protected String name;
	protected Position position;
	protected int width;
	protected int height;


	public Component(String name, Position position, int width, int height) {
		this.name = name;
		this.position = position;
		this.width = width;
		this.height = height;
	}
	
	public String getName() { return name; }
	public Position getPosition() { return position; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	
	public void setName(String name) { this.name = name; }
	public void setPosition(Position position) { this.position = position; }
	public void setWidth(int width) { this.width = width; }
	public void setHeight(int height) { this.height = height; }
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "[" + name + "] at " + position;
	}
}
