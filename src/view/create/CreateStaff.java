/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.create;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 *
 * @author Andreas
 */
public class CreateStaff extends JPanel {
    
    public CreateStaff(String opret_medarbejder,JTabbedPane jtp) {
        this.setLayout(new BorderLayout());

        JPanel CreatePersonaleCenter = new JPanel();
        this.add(CreatePersonaleCenter, BorderLayout.CENTER);
        
        JPanel CreatePersonaleWest = new JPanel();
        this.add(CreatePersonaleWest, BorderLayout.WEST);

        JPanel CreatePersonaleSouth = new JPanel();
        this.add(CreatePersonaleSouth, BorderLayout.SOUTH);
        
        JPanel CreatePersonaleEast = new JPanel();
        this.add(CreatePersonaleEast, BorderLayout.EAST);
        
        Container CreatePersonalePaneCenter = new Container();
        CreatePersonalePaneCenter.setLayout(new GridLayout(0, 1, 20, 20));
        CreatePersonaleCenter.add(CreatePersonalePaneCenter);
        
        Container CreatePersonalePaneWest = new Container();
        CreatePersonalePaneWest.setLayout(new GridLayout(0, 1, 20, 20));
        CreatePersonaleWest.add(CreatePersonalePaneWest);

        Container CreatePersonalePaneSouth = new Container();
        CreatePersonalePaneSouth.setLayout(new GridLayout(1, 0, 20, 20));
        CreatePersonaleSouth.add(CreatePersonalePaneSouth);

        Container CreatePersonalePaneEast = new Container();
        CreatePersonalePaneEast.setLayout(new GridLayout(0, 1, 20, 20));
        CreatePersonaleEast.add(CreatePersonalePaneEast);
        
        JLabel fornavn = new JLabel("Fornavn");
        CreatePersonalePaneWest.add(fornavn);
        
        JLabel efternavn = new JLabel("Efternavn");
        CreatePersonalePaneWest.add(efternavn);
        
        JLabel kaldenavn = new JLabel("Kaldenavn");
        CreatePersonalePaneWest.add(kaldenavn);
        
        JLabel telefon = new JLabel("Tlf");
        CreatePersonalePaneWest.add(telefon);
        
        JLabel mobil = new JLabel("Mobil");
        CreatePersonalePaneWest.add(mobil);
        
        JLabel email = new JLabel("Email");
        CreatePersonalePaneWest.add(email);
        
        JLabel stilling = new JLabel("Stilling");
        CreatePersonalePaneWest.add(stilling);
        
        JLabel modul = new JLabel("Modul");
        CreatePersonalePaneWest.add(modul);
        
        JCheckBox student = new JCheckBox("Student");
        CreatePersonalePaneWest.add(student);
        
        JTextArea fornavninfo = new JTextArea("     ");
        CreatePersonalePaneCenter.add(fornavninfo);
        
        JTextArea efternavninfo = new JTextArea("    ");
        CreatePersonalePaneCenter.add(efternavninfo);
        
        JTextArea kaldenavninfo = new JTextArea("    ");
        CreatePersonalePaneCenter.add(kaldenavninfo);
        
        JTextArea telefonnr = new JTextArea("    ");
        CreatePersonalePaneCenter.add(telefonnr);
        
        JTextArea mobilnr = new JTextArea("    ");
        CreatePersonalePaneCenter.add(mobilnr);
        
        JTextArea emailinfo = new JTextArea("    ");
        CreatePersonalePaneCenter.add(emailinfo);
        
        JComboBox stillingListe = new JComboBox();
        CreatePersonalePaneCenter.add(stillingListe);
        
        JComboBox modulListe = new JComboBox();
        CreatePersonalePaneCenter.add(modulListe);
                
        JButton tilbage6 = new JButton("Tilbage til Personaleoversigt");
        tilbage6.addActionListener(new ActionListener(){
        
        
            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(3);
            }
        });
        CreatePersonaleSouth.add(tilbage6);
        
        JButton gem6 = new JButton("Gem medarbejder");
        gem6.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(3);
            }
        });
        CreatePersonaleSouth.add(gem6);
    }
}
