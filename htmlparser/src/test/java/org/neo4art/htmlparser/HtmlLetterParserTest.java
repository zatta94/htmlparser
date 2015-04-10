package org.neo4art.htmlparser;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.neo4art.htmlparser.exception.HtmlLetterParserException;

/**
 * 
 * @author larus
 *
 */
public class HtmlLetterParserTest {

	
	@Test
	public void theHague29September1872HtmlParserTest() throws MalformedURLException,HtmlLetterParserException{
		
		IHtmlLetterParser htmlParser = new HtmlLetterParser();
		
		URL url = new URL("http://vangoghletters.org/vg/letters/let001/letter.html");
		String htmlPageByUrl = htmlParser.getHtmlPageByUrl(url);
		
		Assert.assertNotNull(htmlPageByUrl);
		Assert.assertTrue((htmlPageByUrl.trim().length() > 0));
		
		System.out.println("htmlPageByUrl: "+htmlPageByUrl);
	}
	
	
}
