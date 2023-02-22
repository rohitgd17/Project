import java.util.*;

class Bank_account {

    String F_name;
    String L_name;
    String Username;
    String Password;
    String Account_NO;
    float Balance = 100000;
    int Transactions = 0;
    String Transaction_history = "";

    Bank_account() {

    }

    Bank_account(String F_name, String L_name, String Username, String Password, String Account_NO) {
        this.F_name = F_name;
        this.L_name = L_name;
        this.Username = Username;
        this.Password = Password;
        this.Account_NO = Account_NO;
    }

    public void Register() {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter your first name : ");
        this.F_name = sobj.nextLine();

        System.out.println("Enter your last name : ");
        this.L_name = sobj.nextLine();

        System.out.println("Enter your Username : ");
        this.Username = sobj.nextLine();

        System.out.println("Enter your Password : ");
        this.Password = sobj.nextLine();

        System.out.println("Enter your Account_NO : ");
        this.Account_NO = sobj.nextLine();
        // sobj.close();
    }

    public boolean Login() {
        boolean isLogin = false;
        Scanner sobj = new Scanner(System.in);
        // sobj.close();
        while (!isLogin) {
            System.out.println("Enter your username :");
            String username = sobj.nextLine();

            if (Username.equals(username)) {
                while (!isLogin) {
                    System.out.println("Enter your Password :");
                    String password = sobj.nextLine();
                    if (password.equals((Password))) {
                        isLogin = true;
                    } else {
                        System.out.println("Password is incorrect.");
                    }
                }
            } else {
                System.out.println("Entered username is not correct please enter a valid username.");
            }
        }
        return isLogin;
    }

    public void WithDraw() {
        System.out.println("Enter the amount that you want to withdraw :");
        Scanner sobj = new Scanner(System.in);
        int amount = sobj.nextInt();
        // sobj.close();
        String s;

        try {
            if (amount <= Balance) {
                Balance -= amount;
                s = amount + "rs WithDrawed";
                Transactions++;
                Transaction_history += s;
                Transaction_history += "\n";
            } else {
                System.out.println("INsufficient Balance.");
            }
        } catch (Exception e) {

        }
    }

    public void Deposit() {
        Scanner sobj = new Scanner(System.in);
        System.out.println("Enter the amount that u want deposit : ");
        int amount = sobj.nextInt();
        String s;
        // sobj.close();
        try {
            if (amount + Balance <= 100000) {
                Balance += amount;
                Transactions++;
                s = amount + "rs Deposited";
                Transaction_history += s;
                Transaction_history += "\n";

            } else {
                System.out.println("Can not deposit amount greater than 100000.");
            }
        } catch (Exception e) {

        }
    }

    public void Transfer() {
        Scanner sobj = new Scanner(System.in);
        System.out.println("Enter the amount that u want Transfer : ");
        int amount = sobj.nextInt();
        String s;
        // sobj.close();

        try {
            if (amount <= 50000) {
                if (amount <= Balance) {
                    Balance -= amount;
                    Transactions++;
                    s = amount + "rs transfered";
                    Transaction_history += s;
                    Transaction_history += "\n";
                    System.out.println("Money Transfered successfully");
                } else {
                    System.out.println("Ensufficient Balance.");
                }
            } else {
                System.out.println("You cannot transfer amount greater than 50000.");
            }
        } catch (Exception e) {
        }

    }

    public void check_Balance() {
        System.out.println("Your Balance is :" + Balance);
    }

    public void show_Transaction_History() {
        if (Transactions == 0) {
            System.out.println("NO Transactions done yet.");
        } else {
            System.out.println("\n" + Transaction_history + "\n");
        }
    }

}
