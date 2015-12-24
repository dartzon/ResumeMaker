package com.resume.data;

import java.util.Vector;

import com.resume.data.skills.Lang;

public class Skill
{
    /**
     * ================================================
     * Default constructor.
     * ================================================
     */
    public Skill()
    {
	m_langs= new Vector<Lang>();
	m_linkedPerson= null;
    }

    /**
     * ================================================
     * Class initialization constructor.
     * ================================================
     */
    public Skill(Vector<Lang> langs)
    {
	m_langs= langs;
	m_linkedPerson= null;
    }
    
    /**
     * ================================================
     * Class accessors.
     * ================================================
     */
    public Vector<Lang> getLangs()
    {
	return (m_langs);
    }
    public void setLangs(Vector<Lang> langs)
    {
	m_langs= langs;
    }
    public void addLang(Lang lang)
    {
	m_langs.add(lang);
    }
    
    public Person getLinkedPerson()
    {
	return (m_linkedPerson);
    }
    public void setLinkedPerson(Person linkedPerson)
    {
	m_linkedPerson= linkedPerson;
    }
    
    /**
     * ================================================
     * Class members.
     * ================================================
     */
    private Vector<Lang> m_langs;
    private Person m_linkedPerson;
}
