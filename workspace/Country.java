//
//  Class author:  Noah Raigrodski
//  Date due:  1/14/25
//  General description: This class creates the blueprint for a country object with a name, capital, language, and image file
//
public class Country {
  // Instance variables
  private String name;
  private String capital;
  private String language;
  private String imageFile;

  // Default constructor
  public Country() {
    name = "The United States";
    capital = "Washington D.C.";
    language = "English";
    imageFile = "US.jpg";
  }

  // Parameterized constructor
  public Country(String name, String capital, String language, String imageFile) {
    this.name = name;
    this.capital = capital;
    this.language = language;
    this.imageFile = imageFile;
  }

  // Accessor methods
  public String getName() {
    return name;
  }

  public String getCapital() {
    return capital;
  }

  public String getLanguage() {
    return language;
  }

  public String getImageFile() {
    return imageFile;
  }

  // Mutator methods
  public void setName(String name) {
    this.name = name;
  }

  public void setCapital(String capital) {
    this.capital = capital;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public void setImageFile(String imageFile) {
    this.imageFile = imageFile;
  }

  // toString method returns a string of all the country's instance variables
  public String toString() {
    return "The country is " + name + " and its capital is " + capital + " and its primary language is " + language;
  }

}