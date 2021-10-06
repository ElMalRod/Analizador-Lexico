/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author emili
 */
public class Lexema {
     //Atributo de texto de token
        private String lexema;
        //Color del token
        private String color;
        //Tipo de token
        private String tipo;

        /*Metodo constructor*/
        public Lexema(String lexema, String color, String tipo){
            this.lexema = lexema;
            this.color = color;
            this.tipo = tipo;
        }

        /*Regresa el lexema*/
       public String getLexema()
        {
            return lexema;
        }

        /*Regresa el color*/
        public String getColor()
        {
            return color;
        }

        /*Regresa el tipo*/
        public String getTipo()
        {
            return tipo;
        }
    }
