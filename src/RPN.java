import java.util.Scanner;

class StackNode
{  
	/*Stacks constructor with parameters*/
    public StackNode(double data, StackNode underneath) {
   	 /*calling the function of all stacks parameters*/
        this.data = data;
        this.underneath = underneath;
     }
        //Declaration of the StackNode constructor parameters
        public StackNode underneath;
        public double data;
 }


public class RPN {
	        public void into(double new_data) 
	        {
	        StackNode new_node = new StackNode(new_data, top);
	        top = new_node;
	      }
	
	        public double outof( )
	        {
	           double top_data = top.data;
	           top = top.underneath;
	           return top_data;
	     }
	     //RPN calculator method to act on a given command
	     public RPN(String command) 
	     {
	       top = null;
	       this.command = command;/*calling the command parameter*/
	     }
	
	     public double get( ) //Getter method
	     {
	        double a, b;
	        int j;
	    
	       for(int i = 0; i < command.length( ); i++)
	       {
	           // if it's a digit
	            if(Character.isDigit(command.charAt(i))) 
	            {
	                 double number;
	
	                  // get a string of the number
	                  String temp = "";
	                  for(j = 0; (j < 100) && (Character.isDigit(command.charAt(i)) || (command.charAt(i) == '.')); j++, i++) 
	                  {
	                      temp = temp + String.valueOf(command.charAt(i));
	                  }
	
                    // convert to double and add to the stack conditions
	                  number = Double.parseDouble(temp);
	                  into(number);
	                  } 
	                    else if(command.charAt(i) == '+') {/*adds top two elements in the stack, and replaces them in the stack with the answer.*/
	                        b = outof( );
	                        a = outof( );
	                        into(a + b);
	                  }   
	                    else if(command.charAt(i) == '-') {/*subtracts the top two elements in the stack, and replaces them in the stack with the answer.*/
	                    b = outof( );
	                    a = outof( );
	                     into(a - b);
	                  } 
	                    else if(command.charAt(i) == '*') {/*multiplies the top two elements in the stack, and replaces them in the stack with the answer*/
	                    b = outof( );
	                    a = outof( );
	                    into(a * b);
	                  } 
	                    else if(command.charAt(i) == '/') {/*divides the top two elements in the stack, and replaces them in the stack with the answer*/
	                    b = outof( );
	                    a = outof( );
	                    into(a / b);
	                  }
	
	                    else if(command.charAt(i) == '^') {/*exponentiation operation were x y^ would be x to the yth power (x^y).*/
	                    b = outof( );
	                    a = outof( );
	                    into(Math.pow(a, b));
	                  }
	                    else if(command.charAt(i) != ' ') {
	                      throw new IllegalArgumentException( );
	             }
	        }
	
	        double val = outof( );
	            return val; /*returning the value*/
	       }
	       //Declaration of the variables
	       private String command;
	       private StackNode top;
	
	        /* main method */
	       public static void main(String args[]) 
	       {
	    	   Scanner in = new Scanner(System.in);
	           while(true) 
	           {
			
	               System.out.println("Enter RPN expression or \"quit\".");/*Input display*/
	               String line = in.nextLine( );
	               if(line.equals("quit")) /*Condition for quiting the calculator*/
	               {
	                   in.close();
	            	   break;
	               } else {
	                  RPN calc = new RPN(line);
	                  System.out.printf("Answer is %f\n" , calc.get( ));/*Output/answer display*/
	               }
	           } 
	     }
	}

		