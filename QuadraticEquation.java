/** 
 * 1. Quadratic Equation [20 points]
 * Write a Java code that calculates the roots 'p' and 'q' of
 * a quadratic equation ax^2 + bx + c = 0, 
 * where a, b and c are real numbers.
 * Using different cases validate the following equations:
 * 
 * @author Fabian_Cuero
 */

// class to perform the calculations for the quadratic equation
class Calculations{
    // setup private variables
    private double a, b, c, p, q, determinant, real, imaginary;
    private String condition = "less";
    
    // constructor 
    Calculations(){}
    
    // method to calculate the quadratic equation
    public void calculate(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
        this.determinant = Math.pow(this.b, 2) - 4 * (a * c);
        // print the values passed
        System.out.println("a = " + this.a + "; b = "
                + this.b + "; c = " + this.c
                + "; Determinant = " + this.determinant);
        
        // check to see if the condition is greater than 0
        if(determinant > 0) {
            condition = "greater";
            p = (-b + Math.sqrt(determinant)) / (2 * a);
            q = (-b - Math.sqrt(determinant)) / (2 * a);
        }
        // Condition for real and equal roots
        else if(determinant == 0) {
            condition = "equals";
            p = q = -b / (2 * a);
        }
        // If roots are not real
        else {
            condition = "less";
            real = -b / (2 *a);
            imaginary = Math.sqrt(-determinant) / (2 * a);
            
            p = real + imaginary;
            q = real - imaginary;
        }
        // print the calculated values
        System.out.println("p = " + p + "; q = " + q 
                + "; Real = " + real + " Imaginary = " + imaginary);
        
        // call the methods to get he sum and product
        sumEquation();
        productEquation();
    } // end calculate
    
    // method to calculate the sum
    private void sumEquation(){
        double sum = p+q;
        System.out.println("Sum = " + sum);
    } // end sumEquation
    
    // method to calculate the product
    private void productEquation(){
        // local variable
        double product = 0.0;
        // use the switch statement to get the product
        switch(condition){
            case "greater":
            case "equals":
                product = p*q;
                break;
            case "less":
                product = Math.pow(real, 2) + Math.pow(imaginary, 2);
                break;
        } // end switch
        // print the final product
        System.out.println("Product = " + product);
    } // end productEquation
    
}
public class QuadraticEquation {
    
    public static void main(String[] args){
        // create the test cases array
        double testCase1[] = { 2.3, 3.0, 8.8, 55.0, 1. };
        double testCase2[] = { 4.0, 77.0, 9.0, 33.4, 2. };
        double testCase3[] = { 5.6, 4.4, 15.2, 2.8, 1. };
        // create new object
        Calculations calc = new Calculations();
        // loop thru the array and pass the values to the method
        for (int i = 0; i < testCase1.length; i++){
            int count = i+1;
            System.out.println("Test Case: #" + count);
            calc.calculate(testCase1[i], testCase2[i], testCase3[i]);
            System.out.println();
        } // end for i
    } // end main
}
