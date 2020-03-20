import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
    private String address;
    private String city;
    private String state;
    private CharSequence zipcode;
    private String email;
    private String c_num; //credit card number

    Validations(){}

    Validations(int id){

        User user = new User(id);
        address = user.getAddress().getStreet();
        city = user.getAddress().getCity();
        state = user.getAddress().getState();
        zipcode = user.getAddress().getZipcode();
        email = user.getEmail();
        c_num = user.getCredit();
    }
    public boolean validateAll(){
        return (isvalid_streetAddress(address)&& isvalid_city(city)&& isvalid_state(state)&& isvalid_zipcode(zipcode)&& isvalid_email(email)&& isvalid_payment(c_num));
    }
    public boolean isvalid_streetAddress(String address){
        String addressRegex = "\\d{1,4}\\s\\w.*";
        return (address.matches(addressRegex));
    }

    public boolean isvalid_city (String city){
        String cityRegex= "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$";
        return (city.matches(cityRegex));
    }

    public boolean isvalid_state (String state){
        List<String> allstates = Arrays.asList("Alabama","AL","Alaska","AK","Arizona","AZ","Arkansas","AR","California","CA","Colorado","CO","Connecticut","CT","Delaware","DE", "DC", "Florida","FL","Georgia","GA","Hawaii","HI",
                "Idaho","ID","Illinois","IL","Indiana","IN","Iowa","IA","Kansas","KS","Kentucky","KY","Louisiana","LA","Maine","ME","Maryland","MD","Massachusetts","MA","Michigan","MI","Minnesota","MN",
                "Mississippi","MS","Missouri","MO","Montana","MT","Nebraska","NE","Nevada","NV","New Hampshire","NH","New Jersey","NJ","New Mexico","NM","New York","NY","North Carolina","NC",
                "North Dakota","ND","Ohio","OH","Oklahoma","OK","Oregon","OR","Pennsylvania","PA","Rhode Island","RI","South Carolina","SC","South Dakota","SD","Tennessee","TN","Texas","TX",
                "Utah","UT","Vermont","VT","Virginia","VA","Washington","WA","West Virginia","WV","Wisconsin","WI","Wyoming","WY");

        if (allstates.contains(state)) {
            return true;
        }
        return false;
    }

    public boolean isvalid_zipcode (CharSequence zipcode){
        String zipcodeRegex = "^[0-9]{5}(?:-[0-9]{4})?$";
        Pattern pattern = Pattern.compile(zipcodeRegex);
        Matcher matcher = pattern.matcher(zipcode);
        return(matcher.matches());
    }

    public boolean isvalid_email (String email){
        String emailRegex = "\\w[\\w._]{1,25}@\\w*.(com|edu|net)";
        return(email.matches(emailRegex));
    }

    public boolean isvalid_payment(String c_num) {
        boolean valid = false;
        if (c_num.length()>=13 && c_num.length()<=16) {
            if (c_num.charAt(0)=='4') {
                valid = true;
                System.out.println("You are using a Visa Card");
            }
            else if (c_num.charAt(0)=='5') {
                valid = true;
                System.out.println("You are using a Mastercard");
            }
            else if (c_num.charAt(0)=='3') {
                if(c_num.charAt(1)=='7') {
                    valid = true;
                    System.out.println("You are using an American Express card");
                }
                else
                    System.out.println("Not a valid card");
            }
            else if (c_num.charAt(0)=='6') {
                valid = true;
                System.out.println("You are using a Discover card");
            }
            else {
                System.out.println("Not a valid card");
            }
        }
        else{
            System.out.println("Not a valid card");
        }
        return valid;
    }

}
