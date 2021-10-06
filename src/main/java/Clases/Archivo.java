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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author emili
 */
public class Archivo {
    //Atributo de la direccion actual del archivo

    private String direccionActual = "";
    //Atributo para saber si se ha cambiado el texto
    private Boolean textoCambiado = false;
    FileInputStream Entrada;
    JFileChooser Seleccionar = new JFileChooser();
    File Archivo = new File("Archivo.txt");
    FileOutputStream Salida;

    public Archivo() {
        textoCambiado = false;
        direccionActual = "";

    }

    public String getDireccionActual() {
        return direccionActual;
    }

    public void setDireccionActual(String direccionActual) {
        this.direccionActual = direccionActual;
    }

    public void guardarArchivoComo() {
        try {
            if (Archivo.exists()) {
                JOptionPane.showMessageDialog(null, "Base de datos ya creada");
            } else {
                Archivo.createNewFile();
                JOptionPane.showMessageDialog(null, "Base de datos creada");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + JOptionPane.ERROR_MESSAGE);
        }
    }

    public void guardarArchivo() {
        try {
            FileReader LectorArchivo = new FileReader("Archivo.txt");
            BufferedReader Lector = new BufferedReader(LectorArchivo);
            String Cadena;
            while ((Cadena = Lector.readLine()) != null) {
                System.out.println(" " + Cadena);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + JOptionPane.ERROR_MESSAGE);
        }
    }

    public String abrirArchivo(File Archivo) {
        String Documento = "";
        try {
            Entrada = new FileInputStream(Archivo);
            int ascci;
            while ((ascci = Entrada.read()) != -1) {
                char Caracter = (char) ascci;
                Documento += Caracter;
            }
        } catch (Exception ex) {

        }
        return Documento;
    }

    public String ModificarArchivo(File Archivo, String Documento) {
        String Texto = null;
        try {
            Salida = new FileOutputStream(Archivo);
            byte[] bytxt = Documento.getBytes();
            Salida.write(bytxt);
            Texto = "Archivo Modificado";
        } catch (Exception ex) {

        }
        return Texto;
    }

    /*Metodo para exportar errores*/
    public void guardarErrorComo(File Archivo, String texto, String nombreProyecto) {
        try {
            Entrada = new FileInputStream(Archivo);

            JOptionPane.showMessageDialog(null, "archivo Guardado Exitosamente");
            setTextoCambiado(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }

    }

    public FileInputStream getEntrada() {
        return Entrada;
    }

    public void setEntrada(FileInputStream Entrada) {
        this.Entrada = Entrada;
    }

    public JFileChooser getSeleccionar() {
        return Seleccionar;
    }

    public void setSeleccionar(JFileChooser Seleccionar) {
        this.Seleccionar = Seleccionar;
    }

    public void setTextoCambiado(Boolean textoCambiado) {
        this.textoCambiado = textoCambiado;
    }

    public Boolean getTextoCambiado() {
        return textoCambiado;
    }

    public File getArchivo() {
        return Archivo;
    }

    public void setArchivo(File Archivo) {
        this.Archivo = Archivo;
    }

    public FileOutputStream getSalida() {
        return Salida;
    }

    public void setSalida(FileOutputStream Salida)  {
        this.Salida = Salida;
    }

}
