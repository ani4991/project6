/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logingame;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Lindsie Dinh
 */
//public class Connection{
//    
//    private String userName = "";
//    private String password = "";
//    private String serverName = "";
//    private String dbName = "";
//    private String portNumber = "";
//    private String dbms = "mysql";
//    
//    public Connection getConnection() throws SQLException {
//
//        Connection conn = null;
//        Properties connectionProps = new Properties();
//        connectionProps.put("user", this.userName);
//        connectionProps.put("password", this.password);
//
//        if (this.dbms.equals("mysql")) {
//            conn = DriverManager.getConnection(
//                    "jdbc:" + this.dbms + "://"
//                    + this.serverName
//                    + ":" + this.portNumber + "/",
//                    connectionProps);
//        } else if (this.dbms.equals("derby")) {
//            conn = DriverManager.getConnection(
//                    "jdbc:" + this.dbms + ":"
//                    + this.dbName
//                    + ";create=true",
//                    connectionProps);
//        }
//        System.out.println("Connected to database");
//        return conn;
//    }
//}
