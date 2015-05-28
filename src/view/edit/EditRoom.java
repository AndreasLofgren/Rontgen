package view.edit;

import handler.RoomHandler;
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

    /**
     *
     * @param jtp the JTabbedPane the JPanel is build on
     */
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
        
        JLabel roomid = new JLabel("Navn på rum: ");
        infonorth.add(roomid);
        
        JTextField rumtext = new JTextField();
        infonorth.add(rumtext);
        rumtext.setText("Indtast navn på rummet");

        JLabel type = new JLabel("Type:");
        infonorth.add(type);

        //Combobox - Type
        JComboBox typecombo = new JComboBox();
        infonorth.add(typecombo);

        //Tilføjer type til rummet i combobox
        typecombo.addItem("MR");
        typecombo.addItem("CT");
        typecombo.addItem("Ultralyd");
        typecombo.addItem("Gennemlysning");
        typecombo.addItem("Knogle");
        typecombo.addItem("Adminstrativ");
        typecombo.addItem("Vagtrum");

        JLabel status = new JLabel("Status:");
        infonorth.add(status);

//      Combobox - Status
        JComboBox statuscombo = new JComboBox();
        infonorth.add(statuscombo);

//      Tilføjer status til rummet i combobox
        statuscombo.addItem("Åben");
        statuscombo.addItem("Lukket");
        statuscombo.addItem("Service");

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

        JLabel validFrom = new JLabel("Gyldigt fra: ");
        infonorth.add(validFrom);

        JPanel infox = new JPanel();
        infonorth.add(infox);

        JComboBox validDay = new JComboBox();
        infox.add(validDay);

        for (int i = 1; i <= 31; i++) {
            validDay.addItem(i);
        }

        JLabel day = new JLabel("Dag");
        infox.add(day);

        JComboBox validMonth = new JComboBox();
        infox.add(validMonth);

        for (int i = 1; i <= 12; i++) {
            validMonth.addItem(i);
        }

        JLabel month = new JLabel("Måned");
        infox.add(month);

        JComboBox validYear = new JComboBox();
        infox.add(validYear);

        for (int i = 2015; i < 2021; i++) {
            validYear.addItem(i);
        }

        JLabel year = new JLabel("År");
        infox.add(year);

        
        validMonth.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int year = Integer.parseInt(String.valueOf(validYear.getSelectedItem()));
                int month = Integer.parseInt(String.valueOf(validMonth.getSelectedItem()));
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
                        daysInMonth= 31;
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
                validDay.removeAllItems();
                for (int i = 1; i <= daysInMonth; i++) {
                    validDay.addItem(i);
                }

            }
        });
        
        validYear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (Integer.parseInt(String.valueOf(validMonth.getSelectedItem())) == 2) {
                    int daysInMonth = 0;
                    int year = 0;
                    
                    validDay.removeAllItems();
                    daysInMonth = (year % 4 == 0) && (year % 100 != 0)
                                || (year % 400 == 0) ? 29 : 28;
                    for (int i = 1; i <= daysInMonth; i++) {
                        validDay.addItem(i);
                        
                    }
                }
            }
        });
        
        //Knap Gem
        JButton gemroom = new JButton("Gem");
        gemroom.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //RoomHandler rh = new RoomHandler();
//                rh.updateRoom(rumtext.getText(), String.valueOf(typecombo.getSelectedItem()), String.valueOf(statuscombo.getSelectedItem()),
//                       Integer.parseInt(minbemandtext.getText()), Integer.parseInt(maxbemandtext.getText()), String.valueOf(validYear.getSelectedItem()) + String.valueOf(validMonth.getSelectedItem()) + String.valueOf(validDay.getSelectedItem()), 1 );
                jtp.setSelectedIndex(4);
            }
        });
        infosouth.add(gemroom);

        //Knap Tilbage
        JButton anuller = new JButton("Anuller");
        anuller.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(4);
            }
        });
        infosouth.add(anuller);

    }
}
