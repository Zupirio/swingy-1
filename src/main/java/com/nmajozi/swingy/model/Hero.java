package com.nmajozi.swingy.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.concurrent.ThreadLocalRandom;

import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import javax.validation.Validation;
import java.util.Set;
import javax.validation.ConstraintViolation;

import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;

public class Hero extends Character{
    public static final String FILENAME = "heroes.txt";
    
    private Position previousPosition = null;
    @NotNull(message = "Name cannot be null")
    @Length(min=2, max= 7, message= "Name length should not be less than 1 or greater than 7" )
    private String name = null;
    @NotNull(message = "Class cannot be null")
    @Length(min=2, max= 7, message= "Class length should not be less than 1 or greater than 7" )
    private String heroClass = null;
    @Digits(integer=5, fraction=0, message="The value of heroClass cannot be more than 5 digits")
	@Min(value=0, message="Min value of heroClass cannot be less than 0")
	@Max(value=100, message="Max value of heroClass cannot be more than 100")
    private int level;
    @Digits(integer=5, fraction=0, message="The value of level cannot be more than 3 digits")
	@Min(value=0, message="Min value of level cannot be less than 0")
    private long experience;
    @Digits(integer=5, fraction=0, message="The value of experience cannot be more than 3 digits")
	@Min(value=0, message="Min value of experience cannot be less than 0")
    private int attack;
    @Digits(integer=5, fraction=0, message="The value of level cannot be more than 3 digits")
	@Min(value=0, message="Min value of level cannot be less than 0")
    private int defence;
    @Digits(integer=5, fraction=0, message="The value of attack cannot be more than 3 digits")
	@Min(value=0, message="Min value of attack cannot be less than 0")
    private int hitPoints;

    private ValidatorFactory factory;
    private Validator validator;
    private Set<ConstraintViolation<Hero>> violations;
    
     public Hero(){
    //     this.factory = Validation.buildDefaultValidatorFactory();
    //     this.validator = factory.getValidator();
    //     this.violations = validator.validate(this);
    //     for (ConstraintViolation<Hero> violation : this.violations) {
    //         System.out.println(violation.getMessage()); 
    //     }
    }

    public Hero(String name, String heroClass, int level, long experience, int attack, int defence, int hitPoints){
        this.name = name;
        this.heroClass = heroClass;
        this.level = level;
        this.experience = experience;
        this.attack = attack;
        this.defence = defence;
        this.hitPoints = hitPoints;

        

        
    }

    public void setHero(String name, String heroClass, int level, long experience, int attack, int defence, int hitPoints){
        this.name = name;
        this.heroClass = heroClass;
        this.level = level;
        this.experience = experience;
        this.attack = attack;
        this.defence = defence;
        this.hitPoints = hitPoints;

        /*this.factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
        this.violations = validator.validate(this);
        for (ConstraintViolation<Hero> violation : this.violations) {
            System.out.println(violation.getMessage()); 
        }*/
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

        results = String.format("%s,%s,%d,%d,%d,%d,%d", this.name, this.heroClass, this.level, this.experience, this.attack, this.defence, this.hitPoints);
        return results;
    }
}