package org.neo4art.htmlparser;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.neo4art.htmlparser.exception.HtmlLetterParserException;


public class HtmlLetterParserTest {

	
	@Test
	public void theHague29September1872HtmlParserTest() throws MalformedURLException,HtmlLetterParserException{
		
		String testToValidate = "The Hague, 29 September 1872."+
                                "My dear Theo,"+
                                "Thanks for your letter, I was glad to hear that you got back safely. I missed you the first few days, and it was strange for me not to find"+
                                " you when I came home in the afternoon."+
                                "We spent some pleasant days together, and actually did go for some walks and see a thing or two whenever we had the chance."+
                                "What terrible weather, you must feel anxious on your walks to Oisterwijk. Yesterday there were trotting races on the occasion of the exhibition,"+
                                " but the illumination and fireworks were postponed because of the bad weather, so it’s just as well you didn’t stay to see them."+
                                "Regards from the Haanebeeks and the Rooses. Ever,"+
                                "Your loving"+
                                "Vincent";
		
		IHtmlLetterParser htmlParser = new HtmlLetterParser();
		
		URL url = new URL("http://vangoghletters.org/vg/letters/let001/letter.html");
		String htmlPageByUrl = htmlParser.getHtmlPageByUrl(url);
		
		Assert.assertNotNull(htmlPageByUrl);
		Assert.assertTrue((htmlPageByUrl.trim().length() > 0));
		
		//System.out.println("htmlPageByUrl: "+htmlPageByUrl);
	}
	
	
}
