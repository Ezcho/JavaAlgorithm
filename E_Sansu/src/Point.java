import java.util.Scanner;

public class Point {
    private double xCoordinate= 0, yCoordinate=0;
    public Point(){}
    public Point(double x, double y){
        xCoordinate = x;
        yCoordinate = y;
    }
    public double getxCoordinate(){return xCoordinate;}
    public double getyCoordinate(){return yCoordinate;}
    public int getQuadrant(){
        if(xCoordinate > 0&& yCoordinate >0)
            return 1;
        else if(xCoordinate < 0&& yCoordinate > 0)
            return 2;
        else if(xCoordinate < 0 && yCoordinate <0)
            return 3;
        else if(xCoordinate > 0&& yCoordinate < 0)
            return 4;
        else
            return 0;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter point 1: ");
        double x = in.nextDouble();
        double y = in.nextDouble();
        Point p1 = new Point(x, y);
        
        System.out.print("Enter point 2: ");
        x = in.nextDouble();
        y = in.nextDouble();
        Point p2 = new Point(x, y);
        
        System.out.println("Quadrant of (" + p1.getxCoordinate() + ", " + 
        		+ p1.getyCoordinate() + ") = " + p1.getQuadrant());
        System.out.println("Quadrant of " + "(" + p2.getxCoordinate() + ", " + 
        		+ p2.getyCoordinate() + ") = " + p2.getQuadrant());
        
        System.out.println("Distance between 2 points (" + p1.getxCoordinate() 
        		+ ", " + p1.getyCoordinate() + ") and (" + p2.getxCoordinate() 
        		+ ", " + p2.getyCoordinate() + ") = "
        		+ String.format("%.2f", distanceBetweenPoints(p1, p2)) );
        
        in.close();
        
    }
    public static double distanceBetweenPoints(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.xCoordinate-p2.xCoordinate,2)+Math.pow(p1.yCoordinate-p2.yCoordinate,2));}
}