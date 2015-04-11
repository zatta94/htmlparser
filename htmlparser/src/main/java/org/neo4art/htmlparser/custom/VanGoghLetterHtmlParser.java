package org.neo4art.htmlparser.custom;

import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.neo4art.htmlparser.IHtmlLetterParser;
import org.neo4art.htmlparser.bean.Letter;
import org.neo4art.htmlparser.exception.HtmlLetterParserException;


public class VanGoghLetterHtmlParser  {

	private IHtmlLetterParser htmlLetterParser;

	public Letter getLetter(URL url) throws HtmlLetterParserException{
		Letter letter = new Letter();
		String htmlPageByUrl = htmlLetterParser.getHtmlPageByUrl(url);
		String patternEXP = "(1r:1)+([\\w\\s\\W]*)";
		Pattern pattern = Pattern.compile(patternEXP);
		Matcher matcher = pattern.matcher(htmlPageByUrl);
		
		while (matcher.find()) {
			letter.setText(matcher.group(2));
		}

		
		//FROM 
		String patternEXPFrom = "(From:)+(\\s[a-zA-Z\\s]*)+(\\sTo)";
		Pattern patternFrom = Pattern.compile(patternEXPFrom);
		Matcher matcherFrom = patternFrom.matcher(htmlPageByUrl);
		
		while (matcherFrom.find()) {
			letter.setFrom(matcherFrom.group(2).replaceAll("^\\s+|\\s+$|\\s*(\n)\\s*|(\\s)\\s*", "$1$2"));
		}
		
		//PULISCO IL TESTO

		String text = letter.getText().replaceAll("\\|\\s+[\\w\\W]*", "");
		text = text.replaceAll("<[^>]*>+[0-9a-z:]*", "");
		letter.setText(text);
		
		String title = this.htmlLetterParser.getMetadata().get("title");
		
		String[] titleGenerale = title.split(":");
		String titleGenerale1 = titleGenerale[1];
		String[] t1 = titleGenerale1.split("\\.");
		String to = t1[0];	
		String t2 = t1[1];
		String[] t3 = t2.split(",");
		
		String luogo = t3[0];
	
		String date = "";
		for(int i = 1 ; i < t3.length ;i++){
			date = date + t3[i];
		}
		
		to = to.substring(3);
		
		
		letter.setDate(date);
		letter.setPlace(luogo);
		letter.setTo(to);
		letter.setUrl(""+url);
		
		letter.setText(letter.getText().replace(",", " , "));
		letter.setText(letter.getText().replace(".", " . "));
		letter.setText(letter.getText().replace(";", " ; "));
		letter.setText(letter.getText().replaceAll("^\\s+|\\s+$|\\s*(\n)\\s*|(\\s)\\s*", "$1$2"));
		
		return letter;
	}
	
	public void setHtmlLetterParser(IHtmlLetterParser htmlLetterParser) {
		this.htmlLetterParser = htmlLetterParser;
	}
	
}
