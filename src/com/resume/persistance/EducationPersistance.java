package com.resume.persistance;

import java.util.Vector;

import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;
import com.resume.data.Education;
import com.resume.data.Person;

public class EducationPersistance extends DBPersistance
{
    public boolean save(Object obj, Object ... args)
    {
	Education educ= (Education) obj;
	Person pers= (Person) args[0];
	
	String stmt= "INSERT INTO EDUCATION (INSTITUTION, INTERVAL_DATE_START, INTERVAL_DATE_END, "
		+ "TITLE, IS_CURRENT, PERSON_ID) ";
	stmt+= "VALUES('%s', '%d', '%d', '%s', '%d', '%d', '%d')";
	stmt= String.format(stmt, educ.getInstitutionName(), educ.getStartYear(), educ.getEndYear(), educ.getTitle(),
		(educ.isCurrent() == true) ? 1 : 0, pers.getID());
	
	SQLiteStatement sqlStmt= executeStatement(stmt);
	
	if(sqlStmt == null)
	{
	    return (false);
	}
	
	try
	{
	    sqlStmt.stepThrough();
	    
	    sqlStmt.dispose();
	}
	catch (SQLiteException e)
	{
	    e.printStackTrace();
	    
	    return (false);
	}

	return (true);
    }
    
    public Object load(int ID)
    {
	final String stmt= "SELECT INSTITUTION, INTERVAL_DATE_START, INTERVAL_DATE_END,"+
		     "TITLE, DETAIL, IS_CURRENT "+
		     "FROM PERSON P, EDUCATION E "+
		     "WHERE P.ID = E.ID AND P.ID= "+ ID;

	SQLiteStatement sqlStmt= executeStatement(stmt);
	
	if(sqlStmt == null)
	{
	    return (null);
	}
	
	Vector<Education> educations= new Vector<Education>();
	
	try
	{
	    while( sqlStmt.step() == true )
	    {
		System.out.println(stmt);
		
		int colIdx= 0;
		String institutionName= sqlStmt.columnString(colIdx++);
		int startYear= sqlStmt.columnInt(colIdx++);
		int endYear= sqlStmt.columnInt(colIdx++);
		String title= sqlStmt.columnString(colIdx++);
		String description= sqlStmt.columnString(colIdx++);
		boolean isCurrent= (sqlStmt.columnInt(colIdx++) == 1) ? true : false;
		
		educations.add(new Education(institutionName, startYear, endYear, title, description, isCurrent));
	    }
	}
	catch (SQLiteException e)
	{
	    e.printStackTrace();
	    
	    return (null);
	}
	
	return (educations);
    }
}
