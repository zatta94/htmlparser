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
	public void theHague29September1872HtmlParserTest()
			throws MalformedURLException, HtmlLetterParserException {

		String testToValidate = "The Hague , 29 September 1872 .\n"+
                                "My dear Theo ,\n"+
                                "Thanks for your letter , I was glad to hear that you got back safely . I missed you the first few days , and it was strange for me not to find you when I came home in the afternoon .\n"+
                                "We spent some pleasant days together , and actually did go for some walks and see a thing or two whenever we had the chance .\n"+
                                "What terrible weather , you must feel anxious on your walks to Oisterwijk . Yesterday there were trotting races on the occasion of the exhibition , but the illumination and fireworks were postponed because of the bad weather , so it’s just as well you didn’t stay to see them . Regards from the Haanebeeks and the Rooses . Ever ,\n"+
                                "Your loving\n"+
                                "Vincent";

		URL url = new URL(
				"http://vangoghletters.org/vg/letters/let001/letter.html");
		VanGoghLetterHtmlParser vanGoghLetterParser = new VanGoghLetterHtmlParser();
		IHtmlLetterParser htmlParser = new HtmlLetterParser();

		vanGoghLetterParser.setHtmlLetterParser(htmlParser);
		Letter letter = vanGoghLetterParser.getLetter(url);

		Assert.assertNotNull(letter);
		Assert.assertNotNull(letter.getText());
		Assert.assertNotNull(letter.getFrom());
		Assert.assertTrue(letter.getText().trim().length() > 0);

		System.out.println(letter.getText());
		
		Assert.assertEquals(testToValidate, letter.getText());
	}

}
