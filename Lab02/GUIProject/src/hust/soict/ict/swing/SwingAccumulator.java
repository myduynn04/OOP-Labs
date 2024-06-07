package hust.soict.ict.swing;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;

    public SwingAccumulator() {
        Container cp = getContentPane();
        cp.setLayout (new GridLayout(2,2));

        cp.add(new Label("Enter an Integer: "));

        tfInput = new JTextField(10);
        cp.add(tfInput);
        //Thêm trình lắng nghe cho
        tfInput.addActionListener(new TFInputListener());


        cp.add(new Label("The Accumulateed Sum is: "));

        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);
        cp.add(tfOutput);

        setTitle("AWT Accumulator");
        setSize(350,120);
        setVisible(true);

    }

    public static void main (String[] arg) {
        new SwingAccumulator();
    }

    private class TFInputListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt) {
            int numberIn = Integer.parseInt(tfInput.getText());
            sum+= numberIn;
            tfInput.setText("");
            tfOutput.setText(sum +"");
        }
    }
}
