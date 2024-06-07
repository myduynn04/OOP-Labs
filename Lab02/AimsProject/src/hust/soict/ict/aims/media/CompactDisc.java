package hust.soict.ict.aims.media;

import hust.soict.ict.aims.exception.PlayerException;
import javafx.scene.control.Alert;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> trackList = new ArrayList<>();
    private int numberOfSong = 0;

    public CompactDisc(int id, String title, String category, String director, String artist, int length, float cost) {
        super(id, title, category, director, length, cost);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void play() throws PlayerException {
        System.out.println("=======START PLAY TRACKS LIST=======");
        if (!trackList.isEmpty()) {
            for (Track track : trackList) {
                try {
                    track.play();
                } catch (PlayerException e) {
                    throw e;
                }
            }
            // Hiển thị thông tin đĩa CD sau khi các track đã được phát
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Play CD");

            StringBuilder content = new StringBuilder();
            content.append("Title: ").append(getTitle()).append("\n");
            content.append("Category: ").append(getCategory()).append("\n");
            content.append("Director: ").append(getDirector()).append("\n");
            content.append("Artist: ").append(artist).append("\n");
            content.append("List of track: ").append("\n");
            for (Track track : trackList) {
                content.append("\t").append(track.getTitle()).append("\n");
            }
            content.append("Total Length: ").append(getLength()).append("\n");
            content.append("Cost: ").append(getCost()).append("\n");

            alert.setHeaderText(getTitle());
            alert.setContentText(content.toString());
            alert.setResizable(true);
            alert.showAndWait();
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }

    public void addTrack(Track musicSongInput) {
        for (Track musicSong : trackList) {
            if (musicSong.isMatch(musicSongInput)) {
                System.out.println("This track is already in the CD");
                return;
            }
        }
        trackList.add(musicSongInput);
        numberOfSong++;
    }

    public void removeTrack(Track musicSongInput) {
        for (int i = 0; i < trackList.size(); i++) {
            if (trackList.get(i).isMatch(musicSongInput)) {
                trackList.remove(i);
                numberOfSong--;
                return;
            }
        }
        System.out.println("Track not found in TrackList");
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : trackList) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    public int getTrack() {
        return numberOfSong;
    }

    @Override
    public void toStringItem(int order) {
        System.out.println(order + ".CompactDisc - " + this.getId() + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getArtist() + " - " + this.getLength() + " - " + this.getCost() + " $");
    }

    public boolean isMatchItem(CompactDisc item) {
        return this.id == item.id &&
                this.title.equals(item.getTitle()) &&
                this.category.equals(item.getCategory()) &&
                this.cost == item.cost &&
                this.director.equals(item.getDirector()) &&
                this.length == item.length &&
                this.artist.equals(item.getArtist());
    }
}
