public class Tutor {
    public String name;
    public String position;
    public Tutor(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
