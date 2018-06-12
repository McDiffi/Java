package Lab11;

abstract class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
        System.out.print("Object " + name + " has been created! (Lab11.Shape constructor)\n");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract double perimeter();
    abstract double area();
    void display(){
        System.out.print(name + " ma pole równe " + area() + " i obwód " + perimeter() + "\n");
    }
}

class Rectangle extends Shape {
    double width;
    double height;

    public Rectangle(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
        try {
           if(width < 0 || height < 0) throw new ArithmeticException("Rectangle dimmencsions cannot be smaller than 0.");
        } catch(ArithmeticException e){
            System.out.println("Error occured: " + e);
        }
        System.out.print("Object " + name + " has been created! (Lab11.Rectangle constructor)\n");
    }

    @Override
    double area() {
        return width*height;
    }

    @Override
    double perimeter() {
        return 2*width+2*height;
    }
}

class Square extends Rectangle {
    public Square(String name, double width) {
        super(name, width, width);
        System.out.print("Object " + name + " has been created! (Lab11.Square constructor)\n");
    }
}

class Circle extends Shape {
    double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    double perimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    double area() {
        return Math.PI*Math.pow(radius, 2);
    }
}
class Elipse extends Shape {
    double major_axis;
    double minor_axis;

    public Elipse(String name, double major_axis, double minor_axis) {
        super(name);
        this.major_axis = major_axis;
        this.minor_axis = minor_axis;
    }

    @Override
    double perimeter() {
        return Math.PI*(1.5*(major_axis+minor_axis)-Math.sqrt(major_axis*minor_axis));
    }

    @Override
    double area() {
        return Math.PI*major_axis*minor_axis;
    }
}