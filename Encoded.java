import java.util.*;
import javax.swing.JOptionPane;
import java.awt.*;

//Main Function
public class Encoded {

    public static void main(String[] args) {

        //Variable declaration
        String inputText;
        int charCount;
        String resultText;
        String groupID = "G02/SE";

        //User input String
        inputText = JOptionPane.showInputDialog("Enter your full name in lowercase:");

        if (checkStringValidity(inputText)){
            charCount = countCharacters(inputText);
            JOptionPane.showMessageDialog(null, "Total number of characters are " + charCount);
            int groupShift = generateShift(groupID);
            int finalShift = groupShift + charCount;

            //required UI
            JFrame frame = new JFrame("Final Shift Result");
            frame.setSize(250, 150);
            frame.setLayout(new FlowLayout());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel label = new JLabel("Final Shift:");
            JTextField field = new JTextField(10);
            field.setText(String.valueOf(finalShift));
            field.setEditable(false);

            frame.add(label);
            frame.add(field);

            frame.setVisible(true);
        }
        else 
            JOptionPane.showMessageDialog(null, "Your input is not a String in lowercase!");
    }


//Subclass: To validate String Characters - Only accepts lowercase letters and whitespace
public static boolean checkStringValidity(String inputText){
    String input = inputText.replaceAll(" ", ""); //To remove whitespace from the String

    //To loop through each character in the String
    for (char str : input.toCharArray()){
        //Condition: Check if characters are lower than 'a' and larger than 'z'
        if (str < 'a' || str > 'z'){
            return false;
        }
        //Otherwise, it is lowercase letters!
        else
            continue;
    }
    return true;
}

// Subclass: Count Characters
public static int countCharacters(String inputText){
    //Count characters in String excluding the whitespace
    int count = inputText.replace(" ", "").length();
    return count;
}
// ================= MEMBER 2 =================
// Contributed by: Ailin Najwa
// Role: Hashing & Shift Engine
// - Generates groupShift using hashCode()
// - Ensures shift range between 1 and 10
// - Supports finalShift calculation
  public static int generateShift(String groupID) {
        int hash = Math.abs(groupID.hashCode()); //convert to positive number
          // ensure value between 1 and 10
        return (hash % 10) + 1;
    }
}
