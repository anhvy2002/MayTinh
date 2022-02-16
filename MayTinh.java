
package ltjavanc;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MayTinh implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numButton = new JButton[10];
    JButton[] funButton = new JButton[9];
    JButton addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    
    Font myFont = new Font("", Font.BOLD, 30);
    
    double num1 = 0, num2 = 0, result = 0;
    char operator;
    
    MayTinh() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);
        
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("AC");
        negButton = new JButton("(-)");
        
        funButton[0] = addButton;
        funButton[1] = subButton;
        funButton[2] = mulButton;
        funButton[3] = divButton;
        funButton[4] = decButton;
        funButton[5] = equButton;
        funButton[6] = delButton;
        funButton[7] = clrButton;
        funButton[8] = negButton;
        
        for(int i = 0; i < 9; i++) {
            funButton[i].addActionListener(this);
            funButton[i].setFont(myFont);
            funButton[i].setFocusable(false);
        }
        
        for(int i = 0; i < 10; i++) {
            numButton[i] = new JButton(String.valueOf(i));
            numButton[i].addActionListener(this);
            numButton[i].setFont(myFont);
            numButton[i].setFocusable(false);
        }
        
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);
        
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        
        panel.add(numButton[1]);
        panel.add(numButton[2]);
        panel.add(numButton[3]);
        panel.add(addButton);
        panel.add(numButton[4]);
        panel.add(numButton[5]);
        panel.add(numButton[6]);
        panel.add(subButton);
        panel.add(numButton[7]);
        panel.add(numButton[8]);
        panel.add(numButton[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numButton[0]);
        panel.add(equButton);
        panel.add(divButton);
        
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }
        
    public static void main(String[] args) {
        MayTinh calc = new MayTinh();
        
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 10; i++) {
            if(e.getSource() == numButton[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
                
            }
        }
        if(e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            
            switch(operator) {
                case'+':
                    result = num1 + num2;
                    break;
                case'-':
                    result = num1 - num2;
                    break;
                case'*':
                    result = num1 * num2;
                    break;
                case'/':
                    result = num1 / num2;
                    break;
                    
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource() == clrButton) {
            textField.setText("");
        }
        if(e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for(int i = 0; i < string.length()-1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
        if(e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }
    }
}

