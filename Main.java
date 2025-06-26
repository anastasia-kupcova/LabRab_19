import static java.lang.System.out;
public class Main {
    public static void main(String[] args) {
        Clothes[] clothes = {
                new TShirt(Size.XS, 2000, "Белый"),
                new TShirt(Size.L, 1500, "Черный"),
                new Pants(Size.XXS, 3500, "Розовый"),
                new Pants(Size.M, 4200, "Синий"),
                new Skirt(Size.S, 3000, "Зеленый"),
                new Tie(Size.S, 1000, "Красный")
        };
        Atelie.dressMan(clothes);
        Atelie.dressWoman(clothes);
    }
}
enum Size{
    XXS(32){
        //@Override
        public String getDescriptoin(){
            return "Детский размер";
        }
    },
    XS(34),
    S(36),
    M(38),
    L(40);
    private int euroSize;
    Size (int euroSize){
        this.euroSize = euroSize;
    }
    public int getEuroSize(){
        return euroSize;
    }
    public String getDescription(){
        return "Взрослый размер";
    }
}
interface Men_Clothes{
    void dressMen();
}
interface Woman_Clothes{
    void dressWoman();
}
abstract class Clothes{
    Size size;
    int price;
    String colour;
    Clothes(Size size, int price, String colour){
        this.size = size;
        this.price = price;
        this.colour = colour;
    }
    @Override
    public String toString() {
        return String.format("{размер= %s(%s), цена= %d руб, цвет= %s, описание= %s}", size,size.getEuroSize(),price,colour,size.getDescription());
    }
}
class TShirt extends Clothes implements Men_Clothes, Woman_Clothes{
    TShirt(Size size, int price, String colour){
        super(size, price, colour);
    }
    @Override
    public void dressMen(){
        out.println("Мужская футболка " + this);
    }
    @Override
    public void dressWoman(){
        out.println("Женская футболка " + this);
    }
}
class Pants extends Clothes implements Men_Clothes, Woman_Clothes{
    Pants(Size size, int price, String colour){
        super(size, price, colour);
    }
    @Override
    public void dressMen(){
        out.println("Мужские штаны " + this);
    }
    @Override
    public void dressWoman(){
        out.println("Женские штаны " + this);
    }
}
class Skirt extends Clothes implements Woman_Clothes{
    Skirt(Size size, int price, String colour){
        super(size, price, colour);
    }
    @Override
    public void dressWoman(){
        out.println("Женская юбка " + this);
    }
}
class Tie extends Clothes implements Men_Clothes{
    Tie(Size size, int price, String colour){
        super(size, price, colour);
    }
    @Override
    public void dressMen(){
        out.println("Мужской галстук " + this);
    }
}
class Atelie{
    public static void dressMan(Clothes[] clothes){
        out.println("Мужская одежда");
        for (Clothes c : clothes){
            if (c instanceof Men_Clothes)
                ((Men_Clothes) c).dressMen();
        }
    }
    public static void dressWoman(Clothes[] clothes){
        out.println("Женская одежда");
        for (Clothes c : clothes){
            if (c instanceof Woman_Clothes)
                ((Woman_Clothes) c).dressWoman();
        }
    }
}
