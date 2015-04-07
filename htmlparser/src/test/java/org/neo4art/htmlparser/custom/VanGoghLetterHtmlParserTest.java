package org.neo4art.htmlparser.custom;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.neo4art.htmlparser.HtmlLetterParser;
import org.neo4art.htmlparser.IHtmlLetterParser;
import org.neo4art.htmlparser.bean.Letter;
import org.neo4art.htmlparser.exception.HtmlLetterParserException;

public class VanGoghLetterHtmlParserTest {

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
		
		URL url = new URL("http://vangoghletters.org/vg/letters/let001/letter.html");
		VanGoghLetterHtmlParser vanGoghLetterParser = new VanGoghLetterHtmlParser();
		IHtmlLetterParser htmlParser = new HtmlLetterParser();
		
		vanGoghLetterParser.setHtmlLetterParser(htmlParser);
		Letter letter = vanGoghLetterParser.getLetter(url);
		Assert.assertNotNull(letter);
		Assert.assertNotNull(letter.getText());
		Assert.assertTrue(letter.getText().trim().length() > 0);
		
		System.out.println("TITLE: "+letter.getTitle());
		
		System.out.println(letter.getText());
	}
	
}
