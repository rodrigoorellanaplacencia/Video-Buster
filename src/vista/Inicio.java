/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author LEARNING CENTER
 */
public class Inicio{

    private JFrame ventana;
    private JMenuBar barraMenu;
    private JMenu menuArchivo;
    private JMenu menuPelicula;
    private JMenuItem itemSalir;
    private JMenuItem itemAgregar;
    private JMenuItem itemListar;
    private JMenuItem itemBuscar;
    private JMenuItem itemModificar;
    private JMenuItem itemEliminar;
    

    public Inicio() 
    {
        //Ventana Inicio
        this.ventana = new JFrame();
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setBounds(0,0,500,500);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Programa Video Buster");
        
        //Barra de menú
        this.barraMenu = new JMenuBar();

        this.menuArchivo = new JMenu("Archivo");
        
        this.menuPelicula = new JMenu("Película");
        this.itemAgregar = new JMenuItem("Agregar");

        //agregar
        this.itemAgregar = new JMenuItem("Agregar"); 
        itemAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                itemAgregarActionPerformed(evt);
            }
        });
        //listar
        this.itemListar = new JMenuItem("Listar");
        itemListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                itemListarActionPerformed(evt);
            }
        });
        //buscar
        this.itemBuscar = new JMenuItem("Buscar");
        itemBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                itemBuscarActionPerformed(evt);
            }
        });
        //modificar
        this.itemModificar = new JMenuItem("Modificar");
        itemModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                itemModificarActionPerformed(evt);
            }
        });
        //eliminar
        this.itemEliminar = new JMenuItem("Eliminar");
        itemEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                itemEliminarActionPerformed(evt);
            }
        });
        //salir
        this.itemSalir = new JMenuItem("Salir"); 
        itemSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        

        
        this.barraMenu.add(menuArchivo);
        this.menuArchivo.add(itemSalir);
        
        this.barraMenu.add(menuPelicula);
        this.menuPelicula.add(itemAgregar);
        this.menuPelicula.add(itemListar);
        this.menuPelicula.add(itemBuscar);
        this.menuPelicula.add(itemModificar);
        this.menuPelicula.add(itemEliminar);
        this.ventana.setJMenuBar(barraMenu);  
    }
    

    
    public JFrame getVentana() {
        return ventana;
    }

    public void setVentana(JFrame ventana) {
        this.ventana = ventana;
    }

    public JMenuBar getBarraMenu() {
        return barraMenu;
    }

    public void setBarraMenu(JMenuBar barraMenu) {
        this.barraMenu = barraMenu;
    }

    public JMenu getMenuArchivo() {
        return menuArchivo;
    }

    public void setMenuArchivo(JMenu menuArchivo) {
        this.menuArchivo = menuArchivo;
    }
    
    public void setVisible(boolean visible)
    {
        this.ventana.setVisible(visible);
    }

    
    //ACCIONES DE LOS BOTONES
    
    private void itemSalirActionPerformed(ActionEvent evt) {                                         
        System.exit(0);
    } 
    
    private void itemAgregarActionPerformed(ActionEvent evt) {                                         
        Agregar agregar = new Agregar();
        agregar.setVisible(true);
        

    } 
    
    private void itemListarActionPerformed(ActionEvent evt) {
        Listar listar = new Listar();
        listar.setVisible(true);
    }
    
    private void itemBuscarActionPerformed(ActionEvent evt) {
        Modificar modificar = new Modificar();
        modificar.setVisible(true);
    }     
    private void itemModificarActionPerformed(ActionEvent evt) {
        Modificar modificar = new Modificar();
        modificar.setVisible(true);
    }
    private void itemEliminarActionPerformed(ActionEvent evt) {
        Eliminar eliminar = new Eliminar();
        eliminar.setVisible(true);
    }
    
}
