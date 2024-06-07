package hust.soict.ict.aims.store;

import java.util.ArrayList;

import hust.soict.ict.aims.media.*;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();
    private int qtyItem = 0;

    public void initData() {
        // Book
        addMedia(new Book(1, "Naruto", "Manga", "Masashi Kishimoto", 25.0f, 123));
        addMedia(new Book(2, "One Piece", "Manga", "Eiichiro Oda", 20.0f, 124));
        addMedia(new Book(3, "Attack on Titan", "Manga", "Hajime Isayama", 30.0f, 125));
        addMedia(new Book(4, "Fullmetal Alchemist", "Manga", "Hiromu Arakawa", 28.0f, 126));
        addMedia(new Book(5, "Death Note", "Manga", "Tsugumi Ohba", 35.0f, 127));
        addMedia(new Book(6, "My Hero Academia", "Manga", "Kohei Horikoshi", 18.0f, 128));
        addMedia(new Book(7, "To Kill a Mockingbird", "Literature", "Harper Lee", 25.0f, 133));
        addMedia(new Book(8, "1984", "Literature", "George Orwell", 20.0f, 134));

        // DigitalVideoDisc
        addMedia(new DigitalVideoDisc(9, "Spirited Away", "Animation", "Hayao Miyazaki", 125, 15.0f));
        addMedia(new DigitalVideoDisc(10, "Toy Story", "Animation", "John Lasseter", 81, 18.0f));
        addMedia(new DigitalVideoDisc(11, "The Lion King", "Animation", "Roger Allers", 88, 20.0f));
        addMedia(new DigitalVideoDisc(12, "Finding Nemo", "Animation", "Andrew Stanton", 100, 16.0f));
        addMedia(new DigitalVideoDisc(13, "Shrek", "Animation", "Andrew Adamson", 90, 17.0f));

        // CompactDisc
        CompactDisc cd1 = new CompactDisc(14, "Minisode 3: Tomorrow", "Pop", "hitman bang", "tubatu", 40, 12.0f);
        cd1.addTrack(new Track("Deja vu", 4));
        cd1.addTrack(new Track("The Killa", 5));
        cd1.addTrack(new Track("Miracle", 3));
        addMedia(cd1);

        CompactDisc cd2 = new CompactDisc(15, "The dream chapter: Star", "Rock", "rabbit", "TXT", 65, 14.0f);
        cd2.addTrack(new Track("Crown", 5));
        cd2.addTrack(new Track("Cat & Dog", 5));
        cd2.addTrack(new Track("Our Summer", 3));
        addMedia(cd2);

        CompactDisc cd3 = new CompactDisc(16, "The dream chapter: Eternity", "Pop", "slow", "Tomorrow X Together", 65, 14.0f);
        cd3.addTrack(new Track("Can't you see me", 5));
        cd3.addTrack(new Track("Fairy of Shampoo", 5));
        cd3.addTrack(new Track("Puma", 3));
        cd3.addTrack(new Track("Drama", 4));
        addMedia(cd3);
    }

    public int getQuantity() {
        return this.qtyItem;
    }

    public void addMedia(Media media) {
        for (Media item : itemsInStore) {
            if (item.isMatchItem(media)) {
                System.out.println("This item is already in the store");
                return;
            }
        }
        itemsInStore.add(media);
        qtyItem++;
    }

    public void removeMedia(Media media) {
        boolean found = false;
        for (int i = 0; i < itemsInStore.size(); i++) {
            if (itemsInStore.get(i).isMatchItem(media)) {
                itemsInStore.remove(i);
                qtyItem--;
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Item not found in store");
        }
    }

    public void listItem() {
        if (qtyItem <= 0) {
            System.out.println("There are no items in the store.");
        } else {
            System.out.println("*********************** STORE ***********************");
            System.out.println("Store");
            int cnt = 1;
            for (Media media : itemsInStore) {
                media.toStringItem(cnt);
                cnt++;
            }
        }
    }

    public Media searchMedia(Media item) {
        for (Media media : itemsInStore) {
            if (media.isMatchItem(item)) {
                return media;
            }
        }
        return null;
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public ArrayList<Media> getItemsInStore() {
        return this.itemsInStore;
    }
}
