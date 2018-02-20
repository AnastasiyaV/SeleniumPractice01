package myproject.domain;

public class Tutor {
    public String name;
    public String position;
    public Tutor(String name, String position) {
        this.name = name;
        this.position = position;
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

        if (name != null ? !name.equals(tutor.name) : tutor.name != null) return false;
        return position != null ? position.equals(tutor.position) : tutor.position == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}
