package com.nmajozi.swingy.utils;

import com.nmajozi.swingy.model.Hero;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.event.ActionListener; //Interface
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;


public class SelectHeroActionListener implements ActionListener {
    private JFrame selectHeroWindow;
    private Hero heroRef;
    private JComboBox heroDetails;

    public SelectHeroActionListener(JFrame selectHeroWindow, Hero hero, JComboBox heroDetails){
        this.selectHeroWindow = selectHeroWindow;
        this.heroRef = hero;
        this.heroDetails = heroDetails;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String heroStringDetails = String.valueOf(this.heroDetails.getSelectedItem());
        String heroChosen = heroStringDetails.replaceFirst("[0-9]* - ", "");
        String heroChosenItems[] = heroChosen.split(",");


        String nameData  = heroChosenItems[0];
        String classData = heroChosenItems[1];
        int levelData  = Integer.parseInt(heroChosenItems[2]);
        int experienceData  = Integer.parseInt(heroChosenItems[3]); //long
        int attackData  = Integer.parseInt(heroChosenItems[4]);
        int defenceData  = Integer.parseInt(heroChosenItems[5]);
        int hitPointsData  = Integer.parseInt(heroChosenItems[6]);
        this.heroRef = new Hero(nameData, classData, levelData, experienceData, attackData, defenceData, hitPointsData);
        
        JOptionPane.showMessageDialog(null, "Hero Created");
        this.selectHeroWindow .dispose();
    }
    
}