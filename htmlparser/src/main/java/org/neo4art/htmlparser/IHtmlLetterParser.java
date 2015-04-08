package org.neo4art.htmlparser;

import java.net.URL;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.sax.LinkContentHandler;
import org.neo4art.htmlparser.exception.HtmlLetterParserException;

/**
 * 
 * @author Enrico
 *
 */
public interface IHtmlLetterParser {

   /**
    * Metodo che restituisce il contenuto di una pagina HTML
    * dato l'indirizzo url	
    */
   String getHtmlPageByUrl(URL url) throws HtmlLetterParserException;
   
   Metadata getMetadata();
	
   LinkContentHandler getLinkHandler();
}
