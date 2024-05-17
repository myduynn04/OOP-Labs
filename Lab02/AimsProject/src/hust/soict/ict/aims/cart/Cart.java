package hust.soict.ict.aims.cart;
import hust.soict.ict.aims.media.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    //thêm media vào giỏ hàng
    public void addMedia(Media media){
        if(itemsOrdered.size() >= MAX_NUMBERS_ORDERED){
            System.out.println("The cart is full. Please remove some items to continue.");
        }
        else{
            itemsOrdered.add(media);
            System.out.println("The media has been added to the cart");
            if(itemsOrdered.size() >= 18){
                System.out.println("The cart is almost full");
            }
        }
    }

    // xóa media khỏi giỏ hàng
    public void removeMedia(Media media){
        if(itemsOrdered.remove(media)){
            System.out.println("The media has been removed from the cart");
        } else {
            System.out.println("The media is not found in cart.");
        }
    }

    // tổng chi phí
    public double totalCost(){
        double total = 0;
        for(Media media : itemsOrdered){
            total += media.getCost();
        }
        return total;
    }

    // hiển thị danh sách 
    public void orderedItems(){
        if(itemsOrdered.isEmpty()){
            System.out.println("There are no items in the cart.");
        }
        else{
            System.out.println("***********************CART***********************");
            System.out.println("Ordered Items:");
            for(int i = 0; i < itemsOrdered.size(); i++){
                itemsOrdered.get(i).toStringItem(i + 1);
            }
            System.out.println("**************************************************");
            System.out.println("Total Cost is: " + totalCost() + "$");
        }
    }

    //tìm kiếm media theo tiêu đề
    public void searchByTitle(String title){
        if(itemsOrdered.isEmpty()){
            System.out.println("There are no items in the cart.");
        }
        else{
            int count = 0;
            System.out.println("List of items with title \"" + title + "\":");
            for(Media media : itemsOrdered){
                if(media.getTitle().equals(title)){
                    media.toString();
                    count++;
                }
            }
            if(count == 0){
                System.out.println("No items found with title \"" + title + "\" in the cart.");
            }
        }
    }

   
    public int numberDVD(){
        int cnt = 0 ;
        for(Media item : itemsOrdered){
            if(item instanceof DigitalVideoDisc) {
                cnt++;
            }
        }
        return cnt;
    }

    // lọc các phần tử trong giỏ hàng dựa trên tiêu đề
    public void filterByTitle(String title) {
        ArrayList<Media> filteredList = new ArrayList<>();
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                filteredList.add(media);
            }
        }
        if (filteredList.isEmpty()) {
            System.out.println("No items found with title \"" + title + "\" in the cart.");
        } else {
            System.out.println("Items with title \"" + title + "\":");
            for (Media media : filteredList) {
                media.toStringItem(itemsOrdered.indexOf(media) + 1);
            }
        }
    }

    //sắp xếp các phần tử trong giỏ hàng theo tiêu đề
    public void sortByTitle() {
        Collections.sort(itemsOrdered, Comparator.comparing(Media::getTitle));
        System.out.println("Items sorted by title:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            itemsOrdered.get(i).toStringItem(i + 1);
        }
    }

    //sắp xếp các phần tử trong giỏ hàng theo giá
    public void sortByCost() {
        Collections.sort(itemsOrdered, Comparator.comparing(Media::getCost));
        System.out.println("Items sorted by cost:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            itemsOrdered.get(i).toStringItem(i + 1);
        }
    }

    
    public void playMedia(Media media) {
        if (media instanceof DigitalVideoDisc) {
            DigitalVideoDisc dvd = (DigitalVideoDisc) media;
            dvd.play();
        } else {
            System.out.println("Cannot play this type of media.");
        }
    }

    // đặt hàng
    public void placeOrder() {
        System.out.println("An order has been created.");
        itemsOrdered.clear(); 
    }
    public Media searchMedia(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null; 
    }
}