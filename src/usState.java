
package edu.acc.java2.taxes;
/**
# *
 * @author playerone
# */
  public class usState {
    private String state;
    private String ZipCode;
    private int id;
    private double totalTax;
    private double adjustedGross;
    private int totalReturns;
    private int perCapita;
    private int returnsTaxDue;
    private int taxDue;
    
    public usState(){
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String ZipCode) {
        this.ZipCode = ZipCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public double getAdjustedGross() {
        return adjustedGross;
    }

    public void setAdjustedGross(double adjustedGross) {
        this.adjustedGross = adjustedGross;
    }

    
    public int getTotalReturns() {
        return totalReturns;
    }

    public void setTotalReturns(int totalReturns) {
        this.totalReturns = totalReturns;
    }

    public int getPerCapita() {
        return perCapita;
    }

    public void setPerCapita(int perCapita) {
        this.perCapita = perCapita;
    }

    public int getReturnsTaxDue() {
        return returnsTaxDue;
    }

    public void setReturnsTaxDue(int returnsTaxDue) {
        this.returnsTaxDue = returnsTaxDue;
    }

    public int getTaxDue() {
        return taxDue;
    }

    public void setTaxDue(int taxDue) {
        this.taxDue = taxDue;
    }
}
    

    
