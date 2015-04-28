/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.show;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 *
 * @author hesc
 */
public class ShowStatestik extends JPanel {

    public ShowStatestik(JTabbedPane jtp) {

        this.setLayout(new BorderLayout());

        JPanel statestikWest = new JPanel();
        this.add(statestikWest, BorderLayout.WEST);

        JPanel statestikEast = new JPanel();
        this.add(statestikEast, BorderLayout.EAST);

        JPanel statestikNorth = new JPanel();
        statestikNorth.setLayout(new GridLayout(0, 2, 10, 10));
        this.add(statestikNorth, BorderLayout.NORTH);

        JPanel statestikSouth = new JPanel();
        this.add(statestikSouth, BorderLayout.SOUTH);

        JPanel statestikCenter = new JPanel();
        this.add(statestikCenter, BorderLayout.CENTER);

        JLabel type = new JLabel("Statistiktype");
        statestikNorth.add(type);

        JComboBox typecombobox = new JComboBox();
        statestikNorth.add(typecombobox);
        typecombobox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JLabel statmedarbejder = new JLabel("Medarbejder");
        statestikNorth.add(statmedarbejder);

        JComboBox arbejdercombobox = new JComboBox();
        statestikNorth.add(arbejdercombobox);
        arbejdercombobox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JLabel statrum = new JLabel("Rum");
        statestikNorth.add(statrum);

        JComboBox rumcombobox = new JComboBox();
        statestikNorth.add(rumcombobox);
        rumcombobox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JLabel statstart = new JLabel("Startdato");
        statestikNorth.add(statstart);

        JComboBox startdatocombobox = new JComboBox();
        statestikNorth.add(startdatocombobox);
        startdatocombobox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JLabel statslut = new JLabel("Slutdato");
        statestikNorth.add(statslut);

        JComboBox slutdatocombobox = new JComboBox();
        statestikNorth.add(slutdatocombobox);
        slutdatocombobox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JTextArea statestiktekst = new JTextArea();
        statestikCenter.add(statestiktekst);
        statestiktekst.setPreferredSize(new Dimension(800, 400));            // tallene skal erstattes med variabler

        JButton gem3 = new JButton("Gem som PDF");
        gem3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        statestikSouth.add(gem3);

        JButton tilbage33 = new JButton("Tilbage til startside");
        tilbage33.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        statestikSouth.add(tilbage33);
    }

}
