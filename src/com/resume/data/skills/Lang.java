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
	m_name= "";
	m_level= 0;
    }

    /**
     * ================================================
     * Class initialization constructor.
     * ================================================
     */
    public Lang(String name, int level)
    {
	m_name= name;
	setLevel(level);
    }
    
    /**
     * ================================================
     * Class accessors.
     * ================================================
     */
    public String getName()
    {
	return (m_name);
    }
    public void setName(String name)
    {
	m_name= name;
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
    private String m_name;
    private int m_level;
}
