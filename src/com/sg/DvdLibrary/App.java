/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.DvdLibrary;



import com.sg.DvdLibrary.Controller.DvdLibraryController;
import com.sg.DvdLibrary.dao.DvdLibraryDao;
import com.sg.DvdLibrary.dao.DvdLibraryDaoFileImpl;
import com.sg.DvdLibrary.ui.DvdLibraryView;
import com.sg.DvdLibrary.ui.UserIO;
import com.sg.DvdLibrary.ui.UserIOConsoleImpl;



/**
 *
 * @author Blake
 */
public class App {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
    UserIO myIo = new UserIOConsoleImpl();
    DvdLibraryView myView = new DvdLibraryView(myIo);
    DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
    DvdLibraryController controller = 
            new DvdLibraryController(myDao, myView);
    controller.Run();
    
}
}
