//BY 21ce109 VARUN PITHIYA
/*Question :
Design a class named Account that contains:
• A private int data field named id for the account (default 0).
• A private double data field named balance for the account (default 500₹).
• A private double data field named annualInterestRate that stores the current
interest rate (default 7%). Assume all accounts have the same interest rate.
• A private Date data field named dateCreated that stores the date when the
account was created.
• A no-arg constructor that creates a default account.
• A constructor that creates an account with the specified id and initial balance.
• The accessor and mutator methods for id, balance, and annualInterestRate.
• The accessor method for dateCreated.
• A method named getMonthlyInterestRate() that returns the monthly interest rate.
• A method named getMonthlyInterest() that returns the monthly interest.
• A method named withdraw that withdraws a specified amount from the account.
• A method named deposit that deposits a specified amount to the account. */

import java.util.*;

class P2P2
{
    public static void main(String[]args)
    {
        //Default Account
        Account A1=new Account();
        A1.getInfo();

        //Setting pararmeters
        A1.setId(1);                //Changed account number to 1
        A1.setBalance(2000);        //Changed balance to 2000
        A1.setAnnualInterestRate(.2);  //Changed account annual interest rate to 20%
        A1.getInfo();




    }
}
class Account
{
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    Account()
    {
        id=0;
        balance=500;
        annualInterestRate=0.07;
        dateCreated=new Date();
    }
    Account(int id,double balance)
    {
        this.id=id;
        this.balance=balance;
    }
    void setId(int id)
    {
        this.id=id;
    }
    void setBalance(double balance)
    {
        this.balance=balance;
    }
    void setAnnualInterestRate(double annualInterestRate)
    {
        this.annualInterestRate=annualInterestRate;
    }
    int getId()
    {
        return id;
    }
    double getBalance()
    {
        return balance;
    }
    double getAnnualInterestRate()
    {
        return annualInterestRate;
    }      
    Date getDateCreated()                              
    {
        return dateCreated;
    }
    double getMonthlyInterestRate()
    {
        return annualInterestRate/12;
    }
    double getMonthlyInterest()
    {
        return balance*getAnnualInterestRate();
    }
    void withdraw(double MoneyWithdrawn)
    {
        balance=balance-MoneyWithdrawn;
    }
    void deposit(double MoneyDeposit)
    {
        balance=balance+MoneyDeposit;
    }
    void getInfo()        //Shows all the information
    {
        System.out.println("\nId : "+id);
        System.out.println("Balance : "+balance);
        System.out.println("Annual Interest Rate : "+annualInterestRate);
        System.out.println("Date Created : "+dateCreated);
        System.out.println("Montly Interest Rate : "+getMonthlyInterestRate());
        System.out.println("Montly Interest : "+getMonthlyInterest());
    }
}

