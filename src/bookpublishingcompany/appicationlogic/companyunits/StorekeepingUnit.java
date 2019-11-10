package bookpublishingcompany.appicationlogic.companyunits;

import java.util.HashMap;

/**
 * Store Unit. Features
 *       Can store, remove items like books, printing material (paper, ink cartridges)
 *       Hashmap to add book details 
 */

public class StorekeepingUnit extends Unit{
    private int paperAmount;
    private int inkcartridgeAmount;
    private HashMap <String,Integer> bookRecord; 
    
    public StorekeepingUnit (int unitId, String unitName){
        super(unitId, unitName);
        bookRecord= new HashMap<String,Integer>();
    }

//Getters and setter for printing materials
    public void addInkCartridges (int inkAmount){
        inkcartridgeAmount += inkAmount;
    }
    public void addPaper (int paperAmount){
        this.paperAmount += paperAmount;
    }
    public void removeInkCartridges (int inkAmount){
        this.inkcartridgeAmount -= inkAmount;
    }
    public void removePaper (int paperAmount){
        this.paperAmount -= paperAmount;
    }
    public int checkInkAmount (){
        return inkcartridgeAmount ;
    }
    public int checkPaperAmount (){
        return paperAmount ;
    }

//adding books to store
    public void addBookRecords (String id, int amount ){  
        if (bookRecord.containsKey(id)){
            int value =bookRecord.get(id) + amount;
            bookRecord.put(id,value);
        }else{
            bookRecord.put(id,amount);
        }
    }

/** Taking books out of store
 *      if there are not enough of books in the store notify via string
 *      else notify success
 */
    public void getBooks (String id,int amount){  
        if (bookRecord.containsKey(id)){
            int supply = bookRecord.get(id); 
            if (amount>= supply ){
                System.out.println ("Not enough books in the store. Provided amount : " + Integer.toString(supply));
                bookRecord.remove(id);
            }else{
                int value =supply- amount; 
                bookRecord.put(id,value);
                System.out.println ("Request completed. Provided amount : " + Integer.toString(amount));
            }
        }else{
            System.out.println ("Not enough books in the store. Provided amount : 0"); 
        }
    }
}