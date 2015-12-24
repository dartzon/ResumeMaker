package com.resume.persistance;

import java.util.Vector;

import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;
import com.resume.data.Person;
import com.resume.data.skills.Lang;

public class LangPersistance extends DBPersistance
{
    public boolean save(Object obj, Object... args)
    {
	Lang lg= (Lang) obj;
	Person pers= (Person) args[0];
	int langID= (int) args[1];
	
	String stmt= "INSERT INTO SPOKENLANG (ID_PERSON, ID_LANG, LVL) ";
	stmt+= "VALUES('%d', '%d', %d)";	
	stmt= String.format(stmt, langID, pers.getID(), lg.getLevel());
	
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
	final String stmt= "SELECT L.NAME, S.LVL FROM SPOKENLANG S, LANG L, PERSON P "
		+ "WHERE S.ID_PERSON=P.ID AND S.ID_LANG=L.ID A, ID_PERSON = "+ ID;
	
	System.out.println(stmt);

	SQLiteStatement sqlStmt= executeStatement(stmt);
	
	if(sqlStmt == null)
	{
	    return (null);
	}
	
	Vector<Lang> langs= new Vector<Lang>();
	
	try
	{
	    while( sqlStmt.step() == true )
	    {
		int colIdx= 0;
		final String name= sqlStmt.columnString(colIdx++);
		final int level= sqlStmt.columnInt(colIdx++);
		
		langs.add(new Lang(name, level));
	    }
	}
	catch (SQLiteException e)
	{
	    e.printStackTrace();
	    
	    return (null);
	}
	
	return (langs);
    }
}
