/**
 * Created by paul on 31/05/2016.
 */
class Person {
    String name

    List<Address> address
    static embedded = ['address']

    static constraints = {
    }
}
