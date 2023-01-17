/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class SnakeJuego extends JFrame implements ActionListener {
    
    JLabel puntuacion;
    static int puntos = 0;
    Point snake;
    Point comida;
    boolean gameOver = false;
    int widthPoint = 7;
    int heighPoint = 7;
    int width = 550;
    int height = 400;
    ImagenSnake imagen;
    int direccion = KeyEvent.VK_LEFT;
    long frecuencia = 60;
    SnakeMenu menu;
    ArrayList<Point> list = new ArrayList<Point>();

    public SnakeJuego() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        puntuacion = new JLabel("Puntuacion: " + 0);
        puntuacion.setBounds(440, 15, 100, 15 );
        add(puntuacion);
        puntuacion.setFont(new Font("Agency FB", 1, 12));
        puntuacion.setForeground(new Color(0,0,0));
        
        startGame();

        Teclas teclas = new Teclas();
        this.addKeyListener(teclas);

        snake = new Point(width / 2, height / 2);

        imagen = new ImagenSnake();
        getContentPane().add(imagen);

        Momento momento = new Momento();
        Thread trid = new Thread(momento);
        trid.start();
        
        
        getContentPane().setBackground(new Color(200, 200, 200));
        setTitle("juego");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void actualizar() {
        repaint();

        list.add(0, new Point(snake.x, snake.y));
        list.remove(list.size() - 1);

        for (int i = 1; i < list.size(); i++) {
            Point punto = list.get(i);
            if (snake.x == punto.x && snake.y == punto.y) {
                gameOver = true;
            }
        }
        
        /*
        if(snake.x == width || snake.x == (width - 550) ||  snake.y == (height - 400) || snake.y == height){
            gameOver = true;
        }
        */

        if (snake.x > comida.x - 10 && snake.x < comida.x + 10 && snake.y > comida.y - 10 && snake.y < comida.y + 10) {
            list.add(0, new Point(snake.x, snake.y));
            crearComida();
            puntos ++;
            puntuacion.setText("Puntuacion: " + puntos);
            
        }
        menu();
    }
    
    public int tenerPuntos(){
        return puntos;
    }

    public void startGame() {
        comida = new Point((int) (((Math.random() * 550) / 100) * 100), (int) (((Math.random() * 400) / 100) * 100));
        snake = new Point(width / 2, height / 2);

        list = new ArrayList<Point>();
        list.add(snake);

        crearComida();
    }

    public void crearComida() {
        comida.x = (int) (((Math.random() * 505) / 100) * 100);
        comida.y = (int) (((Math.random() * 365) / 100) * 100);
        if (comida.x >= 0 && comida.x <= 45) {
            comida.x = comida.x + 40;
        }
        if (comida.y >= 0 && comida.y <= 45) {
            comida.y = comida.y + 40;
        }
        comida = new Point(comida.x, comida.y);

    }

    public class ImagenSnake extends JPanel {

        public void paint(Graphics g) {
            super.paint(g);

            g.setColor(new Color(255, 0, 0));
            g.fillRect(snake.x, snake.y, widthPoint, heighPoint);

        }
    }

    public class Teclas extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_F1) {
                System.exit(0);
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (direccion != KeyEvent.VK_DOWN) {
                    direccion = KeyEvent.VK_UP;
                }

            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (direccion != KeyEvent.VK_UP) {
                    direccion = KeyEvent.VK_DOWN;
                }

            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (direccion != KeyEvent.VK_LEFT) {
                    direccion = KeyEvent.VK_RIGHT;
                }

            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (direccion != KeyEvent.VK_RIGHT) {
                    direccion = KeyEvent.VK_LEFT;
                }
            }
        }
    }

    public class Momento extends Thread {

        long last = 0;

        public void run() {
            while (true) {
                if ((java.lang.System.currentTimeMillis() - last) > frecuencia) {
                    if (!gameOver) {
                        if (direccion == KeyEvent.VK_UP) {
                            snake.y = snake.y - heighPoint;
                            if (snake.y > height) {
                                snake.y = 0;
                            }

                            if (snake.y < 0) {
                                snake.y = height - heighPoint;
                            }
                        } else if (direccion == KeyEvent.VK_DOWN) {
                            snake.y = snake.y + heighPoint;
                            if (snake.y > height) {
                                snake.y = 0;
                            }

                            if (snake.y < 0) {
                                snake.y = height - heighPoint;
                            }
                        } else if (direccion == KeyEvent.VK_RIGHT) {
                            snake.x = snake.x + widthPoint;
                            if (snake.x > width) {
                                snake.x = 0;
                            }

                            if (snake.x < 0) {
                                snake.x = width - widthPoint;
                            }
                        } else if (direccion == KeyEvent.VK_LEFT) {
                            snake.x = snake.x - widthPoint;
                            if (snake.x > width) {
                                snake.x = 0;
                            }

                            if (snake.x < 0) {
                                snake.x = width - widthPoint;
                            }
                        }

                        actualizar();
                        last = java.lang.System.currentTimeMillis();
                    }
                }
            }
        }

    }

    public static void main(String args[]) {
        SnakeJuego juego = new SnakeJuego();
        int width = juego.width;
        int height = juego.height;
        juego.setBounds(0, 0, width, height);
        juego.setVisible(true);
        juego.setResizable(false);
        juego.setLocationRelativeTo(null);
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(new Color(255, 0, 0));
        g.fillRect(snake.x, snake.y, widthPoint, heighPoint);
        for (int i = 0; i < list.size(); i++) {
            Point point = (Point) list.get(i);
            g.fillRect(point.x, point.y, widthPoint, heighPoint);
        }

        g.setColor(new Color(0, 255, 0));
        g.fillRect(comida.x, comida.y, widthPoint, heighPoint);

        if (gameOver) {
            g.drawString("GAME OVER", (width / 2) - 40, (height / 2));
        }

    }
    
    public void menu(){
        if(gameOver){
            menu = new SnakeMenu();
            menu.setBounds(0,0,400,400);
            menu.setLocationRelativeTo(null);
            menu.setVisible(true);
            menu.setResizable(true);
            this.dispose();
        }
    }

}
