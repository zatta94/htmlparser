package org.neo4art.htmlparser;

import java.net.URL;

import org.neo4art.htmlparser.exception.HtmlLetterParserException;

public interface IHtmlLetterParser {

   /**
    * Metodo che restituisce il contenuto di una pagina HTML
    * dato l'indirizzo url	
    */
   String getHtmlPageByUrl(URL url) throws HtmlLetterParserException;
	
}
