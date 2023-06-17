package dao;
import java.util.ArrayList;

public interface Idao <T>{
	//insert an object<T> (a record)in database 
    public int insert (T obj); 
    public int update(T obj);
    public int delete (T obj);
    public ArrayList<T> selectAll ();
    public T selectByID (T obj); 
    public T selectByCondition (String condition);
    
}
