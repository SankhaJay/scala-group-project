object SuperMarket{
    class Item(var icode:Int, var iprice:Int,var iqty:Int, var iname:String){
        var code:Int=icode;
        var price:Int =iprice;
        var qty:Int=iqty;
        var name:String=iname;

        def UpdateItem(icode:Int, iqty:Int): Unit={
            qty=qty-iqty;
        }
    }
    def main(args: Array[String]){
        println("###Super Market###");
        val item1=new Item(1,500,10,"Soap");
        println(item1.price+" "+ item1.qty+" "+item1.name+"\n");

        var code=readLine("Enter item code: ");
        var qty=readLine("Enter Quantity: ");
        item1.UpdateItem(code.toInt,qty.toInt)
        println(item1.price+" "+ item1.qty+" "+item1.name+"\n");

    }
}