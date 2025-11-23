package assignment4.E1;

import java.time.LocalDate;

class Position {
    enum PositionName {DEV, TEST, PM}
    PositionName name;

    public Position(PositionName name) {
        this.name = name;
    }
}

public class Account {
    private int id;
    private String email;
    private String username;
    private String fullName;
    private Position position;
    // private String position;
    private LocalDate createDate;

    public String getUsername() {
        return username;
    }


    public Account() {
    }

    public Account(int id, String email, String username, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.fullName = firstName + " " + lastName;
    }

    public Account(int id, String email, String username, String firstName, String lastName, Position position) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.fullName = firstName + " " + lastName; 
        this.position = position;
        this.createDate = LocalDate.now(); 
    }

    public Account(int id, String email, String username, String firstName, String lastName, Position position, LocalDate createDate) {
         this.id = id;
        this.email = email;
        this.username = username;
        this.fullName = firstName + " " + lastName; 
        this.position = position;
        this.createDate = createDate; 
    }
    
    public void showInfo() {
        System.out.println("ID: " + this.id + ", Email: " + this.email + ", FullName: " + this.fullName 
            + (this.position != null ? ", Position: " + this.position.name : "")
            + (this.createDate != null ? ", CreateDate: " + this.createDate : ""));
    }
}

