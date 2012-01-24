package mmotest;

public class DataParser {

	private static DataParser instance = null;
	 
    private DataParser() {}
 

    public static DataParser getInstance() {
        if (instance == null) {
            instance = new DataParser();
        }
        return instance;
    }
	
}
