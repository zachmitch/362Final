

import junit.framework.TestCase;
import java.util.Random;
import org.junit.Test;
import incorrect.UrlValidator;

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
   
   
   public void PartitionTesting()
   {

     // Partitions - 
     // Options flag - ALLOW_ALL_SCHEMES
     // Authority - google, reddit, washingtonpost, amazon, 
     // tld (top level domain) - .com, .net, .io, .xyz, .123, .\xd*#
     // protocol scheme - http, HTTP, https, HTTPS, ftp, sftp, telnet, 1234, icmp
     // port number - :1, :44, :1453, :-3, :2348920
     // path  - /main.html, /main/subdir/yes.html, /902, //main, /\main, /..main


	//Options flag partition
	UrlValidator optionFlagSet = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	UrlValidator optionFlagNotSet = new UrlValidator();

	System.out.println(optionFlagSet.isValid("http://www.google.com"));
	System.out.println(optionFlagSet.isValid("https://www.google.com"));
	System.out.println(optionFlagSet.isValid("http://www.google.com/main/subdir"));

	System.out.println(optionFlagNotSet.isValid("http://www.google.com"));
	System.out.println(optionFlagNotSet.isValid("https://www.google.com"));
	System.out.println(optionFlagNotSet.isValid("http://www.google.com/main/subdir"));

	// Authority partition
	UrlValidator authority = new UrlValidator();
	System.out.println(authority.isValid("http://www.google.com"));
	System.out.println(authority.isValid("http://www.amazon.com"));
	System.out.println(authority.isValid("http://www.reddit.com"));
	System.out.println(authority.isValid("http://www.ebay.com"));
 
	// tld
	UrlValidator tld = new UrlValidator();
	System.out.println(tld.isValid("http://www.google.com"));
	System.out.println(tld.isValid("http://www.google.net"));
	System.out.println(tld.isValid("http://www.google.io"));
	System.out.println(tld.isValid("http://www.google.123"));
	System.out.println(tld.isValid("http://www.google.*&^"));

	//Protocol scheme
	UrlValidator prot = new UrlValidator();
	System.out.println(prot.isValid("http://www.google.com"));
	System.out.println(prot.isValid("https://www.google.com"));
	System.out.println(prot.isValid("HTTP://www.google.com"));
	System.out.println(prot.isValid("HTTPS://www.google.com"));
	System.out.println(prot.isValid("ftp://www.google.com"));
	System.out.println(prot.isValid("FTP://www.google.com"));

	//Port Number
	UrlValidator portNum = new UrlValidator();
	System.out.println(portNum.isValid("http://www.google.com:80"));
	System.out.println(portNum.isValid("http://www.google.com:-3"));
	System.out.println(portNum.isValid("http://www.google.com:54056846832"));

	//Path
	UrlValidator path = new UrlValidator();
	System.out.println(path.isValid("http://www.google.com/main"));
	System.out.println(path.isValid("http://www.google.com/main/subdir"));
	System.out.println(path.isValid("http://www.google.com//main"));
	System.out.println(path.isValid("http://www.google.com/~main/subdir"));


  }
   
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }
   


}
