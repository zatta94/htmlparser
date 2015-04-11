/**
 * 
 */
package org.neo4art.htmlparser.service;

import java.nio.file.Path;

import org.neo4art.htmlparser.bean.Letter;

/**
 * @author Enrico
 *
 */
public interface ILetterService {

  /**
   * Method that save a letter into the giving path.
   * 
   * @param Letter - the letter to save. 
   * @param Path - the path where save the letter
   */
  void	saveLetterFromUrl(Letter letter,Path path);
	
}
