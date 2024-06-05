import java.util.*;
public class pfcalc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // initializes scanner variable to take user input

        // initializing stacks to take operators (c) and numbers (n)
        Stack<Character> c = new Stack<>();
        Stack<Integer> n = new Stack<>();

        boolean done = false; // var to stop loop
        while(!done){ // loops until user is done
            System.out.println("Enter your post-fix expression (press enter after each character, and 'n' when you're done): "); // prompts user
            String e = input.next(); // takes user input
            if(NumberCheck(e.charAt(0))){ // checks if its a number and inputs into stack if it is
            int num = e.charAt(0) - '0';
            n.push(num);
            }
            if(OperatorCheck(e.charAt(0))){ // checks if its an operator and if it is performs math and pushs the new num onto the n stack
                c.push(e.charAt(0)); // pushes op onto stack
                //pops vals and op for math
                int val1 = n.pop();
                int val2 = n.pop();
                char op = c.pop();
                n.push(DoMath(val1,val2,op)); // does math and pushes to stack
            }
            if(e.equalsIgnoreCase("n")) done = true; // stops loop when user wants
        }
        System.out.println(n.peek()); // prints the final value
    }
    static boolean NumberCheck(char po){
        return (po >= '0' && po <= '9'); // checks if the character is a number, luckily the numbers are all in order for ASCII values
    }
    static boolean OperatorCheck(char po){
        return (po == '+' || po  == '-' || po == '*' || po == '/' || po == '(' || po == ')'); // checks if the character is an operator, unfortunately ASCII values here are not in order so long or statement is necessary
    }
    static int Precedence(char op){ // attains the precedence of the given operator in order to know the order of operations
        switch(op){ // so i dont have to write a bunch of if statements
            case '+': case '-': return 1; // lowest priority gets the lowest number
            case '*': case '/': return 2;
            case '(': case ')': return 3; // highest priority gets the highest number
            default: return -1;
        }
    }
    static int DoMath(int val1, int val2, char op){ // takes values and performs an operation based on the operator
        switch(op){ // yay no if statement
            case '+': return val1 + val2; // adds for addition
            case '-': return val1 - val2; // subtracts for subtraction
            case '*': return val1 * val2; // multiplies for multiplication
        }
        return val1/val2; // if its not anything else then it must be division
    }
}
