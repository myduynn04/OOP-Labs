package hust.soict.ict.aims.screen.manager;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hust.soict.ict.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
	protected Store store;
    protected JFrame frame;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        frame = new JFrame();
        frame.setTitle("Add Item to Store");
        frame.setSize(400 , 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
    }

    public void display() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    protected abstract void addItemToStore();
}
