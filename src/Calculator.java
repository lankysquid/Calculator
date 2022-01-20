import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Calculator {
    private JTextField textField1;
    private JButton a7Button;
    private JButton multiplyButton;
    private JButton a8Button;
    private JButton a9Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton subtractButton;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton addButton;
    private JButton zeroButton;
    private JButton decimalButton;
    private JButton equalButton;
    private JButton ACButton;
    private JButton randomButton;
    private JButton modulusButton;
    private JButton divideButton;
    private JPanel calculator;
    private String left;
    private String right;
    private Operation operation;
    private boolean newOperation;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().calculator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Calculator() {
        textField1.setHorizontalAlignment(JTextField.RIGHT);
        zeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText() + "0");
            }
        });
        decimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField1.getText().contains(".")) textField1.setText(textField1.getText() + ".");
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               setOperation(Operation.ADD);
            }
        });

        equalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (newOperation) {
                    right = textField1.getText();
                    newOperation = false;
                }
                left = operation.compute(Double.parseDouble(left),Double.parseDouble(right)).toString();
                textField1.setText(left);
            }
        });
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText() + "1");
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOperation(Operation.SUBTRACT);
            }
        });
        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOperation(Operation.MULTIPLY);
            }
        });
        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(Double.toString( new Random().nextDouble() * new Random().nextInt(1000000)));
            }
        });
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
        left = textField1.getText();
        textField1.setText("");
        newOperation = true;
    }

    enum Operation {
        ADD {
            @Override
            public Double compute(Double x, Double y) {
                return x + y;
            }
        } , SUBTRACT {
            @Override
            public Double compute(Double x, Double y) {
                return x - y;
            }
        }, DIVIDE {
            @Override
            public Double compute(Double x, Double y) {
                return x / y;
            }
        }, MULTIPLY {
            @Override
            public Double compute(Double x, Double y) {
                return x * y;
            }
        };

        public Double compute(Double x, Double y) {return 0.0;}
    }
}
