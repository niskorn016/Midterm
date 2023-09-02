import java.util.Scanner;

public class Account extends Person {
    private String[] acc_id = new String[6];
    private int[] acc_password = new int[6];
    private float[] balance = new float[6]; //กำหนดชนิดตัวแปรใหม่
    public int amount;
    public float btc2thb = 0; //กำหนดชนิตัวแปรให้เป็นบาทเก็บค่า float

    Scanner acc_input = new Scanner(System.in);

    public void setBTC() { //กำหนดเรท btc 
        System.out.print("Please Enter BTC Rate: ");
        btc2thb = acc_input.nextInt();
    }

    public void acc_detail() {
        while (true) {
            System.out.print("Enter Amount of Account : ");
            amount = acc_input.nextInt();
            if (amount <= 5) {
                System.out.println("===Enter Account Details===");
                for (int i = 1; i <= amount; i++) {
                    System.out.println("No." + i);
                    System.out.print("Identification ID : ");
                    String acc_ident = acc_input.next();
                    ident[i] = acc_ident;
                    System.out.print("Name : ");
                    name[i] = acc_input.next();
                    System.out.print("Sex(F/M) : ");
                    String acc_sex = acc_input.next();
                    sex[i] = acc_sex;
                    System.out.print("Login ID : ");
                    acc_id[i] = acc_input.next();
                    System.out.print("Password : ");
                    acc_password[i] = acc_input.nextInt();
                    while (true) {
                        System.out.print("Balance : ");
                        int tmp_bal = acc_input.nextInt();
                        if (tmp_bal <= 1000000) {
                            balance[i] = tmp_bal;
                            break;
                        } else
                            System.out.println("Your balance more than 1 Million try again");
                    }
                }
                break;
            } else System.out.println("Account must less than 5");
        }
    }

    public String[] getAcc_id() {
        return acc_id;
    }

    public int[] getAcc_password() {
        return acc_password;
    }

    public void Checkable(int i) { //เช็คยอดเงินคงเหลือทั้ง 2 เรทค่าเงิน
        System.out.println("your balance is : ");
        System.out.println("THB : " + balance[i]);
        System.out.println("BTC : " + balance[i]/btc2thb);
    }

    public void Withdrawable(int i) { //ถอนเงินทั้ง 2 ค่า
        System.out.println("balance is : ");
        System.out.println("THB : " + balance[i]);
        System.out.println("BTC : " + balance[i]/btc2thb);
        System.out.println("Enter Withdraw"); //บอกยอดเงิน
        System.out.println("1 BTC = "+btc2thb+" THB");
        System.out.print("Withdraw with THB[1] or BTC[2]: "); //เลือกว่าถอดสกุลเินค่าอะไร
        int or = acc_input.nextInt();
        if(or==2) {
            System.out.print("Withdraw with BTC :");
            float BTC = acc_input.nextFloat();
            if(BTC>balance[i]/btc2thb) {
                System.out.println("insufficient amount !!");
            }
            else if(BTC<=balance[i]/btc2thb) {
                float withdrawed = (balance[i] /btc2thb)-BTC;
                this.balance[i] = withdrawed*btc2thb;
                System.out.println("balance is : ");
                System.out.println("THB : " + balance[i]);
                System.out.println("BTC : " + balance[i]/btc2thb);
            }
        }
        else {
            System.out.print("Withdraw with THB :");
            float THB = acc_input.nextInt();
            if(THB>balance[i]) {
                System.out.println("insufficient amount !!");
            }
            else if(THB<=balance[i]) {
                float withdrawed = balance[i]-THB;
                this.balance[i] = withdrawed;
                System.out.println("balance is : ");
                System.out.println("THB : " + balance[i]);
                System.out.println("BTC : " + balance[i]/btc2thb);
            }
        }
    }

    public void Depositeable(int i) { //ฝากเงิน
        System.out.println("balance is : ");
        System.out.println("THB : " + balance[i]);
        System.out.println("BTC : " + balance[i]/btc2thb);
        System.out.print("Enter Deposit : ");
        float deposit = acc_input.nextInt();
        float deposited = balance[i] + deposit;
        balance[i] = deposited;
        System.out.println("balance is : ");
        System.out.println("THB : " + balance[i]);
        System.out.println("BTC : " + balance[i]/btc2thb);
    }

    public void Transferable(int i) { //โอนเงิน
        System.out.println("balance is : ");
        System.out.println("THB : " + balance[i]);
        System.out.println("BTC : " + balance[i]/btc2thb);
        int tranfer;
        System.out.print("Enter tranfer :");
        tranfer = acc_input.nextInt();
        if (tranfer > balance[i]) {
            System.out.println("Your balance not enough");
            return;
        }
        System.out.print("Which Account ID? : ");
        String account = acc_input.next();
        int x;
        for (x = 1; x <= amount; x++) {
            if (acc_id[x].equals(account)) {
                balance[x] = balance[x] + tranfer;
                balance[i] = balance[i] - tranfer;
                System.out.println("Tranfer Completed");
                System.out.println("balance is : ");
                System.out.println("THB : " + balance[i]);
                System.out.println("BTC : " + balance[i]/btc2thb);
                break;
            }
        }
        if (x > amount) {
            System.out.println("Account Not Found");
        }
    }
}
