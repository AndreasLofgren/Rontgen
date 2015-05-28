/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.show;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author stine
 */
public class ShowAbsence extends JPanel {

    /**
     *
     * @param jtp the JTabbedPane the JPanel is build on
     */
    public ShowAbsence(JTabbedPane jtp) {
        this.setLayout(new BorderLayout());

        JPanel infoNorth = new JPanel();
        infoNorth.setLayout(new GridLayout(0, 2, 10, 10));
        this.add(infoNorth, BorderLayout.NORTH);

        JPanel infoSouth = new JPanel();
        this.add(infoSouth, BorderLayout.SOUTH);

        //Label: Vælg medarbejder
        JLabel valgmedarbejder = new JLabel("Vælg medarbejder: ");
        infoNorth.add(valgmedarbejder);

        //Combobox: Personale liste
        JComboBox personaleListe = new JComboBox();
        infoNorth.add(personaleListe);

        //Fra dato
        JLabel fradato = new JLabel("Fra dato: ");
        infoNorth.add(fradato);

        JPanel infox = new JPanel();
        infoNorth.add(infox);

        //Fra dato (3 combobox) - datetime
        JComboBox fromDayList = new JComboBox();
        infox.add(fromDayList);

        JLabel fromDay = new JLabel("Dag");
        infox.add(fromDay);

        JComboBox fromMonthList = new JComboBox();
        infox.add(fromMonthList);

        JLabel fromMonth = new JLabel("Måned");
        infox.add(fromMonth);

        JComboBox fromYearList = new JComboBox();
        infox.add(fromYearList);

        JLabel fromYear = new JLabel("År");
        infox.add(fromYear);

        //Til dato
        JLabel tildato = new JLabel("Til dato: ");
        infoNorth.add(tildato);

        JPanel infoy = new JPanel();
        infoNorth.add(infoy);

        //Til dato (3 combobox) - datetime
        JComboBox toDayList = new JComboBox();
        infoy.add(toDayList);

        JLabel toDay = new JLabel("Dag");
        infoy.add(toDay);

        JComboBox toMonthList = new JComboBox();
        infoy.add(toMonthList);

        JLabel toMonth = new JLabel("Måned");
        infoy.add(toMonth);

        JComboBox toYearList = new JComboBox();
        infoy.add(toYearList);

        JLabel toYear = new JLabel("År");
        infoy.add(toYear);

        //Knap Gem fravær
        JButton gemFravar = new JButton("Gem");
        gemFravar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Gemmefunktion til absence
            }
        });
        infoSouth.add(gemFravar);

        //Anuller
        JButton anullerFravar = new JButton("Anuller");
        anullerFravar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        infoSouth.add(anullerFravar);

    }

}
