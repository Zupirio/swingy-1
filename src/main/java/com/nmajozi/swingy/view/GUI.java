package com.nmajozi.swingy.view;

import com.nmajozi.swingy.utils.CreateHeroActionListener;
import com.nmajozi.swingy.model.Hero;
import com.nmajozi.swingy.utils.Tools;
import com.nmajozi.swingy.controller.Map;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener; //Interface
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;

public class GUI implements ViewMode {
    private final String name = "GUI";
    private static Hero hero = new Hero();

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
        JFrame introWindow = new JFrame("CREATE HERO");
        introWindow.setSize(500, 120);
        introWindow.setLocationRelativeTo(null);
        introWindow.setVisible(true);

        // Labels & Inputs
        JLabel nameLabel = new JLabel("Enter Name");
        JTextField nameInput = new JTextField(20);
        JLabel classLabel = new JLabel("Enter Class");
        JTextField classInput = new JTextField(20);

        JLabel levelLabel = new JLabel("Choose Level");
        JComboBox levelInput = new JComboBox(new String[]{"1", "2", "3", "4", "5", "6"});

        JLabel experienceLabel = new JLabel("Choose Experience");
        JComboBox experienceInput = new JComboBox(new String[]{"5", "10", "15", "20"});

        JLabel attackLabel = new JLabel("Choose Attack");
        JComboBox attackInput = new JComboBox(new String[]{"5", "10", "15", "20"});

        JLabel defenceLabel = new JLabel("Choose Defence");
        JComboBox defenceInput = new JComboBox(new String[]{"5", "10", "15", "20"});

        JLabel hitPointsLabel = new JLabel("Choose Hit Points");
        JComboBox hitPointsInput = new JComboBox(new String[]{"5", "10", "15", "20"});

        // Buttons & Events
        JButton createHeroButton = new JButton("Create Hero");
        createHeroButton.addActionListener(new CreateHeroActionListener(GUI.hero, nameInput, classInput, levelInput, experienceInput, attackInput,defenceInput, hitPointsInput));
         
         // Layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        JPanel namePanel = new JPanel();
        namePanel.add(nameLabel);
        namePanel.add(nameInput);
        detailsPanel.add(namePanel);
        JPanel classPanel = new JPanel();
        classPanel.add(classLabel);
        classPanel.add(classInput);
        detailsPanel.add(classPanel);
        JPanel levelPanel = new JPanel();
        levelPanel.add(levelLabel);
        levelPanel.add(levelInput);
        detailsPanel.add(levelPanel);
        JPanel experiencePanel = new JPanel();
        experiencePanel.add(experienceLabel);
        experiencePanel.add(experienceInput);
        detailsPanel.add(experiencePanel);
        JPanel attackPanel = new JPanel();
        attackPanel.add(attackLabel);
        attackPanel.add(attackInput);
        detailsPanel.add(attackPanel);
        JPanel defencePanel = new JPanel();
        defencePanel.add(defenceLabel);
        defencePanel.add(defenceInput);
        detailsPanel.add(defencePanel);
        JPanel hitPointsPanel = new JPanel();
        hitPointsPanel.add(hitPointsLabel);
        hitPointsPanel.add(hitPointsInput);
        detailsPanel.add(hitPointsPanel);


        mainPanel.add(detailsPanel, BorderLayout.CENTER);
        mainPanel.add(createHeroButton, BorderLayout.SOUTH);
        introWindow.add(mainPanel);
        introWindow.pack();
    }

    public static void selectHero(){

    }

    public void run(){
        this.init();
    }
}