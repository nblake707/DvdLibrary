/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.DvdLibrary.ui;

import com.sg.DvdLibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author Blake
 */
public class DvdLibraryView {
    
    UserIO io;
    
    public DvdLibraryView(UserIO io) {
    this.io = io;
}
    
    
    public int printMenuAndGetSelection(){
          io.print("Main Menu");
	            io.print("1. Add New DVD");
	            io.print("2. Remove DVD");
	            io.print("3. Edit Existing DVD Information");
	            io.print("4. List All DVDs");
                    io.print("5. Display DVD Information");
                    io.print("6. Search by title");
	            io.print("7. Exit");
                    
                    return io.readInt("Please select from the above choices.", 1, 7);
    }
    
    //creating a new Dvd
    public Dvd getNewDvdInfo() {
	    String title = io.readString("Please enter Title.");
	    String releaseDate = io.readString("Please enter Release Date.");
	    String mpaaRating = io.readString("Please enter MPAA Rating.");
	    String directorName = io.readString("Please enter the Director.");
            String studio = io.readString("Please enter Studio");
            String userRating = io.readString("Please enter a Rating/Comment.");
            
	    Dvd currentDvd = new Dvd(title);
	    currentDvd.setReleaseDate(releaseDate);
	    currentDvd.setMpaaRating(mpaaRating);
            currentDvd.setDirectorName(directorName);
            currentDvd.setStudio(studio);
            currentDvd.setUserRating(userRating);
	    return currentDvd;
	}
    
    	public void displayCreateDvdBanner() {
	    io.print("=== Create Dvd ===");
	}
	
	public void displayCreateSuccessBanner() {
	    io.readString(
	            "New title successfully created.  Please hit enter to continue");
	}
        
        // Displaying all Dvds
	
        public void displayDvdList(List<Dvd> dvdList) {
	    for (Dvd currentDvd : dvdList) {
	        io.print(currentDvd.getTitle() + ": "
	                + currentDvd.getReleaseDate() + " / "
	                + currentDvd.getDirectorName() + " / " 
                        + currentDvd.getMpaaRating() + " / "
                        + currentDvd.getStudio() + " / "
                        + currentDvd.getUserRating());
	    }
	    io.readString("Please hit enter to continue.");
	}
        
        public void displayDisplayAllBanner() {
	    io.print("=== Display All Dvds ===");
	}
        
        
        //Display single dvd
        public void displayDisplayDvdBanner () {
	    io.print("=== Display a Dvd ===");
	}

	public String getDvdChoice() {
	    return io.readString("Please enter title.");
	}

	public void displayDvd(Dvd dvd) {
	    if (dvd != null) {
	         io.print(dvd.getTitle() + ": "
	                + dvd.getReleaseDate() + " / "
	                + dvd.getDirectorName() + " / " 
                        + dvd.getMpaaRating() + " / "
                        + dvd.getStudio() + " / "
                        + dvd.getUserRating());
	    } else {
	        io.print("No such dvd.");
	    }
	    io.readString("Please hit enter to continue.");
	}
        
        //Delete Dvd
        public void displayRemoveDvdBanner () {
	    io.print("=== Remove Dvd ===");
	}

	public void displayRemoveSuccessBanner () {
	    io.readString("Dvd successfully removed. Please hit enter to continue.");
	}
        
        //Edit Dvd
        
        public void displayEditDvdBanner () {
	    io.print("=== Edit Student ===");
	}

	public void displayEditSuccessBanner () {
	    io.readString("Dvd successfully edited. Please hit enter to continue.");
	}
        
        public void displayExitBanner() {
    io.print("Good Bye!");
}

public void displayUnknownCommandBanner() {
    io.print("Unknown Command!");
}

public void displayErrorMessage(String errorMsg) {
	    io.print("=== ERROR ===");
	    io.print(errorMsg);
	}
	
}
