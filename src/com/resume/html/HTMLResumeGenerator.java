package com.resume.html;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.CharBuffer;

import com.resume.data.Person;

public class HTMLResumeGenerator
{
    public HTMLResumeGenerator(Person person)
    {
	m_person= person;
    }
    
    // ================================================================================
    // ================================================================================
    
    public void createIndexHTML()
    {
	try
	{
	    String htmlContent= "<!DOCTYPE html> <html>";
	    
	    htmlContent+= processTitleHTML();
	    
	    htmlContent+= "<body>";
	    
	    htmlContent+= processHeaderHTML();
	    
	    htmlContent+= "<div id=\"main_content\">";
	    
	    htmlContent+= processPersonalHTML();
	    htmlContent+= processPhotoHTML();
	    
	    /*
	     * ========================================================================
	     * Education Section.
	     * ========================================================================
	     */
	    
	    htmlContent+= "<div id=\"education\" class=\"Section\" style=\"clear:both\">";
	    htmlContent+= "<div class=\"SectionTitle\">";
	    htmlContent+= "<span>Formation</span>";
	    htmlContent+= "</div>";
	    
	    htmlContent+= processEducationHTML();
	    
	    htmlContent+= "</div>";
	    
	    // ========================================================================
	    
	    htmlContent+= "</div> </body> </html>";
	    
	    File presentationFile= new File("data/HTMLResume/index.html");
	    BufferedWriter writer= new BufferedWriter( new FileWriter(presentationFile) );
	    
	    writer.write(htmlContent);
	    
	    writer.close();
	}
	catch (IOException e)
	{
	    e.printStackTrace();
	}
    }
    
    // ================================================================================
    // ================================================================================
    
    private StringBuilder processTitleHTML() throws IOException
    {
	File presentationFile= new File("data/HTMLResume/HTMLParts/title.html");
	
	if(presentationFile.exists() == false)
	{
	    return (null);
	}
	
	BufferedReader reader= new BufferedReader( new FileReader( presentationFile ) );
	
	StringBuilder buffer= new StringBuilder((int) presentationFile.length());
	
	String line;
	while( (line= reader.readLine()) != null )
	{
	    line= line.replaceAll("\\$FIRSTNAME\\$", m_person.getFirstName());
	    line= line.replaceAll("\\$LASTNAME\\$", m_person.getLastName());
	    
	    buffer.append(line);
	}
	
	reader.close();

	return (buffer);
    }
    
    // ================================================================================
    // ================================================================================
    
    private StringBuilder processHeaderHTML() throws IOException
    {
	File presentationFile= new File("data/HTMLResume/HTMLParts/header.html");
	
	if(presentationFile.exists() == false)
	{
	    return (null);
	}
	
	BufferedReader reader= new BufferedReader( new FileReader( presentationFile ) );
	
	StringBuilder buffer= new StringBuilder((int) presentationFile.length());
	
	String line;
	while( (line= reader.readLine()) != null )
	{
	    line= line.replaceAll("\\$FIRSTNAME\\$", m_person.getFirstName());
	    line= line.replaceAll("\\$LASTNAME\\$", m_person.getLastName());
	    
	    buffer.append(line);
	}
	
	reader.close();

	return (buffer);
    }
    
    // ================================================================================
    // ================================================================================
    
    private StringBuilder processPersonalHTML() throws IOException
    {
	File presentationFile= new File("data/HTMLResume/HTMLParts/personal.html");
	
	if(presentationFile.exists() == false)
	{
	    return (null);
	}
	
	BufferedReader reader= new BufferedReader( new FileReader( presentationFile ) );
	
	StringBuilder buffer= new StringBuilder((int) presentationFile.length());
	
	final String martialStatus= (m_person.getMartialStatus() == true) ? "Mari&eacute;" : "C&eacute;libataire";
	
	String line;
	while( (line= reader.readLine()) != null )
	{
	    line= line.replaceAll("\\$FIRSTNAME\\$", m_person.getFirstName());
	    line= line.replaceAll("\\$LASTNAME\\$", m_person.getLastName());
	    line= line.replaceAll("\\$BIRTHDAY\\$", m_person.getBirthDay());
	    line= line.replaceAll("\\$NATIONALITY\\$", String.valueOf( m_person.getNationality() ) );
	    line= line.replaceAll("\\$MARTIALSTATUS\\$", martialStatus);
	    line= line.replaceAll("\\$ADDRESS\\$", m_person.getAddress());
	    line= line.replaceAll("\\$EMAIL\\$", m_person.getEmail());
	    line= line.replaceAll("\\$TEL\\$", m_person.getTel());
	    line= line.replaceAll("\\$WEBSITE\\$", m_person.getWebSite());
	    
	    buffer.append(line);
	}
	
	reader.close();

	return (buffer);
    }
    
    // ================================================================================
    // ================================================================================
    
    private StringBuilder processPhotoHTML() throws IOException
    {
	File presentationFile= new File("data/HTMLResume/HTMLParts/photosection.html");
	
	if(presentationFile.exists() == false)
	{
	    return (null);
	}
	
	BufferedReader reader= new BufferedReader( new FileReader( presentationFile ) );
	
	StringBuilder buffer= new StringBuilder((int) presentationFile.length());
	
	String line;
	while( (line= reader.readLine()) != null )
	{
	    line= line.replaceAll("\\$FACE\\$", "face.png");
	    
	    buffer.append(line);
	}
	
	reader.close();

	return (buffer);
    }
    
    // ================================================================================
    // ================================================================================
    
    private StringBuilder processEducationHTML() throws IOException
    {
	File presentationFile= new File("data/HTMLResume/HTMLParts/education.html");
	
	if(presentationFile.exists() == false)
	{
	    return (null);
	}
	
	BufferedReader reader= new BufferedReader( new FileReader( presentationFile ) );
	
	StringBuilder buffer= new StringBuilder((int) presentationFile.length());
	
	String line;
	while( (line= reader.readLine()) != null )
	{
	    line= line.replaceAll("\\$INSTITUTION\\$", "OUTER HEAVEN");
	    line= line.replaceAll("\\$EDUCATION-INTERVAL-DATES\\$", "1995-1997");
	    line= line.replaceAll("\\$TITLE\\$", "FOX-HOUND Agent");
	    line= line.replaceAll("\\$DETAIL\\$", "An undercover FOX-HOUND agent !");
	    
	    buffer.append(line);
	}
	
	reader.close();

	return (buffer);
    }
    
    // ================================================================================
    // ================================================================================
    
    private Person m_person;
}
