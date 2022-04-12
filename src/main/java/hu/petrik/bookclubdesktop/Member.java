package hu.petrik.bookclubdesktop;

import java.time.LocalDate;
import java.util.Date;

public class Member {
    private int id;
    private String name, gender;
    private LocalDate birth_date;
    private boolean banned;

    public Member(int id, String name, String gender, LocalDate birth_date, boolean banned) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birth_date = birth_date;
        this.banned = banned;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public boolean isBanned() {
        return banned;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birth_date=" + birth_date +
                ", banned=" + banned +
                '}';
    }
}
