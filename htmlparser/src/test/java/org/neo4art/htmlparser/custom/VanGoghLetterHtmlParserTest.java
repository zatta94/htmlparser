package org.neo4art.htmlparser.custom;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.junit.Test;
import org.neo4art.htmlparser.HtmlLetterParser;
import org.neo4art.htmlparser.IHtmlLetterParser;
import org.neo4art.htmlparser.bean.Letter;
import org.neo4art.htmlparser.bean.ListLetter;
import org.neo4art.htmlparser.bean.WriteLetterTxt;
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
                " but the illumination and fireworks were postponed because of the bad weather, so it�s just as well you didn�t stay to see them."+
                "Regards from the Haanebeeks and the Rooses. Ever,"+
                "Your loving"+
                "Vincent";
			for(int i = 1; i <= 4; i++){
				String numero = String.format("%03d", i);
				URL url = new URL("http://vangoghletters.org/vg/letters/let"+numero+"/letter.html");
				VanGoghLetterHtmlParser vanGoghLetterParser = new VanGoghLetterHtmlParser();
				IHtmlLetterParser htmlParser = new HtmlLetterParser();
				
				vanGoghLetterParser.setHtmlLetterParser(htmlParser);
				Letter letter = vanGoghLetterParser.getLetter(url);
				
				WriteLetterTxt w = new WriteLetterTxt("let"+numero);
				
				w.writeTxt(letter);
			}
//			
//				URL url = new URL("http://vangoghletters.org/vg/letters/let001a/letter.html");
//				VanGoghLetterHtmlParser vanGoghLetterParser = new VanGoghLetterHtmlParser();
//				IHtmlLetterParser htmlParser = new HtmlLetterParser();
//				
//				vanGoghLetterParser.setHtmlLetterParser(htmlParser);
//				Letter letter = vanGoghLetterParser.getLetter(url);
//				
//				WriteLetterTxt w = new WriteLetterTxt("let001a");
//				
//				w.writeTxt(letter);
		
//			URL url = new URL("http://vangoghletters.org/vg/letters/let118/letter.html");
//			VanGoghLetterHtmlParser vanGoghLetterParser = new VanGoghLetterHtmlParser();
//			IHtmlLetterParser htmlParser = new HtmlLetterParser();
//			
//			vanGoghLetterParser.setHtmlLetterParser(htmlParser);
//			Letter letter = vanGoghLetterParser.getLetter(url);
//			
//			WriteLetterTxt w = new WriteLetterTxt("118");
//			
//			w.writeTxt(letter);
			
			ListLetter l = new ListLetter();
			
			ArrayList<Letter> arrayList;
			
			arrayList = l.getList();
			
			for(Letter f : arrayList){
				System.out.println("Luogo: "+f.getLuogo());
				System.out.println("To: "+f.getTo());
				System.out.println("testo: "+f.getText());
			}
			
			
//		Assert.assertNotNull(letter);
//		Assert.assertNotNull(letter.getText());
//		Assert.assertTrue(letter.getText().trim().length() > 0);
		
//		System.out.println("TITLE: "+letter.getTitle());
		
//		System.out.println(letter.getText());
	}
	
}
