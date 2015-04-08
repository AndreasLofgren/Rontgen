/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xray;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

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
        JButton tilbage2 = new JButton("Tilbage");        
        tilbage2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        personaleVis.add(tilbage2);
        
        //Vis statistikker
        JPanel statistikVis = new JPanel();
        jtp.add(statistikVis);
        JButton tilbage3 = new JButton("Tilbage");        
        tilbage3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        statistikVis.add(tilbage3);
        
        //Vis rum
        JPanel rumVis = new JPanel();
        jtp.add(rumVis);
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
        JButton tilbage5 = new JButton("Tilbage");        
        tilbage5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        kompetanceVis.add(tilbage5);
        
        

        jf.setContentPane(jtp);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

}
