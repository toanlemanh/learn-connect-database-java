package database;

/**
 * Description	Resource	Path	Location	Type
The project was not built since its build path is incomplete. Cannot find the class file for java.lang.Object. Fix the build path then try building this project	BaiTap03		Unknown	Java Problem
The type java.lang.Object cannot be resolved. It is indirectly referenced from required .class files	Haha.java	/BaiTap03/src/database	line 1	Java Problem

 * This is because the version of Jdk and Eclipse are not compatible with, so Eclipse throws some errors  
 * 
 * 
 * @author Toan Tom
 *
 */

public class Haha {
	/**
	 *  To connect a java application to a database, jdbc is a professional solution.
	 *  It is a group of API (classes, methods, interface, protocols, processes) is written by
	 *  database's software group ( Oracle, Microsoft, GG... ).
	 *  
	 *  A connection with HTTP protocol is necessary.
	 *  
	 *  However, we need to create a type of jdbc driver that provides our ability to 
	 *  communicate with database from java app.
	 *  JDBC is stand for Java Database Connectivity
	 *  
	 *  Secondly, we need to register a jdbc driver with DriverManager class, 
	 *  which organizes all drivers.  
	 *  
	 *  The, we declare an url that fits the syntax of certain type of 
	 *  jdbc driver.
	 *  
	 *  VD: jdbc driver of mysql   
	 *  jdbc : mysql:: // <server> : <port>/<database> ? <props>
	 * 
	 * 
	 * 
	 */

}
