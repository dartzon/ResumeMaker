package com.resume.data;

public class GlobalConfig
{
    /**
     * ================================================
     * Default constructor.
     * ================================================
     */
    public GlobalConfig()
    {
	m_ProfileTitle= "";
    }
    
    /**
     * ================================================
     * Class initialization constructor.
     * ================================================
     */
    public GlobalConfig(String profileTitle)
    {
	m_ProfileTitle= profileTitle;
    }
    
    /**
     * ================================================
     * Class accessors.
     * ================================================
     */
    
    public String getProfileTitle()
    {
        return m_ProfileTitle;
    }
    public void setProfileTitle(String m_ProfileTitle)
    {
        this.m_ProfileTitle = m_ProfileTitle;
    }
    
    public Person getLinkedPerson()
    {
	return (m_linkedPerson);
    }
    public void setLinkedPerson(Person linkedPerson)
    {
	m_linkedPerson= linkedPerson;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
	return "GlobalConfig [m_ProfileTitle=" + m_ProfileTitle + ", m_linkedPerson=" + m_linkedPerson + "]";
    }

    /**
     * ================================================
     * Class members.
     * ================================================
     */
    private String m_ProfileTitle;
    private Person m_linkedPerson;
}
