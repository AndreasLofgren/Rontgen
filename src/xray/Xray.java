/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xray;

import handler.MessageHandler;
import handler.StaffHandler;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import model.Message;
import model.Staff;

/**
 *
 * @author stine
 */
public class Xray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane jtp = new JTabbedPane();
        JPanel startside = new JPanel();
        jtp.add(startside);
        jtp.setTitleAt(0, "Startside");
        startside.setPreferredSize(new Dimension(800, 600));    // ændrer tal til variabler
        startside.setLayout(new BorderLayout());

        //Startside
        JPanel center = new JPanel();
        startside.add(center, BorderLayout.CENTER);

        Container pane = jf.getContentPane();
        pane.setLayout(new GridLayout(0, 1, 20, 20));           // ændrer tal til variabler
        center.add(pane);

        //Midlertidligt !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        JButton ugeplaneOversigt = new JButton("Vis uger");
        pane.add(ugeplaneOversigt);
        ugeplaneOversigt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(2);
            }
        });

        JButton ugeplanOprettelse = new JButton("Opret uger");
        pane.add(ugeplanOprettelse);
        ugeplanOprettelse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(1);
            }
        });

        JButton personaleOversigt = new JButton("Personaleoversigt");
        pane.add(personaleOversigt);
        personaleOversigt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(3);
            }
        });

        JButton rumOversigt = new JButton("Rumoversigt");
        pane.add(rumOversigt);
        rumOversigt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(4);
            }
        });

        JButton kompetanceOversigt = new JButton("Kompetanceoversigt");
        pane.add(kompetanceOversigt);
        kompetanceOversigt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(5);
            }
        });

        JButton statistik = new JButton("Statistik");
        pane.add(statistik);
        statistik.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(6);
            }
        });

        //Oprettelse af ugeplan        
        JPanel ugeplanOpret = new JPanel();
        jtp.add(ugeplanOpret);
        jtp.setTitleAt(1, "Opret ugeplan");
        JButton tilbage = new JButton("Tilbage");
        tilbage.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        ugeplanOpret.add(tilbage);

        //Vis ugeplan
        JPanel ugeplanVis = new JPanel();
        jtp.add(ugeplanVis);
        jtp.setTitleAt(2, "Vis ugeplan");
        JButton tilbage1 = new JButton("Tilbage");
        tilbage1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        ugeplanVis.add(tilbage1);

        //Vis personale
        JPanel personaleVis = new JPanel();
        jtp.add(personaleVis);
        jtp.setTitleAt(3, "Personaleoversigt");
        personaleVis.setLayout(new BorderLayout());

        JPanel personaleCenter = new JPanel();
        personaleVis.add(personaleCenter, BorderLayout.CENTER);

        JPanel personaleSouth = new JPanel();
        personaleVis.add(personaleSouth, BorderLayout.SOUTH);

        Container personalePaneCenter = new Container();
        personalePaneCenter.setLayout(new GridLayout(0, 1, 20, 20));           // ændrer tal til variabler
        personaleCenter.add(personalePaneCenter);

        Container personalePaneSouth = new Container();
        personalePaneSouth.setLayout(new GridLayout(1, 0, 20, 20));           // ændrer tal til variabler
        personaleSouth.add(personalePaneSouth);

        JPanel personaleWest = new JPanel();
        personaleVis.add(personaleWest, BorderLayout.WEST);

        JComboBox medarbejderListe = new JComboBox();
        personaleWest.add(medarbejderListe);

        StaffHandler sh = new StaffHandler();
        ArrayList<Staff> medarbejdere = new ArrayList<>();
        medarbejdere = sh.getStaff();

        for (int i = 0; i < medarbejdere.size(); i++) {

            medarbejderListe.addItem(medarbejdere.get(i).getFirstName() + " "
                    + medarbejdere.get(i).getLastName());
        }

        JPanel personaleEast = new JPanel();
        personaleVis.add(personaleEast, BorderLayout.EAST);

        JTextArea medarbejderInfo = new JTextArea();
        personaleEast.add(medarbejderInfo);

        JButton tilbage2 = new JButton("Tilbage");
        tilbage2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        personalePaneSouth.add(tilbage2);

        MessageHandler mh = new MessageHandler();
        ArrayList<Message> beskeder = new ArrayList<>();
        beskeder = mh.getMessage();

        JButton visMedarbejder1 = new JButton("Vis Medarbejder");
        visMedarbejder1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                medarbejderInfo.setText(" Navn: " + medarbejderListe.getSelectedItem()
                        + "\n Adresse: " + "\n Telefon: " + "\n Mobil: "
                        + "\n E-mail: " + "\n Stilling: " + "\n Noter: \n");
                //+ beskeder.get(1).getDescription()
            }
        });
        personalePaneCenter.add(visMedarbejder1);

        JButton visRedigerFravaer1 = new JButton("Åben fravær");
        visRedigerFravaer1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(10);
            }
        });
        personalePaneCenter.add(visRedigerFravaer1);

        JButton redigerKompetencer1 = new JButton("Rediger kompetencer");
        redigerKompetencer1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(12);
            }
        });
        personalePaneCenter.add(redigerKompetencer1);

        JButton opretPersonale1 = new JButton("Opret Personale");
        opretPersonale1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(7);
            }
        });
        personalePaneCenter.add(opretPersonale1);

        JButton redigerPersonale1 = new JButton("Rediger Personale");
        redigerPersonale1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(11);
            }
        });
        personalePaneCenter.add(redigerPersonale1);

        JButton rumOversigt1 = new JButton("Rum oversigt");
        rumOversigt1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(4);
            }
        });
        personalePaneSouth.add(rumOversigt1);

        //Vis rum
        JPanel rumVis = new JPanel();
        jtp.add(rumVis);
        jtp.setTitleAt(4, "Rum oversigt");
        JButton tilbage4 = new JButton("Tilbage");
        tilbage4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        rumVis.add(tilbage4);

        //Vis kompetancer
        JPanel kompetanceVis = new JPanel();
        jtp.add(kompetanceVis);
        jtp.setTitleAt(5, "Vis kompetance");
        JButton tilbage5 = new JButton("Tilbage");
        tilbage5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        kompetanceVis.add(tilbage5);

        //Vis statistikker
        JPanel statistikVis = new JPanel();
        jtp.add(statistikVis);
        jtp.setTitleAt(6, "Statistik");
        JButton tilbage3 = new JButton("Tilbage");
        tilbage3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        statistikVis.add(tilbage3);

        //Opret personale
        JPanel opretMedarbejder = new JPanel();
        jtp.add(opretMedarbejder);
        jtp.setTitleAt(7, "Opret personale");
        JButton tilbage6 = new JButton("Tilbage");
        tilbage6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(3);
            }
        });
        opretMedarbejder.add(tilbage6);

        //Opret rum
        JPanel opretRum = new JPanel();
        jtp.add(opretRum);
        jtp.setTitleAt(8, "Opret Rum");
        JButton tilbage8 = new JButton("Tilbage");
        tilbage8.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        opretRum.add(tilbage8);

        //Opret kompetance
        JPanel opretKompetance = new JPanel();
        jtp.add(opretKompetance);
        jtp.setTitleAt(9, "Opret kompetance");
        JButton tilbage7 = new JButton("Tilbage");
        tilbage7.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        opretKompetance.add(tilbage7);

        //Fravær
        JPanel fravar = new JPanel();
        jtp.add(fravar);
        jtp.setTitleAt(10, "Fravær");

        JButton tilbage9 = new JButton("Tilbage");
        tilbage9.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(3);
            }
        });
        fravar.add(tilbage9);
        
        //Rediger personale
        JPanel redPersonale = new JPanel();
        jtp.add(redPersonale);
        jtp.setTitleAt(11, "Rediger personale");

        JButton tilbage10 = new JButton("Tilbage");
        tilbage10.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(3);
            }
        });
        redPersonale.add(tilbage10);
        
        //Rediger kompetance
        JPanel redKompetance = new JPanel();
        jtp.add(redKompetance);
        jtp.setTitleAt(12, "Rediger kompetance");

        JButton tilbage11 = new JButton("Tilbage");
        tilbage11.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(3);
            }
        });
        redKompetance.add(tilbage11);
        
        //Rediger rum
        JPanel redRum = new JPanel();
        jtp.add(redRum);
        jtp.setTitleAt(13, "Rediger rum");

        JButton tilbage12 = new JButton("Tilbage");
        tilbage12.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(3);
            }
        });
        redRum.add(tilbage12);
        
        

        jf.setContentPane(jtp);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

}
