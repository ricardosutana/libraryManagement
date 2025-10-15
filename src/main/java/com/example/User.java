package com.example;

public class User implements Runnable {
    private Integer registration;
    private String name;
    private UserType userType;
    LibraryService libraryService;

    private OperationType operationType;
    private Integer bookId;
    private Book book2Add;

    public enum UserType{
        ADMIN(1, "Administrator"),
        BASIC(2, "Basic User");

        private int code;
        private String description;

        UserType(int code, String description){
            this.code = code;
            this.description = description;
        }

        public int getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }
    }

    public enum OperationType{
        ADD,
        REMOVE,
        LEND,
        TURNBACK

    }
    //constructor to be used for operations that only need the book ID)
    public User(Integer registration, String name, UserType userType, LibraryService libraryService, OperationType operationType, Integer bookId) {
        this.registration = registration;
        this.name = name;
        this.userType= userType;
        this.operationType=operationType;
        this.bookId = bookId;
    }

    //constructor to be used for ADD operation (need the full book information)
    public  User(Integer registration, String name, UserType userType, LibraryService libraryService, OperationType operationType, Book book2Add){
        this.registration = registration;
        this.name=name;
        this.userType=userType;
        this.libraryService = libraryService;
        this.operationType=operationType;
        this.book2Add = book2Add;

    }

    @Override
    public void run() {
        System.out.println("User Type: " + userType.getDescription()+ " "+ name +" Registration: "+registration+ "access the system" );
        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("The thread was interrupted: "+name);
            return;
        }
        executeOperation();

    }

    private void executeOperation() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }


        switch (operationType) {
            case ADD:
                addBook();
                break;
            case REMOVE:
                removeBook();
                break;
            case LEND:
                lendBook();
                break;
            case TURNBACK:
                turnbackBook();
                break;
            default:
                System.out.println("[ERROR] " + name + ": Invalid Operation!");
        }
    }

    private void addBook() {
        System.out.println(name + " is now adding a book into library: " + book2Add.getTitle() );

        boolean success = libraryService.add(this, book2Add);

        if (!success) {
            System.out.println("Operation failed for user: " + name);
        }
    }

    private void removeBook() {
        System.out.println(name + " is trying to remove the book ID: " + bookId);

        boolean success = libraryService.remove(this, bookId);

        if (!success) {
            System.out.println("Operation failed for user: " + name);
        }
    }

    private void lendBook() {
        System.out.println(name + " want to lend the book ID: " + bookId);

        boolean success = libraryService.lend(this, bookId);

        if (!success) {
            System.out.println("Operation failed for user: " + name);
        }
    }

    private void turnbackBook() {
        System.out.println( name + " want to turnback the book ID: " + bookId);

        boolean success = libraryService.remove(this, bookId);

        if (!success) {
            System.out.println("Operation failed for user: " + name);
        }
    }

    public Integer getRegistration() {
        return registration;
    }

    public void setRegistration(Integer registration) {
        this.registration = registration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    @Override
    public String toString() {
        return "User{" +
                "registration=" + registration +
                ", name='" + name + '\'' +
                ", userType=" + userType +
                '}';
    }
}