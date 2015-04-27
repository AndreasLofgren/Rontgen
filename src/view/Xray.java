/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import view.create.CreateCompetence;
import view.create.CreateWeek;
import view.show.ShowRoom;
import view.show.ShowStaff;

/**
 *
 * @author stine
 */
public class Xray extends JFrame {

    /**
     * @param args the command line arguments
     */
        
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane jtp = new JTabbedPane();
        
        //Startside
        Homepage startside = new Homepage(jf, jtp);
        jtp.add(startside);
        jtp.setTitleAt(0, "Startside");
        startside.setPreferredSize(new Dimension(800, 600)); // ændrer tal til variabler

        //Oprettelse af ugeplan        
        CreateWeek ugeplanOpret = new CreateWeek("Opret ugeplan", jtp);
        jtp.add(ugeplanOpret);
        jtp.setTitleAt(1, "Opret ugeplan");
        
        
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
        ShowStaff personaleVis = new ShowStaff(jtp);
        jtp.add(personaleVis);
        jtp.setTitleAt(3, "Personaleoversigt");

        //Vis rum
        ShowRoom rumVis = new ShowRoom(jtp);
        jtp.add(rumVis);
        jtp.setTitleAt(4, "Rum oversigt");
        

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
        CreateCompetence opretKompetence = new CreateCompetence(jtp);
        jtp.add(opretKompetence);
        jtp.setTitleAt(9, "Opret kompetance");

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
