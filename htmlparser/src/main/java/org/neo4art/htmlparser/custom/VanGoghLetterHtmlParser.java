package org.neo4art.htmlparser.custom;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.List;
import java.util.StringTokenizer;
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
		String htmlPageByUrl = htmlLetterParser.getHtmlPageByUrl(url);
		String patternEXP = "(1r:1)+([\\w\\s\\W]*)";
		Pattern pattern = Pattern.compile(patternEXP);
		Matcher matcher = pattern.matcher(htmlPageByUrl);
//			System.out.println("group:"+matcher.groupCount());
//		System.out.println(""+htmlPageByUrl);
		
		while (matcher.find()) {
			letter.setText(matcher.group(2));
		}
//		System.out.println("asd:"+letter.getText());
		try{
		String nameImage ="show(\\([0-9,'\\w\\-)]*);";
		Pattern patternSke = Pattern.compile(nameImage);
		Matcher matcherSke = patternSke.matcher(letter.getText());
//		System.out.println("GroupCount:"+matcherSke.groupCount());
		
		while (matcherSke.find()) {
			String r = matcherSke.group();
//			System.out.println("Sketches"+r);
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		//PULISCO IL TESTO

		String text = letter.getText().replaceAll("\\|\\s+[\\w\\W]*", "");
		
		
		text = text.replaceAll("<[^>]*>+[0-9a-z:]*", "");
		
		letter.setText(text);
		
//		System.out.println(""+letter.getText());
		
		String title = this.htmlLetterParser.getMetadata().get("title");
		
//		System.out.println("TITLE:"+title);
		
		letter.setLuogo(title);

		String titolo = letter.getLuogo();
		
		String[] titleGenerale = titolo.split(":");
		
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
		letter.setLuogo(luogo);
		letter.setTo(to);
		letter.setUrl(""+url);
		
		String temp = letter.getText();
		
		temp  = temp.replace(",", " ,");
		temp  = temp.replace(".", " . ");
		temp  = temp.replace(";", " ;");
		temp  = temp.replace(":", " : ");
		temp  = temp.replace("!", " !");
		temp  = temp.replace("?", " ?");
		temp  = temp.replace("’", " ’ ");
		temp  = temp.replace("‘", " ‘ ");
		temp  = temp.replace("“", " “ ");
		temp  = temp.replace("”", " ” ");
		temp  = temp.replace("\\", " \\");
		temp  = temp.replace("/", " / ");
		temp  = temp.replace("(", " ( ");
		temp  = temp.replace(")", " ) ");
		temp  = temp.replace("#", " # ");
		temp  = temp.replace("[", " [ ");
		temp  = temp.replace("]", " ] ");
		temp  = temp.replace("-", " - ");
		temp  = temp.replace("_", " _ ");
		
		temp = temp.replaceAll("^\\s+|\\s+$|\\s*(\n)\\s*|(\\s)\\s*", "$1$2");
		
		letter.setText(temp);
		
//		System.out.println("testo:"+letter.getText());
		
//		System.out.println(" To:"+letter.getTo()+" Date:"+letter.getDate()+" Title:"+letter.getTitle());
		
//		System.out.println("Testo:"+letter.getText());
//		System.out.println(""+letter.getTitle());
	
		//-----------------------------------------------------------
		// DA PORTARE SU UN METODO A PARTE...
		
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
