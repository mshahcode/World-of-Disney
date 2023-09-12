package az.pashabank.cardzone.dao.entity;

public enum Rating {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5");

    private final String value;

    Rating(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Rating fromValue(String value){
        for(Rating rating: values()){
            if(rating.getValue().equals(value)){
                return rating;
            }
        }
        throw new IllegalArgumentException("Invalid Rating value: " + value);
    }
}
