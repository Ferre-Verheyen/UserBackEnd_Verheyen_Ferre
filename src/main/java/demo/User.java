package demo;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private int age;
    private List<Integer> membershipYears = new ArrayList<Integer>();
    private String email;
    private String password;

    public User(String name, int age) {
        this.name = name;
        if (age >= 0)
            this.age = age;
    }

    public User(String name, int age, String email, String password) {
        this.name = name;
        if (age >= 0) {
            this.age = age;
        }
        if (!email.contains("@")) {
            this.email = null;
        } else {
            this.email = email;
        }
        if (password.isBlank()) {
            this.password = "@$-" + "t" + "&%#";
        } else {
            this.password = "@$-" + password + "&%#";
        }
    }

    public int countMembershipYearsAfter1999() {
        int result = 0;
        for (Integer year : membershipYears) {
            if (year > 1999)
                result++;
        }
        return result;
    }

    public int countYearsOfMembership() {
        return membershipYears.size();
    }

    public void addMembershipYear(int year) {
        membershipYears.add(year);
    }

    public int getFirstMembershipYear() {
        int firstMembershipYear = Integer.MAX_VALUE;
        for (Integer year : membershipYears) {
            if (year < firstMembershipYear) {
                firstMembershipYear = year;
            }
        }
        if (firstMembershipYear == Integer.MAX_VALUE) {
            firstMembershipYear = 0;
        }
        return firstMembershipYear;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getNumberOfMembershipYearsIn2000() {
        int numberOfMembershipYearsIn2000 = 0;
        for (Integer year : membershipYears) {
            if (year >= 2000 && year <= 2023) {
                numberOfMembershipYearsIn2000 += 1;
            }
        }
        return numberOfMembershipYearsIn2000;
    }

    public Boolean isPasswordCorrect(String password) {
        return ("@$-" + password + "&%#").equals(this.password);
    }

    @Override
    public String toString() {
        return this.name + " is " + this.age + " years old and has as email " + this.email;
    }

}