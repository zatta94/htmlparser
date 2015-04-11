package org.neo4art.htmlparser.bean;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

public class ListLetter {
	
	public ListLetter(){
		
	}
	
	
	public ArrayList<Letter> getList(){
		Vector<String> v = new Vector<String>();
		ArrayList<Letter> arrayList = new ArrayList<Letter>();

		for(int i = 1 ; i <= 4; i++){
			String numero = String.format("%03d", i);
			Letter l1 = new Letter();
			try{
				v.removeAllElements();
				BufferedReader br = new BufferedReader(new FileReader("/home/larus/workspace/lettere/let"+numero+".txt"));
				String line;
				while((line = br.readLine()) != null){
					StringTokenizer stringTokenizer = new StringTokenizer(line, "|");
					while(stringTokenizer.hasMoreTokens()) {
				        v.addElement(stringTokenizer.nextToken());      
				    }
				}
			
				String text = "";
				for(int j = 11; j < v.size(); j ++){
					text = text + v.get(j);
				}
				String location = v.get(1);
				String date = v.get(3);
				String to = v.get(5);
				String from = v.get(7);
				String url = v.get(9);
				l1.setText(text);
				l1.setDate(date);
				l1.setFrom(from);
				l1.setPlace(location);
				l1.setTo(to);
				l1.setUrl(url);
				arrayList.add(l1);
				br.close();
			}catch(Exception e){
				
			}
		}
		return arrayList;
	}
}	
