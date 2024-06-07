package hust.soict.ict.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGrid extends JFrame {
    // Khai báo các thành phần
    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {
        // Khởi tạo JTextField và thiết lập hướng hiển thị từ phải sang trái
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        // Khởi tạo JPanel chứa các nút số
        JPanel panelButtons = new JPanel(new GridLayout(4, 3));
        addButtons(panelButtons);

        // Lấy container và thiết lập layout BorderLayout
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // Thêm JTextField vào phía trên và panelButtons vào phía giữa của BorderLayout
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        // Thiết lập các thuộc tính của JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(200, 200);
        setVisible(true);
    }

    // Phương thức thêm nút vào JPanel
    void addButtons(JPanel panelButtons) {
        ButtonListener btnListener = new ButtonListener(); // Tạo một đối tượng của lớp ButtonListener
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton("" + i);
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener); // Thêm ActionListener cho các nút số
        }

        btnDelete = new JButton("DEL");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(btnListener); // Thêm ActionListener cho nút "DEL"

        btnNumbers[0] = new JButton("0");
        panelButtons.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(btnListener); // Thêm ActionListener cho nút số 0

        btnReset = new JButton("C");
        panelButtons.add(btnReset);
        btnReset.addActionListener(btnListener); // Thêm ActionListener cho nút "C"
    }

    // Lớp lắng nghe sự kiện cho các nút
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand(); // Lấy lệnh của nút được nhấn
            if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
                tfDisplay.setText(tfDisplay.getText() + button); // Nếu là nút số, hiển thị số đó trên JTextField
            } else if (button.equals("DEL")) {
                String text = tfDisplay.getText();
                if (text.length() > 0) {
                    // Xóa ký tự cuối cùng nếu có
                    tfDisplay.setText(text.substring(0, text.length() - 1));
                }
            } else if (button.equals("C")) {
                // Xóa toàn bộ nội dung trong JTextField
                tfDisplay.setText("");
            }
        }
    }

    public static void main(String[] args) {
        // Tạo một đối tượng NumberGrid để hiển thị
        new NumberGrid();
    }
}
