package com.company.ventanas;

import com.company.Presa;
import com.company.Presas;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XPathQueryService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class MisVias {
    private JList ViasList;
    private JButton todasButton;
    private JButton misViasButton;
    private JList PresasList;
    private JTextField FormatextField;
    private JTextField DificultadtextField;
    private JTextField TamañotextField;
    private JTextField ColortextField;
    private JButton editarButton;
    private JButton eliminarButton;
    private JPanel misVias;
    private JLabel Fotolbl;
    private JFrame frameVias;
    private String seleccion;
    private int Pseleccion;
    private Presa presaCon;
    private ArrayList listaNombres = new ArrayList();
    private ArrayList listaNombresLocales = new ArrayList();

    private ArrayList<Presas> arrayPresas = new ArrayList<>();
    private int mias = 0;
    private String borrar;


    static String driver = "org.exist.xmldb.DatabaseImpl"; //Driver para eXist
    static String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db/ColeccionPruebas"; //URI colección
    static String usu = "admin"; //Usuario
    static String usuPwd = "admin"; //Clave
    static Collection col = null;

    public MisVias() {
        inicio();
        todasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                RecogerNombresVias();
                eliminarButton.setEnabled(false);
                editarButton.setEnabled(false);
                mias = 0;
                listarVias();


            }
        });
        ViasList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                seleccion = ViasList.getSelectedValue().toString();
                RecogerPresasVias(seleccion);
                listarPres();
                if (mias == 1)
                    eliminarButton.setEnabled(true);

            }
        });
        PresasList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                Pseleccion = PresasList.getSelectedIndex();
                int cod = arrayPresas.get(Pseleccion).getCodigo();
                RecogerInfoPresa(cod);
                if (mias == 1)
                    editarButton.setEnabled(true);
            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    editarPresa(arrayPresas.get(Pseleccion).getCodigo());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PresasList.removeAll();
                borrar = ViasList.getSelectedValue().toString();
                eliminarVia(borrar);
                System.out.println("pasa");
                RecogerNombresVias();
                try {
                    recogerViasLocales();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                listarVias();
            }
        });
        misViasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mias = 1;
                try {
                    recogerViasLocales();
                    listarVias();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

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

    public void RecogerNombresVias() {
        listaNombres.clear();
        if (conectar() != null) {
            try {
                boolean exist = false;
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                ResourceSet result = servicio.query("for $tam in distinct-values( /Vias/Via/Nombre/text()) return $tam");
                // recorrer los datos del recurso.
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    System.out.println(" LA CONSULTA NO DEVUELVE NADA O ESTÁ MAL ESCRITA");
                    PaginaCreacion.cargar_vias_coleccion();
                }
                i = result.getIterator();
                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    System.out.println("--------------------------------------------");
                    System.out.println((String) r.getContent());
                    listaNombres.add(r.getContent());
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

    public void listarVias() {

        DefaultListModel<String> defaultListModel = new DefaultListModel<>();
        if (mias == 1) {
            for (Object nombre : listaNombresLocales) {
                defaultListModel.addElement(nombre.toString());
            }
        }
        else{
            for (Object nombre : listaNombres) {
                defaultListModel.addElement(nombre.toString());
            }
        }



        ViasList.setModel(defaultListModel);
    }

    public void listarPres() {
        DefaultListModel<String> defaultListModel = new DefaultListModel<>();
        for (Object presa : arrayPresas) {
            Presas pres = (Presas) presa;
            String texto = pres.toString();
            defaultListModel.addElement(texto);
        }

        PresasList.setModel(defaultListModel);

    }

    //Convierte las presas de la vía en objetos presas
    public Presas ObjetoPresas(String xml) {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("Presa", Presas.class);
        Presas c = (Presas) xstream.fromXML(xml);
        arrayPresas.add(c);
        return c;
    }

    //Convierte la presa seleccionada en objeto Presa
    public Presa ObjetoPresa(String xml) {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("Presa", Presa.class);
        Presa c = (Presa) xstream.fromXML(xml);
        System.out.println("pasa");
        FormatextField.setText(c.getForma());
        DificultadtextField.setText(c.getNivel());
        TamañotextField.setText(c.getTamaño());
        ColortextField.setText(c.getColor());
        Fotolbl.setIcon(new ImageIcon("Assets/Presas64x64/" + c.getCodigo() + ".png"));
        return c;
    }

    //Recojo las presas de las vias y mando el String a ObjetoPresas
    public void RecogerPresasVias(String nombre) {
        if (conectar() != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                ResourceSet result = servicio.query("for $v in /Vias/Via where $v/Nombre='" + nombre + "' return $v/Presas/Presa");
                // recorrer los datos del recurso.
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    System.out.println(" LA CONSULTA NO DEVUELVE NADA O ESTÁ MAL ESCRITA");
                }
                arrayPresas.clear();
                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    System.out.println("--------------------------------------------");
                    System.out.println((String) r.getContent());
                    ObjetoPresas(((String) r.getContent()));

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

    //Recojo la info de la presa seleccionada
    public void RecogerInfoPresa(int cod) {
        if (conectar() != null) {
            if (cod < 10) {
                try {
                    XPathQueryService servicio;
                    servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                    //Preparamos la consulta

                    ResourceSet result = servicio.query("for $v in /Presas/Presa where $v/Codigo='00" + cod + "'  return $v");
                    ResourceIterator i;
                    i = result.getIterator();

                    if (!i.hasMoreResources()) {
                        System.out.println(" LA CONSULTA NO DEVUELVE NADA O ESTÁ MAL ESCRITA");
                    }
                    while (i.hasMoreResources()) {
                        Resource r = i.nextResource();
                        System.out.println("--------------------------------------------");
                        System.out.println((String) r.getContent());
                        presaCon = ObjetoPresa((String) r.getContent());
                    }
                    col.close();
                } catch (XMLDBException e) {
                    System.out.println(" ERROR AL CONSULTAR DOCUMENTO.");
                    e.printStackTrace();
                }
            } else {
                try {
                    XPathQueryService servicio;
                    servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                    //Preparamos la consulta

                    ResourceSet result = servicio.query("for $v in /Presas/Presa where $v/Codigo='0" + cod + "'  return $v");
                    ResourceIterator i;
                    i = result.getIterator();

                    if (!i.hasMoreResources()) {
                        System.out.println(" LA CONSULTA NO DEVUELVE NADA O ESTÁ MAL ESCRITA");
                    }
                    while (i.hasMoreResources()) {
                        Resource r = i.nextResource();
                        System.out.println("--------------------------------------------");
                        System.out.println((String) r.getContent());
                        presaCon = ObjetoPresa((String) r.getContent());
                    }
                    col.close();
                } catch (XMLDBException e) {
                    System.out.println(" ERROR AL CONSULTAR DOCUMENTO.");
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Error en la conexión. Comprueba datos.");
        }
    }

    //Editar presa
    public void editarPresa(int cod) throws IOException {


        if (conectar() != null) {
            String scod = "";
            if (cod < 10)
                scod = "00" + cod;
            else if (cod >= 10)
                scod = "0" + cod;
            //Se edita la forma
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Consulta para modificar/actualizar un valor --> update value
                ResourceSet result = servicio.query("update value /Presas/Presa[Codigo=" + scod + "]/Forma with data('" + FormatextField.getText() + "') ");
                col.close();
                System.out.println("Forma de presa actualizado");
            } catch (Exception e) {
                System.out.println("Error al actualizar.");
                e.printStackTrace();
            }
            //Se edita el tamaño
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Consulta para modificar/actualizar un valor --> update value
                ResourceSet result = servicio.query("update value /Presas/Presa[Codigo=" + scod + "]/Tamaño with data('" + TamañotextField.getText() + "') ");
                col.close();
                System.out.println("Tamaño de presa actualizado");
            } catch (Exception e) {
                System.out.println("Error al actualizar.");
                e.printStackTrace();
            }
            //Se edita Nivel
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Consulta para modificar/actualizar un valor --> update value
                ResourceSet result = servicio.query("update value /Presas/Presa[Codigo=" + scod + "]/Nivel with data('" + DificultadtextField.getText() + "') ");
                col.close();
                System.out.println("Dificultad de presa actualizado");
            } catch (Exception e) {
                System.out.println("Error al actualizar.");
                e.printStackTrace();
            }
            //Se actualiza color
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Consulta para modificar/actualizar un valor --> update value
                ResourceSet result = servicio.query("update value /Presas/Presa[Codigo=" + scod + "]/Color with data('" + ColortextField.getText() + "') ");
                col.close();
                System.out.println("Forma de presa actualizado");
            } catch (Exception e) {
                System.out.println("Error al actualizar.");
                e.printStackTrace();
            }
            añadirRegistro("Editada presa: " + scod);

        } else {
            System.out.println("Error en la conexión. Comprueba datos.");
        }
    }

    //Añadimos registros
    public void añadirRegistro(String registro) throws IOException {
        File fichero = new File("Archivos/Registros.txt");

        FileReader fr = new FileReader(fichero);
        int z = fr.read();
        String reg = "";
        while (z != -1) {
            System.out.println((char) z + "ojo");
            reg = reg + (char) z;
            z = fr.read();
        }
        System.out.println(registro);
        FileWriter fw = new FileWriter(fichero);
        fw.write(reg + registro + "\n");
        fr.close();
        fw.close();


    }

    //Eliminar Via
    public void eliminarVia(String nombre) {
        String nombre1 = nombre.trim();
        if (conectar() != null) {
            try {
                System.out.printf("Borro la vía: %s\n", nombre);
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                System.out.println("update delete /Vias/Via[Nombre=" + nombre1 + "]");

                ResourceSet result = servicio.query(
                        "update delete /Vias/Via[Nombre='" + nombre1 + "']");
                col.close();
                añadirRegistro("Eliminada vía: " + nombre1);
                System.out.println("vía " + nombre + " eliminada.");
            } catch (Exception e) {
                System.out.println("Error al borrar.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Error en la conexión. Comprueba datos.");
        }
    }

    public void recogerViasLocales() throws IOException {
        File fichero = new File("Archivos/ViasLocales.dat");
        FileInputStream filein = new FileInputStream(fichero);
        String array = "";
        listaNombresLocales.clear();
        int e;
        while ((e = filein.read()) != -1) { //lee datos del flujo de entrada
            if ((char) e != ' ')
                array = array + (char) e;
            else {
                for (Object nombre : listaNombres) {
                    if(nombre.equals(array))
                        listaNombresLocales.add(array.trim());
                }

                array="";

            }

        }
    }


    //Bloqueo inicial de botones
    public void inicio() {
        editarButton.setEnabled(false);
        eliminarButton.setEnabled(false);
    }


    //Funciones del panel
    public JPanel getPanel() {
        return misVias;
    }

    public void setFrameVias(JFrame frame) {
        this.frameVias = frame;

    }

    public void setFrameVentanaPrincipal(JFrame frameVentanaPrincipal) {
        this.frameVias = frameVentanaPrincipal;
    }
}



