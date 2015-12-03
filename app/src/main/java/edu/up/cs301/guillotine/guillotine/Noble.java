package edu.up.cs301.guillotine.guillotine;

import java.io.Serializable;

/**
 * This prototype defines a noble and is inherited from by the different colored nobles.
 *
 * @author Nathan Schmedake
 * @author Muhammed Acar
 * @author Melanie Martinell
 * @author Linnea Bair
 * @version November 2015
 */
public class Noble implements Serializable{

    private static final long serialVersionUID = 7777L;
    protected String name;
    protected String color;
    protected int points;
    int image;

    //constructor
    public Noble(String name, String color, int points, int pic) {
        this.name = name;
        this.color = color;
        this.points = points;
        this.image = pic;
    }

    //name getter
    public String getNobleName() {
        return name;
    }

    //color getter
    public String getNobleColor() {
        return color;
    }

    //points getter
    public int getNoblePoints() {
        return points;
    }

    //points setter
    public void setNoblePoints(Integer points) {
        this.points = points;
    }

    //image getter
    public int getImage(){ return image;}

    //action if there is one, modifies Game State
    public GuillotineState nobleAction(GuillotineState curState){
        if (this.name.equals("Palace Guard")) {

        }
        else if(this.name.equals("The Clown")){

        }
        else if(this.name.equals("Tragic Figure")){

        }
        else if(this.name.equals("Rival Executioner")){

        }
        else if(this.name.equals("lady")){

        }
        else if(this.name.equals("Robespierre")){

        }
        else if(this.name.equals("Lady in Waiting")){

        }
        else if(this.name.equals("Fast Noble")){

        }
        else if(this.name.equals("Lord")){

        }
        else if(this.name.equals("Countess")){

        }
        else if(this.name.equals("Count")){

        }
        else if(this.name.equals("General")){

        }
        else if(this.name.equals("Captain of the Guard")){

        }
        return curState;
    }
}
