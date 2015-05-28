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
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 *
 * @author Andreas
 */
public class ShowRoom extends JPanel {

    /**
     *
     * @param jtp the JTabbedPane the JPanel is build on
     */
    public ShowRoom(JTabbedPane jtp) {

        this.setLayout(new BorderLayout());

        JPanel rumCenter = new JPanel();
        this.add(rumCenter, BorderLayout.CENTER);

        JPanel rumSouth = new JPanel();
        this.add(rumSouth, BorderLayout.SOUTH);

        Container rumPaneCenter = new Container();
        rumPaneCenter.setLayout(new GridLayout(0, 1, 20, 20));           // ændrer tal til variabler
        rumCenter.add(rumPaneCenter);

        Container rumPaneSouth = new Container();
        rumPaneSouth.setLayout(new GridLayout(1, 0, 20, 20));           // ændrer tal til variabler
        rumSouth.add(rumPaneSouth);

        JPanel rumWest = new JPanel();
        this.add(rumWest, BorderLayout.WEST);

        JComboBox rumListe = new JComboBox();
        rumWest.add(rumListe);

        JPanel rumEast = new JPanel();
        this.add(rumEast, BorderLayout.EAST);

        JTextArea rumInfo = new JTextArea();
        rumEast.add(rumInfo);

        JButton visRum = new JButton("Vis Rum");
        visRum.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                rumInfo.setText(" Navn: " + rumListe.getSelectedItem()
                        + "\n Status: ");

            }
        });
        rumPaneCenter.add(visRum);

        JButton visRedigerRum = new JButton("Rediger rum");
        visRedigerRum.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(13);
            }
        });
        rumPaneCenter.add(visRedigerRum);

        JButton opretRum = new JButton("Opret rum");
        opretRum.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(8);
            }
        });
        rumPaneCenter.add(opretRum);

        JButton tilbage4 = new JButton("Tilbage");
        tilbage4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        rumPaneSouth.add(tilbage4);
    }
}
