/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.Categoria;
import modelo.Pelicula;

/**
 *
 * @author Ivo
 */
public class MetodosCategoria {
     public ArrayList<Categoria> getLista()
    {
        ArrayList<Categoria> categorias = new ArrayList();
        String sentencia = "SELECT id_categoria, descripcion FROM CATEGORIA ORDER BY ID_CATEGORIA ASC"; 
        try {
            Connection conexion = Conexion.getConnection();
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sentencia);
            
            while (resultado.next()){
   
                int id_categoria =Integer.parseInt(resultado.getString("id_categoria"));
                String descripcion =resultado.getString("descripcion");

                categorias.add(new Categoria(id_categoria, descripcion));
            }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(new JDialog(), "Error al listar.");
        }
        return categorias;
    }
}
