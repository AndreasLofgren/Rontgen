/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.show;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Andreas
 */
public class ShowCompetence extends JPanel {
    public ShowCompetence(String kompetancevis, JTabbedPane jtp){
        this.setLayout(new BorderLayout());

        JPanel visKompetenceCenter = new JPanel();
        this.add(visKompetenceCenter, BorderLayout.CENTER);
        
        JPanel visKompetenceWest = new JPanel();
        this.add(visKompetenceWest, BorderLayout.WEST);

        JPanel visKompetenceSouth = new JPanel();
        this.add(visKompetenceSouth, BorderLayout.SOUTH);
        
        JPanel visKompetenceEast = new JPanel();
        this.add(visKompetenceEast, BorderLayout.EAST);
        
        JPanel visKompetenceNorth = new JPanel();
        this.add(visKompetenceNorth, BorderLayout.NORTH);
        
        Container visKompetencePaneCenter = new Container();
        visKompetencePaneCenter.setLayout(new GridLayout(0, 1, 20, 20));
        visKompetenceCenter.add(visKompetencePaneCenter);
        
        Container visKompetencePaneWest = new Container();
        visKompetencePaneWest.setLayout(new GridLayout(0, 1, 20, 20));
        visKompetenceWest.add(visKompetencePaneWest);

        Container visKompetencePaneSouth = new Container();
        visKompetencePaneSouth.setLayout(new GridLayout(1, 0, 20, 20));
        visKompetenceSouth.add(visKompetencePaneSouth);

        Container visKompetencePaneEast = new Container();
        visKompetencePaneEast.setLayout(new GridLayout(0, 1, 20, 20));
        visKompetenceEast.add(visKompetencePaneEast);
        
        Container visKompetencePaneNorth = new Container();
        visKompetencePaneNorth.setLayout(new GridLayout(0, 1, 20, 20));
        visKompetenceNorth.add(visKompetencePaneNorth);
        
        JLabel kompetence = new JLabel("Kompetence");
        visKompetencePaneWest.add(kompetence);
        
        JLabel fornyelses_Interval = new JLabel("Fornyelses interval");
        visKompetencePaneCenter.add(fornyelses_Interval);
        
        JLabel tilknyttet_Rum = new JLabel("Tilknyttet rum");
        visKompetencePaneEast.add(tilknyttet_Rum);
        
        JComboBox kompetenceList = new JComboBox();
        visKompetencePaneWest.add(kompetenceList);
        
        JTextField fornyelsesInfo = new JTextField();
        visKompetencePaneCenter.add(fornyelsesInfo);
        
        JTextArea tilknyttetRumInfo = new JTextArea();
        visKompetencePaneEast.add(tilknyttetRumInfo);
        
        JButton tilbage5 = new JButton("Tilbage");
        tilbage5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        visKompetencePaneSouth.add(tilbage5);
        
        JButton tilbage55 = new JButton("Opret Kompetence");
        tilbage5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        visKompetencePaneSouth.add(tilbage55);
        
        JButton tilbage555 = new JButton("Rediger Kompetence");
        tilbage5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        visKompetencePaneSouth.add(tilbage555);
        
    }
}
