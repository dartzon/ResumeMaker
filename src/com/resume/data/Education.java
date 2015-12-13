package com.resume.data;

/**
 * @author dartzon
 *
 */
public class Education
{
    /**
     * ================================================
     * Default constructor.
     * ================================================
     */
    public Education()
    {
	m_InstitutionName = "";
	m_StartYear = 0;
	m_EndYear = 0;
	m_Title = "";
	m_Description = "";
	m_isCurrent = false;
	m_linkedPerson= null;
    }
    
    /**
     * ================================================
     * Class initialization constructor.
     * ================================================
     */
    public Education(String institutionName, int startYear, int endYear, String title, String description,
	    boolean isCurrent)
    {
	m_InstitutionName = institutionName;
	m_StartYear = startYear;
	m_EndYear = endYear;
	m_Title = title;
	m_Description = description;
	m_isCurrent = isCurrent;
	m_linkedPerson= null;
    }
    
    /**
     * ================================================
     * Class initialization constructor.
     * ================================================
     */
    public Education(String institutionName, int startYear, int endYear, String title, String description,
	    boolean isCurrent, Person linkedPerson)
    {
	m_InstitutionName = institutionName;
	m_StartYear = startYear;
	m_EndYear = endYear;
	m_Title = title;
	m_Description = description;
	m_isCurrent = isCurrent;
	m_linkedPerson= linkedPerson;
    }

    /**
     * @return the m_InstitutionName
     */
    public String getInstitutionName()
    {
	return m_InstitutionName;
    }

    /**
     * @param m_InstitutionName
     *            the m_InstitutionName to set
     */
    public void setInstitutionName(String m_InstitutionName)
    {
	this.m_InstitutionName = m_InstitutionName;
    }

    /**
     * @return the m_StartYear
     */
    public int getStartYear()
    {
	return m_StartYear;
    }

    /**
     * @param m_StartYear
     *            the m_StartYear to set
     */
    public void setStartYear(int m_StartYear)
    {
	this.m_StartYear = m_StartYear;
    }

    /**
     * @return the m_EndYear
     */
    public int getEndYear()
    {
	return m_EndYear;
    }

    /**
     * @param m_EndYear
     *            the m_EndYear to set
     */
    public void setEndYear(int m_EndYear)
    {
	this.m_EndYear = m_EndYear;
    }

    /**
     * @return the m_Title
     */
    public String getTitle()
    {
	return m_Title;
    }

    /**
     * @param m_Title
     *            the m_Title to set
     */
    public void setTitle(String m_Title)
    {
	this.m_Title = m_Title;
    }

    /**
     * @return the m_Description
     */
    public String getDescription()
    {
	return m_Description;
    }

    /**
     * @param m_Description
     *            the m_Description to set
     */
    public void setDescription(String m_Description)
    {
	this.m_Description = m_Description;
    }

    /**
     * @return the m_isCurrent
     */
    public boolean isCurrent()
    {
	return m_isCurrent;
    }

    /**
     * @param m_isCurrent the m_isCurrent to set
     */
    public void setCurrent(boolean m_isCurrent)
    {
	this.m_isCurrent = m_isCurrent;
    }
    
    /**
     * @return the m_linkedPerson
     */
    public Person getlinkedPerson()
    {
        return m_linkedPerson;
    }

    /**
     * @param m_linkedPerson the m_linkedPerson to set
     */
    public void setlinkedPerson(Person m_linkedPerson)
    {
        this.m_linkedPerson = m_linkedPerson;
    }

    /**
     * ================================================
     * toString method.
     * ================================================
     */
    public String toString()
    {
	return ("Education [m_InstitutionName=" + m_InstitutionName + ", m_StartYear=" + m_StartYear + ", m_EndYear="
		+ m_EndYear + ", m_Title=" + m_Title + ", m_Description=" + m_Description + ", m_isCurrent="
		+ m_isCurrent + "]");
    }

    /**
     * ================================================
     * Class members.
     * ================================================
     */
    private String m_InstitutionName;
    private int m_StartYear;
    private int m_EndYear;
    private String m_Title;
    private String m_Description;
    private boolean m_isCurrent;
    private Person m_linkedPerson;
}
