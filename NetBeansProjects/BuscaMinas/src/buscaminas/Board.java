/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package buscaminas;

/**
 *
 * @author alu13114532
 */
public class Board extends javax.swing.JPanel {

    public static final int NUM_ROWS = 22;
    public static final int NUM_COLS = 10;
    private int currentRow;
    private int currentCol;
    private AccessibleJPanel[][] matrix;
    public Board() {
        initComponents();
    }
    
        private void initMatrix() {
        matrix = new AccessibleJPanel[NUM_ROWS][NUM_COLS];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = Tetrominoes.NoShape;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.GridLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
