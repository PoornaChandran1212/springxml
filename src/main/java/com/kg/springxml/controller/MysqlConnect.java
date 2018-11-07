package com.kg.springxml.controller;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * @desc A singleton database access class for MySQL
 * @author Ramindu
 */
public final class MysqlConnect {
    public Connection conn;
    private Statement statement;
    public static MysqlConnect db;
    private MysqlConnect() {
        String url= "jdbc:mysql://localhost:3306/";
        String dbName = "travellog";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection)DriverManager.getConnection(url+dbName,userName,password);
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }
    /**
     *
     * @return MysqlConnect Database connection object
     */
    public static synchronized MysqlConnect getDbCon() {
        if ( db == null ) {
            db = new MysqlConnect();
        }
        return db;
 
    }
    /**
     *
     * @param query String The query to be executed
     * @return a ResultSet object containing the results or null if not available
     * @throws SQLException
    //  */
    // public ResultSet query(String query) throws SQLException{
    //     System.out.println(query);
    //     statement = db.conn.createStatement();
    //     ResultSet res = statement.executeQuery(query);
    //     System.out.println(res);
    //     resultSetToArrayList(res);
    //     return res;
    // }
    
    

    
    
    public ArrayList<Object> resultSetToArrayList(String res) throws SQLException {
        statement = db.conn.createStatement();
        ResultSet rs = statement.executeQuery(res);
 
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        ArrayList<Object> list = new ArrayList<Object>();
        while (rs.next()){
           HashMap<Object, Object> row = new HashMap<>(columns);
           for(int i=1; i<=columns; ++i){
            row.put(md.getColumnName(i),rs.getObject(i));
           }
            list.add(row);
        }
 
       return list;
      }
	public String query(String string) {
		return null;
	}

}