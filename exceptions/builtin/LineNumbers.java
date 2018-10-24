package com.htc.exceptions.builtin;
/**getStackTrace
 * Returns an ARRAY of stack trace elements, each representing one stack frame
 *
 */
public class LineNumbers {
	public static void main(String[] args) throws Exception {

		try{
			System.out.println("prior to  exception");
			//throw new Exception("custom exception");
			System.out.println(5/0);
		}
		catch(ArithmeticException e)
		{
			e.printStackTrace();
			
			System.out.println						("\nFollowing exception class name:-"+
			e.getClass().getSimpleName()			+" has occurred with message :-"+
			e.getMessage()							+", at line number:-"+
			e.getStackTrace()[0].getLineNumber()	+", belonging to method:-"+
			e.getStackTrace()[0].getMethodName()	+"in class:-"+
			e.getStackTrace()[0].getClassName()		+"\n");

		}
		catch(Exception e)
		{
			System.out.println("\nFollowing exception has occurred with message:-"+e.getMessage()+", at line number:-"+e.getStackTrace()[0].getLineNumber()+", belonging to method:-"+e.getStackTrace()[0].getMethodName());
			System.out.println("in class:-"+e.getStackTrace()[0].getClass().getSimpleName()+"\n");
		}
		finally
		{
			System.out.println("in finally");
		}
	}
}

/**
 * getLocalizedmessage returns message in local language- however you need to override this message first and add some files
 * the gist is that you place any text in resource files, of which you have many (one per locale/language/etc) and 
 * your code uses a mechanism to look up the text in the correct resource file
 */


