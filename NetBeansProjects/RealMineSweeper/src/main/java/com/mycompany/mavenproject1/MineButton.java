/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author alu13114532
 */
public class MineButton extends JButton {

    private int row;
    private int col;

    private static Icon iconButtom = null;
    private static Icon iconButtomPress = null;
    private static MouseAdapter mouseAdapter = null;
    public static final int BUTTOM_SIZE = 30;

    public MineButton(int row, int col) {
        super();
        this.row = row;
        this.col = col;
        setMargin(new Insets(0, 0, 0, 0));
        setContentAreaFilled(false);
        setBorderPainted(false);
        if(mouseAdapter == null) {
            mouseAdapter = new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    MineButton b = (MineButton) e.getComponent();
                    b.setIcon(iconButtomPress);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    MineButton b = (MineButton) e.getComponent();
                    b.setIcon(iconButtom);
                }
                
            };
        }
        setIconMine();
        addMouseListener(mouseAdapter);
        
    }
    
    public int getRow() {
        return row;
    }
    
    public int getCol() {
        return col;
    }

    private void setIconMine() {
        if (iconButtom == null) {
            Image image = new ImageIcon(getClass().getResource("/images/boton.jpg")).getImage();
            Image newimg = image.getScaledInstance(BUTTOM_SIZE, BUTTOM_SIZE, java.awt.Image.SCALE_SMOOTH);
            iconButtom = new ImageIcon(newimg);
        }
        if(iconButtomPress == null) {
            Image image = new ImageIcon(getClass().getResource("/images/boton_pressed.jpg")).getImage();
            Image newimg = image.getScaledInstance(BUTTOM_SIZE, BUTTOM_SIZE, java.awt.Image.SCALE_SMOOTH);
            iconButtomPress = new ImageIcon(newimg);
        }
        setIcon(iconButtom);
    }
}
