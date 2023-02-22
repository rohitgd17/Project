import java.util.Scanner;

public class ATM_Interface {

    public static int Integer_input(int limit) {
        Scanner sobj = new Scanner(System.in);
        boolean flag = false;
        int value = 0;
        // sobj.close();
        while (!flag) {
            try {
                value = sobj.nextInt();
                flag = true;
                if (flag && (value < 1 || value > limit)) {
                    System.out.println("Enter number in the range 1 to " + limit);
                    flag = false;
                }

            } catch (Exception e) {
                System.out.println("Please enter integer value only:");
                flag = false;
            }
        }

        return value;
    }

    public static void main(String arg[]) {
        System.out.println("\n--------------WELCOME TO IDBI ATM SYSTEM--------------\n");
        System.out.println(" 1.Register \n 2.Exit");
        System.out.println("Enter your choice : ");

        int choice = Integer_input(2);
        if (choice == 1) {
            Bank_account obj = new Bank_account();
            obj.Register();

            while (true) {
                System.out.println("\n 1.Login \n 2.Exit");
                System.out.println("Enter your choice : ");
                int ch = Integer_input(2);

                if (ch == 1) {
                    if (obj.Login()) {
                        System.out.println(
                                "\n\n---------WELCOME BACK " + obj.F_name + " " + obj.L_name + "-----------\n");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println(
                                    "\n 1.Withdraw\n 2.Deposit\n 3.Transfer\n 4.CheckBalance\n 5.TransactionHostory\n 6.Exit\n");
                            System.out.println("\nEnter your choice");

                            int cho = Integer_input(6);
                            if (cho == 1)
                                obj.WithDraw();
                            if (cho == 2)
                                obj.Deposit();
                            if (cho == 3)
                                obj.Transfer();
                            if (cho == 4)
                                obj.check_Balance();
                            if (cho == 5)
                                obj.show_Transaction_History();
                            if (cho == 6) {
                                isFinished = true;
                                break;
                            }
                        }
                    } else {
                        System.exit(0);
                    }
                } else {
                    System.out.println("Thank You..!!");
                    break;
                }

            }

        }
        System.exit(0);

    }

}
