package hust.soict.ict.test.cart;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.media.DigitalVideoDisc;
public class CartTest {
	

	    public static void main(String[] args) {
	        // Create a new cart
	        Cart cart = new Cart();

	        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
	        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
	        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
	        
	        // Adding DVDs to the cart
	        cart.addDigitalVideoDisc(dvd3);
	        cart.addDigitalVideoDisc(dvd2);
	        
	        // Printing the content of the cart
	        cart.print();
	        //Test for search
	        cart.searchByTitle("Star Wars1");
	    }
	}


