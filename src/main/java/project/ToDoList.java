package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class ToDoList {
    
    static ArrayList<String> data = new ArrayList<String>();

    public ToDoList() throws FileNotFoundException{
        File myObj = new File("ToDo_data.txt");
        Scanner myReader = new Scanner(myObj);

        while (myReader.hasNextLine()) {
            String item = myReader.nextLine();
            data.add(item + "\n");
        }
        myReader.close();
    }

    public void add_item(String item) throws IOException {
        data.add(item);
        write_to_file("ToDo_data.txt", item);
    }

    public void write_to_file(String filename, String item) throws IOException {
        FileWriter myWriter = new FileWriter(filename, true);
        myWriter.write(item + "\n");
        myWriter.close();
    }

    public void remove_item(int index) throws IOException {
        data.remove(index);
        
        File tempFile = new File("tempFile.txt");
        for (int i = 0; i < data.size(); i++) {
            if (i != index) {
                write_to_file("tempFile.txt",data.get(i));
            }
        }

        File oldfile = new File("ToDo_data.txt");
        oldfile.delete();
        File dump = new File("ToDo_data.txt");
        tempFile.renameTo(dump);
    }

    public int data_size() {
        return data.size();
    }

    public void print_data() {
        System.out.println("");
        for (int i = 0; i < data.size(); i++) {
            System.out.println(i+1 + " - " + data.get(i));
        }
    }
}
