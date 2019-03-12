object SuperMarket{
    var inum:Int =0;
    var cnum:Int =0;
    val N:Int = 10;
    class Item(var icode:Int, var iprice:Int,var iqty:Int, var iname:String){
        var code:Int=icode;
        var price:Int =iprice;
        var qty:Int=iqty;
        var name:String=iname;

        def updateItem(quantity:Int){
            this.qty=this.qty-quantity;
        }
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
        }while(true);
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
    def itemList(){
        var i:Int = 0;
        println("\n------Item list------")
        for( i <- 0 to inum-1){
            println(items(i).code+"-->"+items(i).name);
        }
    }
    def isAvailable(icode: Int, iqty: Int){
        if(items(icode-1).qty<iqty){
            println("Sorry there is not enough goods in the shop");
            buyItem();
        }
        if(iqty<=0){
            println("Invalid!! ");
            buyItem();
        }

    }
    def buyItem(){
        itemList();
        println("Enter item code to buy");
        var icode = scala.io.StdIn.readInt();
        if(icode<0 || icode>inum){
            println("Enter valid item number");
        }
        println("Enter quantity to buy");
        var iqty = scala.io.StdIn.readInt();
        isAvailable(icode,iqty);
        items(icode-1).updateItem(iqty);
        println("Item bought succesfully");
    }
    def customerExit(){

    }
    def newCustomer(){
        cnum = cnum + 1;
        do{
            println("Enter choice");
            println("01.Buy items");
            println("02.Issue Bill");
            println("03.Exit")
            var op = scala.io.StdIn.readInt();
            op match{
                case 1 => buyItem();
            /*  case 2 => issueBill();*/
                case 3 => enterShop();
                case _ => println("Enter a valid choice");
            }
        }while(true)
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