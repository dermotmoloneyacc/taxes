/*
Create a zip code class for tax calculations 

 */
package edu.acc.java2.taxes;
/**
# *
 * @author playerone
# */
public class ZipCode {
    private String state;
    private String zipCode;
    private int id;
    private int agiStub;
    private double adjustedGross;
    private double totalTax;
    private int totalReturns;
    private double perCapita;
    private int returnsTaxDue;
    private int taxDue;
    
    public ZipCode(){
    }
    
    public ZipCode(String zipCode, int id, int agiStub, double totalTax, 
        int totalReturns, int perCapita, int returnsTaxDue, int taxDue,
        double adjustedGross){
            this.state = state;
            this.zipCode = zipCode;
            this.id = id;
            this.agiStub = agiStub;
            this.adjustedGross = adjustedGross;
            this.totalTax = totalTax;
            this.totalReturns = totalReturns;
            this.perCapita = perCapita;
            this.returnsTaxDue = returnsTaxDue;
            this.taxDue = taxDue;
    }
    

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

       public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAgiStub() {
        return agiStub;
    }

    public void setAgiStub(int agiStub) {
        this.agiStub = agiStub;
    }
    
    public double getAdjustedGross() {
        return adjustedGross;
    }

    public void setAdjustedGross(int adjustedGross) {
        this.adjustedGross = adjustedGross;
    }
    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public int getTotalReturns() {
        return totalReturns;
    }

    public void setTotalReturns(int totalReturns) {
        this.totalReturns = totalReturns;
    }

    public double getPerCapita() {
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
  
