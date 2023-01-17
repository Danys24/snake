/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.snake;

import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 *
 * @author ACER
 */
public class Snake extends JFrame implements ActionListener, MouseListener{
    
    private JLabel titulo, empezar, puntaje, salir, copi;
    
    public Snake(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        titulo = new JLabel("Juego de la Serpiente");
        titulo.setBounds(70, 30, 300, 40);
        add(titulo);
        titulo.setFont(new Font("Agency FB", 1, 35));
        titulo.setForeground(new Color(255,255,255));
        
        empezar = new JLabel("Jugar");
        empezar.setBounds(177, 150, 300, 30);
        add(empezar);
        empezar.setFont(new Font("Agency FB", 1, 25));
        empezar.setForeground(new Color(255,255,255));
        empezar.addMouseListener(this);
        
        puntaje = new JLabel("Puntaje");
        puntaje.setBounds(170, 230, 300, 30);
        add(puntaje);
        puntaje.setFont(new Font("Agency FB", 1, 25));
        puntaje.setForeground(new Color(255,255,255));
        puntaje.addMouseListener(this);
        
        salir = new JLabel("Salir");
        salir.setBounds(180, 310, 300, 30);
        add(salir);
        salir.setFont(new Font("Agency FB", 1, 25));
        salir.setForeground(new Color(255,255,255));
        salir.addMouseListener(this);
        
        copi = new JLabel("Todos los derechos reservados 2023");
        copi.setBounds(110, 480, 300, 30);
        add(copi);
        copi.setFont(new Font("Agency FB", 1, 14));
        copi.setForeground(new Color(255,255,255));
        
        getContentPane().setBackground(new Color(100,100,100));
        setTitle("Snake inicio");
    }
    
    public static void main(String[] args){
        Snake principal = new Snake();
        principal.setBounds(0,0,400,550);
        principal.setVisible(true);
        principal.setResizable(false);
        principal.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //JOptionPane.showMessageDialog(null, "se ha dado click en salir");
        if(e.getComponent() == empezar){
            SnakeJuego juego = new SnakeJuego();
            int width = juego.width;
            int height = juego.height;
            juego.setBounds(0, 0, width, height);
            juego.setVisible(true);
            juego.setResizable(false);
            juego.setLocationRelativeTo(null);
            juego.puntos= 0;
            this.dispose();
            
        }
        
        if(e.getComponent() == puntaje){
            SnakePuntos snakePuntos = new SnakePuntos();
            snakePuntos.setBounds(0,0,400,400);
            snakePuntos.setVisible(true);
            snakePuntos.setResizable(false);
            snakePuntos.setLocationRelativeTo(null);
            this.dispose();
        }
        
        if(e.getComponent() == salir){
            System.exit(0);
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
     
    
}
