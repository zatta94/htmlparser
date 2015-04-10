package org.neo4art.htmlparser;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.neo4art.htmlparser.bean.Letter;
import org.neo4art.htmlparser.bean.WriteLetterTxt;
import org.neo4art.htmlparser.custom.VanGoghLetterHtmlParser;
import org.neo4art.htmlparser.custom.VanGoghLetterHtmlParserTest;
import org.neo4art.htmlparser.exception.HtmlLetterParserException;


public class HtmlLetterParserTest {

	
	@Test
	public void theHague29September1872HtmlParserTest() throws MalformedURLException,HtmlLetterParserException{
		
		IHtmlLetterParser htmlParser = new HtmlLetterParser();
		try{
			
//		URL url = new URL("http://vangoghletters.org/vg/letters/let001/letter.html");
//		String htmlPageByUrl = htmlParser.getHtmlPageByUrl(url);
		
		VanGoghLetterHtmlParserTest vgtest = new VanGoghLetterHtmlParserTest();

//		Assert.assertNotNull(htmlPageByUrl);
//		Assert.assertTrue((htmlPageByUrl.trim().length() > 0));
		
//		System.out.println("htmlPageByUrl: "+htmlPageByUrl);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}
