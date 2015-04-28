/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import view.create.CreateStaff;
import view.create.CreateCompetence;
import view.create.CreateRoom;
import view.create.CreateWeek;
import view.edit.EditCompetence;
import view.edit.EditRoom;
import view.edit.EditStaff;
import view.show.ShowAbsence;
import view.show.ShowRoom;
import view.show.ShowStaff;
import view.show.ShowWeek;
import view.show.ShowCompetence;

/**
 *
 * @author stine
 */
public class Xray extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane jtp = new JTabbedPane();

        //Startside
        Homepage startside = new Homepage(jf, jtp);
        jtp.add(startside);
        jtp.setTitleAt(0, "Startside");
        startside.setPreferredSize(new Dimension(800, 600)); // ændrer tal til variabler

        //Oprettelse af ugeplan        
        CreateWeek ugeplanOpret = new CreateWeek("Opret ugeplan", jtp);
        jtp.add(ugeplanOpret);
        jtp.setTitleAt(1, "Opret ugeplan");

        //Vis ugeplan
        ShowWeek ugeplanVis = new ShowWeek(jtp);
        jtp.add(ugeplanVis);
        jtp.setTitleAt(2, "Vis ugeplan");

        //Vis personale
        ShowStaff personaleVis = new ShowStaff(jtp);
        jtp.add(personaleVis);
        jtp.setTitleAt(3, "Personaleoversigt");

        //Vis rum
        ShowRoom rumVis = new ShowRoom(jtp);
        jtp.add(rumVis);
        jtp.setTitleAt(4, "Rum oversigt");

        //Vis kompetancer
        ShowCompetence kompetanceVis = new ShowCompetence("Vis kompetence", jtp);
        jtp.add(kompetanceVis);
        jtp.setTitleAt(5, "Vis kompetance");

        //Vis statistikker
        JPanel statistikVis = new JPanel();
        jtp.add(statistikVis);
        jtp.setTitleAt(6, "Statistik");

        //Opret personale
        CreateStaff opretMedarbejder = new CreateStaff("Opret personale", jtp);
        jtp.add(opretMedarbejder);
        jtp.setTitleAt(7, "Opret personale");

        //Opret rum
        CreateRoom opretRum = new CreateRoom(jtp);
        jtp.add(opretRum);
        jtp.setTitleAt(8, "Opret Rum");

        //Opret kompetance
        CreateCompetence opretKompetence = new CreateCompetence(jtp);
        jtp.add(opretKompetence);
        jtp.setTitleAt(9, "Opret kompetance");

        //Fravær
        ShowAbsence fravar = new ShowAbsence(jtp);
        jtp.add(fravar);
        jtp.setTitleAt(10, "Fravær");

        //Rediger personale
        EditStaff redPersonale = new EditStaff("Rediger personale", jtp);
        jtp.add(redPersonale);
        jtp.setTitleAt(11, "Rediger personale");

        //Rediger kompetance
        EditCompetence redKompetance = new EditCompetence(jtp);
        jtp.add(redKompetance);
        jtp.setTitleAt(12, "Rediger kompetance");

        //Rediger rum
        EditRoom redRum = new EditRoom(jtp);
        jtp.add(redRum);
        jtp.setTitleAt(13, "Rediger rum");

        jf.setContentPane(jtp);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

}
