package materials;

import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.linkedList.cs48.PolynomialSolver;


public class Main {
	
	public static void main(String [] args){
		
		char listChar = 0;
		
		PolynomialSolver poly = new PolynomialSolver ();
		
		while (true)
		{
		
		System.out.println("Please choose an action");
		System.out.println("-----------------------");
		System.out.println("1- Set a polynomial variable");
		System.out.println("2- Print the value of a polynomial variable");
		System.out.println("3- Add two polynomials");
		System.out.println("4- Subtract two polynomials");
		System.out.println("5- Multiply two polynomials");
		System.out.println("6- Evaluate a polynomial at some point");
		System.out.println("7- Clear a polynomial variable");
		System.out.println("====================================================================");
		
		Scanner s = new Scanner (System.in);
		int action = s.nextInt();
		
		if (action == 1)
		{
			System.out.println("Insert the variable name : A, B or C");
			
			listChar =s.next().charAt(0);	
			
			System.out.println("Insert the polynomial terms in the form exactly or an error will occur:");
			System.out.println("(coeff1, exponent1 ), (coeff2, exponent2 ), ..");
			
			//char garp =s.next().charAt(0);	
			
			String in = s.nextLine();
			in = s.nextLine();
			
			int size = 0;
			boolean isCorrect=false;
			
			for (int i =0 ;i<in.length();i++)
			{
				if (in.charAt(i) == '(' )
				{
					size ++;
					isCorrect = true;
				}
			}			
			
			if (isCorrect)
			{
				int[][] terms = new int [size][2];
				int j =0;
				int z=0;
				
				
				for (int i =0 ;i<in.length();i++)
				{
					String x = new String();
					String y = new String ();
					
					if (in.charAt(i) == '(')
					{
						z=i+1;
						while (in.charAt(z)!=',')
						{
							if (in.charAt(z) >='0' && in.charAt(z)<='9')
							{
								x +=in.charAt (z);
							}
							z++;
							
						}
						
						z=i+4;
						
						while (in.charAt(z)!=')')
						{
							if (in.charAt(z) >='0' && in.charAt(z)<='9')
							{
								y +=in.charAt (z);
							}
							z++;
						}
						
						terms [j][0]= Integer.parseInt(x);;
						terms [j][1]= Integer.parseInt(y);;	
						j++;
					}
				}
				
				poly.setPolynomial(listChar, terms);
				
				System.out.println("Polynomial A is set");
			}
		}
		
		else if (action ==2)
		{
			System.out.println("Insert the variable name : A, B, C");
			listChar =s.next().charAt(0);
			
			String print = new String();
			print = poly.print(listChar);
			
			if (print == null)
				System.out.println(""+listChar+" is empty");
			else
				System.out.println(print);
			
		}
		
		else if (action ==3)
		{
			System.out.println("Insert first operand variable name : A, B or C");
			
			char first = s.next().charAt(0);
			
			if (poly.print(first) == null)
				System.out.println(""+listChar+" is empty");
			
			else 
			{
				System.out.println("Insert second operand variable name : A, B or C");
				
				char second = s.next().charAt(0);
				
				if (poly.print(second) == null)
					System.out.println(""+listChar+" is empty");
				
				else 
				{
					int [][] r = new int [100][2];
					r=poly.add(first, second);
					
					int i=0;
					
					while (r[i][0]!=0 || r[i][1]!=0)
					{
						System.out.println("("+""+r[i][0]+","+""+r[i][1]+")");
						i++;
					}
					
				}
			}
		}
		
		else if (action ==4)
		{
			System.out.println("Insert first operand variable name : A, B or C");
			
			char first = s.next().charAt(0);
			
			if (poly.print(first) == null)
				System.out.println(""+listChar+" is empty");
			
			else 
			{
				System.out.println("Insert second operand variable name : A, B or C");
				
				char second = s.next().charAt(0);
				
				if (poly.print(second) == null)
					System.out.println(""+listChar+" is empty");
				
				else 
				{
					int [][] r = new int [100][2];
					r=poly.subtract(first, second);
					
					int i=0;
					
					while (r[i][0]!=0 || r[i][1]!=0)
					{
						System.out.println("("+""+r[i][0]+","+""+r[i][1]+")");
						i++;
					}
					
				}
			}
		}
		
		else if (action ==5)
		{
			System.out.println("Insert first operand variable name : A, B or C");
			
			char first = s.next().charAt(0);
			
			if (poly.print(first) == null)
				System.out.println(""+listChar+" is empty");
			
			else 
			{
				System.out.println("Insert second operand variable name : A, B or C");
				
				char second = s.next().charAt(0);
				
				if (poly.print(second) == null)
					System.out.println(""+listChar+" is empty");
				
				else 
				{
					int [][] r = new int [100][2];
					r=poly.multiply(first, second);
					
					int i=0;
					
					while (r[i][0]!=0 || r[i][1]!=0)
					{
						System.out.println("("+""+r[i][0]+","+""+r[i][1]+")");
						i++;
					}
					
				}
			}
		}
		
		else if (action==6)
		{
			System.out.println("Insert variable name : A, B or C");
			
			char name = s.next().charAt(0);
			
			if (poly.print(name) == null)
				System.out.println(""+listChar+" is empty");
			
			else 
			{
				System.out.println("enter value :");
				
				float val = s.nextFloat();
				
				System.out.println("result is :"+""+poly.evaluatePolynomial(name, val));
			}
			
		}
		
		if (action == 7)
		{
			System.out.println("Insert variable name : A, B or C");
			
			char name = s.next().charAt(0);
			
			poly.clearPolynomial(name);
			
			System.out.println(""+name + "is clear");
		}

		System.out.println("enter any thing then press enter to continue");
		char garp =s.next().charAt(0);
		
		s.close();
	}
		
		
	}

}