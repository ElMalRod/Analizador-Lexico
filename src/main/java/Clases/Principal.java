/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.text.*;

public class Principal extends JApplet {

    JTextField txtbuscar;
    JScrollPane scroll;
    JLabel estado;
    JTextArea texto;

    Color colorfondodefault;
    Highlighter hilit;
    Highlighter.HighlightPainter painter;
    JPanel panelPrincipal;

    public void init() {

        txtbuscar = new JTextField();
        texto = new JTextArea();
        estado = new JLabel();
        estado.setText("Digite la palabra a buscar.");

        texto.setColumns(20);
        texto.setLineWrap(true);
        texto.setRows(5);
        texto.setWrapStyleWord(true);
        texto.setEditable(false);

        scroll = new JScrollPane(texto);

        hilit = new DefaultHighlighter();
        painter = new DefaultHighlighter.DefaultHighlightPainter(Color.CYAN);
        texto.setHighlighter(hilit);

        colorfondodefault = txtbuscar.getBackground();

        txtbuscar.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    hilit.removeAllHighlights();
                    txtbuscar.setText("");
                    txtbuscar.setBackground(colorfondodefault);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                buscarTexto();
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
            }
        });

        panelPrincipal = (JPanel) getContentPane();
        panelPrincipal.add(txtbuscar, BorderLayout.NORTH);
        panelPrincipal.add(scroll);
        panelPrincipal.add(estado, BorderLayout.SOUTH);

    }

    public void buscarTexto() {

        hilit.removeAllHighlights();
        String s = txtbuscar.getText();

        if (s.length() > 0) {
            String contenido = texto.getText();
            int index = contenido.indexOf(s, 0);
            if (index >= 0) {
                try {
                    int end = index + s.length();
                    hilit.addHighlight(index, end, painter);
                    texto.setCaretPosition(end);
                    txtbuscar.setBackground(colorfondodefault);
                    estado.setText("'" + s + "' fue encontrado. Presione ESC para finalizar la busqueda.");
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
            } else {
                txtbuscar.setBackground(Color.ORANGE);
                estado.setText("'" + s + "' no se ha encontrado. Presione ESC para finalizar la busqueda.");
            }
        } else {
            estado.setText("Digite la palabra a buscar.");
        }
    }
}
