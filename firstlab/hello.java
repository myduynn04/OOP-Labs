package firstlab;

public class hello {
	public class Main {
	    public static void main(String[] args) {
	        StringBuffer buffer = new StringBuffer(15);
	        buffer.append("This is ");
	        buffer.append("String");
	        buffer.insert(7, " a");
	        buffer.append('.');
	        System.out.println(buffer.length());
	        System.out.println(buffer.capacity());
	        String output = buffer.toString();
	        System.out.println(output);
	    }
	}


}
