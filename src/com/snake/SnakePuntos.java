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
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author ACER
 */
public class SnakePuntos extends JFrame implements MouseListener{
        JLabel puntaje, cantidadPuntos, volverInicio, score;
        SnakeJuego juego = new SnakeJuego();
        public static int puntajeMaximo = 0;
        
    public SnakePuntos(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        puntaje = new JLabel("PUNTAJE");
        puntaje.setBounds(142, 30, 300, 40);
        add(puntaje);
        puntaje.setFont(new Font("Agency FB", 1, 35));
        puntaje.setForeground(new Color(255,255,255));
        
        cantidadPuntos = new JLabel("Puntuacion Maxima");
        cantidadPuntos.setBounds(135, 200, 300, 30);
        add(cantidadPuntos);
        cantidadPuntos.setFont(new Font("Agency FB", 1, 18));
        cantidadPuntos.setForeground(new Color(255,255,255));
        cantidadPuntos.addMouseListener(this);
        
        volverInicio = new JLabel("Volver al Inicio");
        volverInicio.setBounds(150, 150, 300, 30);
        add(volverInicio);
        volverInicio.setFont(new Font("Agency FB", 1, 18));
        volverInicio.setForeground(new Color(255,255,255));
        volverInicio.addMouseListener(this);
        
        score = new JLabel(""+puntajeMaximo);
        score.setBounds(174, 260, 300, 30);
        add(score);
        score.setFont(new Font("Agency FB", 1, 40));
        score.setForeground(new Color(255,255,255));
        
        mostrarPuntos();
        
        getContentPane().setBackground(new Color(100,100,100));
        setTitle("Puntaje");
    }
    
    public void mostrarPuntos(){
        if(puntajeMaximo < juego.puntos){
            puntajeMaximo = juego.puntos;
            score.setText("" + puntajeMaximo);
        }
    }
    
    public static void main(String args[]){
        SnakePuntos snakePuntos = new SnakePuntos();
        snakePuntos.setBounds(0,0,400,400);
        snakePuntos.setVisible(true);
        snakePuntos.setResizable(false);
        snakePuntos.setLocationRelativeTo(null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getComponent() == volverInicio){
            Snake principal = new Snake();
            principal.setBounds(0,0,400,550);
            principal.setVisible(true);
            principal.setResizable(false);
            principal.setLocationRelativeTo(null);
            this.dispose();
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
