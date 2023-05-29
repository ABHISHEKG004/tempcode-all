package MCexamples.LineTextEditor.service;

import com.design.lowlevel.mine.LineTextEditor.processor.TextEditorProcessor;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by abhishek.gupt on 08/01/18.
 */
public class UiService {

    public ArrayList<String> copiedLines = new ArrayList<String>();

    //public Stack

    public void askUserForInput(){

        System.out.println("COMMANDS : ");
        System.out.println("Select 1 to display");
        System.out.println("Select 2 to display specific lines");
        System.out.println("Select 3 to insert lines");
        System.out.println("Select 4 to delete one line");
        System.out.println("Select 5 to delete more than one line");
        System.out.println("Select 6 to copy lines");
        System.out.println("Select 7 to paste lines");
        System.out.println("Select 8 to undo last command");
        System.out.println("Select 9 to redo last undone command");

        Scanner sc = new Scanner(System.in);
        while(true) {


            int val = sc.nextInt();

            TextEditorProcessor textEditorProcessor = new TextEditorProcessor();

            switch (val) {
                case 1:
                    textEditorProcessor.displayAll();
                    break;
                case 2:
                    textEditorProcessor.displaySpecificLines(sc);
                    break;
                case 3:
                    textEditorProcessor.insertLine(sc);
                    break;
                case 4:
                    textEditorProcessor.deleteOneLine(sc);
                    break;
                case 5:
                    textEditorProcessor.deleteMoreThanOneLine(sc);
                    break;
                case 6:
                    textEditorProcessor.copyLines(copiedLines, sc);
                    break;
                case 7:
                    textEditorProcessor.pasteLines(copiedLines, sc);
                    break;
                case 8:
                    //textEditorProcessor.undo(copiedLines, sc);
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

}
