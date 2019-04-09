/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.DvdLibrary.dao;

import com.sg.DvdLibrary.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



public class DvdLibraryDaoFileImpl implements DvdLibraryDao {
    
    public static final String Library_FILE = "library.txt";
	public static final String DELIMITER = "::";
   
    // creates a new HashMap saved to Variable dvds
    private Map <String,Dvd> dvds = new HashMap <>();
//              <key,values>
    
    //adds dvd to Hash
    @Override
    public Dvd addDvd(String Title, Dvd dvd) 
        throws DvdLibraryDaoException {
      Dvd newDvd = dvds.put(Title,dvd);
      writeLibrary();
      return newDvd; 
    }

    //Displays all Dvds in Hash
    @Override
    public List<Dvd> getAllDvds() 
            throws DvdLibraryDaoException {
        loadLibrary();
       return new ArrayList<Dvd>(dvds.values()); 
    }

    //Gets specific Dvd by title
    @Override
    public Dvd getTitle(String title) 
            throws DvdLibraryDaoException {
        loadLibrary();
        return dvds.get(title);
    }

    //Removes Dvd from the Hash
    @Override
    public Dvd removeDvd(String title) 
            throws DvdLibraryDaoException {
       Dvd removedDvd = dvds.remove(title);
       writeLibrary();
       return removedDvd;
    }

    //Edits a dvd 
    //can use the same code for dvd add
    @Override
    public Dvd editDvd(String title, Dvd dvd) 
//       dvds.remove(title);
//        Dvd alteredDvd = dvds.put(title,dvd);
//       return alteredDvd;
    throws DvdLibraryDaoException {
      Dvd newDvd = dvds.put(title,dvd);
      writeLibrary();
      return newDvd; 
    }

    //Searches for Dvd by title
    @Override
    public Dvd searchDvd(String title) 
        throws DvdLibraryDaoException {
        loadLibrary();
       return dvds.get(title); 
    }

   
       public void loadLibrary() throws DvdLibraryDaoException {
        Scanner scanner;
        
        try {
            //Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(Library_FILE)));
        } 
        catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException ("could not load Library data into memory.", e);
        }
         // currentLine holds the most recent line read from the file
        String currentLine;
        String[] currentTokens;
        
        //Goes thorugh Library_File line by line, and decodes each
        //into a studen object.
        //processes while there are more lines in the file
        while (scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            
            currentTokens = currentLine.split(DELIMITER);
            
            Dvd currentDvd = new Dvd(currentTokens[0]);
            //set the reaining values on currentStudents manually
            currentDvd.setDirectorName(currentTokens[1]);
            currentDvd.setMpaaRating(currentTokens[2]);
            currentDvd.setReleaseDate(currentTokens[3]);
            currentDvd.setStudio(currentTokens[4]);
            currentDvd.setUserRating(currentTokens[5]);
            
            //put currentDvd in the map using the title as the key
            dvds.put(currentDvd.getTitle(), currentDvd);
    }
        scanner.close();
     }
 
  
    
  private void writeLibrary() throws DvdLibraryDaoException {
      
      PrintWriter out;
      
      try {
          out= new PrintWriter(new FileWriter(Library_FILE));
      }
      catch (IOException e) {
          throw new DvdLibraryDaoException(
          "could nto save student data " , e);
      }
      
      List<Dvd> dvdList = this.getAllDvds();
      for (Dvd currentDvd : dvdList) {
          out.println (currentDvd.getTitle() + DELIMITER
          + currentDvd.getDirectorName() + DELIMITER
          + currentDvd.getMpaaRating() + DELIMITER
          + currentDvd.getReleaseDate() + DELIMITER
          + currentDvd.getStudio() + DELIMITER
          + currentDvd.getUserRating());
          
          out.flush();
          
      }
      
      out.close();
  }      
      
      
  }
   
    
     

