package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Schedule {

    static ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

    public Schedule() throws FileNotFoundException {
        
        File myObj = new File("schedule_data.txt");
        Scanner myReader = new Scanner(myObj);

        ArrayList<String> items = new ArrayList<String>();

        while (myReader.hasNextLine()) {
            String item = myReader.nextLine();
            items.add(item);
        }
        myReader.close();

        for (int i = 0; i < items.size(); i += 2) {
            ArrayList<String> item = new ArrayList<String>();
            item.add(items.get(i));
            item.add(items.get(i+1));
            data.add(item);
        }
        sort_schedule();
    }

    public static void sort_schedule() {

        Collections.sort(data, new Comparator<ArrayList<String>>() {    
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                return Float.compare(Float.parseFloat(o1.get(0).replace(":",".")), Float.parseFloat(o2.get(0).replace(":",".")));
            }
        });
    }

    public void add_item(String time, String task) throws IOException {
        ArrayList<String> item = new ArrayList<String>();
        item.add(time);
        item.add(task);
        data.add(item);
        write_to_file(time, task);
        sort_schedule();
    }

    public static void write_to_file(String time, String task) throws IOException {
        FileWriter myWriter = new FileWriter("schedule_data.txt", true);
        myWriter.write(time + "\n");
        myWriter.write(task + "\n");
        myWriter.close();
    }
}