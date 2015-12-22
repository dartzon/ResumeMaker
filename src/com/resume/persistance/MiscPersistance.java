package com.resume.persistance;

import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;
import com.resume.data.Misc;
import com.resume.data.Person;

public class MiscPersistance extends DBPersistance
{
    public boolean save(Object obj, Object ... args)
    {
	Misc misc= (Misc) obj;
	Person pers= (Person) args[0];
	
	String stmt= "INSERT INTO MISC (HOBBIES, PERSON_ID) ";
	stmt+= "VALUES('%s', '%d')";	
	stmt= String.format(stmt, misc.getHobbies(), pers.getID());
	
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
	final String stmt= "SELECT HOBBIES "+
		     "FROM PERSON P, MISC M "+
		     "WHERE P.ID = M.PERSON_ID AND P.ID= "+ ID;
	
	System.out.println(stmt);
	
	SQLiteStatement sqlStmt= executeStatement(stmt);
	
	if(sqlStmt == null)
	{
	    return (null);
	}
	
	Misc misc= null;
	
	try
	{
	    while( sqlStmt.step() == true )
	    {
		int colIdx= 0;
		final String hobbies= sqlStmt.columnString(colIdx++);
		
		misc= new Misc(hobbies);
	    }
	}
	catch (SQLiteException e)
	{
	    e.printStackTrace();
	    
	    return (null);
	}
	
	return misc;
    }

}
