package cricket;

import cricket.cricsheet.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String file = "/Users/sjain68/Downloads/odis/225171.yaml";
        CricSheet data = CricSheet.readFromFile(file);
        System.out.println("Hello World!");
    }
}
