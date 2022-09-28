//BY 21ce109 VARUN PITHIYA
/*Question :
Use the Account class created as above to simulate an ATM machine.
Create 10 accounts with id AC001…..AC010 with initial balance 300₹. The
system prompts the users to enter an id. If the id is entered incorrectly, ask
the user to enter a correct id. Once an id is accepted, display menu with
multiple choices.
1. Balance inquiry
2. Withdraw money [Maintain minimum balance 300₹]
3. Deposit money
4. Money Transfer
5. Create Account
6. Deactivate Account
7. Exit
Hint: Use ArrayList, which is can shrink and expand with compared to Array. */
                                       
import java.util.*;

class P2P3
{
    public static void main(String[]args)
    {
        ArrayList<Account> AC=new ArrayList<Account>();

        //Creating 10 accounts
        for(int i=0;i<10;i++)
        {
            AC.add(new Account());    
        }

        int choose=0,flag=0,whereid=0,transferid=0,transferflag=0,deactivate=0,deactivateflag=0,switchflag=0,switchId=0;
        double WithdrawOrDeposit=0,TransferMoney=0;
        String id;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Id : ");
        id=sc.next();


        //System.out.print(AC.get(9).getId());
       
        for(Account A:AC)
        {
            if(A.getId().equals(id))
            {
                flag=1;
                break;
            }
            else
            {
                whereid++;
            }
        }

        if(flag==1)
        {
            while(choose!=7)
            {
                System.out.println("\n1. Balance inquiry");
                System.out.println("2. Withdraw money");
                System.out.println("3. Deposit money");
                System.out.println ("4. Money Transfer");
                System.out.println ("5. Create Account");
                System.out.println("6. Deactivate Account");
                System.out.println("7. Exit ");
                System.out.println("8. Switch Account");
                System.out.print("Enter : ");
                choose=sc.nextInt();

                switch(choose)
                {
                    case 1:
                        System.out.println("Balance : "+AC.get(whereid).getBalance());
                        break;
                   
                    case 2:
                        System.out.println("Enter money to be withdrawn : ");
                        WithdrawOrDeposit=sc.nextDouble();
                        AC.get(whereid).withdraw(WithdrawOrDeposit);
                        break;
                   
                    case 3:
                        System.out.println("Enter money to be deposit : ");
                        WithdrawOrDeposit=sc.nextDouble();
                        AC.get(whereid).deposit(WithdrawOrDeposit);
                        break;
                   
                    case 4:
                        System.out.print("Enter account number to transfer money : ");
                        id=sc.next();
                        for(Account A:AC)
                        {
                            if(A.getId().equals(id))
                            {
                                transferflag=1;
                                break;
                            }
                            else
                            {
                                transferid++;
                            }
                        }
                        if(transferflag==1)
                        {
                            System.out.print("Enter money to be transfered : ");
                            TransferMoney=sc.nextDouble();
                            if(AC.get(whereid).getBalance()-TransferMoney<=300)
                            {
                                System.out.println("Insufficient funds to transfer money");
                            }
                            else
                            {
                                AC.get(transferid).TransferFunds(TransferMoney);
                                AC.get(whereid).CutTransferredFund(TransferMoney);
                            }
                        }
                        else
                        {
                            System.out.println("Incorrect ID to transfer funds! Try Again");
                        }
                        break;
                   
                    case 5:
                        AC.add(new Account());
                        System.out.println("Account created successfully");
                        break;
                   
                    case 6:
                        System.out.print("Enter account number to be deactivated : ");
                        id=sc.next();
                        for(Account A:AC)
                        {
                            if(A.getId().equals(id))
                            {
                                deactivateflag=1;
                                break;
                            }
                            else
                            {
                                deactivate++;
                            }
                        }
                        if(flag==1)
                        {
                            AC.remove(deactivate);
                            System.out.println("Account deactivte successfull");
                        }
                        else
                        {
                            System.out.println("Account doesnt exist to be deactivated");
                        }
                        break;
                   
                    case 8:
                        System.out.print("Enter account to switch : ");
                        id=sc.next();
                        for(Account A:AC)
                            {
                                if(A.getId().equals(id))
                                {
                                    switchflag=1;
                                    break;
                                }
                                else
                                {
                                    switchId++;
                                }
                            }
                        if(switchflag==1)
                        {
                            whereid=switchId;
                            System.out.println("ID switch successfull");
                        }
                        else
                        {
                            System.out.println("Incorrect ID to switch");
                        }

                }
            }
        }
        else
        {
            System.out.println("Incorrect ID! \nTry Again");
        }
    }
}

class Account
{
    private String id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    private static int totalAccounts;

    Account()
    {
        if(totalAccounts<10)
        {
            id="AC00"+totalAccounts;
            balance=300;
            annualInterestRate=0.07;
            dateCreated=new Date();
            totalAccounts++;
        }
        else
        {
            id="AC0"+totalAccounts;
            balance=300;
            annualInterestRate=0.07;
            dateCreated=new Date();
            totalAccounts++;
        }
    }
    Account(String id,double balance)
    {
        this.id=id;
        this.balance=balance;
    }
    void setId(String id)
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
    String getId()
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
        if(balance-MoneyWithdrawn<=300)
        {
            System.out.println("Money cannot be withdraw low balance");
        }
        else
        {
            balance=balance-MoneyWithdrawn;
            System.out.println("Money withdrawn successfull");
        }
       
    }
    void deposit(double MoneyDeposit)
    {
        balance=balance+MoneyDeposit;
        System.out.println("Money deposit successfull");
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

    void TransferFunds(double A)
    {
        balance=A+balance;
        System.out.println("Transfer successfull");
    }

    void CutTransferredFund(double A)
    {
        balance=balance-A;
    }

    public String toString()
    {
        return "\nId : "+id+"\nBalance : "+balance+"\nAnnual Interest Rate : "+annualInterestRate+"\nDate Created : "+dateCreated;
    }
}
