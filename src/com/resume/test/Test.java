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
	
	PersonPersistance prsper= new PersonPersistance();
	
	//prsper.save(prs);
	prs= (Person) prsper.load(1);
	
	HTMLResumeGenerator gen= new HTMLResumeGenerator(prs);
	gen.createIndexHTML();
	
	SQLiteManager.release();
    }
}
