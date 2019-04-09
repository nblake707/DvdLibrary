/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.DvdLibrary.Controller;


import com.sg.DvdLibrary.dao.DvdLibraryDao;
import com.sg.DvdLibrary.dao.DvdLibraryDaoException;
import com.sg.DvdLibrary.dto.Dvd;
import com.sg.DvdLibrary.ui.DvdLibraryView;
//import com.sg.DvdLibrary.ui.UserIO;
//import com.sg.DvdLibrary.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author Blake
 */
public class DvdLibraryController {
    
//    private UserIO io = new UserIOConsoleImpl(); 
    private DvdLibraryView view;
    private DvdLibraryDao dao;
    
    public DvdLibraryController(DvdLibraryDao dao, DvdLibraryView view) {
    this.dao = dao;
    this.view = view;
}
    
    
    public void Run(){
      boolean keepGoing = true;
      int menuSelection = 0;
      
      try{
       while (keepGoing) {
           
           menuSelection = getMenuSelection();
	      

	            switch (menuSelection) {
	                case 1:
	                    
                            createDvd();
	                    break;
	                case 2:
	                    
                            removeDvd();
	                    break;
	                case 3:
	                    
                            editDvd();
	                    break;
	                case 4:
	              
                            listDvds();
	                    break;
                        case 5:
	                    viewDvd();
	                    break;
                        case 6:
	                    searchDvd();
	                    break;
	                case 7:
	                    keepGoing = false;
	                    break;
                      
	                default:
	                  unknownCommand();
	            }

	        }
	        exitMessage();
    }
      catch ( DvdLibraryDaoException e) {
          view.displayErrorMessage(e.getMessage());
      }
    }
    
    
      private int getMenuSelection() {
	  return view.printMenuAndGetSelection();
      }

    private void createDvd() throws DvdLibraryDaoException{
       
        view.displayCreateDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(),newDvd);
        view.displayCreateDvdBanner();
    }
    
    private void editDvd() throws DvdLibraryDaoException{
        view.displayEditDvdBanner();
        String title = view.getDvdChoice();
        dao.removeDvd(title);
        Dvd editedDvd = view.getNewDvdInfo();
        dao.editDvd(editedDvd.getTitle(), editedDvd);
        view.displayEditSuccessBanner();
        
    }

    private void removeDvd() throws DvdLibraryDaoException {
	    view.displayRemoveDvdBanner();
	    String title = view.getDvdChoice();
	    dao.removeDvd(title);
	    view.displayRemoveSuccessBanner();
	}
    
    	private void listDvds() throws DvdLibraryDaoException {
	    view.displayDisplayAllBanner();
	    List<Dvd> dvdList = dao.getAllDvds();
	    view.displayDvdList(dvdList);
	}
        
       private void viewDvd() throws DvdLibraryDaoException {
	    view.displayDisplayDvdBanner();
	    String title = view.getDvdChoice();
	    Dvd dvd = dao.getTitle(title);
	    view.displayDvd(dvd);
	}
       
       private void searchDvd() throws DvdLibraryDaoException{
             view.displayDisplayDvdBanner();
	    String title = view.getDvdChoice();
	    Dvd dvd = dao.getTitle(title);
	    view.displayDvd(dvd);
       }
       
       private void unknownCommand() {
        view.displayUnknownCommandBanner();
}

    private void exitMessage() {
        view.displayExitBanner();
}

   
}
