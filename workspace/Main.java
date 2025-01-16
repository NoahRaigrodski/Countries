//
//  Class author:  Noah Raigrodski
//  Date due:  1/14/25
//  General description: This class uses a GUI and the Country class to make a quiz game where you guess certain attributes of a Country
//
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Main 
{

  // array of 10 Country objects
  private Country[] countryArray = new Country[10];  
  // index of current shown country
  private int index = 0;
  private int questIndex = 0;

  // GUI elements
  private JFrame jFrame = new JFrame("Countries");
  private ImageIcon img;
  private JLabel imageLabel;
  private JLabel outputLabel;
  private JTextField input;
  
  public static void main(String[] args) {
    // Create the GUI
    Main gui = new Main();
    gui.loadCountries();
  }

  // loadCountries() reads in the data from the countries-data.csv file and fills in the countryArray with data.
  //
	// Pre-condition: none
	// Post-condition: an array of Country objects is created
	//
  public void loadCountries() 
  {
    // Open the data file - do not change
    File file = new File("/workspaces/Countries/workspace/countries-data.csv");
    Scanner scan = null;
    try {
      scan = new Scanner(file);
    } catch(FileNotFoundException e) { 
        System.out.println("File not found");     
    }
    
     for (int i = 0; i < countryArray.length; i++) {
      String input = scan.nextLine();
      String[] data = input.split(",");
      System.out.println("Read in " + data[0]);
      Country newCountry = new Country(data[0], data[1], data[2], data[3]);
      countryArray[i] = newCountry;
    }
     
    
  }

  //
	// Pre-condition: a countryArray exists
	// Post-condition: The image displayed in the GUI is updated
	//
  public void showCountry() {
    // Get the country at index from countryArray
    // Use its get method to get the its image file name and save it into imagefile
    // variable below instead of worldmap.jpg.
    String imagefile = countryArray[index].getImageFile();
    // Use the following code to create an new Image Icon and put it into the GUI
    img = new ImageIcon("/workspaces/Countries/workspace/"+imagefile);
    imageLabel.setIcon(img);
  }
  
  //
	// Pre-condition: None
	// Post-condition: Index is increased or reset to 0, output and input labels are cleared, showCountry is called
	//
  public void nextButtonClick() {
    index += 1;
    if (index > 9) {
      index = 0;
    }

    outputLabel.setText("");
    input.setText("");
    showCountry();
  }
  
  //
	// Pre-condition: A countryArray exists
	// Post-condition: The toString method for Country objects is called and displayed on the GUI
	//
  public void reviewButtonClick() {
    String toString = countryArray[index].toString();
    System.out.println(toString);
    outputLabel.setText(toString);
  }

  //
	// Pre-condition: None
	// Post-condition: questIndex is assigned a random value, a question is chosen from the questions array, that question is displayed
	//
  public void quizButtonClick() {
    input.setText("");
    String[] questions = new String[] {"What country is this?", "What is the primary language spoken in this country?", "What is this country's capital?"};
    questIndex = (int)(Math.random()*3);

    outputLabel.setText(questions[questIndex]);
    System.out.println(questions[questIndex]);
    showCountry();
  }

  //
	// Pre-condition: None
	// Post-condition: The GUI is updated to display whether the user's answer was correct or not
	//
  public void confirmButtonClick() {
    String answer = "";
    if (questIndex == 0){
      answer = countryArray[index].getName();
    }
    else if (questIndex == 1){
      answer = countryArray[index].getLanguage();
    }
    else if (questIndex == 2){
      answer = countryArray[index].getCapital();
    }

    if (input.getText().contentEquals(answer)) {
      outputLabel.setText("Correcto!");
    } else {
      outputLabel.setText("Falso! The answer was " + answer);
    }  
  }




  /* Do NOT change anything below here */
  /* The Main() constructor is finished and will construct the GUI */
public Main() {
    jFrame.setLayout(new FlowLayout());
    jFrame.setSize(500, 360);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // buttons at the top
        JButton reviewButton = new JButton("Review");
        JButton quizButton = new JButton("Quiz");
        JButton newButton = new JButton("Next");
        JButton confirmButton = new JButton("Confirm");
        jFrame.add(reviewButton);
        jFrame.add(quizButton);
        jFrame.add(newButton);
        jFrame.add(confirmButton);
        
        // create a new image icon
        img = new ImageIcon("/workspaces/Countries/workspace/worldmap.jpg");
        // create a label to display image
        imageLabel = new JLabel(img);
        // and one for output
        outputLabel = new JLabel();
        jFrame.add(imageLabel);
        jFrame.add(outputLabel);
        jFrame.setVisible(true);

        input = new JTextField(20);
        jFrame.add(input);

        // add event listener for button click
        reviewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      reviewButtonClick();
    }
        });
    quizButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      quizButtonClick();
    }
    });
   
   newButton.addActionListener(new ActionListener()  {
    public void actionPerformed(ActionEvent e) 
    {
      nextButtonClick();
    }
   });

   confirmButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      confirmButtonClick();
    }
  });
   
}
  

}
