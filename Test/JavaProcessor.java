import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class JavaProcessor extends Application {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<String> list= new ArrayList<String>();

        System.out.println("Please enter the file name: ");
        String filename = scan.next();

        try {
            Scanner fileScanner = new Scanner(new File(filename));
            while(fileScanner.hasNextLine()) {
                list.add(fileScanner.nextLine());
            }
        }catch(FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "File not found");
        }
    }

    //Method to fix comments(returns ArrayList)
    public static ArrayList<String> fixComment(ArrayList<String> list){

        Iterator itr = list.listIterator();
        int count=0;
        String str;

        //Loop thru ArrayList elements
        while(itr.hasNext()){
            str = list.get(count);

            //Make sure the element is not empty...otherwise do not execute this block
            if(!str.isEmpty()) {
                if (str.charAt(0) == '/' && str.charAt(1) != '/')
                    str = "/" + str;

                if (str.startsWith("//") && !str.endsWith("."))
                    str = str + ".";

                list.set(count, str);
            }
            count++;

            //Break out once the size of the ArrayList has been reached to avoid
            //IndexOutOfBounds Exception
            if(count == list.size())
                break;
        }
        return list;
    }

}
