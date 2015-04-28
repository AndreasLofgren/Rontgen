package view.create;

import handler.RoomHandler;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import model.Room;

/**
 *
 * @author Stine
 */
public class CreateRoom extends JPanel {

    public CreateRoom(JTabbedPane jtp) {

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

        //Tilføjer status til rummet i combobox
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
        
        for (int i = 1; i <= 31; i++){
            validDay.addItem(i);
        }
        
        JLabel day = new JLabel("Dag");
        infox.add(day);

        JComboBox validMonth = new JComboBox();
        infox.add(validMonth);
        
        for (int i = 1; i <= 12; i++){
            validMonth.addItem(i);
        }
        
        JLabel month = new JLabel("Måned");
        infox.add(month);

        JComboBox validYear = new JComboBox();
        infox.add(validYear);
        
        for (int i = 2015; i < 2021; i++){
            validYear.addItem(i);
        }
        
        JLabel year = new JLabel("År");
        infox.add(year);

        //Knap Gem
        JButton gemroom = new JButton("Gem");
        gemroom.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            //    RoomHandler rh = new RoomHandler();
            //    rh.insertRoom(1, String.valueOf(typecombo.getSelectedItem()), String.valueOf(statuscombo.getSelectedItem()), Integer.parseInt(minbemanding.getText()), Integer.parseInt(maxbemanding.getText()), String.valueOf(validYear.getSelectedItem()) + String.valueOf(validMonth.getSelectedItem()) + String.valueOf(validDay.getSelectedItem()));
                jtp.setSelectedIndex(4);
            }
        });
        infosouth.add(gemroom);

        //Knap Anuller
        JButton anuller = new JButton("Anuller");
        anuller.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        infosouth.add(anuller);

    }
}
