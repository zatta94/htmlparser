package org.neo4art.htmlparser.service;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.neo4art.htmlparser.HtmlLetterParser;
import org.neo4art.htmlparser.IHtmlLetterParser;
import org.neo4art.htmlparser.bean.Letter;
import org.neo4art.htmlparser.custom.SentimentAnalysis;
import org.neo4art.htmlparser.custom.VanGoghLetterHtmlParser;
import org.neo4art.htmlparser.exception.HtmlLetterParserException;

public class SentimentAnalysisTest
{

  @Test
  public void test() throws HtmlLetterParserException
  {
    try
    {
      VanGoghLetterHtmlParser vanGoghLetterHtmlParser = new VanGoghLetterHtmlParser();
      SentimentAnalysis s = new SentimentAnalysis();
      WriteSentimentCSV write = new WriteSentimentCSV();
      write.createCSV();
      
      IHtmlLetterParser htmlParser1 = new HtmlLetterParser();
      vanGoghLetterHtmlParser.setHtmlLetterParser(htmlParser1);
      
      URL url1 = new URL("http://vangoghletters.org/vg/letters/let001a/letter.html");

      Letter letter1 = vanGoghLetterHtmlParser.getLetter(url1);
      int result1 = s.sentiment(letter1.getText());
      write.writeResult(letter1.getTitle(), result1);
      
      for (int i = 0; i < 902; i++)
      {

        String numeroLettera = "";
        numeroLettera = StringUtils.leftPad(numeroLettera, 3 - Integer.toString(i + 1).length(), "0");
        numeroLettera += "" + (i + 1);

        IHtmlLetterParser htmlParser = new HtmlLetterParser();
        vanGoghLetterHtmlParser.setHtmlLetterParser(htmlParser);

        URL url = new URL("http://vangoghletters.org/vg/letters/let" + numeroLettera + "/letter.html");
        
        Letter letter = vanGoghLetterHtmlParser.getLetter(url);
        int result = s.sentiment(letter.getText());
        write.writeResult(letter.getTitle(), result);
      }
      
      for (int i = 0; i < 25; i++)
      {

        String numeroLettera = "";
        numeroLettera = StringUtils.leftPad(numeroLettera, 2 - Integer.toString(i + 1).length(), "0");
        numeroLettera += "" + (i + 1);

        IHtmlLetterParser htmlParser = new HtmlLetterParser();
        vanGoghLetterHtmlParser.setHtmlLetterParser(htmlParser);

        URL url = new URL("http://vangoghletters.org/vg/letters/RM" + numeroLettera + "/letter.html");
        
        Letter letter = vanGoghLetterHtmlParser.getLetter(url);
        int result = s.sentiment(letter.getText());
        write.writeResult(letter.getTitle(), result);
      }
      

    }
    catch (MalformedURLException e)
    {
      Assert.fail(e.getMessage());
    }

  }

}
