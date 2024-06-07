package hust.soict.ict.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.store.Store;

public class AddCDToStoreScreen extends AddItemToStoreScreen {
    private JLabel titleLabel;
    private JLabel categoryLabel;
    private JLabel artistLabel;
    private JLabel directorLabel;
    private JLabel costLabel;
    private JLabel lengthLabel;
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField artistField;
    private JTextField directorField;
    private JTextField costField;
    private JTextField lengthField;
    private JButton addButton;

    public AddCDToStoreScreen(Store store) {
        super(store);
        addButton = new JButton("Add CD"); // Initialize the addButton

        titleLabel = new JLabel("Title:");
        categoryLabel = new JLabel("Category:");
        artistLabel = new JLabel("Artist:");
        directorLabel = new JLabel("Director:");
        costLabel = new JLabel("Cost:");
        lengthLabel = new JLabel("Length:");

        titleField = new JTextField();
        categoryField = new JTextField();
        artistField = new JTextField();
        directorField = new JTextField();
        costField = new JTextField();
        lengthField = new JTextField();

        addComponents();
    }

    private void addComponents() {
        JPanel panel = new JPanel(); // Sử dụng JPanel để chứa các thành phần
        panel.setLayout(new GridLayout(7, 2)); // GridLayout cho sắp xếp đều các thành phần
        panel.add(titleLabel);
        panel.add(titleField);

        panel.add(categoryLabel);
        panel.add(categoryField);

        panel.add(artistLabel);
        panel.add(artistField);

        panel.add(directorLabel);
        panel.add(directorField);

        panel.add(costLabel);
        panel.add(costField);

        panel.add(lengthLabel);
        panel.add(lengthField);

        panel.add(addButton);
        frame.add(panel, BorderLayout.CENTER); // Thêm JPanel vào cửa sổ frame
        addButton.addActionListener(e -> addItemToStore()); // Xử lý sự kiện khi nút được nhấn
    }

    @Override
    protected void addItemToStore() {
        try {
            String title = titleField.getText();
            String category = categoryField.getText();
            String artist = artistField.getText();
            String director = directorField.getText();
            float cost = Float.parseFloat(costField.getText());
            int length = Integer.parseInt(lengthField.getText());

            // Lấy id mới
            int newId = store.getItemsInStore().size() + 1;

            CompactDisc cd = new CompactDisc(newId, title, category, director, artist, length, cost);
            store.addMedia(cd);
            JOptionPane.showMessageDialog(frame, "CD added successfully."); // Thông báo khi CD được thêm
            StoreManagerScreen mainFrame = new StoreManagerScreen(store);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid input. Please enter valid numbers for length and cost.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
