/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.Pelicula;

/**
 *
 * @author Ivo
 */
public class Metodos {
    public void agregar(Pelicula pelicula)
    {
        try
        {
            Connection conexion = Conexion.getConnection();
            Statement statement = conexion.createStatement();
            String consulta = "insert into PELICULA (codigo,nombre,precio, id_categoria, formato4k ) values('"+pelicula.getCodigo()+"','"+pelicula.getNombre()+"','"+pelicula.getPrecio()+"','"+pelicula.getIdCategoria()+"','"+pelicula.getFormato4k()+"')";
            statement.executeUpdate(consulta);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(new JDialog(), "Error al agregar.");
        }
        
    }
    
    public void eliminar(int codigo)
    {
        if(existePelicula(codigo)){
          try
        {
            Connection conexion = Conexion.getConnection();
            Statement statement = conexion.createStatement();
            String consulta = "delete from pelicula where codigo = "+codigo;
            statement.executeUpdate(consulta);
            JOptionPane.showMessageDialog(null, "Pelicula eliminada");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(new JDialog(), "Error al eliminar.");
        }          
        }else{
        JOptionPane.showMessageDialog(null, "Codigo no existe, ingrese nuevo codigo");
        }
    }
        
    
    public ArrayList<Pelicula> getLista()
    {
        ArrayList<Pelicula> peliculas = new ArrayList();
        String sentencia = "SELECT codigo, nombre, precio, id_categoria, formato4k FROM PELICULA"; 
        try {
            Connection conexion = Conexion.getConnection();
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sentencia);
            
            while (resultado.next()){
   
                int codigo =Integer.parseInt(resultado.getString("codigo"));
                String nombre =resultado.getString("nombre");
                int precio =Integer.parseInt(resultado.getString("precio"));
                int id_categoria =Integer.parseInt(resultado.getString("id_categoria"));
                char formato4k =resultado.getString("formato4k").charAt(0);

                peliculas.add(new Pelicula(codigo, precio, id_categoria, formato4k, nombre));
            }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(new JDialog(), "Error al listar.");
        }
        return peliculas;
    }
    
    
    public Pelicula buscar(int code)
    {
        Pelicula pelicula;
        String sentencia = "SELECT codigo, nombre, precio, id_categoria, formato4k FROM PELICULA where codigo ="+code; 
        pelicula = null;
        try {
            Connection conexion = Conexion.getConnection();
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sentencia);
            while(resultado.next())
            {
                int codigo =Integer.parseInt(resultado.getString("codigo"));
                String nombre =resultado.getString("nombre");
                int precio =Integer.parseInt(resultado.getString("precio"));
                int id_categoria =Integer.parseInt(resultado.getString("id_categoria"));
                char formato4k =resultado.getString("formato4k").charAt(0);

                pelicula = new Pelicula(codigo, precio, id_categoria, formato4k, nombre);
            }
                
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(new JDialog(), "Error al buscar.");
             pelicula = null;
        }
        return pelicula;
    }
    
     public boolean existePelicula(int codigo)
    {
        for (Pelicula tmp : getLista())
        {
            if(codigo == tmp.getCodigo())
            {
                return true;
            }
        }
        return false;
    }
     
     
       public void modificar(Pelicula pelicula, int codigo) throws SQLException
    {
        String sentencia = "update pelicula set nombre='"+pelicula.getNombre()+"' where codigo ="+codigo;
        String sentencia1 = "update pelicula set precio='"+pelicula.getPrecio()+"' where codigo ="+codigo;
        String sentencia2 = "update pelicula set id_categoria='"+pelicula.getIdCategoria()+"' where codigo ="+codigo;
        String sentencia3 = "update pelicula set formato4k='"+pelicula.getFormato4k()+"' where codigo ="+codigo;
        
        Connection conexion = Conexion.getConnection();
        Statement statement = conexion.createStatement();
        statement.executeUpdate(sentencia);
        statement.executeUpdate(sentencia1);
        statement.executeUpdate(sentencia2);
        statement.executeUpdate(sentencia3); 
    }
     
}
