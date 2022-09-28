package com.example.javamcqajith;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String TAG = MainActivity.class.getSimpleName();
    TextView tvQuestion;
    RadioGroup radioGroup;
    RadioButton radioButton1,radioButton2,radioButton3,radioButton4;
    ImageView ImageviewLeft,ImageViewRight;
    Button btCheck;

    int currentIndex = 0;

    String [] question = new String[]{

            "1. Who invented Java Programming?",
            "2. Which component is used to compile, debug and execute the java programs?",
            "3. Which one of the following is not a Java feature?",
            "4. Which of these cannot be used for a variable name in Java?",
            "5. What is the extension of java code files?",
            "6. Which environment variable is used to set the java path?",
            "7. Which of the following is not an OOPS concept in Java?",
            "8. Which of the following is a type of polymorphism in Java Programming?",
            "9. Which exception is thrown when java is out of memory?",
            "10. Which of these are selection statements in Java?",
            "11. Which of these keywords is used to define interfaces in Java?",
            "12. Which of the following is a superclass of every class in Java?",
            "13. Which of the below is not a Java Profiler?",
            "14. Which of these packages contains the exception Stack Overflow in Java?",
            "15. Which of these keywords are used for the block to be examined for exceptions?",
            "16. Which one of the following is not an access modifier?",
            "17. Which class provides system independent server side implementation?",
            "18. Which of the following is not a Java features?",
            "19. _____ is used to find and fix bugs in the Java programs?",
            "20. What is the return type of the hashCode() method in the Object class?",
            "21. Which of the following tool is used to generate API documentation in HTML format from doc comments in source code?",
            "22. Which of the following is true about the anonymous inner class?",
            "23. Which package contains the Random class?",
            "24. An interface with no fields or methods is known as a ______?",
            "25. Which of the following is an immediate subclass of the Panel class?",
    };

    String[][] option = new String[][]{

            {"Guido van Rossum","James Gosling","Dennis Ritchie","Bjarne Stroustrup"},
            {"JRE","JIT","JDK","JVM"},
            {"Object-oriented","Use of pointers","Portable","Dynamic and Extensible"},
            {"identifier & keyword","identifier","keyword","none of the mentioned"},
            {".js",".txt",".class",".java"},
            {"MAVEN_Path","JavaPATH","JAVA","JAVA_HOME"},
            {"Polymorphism","Inheritance","Compilation","Encapsulation"},
            {"Multiple polymorphism","Compile time polymorphism","Multilevel polymorphism","Execution time polymorphism"},
            {"MemoryError","OutOfMemoryError","MemoryOutOfBoundsException","MemoryFullException"},
            {"break","continue","for()","if()"},
            { "intf","Intf","interface","Interface"},
            {"ArrayList","Abstract class","Object class","String"},
            {"JProfiler","Eclipse Profiler","JVM","JConsole"},
            {"java.io","java.system","java.lang","java.util"},
            {"check","throw","catch","try"},
            {"Protected","Void","Public","Private"},
            {"Server","ServerReader","Socket","ServerSocket"},
            {"Dynamic","Architecture Neutral","Use of pointers","Object-oriented"},
            {"JVM","JRE","JDK","JDB"},
            {"Object","int","long","void"},
            {"javap tool","javaw command","Javadoc tool","javah command"},
            {"It has only methods","Objects can't be created","It has a fixed class name","It has no class name"},
            {"java.util package","java.lang package","java.awt package","java.io package"},
            {"Runnable Interface","Marker Interface","Abstract Interface","CharSequence Interface"},
            {"Applet class","Window class","Frame class","Dialog class"},
    };

    String[] answersKey = new String[]{

            "James Gosling",
            "JDK",
            "Use of pointers",
            "keyword",
            ".java",
            "JAVA_HOME",
            "Compilation",
            "Compile time polymorphism",
            "OutOfMemoryError",
            "if()",
            "interface",
            "Object class",
            "JVM",
            "java.lang",
            "try",
            "Void",
            "ServerSocket",
            "Use of pointers",
            "JDB",
            "int",
            "Javadoc tool",
            "It has no class name",
            "java.util package",
            "Marker Interface",
            "Applet class",
    };

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"------------------>onCreate");

        tvQuestion = findViewById(R.id.textView2);

        radioGroup = findViewById(R.id.radioGroup);
        radioButton1 =findViewById(R.id.radioButton);
        radioButton2 =findViewById(R.id.radioButton2);
        radioButton3 =findViewById(R.id.radioButton3);
        radioButton4 =findViewById(R.id.radioButton4);

        ImageviewLeft = findViewById(R.id.imageView);
        ImageViewRight = findViewById(R.id.imageView2);

        btCheck = findViewById(R.id.button);

        navigationControl();

    }

    private void navigationControl() {

        resetRadioButton();

        Log.d(TAG,"------------------------->navigationControl");

        if (currentIndex == 0){
            ImageviewLeft.setImageResource(R.drawable.left_arrow_light);
            ImageviewLeft.setClickable(false);

            Toast.makeText(this, "start - Quiz", Toast.LENGTH_SHORT).show();

        }else if (currentIndex == question.length-1){
            ImageViewRight.setImageResource(R.drawable.right_arrow_light);
            ImageViewRight.setClickable(false);

            Toast.makeText(this, "end-Quiz", Toast.LENGTH_SHORT).show();

        }else {
            ImageviewLeft.setImageResource(R.drawable.left_arrow_bright);
            ImageviewLeft.setClickable(true);

            ImageViewRight.setImageResource(R.drawable.right_arrow_bright);
            ImageViewRight.setClickable(true);
        }
        displayData();
    }

    private void displayData() {
        Log.d(TAG,"------------------------->displayData");

        tvQuestion.setText(question[currentIndex]);

        radioButton1.setText(option[currentIndex] [0]);
        radioButton2.setText(option[currentIndex] [1]);
        radioButton3.setText(option[currentIndex] [2]);
        radioButton4.setText(option[currentIndex] [3]);
    }

    private void resetRadioButton() {
        Log.d(TAG,"------------------------->resetRadioButton");

        radioButton1.setChecked(false);
        radioButton2.setChecked(false);
        radioButton3.setChecked(false);
        radioButton4.setChecked(false);

        btCheck.setBackgroundColor(getResources().getColor(R.color.purple_700));
     }

    public void leftArrowMethod(View view) {
        Log.d(TAG,"------------------------->leftArrowMethod");

        currentIndex--;
        navigationControl();
    }

    public void checkAnswerMethod(View view) {
        Log.d(TAG,"------------------------->chickAnswerMethod");

        int selectedRadioButton = radioGroup.getCheckedRadioButtonId();

        Log.d(TAG,"-------------------->selectedRadioButton ");

        if(selectedRadioButton == -1){
            Log.d(TAG,"----------------->Choose the correctAnswer");
            Toast.makeText(this, "Choose the correctAnswer", Toast.LENGTH_SHORT).show();

        }else {
            Log.d(TAG,"--------------------->something is selected");

            RadioButton checkedRadioButton = findViewById(selectedRadioButton);
            Log.d(TAG,"--------------------->checkedRadioButton"+ checkedRadioButton.getText().toString());
            Log.d(TAG,"------------------>AnswerKey"+ answersKey);

            if(checkedRadioButton.getText().toString().equalsIgnoreCase(answersKey[currentIndex])){
                Log.d(TAG,"----------------->Correct answer");
                Toast.makeText(this, "Correct answer", Toast.LENGTH_SHORT).show();
                btCheck.setBackgroundColor(getResources().getColor(R.color.green));
            }else{
                Log.d(TAG,"----------------->In Correct answer");
                Toast.makeText(this, "In Correct answer", Toast.LENGTH_SHORT).show();
                btCheck.setBackgroundColor(getResources().getColor(R.color.red));
            }
        }
    }

    public void rightArrowMethod(View view) {
        Log.d(TAG,"------------------------->rightArrow");

        currentIndex++;
        navigationControl();
    }
}