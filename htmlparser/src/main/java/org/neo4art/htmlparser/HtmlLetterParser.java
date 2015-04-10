package org.neo4art.htmlparser;

import java.io.InputStream;
import java.net.URL;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.html.HtmlParser;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.sax.LinkContentHandler;
import org.apache.tika.sax.TeeContentHandler;
import org.apache.tika.sax.ToHTMLContentHandler;
import org.neo4art.htmlparser.exception.HtmlLetterParserException;
import org.xml.sax.ContentHandler;

/**
 * 
 * @author Enrico
 *
 */

public class HtmlLetterParser implements IHtmlLetterParser {

	private LinkContentHandler linkHandler;

	private ContentHandler bodyContentHandler;

	private ToHTMLContentHandler toHTMLHandler;

	private Metadata metadata;

	/**
	 * Constructor.
	 */
	public HtmlLetterParser() {

		this.bodyContentHandler = new BodyContentHandler();
		this.linkHandler = new LinkContentHandler();
		this.toHTMLHandler = new ToHTMLContentHandler();
		this.metadata = new Metadata();
	}

    /**
     * Method that returns an html page from an url adress.
     * 
     * @param Url - the url.
     * 
     * @throws HtmlLetterParserException - if the parser has an error. 
     */
	public String getHtmlPageByUrl(URL url) throws HtmlLetterParserException {

		String result = "";

		try {
			System.out.println("URL: " + url.toString());
			InputStream input = url.openStream();

			TeeContentHandler teeHandler = new TeeContentHandler(linkHandler,
					bodyContentHandler, toHTMLHandler);
			ParseContext parseContext = new ParseContext();

			HtmlParser parser = new HtmlParser();
			parser.parse(input, teeHandler, metadata, parseContext);
			input.close();

			result = toHTMLHandler.toString();
		} catch (Exception e) {
			throw new HtmlLetterParserException(e.getMessage());
		}

		return result;
	}

    /**
     * Method that returns the link handler of the html page parsed.
     * 
     */
	public LinkContentHandler getLinkHandler() {
		return linkHandler;
	}

	/**
     * Method that returns the metadata of the html page parsed.
     * 
     */
	public Metadata getMetadata() {
		return metadata;
	}
}
