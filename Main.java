import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Manager mgr = new Manager();
        Account acc = new Account();
        Scanner log_input = new Scanner(System.in);
        acc.setBTC();
        mgr.mgr_detail();
        System.out.println("===========Manager Login===========");
        System.out.print("ID : ");
        String login_input = log_input.next();
        System.out.print("Password : ");
        int pass_input = log_input.nextInt();
        String mgr_id = mgr.getMgr_id();
        int mgr_pass = mgr.getMgr_password();
        if ((login_input.equals(mgr_id)) && (pass_input == mgr_pass)) {
            System.out.println("==============================");
            System.out.println("Welcome Manager " + mgr.name[0]);
            System.out.println("==============================");
            acc.acc_detail();
            login:
            while (true) {
                System.out.println("==============================");
                System.out.println("Login");
                System.out.println("==============================");
                System.out.print("ID : ");
                String login_acc = log_input.next();
                System.out.print("Password : ");
                int pass_acc = log_input.nextInt();
                String[] id = acc.getAcc_id();
                int[] pass = acc.getAcc_password();
                for (int i = 1; i <= acc.amount; i++) {
                    if ((id[i].equals(login_acc)) && (pass[i] == pass_acc)) {
                        String[] name = acc.getName();
                        System.out.println("===================");
                        System.out.println("Welcome " + name[i]);
                        while (true) {
                            System.out.println("========Menu=======");
                            System.out.println("1.Balance Check");
                            System.out.println("2.Withdraw");
                            System.out.println("3.Deposit");
                            System.out.println("4.Tranfer");
                            System.out.println("5.Exit");
                            System.out.print("Select : ");
                            byte sl = (byte) log_input.nextInt();
                            switch (sl) {
                                case 1:
                                    acc.Checkable(i);
                                    continue;
                                case 2:
                                    acc.Withdrawable(i);
                                    continue;
                                case 3:
                                    acc.Depositeable(i);
                                    continue;
                                case 4:
                                    acc.Transferable(i);
                                    continue;
                                case 5:
                                    continue login;
                                default:
                                    System.out.println("Wrong Selection");
                            }
                        }
                    }
                }
            }
        } else { 
            System.out.println("Manager Account not found");
        }
    }
}