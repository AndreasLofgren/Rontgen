/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.edit;

import handler.CompetenceHandler;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import model.Competence;
import model.Room;

/**
 *
 * @author Andreas
 */
public class EditCompetence extends JPanel {

    public EditCompetence(JTabbedPane jtp) {
        this.setLayout(new BorderLayout());

        JPanel panelNorth = new JPanel();
        this.add(panelNorth, BorderLayout.NORTH);
        panelNorth.setLayout(new GridLayout(0, 2, 15, 15));

        JPanel panelSouth = new JPanel();
        this.add(panelSouth, BorderLayout.SOUTH);
        panelSouth.setLayout(new FlowLayout());

        JLabel kompetenceNavn = new JLabel("Navn: ");
        panelNorth.add(kompetenceNavn);

        JTextField skrivNavn = new JTextField("Skriv navn");
        panelNorth.add(skrivNavn);

        JLabel fornyInterval = new JLabel("Fornyelsesinterval");
        panelNorth.add(fornyInterval);

        JComboBox interval = new JComboBox();
        panelNorth.add(interval);
        for (int i = 0; i < 12; i++) {
            interval.addItem(i + 1);
        }

        JLabel tilknytRum = new JLabel("Tilknyt til rum");
        panelNorth.add(tilknytRum);

        JPanel checks = new JPanel();
        panelNorth.add(checks);

        JCheckBox mrCheck = new JCheckBox();
        checks.add(mrCheck);

        JLabel mr = new JLabel("MR");
        checks.add(mr);

        JCheckBox ctCheck = new JCheckBox();
        checks.add(ctCheck);

        JLabel ct = new JLabel("CT");
        checks.add(ct);

        JCheckBox ultraCheck = new JCheckBox();
        checks.add(ultraCheck);

        JLabel ultra = new JLabel("Ultralyd");
        checks.add(ultra);

        JCheckBox gennemlysCheck = new JCheckBox();
        checks.add(gennemlysCheck);

        JLabel gennemlys = new JLabel("Gennemlys");
        checks.add(gennemlys);

        JCheckBox knogleCheck = new JCheckBox();
        checks.add(knogleCheck);

        JLabel knogle = new JLabel("Knogle");
        checks.add(knogle);

        JCheckBox adminCheck = new JCheckBox();
        checks.add(adminCheck);

        JLabel admin = new JLabel("Admin");
        checks.add(admin);

        JCheckBox vagtCheck = new JCheckBox();
        checks.add(vagtCheck);

        JLabel vagt = new JLabel("Vagt");
        checks.add(vagt);
        
        Competence competence = new Competence("MR");

        JButton gem = new JButton("Gem");
        panelSouth.add(gem);
        gem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(5);
                CompetenceHandler ch = new CompetenceHandler();
//                ch.updateCompetance(skrivNavn.getText(), new Room(1), competence.getSkill());
            }
        });

        JButton tilbage = new JButton("Annuller");
        panelSouth.add(tilbage);
        tilbage.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(5);
            }
        });
    }
}
