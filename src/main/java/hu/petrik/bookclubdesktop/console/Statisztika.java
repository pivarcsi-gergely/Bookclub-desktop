package hu.petrik.bookclubdesktop.console;

import hu.petrik.bookclubdesktop.DB;
import hu.petrik.bookclubdesktop.Member;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Statisztika {
    public static List<Member> membersList = new ArrayList<>();
    public static void main(String[] args) {
        try {
            beolvasas();
            kitiltottakSzama();
            vanE18nalFiatalabb();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void beolvasas() throws SQLException {
        DB db = new DB();
        db.getMembers(membersList);
    }

    public static void kitiltottakSzama() {
        System.out.println("Kitiltott tagok száma: " + membersList.stream().filter(Member::isBanned).count());
    }

    public static void vanE18nalFiatalabb() {
        System.out.println(membersList.stream().anyMatch(member -> member.getBirth_date().isBefore(LocalDate.now().minusYears(18)))
                ? "Van a tagok között 18 évnél fiatalabb személy." : "Nincsen a tagok között 18 évnél fiatalabb személy.");
    }

    public static void legidosebbTag() {
        Comparator<Integer> descOrder = ((o1, o2) -> o2 - o1);
        Member legidosebb =  membersList.stream().collect(Collectors.groupingBy(member -> member.getBirth_date().getYear())).get();
        System.out.println(legidosebb.getName());
    }
}
