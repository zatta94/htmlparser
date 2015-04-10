package org.neo4art.htmlparser.bean;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class WriteLetterTxt {
	
	String file = "/home/larus/workspace/lettere/";
	
	public WriteLetterTxt(String numero){
		this.file = file+numero+".txt";
	}
	
	public void writeTxt(Letter letter){
		try
		 {
			 PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
			 pw.print("Location|"+letter.getLuogo());
			 pw.print("\nDate|"+letter.getDate());
			 pw.print("\nTo|"+letter.getTo());
			 pw.print("\nFrom|"+letter.getFrom());
			 pw.print("\nUrl letter|"+letter.getUrl());
			 pw.print("\nLetter|"+letter.getText());
			 pw.close();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	}

}
