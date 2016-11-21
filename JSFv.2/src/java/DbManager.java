
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Megaprey
 */
public class DbManager
{
    private static final String username = "root";
    private static final String password = "";
    private static final String con_string = "jdbc:mysql://localhost:3306/test_v.2";
    public static Connection con = null;
    public static Statement stmt = null;
    public static ResultSet rs = null;

    public  void DbConnection(String username, String password){
        if(this.username == username && this.password == password)
        {


            try{
                
                con = DriverManager.getConnection(con_string, username, password);
                System.out.println("Connected!");
            }
            catch( SQLException e)
            {
                System.out.println(e);
            }
        } else System.out.println("error");
    }

    public String DbSelect(String column, String table)
    {
        DbConnection(username,password);
        String Dbresult = "";
        String[] columns = column.split(",");
        try
        {
            
            stmt = con.createStatement();
            
            rs = stmt.executeQuery("SELECT " + column + " FROM " + table);
            while(rs.next())
            {
                for (int i = 0; i < columns.length; i++)
                {
                    String element = rs.getString(columns[i]);
                    Dbresult += columns[i] + " = " + element + " ";
                }
                Dbresult +="<br/>";
                
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                con.close();
                stmt.close();
                rs.close();
            }
            catch (SQLException e)
            {
            }
        }
        return Dbresult;

    }
    public  void DbInsert(String columns, String values)
    {
        DbConnection(username,password);
        String[] value = values.split(",");
        try {
            stmt = con.createStatement();
            
            
                
            String insert = "insert into subject (" + columns + ") values (";
            for(int i = 0; i < value.length; i++)
            {
                insert+= "'" + value[i] + "'";
                if(i != value.length - 1)
                    insert+= ",";
            }
            insert += ");";
              
            
        
        
            stmt.execute(insert); 
            con.commit();
        
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public  void DbDelete(String table, String condition)
    {
        
        DbConnection(username,password);
        
        try {
            stmt = con.createStatement();
            String dbdelete;
            if(condition == null)
            {
                dbdelete = "delete from " + table + ";";
            } else 
            {
                dbdelete = "delete from " + table + " where " + condition + ";";
            }
            stmt.execute(dbdelete);
            con.commit();
        }
         catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    }
    
     

