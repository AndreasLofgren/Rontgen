/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.create;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 *
 * @author Andreas
 */
public class CreateWeek extends JPanel {
    
    public CreateWeek(String opret_ugeplan, JTabbedPane jtp) {
        this.setLayout(new BorderLayout());
        
        JPanel CreateweekplanCenter = new JPanel();
        this.add(CreateweekplanCenter, BorderLayout.CENTER);
        
        JPanel CreateweekplanWest = new JPanel();
        this.add(CreateweekplanWest, BorderLayout.WEST);

        JPanel CreateweekplanSouth = new JPanel();
        this.add(CreateweekplanSouth, BorderLayout.SOUTH);
        
        JPanel CreateweekplanNorth = new JPanel();
        this.add(CreateweekplanNorth, BorderLayout.NORTH);
        
        JComboBox infoListe = new JComboBox();
        CreateweekplanNorth.add(infoListe);
        
        JTextArea weekplanInfo = new JTextArea();
        CreateweekplanCenter.add(weekplanInfo);
        weekplanInfo.setPreferredSize(new Dimension(800, 300));  //erstat konstanter med variabler
  
        JButton gemweek = new JButton("Gem ændringer");
        gemweek.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        CreateweekplanSouth.add(gemweek);  
        
        JButton medarbejder = new JButton("Opret medarbejder");
        medarbejder.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        CreateweekplanSouth.add(medarbejder);
        
        JButton ugeplan = new JButton("Vis Ugeplan");
        ugeplan.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        CreateweekplanSouth.add(ugeplan);
        
        JButton tilbage = new JButton("Tilbage til Ugeplan");
        tilbage.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        CreateweekplanSouth.add(tilbage);
    }
    
}
