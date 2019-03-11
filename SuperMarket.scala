object SuperMarket{
    var inum:Int =0;
    var cnum:Int =0;
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
        //println(item1.price+" "+ item1.qty+" "+item1.name+"\n");
        initShop();
        //enterShop();

        /* var code=readLine("Enter item code: ");
        var qty=readLine("Enter Quantity: ");
        item1.UpdateItem(code.toInt,qty.toInt)
        println(item1.price+" "+ item1.qty+" "+item1.name+"\n"); */
    }
    def initShop(){
        println(" Welcome!!! ");
        println("Enter choice");
        println("01.Add a new item");
        println("02.Proceed");
        var op = scala.io.StdIn.readInt();
        op match{
            case 1 => addNewItem();
            case 2 => enterShop();
            case _ => println("Enter a valid choice");
        }
    }
    def addNewItem(){
        println("Enter item name");
        var iname = scala.io.StdIn.readLine();
        println("Enter unit price");
        var iprice = scala.io.StdIn.readInt();
        println("Enter remaining item quantity");
        var iqty = scala.io.StdIn.readInt();
        val temp = new Item(inum,iprice,iqty,iname);
        inum = inum + 1;
        println("An item added");
    }
    def closeShop(){
        println("Shop is closed by the owner!!");
        System.exit(1);
    }
    def newCustomer(){
        println("This is a new customer");
    }
    def enterShop(){
        println("###Super Market###");
        println("Enter choice");
        println("01.New Customer");
        println("02.Close the shop");
        var op = scala.io.StdIn.readInt();
        op match{
            case 1 => newCustomer();
            case 2 => closeShop();
            case _ => println("Enter a valid choice");
        }
        
    }
}