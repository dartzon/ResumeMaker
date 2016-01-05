package com.resume.html;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

import com.resume.data.Education;
import com.resume.data.Experience;
import com.resume.data.GlobalConfig;
import com.resume.data.Misc;
import com.resume.data.Person;
import com.resume.data.Skill;
import com.resume.data.skills.Lang;

public class HTMLResumeGenerator
{   
    public HTMLResumeGenerator(Person person, GlobalConfig config,
	    Vector<Education> educations, Vector<Experience> experiences,
	    Skill skills, Misc misc)
    {
	m_ResumeLang= ResumeLang.RL_US;
	
	m_person= person;
	
	m_config= config;
	m_educations= educations;
	m_experiences= experiences;
	m_skills= skills;
	m_misc= misc;
    }
    
    public HTMLResumeGenerator(ResumeLang lang,
	    Person person, GlobalConfig config, Vector<Education> educations, Vector<Experience> experiences,
	    Skill skills, Misc misc)
    {
	m_ResumeLang= lang;
	
	m_person= person;
	
	m_config= config;
	m_educations= educations;
	m_experiences= experiences;
	m_skills= skills;
	m_misc= misc;
    }
    
    // ================================================================================
    // ================================================================================
    
    public void createIndexHTML()
    {
	try
	{
	    /*
	     * ========================================================================
	     * i18n setup.
	     * ========================================================================
	     */
	    
	    switch(m_ResumeLang)
	    {
	    case RL_US : m_i18nLocale= new Locale("us", "US"); break;
	    case RL_FR : m_i18nLocale= new Locale("fr", "FR"); break;
	    }

	    m_i18nRsc= ResourceBundle.getBundle("resume", m_i18nLocale);
	    
	    // ========================================================================
	    
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
	    htmlContent+= "<div class=\"SectionTitle\"> <span>"+ m_i18nRsc.getString("education")+
		    	  "</span> </div>";
	    
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
	    htmlContent+= "<div class=\"SectionTitle\"> <span>"+ m_i18nRsc.getString("experience")+
		    	  "</span> </div>";
	    
	    final StringBuilder[] experienceOutput= processExperienceHTML();
	    for(int idx= 0; idx< experienceOutput.length; ++idx)
	    {
		htmlContent+= experienceOutput[idx];
	    }
	    
	    htmlContent+= "</div>";
            
	    // ========================================================================
	    
	    /*
	     * ========================================================================
	     * Skills Section.
	     * ========================================================================
	     */
	    
	    htmlContent+= "<div id=\"tools\" class=\"Section\" style=\"clear:both\">";            
	    htmlContent+= "<div class=\"SectionTitle\"> <span>"+ m_i18nRsc.getString("skill")+
		    	  "</span> </div>";
	    
	    htmlContent+= processSkillsHTML();
	    
	    htmlContent+= "</div>";
	    
	    // ========================================================================
	    
	    /*
	     * ========================================================================
	     * Miscellaneous Section.
	     * ========================================================================
	     */
	    htmlContent+= processMiscHTML();
	    
	    // ========================================================================
	    
	    htmlContent+= "</div> </body> </html>";
	    
	    /*
	     * ========================================================================
	     * Level java script.
	     * ========================================================================
	     */
	    htmlContent+= processLevelScriptHTML();
	    
	    // ========================================================================

	    
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
	    
	    line= line.replaceAll("\\$PROFILETITLE\\$", m_config.getProfileTitle());
	    
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
	
	final String i18nNationality= m_i18nRsc.getString("nationality_"+
		m_person.getNationalityID() +"_"+ m_person.getGender());
	
	String i18nMartialStatus= (m_person.getMartialStatus() == true) ?
		m_i18nRsc.getString("married") : m_i18nRsc.getString("single");
		
	if( (m_ResumeLang == ResumeLang.RL_FR) &&
	    (m_person.getGender() == 2)  && (m_person.getMartialStatus() == true))
	{
	    // In the french language, the feminine adjectives take an 'e' at the end.
	    i18nMartialStatus+= "e";
	}
	
	String line;
	while( (line= reader.readLine()) != null )
	{
	    line= line.replaceAll("\\$I18NPRESENTATION\\$", m_i18nRsc.getString("presentation"));
	    
	    line= line.replaceAll("\\$I18NCOMPLETENAME\\$", m_i18nRsc.getString("complete_name"));
	    line= line.replaceAll("\\$FIRSTNAME\\$", m_person.getFirstName());
	    line= line.replaceAll("\\$LASTNAME\\$", m_person.getLastName());
	    
	    line= line.replaceAll("\\$I18NBIRTHDATE\\$", m_i18nRsc.getString("birth_date"));
	    line= line.replaceAll("\\$BIRTHDATE\\$", m_person.getBirthDay());
	    
	    line= line.replaceAll("\\$I18NNATIONALITY\\$", m_i18nRsc.getString("nationality"));
	    line= line.replaceAll("\\$NATIONALITY_ID\\$", String.valueOf( m_person.getNationalityID() ) );
	    line= line.replaceAll("\\$NATIONALITY\\$", i18nNationality);
	    
	    line= line.replaceAll("\\$I18NCIVILSTATUS\\$", m_i18nRsc.getString("civil_status"));
	    line= line.replaceAll("\\$MARTIALSTATUS\\$", i18nMartialStatus);
	    
	    line= line.replaceAll("\\$I18NADDRESS\\$", m_i18nRsc.getString("address"));
	    line= line.replaceAll("\\$ADDRESS\\$", m_person.getAddress());
	    
	    line= line.replaceAll("\\$EMAIL\\$", m_person.getEmail());
	    
	    line= line.replaceAll("\\$I18NPHONE\\$", m_i18nRsc.getString("phone"));
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
	    final String isCurrent= (exp.isCurrent() == true) ? "CurrentAtTheDate" : "";
	    
	    //////////////////////////////////////////
	    // Date interval.
	    final String dateStartMY[]= exp.getDateStart().split("-");
	    final int dateStartM= Integer.parseInt( dateStartMY[0] );
	    String dateStart= m_i18nRsc.getString("month"+ dateStartM);

	    String dateEnd;	    
	    if(exp.getDateEnd().compareTo("!") == 0)
	    {
		dateStart+= " " + dateStartMY[1];
		dateEnd= m_i18nRsc.getString("today");
	    }
	    else
	    {
		final String dateEndMY[]= exp.getDateEnd().split("-");
		final int dateEndM= Integer.parseInt( dateEndMY[0] );
		dateEnd= m_i18nRsc.getString("month"+ dateEndM) + " " + dateEndMY[1];
		
		if(dateStartMY[1].compareTo(dateEndMY[1]) != 0)
		{
		    dateStart+= " " + dateStartMY[1];
		}
	    }
	    
	    final String experiencePeriod= dateStart + " - " + dateEnd;
	    
	    //////////////////////////////////////////
	    
	    final String i18nWeek= m_i18nRsc.getString("week") + ( (exp.getWeekCount() > 0) ? "s" : "" );
	    final String weekCount= (exp.getWeekCount() > 0) ? exp.getWeekCount() + (" " + i18nWeek) : "";

	    String tmpString= originalBuffer.toString();
	    tmpString = tmpString.replaceAll("\\$COMPANY\\$", exp.getcompany());
	    tmpString = tmpString.replaceAll("\\$INTERVAL-DATES\\$", experiencePeriod);
	    tmpString = tmpString.replaceAll("\\$NB-WEEKS\\$", weekCount);
	    tmpString = tmpString.replaceAll("\\$ISCURRENT\\$", isCurrent);
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
    
    private StringBuilder processSkillsHTML() throws IOException
    {
	StringBuilder originalBuffer= processLangsHTML();//new StringBuilder();
	
	return (originalBuffer);
    }
    
    private StringBuilder processLangsHTML() throws IOException
    {
	File presentationFile= new File("data/HTMLResume/HTMLParts/skills/langs.html");
	
	if(presentationFile.exists() == false)
	{
	    return (null);
	}
	
	BufferedReader reader= new BufferedReader( new FileReader( presentationFile ) );
	StringBuilder originalBuffer= new StringBuilder((int) presentationFile.length());
	String line;
	while((line = reader.readLine()) != null)
	{
	    line = line.replaceAll("\\$I18NLANGS\\$", m_i18nRsc.getString("lang"));
	    
	    if(line.contains("$LANGSLIST$") == true)
	    {
		///////////////////////////////////
		
		line= "";
		
		final Vector<Lang> langs= m_skills.getLangs();
		final int langsCount= langs.size();
		for(int idx= 0; idx< langsCount; ++idx)
		{
		    Lang currentLang= langs.elementAt(idx);
		    
		    line+= "<div class=\"Item\">";
		    line+= "<div class=\"ItemCaption\">"+ m_i18nRsc.getString("lang_" + currentLang.getID());
		    line+= "</div><div class=\"ItemRank\" id=\""+ currentLang.getLevel() +"_1\"></div></div>";
		}
		
		///////////////////////////////////
	    }
	    originalBuffer.append(line);
	}
	
	reader.close();

	return (originalBuffer);
    }
    
    // ================================================================================
    // ================================================================================
    
    private StringBuilder processMiscHTML() throws IOException
    {
	File presentationFile= new File("data/HTMLResume/HTMLParts/misc.html");
	
	if(presentationFile.exists() == false)
	{
	    return (null);
	}
	
	BufferedReader reader= new BufferedReader( new FileReader( presentationFile ) );
	
	StringBuilder buffer= new StringBuilder((int) presentationFile.length());
	
	final String i18nMisc= m_i18nRsc.getString("misc");
	
	String line;
	while( (line= reader.readLine()) != null )
	{
	    line= line.replaceAll("\\$I18NMISC\\$", i18nMisc);
	    line= line.replaceAll("\\$HOBBIES\\$", m_misc.getHobbies());
	    
	    buffer.append(line);
	}
	
	reader.close();

	return (buffer);
    }
    
    // ================================================================================
    // ================================================================================
    
    private StringBuilder processLevelScriptHTML() throws IOException
    {
	File presentationFile= new File("data/HTMLResume/HTMLParts/levelscript.html");
	
	if(presentationFile.exists() == false)
	{
	    return (null);
	}
	
	BufferedReader reader= new BufferedReader( new FileReader( presentationFile ) );
	
	StringBuilder buffer= new StringBuilder((int) presentationFile.length());
	
	String line;
	while( (line= reader.readLine()) != null )
	{
	    buffer.append(line);
	}
	
	reader.close();

	return (buffer);
    }
    
    // ================================================================================
    // ================================================================================
    
    private Person m_person;
    
    private GlobalConfig m_config;
    private Vector<Education> m_educations;
    private Vector<Experience> m_experiences;
    private Misc m_misc;
    private Skill m_skills;
    
    // i18n Management.
    private ResumeLang m_ResumeLang; 
    private Locale m_i18nLocale;
    private ResourceBundle m_i18nRsc;
}
