package grades;
/**
 * Exception that should be thrown if an invalid grade is passed in.
 *
 */
public class InvalidGradeException extends Exception 
{
	private static final long serialVersionUID = 1;
	
	public InvalidGradeException() 
	{
		
	}
	
	public InvalidGradeException(String grade) 
	{
		System.out.print("Оруулсан үнэлгээ буруу байна.\n Жишээ нь: a,b,c,d,e,f");
	}
	
	public InvalidGradeException(int point) 
	{
		System.out.print("Оруулсан оноо буруу байна. 0-100 хооронд оруулна уу");
	}

		public static boolean pointCheck(int point) 
	{
		boolean error = false;
		if(point <0 || point > 100)
		{
			error = true;
		}
		return error;
	}	
}