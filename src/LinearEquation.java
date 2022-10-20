public class LinearEquation {
    /* Instance Variables */
    private int x1;
    private int y1;
    private int x2;
    private int y2;


    /* Creates a LinearEquation object */
/* PRECONDITION: x1 and x2 are NOT equal (client programs are responsible for ensuring
   this precondition is not violated) */
    public LinearEquation(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }


/* Calculates and returns distance between (x1, y1) and (x2, y2), rounded to
   the nearest hundredth */
    public double distance(){
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)); // using distance forumla which is sqrt ((x2-x1)^2 + (y2-y1)^2)
        return roundedToHundredth(distance);
    }



    /* Calculates and returns the y-intercept of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double yIntercept(){
        return roundedToHundredth(y1 - slope() * x1); // use formula y=mx+b and solved for b=y-mx
    }



    /* Calculates and returns the slope of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double slope(){
        double slope = (double)(y2 - y1)/(x2 - x1);
        return roundedToHundredth(slope);
    }


    /* Returns a String that represents the linear equation of the line through points
       (x1, y1) and (x2, y2) in slope-intercept (y = mx + b) form, e.g. "y = 3x + 1.5".

        When generating the m value (slope), here are examples of "printable" slopes:
           5, -5, 1/2, 6/8 (reducing not required), 8/5, -2/3, -18/7

        Here are non-examples of "printable" slopes:
     1/-2 (should be -1/2), -4/-3 (should be 4/3), 8/4 (should be reduced to 2),
           -12/3 (should be -4), 3/3 (should be 1), -6/6 (should be -1)

        HINT: Be sure to check if the line is horizontal and return an appropriate string,
        e.g. y = 6
        HINT: Absolute value might be helpful for ensuring proper placement of negative sign!


        When generating the b value, here are some examples of "printable" y-intercepts:
           + 1.0 	- 2.35	      + 12.5		- 8.0		+ 17.19

        Here are non-examples of "printable" y-intercepts:
           - -1.0 	+ -2.35	- -12.5	+ -8.0	     - -17.19	+ 0	- 0

        HINT: Absolute value might be helpful for printing negative y-intercepts as
               subtraction!
     */
    public String equation(){
        // create the slope as an absolute value fraction
        String slopeFrac = String.valueOf(Math.abs(y2-y1)) + "/" + String.valueOf(Math.abs(x2-x1)) + "x";

        // write slope as a whole number if it can be
        if ((y2-y1)%(x2-x1) == 0){
            slopeFrac = String.valueOf(Math.abs((y2-y1)/(x2-x1)))+ "x";
        }

        // if slope is 0, 1, -1, or a negative other than -1
        if(slope() == 0){
            return "y = " + y1;
        } else if(slope() == 1){
            slopeFrac = "x";
        } else if(slope() == -1){ // comes before <0 so that it will not become -1x
            slopeFrac = "-x";
        } else if(slope() < 0){
            slopeFrac = "-" + slopeFrac;
        }

        String yInt = String.valueOf(Math.abs(yIntercept())); // absolute value of y intercept to help with formatting
        if (yIntercept() < 0){
            yInt = " - " + yInt; // if y intercept is - add a - in front of absolute value of yint
        } else if (yIntercept() > 0){
            yInt = " + " + yInt; // if y intercept is + add a + in front
        } else {
            yInt = ""; // if y intercept is nothing, set yint to nothing so it doesnt print anything
        }

        // no need for "x" or "+" or "-" because it is included above
        return "y = " + slopeFrac + yInt;
    }





    /* Returns a String of the coordinate point on the line that has the given x value, with
       both x and y coordinates as decimals to the nearest hundredth, e.g (-5.0, 6.75) */
    public String coordinateForX(double xValue){
        return "(" + roundedToHundredth(xValue) + "," + roundedToHundredth(slope()*xValue + yIntercept()) + ")";
    }





    /* "Helper" method for use elsewhere in your methods; returns the value toRound rounded
        to the nearest hundredth

        HINT:  the Math.round method can help with this!
     */
    public double roundedToHundredth(double toRound){
        return Math.round(toRound*100)/(double)100;
    }



    /* Returns a string that includes all information about the linear equation, each on
       separate lines:
         - The original points: (x1, y1) and (x2, y2)
         - The equation of the line in y = mx + b format (using equation() method)
         - The slope of the line, as a decimal (using slope() method)
         - The y-intercept of the line (using yIntercept() method)
         - The distance between the two points (using distance() method)

      This method should call all other appropriate methods to get the info it needs:
      equation(), slope(), yIntercept(), distance().

      */
    public String lineInfo(){
        if (x1 == x2){
            return "These points are on a vertical line: x=" + x1;
        } else {
            String coord1 = "(" + x1 + ", " + y1 + ")";
            String coord2 = "(" + x2 + ", " + y2 + ")";
            return "The two points are: " + coord1 + " and " + coord2 + "\n" + "The equation of the line between these points is: " + equation() + "\n" + "The slope of this line is: " + slope() + "\n" +  "The y-intercept of this line is: " + yIntercept() + "\n" + "The distance between the two points is: " + distance();
        }
    }

    public String start(){
        return "Welcome!";
    }



}
