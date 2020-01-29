package assignment9;
import java.util.ArrayList;
import assignment9.Shape.Shapes;

public class ShapeFactory {
	
	public static Shape CreateShape(String type,Point p,ArrayList<Integer> parameters)
	{
		Shape shape=null;
		if(Shapes.TRIANGLE.equals(type))
		{
			shape=new Triangle(parameters,p);
		}
		
		else if(Shapes.SQUARE.equals(type))
		{
			shape=new Square(parameters,p);
		}
		
		else if(Shapes.RECTANGLE.equals(type))
		{
			shape=new Rectangle(parameters,p);
		}
		
		else if(Shapes.CIRCLE.equals(type))
		{
			shape=new Circle(parameters,p);
		}
		
		return shape;
				
	}

}