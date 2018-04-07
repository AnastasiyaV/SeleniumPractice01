package myproject.domain;

import java.util.Objects;

public class Tutor {
    private String name;
    private String position;
    public Tutor(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "myproject.domain.Tutor{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tutor tutor = (Tutor) o;
        return Objects.equals(name, tutor.name) &&
                Objects.equals(position, tutor.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
