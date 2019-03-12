object SuperMarket{
    var inum:Int =0;
    var cnum:Int =0;
    val N:Int = 10;
    class Item(var icode:Int, var iprice:Int,var iqty:Int, var iname:String){
        var code:Int=icode;
        var price:Int =iprice;
        var qty:Int=iqty;
        var name:String=iname;

        /*def UpdateItem(icode:Int, iqty:Int): Unit={
            qty=qty-iqty;
        }*/
    }
    val items: Array[Item] = new Array[Item](N);

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
        var op:Int = 0;
        do{
            println("Enter choice");
            println("01.Add a new item");
            println("02.Proceed to the shop");
            println("03.Exit");
            op = scala.io.StdIn.readInt();
            op match{
            case 1 => addNewItem();
            case 2 => enterShop();
            case 3 => System.exit(1);
            case _ => println("Enter a valid choice");
            }
        }while(op == 1);
    }
    def addNewItem(){
        if(inum == N){
            println("Cannot add more items. Please proceed or exit\n");
            return;
        }
        println("Enter item name");
        var iname = scala.io.StdIn.readLine();
        println("Enter unit price");
        var iprice = scala.io.StdIn.readInt();
        println("Enter remaining item quantity");
        var iqty = scala.io.StdIn.readInt();
        inum = inum + 1;
        val temp = new Item(inum,iprice,iqty,iname);
        items(inum-1) = temp;
        
        println("An item added succesfully\n");
    }
    def closeShop(){
        println("Shop is closed by the owner!!");
        System.exit(1);
    }
    def buyItem(){
        println("Enter item code");
        var icode = scala.io.StdIn.readInt();
        println("Enter quantity to buy");
        var iqty = scala.io.StdIn.readInt();
    }
    def itemList(){
        var i:Int = 0;
        println("\n------Item list------")
        for( i <- 0 to inum-1){
            println(items(i).icode+"-->"+items(i).iname);
        }
    }
    def newCustomer(){
        cnum = cnum + 1;
        itemList();
        println("Enter choice");
        println("01.Buy items");
        println("02.Issue Bill");
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