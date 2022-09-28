//BY 21ce109 VARUN PITHIYA
/*Question :
(Subclasses of Account) In Programming Exercise 2, the Account class was
defined to model a bank account. An account has the properties account number,
balance, annual interest rate, and date created, and methods to deposit and
withdraw funds. Create two subclasses for checking and saving accounts. A
checking account has an overdraft limit, but a savings account cannot be
overdrawn. Draw the UML diagram for the classes and then implement them.
Write a test program that creates objects of Account, SavingsAccount, and
CheckingAccount and invokes their toString() methods. */

import java.util.*;

class P2P4
{
    public static void main(String[]args)
    {
        Account A=new Account();
        SavingsAccount S=new SavingsAccount();
        CheckingAccount C=new CheckingAccount();

        System.out.println(A);
        System.out.println(S);
        System.out.println(C);
    }
}

class Account
{
    private int id;
    private double annualInterestRate;
    private Date dateCreated;

    Account()
    {
        id=0;
        annualInterestRate=0.07;
        dateCreated=new Date();
    }
   
    public String toString()
    {
        return "\nId : "+id+"\nAnnual Interest Rate : "+annualInterestRate+"\nDate Created : "+dateCreated;
    }
}

class SavingsAccount extends Account
{
    private double SavingsBalance;

    SavingsAccount()
    {
        SavingsBalance=500;
    }
    void withdraw(double withdrawMoney)
    {
        if(SavingsBalance-withdrawMoney<0)
        {
            System.out.println("Insufficient Funds");
        }
        else
        {
            SavingsBalance=SavingsBalance-withdrawMoney;
            System.out.println("Withdraw Successfull");
        }
    }
    void deposit(double depositMoney)
    {
        SavingsBalance=SavingsBalance+depositMoney;
        System.out.println("Deposit successfull");
    }

    public String toString()
    {
        return "Saving account Balance : "+SavingsBalance;
    }
}

class CheckingAccount extends Account
{
    private double CheckingsBalance;

    CheckingAccount()
    {
        CheckingsBalance=500;
    }

    void withdraw(double withdrawMoney)
    {
        CheckingsBalance=CheckingsBalance-withdrawMoney;
        System.out.println("Withdraw Successfull");
    }
    void deposit(double depositMoney)
    {
        CheckingsBalance=CheckingsBalance+depositMoney;
        System.out.println("Deposit successfull");
    }
    public String toString()
    {
        return "Checking account Balance : "+CheckingsBalance;
    }
}
