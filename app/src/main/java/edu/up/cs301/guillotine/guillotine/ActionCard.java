package edu.up.cs301.guillotine.guillotine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This defines an action card and how it can work relative to the gamestate
 *
 * @author Nathan Schmedake
 * @author Muhammed Acar
 * @author Melanie Martinell
 * @author Linnea Bair
 * @version November 2015
 */
public class ActionCard implements Serializable {
    private static final long serialVersionUID = 7L;

    private String name;
    private int image;
    public ActionCard(String givenName, int pic)
    {
        this.name = givenName;
        this.image = pic;
    }

    public int getImage(){
        return image;
    }
    public String getName() {return name; }
    public GuillotineState humanAction(GuillotineState curState){
        // make if statements for every action card

        if(name.equals("After You....")){

        }
        else if (name.equals("Bribed Guards")){

        }
        else if (name.equals("Church Support")){

        }
        else if (name.equals("Civic Pride")){

        }
        else if (name.equals("Civic Support")){

        }
        else if (name.equals("Clothing Swap")){

        }
        else if (name.equals("Confusion in Line")){

        }
        else if (name.equals("Double Feature")){

        }
        else if (name.equals("Escape!")){

        }
        else if (name.equals("Extra Cart")){

        }
        else if (name.equals("Fainting Spell")){

        }
        else if (name.equals("Fled to England")){

        }
        else if (name.equals("Forced Break")){

        }
        else if (name.equals("Foreign Support")){

        }
        else if (name.equals("Forward March")){

        }
        else if (name.equals("Fountain of Blood")){

        }
        else if (name.equals("Friend of the Queen")){

        }
        else if (name.equals("Ignoble Noble")){

        }
        else if (name.equals("Indifferent Public")){

        }
        else if (name.equals("Infighting")){

        }
        else if (name.equals("Information Exchange")){

        }
        else if (name.equals("Lack of Faith")){

        }
        else if (name.equals("Late Arrival")){

        }
        else if (name.equals("Let Them Eat Cake")){

        }
        else if (name.equals("L'Idiot")){

        }
        else if (name.equals("Majesty")){

        }
        else if (name.equals("Mass Confusion")){

        }
        else if (name.equals("Military Might")){

        }
        else if (name.equals("Military Support")){

        }
        else if (name.equals("Milling in Line")){

        }
        else if (name.equals("Missed!")){

        }
        else if (name.equals("Missing Heads")){

        }
        else if (name.equals("Opinionated Guards")){

        }
        else if (name.equals("Political Influence")){

        }
        else if (name.equals("Public Demand")){

        }
        else if (name.equals("Pushed")){

        }
        else if (name.equals("Rain Delay")){

        }
        else if (name.equals("Scarlet Pimpernel")){

        }
        else if (name.equals("Stumble")){

        }
        else if (name.equals("The Long Walk")){

        }
        else if (name.equals("'Tis a Far Better Thing")){

        }
        else if (name.equals("Tough Crowd")){

        }
        else if (name.equals("Trip")){

        }
        else if (name.equals("Was That My Name?")){

        }

        return curState;
    }
    public GuillotineState easyAIAction(GuillotineState curState){
        // make if statements for every action card
        double rand = Math.random();

        if(name.equals("After You....")){
            if (curState.getNumPlayers() == 2) {
                curState.collectNoble(0);

            }
            if (curState.getNumPlayers() == 3) {
                if (curState.getCurrentPlayer() == 1) {
                    if (rand > .5){
                        curState.collectNoble(0);
                    }
                    else{
                        curState.collectNoble(2);
                    }
                }
                else if (curState.getCurrentPlayer() == 2) {

                    if(rand>.5){
                        curState.collectNoble(0);
                    }
                    else{
                        curState.collectNoble(1);
                    }

                }
            }
            if (curState.getNumPlayers() == 4) {
                if (curState.getCurrentPlayer() == 1) {
                    if (rand < .33){
                        curState.collectNoble(0);

                    }
                    else if(rand>.33 && rand<.66){
                        curState.collectNoble(2);
                    }
                    else{
                        curState.collectNoble(3);
                    }
                } else if (curState.getCurrentPlayer() == 2) {
                    if (rand < .33){
                        curState.collectNoble(0);

                    }
                    else if(rand>.33 && rand<.66){
                        curState.collectNoble(1);
                    }
                    else{
                        curState.collectNoble(3);
                    }

                } else if(curState.getCurrentPlayer()==3){
                    if (rand < .33){
                        curState.collectNoble(0);

                    }
                    else if(rand>.33 && rand<.66){
                        curState.collectNoble(1);
                    }
                    else{
                        curState.collectNoble(2);
                    }

                }
            }
        }
        else if (name.equals("Bribed Guards")){

            Noble firstNob = curState.deathRow.get(0);
            curState.removeFromDeathRow(0);
            curState.deathRow.add(firstNob);

        }
        else if (name.equals("Church Support")){
            curState.setHasChurchSupport(curState.getCurrentPlayer());

        }
        else if (name.equals("Civic Pride")){


        }
        else if (name.equals("Civic Support")){
            curState.setHasCivicSupport(curState.getCurrentPlayer());
        }
        else if (name.equals("Clothing Swap")){

            int chosenNoble = (int)(Math.random()*(curState.deathRow.size()));

            curState.deathRow.remove(chosenNoble);
            curState.deathRow.add(chosenNoble,curState.nobleDeck.get(0));



        }
        else if (name.equals("Confusion in Line")){

            curState.shuffleDeathRow();

        }
        else if (name.equals("Double Feature")){

            if(curState.getCurrentPlayer()==1){
               curState.collectNoble(1);
                curState.collectNoble(1);

            }
            else if(curState.getCurrentPlayer()==2){
                curState.collectNoble(2);
                curState.collectNoble(2);
            }
            else if(curState.getCurrentPlayer()==3){
                curState.collectNoble(3);
                curState.collectNoble(3);
            }

        }
        else if (name.equals("Escape!")){
            int randChosenNob1 = (int)(Math.random()*(curState.deathRow.size()));
            curState.nobleDiscard.add(curState.deathRow.get(randChosenNob1));
            curState.deathRow.remove(randChosenNob1);
            int randChosenNob2 = (int)(Math.random()*(curState.deathRow.size()));
            curState.nobleDiscard.add(curState.deathRow.get(randChosenNob2));
            curState.deathRow.remove(randChosenNob2);

            curState.shuffleDeathRow();



        }
        else if (name.equals("Extra Cart")){

            if(curState.deathRow.size()<=9){
                for(int i =0;i<3;i++) {
                    curState.deathRow.add(curState.nobleDeck.get(0));
                }

            }
            else if(curState.deathRow.size()==10){
                for(int i =0;i<2;i++) {
                    curState.deathRow.add(curState.nobleDeck.get(0));
                }
            }
            else if(curState.deathRow.size()==11){
                curState.deathRow.add(curState.nobleDeck.get(0));
            }

        }
        else if (name.equals("Fainting Spell")){

        }
        else if (name.equals("Fled to England")){

            int randEscapeNob = (int)(Math.random()*curState.deathRow.size());
            curState.nobleDiscard.add(curState.deathRow.get(randEscapeNob));
            curState.deathRow.remove(randEscapeNob);

        }
        else if (name.equals("Forced Break")){


           if(curState.getNumPlayers()==2){
               int rand1 = (int)(Math.random()*curState.humanPlayerNobles.size());
               int rand2 = (int)(Math.random()*curState.computerPlayer1Nobles.size());

               curState.nobleDiscard.add(curState.humanPlayerNobles.get(rand1));
               curState.nobleDiscard.add(curState.computerPlayer1Nobles.get(rand2));
               curState.humanPlayerNobles.remove(rand1);
               curState.computerPlayer1Nobles.remove(rand2);

           }
            else if(curState.getNumPlayers()==3){
               int rand1 = (int)(Math.random()*curState.humanPlayerNobles.size());
               int rand2 = (int)(Math.random()*curState.computerPlayer1Nobles.size());
               int rand3 = (int)(Math.random()*curState.computerPlayer2Nobles.size());

               curState.nobleDiscard.add(curState.humanPlayerNobles.get(rand1));
               curState.nobleDiscard.add(curState.computerPlayer1Nobles.get(rand2));
               curState.nobleDiscard.add(curState.computerPlayer2Nobles.get(rand3));
               curState.humanPlayerNobles.remove(rand1);
               curState.computerPlayer1Nobles.remove(rand2);
               curState.computerPlayer2Nobles.remove(rand3);

           }
            else if(curState.getNumPlayers()==4){
               int rand1 = (int)(Math.random()*curState.humanPlayerNobles.size());
               int rand2 = (int)(Math.random()*curState.computerPlayer1Nobles.size());
               int rand3 = (int)(Math.random()*curState.computerPlayer2Nobles.size());
               int rand4 = (int)(Math.random()*curState.computerPlayer3Nobles.size());

               curState.nobleDiscard.add(curState.humanPlayerNobles.get(rand1));
               curState.nobleDiscard.add(curState.computerPlayer1Nobles.get(rand2));
               curState.nobleDiscard.add(curState.computerPlayer2Nobles.get(rand3));
               curState.nobleDiscard.add(curState.computerPlayer3Nobles.get(rand4));
               curState.humanPlayerNobles.remove(rand1);
               curState.computerPlayer1Nobles.remove(rand2);
               curState.computerPlayer2Nobles.remove(rand3);
               curState.computerPlayer3Nobles.remove(rand4);
           }

        }
        else if (name.equals("Foreign Support")){
            curState.setHasForeignSupport(curState.getCurrentPlayer());
        }
        else if (name.equals("Forward March")){

        }
        else if (name.equals("Fountain of Blood")){

        }
        else if (name.equals("Friend of the Queen")){

        }
        else if (name.equals("Ignoble Noble")){

        }
        else if (name.equals("Indifferent Public")){

        }
        else if (name.equals("Infighting")){

        }
        else if (name.equals("Information Exchange")){

        }
        else if (name.equals("Lack of Faith")){

        }
        else if (name.equals("Late Arrival")){

        }
        else if (name.equals("Let Them Eat Cake")){

        }
        else if (name.equals("L'Idiot")){

        }
        else if (name.equals("Majesty")){

        }
        else if (name.equals("Mass Confusion")){
            ArrayList<Noble> deathRow = curState.getDeathRow();
            int numNobles = deathRow.size();
            ArrayList<Noble> currentNobleDeck = curState.getNobleDeck();

            for(int i = 0; i< deathRow.size();i++){
                Noble card = deathRow.get(i);
                deathRow.remove(i);
                currentNobleDeck.add(card);
            }
            curState.setNobleDeck(currentNobleDeck);
            curState.shuffleNobleDeck();
            curState.createDeathRow(numNobles);
        }
        else if (name.equals("Military Might")){

        }
        else if (name.equals("Military Support")){
            curState.setHasMilitarySupport(curState.getCurrentPlayer());
        }
        else if (name.equals("Milling in Line")){

        }
        else if (name.equals("Missed!")){

        }
        else if (name.equals("Missing Heads")){

        }
        else if (name.equals("Opinionated Guards")){
            ArrayList<Noble> deathRow = curState.getDeathRow();
            Noble one = deathRow.get(0);
            Noble two = deathRow.get(1);
            Noble three = deathRow.get(2);
            Noble four = deathRow.get(3);
            ArrayList<Noble> firstFour = new ArrayList<Noble>();
            firstFour.add(one);
            firstFour.add(two);
            firstFour.add(three);
            firstFour.add(four);
            Collections.shuffle(firstFour);
            curState.removeFromDeathRow(0);
            curState.removeFromDeathRow(1);
            curState.removeFromDeathRow(2);
            curState.removeFromDeathRow(3);
            deathRow.add(0,firstFour.get(0));
            deathRow.add(1,firstFour.get(1));
            deathRow.add(2,firstFour.get(3));
            deathRow.add(3,firstFour.get(4));
        }
        else if (name.equals("Political Influence")){

        }
        else if (name.equals("Public Demand")){

        }
        else if (name.equals("Pushed")){

        }
        else if (name.equals("Rain Delay")){

        }
        else if (name.equals("Scarlet Pimpernel")){

        }
        else if (name.equals("Stumble")){

        }
        else if (name.equals("The Long Walk")){

        }
        else if (name.equals("'Tis a Far Better Thing")){

        }
        else if (name.equals("Tough Crowd")){

        }
        else if (name.equals("Trip")){

        }
        else if (name.equals("Was That My Name?")){
            ArrayList<Noble> deathRow = curState.getDeathRow();
            int randIndex = 3+(int)(Math.random()*(deathRow.size()-1));
            double randSpaces = Math.random();
            if (randSpaces>=.33)
            {
                deathRow.add((randIndex-1), deathRow.get(randIndex));
            }
            else if (randSpaces>.33 && randSpaces<.67)
            {
                deathRow.add((randIndex - 2), deathRow.get(randIndex));
            }
            else if (randSpaces>=.67)
            {
                deathRow.add((randIndex-3), deathRow.get(randIndex));
            }
        }

        return curState;
    }
    public GuillotineState hardAIAction(GuillotineState curState){
        // make if statements for every action card

        if(name.equals("After You....")){

        }
        else if (name.equals("Bribed Guards")){

        }
        else if (name.equals("Church Support")){

        }
        else if (name.equals("Civic Pride")){

        }
        else if (name.equals("Civic Support")){

        }
        else if (name.equals("Clothing Swap")){

        }
        else if (name.equals("Confusion in Line")){

        }
        else if (name.equals("Double Feature")){

        }
        else if (name.equals("Escape!")){

        }
        else if (name.equals("Extra Cart")){

        }
        else if (name.equals("Fainting Spell")){

        }
        else if (name.equals("Fled to England")){

        }
        else if (name.equals("Forced Break")){

        }
        else if (name.equals("Foreign Support")){

        }
        else if (name.equals("Forward March")){

        }
        else if (name.equals("Fountain of Blood")){

        }
        else if (name.equals("Friend of the Queen")){

        }
        else if (name.equals("Ignoble Noble")){

        }
        else if (name.equals("Indifferent Public")){

        }
        else if (name.equals("Infighting")){

        }
        else if (name.equals("Information Exchange")){

        }
        else if (name.equals("Lack of Faith")){

        }
        else if (name.equals("Late Arrival")){

        }
        else if (name.equals("Let Them Eat Cake")){

        }
        else if (name.equals("L'Idiot")){

        }
        else if (name.equals("Majesty")){

        }
        else if (name.equals("Mass Confusion")){

        }
        else if (name.equals("Military Might")){

        }
        else if (name.equals("Military Support")){

        }
        else if (name.equals("Milling in Line")){

        }
        else if (name.equals("Missed!")){

        }
        else if (name.equals("Missing Heads")){

        }
        else if (name.equals("Opinionated Guards")){

        }
        else if (name.equals("Political Influence")){

        }
        else if (name.equals("Public Demand")){

        }
        else if (name.equals("Pushed")){

        }
        else if (name.equals("Rain Delay")){

        }
        else if (name.equals("Scarlet Pimpernel")){

        }
        else if (name.equals("Stumble")){

        }
        else if (name.equals("The Long Walk")){

        }
        else if (name.equals("'Tis a Far Better Thing")){

        }
        else if (name.equals("Tough Crowd")){

        }
        else if (name.equals("Trip")){

        }
        else if (name.equals("Was That My Name?")){

        }

        return curState;
    }
}
