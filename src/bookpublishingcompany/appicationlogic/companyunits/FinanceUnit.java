package bookpublishingcompany.appicationlogic.companyunits;

public class FinanceUnit extends Unit {
    private String finalReport,expendtures,incomes,loans ;
    private int totIncome,totExpendture,totLoan;

/**At the moment it generate string reports */
    public FinanceUnit(int unitId, String unitName) {
        super(unitId, unitName);
        finalReport= "The Final Report\n\n";
        expendtures= "Expendture are\n\n";
        incomes= "Incomes are\n\n";
        loans = "Loan Report \n\n";
        totIncome=0;
        totExpendture=0;
    }


    public void addIncome(String unit, int income){
        totIncome+=income;
        incomes+="Income from " + unit+ " is "+Integer.toString(income)+ "\n";
    }
    public void addExpense(String unit,int expense){
        totExpendture+=expense;
        expendtures+="Expense from "+ unit+ " is "+Integer.toString(expense)+ "\n";
    }
    public String getReport (){
        finalReport += incomes + "Total income = "+ Integer.toString(totIncome)+"\n\n" + expendtures + 
                        "Total expense = " + Integer.toString(totExpendture)+"\n\n" +"Total profit = " +Integer.toString(totIncome-totExpendture); 
        return finalReport;
    }

/**Loan details*/
    public void addLoan(String bank, int loan){
        totLoan+= loan;
        String l= "Loan taken from "+bank+" is "+Integer.toString(loan);
        this.loans += l;
    }
    public String takeloanReport(){
        return loans;
    }
    public int seetotalLoans(){
        return totLoan;
    }

}
