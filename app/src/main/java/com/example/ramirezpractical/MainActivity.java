package com.example.ramirezpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttonsMatrix = new Button[10][10];
    private int startingIndex=0, endingIndex=9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                String buttonID = "button"+ i + j;
                int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttonsMatrix[i][j] = findViewById(resourceID);
                buttonsMatrix[i][j].setOnClickListener(this);
                buttonsMatrix[i][j].setText(Character.toString(randomMaze()));
                buttonsMatrix[i][j].setTextScaleX(0);

                    if(i == 0 && j == startingIndex ){
                        buttonsMatrix[i][j].setText("S");
                        buttonsMatrix[i][j].setBackgroundColor(0xF000FF0);
                        buttonsMatrix[i][j].setTextScaleX(1);
                    }

                    if(i==10-1 && j == endingIndex) {
                        buttonsMatrix[i][j].setText("E");
                        buttonsMatrix[i][j].setBackgroundColor(0xF000FF0);
                        buttonsMatrix[i][j].setTextScaleX(1);
                    }
            }
        }
    }



    public void onClick (View view) {
        Toast toastSuccess = Toast.makeText(getApplicationContext(), "Valid Path!", Toast.LENGTH_SHORT);
        Toast toastFail = Toast.makeText(getApplicationContext(), "Invalid Path!", Toast.LENGTH_SHORT);


        traversePath(buttonsMatrix, startingIndex, endingIndex);
        if(((Button) view).getText().toString().equals("1")){
           toastSuccess.show();
           ((Button) view).setText("|");
            ((Button) view).setTextScaleX(1);
           ((Button) view).setBackgroundColor(0xFF00FF00);
        }

        else {
            toastFail.show();
            ((Button) view).setBackgroundColor(0xFFFFFF00);
            ((Button) view).setText("X");
            ((Button) view).setTextScaleX(1);
        }

    }


        /*if(((Button) view).getText().toString().equals("S") ||((Button) view).getText().toString().equals("E"))
            ((Button) view).setBackgroundColor(0xF000FF0);
         if (((Button) view).getText().equals("1")) {
           ((Button) view).setBackgroundColor(0xFF00FF00);
           ((Button) view).setText("|");
        }
        else
            ((Button) view).setText("");

        if(traversePath(buttonsMatrix, startingIndex, endingIndex)){

        }*//**/


    public char randomMaze () {
        Random random = new Random();

        String charPath = "10";

        int randomInt = random.nextInt(charPath.length());
        char randomChar = charPath.charAt(randomInt);

        return randomChar;

    }

    public boolean traversePath(Button[][] matrix, int row, int col){
        if (spotValidator(matrix, row, col)) {
            if (row < 10 && col < 10) {
                return true;
            }

            matrix[row][col].setText("*");

            boolean returnValue = traversePath(matrix, row - 1, col);


            if (!returnValue) {
                returnValue = traversePath(matrix, row + 1, col);
            }

            if (!returnValue) {
                returnValue = traversePath(matrix, row, col - 1);
            }

            if (!returnValue) {
                returnValue = traversePath(matrix, row, col + 1);
            }

            if (returnValue) {
                matrix[row][col].setText("p");
            }

            return returnValue;
        }
        return false;
    }


    /*public void onClick(View view) {
        Button butt = (Button) view;
        switch (butt.getId()) {
            case R.id.button01:
                button01.setOnClickListener(this);
                button01.setBackgroundColor(0xFF00FF00);
                button01.setText("|");
                break;
            case R.id.button02:
                button02.setBackgroundColor(0xFF00FF00);
                break;
            case R.id.button03:
                button03.setBackgroundColor(0xFF00FF00);
                break;
            case R.id.button04:
                button04.setBackgroundColor(0xFF00FF00);
                break;
            case R.id.button05:
                button05.setBackgroundColor(0xFF00FF00);
                button05.setText("|");
                break;
            case R.id.button06:
                button06.setBackgroundColor(0xFF00FF00);
                button06.setText("|");
                break;
            case R.id.button07:
                button07.setBackgroundColor(0xFF00FF00);
                button07.setText("|");
                break;

            case R.id.button08:
                button08.setBackgroundColor(0xFF00FF00);
                button08.setText("|");
                break;

            /*case R.id.button9:
                button9.setBackgroundColor(0xFF00FF00);
                break;
            case R.id.button10:
                button10.setBackgroundColor(0xFF00FF00);
                break;
            case R.id.button11:
                button11.setBackgroundColor(0xFF00FF00);
                break;
            case R.id.button12:
                button12.setBackgroundColor(0xFF00FF00);
                break;
            case R.id.button13:
                button13.setBackgroundColor(0xFF00FF00);
                break;
            case R.id.button14:
                button14.setBackgroundColor(0xFF00FF00);
                break;
            case R.id.button15:
                button15.setBackgroundColor(0xFF00FF00);
                break;
            case R.id.button16:
                button16.setBackgroundColor(0xFF00FF00);
                break;
            case R.id.button17:
                button17.setBackgroundColor(0xFF00FF00);
                break;
            case R.id.button18:
                button18.setBackgroundColor(0xFF00FF00);
                button18.setText("|");
                break;
            case R.id.button19:
                button19.setBackgroundColor(0xFF00FF00);
                button19.setText("|");
                break;
            case R.id.button20:
                button20.setBackgroundColor(0xFF00FF00);
                button20.setTextColor(0x000000);
                break;
        }
    }*/

        public boolean spotValidator (Button[][] matrix, int row, int col){
            if (row >= 0 && row < 10 && col >= 0 && col < 10) {
                return matrix[row][col].equals("1");
            }
            return false;
        }


    }



