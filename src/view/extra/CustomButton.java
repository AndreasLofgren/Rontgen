/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.extra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import view.Xray;

/**
 *
 * @author Andreas
 */
public class CustomButton extends JButton {
    JButton custom = new JButton();
    JTabbedPane jtp = new JTabbedPane();
    
    /**
     *
     * @param name
     * @param index
     */
    public void createNavBut(String name, int index) {
        
        custom.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setSelectedIndex(index);
            }
        });
        
    }
}
