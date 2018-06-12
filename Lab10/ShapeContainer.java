import java.util.ArrayList;
import java.util.List;

public class ShapeContainer {
    List<Shape> shapes = new ArrayList<>();

    public void add(Shape shape){
        shapes.add(shape);
    }

    public void display(){
        for(Shape s:shapes){
            s.display();
        }
    }

}
