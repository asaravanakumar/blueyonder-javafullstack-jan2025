package com.examples.java.core.enums;

/**
 * Enum is a special class to hold constant values
 */
public class EnumDemo {

	public enum Colors {
		BLUE(100), GREEN(200), RED(300);

		private int colorIndex;

		private Colors(int colorIndex) {
			this.colorIndex = colorIndex;
		}
	}
	

	
	public static void main(String[] args)
	{
		Colors color = Colors.BLUE;
//		Colors color = Colors.valueOf("BLUE");
		switch (color) {
			case BLUE:
				System.out.println("BLUE Color");
				break;
			case GREEN:
				System.out.println("GREEN Color");
				break;
			case RED:
				System.out.println("RED Color");
				break;
		}
	}

}
