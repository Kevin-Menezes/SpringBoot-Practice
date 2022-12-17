package com.sbm.UserService.entities;

// This class has both the objects of the entities
public class ResponseTemplate {

    private Users users;
    private Department department;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public ResponseTemplate() {
    }

    public ResponseTemplate(Users users, Department department) {
        this.users = users;
        this.department = department;
    }

    @Override
    public String toString() {
        return "ResponseTemplate{" +
                "users=" + users +
                ", department=" + department +
                '}';
    }
}
