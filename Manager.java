import java.util.Scanner;

public class Manager extends Person {
    private String mgr_id;
    private int mgr_password;

    public void mgr_detail() {
        Scanner mgr_input = new Scanner(System.in);
        System.out.println("Enter Manager Details");
        System.out.print("Identification ID : ");
        String mgr_ident = mgr_input.next();
        ident[0] = mgr_ident;
        System.out.print("Name : ");
        String mgr_name = mgr_input.next();
        name[0] = mgr_name;
        System.out.print("Sex(F/M) : ");
        String mgr_sex = mgr_input.next();
        sex[0] = mgr_sex;
        System.out.print("Login ID : ");
        mgr_id = mgr_input.next();
        System.out.print("Password : ");
        mgr_password = mgr_input.nextInt();
    }

    public String getMgr_id() {
        return mgr_id;
    }

    public int getMgr_password() {
        return mgr_password;
    }
}
