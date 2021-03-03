package com.company;
import com.company.ventanas.PaginaCreacion;
import com.company.ventanas.PaginaPrincipal;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;
import com.company.main;
import org.xmldb.api.modules.XPathQueryService;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    static Scanner teclado = new Scanner(System.in);
    static String driver = "org.exist.xmldb.DatabaseImpl"; //Driver para eXist
    static String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db/ColeccionPruebas"; //URI colección
    static String usu = "admin"; //Usuario
    static String usuPwd = "admin"; //Clave
    static Collection col = null;


    public static void main(String[] args) throws IOException, XMLDBException {


        JFrame frame = new JFrame("Vias de escalada");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        PaginaPrincipal vp = new PaginaPrincipal();
        frame.setContentPane(vp.getVentanaPrincipal());
        vp.setFrameVentanaPrincipal(frame);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        conectar();
        pruebaXML();



    }
    public static Collection conectar() {

        try {
            Class cl = Class.forName(driver); //Cargar del driver
            Database database = (Database) cl.newInstance(); //Instancia de la BD
            DatabaseManager.registerDatabase(database); //Registro del driver
            col = DatabaseManager.getCollection(URI, usu, usuPwd);

            return col;
        } catch (XMLDBException e) {
            System.out.println("Error al inicializar la BD eXist.");
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Error en el driver.");
            //e.printStackTrace();
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println("Error al instanciar la BD.");
            //e.printStackTrace();
        }
        return null;
    }

    public static void cargar_en_coleccion() throws XMLDBException  {
        //Devuelve true si el dep existe
        if (conectar() != null) {
            try {
                // Inicializamos el recurso
                XMLResource res = null;
                // Creamos el recurso -> recibe 2 parámetros tipo String:
                // s: nombre.xml (si lo dejamos null, pondrá un nombre aleatorio)
                // s1: tipo recurso (en este caso, siempre será XMLResource)
                res = (XMLResource)col.createResource("presas.xml", "XMLResource");

                // Elegimos el fichero .xml que queremos añadir a la colección
                File f = new File("Archivos/presas.xml");

                // Fijamos como contenido ese archivo .xml elegido
                res.setContent(f);
                col.storeResource(res); // lo añadimos a la colección

                // Listamos la colección para ver que en efecto se ha añadido
                for (String colRe: col.listResources())
                    System.out.println(colRe);

                col.close();
            } catch (Exception e) {
                System.out.println("Error al consultar.");
                // e.printStackTrace();
            }
        } else {
            System.out.println("Error en la conexión. Comprueba datos.");
        }
    }// FIN cargar_en_coleccion()

    public static void pruebaXML(){
        if (conectar() != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                ResourceSet result = servicio.query("for $cod in /Presas/Presa/Codigo/text() return $cod");
                // recorrer los datos del recurso.
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    cargar_en_coleccion();

                }

                col.close();
            } catch (XMLDBException e) {
                System.out.println(" ERROR AL CONSULTAR DOCUMENTO.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Error en la conexión. Comprueba datos.");
        }
    }
}
