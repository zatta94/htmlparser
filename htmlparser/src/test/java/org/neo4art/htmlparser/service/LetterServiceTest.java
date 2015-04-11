/**
 * 
 */
package org.neo4art.htmlparser.service;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;
import org.neo4art.htmlparser.HtmlLetterParser;
import org.neo4art.htmlparser.IHtmlLetterParser;
import org.neo4art.htmlparser.bean.Letter;
import org.neo4art.htmlparser.custom.VanGoghLetterHtmlParser;

/**
 * @author Enrico
 *
 */
public class LetterServiceTest {

	@Test
	public void testSaveVanGoghLetters(){
		
		ILetterService letterService = new LetterService();
		VanGoghLetterHtmlParser vanGoghLetterHtmlParser = new VanGoghLetterHtmlParser();
		IHtmlLetterParser htmlParser = new HtmlLetterParser();
		vanGoghLetterHtmlParser.setHtmlLetterParser(htmlParser);
		
		try {
			URL url = new URL("http://vangoghletters.org/vg/letters/let001/letter.html");
			Letter letter = vanGoghLetterHtmlParser.getLetter(url);
			
			Path path = Paths.get("K:\\Progetti\\ArtProject\\Software\\Git\\htmlparser\\htmlparser\\src\\main\\resources\\vangoghletters\\1.txt");
			letterService.saveLetterFromUrl(letter, path);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERR: "+e.getMessage());
			
			Assert.fail(e.getMessage());
		}
		
		
		
	}
	
	
	
}
