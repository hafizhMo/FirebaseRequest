package com.hafizhmo.firebaserequest;

public class Member {

    private final String name;
    private final String role;
    private final String image;

    public Member(String name, String role, String image) {
        this.name = name;
        this.role = role;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getImage() {
        return image;
    }
}
