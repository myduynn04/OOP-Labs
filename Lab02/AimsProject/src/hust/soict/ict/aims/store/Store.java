package hust.soict.ict.aims.store;
import hust.soict.ict.aims.media.DigitalVideoDisc;
public class Store {
	    private DigitalVideoDisc[] itemsInStore;
	    private int itemCount; // Current number of DVDs in the store
	    
	    // Constructor
	    public Store(int capacity) {
	        itemsInStore = new DigitalVideoDisc[capacity];
	        itemCount = 0;
	    }
	    
	    // Method to add a DVD to the store
	    public void addDVD(DigitalVideoDisc dvd) {
	        if (itemCount < itemsInStore.length) {
	            itemsInStore[itemCount] = dvd;
	            itemCount++;
	            System.out.println("DVD added to the store.");
	        } else {
	            System.out.println("The store is full. Cannot add more DVDs.");
	        }
	    }
	    
	    // Method to remove a DVD from the store
	    public void removeDVD(int index) {
	        if (index >= 0 && index < itemCount) {
	            for (int i = index; i < itemCount - 1; i++) {
	                itemsInStore[i] = itemsInStore[i + 1];
	            }
	            itemsInStore[itemCount - 1] = null;
	            itemCount--;
	            System.out.println("DVD removed from the store.");
	        } else {
	            System.out.println("Invalid index. Cannot remove DVD.");
	        }
	    }
}
