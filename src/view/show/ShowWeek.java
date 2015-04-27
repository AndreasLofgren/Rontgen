package view.show;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 *
 * @author Stine
 */
public class ShowWeek extends JPanel {

    public ShowWeek(JTabbedPane jtp) {

        this.setLayout(new BorderLayout());
        JPanel flowborder = new JPanel();
        this.add(flowborder, BorderLayout.SOUTH);

        //Tilbage knap
        JButton tilbage1 = new JButton("Tilbage");
        tilbage1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        flowborder.add(tilbage1);

        //Knap til opret medarbejder
        JButton opretugeplan = new JButton("Opret Ugeplan");
        opretugeplan.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        flowborder.add(opretugeplan);

        //Knap vis uge
        JButton visuge = new JButton("Vis Uge");
        visuge.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        flowborder.add(visuge);

        //Knap Print ugeplan
        JButton printugeplan = new JButton("Print Ugeplan");
        printugeplan.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        flowborder.add(printugeplan);

        //TextArea - display text
        JPanel ugeplanPane = new JPanel();
        ugeplanPane.setLayout(new BorderLayout());
        this.add(ugeplanPane);

        JTextArea displaytext = new JTextArea();
        ugeplanPane.add(displaytext, BorderLayout.CENTER);
        displaytext.append("Næstved Røngten Afdeling - Ugeplan");

        displaytext.setPreferredSize(new Dimension(400, 300));

        //Vis ugerne COMBOBOX
        JPanel comboPane = new JPanel();
        this.add(comboPane, BorderLayout.WEST);
        
        JComboBox uger = new JComboBox();
        comboPane.add(uger);

    }

}
