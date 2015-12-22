package com.resume.data;

public class Misc
{
    /**
     * ================================================
     * Default constructor.
     * ================================================
     */
    public Misc()
    {
	m_hobbies= "";
	m_linkedPerson= null;
    }

    /**
     * ================================================
     * Class initialization constructor.
     * ================================================
     */
    public Misc(String hobbies)
    {
	m_hobbies= hobbies;
    }
    
    /**
     * ================================================
     * Class accessors.
     * ================================================
     */
    
    public String getHobbies()
    {
	return (m_hobbies);
    }
    public void setHobbies(String hobbies)
    {
	m_hobbies= hobbies;
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
	return "Misc [m_hobbies=" + m_hobbies + ", m_linkedPerson=" + m_linkedPerson + "]";
    }
    
    /**
     * ================================================
     * Class members.
     * ================================================
     */
    private String m_hobbies;
    private Person m_linkedPerson;
}
