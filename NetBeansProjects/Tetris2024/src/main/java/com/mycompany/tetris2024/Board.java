/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.tetris2024;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author alu13114532
 */
public class Board extends javax.swing.JPanel {

    class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (canMove(currentShape, currentRow, currentCol)) {
                        currentCol--;
                    }
                    repaint();
                    break;
                case KeyEvent.VK_RIGHT:
                    if (canMove(currentShape, currentRow, currentCol)) {
                        currentCol++;
                    }
                    repaint();
                    break;
                case KeyEvent.VK_UP:

                    break;
                case KeyEvent.VK_DOWN:
                    if (canMove(currentShape, currentRow, currentCol)) {
                        currentRow++;
                    }
                    repaint();
                    break;
                default:
                    break;
            }
            repaint();
        }
    }

    public static final int NUM_ROWS = 22;
    public static final int NUM_COL = 10;
    public static final int DELTA_TIME = 500; //it's in milliseconds

    private Shape currentShape;
    private int currentRow = 5;
    private int currentCol;
    private Timer timer;
    private MyKeyAdapter keyAdapter;

    /**
     * Creates new form Board
     */
    public Board() {

        initComponents();
        currentShape = new Shape();
        currentRow = 0;
        currentCol = NUM_COL / 2;
        keyAdapter = new MyKeyAdapter();
        addKeyListener(keyAdapter);
        setFocusable(true);
        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tic();
            }
        });
        timer.start();
    }

    public boolean canMove(Shape shape, int row, int col) {
        if (col + shape.getMinY() < 0) {
            return false;
        }
        if (col + shape.getMaxX() >= NUM_COL) {
            return false;
        }
        return true;
    }

    public void tic() {
        currentRow++;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintCurrentShape(g);
    }

    public void paintCurrentShape(Graphics g) {
        for (int i = 0; i < 4; i++) {
            if (currentShape.getY(i) + currentRow >= 0) {
                drawSquare(g, currentRow + currentShape.getY(i),
                        currentCol + currentShape.getX(i), currentShape.getShape());
            }
        }
    }

    private void drawSquare(Graphics g, int row, int col,
            Tetronimus shape) {
        Color colors[] = {new Color(0, 0, 0),
            new Color(204, 102, 102),
            new Color(102, 204, 102), new Color(102, 102, 204),
            new Color(204, 204, 102), new Color(204, 102, 204),
            new Color(102, 204, 204), new Color(218, 170, 0)
        };
        int x = col * getSquareWidth();
        int y = row * getSquareHeight();
        Color color = colors[shape.ordinal()];
        g.setColor(color);
        g.fillRect(x + 1, y + 1, getSquareWidth() - 2,
                getSquareHeight() - 2);
        g.setColor(color.brighter());
        g.drawLine(x, y + getSquareHeight() - 1, x, y);
        g.drawLine(x, y, x + getSquareWidth() - 1, y);
        g.setColor(color.darker());
        g.drawLine(x + 1, y + getSquareHeight() - 1,
                x + getSquareWidth() - 1, y + getSquareHeight() - 1);
        g.drawLine(x + getSquareWidth() - 1,
                y + getSquareHeight() - 1,
                x + getSquareWidth() - 1, y + 1);
    }

    private int getSquareWidth() {
        return getWidth() / NUM_COL;
    }

    private int getSquareHeight() {
        return getHeight() / NUM_ROWS;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 134, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 304, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
