# htmlparser
<b>Goal of the project:</b><br>
In this project the goal is to parse an html page, givin an url adress, and analyze the content to obtain some information<br>
that we can save in an txt file. <br>

In this first version of the project we have a Van Gogh Letter parser that parse all the pages found on:<br>
http://vangoghletters.org/vg/letters.html and creates a txt file for every letter parsed. <br>

There is also a method that receive in input a path, where there are the txt files with the letters and return a list<br>
of object Letter whith this attributes:
- place
- text
- from
- to
- date
- url
<br>

<b>Maven:</b><br>
This is a maven project<br>
  &lt;groupId&gt;org.neo4art&lt;/groupId&gt;<br>
  &lt;artifactId&gt;htmlparser&lt;/artifactId&gt;<br>
  &lt;version&gt;1.0.0&lt;/version&gt;<br>
