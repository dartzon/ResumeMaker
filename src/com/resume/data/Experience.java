package com.resume.data;

public class Experience
{
    /**
     * ================================================
     * Default constructor.
     * ================================================
     */
    public Experience()
    {
	m_company = "";
	m_DateStart = "";
	m_DateEnd = "";
	m_WeekCount = 0;
	m_CompanyWebSite = "";
	m_title = "";
	m_detail = "";
	m_isCurrent = false;
	m_linkedPerson = null;
    }
    
    /**
     * ================================================
     * Class initialization constructor.
     * ================================================
     */
    public Experience(String company, String dateStart, String dateEnd, int weekCount, String companyWebSite,
	    String title, String detail, boolean isCurrent)
    {
	m_company = company;
	m_DateStart = dateStart;
	m_DateEnd = dateEnd;
	m_WeekCount = weekCount;
	m_CompanyWebSite = companyWebSite;
	m_title = title;
	m_detail = detail;
	m_isCurrent = isCurrent;
	m_linkedPerson = null;
    }
    
    /**
     * @return the m_company
     */
    public String getcompany()
    {
        return m_company;
    }
    /**
     * @param m_company the m_company to set
     */
    public void setcompany(String m_company)
    {
        this.m_company = m_company;
    }
    
    /**
     * @return the m_DateStart
     */
    public String getDateStart()
    {
        return m_DateStart;
    }
    /**
     * @param m_DateStart the m_DateStart to set
     */
    public void setDateStart(String m_DateStart)
    {
        this.m_DateStart = m_DateStart;
    }
    
    /**
     * @return the m_DateEnd
     */
    public String getDateEnd()
    {
        return m_DateEnd;
    }
    /**
     * @param m_DateEnd the m_DateEnd to set
     */
    public void setDateEnd(String m_DateEnd)
    {
        this.m_DateEnd = m_DateEnd;
    }
    
    /**
     * @return the m_WeekCount
     */
    public int getWeekCount()
    {
        return m_WeekCount;
    }
    /**
     * @param m_WeekCount the m_WeekCount to set
     */
    public void setWeekCount(int m_WeekCount)
    {
        this.m_WeekCount = m_WeekCount;
    }
    
    /**
     * @return the m_CompanyWebSite
     */
    public String getCompanyWebSite()
    {
        return m_CompanyWebSite;
    }
    /**
     * @param m_CompanyWebSite the m_CompanyWebSite to set
     */
    public void setCompanyWebSite(String m_CompanyWebSite)
    {
        this.m_CompanyWebSite = m_CompanyWebSite;
    }
    
    /**
     * @return the m_title
     */
    public String getTitle()
    {
        return m_title;
    }
    /**
     * @param m_title the m_title to set
     */
    public void setTitle(String m_title)
    {
        this.m_title = m_title;
    }
    
    /**
     * @return the m_detail
     */
    public String getDetail()
    {
        return m_detail;
    }
    /**
     * @param m_detail the m_detail to set
     */
    public void setDetail(String m_detail)
    {
        this.m_detail = m_detail;
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
	return "Experience [m_company=" + m_company + ", m_DateStart=" + m_DateStart + ", m_DateEnd=" + m_DateEnd
		+ ", m_WeekCount=" + m_WeekCount + ", m_CompanyWebSite=" + m_CompanyWebSite + ", m_title=" + m_title
		+ ", m_detail=" + m_detail + ", m_isCurrent=" + m_isCurrent + "]";
    }
    
    /**
     * ================================================
     * Class members.
     * ================================================
     */
    private String m_company;
    private String m_DateStart;
    private String m_DateEnd;
    private int m_WeekCount;
    private String m_CompanyWebSite;
    private String m_title;
    private String m_detail;
    private boolean m_isCurrent;
    private Person m_linkedPerson;
}
