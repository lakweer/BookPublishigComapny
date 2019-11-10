package bookpublishingcompany.appicationlogic.companyunits;

import bookpublishingcompany.appicationlogic.publishingprocess.Book;

import java.util.ArrayList;

/**
 * For the printing unit we need two new classes
 *      printer class
 *      Book class
 * And also I'm not sure about do we have to use multithreading and complicate stuff. 
 */

public class PrintingUnit extends Unit {

    private ArrayList <Printer> idlePrinters, busyPrinters;
    private ArrayList <Book> printingQueue;


    public PrintingUnit(int unitId, String unitName) {
        super(unitId, unitName);
        idlePrinters = new ArrayList<Printer>();
        busyPrinters = new ArrayList<Printer>();
        printingQueue = new ArrayList<Book>();

    }

/**Do we need to use multithread? (Then we have to use objectpool) */
    public void usePrinter (){
        if (idlePrinters.isEmpty()){
            System.out.println ("All the printers are busy. Wait for an idle printer"); 
        }else{
            Printer p = idlePrinters.remove(0);
            busyPrinters.add(p);
        }
    }
    public void yieldPrinter (){
        Printer p = busyPrinters.remove(0);
        idlePrinters.add(p);
    }
    public void addPrinter(Printer p){
        idlePrinters.add(p);
    }
    public void removePrinter(Printer p){
        idlePrinters.remove(p);
    }


    public void addtoPrint (Book book){
        printingQueue.add(book);
    }
    public void removefromPrint (Book book){
        printingQueue.remove(book);
    }


    public void typeSetBook (Book book){
        // code to change state of book from unchecked to checked or something like that and inform the author about changes
    }
    public void printBook(Book book){
        if (true){   //check condition of the book to see if it is done typesetting
            usePrinter();
        }
    }


}
    
