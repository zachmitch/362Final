

import junit.framework.TestCase;
//import static org.junit.Assert.*;


//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!


// BUG: Schemes are set to lower case but the allowed schemes are upper case
// BUG: http works as scheme but fails @ authority -- investigate!

public class UrlValidatorTest extends TestCase {

   public UrlValidatorTest(String testName) {
      super(testName);

   }
   
   public void testManualTest() {
	   UrlValidator v = new UrlValidator();
	   
	   System.out.println(v.isValid("http://google.com"));
	   System.out.println(v.isValid("https://google.com"));
	   System.out.println(v.isValid("http://google.com?arg1=foo&arg2@bar"));
	   
	   UrlValidator v2 = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
	   System.out.println(v2.isValid("file://picture.jpg"));
	   System.out.println(v2.isValid("http://yes/this/works")); 
	   System.out.println(v2.isValid("http://www.google.com/main/subdir")); 

   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	   

   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   

   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }
   


}
