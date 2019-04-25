package com.Yasmin;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import javax.swing.event.*;

class BMI extends JFrame {
    public static void main(String[] args) {
        BMI window = new BMI();
        window.setVisible(true);
    }

    private JTextField _mField   = new JTextField(4);
    private JTextField _kgField  = new JTextField(4);
    private JTextField _bmiField = new JTextField(4);

    public BMI() {
        JButton bmiButton = new JButton("Compute BMI");
        bmiButton.addActionListener(new BMIListener());

        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Weight"));
        content.add(_kgField);
        content.add(new JLabel("Height"));
        content.add(_mField);
        content.add(bmiButton);
        content.add(new JLabel("BMI"));
        content.add(_bmiField);

        setContentPane(content);
        setTitle("Body Mass Index");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private class BMIListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double kilograms = Double.parseDouble(_kgField.getText());
            double meters    = Double.parseDouble(_mField.getText());
            int    bmi       = (int)computeBMI(kilograms, meters);
            _bmiField.setText("" + bmi);
        }
    }

    public static double computeBMI(double weight, double height) {
        return weight / (height * height);
    }
}
