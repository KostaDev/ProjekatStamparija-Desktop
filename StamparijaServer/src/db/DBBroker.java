/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.IOpstiDomenskiObjekat;
import helpers.PropertyReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import konstante.Konstante;

/**
 *
 * @author Kosta
 */
public class DBBroker {
    Connection connection;
    PropertyReader pr;
    
    private static DBBroker instance;

    private DBBroker() {
        pr = new PropertyReader();
    }

    public static DBBroker getInstance() {
        if(instance == null)
            instance = new DBBroker();
        return instance;
    }
    
    
    
    public void ucitajDrajver() throws ClassNotFoundException{
        Class.forName(pr.readForKey(Konstante.DRIVER));
    }
    public void otvoriKonekciju() throws SQLException{
        connection = DriverManager.getConnection(pr.readForKey(Konstante.URL), pr.readForKey(Konstante.USER), pr.readForKey(Konstante.PASSWORD));
        connection.setAutoCommit(false);
    }
    public void zatvoriKonekciju() throws SQLException{
        connection.close();
    }
    
    public void commit() throws SQLException{
        connection.commit();
    }
    public void rollback() throws SQLException{
        connection.rollback();
    }

    public List<IOpstiDomenskiObjekat> select(IOpstiDomenskiObjekat odo) throws SQLException{
        String upit = "SELECT * FROM "+odo.nazivTabele()+" "+odo.alijas()+" "+odo.join()+" "+odo.selectWhere();
        System.out.println(upit);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return odo.ucitajListu(rs);
    }
    public void insert(IOpstiDomenskiObjekat odo) throws SQLException{
        String upit = "INSERT INTO "+odo.nazivTabele()+" "+odo.koloneInsert()+" VALUES("+odo.vrednostiInsert()+")";
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }
    public void update(IOpstiDomenskiObjekat odo) throws SQLException{
        String upit = "UPDATE "+odo.nazivTabele()+" SET "+odo.vrednostiUpdate()+" WHERE "+odo.vrednostPrimarniKljuc();
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }
    public void delete(IOpstiDomenskiObjekat odo) throws SQLException{
        String upit = "DELETE FROM "+odo.nazivTabele()+" WHERE "+odo.vrednostPrimarniKljuc();
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }
    public int max(IOpstiDomenskiObjekat odo) throws SQLException{
        String upit ="SELECT max("+odo.vratiMax()+") as max from "+odo.nazivTabele();
        System.out.println(upit);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);
        int max = 0;
        while (rs.next()) {            
            max = rs.getInt("max");
        }
        return max;
    }

    public void deleteDokumenta(IOpstiDomenskiObjekat odo) throws SQLException {
        String upit = "DELETE FROM dokument WHERE "+odo.vrednostPrimarniKljuc();
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    
    }
}
