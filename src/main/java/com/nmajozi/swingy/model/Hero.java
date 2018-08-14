package com.nmajozi.swingy.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.concurrent.ThreadLocalRandom;

import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import javax.validation.Validation;
import java.util.Set;
import javax.validation.ConstraintViolation;

public class Hero extends Character{
    public static final String FILENAME = "heroes.txt";
    
    private Position previousPosition = null;
    @NotNull(message = "Name cannot be null")
    private String name = null;
    @NotNull(message = "Class cannot be null")
    private String heroClass = null;
    @Size(min = 1, max = 5, message = "Level length should not be less than 1 or greater than 5")
    private int level;
    private long experience;
    private int attack;
    private int defence;
    private int hitPoints;

    private ValidatorFactory factory;
    private Validator validator;
    private Set<ConstraintViolation<Hero>> violations;
    
    public Hero(){
        this.factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
        this.violations = validator.validate(this);
        for (ConstraintViolation<Hero> violation : this.violations) {
            System.out.println(violation.getMessage()); 
        }
    }

    public Hero(String name, String heroClass, int level, long experience, int attack, int defence, int hitPoints){
        this.name = name;
        this.heroClass = heroClass;
        this.level = level;
        this.experience = experience;
        this.attack = attack;
        this.defence = defence;
        this.hitPoints = hitPoints;

        // ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        // Validator validator = factory.getValidator();
        // Set<ConstraintViolation<Hero>> violations = validator.validate(this);
        // for (ConstraintViolation<Hero> violation : violations) {
        //     System.out.println(violation.getMessage()); 
        // }

        this.factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
        this.violations = validator.validate(this);
        for (ConstraintViolation<Hero> violation : this.violations) {
            System.out.println(violation.getMessage()); 
        }
    }

    public void setHero(String name, String heroClass, int level, long experience, int attack, int defence, int hitPoints){
        this.name = name;
        this.heroClass = heroClass;
        this.level = level;
        this.experience = experience;
        this.attack = attack;
        this.defence = defence;
        this.hitPoints = hitPoints;
    }

    public String heroStats(){
        String results = null;

        results = "--- Hero Stats ---\n";
        results += String.format("Name: %s\n", this.name);
        results += String.format("Class: %s\n", this.heroClass);
        results += String.format("Level: %s\n", this.level);
        results += String.format("Experience: %s\n", this.experience);
        results += String.format("Attack: %s\n", this.attack);
        results += String.format("Defence: %s\n", this.defence);
        results += String.format("Hit Points: %s\n", this.hitPoints);
        return results;
    }

    public void takeArtifacts(int weapon, int armor, int helm){
        this.attack += weapon;
        this.defence += armor;
        this.hitPoints += helm;
    }

    public int getAttackValue(){
        return this.attack;
    }

    public int getDefenceValue(){
        return this.defence;
    }

    public int getHitPoints(){
        return this.hitPoints;
    }

    public void incrementLevel(){
        this.level++;
    }

    public int getLevel(){
        return this.level;
    }

    public void makePreviousPositionNull(){
        this.previousPosition = null;
    }

    public void setPreviousPosition(int row, int column){
        if (this.previousPosition == null)
            this.previousPosition = new Position(row, column);
        else {
            this.previousPosition.setRow(row);
            this.previousPosition.setColumn(column);
        }
    }

    public Position getPreviousPosition(){
        return this.previousPosition;
    }

    public void changePosition(int row, int column){
        this.setPreviousPosition(this.getRow(), this.getColumn());

        this.position.changeRow(row);
        this.position.changeColum(column);
    }

    public String toString(){
        String results = null;

        results = String.format("%s,%s,%s,%d,%d,%d,%d", this.name, this.heroClass, this.level, this.experience, this.attack, this.defence, this.hitPoints);
        return results;
    }
}