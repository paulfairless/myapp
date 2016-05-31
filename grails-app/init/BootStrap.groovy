class BootStrap {

    def init = { servletContext ->
        int num= 1

        Person p = new Person(name:"bob${num}", address:[new Address(line:"${num} the lane"), new Address(line:"${num} the lane")])
        p.save(flush:true)


        Person.withNewSession {
            Person p2 = Person.findByName("bob${num}")

            assert p2.address[1].line == "${num} the lane"

            p2.address[1].line= null
            p2.save(flush:true)
            assert !p2.hasErrors()
            assert p2.address[1].line == null
        }

        Person.withNewSession {
            Person p3 = Person.findByName("bob${num}")
            assert p3.address[1].line == null
        }
    }
    def destroy = {
    }
}
