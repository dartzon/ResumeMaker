package com.resume.data;

/**
 * @author dartzon
 *
 */
public class Person
{
    /**
     * ================================================
     * Default constructor.
     * ================================================
     */
    public Person()
    {
	m_firstName= "";
	m_lastName= "";
	m_birthDay= "";
	m_nationality= "";
	m_martialStatus= false;
	m_address= "";
	m_email= "";
	m_tel= "";
	m_webSite= "";	
    }
    
    /**
     * ================================================
     * Class initialization constructor.
     * ================================================
     */
    public Person(String firstName, String lastName, String birthDay,
	    String nationality, boolean martialStatus,
	    String address, String email, String tel, String webSite)
    {
	super();
	this.m_firstName = firstName;
	this.m_lastName = lastName;
	this.m_birthDay = birthDay;
	this.m_nationality = nationality;
	this.m_martialStatus = martialStatus;
	this.m_address = address;
	this.m_email = email;
	this.m_tel = tel;
	this.m_webSite = webSite;
    }
    
    /**
     * ================================================
     * Class accessors.
     * ================================================
     */    
    public String getFirstName()
    {
	return m_firstName;
    }
    public void setFirstName(String m_firstName)
    {
	this.m_firstName = m_firstName;
    }

    public String getLastName()
    {
	return m_lastName;
    }
    public void setLastName(String m_lastName)
    {
	this.m_lastName = m_lastName;
    }

    public String getBirthDay()
    {
	return m_birthDay;
    }
    public void setBirthDay(String m_birthDay)
    {
	this.m_birthDay = m_birthDay;
    }

    public String getNationality()
    {
	return m_nationality;
    }
    public void setNationality(String m_nationality)
    {
	this.m_nationality = m_nationality;
    }

    public boolean getMartialStatus()
    {
	return m_martialStatus;
    }
    public void setMartialStatus(boolean m_martialStatus)
    {
	this.m_martialStatus = m_martialStatus;
    }

    public String getAddress()
    {
	return m_address;
    }
    public void setAddress(String m_address)
    {
	this.m_address = m_address;
    }

    public String getEmail()
    {
	return m_email;
    }
    public void setEmail(String m_email)
    {
	this.m_email = m_email;
    }

    public String getTel()
    {
	return m_tel;
    }
    public void setTel(String m_tel)
    {
	this.m_tel = m_tel;
    }

    public String getWebSite()
    {
	return m_webSite;
    }
    public void setWebSite(String m_webSite)
    {
	this.m_webSite = m_webSite;
    }
    
    /**
     * ================================================
     * toString methode.
     * ================================================
     */
    public String toString()
    {
	return ("Person [m_firstName=" + m_firstName + ", m_lastName=" + m_lastName + ", m_birthDay=" + m_birthDay
		+ ", m_nationality=" + m_nationality + ", m_martialStatus=" + m_martialStatus + ", m_address="
		+ m_address + ", m_email=" + m_email + ", m_tel=" + m_tel + ", m_webSite=" + m_webSite + "]");
    }

    /**
     * ================================================
     * Class members.
     * ================================================
     */
    private String m_firstName;
    private String m_lastName;
    private String m_birthDay;
    private String m_nationality;
    private boolean m_martialStatus;
    private String m_address;
    private String m_email;
    private String m_tel;
    private String m_webSite;
}
