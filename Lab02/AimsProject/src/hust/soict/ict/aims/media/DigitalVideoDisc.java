package hust.soict.ict.aims.media;

import hust.soict.ict.aims.exception.PlayerException;
import javafx.scene.control.Alert;

public class DigitalVideoDisc extends Disc implements Playable {
    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, director, length, cost);
    }

    @Override
    public void play() throws PlayerException {
        if (length > 0) {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Play DVD");

            StringBuilder content = new StringBuilder();
            content.append("Title: ").append(getTitle()).append("\n");
            content.append("Category: ").append(getCategory()).append("\n");
            content.append("Director: ").append(getDirector()).append("\n");
            content.append("Length: ").append(getLength()).append("\n");
            content.append("Cost: ").append(getCost()).append("\n");

            alert1.setHeaderText(getTitle());
            alert1.setContentText(content.toString());
            alert1.setResizable(true);
            alert1.showAndWait();
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive");
        }
    }

    @Override
    public void toStringItem(int order) {
        System.out.println(order + ".DVD - " + this.getId() + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + " - " + this.getCost() + " $");
    }

    public boolean isMatchTitle(String title) {
        return this.getTitle().equals(title);
    }

    public boolean isMatchItem(DigitalVideoDisc item) {
        return this.id == item.id &&
                this.title.equals(item.getTitle()) &&
                this.category.equals(item.getCategory()) &&
                this.cost == item.cost &&
                this.director.equals(item.getDirector()) &&
                this.length == item.length;
    }
}
