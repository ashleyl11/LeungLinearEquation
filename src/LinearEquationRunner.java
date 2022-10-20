import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // welcomes the user
        System.out.println("Welcome!");
        // asking user for cooridnate pairs
        System.out.print("Enter coordinate 1: ");
        String coordPair1 = scan.nextLine();
        System.out.print("Enter coordinate 2: ");
        String coordPair2 = scan.nextLine();

        // obtaining int values of coordinates
        int commaIndex1 =  coordPair1.indexOf(",");
        int length1 = coordPair1.length();
        int commaIndex2 = coordPair2.indexOf(",");
        int length2 = coordPair2.length();

        int x1 = Integer.parseInt(coordPair1.substring(1,commaIndex1));
        int y1 = Integer.parseInt(coordPair1.substring(commaIndex1+2, length1-1));

        int x2 = Integer.parseInt(coordPair2.substring(1,commaIndex2));
        int y2 = Integer.parseInt(coordPair2.substring(commaIndex2+2, length2-1));

        System.out.println();

        if (x1 == x2) {
            System.out.println("These points are on a vertical line: x = " + x1);
        } else {
            LinearEquation test1 = new LinearEquation(x1, y1, x2, y2);
            System.out.println(test1.lineInfo());

            System.out.println();

            System.out.print("Enter a value for x: ");
            double userXVal = scan.nextDouble();
            scan.nextLine();

            System.out.println("The point on the line is " + test1.coordinateForX(userXVal));

        }
    }
}
