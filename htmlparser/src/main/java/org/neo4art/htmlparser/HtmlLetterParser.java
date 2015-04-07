package org.neo4art.htmlparser;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tika.Tika;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.html.HtmlParser;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.sax.Link;
import org.apache.tika.sax.LinkContentHandler;
import org.apache.tika.sax.TeeContentHandler;
import org.apache.tika.sax.ToHTMLContentHandler;
import org.neo4art.htmlparser.exception.HtmlLetterParserException;
import org.neo4art.htmlparser.handler.VanGoghLetterParserHandler;
import org.xml.sax.ContentHandler;

/**
 * 
 * @author Enrico
 *
 */

public class HtmlLetterParser implements IHtmlLetterParser{

	public String getHtmlPageByUrl(URL url) throws HtmlLetterParserException{

		String result = "";
		
		try
		{
			System.out.println("URL: "+url.toString());
	        InputStream input = url.openStream();
	        
	        LinkContentHandler linkHandler = new LinkContentHandler();
	        ContentHandler bodyContentHandler = new BodyContentHandler();
	        //ContentHandler bodyContentHandler = new VanGoghLetterParserHandler();
	        ToHTMLContentHandler toHTMLHandler = new ToHTMLContentHandler();
	        TeeContentHandler teeHandler = new TeeContentHandler(linkHandler, bodyContentHandler, toHTMLHandler);
	        
	        
			//ContentHandler teeHandler = new BodyContentHandler();
			Metadata metadata = new Metadata();
			ParseContext parseContext = new ParseContext();
			
			
			HtmlParser parser = new HtmlParser();
			parser.parse(input, teeHandler, metadata,parseContext);
			input.close();
			
			
			String contentBodyString = bodyContentHandler.toString();
			//System.out.println("bodyContentHandler: "+contentBodyString);
			
			
			// RECUPERARE IL TITOLO DELLA LETTERA, E IL DESTINATARIO, E LA DATA DELLA LETTERA
			

			// MATCH DEL contentBodyString PER OTTENERE IL TESTO PULITO DELLA LETTERA
			//1r:1
			
			System.out.println(toHTMLHandler.toString());
			System.out.println("\n------------------------------------------------");
			
			//(<a shape="rect" href=""> </a><a shape="rect" href="">1r:1</a>)+([\\sa-zA-Z,1-9.’]*)
			//(1r:1)+([\\sa-zA-Z,1-9.’]*) 
			String patternEXP = "(<a shape=\"rect\" href=\"\"> </a><a shape=\"rect\" href=\"\">1r:1</a>)+([\\sa-zA-Z,1-9.’<#-=\">?&;_]*)";
			//String patternEXP = "(1r:1)+([\\sa-zA-Z,1-9.’]*)";
			Pattern pattern = Pattern.compile(patternEXP);
			Matcher matcher = pattern.matcher(toHTMLHandler.toString());
			
			System.out.println("Group count: "+matcher.groupCount());
			
			//String group= matcher.group(1);
			//System.out.println("Group: "+group);
			
			while (matcher.find()) {
				
				String group= matcher.group(2);
				System.out.println("Group: "+group);
			}
			
			
			// PULIRE IL TESTO DELLA LETTERE DEI LINK SUPERFLUI
			
			
			
			
			
			
			
			
			
//			System.out.println("Link: ");
//			List<Link> links = linkHandler.getLinks();
//			for (Link link : links) {
//				System.out.println(link.getText()+" is anchor: "+link.isAnchor());
//			}
//			
//			
//			System.out.println("\nMetadata of the document:");
//		      String[] metadataNames = metadata.names();
//		      
//		      for(String name : metadataNames) {
//		         System.out.println(name + ":   " + metadata.get(name));  
//		      }
//			
//		      
//		      System.out.println("TITOLO: "+metadata.get("title"));
		      
		}
		catch(Exception e){
			
			throw new HtmlLetterParserException(e.getMessage());
		}
		
		
		return result;
	}

}
