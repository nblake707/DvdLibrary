/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.DvdLibrary.dao;

import com.sg.DvdLibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author Blake
 */
public interface DvdLibraryDao {
    //CRUD
    //Create
    //ReadAll
    //ReadByName
    //Update
    //Delete
    
    //add save method
    
    
    
//   void writeLibrary();
//   void loadLibrary();
    Dvd addDvd (String Title, Dvd dvd)
     throws DvdLibraryDaoException;
    
    List <Dvd> getAllDvds()
     throws DvdLibraryDaoException;
    
    Dvd getTitle(String title)
     throws DvdLibraryDaoException; 
    
    Dvd removeDvd(String title)
     throws DvdLibraryDaoException;
    
    Dvd editDvd(String title, Dvd dvd)
      throws DvdLibraryDaoException;
//    Dvd displayInfo(String title);
    Dvd searchDvd(String title)
      throws DvdLibraryDaoException;
    
    
        
 
}
