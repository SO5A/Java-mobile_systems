package Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Calculator extends JFrame {

    public JPanel panel;
    private JList<MathematicalFunctions> ListOfFunction;
    private JButton evalButton;
    private JTextField inputField;
    private JTextArea textArea;
    private JScrollPane scrollContainerPane;

    DefaultListModel<MathematicalFunctions> listModel = new DefaultListModel<>();
    List<String> cache =  new ArrayList();
    int count = 0;


    public Calculator(){
        ListOfFunction.setModel(listModel);
        MathematicalFunctions sin = new MathematicalFunctions("Sinus", "sin()");
        listModel.addElement(sin);
        MathematicalFunctions cos = new MathematicalFunctions("Cosinus", "cos()");
        listModel.addElement(cos);
        MathematicalFunctions ctg = new MathematicalFunctions("Contangens", "ctg()");
        listModel.addElement(ctg);
        MathematicalFunctions log = new MathematicalFunctions("Logarytm", "log( ,)");
        listModel.addElement(log);
        MathematicalFunctions mod = new MathematicalFunctions("Modulo", "mod( ,)");
        listModel.addElement(mod);
        MathematicalFunctions Bern= new MathematicalFunctions("Liczby Bernulliego", "Bern( ,)");
        listModel.addElement(Bern);
        MathematicalFunctions pi = new MathematicalFunctions("Wartość PI", "pi");
        listModel.addElement(pi);
        MathematicalFunctions e = new MathematicalFunctions("Wartość e", "e");
        listModel.addElement(e);
        MathematicalFunctions GoldenRatio = new MathematicalFunctions("zlota liczba", "[phi]");
        listModel.addElement(GoldenRatio);
        MathematicalFunctions last= new MathematicalFunctions("ostatnia", "");
        listModel.addElement(last);



        JFrame frame = new JFrame("SciCal");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;

        frame.setSize(width/2,height/2);

        int frameWidth = this.getSize().width;
        int frameHeight = this.getSize().height;

        frame.setLocation(((width)/2 - frameWidth)/2,((height)/2 - frameHeight)/2);
        frame.setVisible(true);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu options = new JMenu("Options");
        menuBar.add(options);

        JMenuItem reset = new JMenuItem("Reset");
        JMenuItem exit = new JMenuItem("Exit");
        options.add(reset);
        options.add(exit);

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                inputField.setText("");
                cache.clear();
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cache.add(inputField.getText());
                count = 0;
                textArea.append(new Message().msg(inputField.getText()));
                inputField.setText(null);
            }
        });

        inputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_UP){
                    if(!cache.isEmpty()){
                        inputField.setText(cache.get(cache.size() - count - 1));

                        if(count < cache.size() - 1){
                            count++;
                        }
                    }
                }
            }
        });

        evalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cache.add(inputField.getText());
                count = 0;
                textArea.append(new Message().msg(inputField.getText()));
                inputField.setText(null);
            }
        });


        ListOfFunction.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int position = ListOfFunction.getSelectedIndex();
                    int CaretPosition =inputField.getCaretPosition();
                    int CarePositionFromBehind = inputField.getText().length() - CaretPosition;
                    String inputText= inputField.getText().substring(0,CaretPosition)+listModel.getElementAt(position).getFunction()+inputField.getText().substring(CaretPosition);


                    inputField.setText(inputText);
                    inputField.requestFocus();

                    if(inputField.getText().contains("()")) {
                        inputField.setCaretPosition(inputField.getText().length() - CarePositionFromBehind - 1);
                    }
                    else if (inputField.getText().contains(",")) {
                        inputField.setCaretPosition(inputField.getText().length() - CarePositionFromBehind - 2);
                    }
                    else if (inputField.getText().equals("")) {
                        if (!cache.isEmpty()) {
                            inputField.setText(new Message().msgg(cache.get(cache.size() - count - CarePositionFromBehind - 1)));

                        } else {
                            JOptionPane.showMessageDialog(null, "There aren't previous operations",
                                    "No last result",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    else {
                        inputField.setCaretPosition(inputField.getText().length());
                    }

                }
            }
        });
    }


    public static void main(String[] args) {
        new Calculator();
    }

}
