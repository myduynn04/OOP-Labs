package hust.soict.ict.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.store.Store;

public class AddDVDToStoreScreen extends AddItemToStoreScreen {
	private JLabel titleLabel;
	private JLabel categoryLabel;
	private JLabel directorLabel;
	private JLabel lengthLabel;
	private JLabel costLabel;
	private JTextField titleField;
	private JTextField categoryField;
	private JTextField directorField;
	private JTextField lengthField;
	private JTextField costField;
	private JButton addButton;

	public AddDVDToStoreScreen(Store store) {
		super(store);
		addButton = new JButton("Add DVD");

		titleLabel = new JLabel("Title:");
		categoryLabel = new JLabel("Category:");
		directorLabel = new JLabel("Director:");
		lengthLabel = new JLabel("Length:");
		costLabel = new JLabel("Cost:");

		titleField = new JTextField();
		categoryField = new JTextField();
		directorField = new JTextField();
		lengthField = new JTextField();
		costField = new JTextField();

		addComponents();
	}

	private void addComponents() {
		JPanel panel = new JPanel(); // Sử dụng JPanel để chứa các thành phần
		panel.setLayout(new GridLayout(6, 2)); // GridLayout cho sắp xếp đều các thành phần
		panel.add(titleLabel);        panel.add(titleField);
		panel.add(categoryLabel);     panel.add(categoryField);
		panel.add(directorLabel);     panel.add(directorField);
		panel.add(lengthLabel);       panel.add(lengthField);
		panel.add(costLabel);         panel.add(costField);

		panel.add(addButton);

		frame.add(panel, BorderLayout.CENTER); // Thêm JPanel vào cửa sổ frame
		addButton.addActionListener(e -> addItemToStore()); // Xử lý sự kiện khi nút được nhấn
	}

	@Override
	protected void addItemToStore() {
		try {
			String title = titleField.getText();
			String category = categoryField.getText();
			String director = directorField.getText();
			int length = Integer.parseInt(lengthField.getText());
			float cost = Float.parseFloat(costField.getText());

			// Lấy id mới
			int newId = store.getItemsInStore().size() + 1;

			DigitalVideoDisc dvd = new DigitalVideoDisc(newId, title, category, director, length, cost);
			store.addMedia(dvd);
			JOptionPane.showMessageDialog(frame, "DVD added successfully.");
			StoreManagerScreen mainFrame = new StoreManagerScreen(store);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frame, "Invalid input. Please enter valid numbers for length and cost.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
