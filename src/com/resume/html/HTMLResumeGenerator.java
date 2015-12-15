package com.resume.html;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import com.resume.data.Education;
import com.resume.data.Experience;
import com.resume.data.Person;

public class HTMLResumeGenerator
{
    public HTMLResumeGenerator(Person person, Vector<Education> educations, Vector<Experience> experiences)
    {
	m_person= person;
	m_educations= educations;
	m_experiences= experiences;
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
	    htmlContent+= "<div class=\"SectionTitle\"> <span>Formation</span> </div>";
	    
	    final StringBuilder[] educationOutput= processEducationHTML();
	    for(int idx= 0; idx< educationOutput.length; ++idx)
	    {
		htmlContent+= educationOutput[idx];
	    }
	    
	    htmlContent+= "</div>";
	    
	    // ========================================================================
	    
	    /*
	     * ========================================================================
	     * Education Section.
	     * ========================================================================
	     */
	    
	    htmlContent+= "<div id=\"experience\" class=\"Section\" style=\"clear:both\">";            
	    htmlContent+= "<div class=\"SectionTitle\"> <span>Exp&eacute;riences</span> </div>";
	    
	    final StringBuilder[] experienceOutput= processExperienceHTML();
	    for(int idx= 0; idx< experienceOutput.length; ++idx)
	    {
		htmlContent+= experienceOutput[idx];
	    }
	    
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
    
    private StringBuilder[] processEducationHTML() throws IOException
    {
	File presentationFile= new File("data/HTMLResume/HTMLParts/education.html");
	
	if(presentationFile.exists() == false)
	{
	    return (null);
	}
	
	BufferedReader reader= new BufferedReader( new FileReader( presentationFile ) );
	StringBuilder originalBuffer= new StringBuilder((int) presentationFile.length());
	String line;
	while((line = reader.readLine()) != null)
	{
	    originalBuffer.append(line);
	}
	
	reader.close();
	
	final int educationsCount= m_educations.size();
	StringBuilder output[]= new StringBuilder[educationsCount];
	for(int idx= 0; idx< educationsCount; ++idx)
	{
	    Education edu= m_educations.elementAt(idx);
	    final String current= (edu.isCurrent() == true) ? "CurrentAtTheDate" : "";
	    final String date_interval= edu.getStartYear() + "-" + edu.getEndYear();

	    String tmpString= originalBuffer.toString();
	    tmpString = tmpString.replaceAll("\\$INSTITUTION\\$", edu.getInstitutionName());
	    tmpString = tmpString.replaceAll("\\$ISCURRENT\\$", current);
	    tmpString = tmpString.replaceAll("\\$EDUCATION-INTERVAL-DATES\\$", date_interval);
	    tmpString = tmpString.replaceAll("\\$TITLE\\$", edu.getTitle());
	    tmpString = tmpString.replaceAll("\\$DETAIL\\$", edu.getDescription());
	    
	    output[idx]= new StringBuilder();
	    output[idx].append(tmpString);
	}

	return (output);
    }
    
    // ================================================================================
    // ================================================================================
    
    private StringBuilder[] processExperienceHTML() throws IOException
    {
	File presentationFile= new File("data/HTMLResume/HTMLParts/experience.html");
	
	if(presentationFile.exists() == false)
	{
	    return (null);
	}
	
	BufferedReader reader= new BufferedReader( new FileReader( presentationFile ) );
	StringBuilder originalBuffer= new StringBuilder((int) presentationFile.length());
	String line;
	while((line = reader.readLine()) != null)
	{
	    originalBuffer.append(line);
	}
	
	reader.close();
	
	final int experiencesCount= m_experiences.size();
	StringBuilder output[]= new StringBuilder[experiencesCount];
	for(int idx= 0; idx< experiencesCount; ++idx)
	{
	    Experience exp= m_experiences.elementAt(idx);
	    final String current= (exp.isCurrent() == true) ? "CurrentAtTheDate" : "";
	    final String date_interval= exp.getDateStart() + "-" + exp.getDateEnd();
	    final String weekCount= (exp.getWeekCount() > 0) ? exp.getWeekCount() + " semaines" : "";

	    String tmpString= originalBuffer.toString();
	    tmpString = tmpString.replaceAll("\\$COMPANY\\$", exp.getcompany());
	    tmpString = tmpString.replaceAll("\\$INTERVAL-DATES\\$", date_interval);
	    tmpString = tmpString.replaceAll("\\$NB-WEEKS\\$", weekCount);
	    tmpString = tmpString.replaceAll("\\$ISCURRENT\\$", current);
	    tmpString = tmpString.replaceAll("\\$COMPANY-WEBSITE\\$", exp.getCompanyWebSite());
	    tmpString = tmpString.replaceAll("\\$TITLE\\$", exp.getTitle());
	    tmpString = tmpString.replaceAll("\\$DETAIL\\$", exp.getDetail());
	    
	    output[idx]= new StringBuilder();
	    output[idx].append(tmpString);
	}

	return (output);
    }
    
    // ================================================================================
    // ================================================================================
    
    private Person m_person;
    private Vector<Education> m_educations;
    private Vector<Experience> m_experiences;
}
