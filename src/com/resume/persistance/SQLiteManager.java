package com.resume.persistance;

import java.io.File;

import com.almworks.sqlite4java.SQLiteConnection;
import com.almworks.sqlite4java.SQLiteException;

public class SQLiteManager
{
    public static SQLiteManager getSingleton(final String DBPath)
    {
	if(m_SQLMgr == null)
	{
	    m_SQLMgr= new SQLiteManager(DBPath);
	}
	
	return (m_SQLMgr);
    }
    
    public static void release()
    {
	if(m_SQLMgr != null)
	{
	    m_SQLMgr.m_DBConnection.dispose();
	}
    }
    
    public SQLiteConnection getConnection()
    {
	return (m_DBConnection);
    }
    
    private SQLiteManager(final String DBPath)
    {
	m_DBPath= DBPath;
	
	m_DBConnection= new SQLiteConnection( new File(m_DBPath) );
	
	try
	{
	    m_DBConnection.open(false);
	}
	catch (SQLiteException e)
	{
	    e.printStackTrace();
	}
    }
    
    private final SQLiteConnection m_DBConnection;
    private final String m_DBPath;
    
    private static SQLiteManager m_SQLMgr= null;
}
