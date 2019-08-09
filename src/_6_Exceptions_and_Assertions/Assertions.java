package _6_Exceptions_and_Assertions;

// signature -
// assert boolean_expression;
// assert boolean_expression: error_message;
//
//  Enabling assertions
//  java -enableassertions Rectangle
//  java -ea Rectangle
//  java -ea:com.wiley.demos... my.programs.Main
public class Assertions {

    public static void main(String[] args) {

        int numGuests = -5;
        assert numGuests > 0;
        System.out.println(numGuests);
    }

}



