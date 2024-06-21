package entities;

public class Produto {

    private String name;
    private String discription;
    private double price;
    private String avaliable;

public Produto(){
}

    public Produto(String name, String discription, double price, String avaliable) {
        this.name = name;
        this.discription = discription;
        this.price = price;
        this.avaliable = avaliable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String isAvaliable() {
        return avaliable;
    }

    public void setAvaliable(String avaliable) {
        this.avaliable = avaliable;
    }

    @Override
    public String toString() {
        return "Produto[" +
                "name='" + name + '\'' +
                ", discription='" + discription + '\'' +
                ", price='" + price + '\'' +
                ", avaliable=" + avaliable +
                ']';
    }
}
