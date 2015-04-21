/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.create;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Andreas
 */
public class CreateWeek extends JPanel {
    
    public CreateWeek(String name) {
        
    }
    
    public void createWeekPage(String name) {
        
        JButton tilbage = new JButton("Tilbage");
        tilbage.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(0);
            }
        });
        name.add(tilbage);
    }
}
