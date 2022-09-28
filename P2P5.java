//BY 21ce109 VARUN PITHIYA
/*Question :
Develop a Program that illustrate method overloading concept */

class P2P5
{
    public static void main(String[]args)
    {
        //Method overloading means same function name but with different arguments
        Add(2,3);  //Both arguments are integer
        Add(1.54,2);  //First arguements is double and other integer
        Add(5.67,23.4);  //Both arguments are double
    }
    static void Add(int a,int b)
    {
        System.out.println(a+" + "+b+" = "+(a+b));
    }
    static void Add(double a,int b)
    {
        System.out.println(a+" + "+b+" = "+(a+b));
    }
    static void Add(double a,double b)
    {
        System.out.println(a+" + "+b+" = "+(a+b));
    }
}

