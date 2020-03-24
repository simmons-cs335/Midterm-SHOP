public class Address {
    private AddressDao addressData = new AddressDao("carletoc", "1683864");
    private Address address;
    private String street;
    private String city;
    private String state;
    private CharSequence zipcode;


    Address(int user_id){
        street = addressData.getAddress(user_id).get(0);
        city = addressData.getAddress(user_id).get(1);
        state = addressData.getAddress(user_id).get(2);
        zipcode = addressData.getAddress(user_id).get(3);
    }

    /**
     * @author Clara Carleton
     */
    public String getStreet(){ return street; }

    /**
     * @author Clara Carleton
     */
    public String getCity() { return city; }

    /**
     * @author Clara Carleton
     */
    public String getState() { return state; }

    /**
     * @author Clara Carleton
     */
    public CharSequence getZipcode() { return zipcode; }

    /**
     * @author Clara Carleton
     */
    public String toString(){
        return street + " " + city + ", " + state + " " + zipcode;
    }
}
