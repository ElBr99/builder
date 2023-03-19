public class Main {
    public static void main(String[] args) {
        Person person = new PersonBuilder()
                .setName("Марина")
                .setSurname("Козлова")
                .setAddress("Воронеж")
                .setAge(40)
                .build();
        Person child = person.newChildBuilder().setName("Вася").build();
        System.out.println("У " + person + " есть сын, " + child);

        try {
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {

            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
