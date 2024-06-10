package Quiz;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Tests implements ActionListener {
    String[] Jautajumi;
    String[][] Izveles;
    char[][] Atbildes;
    int index;
    int correct_guesses = 0;
    int total_questions;
    int result;

    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();
    JTextArea textarea = new JTextArea();
    JCheckBox checkboxA = new JCheckBox();
    JCheckBox checkboxB = new JCheckBox();
    JCheckBox checkboxC = new JCheckBox();
    JCheckBox checkboxD = new JCheckBox();
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();
    JLabel answer_labelD = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();
    JButton proceedButton = new JButton("Turpināt");

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

        textarea.setBounds(0, 59, 834, 64);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(25, 25, 25));
        textarea.setForeground(new Color(25, 255, 0));
        textarea.setFont(new Font("Arial", Font.BOLD, 25));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);

        checkboxA.setBounds(35, 159, 21, 34);
        checkboxA.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 35));
        checkboxA.setFocusable(false);
        checkboxA.addActionListener(this);

        checkboxB.setBounds(35, 275, 21, 34);
        checkboxB.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 35));
        checkboxB.setFocusable(false);
        checkboxB.addActionListener(this);

        checkboxC.setBounds(35, 383, 21, 34);
        checkboxC.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 35));
        checkboxC.setFocusable(false);
        checkboxC.addActionListener(this);

        checkboxD.setBounds(35, 493, 21, 34);
        checkboxD.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 35));
        checkboxD.setFocusable(false);
        checkboxD.addActionListener(this);

        answer_labelA.setBounds(125, 147, 687, 64);
        answer_labelA.setBackground(new Color(50, 50, 50));
        answer_labelA.setForeground(Color.BLACK);
        answer_labelA.setFont(new Font("NSimSun", Font.PLAIN, 20));

        answer_labelB.setBounds(125, 258, 687, 64);
        answer_labelB.setBackground(new Color(50, 50, 50));
        answer_labelB.setForeground(Color.BLACK);
        answer_labelB.setFont(new Font("NSimSun", Font.PLAIN, 20));

        answer_labelC.setBounds(125, 475, 687, 64);
        answer_labelC.setBackground(new Color(50, 50, 50));
        answer_labelC.setForeground(Color.BLACK);
        answer_labelC.setFont(new Font("NSimSun", Font.PLAIN, 20));

        answer_labelD.setBounds(125, 368, 687, 64);
        answer_labelD.setBackground(new Color(50, 50, 50));
        answer_labelD.setForeground(Color.BLACK);
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

        proceedButton.setBounds(335, 550, 117, 34);
        proceedButton.setFont(new Font("Arial", Font.PLAIN, 20));
        proceedButton.setFocusable(false);
        proceedButton.addActionListener(this);
        proceedButton.setEnabled(false);

        frame.getContentPane().add(answer_labelA);
        frame.getContentPane().add(answer_labelB);
        frame.getContentPane().add(answer_labelC);
        frame.getContentPane().add(answer_labelD);
        frame.getContentPane().add(checkboxA);
        frame.getContentPane().add(checkboxB);
        frame.getContentPane().add(checkboxC);
        frame.getContentPane().add(checkboxD);
        frame.getContentPane().add(textarea);
        frame.getContentPane().add(textfield);
        frame.getContentPane().add(proceedButton);

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
            
            // Reset checkboxes
            checkboxA.setSelected(false);
            checkboxB.setSelected(false);
            checkboxC.setSelected(false);
            checkboxD.setSelected(false);

            // Enable the "Proceed" button only when at least two questions are selected
            proceedButton.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == proceedButton) {
            // Proceed button clicked
            char[] correctAnswers = Atbildes[index];
            int correctCount = 0;
            if (checkboxA.isSelected() && contains(correctAnswers, '1')) correctCount++;
            if (checkboxB.isSelected() && contains(correctAnswers, '2')) correctCount++;
            if (checkboxC.isSelected() && contains(correctAnswers, '3')) correctCount++;
            if (checkboxD.isSelected() && contains(correctAnswers, '4')) correctCount++;

            if (correctCount >= 2) {
                correct_guesses++;
            } else {
                JOptionPane.showMessageDialog(frame, "Incorrect. The correct answers are: " + getCorrectAnswersText(correctAnswers), "Feedback", JOptionPane.ERROR_MESSAGE);
            }

            index++;
            nextQuestion();
        } else {
            // Checkbox clicked
            int selectedCount = 0;
            if (checkboxA.isSelected()) selectedCount++;
            if (checkboxB.isSelected()) selectedCount++;
            if (checkboxC.isSelected()) selectedCount++;
            if (checkboxD.isSelected()) selectedCount++;

            proceedButton.setEnabled(selectedCount >= 2);
        }
    }

    public void results() {
 
        checkboxA.setVisible(false);
        checkboxB.setVisible(false);
        checkboxC.setVisible(false);
        checkboxD.setVisible(false);
        answer_labelA.setVisible(false);
        answer_labelB.setVisible(false);
        answer_labelC.setVisible(false);
        answer_labelD.setVisible(false);

        // Display results
        result = (int) ((correct_guesses / (double) total_questions) * 100);
        textfield.setText("RESULTS!");
        textarea.setText("");
        number_right.setText("(" + correct_guesses + "/" + total_questions + ")");
        percentage.setText(result + "%");

        frame.getContentPane().add(number_right);
        frame.getContentPane().add(percentage);

        proceedButton.setText("Beigt");
        proceedButton.setEnabled(true);
        proceedButton.removeActionListener(this);
        proceedButton.addActionListener(e -> frame.dispose());
    }

    private boolean contains(char[] array, char value) {
        for (char c : array) {
            if (c == value) return true;
        }
        return false;
    }

    private String getCorrectAnswersText(char[] correctAnswers) {
        StringBuilder correctText = new StringBuilder();
        for (char answer : correctAnswers) {
            switch (answer) {
                case '1':
                    correctText.append("1. ");
                    break;
                case '2':
                    correctText.append("2. ");
                    break;
                case '3':
                    correctText.append("3. ");
                    break;
                case '4':
                    correctText.append("4. ");
                    break;
            }
        }
        return correctText.toString().trim();
    }
}
