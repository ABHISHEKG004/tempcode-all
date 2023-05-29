package MCexamples.LineTextEditor.processor;

import com.design.lowlevel.mine.LineTextEditor.datastore.DataStore;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by abhishek.gupt on 08/01/18.
 */
public class TextEditorProcessor {

    public boolean checkFileEmpty(ArrayList<String> fileContents) {
        if (fileContents.size() == 0) {
            System.out.println("file is empty");
            return true;
        }
        return false;
    }
    public void displayAll(){
        ArrayList<String> fileContents = DataStore.getUserDataStore();
        if(checkFileEmpty(fileContents)){
            return;
        }
        for(int i =0;i<fileContents.size();i++){
            System.out.println(fileContents.get(i));
        }
    }

    public void displaySpecificLines(Scanner sc) {
        ArrayList<String> fileContents = DataStore.getUserDataStore();
        if(checkFileEmpty(fileContents)){
            return;
        }
        System.out.println("Enter the range of lines you want to view");

        int n;
        int m;
        while(true) {
            n = sc.nextInt();
            m = sc.nextInt();

            if (n <= m && n<fileContents.size() && m<fileContents.size()) {
                break;
            } else {
                System.out.println("Enter valid range of line numbers");
            }
        }

        for(int i =n;i<(m+1);i++){
            System.out.println(fileContents.get(i));
        }

    }

    public void insertLine(Scanner sc) {

        ArrayList<String> fileContents = DataStore.getUserDataStore();
        System.out.println("Enter the position of line you want to insert");
        int n;
        while(true) {

            n = sc.nextInt();

            if (n<=fileContents.size()) {
                break;
            } else {
                System.out.println("Enter valid position of line you want to insert");
            }
        }
        String temp =sc.nextLine();
        System.out.println("Enter the line you want to insert");
        String line = sc.nextLine();
        fileContents.add(n, line);

    }

    public void deleteOneLine(Scanner sc) {

        ArrayList<String> fileContents = DataStore.getUserDataStore();
        if(checkFileEmpty(fileContents)){
            return;
        }
        System.out.println("Enter the position of line you want to delete");
        int n;
        while(true) {
            n = sc.nextInt();

            if (n<fileContents.size()) {
                break;
            } else {
                System.out.println("Enter valid position of line you want to delete");
            }
        }

        fileContents.remove(n);

    }

    public void deleteMoreThanOneLine(Scanner sc) {

        ArrayList<String> fileContents = DataStore.getUserDataStore();
        if(checkFileEmpty(fileContents)){
            return;
        }
        System.out.println("Enter the range of lines you want to delete");
        int n;
        int m;
        while(true) {
            n = sc.nextInt();
            m = sc.nextInt();

            if (n <= m && n<fileContents.size() && m<fileContents.size()) {
                break;
            } else {
                System.out.println("Enter valid range of line numbers");
            }
        }

        for(int i=m;i>=n;i--){
            fileContents.remove(i);
        }

    }

    public void copyLines(ArrayList<String> copiedLines, Scanner sc) {

        ArrayList<String> fileContents = DataStore.getUserDataStore();
        if(checkFileEmpty(fileContents)){
            return;
        }
        System.out.println("Enter the range of lines you want to copy");
        int n;
        int m;
        while(true) {
            n = sc.nextInt();
            m = sc.nextInt();

            if (n <= m && n<fileContents.size() && m<fileContents.size()) {
                break;
            } else {
                System.out.println("Enter valid range of line numbers to copy");
            }
        }

        for(int i =n;i<(m+1);i++){
            copiedLines.add(fileContents.get(i));
        }

    }

    public void pasteLines(ArrayList<String> copiedLines, Scanner sc) {

        ArrayList<String> fileContents = DataStore.getUserDataStore();
        if(checkFileEmpty(fileContents)){
            return;
        }
        System.out.println("Enter the position of line at which you want to paste");
        int n;
        while(true) {
            n = sc.nextInt();
            if (n<fileContents.size()) {
                break;
            } else {
                System.out.println("Enter valid position at which you want to paste");
            }
        }

        for(int i =0;i<copiedLines.size();i++){
            fileContents.add(n+i, copiedLines.get(i));
        }

    }
}
