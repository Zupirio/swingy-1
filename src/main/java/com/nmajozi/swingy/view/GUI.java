package com.nmajozi.swingy.view;

import com.nmajozi.swingy.model.Hero;
import com.nmajozi.swingy.utils.Tools;
import com.nmajozi.swingy.controller.Map;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener; //Interface
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class GUI implements ViewMode {
    private final String name = "GUI";
    private Hero hero = null;

    private JFrame window;

    public GUI(){}

    public void init(){
        // Window
        final JFrame introWindow = new JFrame(this.name + " MODE");
        introWindow.setSize(500, 120);
        introWindow.setLocationRelativeTo(null);
        introWindow.setVisible(true);

        // Buttons & Events
        JButton createHeroButton = new JButton("Create Hero");
        createHeroButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                introWindow.dispose();
                GUI.createHero();
            }
        });
        JButton selectHeroButton = new JButton("Select Hero");
        selectHeroButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                introWindow.dispose();
                GUI.selectHero();
            }
        });
        

        // Layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createHeroButton);
        buttonPanel.add(selectHeroButton);
        introWindow.add(buttonPanel, BorderLayout.CENTER);
        introWindow.pack();
    }

    public static void createHero(){
         // Window
         final JFrame introWindow = new JFrame("CREATE HERO");
         introWindow.setSize(500, 120);
         introWindow.setLocationRelativeTo(null);
         introWindow.setVisible(true);
 
         // Buttons & Events
         JButton createHeroButton = new JButton("Create Hero");
         createHeroButton.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e){
                 
             }
         });
         
 
         // Layout
         JPanel buttonPanel = new JPanel();
         buttonPanel.add(createHeroButton);
         introWindow.add(buttonPanel, BorderLayout.CENTER);
         introWindow.pack();
    }

    public static void selectHero(){

    }

    public void run(){
        this.init();
    }
}