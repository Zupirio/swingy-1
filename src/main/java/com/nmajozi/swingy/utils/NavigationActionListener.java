package com.nmajozi.swingy.utils;

import com.nmajozi.swingy.controller.Map;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener; //Interface
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;


public class NavigationActionListener implements ActionListener {
    private Map mapRef;
    private JTextArea displayScreen;
    private JButton[] navigationButtons;
    private JButton[] fightOrFlightButtons;

    public NavigationActionListener(Map map, JTextArea displayScreen, JButton[] navigationButtons, JButton[] fightOrFlightButtons){
        this.mapRef = map;
        this.displayScreen = displayScreen;
        this.navigationButtons = navigationButtons;
        this.fightOrFlightButtons = fightOrFlightButtons;
    }

    public void check(){
        if (this.mapRef.metVillain()){
            this.navigationButtons[0].setEnabled(false);
            this.navigationButtons[1].setEnabled(false);
            this.navigationButtons[2].setEnabled(false);
            this.navigationButtons[3].setEnabled(false);

            this.fightOrFlightButtons[0].setEnabled(true);
            this.fightOrFlightButtons[1].setEnabled(true);
            JOptionPane.showMessageDialog(null, "You met the following villain(s)\nFight OR Run");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String direction = this.navigationButtons[0].getText();
        String move = null;


        if (direction.equals("UP")){
            move = this.mapRef.move("N");
            if (move.equals("END")){
                JOptionPane.showMessageDialog(null, "\nGAME\nGame over. You survived.");
                System.exit(1);
            }
            displayScreen.setText(this.mapRef.toString());
            this.check();
        } else if (direction.equals("DOWN")){
            move = this.mapRef.move("S");
            if (move.equals("END")){
                JOptionPane.showMessageDialog(null, "\nGAME\nGame over. You survived.");
                System.exit(1);
            }
            displayScreen.setText(this.mapRef.toString());
            this.check();
        } else if (direction.equals("LEFT")){
            move = this.mapRef.move("W");
            if (move.equals("END")){
                JOptionPane.showMessageDialog(null, "\nGAME\nGame over. You survived.");
                System.exit(1);
            }
            displayScreen.setText(this.mapRef.toString());
            this.check();
        } else if (direction.equals("RIGHT")){
            move = this.mapRef.move("E");
            if (move.equals("END")){
                JOptionPane.showMessageDialog(null, "\nGAME\nGame over. You survived.");
                System.exit(1);
            }
            displayScreen.setText(this.mapRef.toString());
            this.check();
        }
    }
    
}