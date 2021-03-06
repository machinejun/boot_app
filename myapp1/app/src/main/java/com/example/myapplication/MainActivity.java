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

    private StringBuilder newNum = new StringBuilder();
    private StringBuilder oldNum = new StringBuilder();
    private StringBuilder operator = new StringBuilder();
    /*
       데이터의 값이 변동이 많은 경우는 String < StringBuffer, StringBuilder
       why ? : String이 변동될 때 기존의 데이터의 주소값은 가비지 컬렉터에 들어간다.
               그래서 연산이 많아지면 성능저하가 나타난다.
       단일 쓰레드일 경우는 StringBuilder > StringBuffer
       멀티 쓰레드일 경우는 StringBuffer > StringBuilder 보다 좋다
       why? : StringBuffer 는 동기화를 지원한다.
     */

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
        c = findViewById(R.id.c);
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
            newNum.append("1");
            printResult(oldNum, operator, newNum);

        });
        two.setOnClickListener(view -> {
            newNum.append("2");
            printResult(oldNum, operator, newNum);

        });
        three.setOnClickListener(view -> {
            newNum.append("3");
            printResult(oldNum, operator, newNum);

        });
        four.setOnClickListener(view -> {
            newNum.append("4");
            printResult(oldNum, operator, newNum);

        });
        five.setOnClickListener(view -> {
            newNum.append("5");
            printResult(oldNum, operator, newNum);

        });
        six.setOnClickListener(view -> {
            newNum.append("6");
            printResult(oldNum, operator, newNum);

        });
        seven.setOnClickListener(view -> {
            newNum.append("7");
            printResult(oldNum, operator, newNum);

        });
        eight.setOnClickListener(view -> {
            newNum.append("8");
            printResult(oldNum, operator, newNum);

        });
        nine.setOnClickListener(view -> {
            newNum.append("9");
            printResult(oldNum, operator, newNum);

        });

        zero.setOnClickListener(view -> {
            newNum.append("0");
            printResult(oldNum, operator, newNum);

        });


        dot.setOnClickListener(view -> {
            if (newNum.indexOf(".") == -1) {
                newNum.append(".");
                printResult(oldNum, operator, newNum);
            }
        });


        square.setOnClickListener(view -> {
            if (newNum.indexOf("^") == -1) {
                newNum.append("^");
                printResult(oldNum, operator, newNum);
            }
        });

        root.setOnClickListener(view -> {
            if (newNum.indexOf("√") == -1) {
                newNum.insert(0, "√");
                printResult(oldNum, operator, newNum);
            }
        });

        percent.setOnClickListener(view -> {
            if (newNum.indexOf(".") != -1) {
                int d = (int) (Double.parseDouble(newNum.toString()) * 100);
                newNum.delete(0, newNum.length());
                newNum.append(d);
                newNum.append("%");
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
                newNum.append(d);
            }
            printResult(oldNum, operator, newNum);
        });


        cancel.setOnClickListener(view -> {
            oldNum.delete(0, oldNum.length());
            operator.delete(0, operator.length());
            newNum.delete(0, newNum.length());
            printResult(oldNum, operator, newNum);
        });

        plus.setOnClickListener(view -> {
            operator.delete(0, operator.length());
            operator.append("+");


            if (oldNum.length() != 0) {
                if (newNum.length() != 0) {
                    if (oldNum.indexOf(".") != -1 || newNum.indexOf(".") != -1) {
                        double d = Double.parseDouble(oldNum.toString()) + Double.parseDouble(newNum.toString());
                        oldNum.delete(0, oldNum.length());
                        oldNum.append(String.format("%.2f", d));
                        newNum.delete(0, newNum.length());
                    } else {
                        int i = Integer.parseInt(oldNum.toString()) + Integer.parseInt(newNum.toString());
                        oldNum.delete(0, oldNum.length());
                        oldNum.append(i);
                        newNum.delete(0, newNum.length());
                    }
                } else {
                    newNum.delete(0, newNum.length());
                }
            } else {
                oldNum.append(newNum);
                newNum.delete(0, newNum.length());
            }
            printResult(oldNum, operator, newNum);
        });

        minus.setOnClickListener(view -> {
            operator.delete(0, operator.length());
            operator.append("-");

            if (oldNum.length() != 0) {
                if (newNum.length() != 0) {
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
                    newNum.delete(0, newNum.length());
                }

            } else {
                oldNum.append(newNum);
                newNum.delete(0, newNum.length());
            }
            printResult(oldNum, operator, newNum);
        });

        multiply.setOnClickListener(view -> {
            operator.delete(0, operator.length());
            operator.append("X");

            if (oldNum.length() != 0) {
                if (newNum.length() != 0) {
                    if (oldNum.indexOf(".") != -1 || newNum.indexOf(".") != -1) {
                        double d = Double.parseDouble(oldNum.toString()) * Double.parseDouble(newNum.toString());
                        oldNum.delete(0, oldNum.length());
                        oldNum.append(String.format("%.2f", d));
                        newNum.delete(0, newNum.length());
                    } else {
                        int i = Integer.parseInt(oldNum.toString()) * Integer.parseInt(newNum.toString());
                        oldNum.delete(0, oldNum.length());
                        oldNum.append(i);
                        newNum.delete(0, newNum.length());
                    }
                } else {
                    newNum.delete(0, newNum.length());
                }
            } else {
                oldNum.append(newNum);
                newNum.delete(0, newNum.length());
            }
            printResult(oldNum, operator, newNum);
        });

        c.setOnClickListener(view -> {
            newNum.delete(0, newNum.length());
            printResult(oldNum, operator, newNum);
        });

        dividing.setOnClickListener(view -> {
            operator.delete(0, operator.length());
            operator.append("÷");

            if (newNum.toString().equals("0")) {
                operator.delete(0, operator.length());
                newNum.delete(0, newNum.length());
                newNum.append("Infinity");
                printResult(oldNum, operator, newNum);
                return;
            }

            if (oldNum.length() != 0) {
                if (newNum.length() != 0) {
                    if (oldNum.indexOf(".") != -1 || newNum.indexOf(".") != -1) {
                        double d = Double.parseDouble(oldNum.toString()) / Double.parseDouble(newNum.toString());
                        oldNum.delete(0, oldNum.length());
                        oldNum.append(String.format("%.2f", d));
                        newNum.delete(0, newNum.length());
                    } else {
                        int i = Integer.parseInt(oldNum.toString()) / Integer.parseInt(newNum.toString());
                        oldNum.delete(0, oldNum.length());
                        oldNum.append(i);
                        newNum.delete(0, newNum.length());
                    }
                } else {
                    newNum.delete(0, newNum.length());
                }
            } else {
                oldNum.append(newNum);
                newNum.delete(0, newNum.length());
            }
            printResult(oldNum, operator, newNum);
        });

        equal.setOnClickListener(view -> {
            if (oldNum.indexOf("/") != -1) {
                try {
                    StringTokenizer st = new StringTokenizer(oldNum.toString(), "/");
                    double d = Double.parseDouble(st.nextToken()) / Double.parseDouble(st.nextToken());
                    oldNum.delete(0, oldNum.length());
                    oldNum.append(String.format("%.2f", d));
                } catch (NoSuchElementException e) {
                    errorprint();
                }

            }

            if (newNum.indexOf("/") != -1) {
                try {
                    StringTokenizer st = new StringTokenizer(newNum.toString(), "/");
                    double d = Double.parseDouble(st.nextToken()) / Double.parseDouble(st.nextToken());
                    newNum.delete(0, newNum.length());
                    newNum.append(String.format("%.2f", d));
                    printResult(oldNum, operator, newNum);
                } catch (NoSuchElementException e) {
                    errorprint();
                }
            }

            if (oldNum.indexOf("^") != -1) {
                try {
                    StringTokenizer st = new StringTokenizer(oldNum.toString(), "^");
                    double d = Math.pow(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
                    //double d = Double.parseDouble(st.nextToken()) * Double.parseDouble(st.nextToken());
                    oldNum.delete(0, oldNum.length());
                    oldNum.append(String.format("%.2f", d));
                } catch (NoSuchElementException e) {
                    errorprint();
                }

            }

            if (newNum.indexOf("^") != -1) {
                try {
                    StringTokenizer st = new StringTokenizer(newNum.toString(), "^");
                    double d = Math.pow(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
                    //double d = Double.parseDouble(st.nextToken()) * Double.parseDouble(st.nextToken());
                    newNum.delete(0, newNum.length());
                    newNum.append(String.format("%.2f", d));
                    printResult(oldNum, operator, newNum);
                } catch (NoSuchElementException e) {
                    errorprint();
                }

            }

            if (oldNum.indexOf("√") != -1) {
                oldNum.replace(0, 1, "");
                double d = Math.sqrt(Double.parseDouble(oldNum.toString()));
                oldNum.delete(0, oldNum.length());
                oldNum.append(String.format("%.2f", d));
            }

            if (newNum.indexOf("√") != -1) {
                newNum.replace(0, 1, "");
                double d = Math.sqrt(Double.parseDouble(newNum.toString()));
                //double d = Double.parseDouble(st.nextToken()) * Double.parseDouble(st.nextToken());
                newNum.delete(0, newNum.length());
                newNum.append(String.format("%.2f", d));
                printResult(oldNum, operator, newNum);
            }

            if(newNum.indexOf("%") != -1){
                newNum.replace(newNum.length()-1, newNum.length(),"");
                double d = Double.parseDouble(newNum.toString()) / 100;
                newNum.delete(0, newNum.length());
                newNum.append(d);
            }

            if(oldNum.indexOf("%") != -1){
                oldNum.replace(oldNum.length()-1, oldNum.length(),"");
                double d = Double.parseDouble(oldNum.toString()) / 100;
                oldNum.delete(0, oldNum.length());
                oldNum.append(d);
            }


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

        erase.setOnClickListener(view -> {
            try {
                newNum.setLength(newNum.length() - 1);
                printResult(oldNum, operator, newNum);
            } catch (StringIndexOutOfBoundsException e) {
                result.setText("0");
            }

        });

        fountain.setOnClickListener(view -> {
            if (newNum.length() > 0) {
                newNum.insert(0, "1/");
                printResult(oldNum, operator, newNum);
            }
        });


    }

    private void printResult(StringBuilder oN, StringBuilder op, StringBuilder nN) {
        result.setText(oN.toString() + op.toString() + nN.toString());
    }

    private void plus() {
        if (oldNum.indexOf(".") != -1 || newNum.indexOf(".") != -1) {
            double d = Double.parseDouble(oldNum.toString()) + Double.parseDouble(newNum.toString());
            oldNum.delete(0, oldNum.length());
            newNum.delete(0, newNum.length());
            newNum.append(String.format("%.2f", d));

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
            newNum.append(String.format("%.2f", d));

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
            newNum.append(String.format("%.2f", d));

        } else {
            try {
                int i = Integer.parseInt(oldNum.toString()) * Integer.parseInt(newNum.toString());
                oldNum.delete(0, oldNum.length());
                newNum.delete(0, newNum.length());
                newNum.append(i);
            } catch (NumberFormatException e) {
                oldNum.delete(0, oldNum.length());
                newNum.delete(0, newNum.length());
                newNum.append("I can't calculate");
            }

        }
        operator.delete(0, operator.length());
        printResult(oldNum, operator, newNum);
    }

    private void errorprint() {
        Log.d("error","실행");
        oldNum.delete(0, oldNum.length());
        newNum.delete(0, newNum.length());
        operator.delete(0, operator.length());
        newNum.append("i can't calculate");
        printResult(oldNum, operator, newNum);
    }

    private void divide() {
        if (oldNum.indexOf(".") != -1 || newNum.indexOf(".") != -1) {
            double d = Double.parseDouble(oldNum.toString()) / Double.parseDouble(newNum.toString());
            oldNum.delete(0, oldNum.length());
            newNum.delete(0, newNum.length());
            newNum.append(String.format("%.2f", d));

        } else {
            try {
                if (!(newNum.toString().equals("0"))) {
                    int i = Integer.parseInt(oldNum.toString()) / Integer.parseInt(newNum.toString());
                    oldNum.delete(0, oldNum.length());
                    newNum.delete(0, newNum.length());
                    newNum.append(i);
                } else {
                    oldNum.delete(0, oldNum.length());
                    newNum.delete(0, newNum.length());
                    newNum.append("Infinity");
                }

            } catch (NumberFormatException e) {
                oldNum.delete(0, oldNum.length());
                newNum.delete(0, newNum.length());
                newNum.append("I can't calculate");
            }
        }
        operator.delete(0, operator.length());
        printResult(oldNum, operator, newNum);
    }


}