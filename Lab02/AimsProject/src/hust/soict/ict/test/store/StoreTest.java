package hust.soict.ict.test.store;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.store.Store;
public class StoreTest {
	public static void main(String[] args) {
        // Create a store with capacity for 5 DVDs
        Store store = new Store(5);
        
        // Create some DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Title 1", "Category 1", 10.0f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Title 2", "Category 2", 12.0f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Title 3", "Category 3", 15.0f);
        
        // Add DVDs to the store
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);
        
        // Remove a DVD from the store
        store.removeDVD(1); 
        
        // Test removing a non-existing DVD
        store.removeDVD(2); 
    }
}
