/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.edit;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author Andreas
 */
public class EditRoom extends JPanel {

    public EditRoom(JTabbedPane jtp) {

        this.setLayout(new BorderLayout());

        JPanel infowest = new JPanel();
        infowest.setLayout(new FlowLayout());

        this.add(infowest, BorderLayout.WEST);

        JPanel infoeast = new JPanel();
        this.add(infoeast, BorderLayout.EAST);

        JPanel infosouth = new JPanel();
        this.add(infosouth, BorderLayout.SOUTH);

        JPanel infonorth = new JPanel();
        infonorth.setLayout(new GridLayout(0, 2, 10, 10));
        this.add(infonorth, BorderLayout.NORTH);

        JPanel infocenter = new JPanel();
        infocenter.setLayout(new GridLayout(0, 1, 10, 10));
        this.add(infocenter, BorderLayout.CENTER);

        JLabel type = new JLabel("Type:");
        infonorth.add(type);

        //Combobox - Type
        JComboBox typecombo = new JComboBox();
        infonorth.add(typecombo);
        typecombo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Hentes fra RoomHandler
            }
        });
        JLabel status = new JLabel("Status:");
        infonorth.add(status);

//      Combobox - Status
        JComboBox statuscombo = new JComboBox();
        infonorth.add(statuscombo);
        statuscombo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Hentes fra RoomHandler
            }
        });

        JLabel minbemanding = new JLabel("Min. bemanding:");
        infonorth.add(minbemanding);

        JTextField minbemandtext = new JTextField();
        infonorth.add(minbemandtext);
        minbemandtext.setText("Indtast min. bemanding");

        JLabel maxbemanding = new JLabel("Max. bemanding:");
        infonorth.add(maxbemanding);

        JTextField maxbemandtext = new JTextField();
        infonorth.add(maxbemandtext);
        maxbemandtext.setText("Indtast max. bemanding");

        //Knap Gem
        JButton gemroom = new JButton("Gem");
        gemroom.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        infosouth.add(gemroom);

        //Knap Tilbage
        JButton tilbage = new JButton("Tilbage");
        tilbage.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        infosouth.add(tilbage);

    }
}
