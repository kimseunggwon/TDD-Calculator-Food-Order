package study.demo.ex_study.gui_program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**  GUI : Graphical User Interface
 *   java awt / javax swing 사용
 */
public class CalculatorGUI extends JFrame{

    private JTextField inputField;

    // 계산식의 숫자를 담을 변수 num
    private String inputStringNumber = "";

    // 방금 누른 버튼을 기억하는 변수 prev_operation
    private String prev_operation = "";

    // 계산 기능을 구현하기 위해 ArrayList에 숫자와 연산 기호를 하나씩 구분해 담음
    private ArrayList<String> syntaxArray = new ArrayList<String>();

    private String font = "Times";

    void run() {
        System.out.println("CalculatorGUI run!!");
        createCalculatorGUI();
    }

    /** 기본 layout 화면
     */
    private void createCalculatorGUI() {

        setLayout(null);
        createtTextField();


        setLocationRelativeTo(null); // 위치 가운데로
        setTitle("내가 만든 계산기");
        setSize(300,370);
        setResizable(false);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 프로그램 같이 종료

    }

    /** 작은 포스트잇 개념
     */
    private JPanel createButtons() {

        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));

        buttonPanel.setBounds(8, 90, 270, 235);

        String button_names[] = { "+", "-", "=", "C", "7", "8", "9", "×", "4", "5", "6", "÷", "1", "2", "3", "0" };

        JButton buttons[] = new JButton[button_names.length];

        for (int i = 0; i < button_names.length; i++) {

            buttons[i] = new JButton(button_names[i]);

            buttons[i].setFont(new Font(font, Font.BOLD, 20));

            if (button_names[i] == "C")

                buttons[i].setBackground(Color.orange);

            else if ((i >= 4 && i <= 6) || (i >= 8 && i <= 10) || (i >= 12 && i <= 14))

                buttons[i].setBackground(Color.BLACK);

            else

                buttons[i].setBackground(Color.DARK_GRAY);

            buttons[i].setForeground(Color.WHITE);

            buttons[i].setBorderPainted(false);

            buttons[i].addActionListener(new buttonActionListener()); // new buttonActionListener 인스턴스를 넘김
                                                                     // 버튼 하나당 ActionListener 생성
            buttonPanel.add(buttons[i]);

        }

        return buttonPanel;

    }

    /**
     *  버튼 이벤트 ( 이너 클래스 )
     */
    class buttonActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String pressedButton = e.getActionCommand();

            if (pressedButton.equals("C")) {

                inputField.setText("");

            } else if (pressedButton.equals("=")) {

                String result = Double.toString(calculate(inputField.getText()));

                inputField.setText("" + result);

                inputStringNumber = "";

            } else if (pressedButton.equals("+") || pressedButton.equals("-") || pressedButton.equals("×")

                    || pressedButton.equals("÷")) {

                if (inputField.getText().equals("") && pressedButton.equals("-")) {

                    inputField.setText(inputField.getText() + pressedButton);

                } else if (!inputField.getText().equals("") && !prev_operation.equals("+")

                        && !prev_operation.equals("-") && !prev_operation.equals("×") && !prev_operation.equals("÷")) {

                    inputField.setText(inputField.getText() + pressedButton);

                }

            }

            else {

                inputField.setText(inputField.getText() + pressedButton);

            }

            prev_operation = pressedButton;

        }
    }

    /** 계산 로직
     * inputText : 입력 숫자값
     */
    public double calculate(String inputText) {

        //todo

        // 입력한 문자 모두 파싱
        fieldStringParsing(inputText);

        double prev = 0;

        double current = 0;

        String action = "";


        // 첫번째 for : 연산 우선 순위인 곱하기 / 나누기를 먼저 계산
        for (int i = 0; i < syntaxArray.size(); i++) {  // start for 1

            String syntax = syntaxArray.get(i);

            if (syntax.equals("+")) {

                action = "add";

            } else if (syntax.equals("-")) {

                action = "sub";

            } else if (syntax.equals("×")) {

                action = "mul";

            } else if (syntax.equals("÷")) {

                action = "div";

            } else {

                if ((action.equals("mul") || action.equals("div")) && !syntax.equals("+") && !syntax.equals("-")
                        && !syntax.equals("×")

                        && !syntax.equals("÷")) {


                    Double one = Double.parseDouble(syntaxArray.get(i - 2));

                    Double two = Double.parseDouble(syntaxArray.get(i));

                    Double result = 0.0;

                    if (action.equals("mul")) {

                        result = one * two;

                    } else if (action.equals("div")) {

                        result = one / two;

                    }



                    syntaxArray.add(i + 1, Double.toString(result));

                    for (int j = 0; j < 3; j++) {

                        syntaxArray.remove(i - 2);

                    }

                    i -= 2;

                }

            }

        } // end for1

        // 두번째 for : 곱하기 / 마이너스 계산
        for (String s : syntaxArray) {  // start for2

            if (s.equals("+")) {

                action = "add";

            } else if (s.equals("-")) {

                action = "sub";

            } else {

                current = Double.parseDouble(s);

                if (action.equals("add")) {

                    prev += current;

                } else if (action.equals("sub")) {

                    prev -= current;

                } else {

                    prev = current;

                }

            }

            prev = Math.round(prev * 100000) / 100000.0; // 결과저장 ( 소수점 자리 너무 길면 안되니까 방지)

        } //end for2

        return prev;
    }

    /**  핵심 : syntaxArray 숫자 연산자를 따로 따로 넣어준다.
     */
    private void fieldStringParsing(String inputText) {

        //todo
        syntaxArray.clear();

        for (int i = 0; i < inputText.length(); i++) {

            char ch = inputText.charAt(i);

            if (ch == '-' || ch == '+' || ch == '×' || ch == '÷') {

                syntaxArray.add(inputStringNumber);

                inputStringNumber = "";

                syntaxArray.add(ch + "");

            } else {

                inputStringNumber = inputStringNumber + ch;

            }

        }

        syntaxArray.add(inputStringNumber);

        syntaxArray.remove("");
    }

    /** 텍스트 창
     */
    private void createtTextField() {
        inputField = new JTextField();

        inputField.setEditable(false); // 수정 불가능

        inputField.setBackground(Color.GRAY);

        inputField.setHorizontalAlignment(JTextField.RIGHT);

        inputField.setFont(new Font(font, Font.BOLD, 50));

        inputField.setBounds(8, 10, 270, 70);
    }

}
