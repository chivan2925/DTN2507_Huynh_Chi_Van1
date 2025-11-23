package assignment4.E1;
import java.time.LocalDate;
import java.util.Arrays;

public class Group {
    private String groupName;
    private Account creator;
    private Account[] accounts;
    private LocalDate createDate;

    public Group() {
    }

    public Group(String groupName, Account creator, Account[] accounts, LocalDate createDate) {
        this.groupName = groupName;
        this.creator = creator;
        this.accounts = accounts;
        this.createDate = createDate;
    }

    public Group(String groupName, Account creator, String[] usernames, LocalDate createDate) {
        this.groupName = groupName;
        this.creator = creator;
        this.createDate = createDate;
        this.accounts = new Account[usernames.length];
        for (int i = 0; i < usernames.length; i++) {
            this.accounts[i] = new Account(0, null, usernames[i], "", null);
        }
    }
    
    public void showInfo() {
        String accountList = "";
        if (accounts != null) {
            for (Account acc : accounts) {
                accountList += acc.getUsername() + ", ";
            }
        }
        System.out.println("Tên Group: " + this.groupName + ", Ngày tạo: " + this.createDate 
            + ", Creator: " + (this.creator != null ? this.creator.getUsername() : "N/A")
            + ", Thành viên: [" + accountList.trim().replaceAll(",$", "") + "]");
    }
}


