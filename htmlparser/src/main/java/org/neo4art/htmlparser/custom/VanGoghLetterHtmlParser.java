package org.neo4art.htmlparser.custom;

import java.net.URL;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tika.sax.Link;
import org.neo4art.htmlparser.IHtmlLetterParser;
import org.neo4art.htmlparser.bean.Letter;
import org.neo4art.htmlparser.exception.HtmlLetterParserException;


public class VanGoghLetterHtmlParser  {

	private IHtmlLetterParser htmlLetterParser;

	
	public Letter getLetter(URL url) throws HtmlLetterParserException{
		
		Letter letter = new Letter();
		String htmlPageByUrl = this.htmlLetterParser.getHtmlPageByUrl(url);
		
		String patternEXP = "(<a shape=\"rect\" href=\"\"> </a><a shape=\"rect\" href=\"\">1r:1</a>)+([\\sa-zA-Z,1-9.’<#-=\">?&;_]*)";
		Pattern pattern = Pattern.compile(patternEXP);
		Matcher matcher = pattern.matcher(htmlPageByUrl);
		
		while (matcher.find()) {
			
			letter.setText(matcher.group(2));
		}
		
		
		
		String title = this.htmlLetterParser.getMetadata().get("title");
		letter.setTitle(title);
		
		
		
		
		//-----------------------------------------------------------
		// DA PORTARE SU UN METODO A PARTE...
		
//		System.out.println("Link: ");
		List<Link> links = this.htmlLetterParser.getLinkHandler().getLinks();
		int i = 0;
		Vector<String> tempLink = new Vector<String>();
		boolean flag = false;
		for (Link link : links) {
//			System.out.println(link.getText());
			if(link.getText().equals("1r:1")){
				flag = true;		
			}
			else
			{
				if(flag == true)
				{
					if(link.getText().equals("001a "))
					{
						flag = false;
					}
					else
					{
						if(isInteger(link.getText()) == true){
							tempLink.add(link.getText());
							i++;
						}
						
					}
				}	
			}
		}
		
		
		return letter;
	}
	
	
	public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
	
	
	
	public void setHtmlLetterParser(IHtmlLetterParser htmlLetterParser) {
		this.htmlLetterParser = htmlLetterParser;
	}
	
}
