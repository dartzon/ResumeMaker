package com.resume.test;

import java.util.Vector;

import com.resume.data.Education;
import com.resume.data.Experience;
import com.resume.data.Person;
import com.resume.html.HTMLResumeGenerator;
import com.resume.persistance.EducationPersistance;
import com.resume.persistance.ExperiencePersistance;
import com.resume.persistance.PersonPersistance;
import com.resume.persistance.SQLiteManager;

public class Test
{
    public static void main(String[] args)
    {
	PersonPersistance prsper= new PersonPersistance();
	Person prs= (Person) prsper.load(1);
	
	EducationPersistance eduper= new EducationPersistance();
	Vector<Education> educations= (Vector<Education>) eduper.load( prs.getID() );
	
	ExperiencePersistance expper= new ExperiencePersistance();
	Vector<Experience> experiences= (Vector<Experience>) expper.load( prs.getID() );
	
	HTMLResumeGenerator gen= new HTMLResumeGenerator(prs, educations, experiences);
	gen.createIndexHTML();
	
	SQLiteManager.release();
    }
}
