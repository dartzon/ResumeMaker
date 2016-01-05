package com.resume.persistance;

import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;
import com.resume.data.GlobalConfig;
import com.resume.data.Person;

public class GlobalConfigPersistance extends DBPersistance
{
    public boolean save(Object obj, Object... args)
    {
	GlobalConfig gc= (GlobalConfig) obj;
	Person pers= (Person) args[0];
	
	String stmt= "INSERT INTO SPOKENLANG (HOBBIES, PERSON_ID) ";
	stmt+= "VALUES('%s', %d)";
	stmt= String.format(stmt, gc.getProfileTitle(), pers.getID());
	
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
	final String stmt= "SELECT R.PROFILETITLE FROM RESUMECONFIG R, PERSON P "
		+ "WHERE R.PERSON_ID=P.ID AND R.PERSON_ID="+ ID;
	
	System.out.println(stmt);

	SQLiteStatement sqlStmt= executeStatement(stmt);
	
	if(sqlStmt == null)
	{
	    return (null);
	}
	
	GlobalConfig gc= new GlobalConfig();
	
	try
	{
	    while( sqlStmt.step() == true )
	    {
		int colIdx= 0;
		final String title= sqlStmt.columnString(colIdx++);
		gc.setProfileTitle(title);
	    }
	}
	catch (SQLiteException e)
	{
	    e.printStackTrace();
	    
	    return (null);
	}
	
	return (gc);
    }
}
