/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.show;

import handler.MessageHandler;
import handler.StaffHandler;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import model.Message;
import model.Staff;

/**
 *
 * @author Andreas
 */
public class ShowStaff extends JPanel {

    /**
     *
     * @param jtp the JTabbedPane the JPanel is build on
     */
    public ShowStaff(JTabbedPane jtp) {
        try {
            this.setLayout(new BorderLayout());
            
            JPanel personaleCenter = new JPanel();
            this.add(personaleCenter, BorderLayout.CENTER);
            
            JPanel personaleSouth = new JPanel();
            this.add(personaleSouth, BorderLayout.SOUTH);
            
            Container personalePaneCenter = new Container();
            personalePaneCenter.setLayout(new GridLayout(0, 1, 20, 20));           // ændrer tal til variabler
            personaleCenter.add(personalePaneCenter);
            
            Container personalePaneSouth = new Container();
            personalePaneSouth.setLayout(new GridLayout(1, 0, 20, 20));           // ændrer tal til variabler
            personaleSouth.add(personalePaneSouth);
            
            JPanel personaleWest = new JPanel();
            this.add(personaleWest, BorderLayout.WEST);
            
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
            this.add(personaleEast, BorderLayout.EAST);
            
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
            
//        for (int i = 0; i < beskeder.size(); i++) {
//            description = beskeder.get(i).getDescription();
//        }
            
            JButton visMedarbejder1 = new JButton("Vis Medarbejder");
            visMedarbejder1.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    medarbejderInfo.setText(" Navn: " + medarbejderListe.getSelectedItem()
                            + "\n Adresse: " + "\n Telefon: " + "\n Mobil: "
                            + "\n E-mail: " + "\n Stilling: " + "\n Noter: \n");
//                        + description);
                    
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
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(jtp, ex, "Fejl", JOptionPane.ERROR_MESSAGE);
        }
    }
}
