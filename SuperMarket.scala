object SuperMarket{
    class Item(var price:Int,var qty:Int){
        var price:Int =price;
        var qty:Int=qty;
        var name:String=name;
    }
    def main(args: Array[String]){
        println("gi");
        val item1=new Item(5);
        println(item1.price);
    }
}