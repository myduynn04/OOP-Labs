package hust.soict.ict.aims.media;

public class Disc extends Media{
	 protected String director;
	    protected int length;
	    public Disc(String title, String category,String director,int length, float cost) {
	        super(title,category,cost);
	        this.director = director;
	        this.length = length;
	    }
	    public String getDirector() {
	        return director;
	    }
	    public int getLength() {
	        return length;
	    }
	    public int getId(){
	        return id;
	    }
	    public String getTitle() {
	        return title;
	    }
	    public String getCategory() {
	        return category;
	    }
	    public double getCost() {
	        return cost;
	    }
	    public boolean isMatchItem(Disc item) {
	        return this.id == item.id &&
	        this.title.equals(item.getTitle())&& 
	        this.category.equals(item.getCategory()) &&
	        this.cost == item.cost && 
	        this.director.equals(item.getDirector()) && 
	        this.length == item.length;
	    }
}
