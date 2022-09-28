//BY 21ce109 VARUN PITHIYA
/*Question :
Design a class named Circle containing following attributes and behavior.
• One double data field named radius. The default value is 1.
• A no-argument constructor that creates a default circle.
• A Single argument constructor that creates a Circle with the specified radius.
• A method named getArea() that returns area of the Circle.
• A method named getPerimeter() that returns perimeter of it. */

class P2P1
{
    public static void main(String[]args)
    {
        //Creating a default Circle
        Circle C1=new Circle();
        System.out.println("Area of default circle : "+C1.getArea());
        System.out.println("Perimeter of default circle : "+C1.getPerimeter());

        //Creating a circle with specific radius
        Circle C2=new Circle(17);
        System.out.println("\nArea of circle 2 : "+C2.getArea());
        System.out.println("Perimeter of circle 2 : "+C2.getPerimeter());
    }
}

class Circle
{
    private double radius;

    Circle()
    {
        radius=1;
    }

    Circle(double radius)
    {
        this.radius=radius;
    }

    double getArea()
    {
        return 3.14*radius*radius;
    }
   
    double getPerimeter()
    {
        return 2*3.14*radius;
    }
}
