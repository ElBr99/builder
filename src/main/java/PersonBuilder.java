import java.util.OptionalInt;

public class PersonBuilder {

    private String name;
    private String surname;

    private OptionalInt age;
    private String address;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {

        this.age = OptionalInt.of(age);
        this.age.ifPresent(value -> {
            if (value < 0 || value > 150) {
                throw new IllegalArgumentException("Указан некорректный возраст");
            }
        });
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null && surname == null) {
            throw new IllegalStateException("Имя и фамилия не заданы");
        }

        Person person = new Person(this.name, this.age, this.surname);
        person.setAddress(this.address);
        return person;

    }
}
