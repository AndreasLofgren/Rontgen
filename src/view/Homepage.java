/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.CreateShow;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import model.Shift;
import view.create.CreateWeek;

/**
 *
 * @author Andreas
 */
public class Homepage extends JPanel{
    
    public Homepage(JFrame jf, JTabbedPane jtp) {
        this.setLayout(new BorderLayout());

        JPanel center = new JPanel();
        this.add(center, BorderLayout.CENTER);

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
                
                CreateShow newWeek = new CreateShow();
                ArrayList<ArrayList<Shift>> ugeplan = newWeek.createWeek("2015-05-05");
                CreateWeek cw = new CreateWeek("Opret ugeplan", jtp);
                
                for (int i = 0; i < ugeplan.size(); i++) {
                    for (int j = 0; j < ugeplan.get(i).size(); j++) {
                        cw.getTextArea().setText(ugeplan.get(i).get(j).getStaff().getFirstName());
                    }                    
                }                
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
    }
}
