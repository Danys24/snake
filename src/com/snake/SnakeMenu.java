/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.JLabel;

/**
 *
 * @author ACER
 */
public class SnakeMenu extends JFrame implements MouseListener{
    
    JLabel over, continuar, volverInicio, salir, puntaje;
    int puntos = 0;
    SnakeJuego juego = new SnakeJuego();
    int width;
    int height;
    
    public SnakeMenu(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        over = new JLabel("GAME OVER");
        over.setBounds(130, 30, 300, 40);
        add(over);
        over.setFont(new Font("Agency FB", 1, 35));
        over.setForeground(new Color(255,255,255));
        
        continuar = new JLabel("continuar");
        continuar.setBounds(163, 150, 300, 30);
        add(continuar);
        continuar.setFont(new Font("Agency FB", 1, 18));
        continuar.setForeground(new Color(255,255,255));
        continuar.addMouseListener(this);
        
        volverInicio = new JLabel("Volver al Inicio");
        volverInicio.setBounds(150, 200, 300, 30);
        add(volverInicio);
        volverInicio.setFont(new Font("Agency FB", 1, 18));
        volverInicio.setForeground(new Color(255,255,255));
        volverInicio.addMouseListener(this);
        
        salir = new JLabel("Salir");
        salir.setBounds(174, 250, 300, 30);
        add(salir);
        salir.setFont(new Font("Agency FB", 1, 18));
        salir.setForeground(new Color(255,255,255));
        salir.addMouseListener(this);
        
        juego = new SnakeJuego();
        puntos = juego.puntos;
        
        puntaje = new JLabel("Su Puntaje fue: " + puntos);
        puntaje.setBounds(145, 320, 300, 30);
        add(puntaje);
        puntaje.setFont(new Font("Agency FB", 1, 15));
        puntaje.setForeground(new Color(255,255,255));
        
        
        getContentPane().setBackground(new Color(100,100,100));
        setTitle("Game Over");
    }
    
    public static void main(String args[]){
        SnakeMenu menu = new SnakeMenu();
        menu.setBounds(0,0,400,400);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        menu.setResizable(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent() == continuar){
            juego = new SnakeJuego();
            width = juego.width;
            height = juego.height;
            juego.setBounds(0, 0, width, height);
            juego.setVisible(true);
            juego.setResizable(false);
            juego.setLocationRelativeTo(null);
            juego.puntos= 0;
            this.dispose();
            
        }
        
        if(e.getComponent() == volverInicio){
            Snake principal = new Snake();
            principal.setBounds(0,0,400,550);
            principal.setVisible(true);
            principal.setResizable(false);
            principal.setLocationRelativeTo(null);
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
