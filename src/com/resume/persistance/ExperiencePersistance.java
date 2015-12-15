package com.resume.persistance;

import java.util.Vector;

import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;
import com.resume.data.Experience;
import com.resume.data.Person;

public class ExperiencePersistance extends DBPersistance
{
    public boolean save(Object obj, Object ... args)
    {
	Experience exp= (Experience) obj;
	Person pers= (Person) args[0];
	
	String stmt= "INSERT INTO EXPERIENCE (COMPANY, DATE_START, DATE_END, NB_WEEKS, WEBSITE, TITLE,"
		+ "DETAIL, IS_CURRENT, PERSON_ID) ";
	stmt+= "VALUES('%s', '%s', '%s', %d, '%s', '%s', '%s', %d, %d)";
	stmt= String.format(stmt, exp.getcompany(), exp.getDateStart(), exp.getDateEnd(), exp.getWeekCount(),
		exp.getCompanyWebSite(), exp.getTitle(), exp.getDetail(), (exp.isCurrent() == true) ? 1 : 0,
			pers.getID());
	
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
	final String stmt= "SELECT COMPANY, DATE_START, DATE_END, NB_WEEKS, E.WEBSITE, TITLE, DETAIL,"
		+ "IS_CURRENT "+
		     "FROM PERSON P, EXPERIENCE E "+
		     "WHERE P.ID = E.PERSON_ID AND P.ID= "+ ID;
	
	System.out.println(stmt);

	SQLiteStatement sqlStmt= executeStatement(stmt);
	
	if(sqlStmt == null)
	{
	    return (null);
	}
	
	Vector<Experience> experiences= new Vector<Experience>();
	
	try
	{
	    while( sqlStmt.step() == true )
	    {
		int colIdx= 0;
		String company= sqlStmt.columnString(colIdx++);
		String dateStart= sqlStmt.columnString(colIdx++);
		String dateEnd= sqlStmt.columnString(colIdx++);
		int weekCount= sqlStmt.columnInt(colIdx++);
		String companyWebSite= sqlStmt.columnString(colIdx++);
		String title= sqlStmt.columnString(colIdx++);
		String detail= sqlStmt.columnString(colIdx++);
		boolean isCurrent= (sqlStmt.columnInt(colIdx++) == 1) ? true : false;
		
		experiences.add(new Experience(company, dateStart, dateEnd, weekCount, companyWebSite,
			title, detail, isCurrent));
	    }
	}
	catch (SQLiteException e)
	{
	    e.printStackTrace();
	    
	    return (null);
	}
	
	return (experiences);
    }
}
