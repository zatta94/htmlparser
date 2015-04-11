/**
 * 
 */
package org.neo4art.htmlparser.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;

import org.neo4art.htmlparser.bean.Letter;

/**
 * @author Enrico
 *
 */
public class LetterService implements ILetterService{

	/**
	   * Method that save a letter into the giving path.
	   * 
	   * @param Letter - the letter to save. 
	   * @param Path - the path where save the letter
	   */
	public void saveLetterFromUrl(Letter letter, Path path) {
		
		try
		 {
			 PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(path.toFile(), true)));
			 printWriter.print("Location|"+letter.getPlace());
			 printWriter.print("\nDate|"+letter.getDate());
			 printWriter.print("\nTo|"+letter.getTo());
			 printWriter.print("\nFrom|"+letter.getFrom());
			 printWriter.print("\nUrl letter|"+letter.getUrl());
			 printWriter.print("\nLetter|"+letter.getText());
			 printWriter.close();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		
		
	}

}
