package Quiz;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Tests implements ActionListener {
    String[] Jautajumi;
    String[][] Izveles;
    char[][] Atbildes;
    char guess;
    int index;
    int correct_guesses = 0;
    int total_questions;
    int result;
    int seconds = 10;

    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();
    JTextArea textarea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();
    JLabel answer_labelD = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();

    public Tests() {
        Jautajumi = new String[Questons.getJautajumi().length];
        for (int i = 0; i < Questons.getJautajumi().length; i++) {
            Jautajumi[i] = Questons.getJautajumi()[i][0];
        }

        Izveles = Awnsers.getIzveles();
        Atbildes = Questons.getAtbildes();
        total_questions = Jautajumi.length;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850, 650);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);

        textfield.setBounds(0, 11, 834, 50);
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Arial", Font.BOLD, 30));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);

        textarea.setBounds(0, 53, 834, 64);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(25, 25, 25));
        textarea.setForeground(new Color(25, 255, 0));
        textarea.setFont(new Font("Arial", Font.BOLD, 25));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);

        buttonA.setBounds(0, 128, 100, 100);
        buttonA.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("1.");

        buttonB.setBounds(0, 239, 100, 100);
        buttonB.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("2.");

        buttonC.setBounds(0, 350, 100, 100);
        buttonC.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("3.");

        buttonD.setBounds(0, 461, 100, 100);
        buttonD.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("4.");

        answer_labelA.setBounds(125, 128, 687, 100);
        answer_labelA.setBackground(new Color(50, 50, 50));
        answer_labelA.setForeground(new Color(25, 255, 0));
        answer_labelA.setFont(new Font("NSimSun", Font.PLAIN, 20));

        answer_labelB.setBounds(125, 239, 687, 100);
        answer_labelB.setBackground(new Color(50, 50, 50));
        answer_labelB.setForeground(new Color(25, 255, 0));
        answer_labelB.setFont(new Font("NSimSun", Font.PLAIN, 20));

        answer_labelC.setBounds(125, 350, 687, 100);
        answer_labelC.setBackground(new Color(50, 50, 50));
        answer_labelC.setForeground(new Color(25, 255, 0));
        answer_labelC.setFont(new Font("NSimSun", Font.PLAIN, 20));

        answer_labelD.setBounds(125, 461, 687, 100);
        answer_labelD.setBackground(new Color(50, 50, 50));
        answer_labelD.setForeground(new Color(25, 255, 0));
        answer_labelD.setFont(new Font("NSimSun", Font.PLAIN, 20));

        number_right.setBounds(225, 225, 200, 100);
        number_right.setBackground(new Color(25, 25, 25));
        number_right.setForeground(new Color(25, 255, 0));
        number_right.setFont(new Font("Ink Free", Font.BOLD, 50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(225, 325, 200, 100);
        percentage.setBackground(new Color(25, 25, 25));
        percentage.setForeground(new Color(25, 255, 0));
        percentage.setFont(new Font("Ink Free", Font.BOLD, 50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);
        frame.getContentPane().add(answer_labelA);
        frame.getContentPane().add(answer_labelB);
        frame.getContentPane().add(answer_labelC);
        frame.getContentPane().add(answer_labelD);
        frame.getContentPane().add(buttonA);
        frame.getContentPane().add(buttonB);
        frame.getContentPane().add(buttonC);
        frame.getContentPane().add(buttonD);
        frame.getContentPane().add(textarea);
        frame.getContentPane().add(textfield);

        // This makes the frame visible when show() is called
        frame.setVisible(false);

        nextQuestion();
    }

    public void show() {
        frame.setVisible(true);
    }

    public void nextQuestion() {
        if (index >= total_questions) {
            results();
        } else {
            textfield.setText("Question " + (index + 1));
            textarea.setText(Jautajumi[index]);
            answer_labelA.setText(Izveles[index][0]);
            answer_labelB.setText(Izveles[index][1]);
            answer_labelC.setText(Izveles[index][2]);
            answer_labelD.setText(Izveles[index][3]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        boolean correct = false;
        char selectedAnswer = ' ';

        if (e.getSource() == buttonA) {
            selectedAnswer = 'A';
        }
        if (e.getSource() == buttonB) {
            selectedAnswer = 'B';
        }
        if (e.getSource() == buttonC) {
            selectedAnswer = 'C';
        }
        if (e.getSource() == buttonD) {
            selectedAnswer = 'D';
        }

        for (char correctAnswer : Atbildes[index]) {
            if (selectedAnswer == correctAnswer) {
                correct = true;
                correct_guesses++;
                break;
            }
        }

        if (!correct) {
            displayAnswer();
        } else {
            answer_labelA.setForeground(Color.GREEN);
            answer_labelB.setForeground(Color.GREEN);
            answer_labelC.setForeground(Color.GREEN);
            answer_labelD.setForeground(Color.GREEN);
            Timer pause = new Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    answer_labelA.setForeground(new Color(25, 255, 0));
                    answer_labelB.setForeground(new Color(25, 255, 0));
                    answer_labelC.setForeground(new Color(25, 255, 0));
                    answer_labelD.setForeground(new Color(25, 255, 0));


                    buttonA.setEnabled(true);
                    buttonB.setEnabled(true);
                    buttonC.setEnabled(true);
                    buttonD.setEnabled(true);
                    index++;
                    nextQuestion();
                }
            });
            pause.setRepeats(false);
            pause.start();
        }
    }

    public void displayAnswer() {

        if (Atbildes[index][0] != 'A')
            answer_labelA.setForeground(new Color(255, 0, 0));
        if (Atbildes[index][0] != 'B')
            answer_labelB.setForeground(new Color(255, 0, 0));
        if (Atbildes[index][0] != 'C')
            answer_labelC.setForeground(new Color(255, 0, 0));
        if (Atbildes[index][0] != 'D')
            answer_labelD.setForeground(new Color(255, 0, 0));

        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer_labelA.setForeground(new Color(25, 255, 0));
                answer_labelB.setForeground(new Color(25, 255, 0));
                answer_labelC.setForeground(new Color(25, 255, 0));
                answer_labelD.setForeground(new Color(25, 255, 0));


                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();
    }

    public void results() {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result = (int) ((correct_guesses / (double) total_questions) * 100);

        textfield.setText("RESULTS!");
        textarea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");

        number_right.setText("(" + correct_guesses + "/" + total_questions + ")");
        percentage.setText(result + "%");

        frame.getContentPane().add(number_right);
        frame.getContentPane().add(percentage);
    }
}
