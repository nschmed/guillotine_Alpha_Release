package edu.up.cs301.guillotine.guillotine;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import edu.up.cs301.guillotine.R;

//import edu.up.cs301.guillotine.R;
//import com.example.administrator.guillotine.R;

/**
 * This is a different version of the game screen.
 *
 * @author Nathan Schmedake
 * @author Muhammed Acar
 * @author Melanie Martinell
 * @author Linnea Bair
 * @version November 2015
 */

public class MainActivity extends Activity {

    Intent intent2;

    private TextView promptTextBox;
    private Spinner yourActionCards;
    private Spinner yourNobleCards;
    private TextView player2Score;
    private TextView player3Score;
    private TextView player4Score;
    private TextView humanPlayerScore;
    private FrameLayout popUpActionCard;
    private Button pass;
    private ImageView imageofActionCardChosen;
    private ImageView imageofNobleCardChosen;
    private ArrayList<String> yourActionCardNames;
    private ArrayList<String> yourNobleCardNames;
    private ActionCard actionCardChosen;
    private Noble nobleCardChosen;
    private TextView userName;
    private int numCompPlayers;
    private int difficulty;
    private String name;

    private GuillotineLocalGame localGame;


    private ImageView noble1;
    private ImageView noble2;
    private ImageView noble3;
    private ImageView noble4;
    private ImageView noble5;
    private ImageView noble6;
    private ImageView noble7;
    private ImageView noble8;
    private ImageView noble9;
    private ImageView noble10;
    private ImageView noble11;
    private ImageView noble12;

    private FrameLayout popUpNobleZoomed;
    public static GuillotineState state;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent2 = getIntent();
        int littleArray[] = intent2.getIntArrayExtra("values");
        String name = intent2.getStringExtra("name");

        promptTextBox = (TextView) findViewById(R.id.PromptTextBox);
        userName = (TextView)findViewById(R.id.userName);


        player2Score = (TextView) findViewById(R.id.player2NumCards);
        player3Score = (TextView) findViewById(R.id.player3NumCards);
        player4Score = (TextView) findViewById(R.id.player4NumCards);
        humanPlayerScore = (TextView)findViewById(R.id.humanScore);
        popUpActionCard = (FrameLayout) findViewById(R.id.LayoutForActionCard);
        popUpNobleZoomed = (FrameLayout) findViewById(R.id.FrameLayoutZoomNoble);


        //set the nobles
        noble1 = (ImageView) findViewById(R.id.noble1);
        noble2 = (ImageView) findViewById(R.id.noble2);
        noble3 = (ImageView) findViewById(R.id.noble3);
        noble4 = (ImageView) findViewById(R.id.noble4);
        noble5 = (ImageView) findViewById(R.id.noble5);
        noble6 = (ImageView) findViewById(R.id.noble6);
        noble7 = (ImageView) findViewById(R.id.noble7);
        noble8 = (ImageView) findViewById(R.id.noble8);
        noble9 = (ImageView) findViewById(R.id.noble9);
        noble10 = (ImageView) findViewById(R.id.noble10);
        noble11 = (ImageView) findViewById(R.id.noble11);
        noble12 = (ImageView) findViewById(R.id.noble12);




        imageofActionCardChosen = (ImageView) findViewById(R.id.imageViewForActionCardChosen);
        imageofNobleCardChosen = (ImageView) findViewById(R.id.ImageOfZoomedNoble);
        //makes sure the popup layout is not visible until button is clicked
        popUpActionCard.setVisibility(View.INVISIBLE);
        popUpNobleZoomed.setVisibility(View.INVISIBLE);
        pass = (Button) findViewById(R.id.PassButton);
        //sets the orientation of the screen to landscape
        lockOrientationLandscape(MainActivity.this);
        state = new GuillotineState(numCompPlayers, name, difficulty);
        if(state!=null) {
            userName.setText(state.getUsername()+"");
        }

        //change the length based on how many nobles possible
        //and action cards possible. I don't know how many.
        yourActionCardNames = new ArrayList<String>();
        yourNobleCardNames = new ArrayList<String>();

        yourNobleCardNames.add("---Noble Cards---");
        yourActionCardNames.add("---Action Cards---");

        setDeathRowLine();
        createActionSpinner();
        createNobleSpinner();
        addListenerOnActionSelected();
        addListenerOnNobleSelected();
        setScores();


    }

    private void setDeathRowLine() {
        //set the nobles image based on what was initialized in
        //the gamestate
        if(state!=null) {

            if(state.deathRow.size()>=1) {
                noble1.setImageResource(state.deathRow.get(0).getImage());
            }
            else if(state.deathRow.size()<1){
                noble1.setImageResource(0);
                noble1.setClickable(false);
                state.setDay(state.getDay()+1);
                if(state.isGameOver()){
                    startActivity(new Intent(this, GameOver.class));
                }
            }
            if(state.deathRow.size()>=2) {
                noble2.setImageResource(state.deathRow.get(1).getImage());
            }
            else if(state.deathRow.size()<2){
                noble2.setImageResource(0);
                noble2.setClickable(false);
            }
            if(state.deathRow.size()>=3) {
                noble3.setImageResource(state.deathRow.get(2).getImage());
            }
            else if(state.deathRow.size()<3){
                noble3.setImageResource(0);
                noble3.setClickable(false);
            }
            if(state.deathRow.size()>=4) {
                noble4.setImageResource(state.deathRow.get(3).getImage());
            }
            else if(state.deathRow.size()<4){
                noble4.setImageResource(0);
                noble4.setClickable(false);
            }
            if(state.deathRow.size()>=5) {
                noble5.setImageResource(state.deathRow.get(4).getImage());
            }
            else if(state.deathRow.size()<5){
                noble5.setImageResource(0);
                noble5.setClickable(false);
            }
            if(state.deathRow.size()>=6) {
                noble6.setImageResource(state.deathRow.get(5).getImage());
            }
            else if(state.deathRow.size()<6){
                noble6.setImageResource(0);
                noble6.setClickable(false);
            }
            if(state.deathRow.size()>=7) {
                noble7.setImageResource(state.deathRow.get(6).getImage());
            }
            else if(state.deathRow.size()<7){
                noble7.setImageResource(0);
                noble7.setClickable(false);
            }
            if(state.deathRow.size()>=8) {
                noble8.setImageResource(state.deathRow.get(7).getImage());
            }
            else if(state.deathRow.size()<8){
                noble8.setImageResource(0);
                noble8.setClickable(false);
            }
            if(state.deathRow.size()>=9) {
                noble9.setImageResource(state.deathRow.get(8).getImage());
            }
            else if(state.deathRow.size()<9){
                noble9.setImageResource(0);
                noble9.setClickable(false);
            }
            if(state.deathRow.size()>=10) {
                noble10.setImageResource(state.deathRow.get(9).getImage());
            }
            else if(state.deathRow.size()<10){
                noble10.setImageResource(0);
                noble10.setClickable(false);
            }
            if(state.deathRow.size()>=11) {
                noble11.setImageResource(state.deathRow.get(10).getImage());
            }
            else if(state.deathRow.size()<11){
                noble11.setImageResource(0);
                noble11.setClickable(false);
            }
            if(state.deathRow.size()>=12) {
                noble12.setImageResource(state.deathRow.get(11).getImage());
            }
            else if(state.deathRow.size()<12){
                noble12.setImageResource(0);
                noble12.setClickable(false);
            }
        }

    }

    public void setScores() {

        if(state!=null){

            player2Score.setText(state.getComputerPlayer1Score() + "");
            player3Score.setText(state.getComputerPlayer2Score() + "");
            player4Score.setText(state.getComputerPlayer3Score() + "");
            humanPlayerScore.setText(state.getHumanPlayerScore() + "");

        }
    }

    public void createActionSpinner(){

        yourActionCards = (Spinner) findViewById(R.id.spinnerYourActions);
        if(state!=null) {
            ArrayList<ActionCard> hand = state.getHumanPlayerHand();
            for (int i = 0; i < hand.size(); i++) {

                yourActionCardNames.add(hand.get(i).getName());
            }
        }
        setAdapterAction();
    }
    public void createNobleSpinner(){

        yourNobleCards = (Spinner) findViewById(R.id.spinnerYourNobles);
        if(state!=null) {
            ArrayList<Noble> nobles = state.getHumanPlayerNobles();
            for (int i = 0; i < nobles.size(); i++) {
                yourNobleCardNames.add(nobles.get(i).getNobleName());
            }

        }
        setAdapterNoble();
    }

    //set action card spinner
    public void setAdapterAction() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, yourActionCardNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // bind the spinner and adapter
        yourActionCards.setAdapter(adapter);
    }

    public void setAdapterNoble() {
        //set noble card spinner
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
                yourNobleCardNames);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // bind the spinner and adapter
        yourNobleCards.setAdapter(adapter2);
    }
    public void addListenerOnActionSelected(){
        yourNobleCards.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if (position == 0) {

                } else {
                    if (state != null) {
                        nobleCardChosen = state.getHumanPlayerNobles().get(position - 1);
                        imageofNobleCardChosen.setImageResource(nobleCardChosen.getImage());

                    }

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    public void addListenerOnNobleSelected(){
        yourActionCards.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if (position == 0) {

                } else {
                    if (state != null) {
                        for (int i = 0; i < state.getHumanPlayerHand().size(); i++) {

                            actionCardChosen = state.getHumanPlayerHand().get(position - 1);
                            imageofActionCardChosen.setImageResource(actionCardChosen.getImage());

                        }
                    }


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    public static void lockOrientationLandscape(Activity activity) {
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }


    public void nobleOne(View view) {

        if(state!=null) {
            imageofNobleCardChosen.setImageResource(state.deathRow.get(0).getImage());
        }
        popUpNobleZoomed.setVisibility(view.VISIBLE);
        clickableDeathRow(false);

    }

    public void nobleTwo(View view) {
        if(state!=null) {
            imageofNobleCardChosen.setImageResource(state.deathRow.get(1).getImage());
        }
        popUpNobleZoomed.setVisibility(view.VISIBLE);
        clickableDeathRow(false);

    }

    public void nobleThree(View view) {
        if(state!=null) {
            imageofNobleCardChosen.setImageResource(state.deathRow.get(2).getImage());
        }
        popUpNobleZoomed.setVisibility(view.VISIBLE);
        clickableDeathRow(false);

    }

    public void nobleFour(View view) {
        imageofNobleCardChosen.setImageResource(state.deathRow.get(3).getImage());
        popUpNobleZoomed.setVisibility(view.VISIBLE);
        clickableDeathRow(false);

    }

    public void nobleFive(View view) {
        if(state!=null) {
            imageofNobleCardChosen.setImageResource(state.deathRow.get(4).getImage());
        }
        popUpNobleZoomed.setVisibility(view.VISIBLE);
        clickableDeathRow(false);

    }

    public void nobleSix(View view) {
        if(state!=null) {
            imageofNobleCardChosen.setImageResource(state.deathRow.get(5).getImage());
        }
        popUpNobleZoomed.setVisibility(view.VISIBLE);
        clickableDeathRow(false);

    }

    public void nobleSeven(View view) {
        if(state!=null) {
            imageofNobleCardChosen.setImageResource(state.deathRow.get(6).getImage());
        }
        popUpNobleZoomed.setVisibility(view.VISIBLE);
        clickableDeathRow(false);

    }

    public void nobleEight(View view) {
        if(state!=null) {
            imageofNobleCardChosen.setImageResource(state.deathRow.get(7).getImage());
        }
        popUpNobleZoomed.setVisibility(view.VISIBLE);
        clickableDeathRow(false);

    }

    public void nobleNine(View view) {
        if(state!=null) {
            imageofNobleCardChosen.setImageResource(state.deathRow.get(8).getImage());
        }
        popUpNobleZoomed.setVisibility(view.VISIBLE);
        clickableDeathRow(false);

    }

    public void nobleTen(View view) {
        if(state!=null) {
            imageofNobleCardChosen.setImageResource(state.deathRow.get(9).getImage());
        }
        popUpNobleZoomed.setVisibility(view.VISIBLE);
        clickableDeathRow(false);

    }

    public void nobleEleven(View view) {
        if(state!=null) {
            imageofNobleCardChosen.setImageResource(state.deathRow.get(10).getImage());
        }
        popUpNobleZoomed.setVisibility(view.VISIBLE);
        clickableDeathRow(false);

    }

    public void nobleTwelve(View view) {
        if(state!=null) {
            imageofNobleCardChosen.setImageResource(state.deathRow.get(11).getImage());
        }
        popUpNobleZoomed.setVisibility(view.VISIBLE);
        clickableDeathRow(false);

    }

    //chooses the noble that the spinner is currently on
    public void chooseNobleButton(View view) {
        popUpNobleZoomed.setVisibility(view.VISIBLE);
        clickableDeathRow(false);


    }

    //opens up a new window in which the action card should be shown
    //as an image in the imageView: imageOfActionCardChosen
    public void showActionButton(View view) {

        popUpActionCard.setVisibility(view.VISIBLE);
        clickableDeathRow(false);
        // pass.setVisibility(view.INVISIBLE);

    }

    public void passButton(View view) {
        //collect first noble in line
        //update score
        //add noble to spinner
        if(state!=null){

            Noble firstNoble = state.deathRow.get(0);

            state.collectNoble(0);
            state.addNobleScoreHuman(firstNoble.getNoblePoints());

            updateNobleSpinner();
            setDeathRowLine();
            setScores();


            promptTextBox.setText("You have opted to pass your turn.");


        }

    }

    public void clickableDeathRow(boolean click){

        noble1.setClickable(click);
        noble2.setClickable(click);
        noble3.setClickable(click);
        noble4.setClickable(click);
        noble5.setClickable(click);
        noble6.setClickable(click);
        noble7.setClickable(click);
        noble8.setClickable(click);
        noble9.setClickable(click);
        noble10.setClickable(click);
        noble11.setClickable(click);
        noble12.setClickable(click);
    }

    public void updateNobleSpinner() {
        if(state!=null) {
            for (int i = yourNobleCardNames.size()-1; i <= state.getHumanPlayerNobles().size()-1; i++) {
                yourNobleCardNames.add(state.getHumanPlayerNobles().get(i).getNobleName());

            }
            setAdapterNoble();
        }
    }

    public void updateActionSpinner() {
        if(state!=null) {
            for (int i = yourActionCardNames.size()-1; i <= state.getHumanPlayerHand().size()-1; i++) {
                yourActionCardNames.add(state.getHumanPlayerHand().get(i).getName());

            }
            setAdapterAction();
        }
    }

    public void endButton(View view) {

        finish();

    }

    public void helpButton(View view) {


    }

    //images that were turned button on the left hand side
    //allows the user to get a new action card if prompted
    public void actionCardDrawButton(View view) {

        if(state!=null) {
            state.getHumanPlayerHand().add(state.actionDeck.get(0));
            state.actionDeck.remove(0);
        }
        updateActionSpinner();

    }

    //chooses the action card displayed on the pop up screen
    //to play
    public void chooseActionCardToPlay(View view) {

        //Use actionCardChosen to decide what action to do

    }

    //chooses the noble card displayed on the pop up screen
    //to be played
    public void chooseNobleFromZoomedNoble(View view) {

        //Use nobleCardChosen to decide what action to do

    }

    //pop up will disappear
    public void goBackToPlay(View view) {
        popUpActionCard.setVisibility(view.INVISIBLE);
        clickableDeathRow(true);
        //pass.setVisibility(view.VISIBLE);

    }

    public void goBackFromZoomedNoble(View view) {
        popUpNobleZoomed.setVisibility(view.INVISIBLE);
        clickableDeathRow(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}



