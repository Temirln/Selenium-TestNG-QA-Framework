package Task3.MODELS;

public class UserTable {
    
    private final String firstname;
    private final String lastname;
    private final String age;
    private final String email;
    private final String salary;
    private final String department;
    
    public UserTable(String firstname, String lastname, String age, String email, String salary, String department) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.salary = salary;
        this.department = department;
    }
    
    public String getFirstname() {
        return firstname;
    }
    
    public String getLastname() {
        return lastname;
    }
    
    public String getAge() {
        return age;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getSalary() {
        return salary;
    }
    
    public String getDepartment() {
        return department;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTable userTable = (UserTable) o;
        return firstname.equals(userTable.firstname) && lastname.equals(userTable.lastname) && age.equals(userTable.age) && email.equals(userTable.email) && salary.equals(userTable.salary) && department.equals(userTable.department);
    }
    
    
    
    @Override
    public String toString() {
        return "UserTable{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
