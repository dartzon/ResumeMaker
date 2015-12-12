package com.resume.persistance;

import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;
import com.resume.data.Person;

public class PersonPersistance extends DBPersistance
{    
    public boolean save(Object obj)
    {
	Person person= (Person) obj;
	
	String stmt= "INSERT INTO PERSON (FIRSTNAME, LASTNAME, BIRTHDAY, NATIONALITY_ID, MARTIALSTATUS, "
		+ "ADDRESS, EMAIL, TEL, WEBSITE) ";
	stmt+= "VALUES('%s', '%s', '%s', '%d', '%d', '%s', '%s', '%s', '%s')";
	stmt= String.format(stmt, person.getFirstName(), person.getLastName(), person.getBirthDay(), 118,
		(person.getMartialStatus() == true) ? 1 : 0, person.getAddress(), person.getEmail(),
			person.getTel(), person.getWebSite());
	
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
	final String stmt= "SELECT FIRSTNAME, LASTNAME, BIRTHDAY, NAME,"+
		     "MARTIALSTATUS, ADDRESS, EMAIL, TEL, WEBSITE "+
		     "FROM PERSON P, COUNTRY C "+
		     "WHERE P.NATIONALITY_ID = C.ID AND P.ID= "+ ID;
	
	SQLiteStatement sqlStmt= executeStatement(stmt);
	
	if(sqlStmt == null)
	{
	    return (null);
	}
	
	Person person= null;
	
	try
	{
	    while( sqlStmt.step() == true )
	    {
		System.out.println(stmt);
		
		int colIdx= 0;
		final String firstName= sqlStmt.columnString(colIdx++);
		final String lastName= sqlStmt.columnString(colIdx++);
		final String birthday= sqlStmt.columnString(colIdx++);
		final String nationality= sqlStmt.columnString(colIdx++);
		final boolean martialStatus= (sqlStmt.columnInt(colIdx++) == 1) ? true : false;
		final String address= sqlStmt.columnString(colIdx++);
		final String email= sqlStmt.columnString(colIdx++);
		final String tel= sqlStmt.columnString(colIdx++);
		final String webSite= sqlStmt.columnString(colIdx++);
		
		person= new Person(firstName, lastName, birthday, nationality, martialStatus,
			address, email, tel, webSite);
	    }
	}
	catch (SQLiteException e)
	{
	    e.printStackTrace();
	    
	    return (null);
	}
	
	return (person);
    }
}
