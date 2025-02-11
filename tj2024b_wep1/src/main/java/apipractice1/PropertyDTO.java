package apipractice1;

public class PropertyDTO {
    private int id;
    private String title;
    private double latitude;
    private double longitude;
    private String address;
    private int price;
    private int squareFeet;
    private String propertyType;    // 아파트, 빌라, 원룸 등
    
    // 생성자
    public PropertyDTO() {}
    
    public PropertyDTO(int id, String title, double latitude, double longitude, 
                   String address, int price, int squareFeet, String propertyType) {
        this.id = id;
        this.title = title;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.price = price;
        this.squareFeet = squareFeet;
        this.propertyType = propertyType;
    }
    
    // Getter와 Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }
    
    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    
    public int getSquareFeet() { return squareFeet; }
    public void setSquareFeet(int squareFeet) { this.squareFeet = squareFeet; }
    
    public String getPropertyType() { return propertyType; }
    public void setPropertyType(String propertyType) { this.propertyType = propertyType; }
}