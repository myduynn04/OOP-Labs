package hust.soict.ict.aims.test.cart;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.media.*;

public class CartTest {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King",
                "Animation", "Roger Allers", 87, 199);
        anOrder.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars",
                "Science Fiction", "George Lucas", 87, 143);
        anOrder.addMedia(dvd2);



        CompactDisc cd1 = new CompactDisc(4, "Best of 80s", "Music", "Various Artists", "Duong", 153, 1223);
        anOrder.addMedia(cd1);

        anOrder.searchByTitle("The Lion King");
    }
}
