package com.company.ventanas;

import com.company.Presas;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XPathQueryService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class PaginaCreacion {
    private JPanel VentanaCreacion;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton button13;
    private JButton button14;
    private JButton button15;
    private JButton button16;
    private JButton button17;
    private JButton button18;
    private JButton button19;
    private JButton button20;
    private JButton button21;
    private JButton button22;
    private JButton button23;
    private JButton button24;
    private JButton button25;
    private JButton button26;
    private JButton button27;
    private JButton button28;
    private JButton button29;
    private JButton button30;
    private JButton button31;
    private JButton button32;
    private JButton button33;
    private JButton button34;
    private JButton button35;
    private JButton button36;
    private JButton button37;
    private JButton button38;
    private JButton button39;
    private JButton button40;
    private JButton button41;
    private JButton button42;
    private JButton button43;
    private JButton button44;
    private JButton button45;
    private JButton button46;
    private JButton button47;
    private JButton button48;
    private JButton button49;
    private JButton button50;
    private JComboBox comboTamaño;
    private JComboBox comboAgarre;
    private JComboBox comboDificultad;
    private JComboBox comboColor;
    private JComboBox comboCodigo;
    private JTextField textNombre;
    private JComboBox comboNivel;
    private JButton añadirButton;
    private JButton eliminarButton;
    private JLabel Foto;
    private JLabel Tamañolbl;
    private JLabel AgarreLbl;
    private JLabel DificultadLbl;
    private JLabel ColorLbl;
    private JLabel PuntuacionLbl;
    private JLabel PuntosViaLbl;
    private JButton Nivelarbutton;
    private JButton Guardarbutton;
    private JFrame frameVentanaCreacion;
    private int posicion;
    private JButton seleccion;
    private int puntosVia;
    private int Npresas;

    private ArrayList listaNivel = new ArrayList();
    private ArrayList<Presas> ListaPresas = new ArrayList<>();
    private ArrayList listaNombres = new ArrayList();

    private ArrayList ListaCodigo = new ArrayList();
    private ArrayList ListaColor = new ArrayList();
    private ArrayList ListaDificultad = new ArrayList();
    private ArrayList ListaForma = new ArrayList();
    private ArrayList ListaPuntuacion = new ArrayList();
    private ArrayList ListaTamaño = new ArrayList();

    private ArrayList ListaColorD = new ArrayList();
    private ArrayList ListaPuntuacionD = new ArrayList();
    private ArrayList ListaFormaD = new ArrayList();
    private ArrayList ListaDificultadD = new ArrayList();


    static String driver = "org.exist.xmldb.DatabaseImpl"; //Driver para eXist
    static String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db/ColeccionPruebas"; //URI colección
    static String usu = "admin"; //Usuario
    static String usuPwd = "admin"; //Clave
    static Collection col = null;


    public PaginaCreacion() {
        ImagenesSuma();
        RecogerCodigo();
        RecogerColor();
        RecogerDificultad();
        RecogerForma();
        RecogerPuntuacion();
        RecogerTamaño();
        RecogerDificultadD();
        RecogerFormaD();
        RecogerColorD();
        RecogerTamañoD();
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 1;
                seleccion = button1;
                activarSelector();

            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 2;
                seleccion = button2;
                activarSelector();

            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 3;
                seleccion = button3;
                activarSelector();

            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 4;
                seleccion = button4;
                activarSelector();

            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 5;
                seleccion = button5;
                activarSelector();

            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 6;
                seleccion = button6;
                activarSelector();

            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 7;
                seleccion = button7;
                activarSelector();

            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 8;
                seleccion = button8;
                activarSelector();

            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 9;
                seleccion = button9;
                activarSelector();

            }
        });
        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 10;
                seleccion = button10;
                activarSelector();

            }
        });
        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 11;
                seleccion = button11;
                activarSelector();

            }
        });
        button12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 12;
                seleccion = button12;
                activarSelector();

            }
        });
        button13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 13;
                seleccion = button13;
                activarSelector();

            }
        });
        button14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 14;
                seleccion = button14;
                activarSelector();

            }
        });
        button15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 15;
                seleccion = button15;
                activarSelector();

            }
        });
        button16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 16;
                seleccion = button16;
                activarSelector();

            }
        });
        button17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 17;
                seleccion = button17;
                activarSelector();

            }
        });
        button18.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 18;
                seleccion = button18;
                activarSelector();

            }
        });
        button19.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 19;
                seleccion = button19;
                activarSelector();

            }
        });
        button20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 20;
                seleccion = button20;
                activarSelector();

            }
        });
        button21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 21;
                seleccion = button21;
                activarSelector();

            }
        });
        button22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 22;
                seleccion = button22;
                activarSelector();

            }
        });
        button23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 23;
                seleccion = button23;
                activarSelector();

            }
        });
        button24.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 24;
                seleccion = button24;
                activarSelector();

            }
        });
        button25.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 25;
                seleccion = button25;
                activarSelector();

            }
        });
        button26.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 26;
                seleccion = button26;
                activarSelector();

            }
        });
        button27.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 27;
                seleccion = button27;
                activarSelector();

            }
        });
        button28.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 28;
                seleccion = button28;
                activarSelector();

            }
        });
        button29.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 29;
                seleccion = button29;
                activarSelector();

            }
        });
        button30.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 30;
                seleccion = button30;
                activarSelector();

            }
        });
        button31.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 31;
                seleccion = button31;
                activarSelector();

            }
        });
        button32.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 32;
                seleccion = button32;
                activarSelector();

            }
        });
        button33.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 33;
                seleccion = button33;
                activarSelector();

            }
        });
        button34.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 34;
                seleccion = button34;
                activarSelector();

            }
        });
        button35.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 35;
                seleccion = button35;
                activarSelector();

            }
        });
        button36.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 36;
                seleccion = button36;
                activarSelector();

            }
        });
        button37.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 37;
                seleccion = button37;
                activarSelector();

            }
        });
        button38.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 38;
                seleccion = button38;
                activarSelector();

            }
        });
        button39.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 39;
                seleccion = button39;
                activarSelector();

            }
        });
        button40.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 40;
                seleccion = button40;
                activarSelector();

            }
        });
        button41.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 41;
                seleccion = button41;
                activarSelector();

            }
        });
        button42.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 42;
                seleccion = button42;
                activarSelector();

            }
        });
        button43.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 43;
                seleccion = button43;
                activarSelector();

            }
        });
        button44.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 44;
                seleccion = button44;
                activarSelector();

            }
        });
        button45.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 45;
                seleccion = button45;
                activarSelector();

            }
        });
        button46.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 46;
                seleccion = button46;
                activarSelector();

            }
        });
        button47.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 47;
                seleccion = button47;
                activarSelector();

            }
        });
        button48.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 48;
                seleccion = button48;
                activarSelector();

            }
        });
        button49.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 49;
                seleccion = button49;
                activarSelector();

            }
        });
        button50.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = 50;
                seleccion = button50;
                activarSelector();

            }
        });
        comboCodigo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Foto.setIcon(new ImageIcon("Assets/Presas64x64/" + comboCodigo.getSelectedItem().toString() + ".png"));
                    int cod = Integer.parseInt(comboCodigo.getSelectedItem().toString()) - 1;
                    Tamañolbl.setText(ListaTamaño.get(cod).toString());
                    AgarreLbl.setText(ListaForma.get(cod).toString());
                    DificultadLbl.setText(ListaDificultad.get(cod).toString());
                    ColorLbl.setText(ListaColor.get(cod).toString());
                    PuntuacionLbl.setText(ListaPuntuacion.get(cod).toString());

                } catch (Exception e1) {

                }
            }
        });
        comboTamaño.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CodigoPorTamaño(Objects.requireNonNull(comboTamaño.getSelectedItem()).toString());
            }
        });
        comboColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CodigoPorColor(Objects.requireNonNull(comboColor.getSelectedItem()).toString());
            }
        });
        comboDificultad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CodigoPorDificultad(Objects.requireNonNull(comboDificultad.getSelectedItem()).toString());
            }
        });
        comboAgarre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CodigoPorForma(Objects.requireNonNull(comboAgarre.getSelectedItem()).toString());
            }
        });
        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccion.setIcon(new ImageIcon("Assets/Presas32x32/" + comboCodigo.getSelectedItem().toString() + ".png"));
                int cod = Integer.parseInt(comboCodigo.getSelectedItem().toString()) - 1;
                Presas presa = new Presas(cod + 1, posicion);
                ListaPresas.add(presa);
                puntosVia = puntosVia + Integer.parseInt(ListaPuntuacion.get(cod).toString());
                Npresas++;
                PuntosViaLbl.setText("" + puntosVia);
                añadirButton.setEnabled(false);
                if (Npresas >= 5) {
                    Nivelarbutton.setEnabled(true);
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccion.setIcon(new ImageIcon("Assets/anadir.png"));
                int cod = Integer.parseInt(comboCodigo.getSelectedItem().toString()) - 1;
                Presas eliminar = null;
                for (Presas presa : ListaPresas) {
                    if (presa.getCodigo() == cod) {
                        eliminar = presa;

                    }

                }
                añadirButton.setEnabled(true);
                ListaPresas.remove(eliminar);
                puntosVia = puntosVia - Integer.parseInt(ListaPuntuacion.get(cod).toString());
                Npresas--;
                PuntosViaLbl.setText("" + puntosVia);
                if (Npresas < 5) {
                    Nivelarbutton.setEnabled(false);
                }
            }
        });
        Nivelarbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double media = puntosVia / Npresas;
                System.out.println(media);
                crearListaNivel();
                Guardarbutton.setEnabled(true);
                comboNivel.removeAllItems();
                if (media < 4.0) {
                    comboNivel.addItem(listaNivel.get(0).toString());
                    comboNivel.addItem(listaNivel.get(1).toString());
                } else if (media >= 4.0 && media <= 5.0) {
                    comboNivel.addItem(listaNivel.get(2).toString());
                    comboNivel.addItem(listaNivel.get(3).toString());
                } else if (media > 5.0 && media < 7.0) {
                    comboNivel.addItem(listaNivel.get(4).toString());
                    comboNivel.addItem(listaNivel.get(5).toString());
                    comboNivel.addItem(listaNivel.get(6).toString());
                    comboNivel.addItem(listaNivel.get(7).toString());

                } else if (media >= 7.0) {
                    comboNivel.addItem(listaNivel.get(8).toString());
                    comboNivel.addItem(listaNivel.get(9).toString());
                    comboNivel.addItem(listaNivel.get(10).toString());
                    comboNivel.addItem(listaNivel.get(11).toString());
                    comboNivel.addItem(listaNivel.get(12).toString());
                    comboNivel.addItem(listaNivel.get(13).toString());


                }

            }
        });
        Guardarbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    RecogerNombresVias();
                } catch (Exception e1) {
                    String tituloJOptionPane = "Error ";
                    int tipoJOptionPane = 0;
                    String mensajeJOptionPane = "La lista no estaba metida, vuelve a intentarlo";
                    mostrarJOPtionPane(tituloJOptionPane, mensajeJOptionPane, tipoJOptionPane);

                }
                for (Object nombre : listaNombres) {
                    System.out.println(nombre);
                }
                if (!textNombre.getText().equals("")) {
                    if (!NombreRepetido(textNombre.getText())) {
                        nuevaVia(textNombre.getText(), comboNivel.getSelectedItem().toString(), ListaPresas);
                    }else{
                        String tituloJOptionPane = "Error";
                        int tipoJOptionPane = 0;
                        String mensajeJOptionPane = "El nombre de la via ya existe";
                        mostrarJOPtionPane(tituloJOptionPane, mensajeJOptionPane, tipoJOptionPane);
                    }

                    try {
                        añadirViaArchivoLocal(textNombre.getText());
                        añadirRegistro("Guardada Via: "+textNombre.getText());

                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                } else {
                    String tituloJOptionPane = "Error";
                    int tipoJOptionPane = 0;
                    String mensajeJOptionPane = "El nombre de la via no puede estar vacio";
                    mostrarJOPtionPane(tituloJOptionPane, mensajeJOptionPane, tipoJOptionPane);
                }

            }

        });

    }

    public void mostrarJOPtionPane(String titulo, String mensaje, int tipo) {
        JButton okButton = new JButton("Entendido");
        okButton.setFocusPainted(false);
        Object[] options = {okButton};
        final JOptionPane pane = new JOptionPane(mensaje, tipo, JOptionPane.YES_NO_OPTION, null, options);
        JDialog dialog = pane.createDialog(titulo);
        okButton.addActionListener(e -> dialog.dispose());
        dialog.setVisible(true);
    }

    public void ImagenesSuma() {
        Inicial();


    }

    public void Inicial() {
        comboAgarre.setEnabled(false);
        comboCodigo.setEnabled(false);
        comboColor.setEnabled(false);
        comboDificultad.setEnabled(false);
        comboNivel.setEnabled(false);
        comboTamaño.setEnabled(false);
        añadirButton.setEnabled(false);
        eliminarButton.setEnabled(false);
        Nivelarbutton.setEnabled(false);
        IconoIniciales();
    }

    public void IconoIniciales() {
        button1.setIcon(new ImageIcon("Assets/anadir.png"));
        button2.setIcon(new ImageIcon("Assets/anadir.png"));
        button3.setIcon(new ImageIcon("Assets/anadir.png"));
        button4.setIcon(new ImageIcon("Assets/anadir.png"));
        button5.setIcon(new ImageIcon("Assets/anadir.png"));
        button6.setIcon(new ImageIcon("Assets/anadir.png"));
        button7.setIcon(new ImageIcon("Assets/anadir.png"));
        button8.setIcon(new ImageIcon("Assets/anadir.png"));
        button9.setIcon(new ImageIcon("Assets/anadir.png"));
        button10.setIcon(new ImageIcon("Assets/anadir.png"));
        button11.setIcon(new ImageIcon("Assets/anadir.png"));
        button12.setIcon(new ImageIcon("Assets/anadir.png"));
        button13.setIcon(new ImageIcon("Assets/anadir.png"));
        button14.setIcon(new ImageIcon("Assets/anadir.png"));
        button15.setIcon(new ImageIcon("Assets/anadir.png"));
        button16.setIcon(new ImageIcon("Assets/anadir.png"));
        button17.setIcon(new ImageIcon("Assets/anadir.png"));
        button18.setIcon(new ImageIcon("Assets/anadir.png"));
        button19.setIcon(new ImageIcon("Assets/anadir.png"));
        button20.setIcon(new ImageIcon("Assets/anadir.png"));
        button21.setIcon(new ImageIcon("Assets/anadir.png"));
        button22.setIcon(new ImageIcon("Assets/anadir.png"));
        button23.setIcon(new ImageIcon("Assets/anadir.png"));
        button24.setIcon(new ImageIcon("Assets/anadir.png"));
        button25.setIcon(new ImageIcon("Assets/anadir.png"));
        button26.setIcon(new ImageIcon("Assets/anadir.png"));
        button27.setIcon(new ImageIcon("Assets/anadir.png"));
        button28.setIcon(new ImageIcon("Assets/anadir.png"));
        button29.setIcon(new ImageIcon("Assets/anadir.png"));
        button30.setIcon(new ImageIcon("Assets/anadir.png"));
        button31.setIcon(new ImageIcon("Assets/anadir.png"));
        button32.setIcon(new ImageIcon("Assets/anadir.png"));
        button33.setIcon(new ImageIcon("Assets/anadir.png"));
        button34.setIcon(new ImageIcon("Assets/anadir.png"));
        button35.setIcon(new ImageIcon("Assets/anadir.png"));
        button36.setIcon(new ImageIcon("Assets/anadir.png"));
        button37.setIcon(new ImageIcon("Assets/anadir.png"));
        button38.setIcon(new ImageIcon("Assets/anadir.png"));
        button39.setIcon(new ImageIcon("Assets/anadir.png"));
        button40.setIcon(new ImageIcon("Assets/anadir.png"));
        button41.setIcon(new ImageIcon("Assets/anadir.png"));
        button42.setIcon(new ImageIcon("Assets/anadir.png"));
        button43.setIcon(new ImageIcon("Assets/anadir.png"));
        button44.setIcon(new ImageIcon("Assets/anadir.png"));
        button45.setIcon(new ImageIcon("Assets/anadir.png"));
        button46.setIcon(new ImageIcon("Assets/anadir.png"));
        button47.setIcon(new ImageIcon("Assets/anadir.png"));
        button48.setIcon(new ImageIcon("Assets/anadir.png"));
        button49.setIcon(new ImageIcon("Assets/anadir.png"));
        button50.setIcon(new ImageIcon("Assets/anadir.png"));
        añadirButton.setIcon(new ImageIcon("Assets/Botones/seleccionar.png"));
        eliminarButton.setIcon(new ImageIcon("Assets/Botones/eliminar.png"));
        Nivelarbutton.setIcon(new ImageIcon("Assets/Botones/nivelar.png"));
        Guardarbutton.setIcon(new ImageIcon("Assets/Botones/guardar.png"));
    }

    public void setFrameVentanaPrincipal(JFrame frameVentanaPrincipal) {
        this.frameVentanaCreacion = frameVentanaPrincipal;
    }

    public void activarSelector() {
        comboAgarre.setEnabled(true);
        comboCodigo.setEnabled(true);
        comboColor.setEnabled(true);
        comboDificultad.setEnabled(true);
        comboNivel.setEnabled(true);
        comboTamaño.setEnabled(true);
        if (seleccion.getIcon().toString().equals("Assets/anadir.png")) {
            añadirButton.setEnabled(true);
        } else {
            añadirButton.setEnabled(false);
        }
        eliminarButton.setEnabled(true);

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

    public void RecogerCodigo() {
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
                    System.out.println(" LA CONSULTA NO DEVUELVE NADA O ESTÁ MAL ESCRITA");
                }
                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    System.out.println("--------------------------------------------");
                    System.out.println((String) r.getContent());
                    comboCodigo.addItem(r.getContent());
                    ListaCodigo.add(r.getContent());
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

    public void RecogerColor() {
        if (conectar() != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                ResourceSet result = servicio.query("for $col in /Presas/Presa/Color/text() return $col");
                // recorrer los datos del recurso.
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    System.out.println(" LA CONSULTA NO DEVUELVE NADA O ESTÁ MAL ESCRITA");
                }
                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    System.out.println("--------------------------------------------");
                    System.out.println((String) r.getContent());
                    ListaColor.add(r.getContent());
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

    public void RecogerForma() {
        if (conectar() != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                ResourceSet result = servicio.query("for $forma in /Presas/Presa/Forma/text() return $forma");
                // recorrer los datos del recurso.
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    System.out.println(" LA CONSULTA NO DEVUELVE NADA O ESTÁ MAL ESCRITA");
                }
                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    System.out.println("--------------------------------------------");
                    System.out.println((String) r.getContent());
                    ListaForma.add(r.getContent());
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

    public void RecogerDificultad() {
        if (conectar() != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                ResourceSet result = servicio.query("for $nivel in /Presas/Presa/Nivel/text() return $nivel");
                // recorrer los datos del recurso.
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    System.out.println(" LA CONSULTA NO DEVUELVE NADA O ESTÁ MAL ESCRITA");
                }
                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    System.out.println("--------------------------------------------");
                    System.out.println((String) r.getContent());
                    ListaDificultad.add(r.getContent());
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

    public void RecogerTamaño() {
        if (conectar() != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                ResourceSet result = servicio.query("for $tam in /Presas/Presa/Tamaño/text() return $tam");
                // recorrer los datos del recurso.
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    System.out.println(" LA CONSULTA NO DEVUELVE NADA O ESTÁ MAL ESCRITA");
                }
                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    System.out.println("--------------------------------------------");
                    System.out.println((String) r.getContent());
                    ListaTamaño.add(r.getContent());
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

    public void RecogerPuntuacion() {
        if (conectar() != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                ResourceSet result = servicio.query("for $punt in /Presas/Presa/Puntuacion/text() return $punt");
                // recorrer los datos del recurso.
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    System.out.println(" LA CONSULTA NO DEVUELVE NADA O ESTÁ MAL ESCRITA");
                }
                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    System.out.println("--------------------------------------------");
                    System.out.println((String) r.getContent());
                    ListaPuntuacion.add(r.getContent());
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

    public void RecogerDificultadD() {
        if (conectar() != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                ResourceSet result = servicio.query("for $nivel in distinct-values( /Presas/Presa/Nivel/text()) return $nivel");
                // recorrer los datos del recurso.
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    System.out.println(" LA CONSULTA NO DEVUELVE NADA O ESTÁ MAL ESCRITA");
                }
                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    System.out.println("--------------------------------------------");
                    System.out.println((String) r.getContent());
                    comboDificultad.addItem(r.getContent());
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

    public void RecogerColorD() {
        if (conectar() != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                ResourceSet result = servicio.query("for $col in distinct-values( /Presas/Presa/Color/text()) return $col");
                // recorrer los datos del recurso.
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    System.out.println(" LA CONSULTA NO DEVUELVE NADA O ESTÁ MAL ESCRITA");
                }
                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    System.out.println("--------------------------------------------");
                    System.out.println((String) r.getContent());
                    comboColor.addItem(r.getContent());
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

    public void RecogerFormaD() {
        if (conectar() != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                ResourceSet result = servicio.query("for $forma in distinct-values( /Presas/Presa/Forma/text()) return $forma");
                // recorrer los datos del recurso.
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    System.out.println(" LA CONSULTA NO DEVUELVE NADA O ESTÁ MAL ESCRITA");
                }
                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    System.out.println("--------------------------------------------");
                    System.out.println((String) r.getContent());
                    comboAgarre.addItem(r.getContent());
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

    public void RecogerTamañoD() {
        if (conectar() != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                ResourceSet result = servicio.query("for $tam in distinct-values( /Presas/Presa/Tamaño/text()) return $tam");
                // recorrer los datos del recurso.
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    System.out.println(" LA CONSULTA NO DEVUELVE NADA O ESTÁ MAL ESCRITA");
                }
                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    System.out.println("--------------------------------------------");
                    System.out.println((String) r.getContent());
                    comboTamaño.addItem(r.getContent());
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

    public void CodigoPorColor(String color) {
        if (conectar() != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                ResourceSet result = servicio.query("for $cod in /Presas/Presa where $cod/Color='" + color + "' return $cod/Codigo/text()");
                // recorrer los datos del recurso.
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    System.out.println(" LA CONSULTA NO DEVUELVE NADA O ESTÁ MAL ESCRITA");
                }
                comboCodigo.removeAllItems();
                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    System.out.println("--------------------------------------------");
                    System.out.println((String) r.getContent());

                    comboCodigo.addItem(r.getContent());

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

    public void CodigoPorDificultad(String dificultad) {
        if (conectar() != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                ResourceSet result = servicio.query("for $cod in /Presas/Presa where $cod/Nivel='" + dificultad + "' return $cod/Codigo/text()");
                // recorrer los datos del recurso.
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    System.out.println(" LA CONSULTA NO DEVUELVE NADA O ESTÁ MAL ESCRITA");
                }
                comboCodigo.removeAllItems();
                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    System.out.println("--------------------------------------------");
                    System.out.println((String) r.getContent());

                    comboCodigo.addItem(r.getContent());

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

    public void CodigoPorForma(String forma) {
        if (conectar() != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                ResourceSet result = servicio.query("for $cod in /Presas/Presa where $cod/Forma='" + forma + "' return $cod/Codigo/text()");
                // recorrer los datos del recurso.
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    System.out.println(" LA CONSULTA NO DEVUELVE NADA O ESTÁ MAL ESCRITA");
                }
                comboCodigo.removeAllItems();
                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    System.out.println("--------------------------------------------");
                    System.out.println((String) r.getContent());

                    comboCodigo.addItem(r.getContent());

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

    public void CodigoPorTamaño(String nivel) {
        if (conectar() != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                ResourceSet result = servicio.query("for $cod in /Presas/Presa where $cod/Tamaño='" + nivel + "' return $cod/Codigo/text()");
                // recorrer los datos del recurso.
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    System.out.println(" LA CONSULTA NO DEVUELVE NADA O ESTÁ MAL ESCRITA");
                }
                comboCodigo.removeAllItems();
                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    System.out.println("--------------------------------------------");
                    System.out.println((String) r.getContent());

                    comboCodigo.addItem(r.getContent());

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

    public void crearListaNivel() {
        listaNivel.add("IV");
        listaNivel.add("IV+");
        listaNivel.add("V");
        listaNivel.add("V+");
        listaNivel.add("6a");
        listaNivel.add("6a+");
        listaNivel.add("6b");
        listaNivel.add("6b+");
        listaNivel.add("6c");
        listaNivel.add("6c+");
        listaNivel.add("7a");
        listaNivel.add("7a+");
        listaNivel.add("7b");
        listaNivel.add("7b+");


    }

    public static void cargar_vias_coleccion() throws XMLDBException {
        //Devuelve true si el dep existe
        if (conectar() != null) {
            try {
                // Inicializamos el recurso
                XMLResource res = null;
                // Creamos el recurso -> recibe 2 parámetros tipo String:
                // s: nombre.xml (si lo dejamos null, pondrá un nombre aleatorio)
                // s1: tipo recurso (en este caso, siempre será XMLResource)
                res = (XMLResource) col.createResource("vias.xml", "XMLResource");

                // Elegimos el fichero .xml que queremos añadir a la colección
                File f = new File("Archivos/vias.xml");

                // Fijamos como contenido ese archivo .xml elegido
                res.setContent(f);
                col.storeResource(res); // lo añadimos a la colección

                // Listamos la colección para ver que en efecto se ha añadido
                for (String colRe : col.listResources())
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

    public void añadirViaArchivoLocal(String nombre) throws IOException {
        File fichero = new File("Archivos/ViasLocales.dat");
        FileInputStream filein = new FileInputStream(fichero);

        // System.out.println(fichero.length());
        nombre = nombre + " ";


        String array = "";
        int e;
        while ((e = filein.read()) != -1) { //lee datos del flujo de entrada
            array = array + (char) e ;
        }

        byte[] escribir = (array + nombre).getBytes();
        FileOutputStream fileout = new FileOutputStream(fichero);

        int longitud = escribir.length;
        for (int i = 0; i < longitud; i++) {
            fileout.write(escribir[i]);
        }
        filein.close();
        fileout.close();

    }

    public void añadirRegistro(String registro) throws IOException {
        File fichero = new File("Archivos/Registros.txt");

        FileReader fr = new FileReader(fichero);
        int z = fr.read();
        String reg = "";
        while( z !=-1){
            reg = reg+(char)z;
            z = fr.read();
        }
        System.out.println(registro);
        FileWriter fw = new FileWriter(fichero);
        fw.write(reg+registro+"\n");
        fr.close();
        fw.close();





    }

    public static void nuevaVia(String nombre, String Dificultad, ArrayList<Presas> Pres) {
        String nueva = "\t<Via>\n\t\t<Nombre>" + nombre + "</Nombre>\n\t\t<Dificultad>" + Dificultad + "</Dificultad>\n\t\t<Presas>";
        for (Presas pre : Pres) {
            nueva = nueva + "\n\t\t\t<Presa>\n\t\t\t\t<Codigo>" + pre.getCodigo() + "</Codigo>\n\t\t\t\t<Posicion>" + pre.getPosicion() + "</Posicion>\n\t\t\t</Presa>";
        }
        nueva = nueva + "\n\t\t</Presas>\n\t</Via>";
        if (conectar() != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                ResourceSet result = servicio.query("update insert " + nueva + " into /Vias");
                col.close();
                System.out.println("via insertada correctamente");
            } catch (Exception e) {
                System.out.println("Error al insertar la via.");
                e.printStackTrace();
            }
        }

        System.out.println(nueva);
    }

    public void RecogerNombresVias() {
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
                    cargar_vias_coleccion();
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

    public boolean NombreRepetido(String nombre) {
        boolean repetido = false;
        for (Object nombreL : listaNombres) {
            if (nombre.toLowerCase().equals(nombreL.toString().toLowerCase()))
                repetido = true;

        }

        return repetido;
    }

    //TODO comprobar que no se repita el nombre, y añadir el nombre a un fichero con los nombres de las vias creadas en cada sitio



    //TODO Añadir la info al fichero de recoger info

    public JPanel getPanel() {
        return VentanaCreacion;
    }

    public void setVentanaCreacion(JFrame jframe) {
        this.frameVentanaCreacion = jframe;
    }

}
