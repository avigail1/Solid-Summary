package utilities;

/**
 * The Person class represents an individual with various attributes
 * such as name, address, contact information, and more.
 */
public class Person {
    private String firstName;
    private String lastName;
    private String address;
    private String postcode;
    private String city;
    private String phone;
    private String email;

    /**
     * Constructs a Person object with the specified details.
     *
     * @param firstName the first name of the person.
     * @param lastName the last name of the person.
     * @param address the address of the person.
     * @param postcode the postcode of the person.
     * @param city the city of the person.
     * @param phone the phone number of the person.
     * @param email the email address of the person.
     */
    public Person(String firstName, String lastName, String address, String postcode,
                  String city, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postcode = postcode;
        this.city = city;
        this.phone = phone;
        this.email = email;
    }

    /**
     * Returns the first name of the person.
     *
     * @return the first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name of the person.
     *
     * @return the last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the address of the person.
     *
     * @return the address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns the postcode of the person.
     *
     * @return the postcode.
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Returns the city of the person.
     *
     * @return the city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns the phone number of the person.
     *
     * @return the phone number.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Returns the email address of the person.
     *
     * @return the email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns a string representation of the Person object.
     *
     * @return a string representation of the person's details.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
