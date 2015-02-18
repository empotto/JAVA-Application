/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasqlite;
import java.sql.*;
/**
 *
 * @author EmpOtto
 */
public class JavaSQLite {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
      
       Connection c = null;
       Statement stmt=null;
        try
        {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\EmpOtto\\Desktop\\test.sqlite");
          c.setAutoCommit(true);
          stmt = c.createStatement();
          String sql = "INSERT INTO test(AD,SOYAD,TC) VALUES('ISMAIL','SAHIN','12345678911')"; 
          stmt.execute(sql);
          System.out.println("Veriler Veritabanina Eklendi");
          ResultSet rs=stmt.executeQuery("SELECT * FROM test");
          System.out.println("<--UPDATE Sorgusundan önce-->");
          while(rs.next())
          {
              System.out.println("AD:"+rs.getString("AD"));
              System.out.println("SOYAD:"+rs.getString("SOYAD"));
              System.out.println("TC:"+rs.getString("TC"));
          }
          
          stmt.executeUpdate("UPDATE test SET AD='EMP' WHERE AD='ISMAIL'");
          rs=stmt.executeQuery("SELECT * FROM test");
          System.out.println("<--UPDATE sorgusundan sonra-->");
          while(rs.next())
          {
              System.out.println("Veritabanından veriler okunuyor");
              System.out.println("AD:"+rs.getString("AD"));
              System.out.println("SOYAD:"+rs.getString("SOYAD"));
              System.out.println("TC:"+rs.getString("TC"));
          }
        }
        catch (ClassNotFoundException | SQLException e) 
        {
           System.out.println("Islemler yapilirken hata olustu:"+e);
           System.exit(0);
        }
       stmt.close();
        c.close();
        
    }
    
}
