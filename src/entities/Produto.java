package entities;

public class Produto {

    private String name;
    private String discription;
    private String price;
    private boolean avaliable;

public Produto(){
}

    public Produto(String name, String discription, String price, boolean avaliable) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isAvaliable() {
        return avaliable;
    }

    public void setAvaliable(boolean avaliable) {
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
