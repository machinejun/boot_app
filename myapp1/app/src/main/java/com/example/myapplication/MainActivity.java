package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TAG";
    //number
    private TextView one; //
    private TextView two;
    private TextView three;
    private TextView four;
    private TextView five;
    private TextView six;
    private TextView seven;
    private TextView eight;
    private TextView nine;
    private TextView zero;
    private TextView convert;
    private TextView dot;


    //operator
    private TextView percent;
    private TextView cancel;
    private TextView c;
    private TextView erase;
    private TextView fountain;
    private TextView square;
    private TextView root;
    private TextView dividing;
    private TextView multiply;
    private TextView minus;
    private TextView plus;
    private TextView equal;


    private TextView result;

    private StringBuffer newNum = new StringBuffer();
    private StringBuffer oldNum = new StringBuffer();
    private StringBuffer operator = new StringBuffer();

    String newValue = "0";
    String oldValue = "0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator3);
        initData(); // 호출되면 stack 메모리에 올라간다.
        addEventListener();
    }


    private void initData() {
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        dot = findViewById(R.id.dot);
        //
        percent = findViewById(R.id.percent);
        erase = findViewById(R.id.erase);
        fountain = findViewById(R.id.fountain);
        square = findViewById(R.id.square);
        root = findViewById(R.id.root);
        dividing = findViewById(R.id.dividing);
        multiply = findViewById(R.id.multiply);
        minus = findViewById(R.id.minus);
        convert = findViewById(R.id.convert);
        cancel = findViewById(R.id.cancel);
        plus = findViewById(R.id.plus);
        equal = findViewById(R.id.equal);
        result = findViewById(R.id.result);

        System.out.println("initData 메서드 호출");
    }

    private void addEventListener() {
        one.setOnClickListener(view -> {
            Log.d(TAG, "three가 눌러졌어요");
            newNum.append("1");
            printResult(oldNum, operator, newNum);

        });
        two.setOnClickListener(view -> {
            Log.d(TAG, "three가 눌러졌어요");
            newNum.append("2");
            printResult(oldNum, operator, newNum);

        });
        three.setOnClickListener(view -> {
            Log.d(TAG, "three가 눌러졌어요");
            newNum.append("3");
            printResult(oldNum, operator, newNum);

        });
        four.setOnClickListener(view -> {
            Log.d(TAG, "four가 눌러졌어요");
            newNum.append("4");
            printResult(oldNum, operator, newNum);

        });
        five.setOnClickListener(view -> {
            Log.d(TAG, "five가 눌러졌어요");
            newNum.append("5");
            printResult(oldNum, operator, newNum);

        });
        six.setOnClickListener(view -> {
            Log.d(TAG, "siz가 눌러졌어요");
            newNum.append("6");
            printResult(oldNum, operator, newNum);

        });
        seven.setOnClickListener(view -> {
            Log.d(TAG, "seven가 눌러졌어요");
            newNum.append("7");
            printResult(oldNum, operator, newNum);

        });
        eight.setOnClickListener(view -> {
            Log.d(TAG, "eight가 눌러졌어요");
            newNum.append("8");
            printResult(oldNum, operator, newNum);

        });
        nine.setOnClickListener(view -> {
            Log.d(TAG, "nine가 눌러졌어요");
            newNum.append("9");
            printResult(oldNum, operator, newNum);

        });

        zero.setOnClickListener(view -> {
            Log.d(TAG, "Zero가 눌러졌어요");
            newNum.append("0");
            printResult(oldNum, operator, newNum);

        });

        dot.setOnClickListener(view -> {
            if (newNum.indexOf(".") == -1) {
                newNum.append(".");
                printResult(oldNum, operator, newNum);
            }
        });

        convert.setOnClickListener(view -> {
            if (newNum.indexOf(".") == -1) {
                int i = Integer.parseInt(newNum.toString()) * -1;
                newNum.delete(0, newNum.length());
                newNum.append(i);
            } else {
                double d = Double.parseDouble(newNum.toString()) * -1;
                newNum.delete(0, newNum.length());
                newNum.append(String.format("%.1f", d));
            }
            printResult(oldNum, operator, newNum);
        });


        cancel.setOnClickListener(view -> {
            Log.d(TAG, "CA가 눌러졌어요");
            oldNum.delete(0, oldNum.length());
            operator.delete(0, operator.length());
            newNum.delete(0, newNum.length());
            printResult(oldNum, operator, newNum);
        });

        plus.setOnClickListener(view -> {
            operator.delete(0, operator.length());
            operator.append("+");

            if (oldNum.length() != 0) {
                if (oldNum.indexOf(".") != -1 || newNum.indexOf(".") != -1) {
                    double d = Double.parseDouble(oldNum.toString()) + Double.parseDouble(newNum.toString());
                    oldNum.delete(0, oldNum.length());
                    oldNum.append(String.format("%.1f", d));
                    newNum.delete(0, newNum.length());
                } else {
                    int i = Integer.parseInt(oldNum.toString()) + Integer.parseInt(newNum.toString());
                    oldNum.delete(0, oldNum.length());
                    oldNum.append(i);
                    newNum.delete(0, newNum.length());
                }
            } else {
                oldNum.append(newNum);
                newNum.delete(0, newNum.length());
            }
            printResult(oldNum, operator, newNum);
            Log.d(TAG, "+가 눌러졌어요");
        });

        minus.setOnClickListener(view -> {
            operator.delete(0, operator.length());
            operator.append("-");

            if (oldNum.length() != 0) {
                if (oldNum.indexOf(".") != -1 || newNum.indexOf(".") != -1) {
                    double d = Double.parseDouble(oldNum.toString()) - Double.parseDouble(newNum.toString());
                    oldNum.delete(0, oldNum.length());
                    oldNum.append(String.format("%.1f", d));
                    newNum.delete(0, newNum.length());
                } else {
                    int i = Integer.parseInt(oldNum.toString()) - Integer.parseInt(newNum.toString());
                    oldNum.delete(0, oldNum.length());
                    oldNum.append(i);
                    newNum.delete(0, newNum.length());
                }
            } else {
                oldNum.append(newNum);
                newNum.delete(0, newNum.length());
            }
            printResult(oldNum, operator, newNum);
            Log.d(TAG, "-가 눌러졌어요");
        });

        multiply.setOnClickListener(view -> {
            operator.delete(0, operator.length());
            operator.append("X");

            if (oldNum.length() != 0) {
                if (oldNum.indexOf(".") != -1 || newNum.indexOf(".") != -1) {
                    double d = Double.parseDouble(oldNum.toString()) * Double.parseDouble(newNum.toString());
                    oldNum.delete(0, oldNum.length());
                    oldNum.append(String.format("%.1f", d));
                    newNum.delete(0, newNum.length());
                } else {
                    int i = Integer.parseInt(oldNum.toString()) * Integer.parseInt(newNum.toString());
                    oldNum.delete(0, oldNum.length());
                    oldNum.append(i);
                    newNum.delete(0, newNum.length());
                }
            } else {
                oldNum.append(newNum);
                newNum.delete(0, newNum.length());
            }
            printResult(oldNum, operator, newNum);
            Log.d(TAG, "-가 눌러졌어요");
        });

        dividing.setOnClickListener(view -> {
            operator.delete(0, operator.length());
            operator.append("÷");

            if (oldNum.length() != 0) {
                if (oldNum.indexOf(".") != -1 || newNum.indexOf(".") != -1) {
                    double d = Double.parseDouble(oldNum.toString()) / Double.parseDouble(newNum.toString());
                    oldNum.delete(0, oldNum.length());
                    oldNum.append(String.format("%.1f", d));
                    newNum.delete(0, newNum.length());
                } else {
                    int i = Integer.parseInt(oldNum.toString()) / Integer.parseInt(newNum.toString());
                    oldNum.delete(0, oldNum.length());
                    oldNum.append(i);
                    newNum.delete(0, newNum.length());
                }
            } else {
                oldNum.append(newNum);
                newNum.delete(0, newNum.length());
            }
            printResult(oldNum, operator, newNum);
            Log.d(TAG, "-가 눌러졌어요");
        });

        equal.setOnClickListener(view -> {
            if (oldNum.length() != 0 || newNum.length() != 0) {
                switch (operator.toString()) {
                    case "+":
                        plus();
                        break;
                    case "-":
                        minus();
                        break;
                    case "X":
                        multiple();
                        break;
                    case "÷":
                        divide();
                }

            }
        });


    }

    private void printResult(StringBuffer oN, StringBuffer op, StringBuffer nN) {
        result.setText(oN.toString() + op.toString() + nN.toString());
    }

    private void plus() {
        if (oldNum.indexOf(".") != -1 || newNum.indexOf(".") != -1) {
            double d = Double.parseDouble(oldNum.toString()) + Double.parseDouble(newNum.toString());
            oldNum.delete(0, oldNum.length());
            newNum.delete(0, newNum.length());
            newNum.append(String.format("%.1f", d));

        } else {
            int i = Integer.parseInt(oldNum.toString()) + Integer.parseInt(newNum.toString());
            oldNum.delete(0, oldNum.length());
            newNum.delete(0, newNum.length());
            newNum.append(i);
        }
        operator.delete(0, operator.length());
        printResult(oldNum, operator, newNum);
    }

    private void minus() {
        if (oldNum.indexOf(".") != -1 || newNum.indexOf(".") != -1) {
            double d = Double.parseDouble(oldNum.toString()) - Double.parseDouble(newNum.toString());
            oldNum.delete(0, oldNum.length());
            newNum.delete(0, newNum.length());
            newNum.append(String.format("%.1f", d));

        } else {
            int i = Integer.parseInt(oldNum.toString()) - Integer.parseInt(newNum.toString());
            oldNum.delete(0, oldNum.length());
            newNum.delete(0, newNum.length());
            newNum.append(i);
        }
        operator.delete(0, operator.length());
        printResult(oldNum, operator, newNum);
    }

    private void multiple() {
        if (oldNum.indexOf(".") != -1 || newNum.indexOf(".") != -1) {
            double d = Double.parseDouble(oldNum.toString()) * Double.parseDouble(newNum.toString());
            oldNum.delete(0, oldNum.length());
            newNum.delete(0, newNum.length());
            newNum.append(String.format("%.1f", d));

        } else {
            int i = Integer.parseInt(oldNum.toString()) * Integer.parseInt(newNum.toString());
            oldNum.delete(0, oldNum.length());
            newNum.delete(0, newNum.length());
            newNum.append(i);
        }
        operator.delete(0, operator.length());
        printResult(oldNum, operator, newNum);
    }

    private void divide() {
        if (oldNum.indexOf(".") != -1 || newNum.indexOf(".") != -1) {
            double d = Double.parseDouble(oldNum.toString()) / Double.parseDouble(newNum.toString());
            oldNum.delete(0, oldNum.length());
            newNum.delete(0, newNum.length());
            newNum.append(String.format("%.1f", d));

        } else {
            int i = Integer.parseInt(oldNum.toString()) / Integer.parseInt(newNum.toString());
            oldNum.delete(0, oldNum.length());
            newNum.delete(0, newNum.length());
            newNum.append(i);
        }
        operator.delete(0, operator.length());
        printResult(oldNum, operator, newNum);
    }


}