package com.resume.data.skills;

public class Lang
{
    /**
     * ================================================
     * Default constructor.
     * ================================================
     */
    public Lang()
    {
	m_ID= 0;
	m_level= 0;
    }

    /**
     * ================================================
     * Class initialization constructor.
     * ================================================
     */
    public Lang(int ID, int level)
    {
	m_ID= ID;
	setLevel(level);
    }
    
    /**
     * ================================================
     * Class accessors.
     * ================================================
     */
    public int getID()
    {
	return (m_ID);
    }
    public void setID(int ID)
    {
	m_ID= ID;
    }
    
    public int getLevel()
    {
	return (m_level);
    }
    public void setLevel(int level)
    {
	if((level >= 0) && (level <= 5))
	{
	    m_level= level;
	}
    }
    
    /**
     * ================================================
     * Class members.
     * ================================================
     */
    private int m_ID;
    private int m_level;
}
