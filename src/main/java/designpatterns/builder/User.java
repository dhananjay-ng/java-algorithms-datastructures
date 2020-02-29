package designpatterns.builder;

public class User {
    private String fname;
    private String lname;
    private String age;
    private String height;
    private String SSC;
    private String HSC;
    private String GPA;

    private User(UserBuilder userBuilder){
        this.fname = userBuilder.fname;
        this.lname = userBuilder.lname;
        this.age = userBuilder.age;
        this.height = userBuilder.height;
        this.SSC = userBuilder.SSC;
        this.HSC = userBuilder.HSC;
        this.GPA = userBuilder.GPA;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getAge() {
        return age;
    }

    public String getHeight() {
        return height;
    }

    public String getSSC() {
        return SSC;
    }

    public String getHSC() {
        return HSC;
    }

    public String getGPA() {
        return GPA;
    }

    public static UserBuilder getBuilder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private String fname;
        private String lname;
        private String age;
        private String height;
        private String SSC;
        private String HSC;
        private String GPA;
        private User user;
        public String getFname() {
            return fname;
        }

        public UserBuilder withFname(String fname) {
            this.fname = fname;
            return this;
        }

        public String getLname() {
            return lname;
        }

        public UserBuilder withLname(String lname) {
            this.lname = lname;
            return this;
        }

        public String getAge() {
            return age;
        }

        public UserBuilder withAge(String age) {
            this.age = age;
            return this;
        }

        public String getHeight() {
            return height;
        }

        public UserBuilder withHeight(String height) {
            this.height = height;
            return this;
        }

        public String getSSC() {
            return SSC;
        }

        public UserBuilder withSSC(String SSC) {
            this.SSC = SSC;
            return this;
        }

        public String getHSC() {
            return HSC;
        }

        public UserBuilder withHSC(String HSC) {
            this.HSC = HSC;
            return this;
        }

        public String getGPA() {
            return GPA;
        }

        public UserBuilder withGPA(String GPA) {
            this.GPA = GPA;
            return this;
        }

        public User build() {
            this.user = new User(this);
            return this.user;
        }

        public User getResult() {
            if (this.user == null) return build();
            return this.user;
        }
    }
}
