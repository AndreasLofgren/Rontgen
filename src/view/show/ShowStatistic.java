/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.show;

import control.Statistic;
import handler.RoomHandler;
import handler.StaffHandler;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import model.Absence;
import model.Room;
import model.Shift;
import model.Staff;

/**
 *
 * @author hesc
 */
public class ShowStatistic extends JPanel {

    public ShowStatistic(JTabbedPane jtp) {

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

        typecombobox.addItem("Dagsvagt");
        typecombobox.addItem("Aftenvagt");
        typecombobox.addItem("Nattevagt");
        typecombobox.addItem("Fravær");

        JLabel statmedarbejder = new JLabel("Medarbejder");
        statestikNorth.add(statmedarbejder);

        JComboBox arbejdercombobox = new JComboBox();
        statestikNorth.add(arbejdercombobox);

        StaffHandler sh = new StaffHandler();
        ArrayList<Staff> medarbejdere = new ArrayList<>();
        medarbejdere = sh.getStaff();

        arbejdercombobox.addItem("Alle");
        for (int i = 0; i < medarbejdere.size(); i++) {

            arbejdercombobox.addItem(medarbejdere.get(i).getFirstName() + " "
                    + medarbejdere.get(i).getLastName());
        }

        JLabel statrum = new JLabel("Rum");
        statestikNorth.add(statrum);

        JComboBox rumcombobox = new JComboBox();
        statestikNorth.add(rumcombobox);

        RoomHandler rh = new RoomHandler();
        ArrayList<Room> rum = new ArrayList<>();
        rum = rh.getRoom();

        rumcombobox.addItem("Alle");
        for (int i = 0; i < rum.size(); i++) {

            rumcombobox.addItem(rum.get(i).getName());
        }

        JLabel statstart = new JLabel("Startdato");
        statestikNorth.add(statstart);

        JPanel statestikx = new JPanel();
        statestikNorth.add(statestikx);

        JLabel startday = new JLabel("Dag: ");
        statestikx.add(startday);

        JComboBox startdaycombobox = new JComboBox();
        statestikx.add(startdaycombobox);

        for (int i = 1; i <= 31; i++) {
            startdaycombobox.addItem(i);
        }

        JLabel startmonth = new JLabel("Måned: ");
        statestikx.add(startmonth);

        JComboBox startmonthcombobox = new JComboBox();
        statestikx.add(startmonthcombobox);

        for (int i = 1; i <= 12; i++) {
            startmonthcombobox.addItem(i);
        }

        JLabel startyear = new JLabel("År: ");
        statestikx.add(startyear);

        JComboBox startyearcombobox = new JComboBox();
        statestikx.add(startyearcombobox);

        for (int i = 2015; i <= 2021; i++) {
            startyearcombobox.addItem(i);
        }

        startmonthcombobox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int year = Integer.parseInt(String.valueOf(startyearcombobox.getSelectedItem()));
                int month = Integer.parseInt(String.valueOf(startmonthcombobox.getSelectedItem()));
                int daysInMonth = 0;

                switch (month) {
                    case 1:
                        daysInMonth = 31;
                        break;
                    case 2:
                        daysInMonth = (year % 4 == 0) && (year % 100 != 0)
                                || (year % 400 == 0) ? 29 : 28;
                        break;
                    case 3:
                        daysInMonth = 31;
                        break;
                    case 4:
                        daysInMonth = 30;
                        break;
                    case 5:
                        daysInMonth = 31;
                        break;
                    case 6:
                        daysInMonth = 30;
                        break;
                    case 7:
                        daysInMonth = 31;
                        break;
                    case 8:
                        daysInMonth = 31;
                        break;
                    case 9:
                        daysInMonth = 30;
                        break;
                    case 10:
                        daysInMonth = 31;
                        break;
                    case 11:
                        daysInMonth = 30;
                        break;
                    case 12:
                        daysInMonth = 31;
                        break;
                    default:
                        daysInMonth = 30;
                }
                startdaycombobox.removeAllItems();
                for (int i = 1; i <= daysInMonth; i++) {
                    startdaycombobox.addItem(i);
                }
            }
        });

        startyearcombobox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (Integer.parseInt(String.valueOf(startmonthcombobox.getSelectedItem())) == 2) {
                    int daysInMonth = 0;
                    int year = 0;

                    startdaycombobox.removeAllItems();
                    daysInMonth = (year % 4 == 0) && (year % 100 != 0)
                            || (year % 400 == 0) ? 29 : 28;
                    for (int i = 1; i <= daysInMonth; i++) {
                        startdaycombobox.addItem(i);

                    }
                }
            }
        });

        JLabel statslut = new JLabel("Slutdato");
        statestikNorth.add(statslut);

        JPanel statestiky = new JPanel();
        statestikNorth.add(statestiky);

        JLabel slutday = new JLabel("Dag: ");
        statestiky.add(slutday);

        JComboBox slutdaycombobox = new JComboBox();
        statestiky.add(slutdaycombobox);

        for (int i = 1; i <= 31; i++) {
            slutdaycombobox.addItem(i);
        }

        JLabel slutmonth = new JLabel("Måned: ");
        statestiky.add(slutmonth);

        JComboBox slutmonthcombobox = new JComboBox();
        statestiky.add(slutmonthcombobox);

        for (int i = 1; i <= 12; i++) {
            slutmonthcombobox.addItem(i);
        }

        JLabel slutyear = new JLabel("År: ");
        statestiky.add(slutyear);

        JComboBox slutyearcombobox = new JComboBox();
        statestiky.add(slutyearcombobox);

        for (int i = 2015; i <= 2021; i++) {
            slutyearcombobox.addItem(i);
        }

        slutmonthcombobox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int year = Integer.parseInt(String.valueOf(slutyearcombobox.getSelectedItem()));
                int month = Integer.parseInt(String.valueOf(slutmonthcombobox.getSelectedItem()));
                int daysInMonth = 0;
                switch (month) {
                    case 1:
                        daysInMonth = 31;
                        break;
                    case 2:
                        daysInMonth = (year % 4 == 0) && (year % 100 != 0)
                                || (year % 400 == 0) ? 29 : 28;
                        break;
                    case 3:
                        daysInMonth = 31;
                        break;
                    case 4:
                        daysInMonth = 30;
                        break;
                    case 5:
                        daysInMonth = 31;
                        break;
                    case 6:
                        daysInMonth = 30;
                        break;
                    case 7:
                        daysInMonth = 31;
                        break;
                    case 8:
                        daysInMonth = 31;
                        break;
                    case 9:
                        daysInMonth = 30;
                        break;
                    case 10:
                        daysInMonth = 31;
                        break;
                    case 11:
                        daysInMonth = 30;
                        break;
                    case 12:
                        daysInMonth = 31;
                        break;
                    default:
                        daysInMonth = 30;
                }
                slutdaycombobox.removeAllItems();
                for (int i = 1; i <= daysInMonth; i++) {
                    slutdaycombobox.addItem(i);
                }
            }
        });

        slutyearcombobox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (Integer.parseInt(String.valueOf(slutmonthcombobox.getSelectedItem())) == 2) {
                    int daysInMonth = 0;
                    int year = 0;

                    slutdaycombobox.removeAllItems();
                    daysInMonth = (year % 4 == 0) && (year % 100 != 0)
                            || (year % 400 == 0) ? 29 : 28;
                    for (int i = 1; i <= daysInMonth; i++) {
                        slutdaycombobox.addItem(i);

                    }
                }
            }
        });

        JButton createStatistik = new JButton("Lav statistik");
        statestikSouth.add(createStatistik);

        JTextArea statestiktekst = new JTextArea();
        statestikCenter.add(statestiktekst);
        statestiktekst.setPreferredSize(new Dimension(800, 400));            // tallene skal erstattes med variabler

        createStatistik.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Statistic metoder = new Statistic();
                System.out.println("Index i combobox: " + typecombobox.getSelectedIndex());

                String startDato = startyearcombobox.getSelectedItem() + ":"
                        + startmonthcombobox.getSelectedItem() + ":"
                        + startdaycombobox.getSelectedItem();

                String slutDato = slutyearcombobox.getSelectedItem() + ":"
                        + slutmonthcombobox.getSelectedItem() + ":"
                        + slutdaycombobox.getSelectedItem();

                switch (typecombobox.getSelectedIndex()) {
                    case 0:
                        ArrayList<ArrayList<Shift>> dagsVagt = metoder.createDagsvagt("dagsvagt");

                        if (dagsVagt.isEmpty()) {
                            statestiktekst.setText("Ingen dagsvagter i denne periode");
                        } else {
                            for (int i = 0; i < dagsVagt.size(); i++) {
                                for (int j = 0; j < dagsVagt.get(i).size(); j++) {
                                    statestiktekst.setText(
                                            "Statistik for d. " + startDato
                                            + " til d. " + slutDato + ": \n Navn: "
                                            + dagsVagt.get(i).get(j).getStaff().getFirstName()
                                            + " "
                                            + dagsVagt.get(i).get(j).getStaff().getLastName()
                                            + "\n Antal vagter i "
                                            + dagsVagt.get(i).get(j).getRoom().getName()
                                            + ": " + dagsVagt.get(i).size());
                                }
                            }
                        }
                        break;
                    case 1:
                        ArrayList<Shift> aftenVagt = metoder.createVagt("aftenvagt");

                        if (aftenVagt.isEmpty()) {
                            statestiktekst.setText("Intet aftenvagt i denne periode");
                        } else {
                            for (int i = 0; i < aftenVagt.size(); i++) {
                                statestiktekst.setText(
                                        "Statistik for d. " + startDato
                                        + " til d. " + slutDato + ": \n Navn: "
                                        + aftenVagt.get(i).getStaff().getFirstName()
                                        + " "
                                        + aftenVagt.get(i).getStaff().getLastName()
                                        + "\n Antal vagter i "
                                        + aftenVagt.get(i).getRoom().getName()
                                        + ": " + aftenVagt.size());
                            }
                        }
                        break;
                    case 2:
                        ArrayList<Shift> natteVagt = metoder.createVagt("nattevagt");

                        if (natteVagt.isEmpty()) {
                            statestiktekst.setText("Inngen nattevagt i denne periode");
                        } else {
                            for (int i = 0; i < natteVagt.size(); i++) {
                                statestiktekst.setText(
                                        "Statistik for d. " + startDato
                                        + " til d. " + slutDato + ": \n Navn: "
                                        + natteVagt.get(i).getStaff().getFirstName()
                                        + " "
                                        + natteVagt.get(i).getStaff().getLastName()
                                        + "\n Antal vagter i "
                                        + natteVagt.get(i).getRoom().getName()
                                        + ": " + natteVagt.size());
                            }
                        }
                        break;
                    case 3:
                        ArrayList<ArrayList<Absence>> fravaer = metoder.createfravaer(startDato,
                                slutDato);
                        if (fravaer.isEmpty()) {
                            statestiktekst.setText("Intet fravær i denne periode");
                        } else {

                            for (int i = 0; i < fravaer.size(); i++) {
                                for (int j = 0; j < fravaer.get(i).size(); j++) {
                                    statestiktekst.setText(
                                            "Statistik for d. " + startDato
                                            + " til d. " + slutDato + "\n Navn: "
                                            + fravaer.get(i).get(j).getStaff().getFirstName()
                                            + " "
                                            + fravaer.get(i).get(j).getStaff().getLastName()
                                            + "\n Fravær: " + fravaer.get(i).size());
                                }
                            }
                        }
                        break;
                }
            }
        }
        );

        JButton gem3 = new JButton("Gem som PDF");

        statestikSouth.add(gem3);

        JButton tilbage33 = new JButton("Tilbage til startside");

        tilbage33.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        jtp.setSelectedIndex(0);
                    }
                }
        );
        statestikSouth.add(tilbage33);
    }
}
