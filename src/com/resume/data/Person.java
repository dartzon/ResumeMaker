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
	m_ID= 0;
	m_firstName= "";
	m_lastName= "";
	m_birthDay= "";
	m_gender= 1;
	m_nationalityID= 0;
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
    public Person(int ID, String firstName, String lastName, String birthDay,
	    int gender, int nationalityID, String nationality, boolean martialStatus,
	    String address, String email, String tel, String webSite)
    {
	this.m_ID= ID;
	this.m_firstName = firstName;
	this.m_lastName = lastName;
	this.m_birthDay = birthDay;
	this.m_gender = gender;
	this.m_nationalityID= nationalityID;
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
    public int getID()
    {
	return m_ID;
    }
    public void setID(int ID)
    {
	m_ID = ID;
    }
    
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
    
    public int getGender()
    {
	return m_gender;
    }
    public void setGender(int gender)
    {
	this.m_gender = gender;
    }
    
    public int getNationalityID()
    {
	return m_nationalityID;
    }
    public void setNationalityID(int nationalityID)
    {
	m_nationalityID= nationalityID;
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
     * toString method.
     * ================================================
     */
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
	return "Person [m_ID=" + m_ID + ", m_firstName=" + m_firstName + ", m_lastName=" + m_lastName +
		", m_birthDay=" + m_birthDay + ", m_gender=" + m_gender + ", m_nationality=" + m_nationality +
		", m_martialStatus=" + m_martialStatus + ", m_address=" + m_address + ", m_email=" + m_email +
		", m_tel=" + m_tel + ", m_webSite=" + m_webSite + "]";
    }

    /**
     * ================================================
     * Class members.
     * ================================================
     */
    private int m_ID;
    private String m_firstName;
    private String m_lastName;
    private String m_birthDay;
    private int m_gender; // 1 = Male / 2 = Female
    private int m_nationalityID;
    private String m_nationality;
    private boolean m_martialStatus;
    private String m_address;
    private String m_email;
    private String m_tel;
    private String m_webSite;
}
