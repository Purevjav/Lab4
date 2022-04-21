package grades;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.lang.Exception;



public class GradeManager 
{

	private HashMap<LetterGrade, String> allGrades;
	int size=1,size1=1,size2=1,size3=1,size4=1;


	public GradeManager() 
	{
		this.allGrades = new HashMap<LetterGrade,String>();
        for (LetterGrade dun : LetterGrade.values()) 
		{
			allGrades.put(dun, "");
		}
	}

	public void addGrade(String grade, String point) throws InvalidGradeException 
	{
		int intPoint = Integer.parseInt(point);
		boolean pointError = InvalidGradeException.pointCheck(intPoint);
		StringBuffer points = new StringBuffer();
				if(pointError) 
		{
			throw new InvalidGradeException(intPoint);
		}
		if (grade.equals("a")) 
		{
			points.append(allGrades.get(LetterGrade.A)+" "+ point);
			allGrades.put(LetterGrade.A,points.toString());			
		} 
		else if (grade.equals("b")) 
		{
			points.append(allGrades.get(LetterGrade.B)+" "+ point);
			allGrades.put(LetterGrade.B,points.toString());			
		} 
		else if (grade.equals("c")) 
		{
			points.append(allGrades.get(LetterGrade.C)+" "+ point);
			allGrades.put(LetterGrade.C,points.toString());			
		} 	
		else if (grade.equals("d")) 
		{
			points.append(allGrades.get(LetterGrade.D)+" "+ point);
			allGrades.put(LetterGrade.D,points.toString());			
		} 
		else if (grade.equals("f")) 
		{
			points.append(allGrades.get(LetterGrade.F)+" "+ point);
			allGrades.put(LetterGrade.F,points.toString());			
		} 
		else throw new InvalidGradeException(grade);
	}

		
	public void printHistogram() 
	{
		try 
		{			
			System.out.println(getHistString());
		}
		catch(Exception e)
		{
			throw new RuntimeException("GradeManger.printHistogram() хараахан хэрэгжээгүй байна!");
		}		
	}

	
	public String getHistString() 
	{
		StringBuffer sb = new StringBuffer();
		for (LetterGrade gl : LetterGrade.values()) 
		{
			sb.append( gl + ":" + allGrades.get(gl) + "\n");
					
		}
		return sb.toString();
	}

	
	public static void main(String[]  args) throws IOException, InvalidGradeException, Exception
	{
			    System.out.print("Available input: "
				+ "\n Дүн оруулах жишээ: add 'Дүн- a,b,c,d,e,f' 'оноо' \n Дүнгийн хамрагдах оноонууд: "
				+ "\n A | 90 - 100 \n B | 80 - 89 \n C | 70 - 79 \n D | 60 - 69 \n F | 00 - 59 \n"
				+ " Дүнг хэвлэх бол: print"
				+ "\n Жишээ харах бол: example"
				+ "\n Гарах бол: exit \n"
				+ "\n Дүнгийн бүртгэл эхэллээ: \n");
		GradeManager gm = new GradeManager();		
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		try 
		{
			while (true) 
			{			
				String input = cin.readLine();
				if (input.startsWith("add")) 				
				{							
					String[] str = input.split(" ");					
					gm.addGrade(str[1], str[2]);
				} 
				else if (input.equals("print")) 
				{
					gm.printHistogram();
				}  
				else if (input.equals("example")) 
				{
					System.out.print("Жишээ: \n "
							+ "add a 90 \n"
							+ "add b 89 \n"
							+ "print \n exit");
				}
				else if (input.equals("exit")) 
				{
					break;
				}
				else 
				{
					throw new Exception();							
				}
			}
		}
		catch(Exception InvalidInputException)
		{
			System.out.print("Дахин оролдоно уу");	
			return ; 
		}
	}
}