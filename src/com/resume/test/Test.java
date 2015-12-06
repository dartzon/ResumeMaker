package com.resume.test;

import com.resume.data.Person;
import com.resume.html.HTMLResumeGenerator;
import com.resume.persistance.PersonPersistance;
import com.resume.persistance.SQLiteManager;

public class Test
{
    public static void main(String[] args)
    {	
	Person prs= new Person();
	
	/*prs.setFirstName("Othmane");
	prs.setLastName("AIT EL CADI");
	
	prs.setBirthDay("1989-10-02");
	prs.setNationality(118);
	prs.setMartialStatus(true);
	prs.setAddress("48 BD de Paris, Casablanca");
	prs.setEmail("dartzon@gmail.com");
	prs.setTel("0225475015");
	prs.setWebSite("www.google.com");*/
	
	
	PersonPersistance prsper= new PersonPersistance();
	
	//prsper.save(prs);
	prs= (Person) prsper.load(2);
	
	HTMLResumeGenerator gen= new HTMLResumeGenerator(prs);
	gen.createIndexHTML();
	
	SQLiteManager.release();
    }
}
