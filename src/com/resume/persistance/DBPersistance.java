package com.resume.persistance;

import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;

public abstract class DBPersistance
{
    public DBPersistance()
    {
	m_SQLMgr= SQLiteManager.getSingleton("data/ResumeMaker");
    }
    
    protected SQLiteStatement executeStatement(final String stmt)
    {
	SQLiteStatement sqlStmt= null;
		
	try
	{
	    sqlStmt= m_SQLMgr.getConnection().prepare(stmt);
	}
	catch (SQLiteException e)
	{
	    e.printStackTrace();
	}
	
	return (sqlStmt);
    }
    
    public abstract boolean save(Object obj);
    public abstract Object load(int ID);
    
    protected SQLiteManager m_SQLMgr;
}
