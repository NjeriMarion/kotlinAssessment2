fun main(){
    println(randomString("akirachix"))
    println(passwords("password"))
    println(passwords("friendsofmine"))
    multiples()
    var accountHolder1 = CurrentAccount("123-456-2342", "John Doe", 1345567)
    accountHolder1.details()
    println("your new balance after deposit is ${accountHolder1.deposit(900.00)}")
    println("your new balance after withdrawal is ${accountHolder1.withdraw(1000.00)}")
    var savings1 = SavingsAccount("123-098-345", "AkiraChix", 89023445, 5)
    println( savings1.withdraw(231356.90))


}
//    Write and invoke one function that takes in a random string and returns the
//            following values: first character, last character, length of the string and
//    whether it begins with a vowel or not. (6pts)
fun randomString(word:String): String{
    val fistChar = word.first()
    val lastChar = word.last()
    val length = word.length
    val vowel = arrayOf('a','e', 'o','i','u')
    var starts = ""
    if (fistChar in vowel) {
        starts = " $word starts with a vowel"
    }
    else{
        starts = "$word does not start with a vowel"
    }
    val output = ("$fistChar, $lastChar, $length, $starts")
    return output
}

//2. Create a function that takes in a password as a parameter. For a password to
//be valid it must meet the following conditions:
fun passwords(password: String):Boolean{
    if (password.length >8 && password.length <16 && password != "password"){
       return  true
    }
    else{
        return false
    }
}
//Create a function that prints out multiples of 6 and 8 between 1 and 1000. For
//multiples of both 6 and 8 it should print out “Bingo!” (5pts)

fun multiples(){
    var x = IntRange(1, 1000)
    for(i in x){
        if (i % 6 ==0 && i % 8 ==0){
            println("Bingo")
        }
        else if(i % 6 ==0){
            println(i)
        }
        else if(i % 8 == 0){
            println(i)
        }
    }
}
//Create a class CurrentAccount with the following attributes: account number,
//account name, balance. It has the following functions:
open class CurrentAccount(var accountNumber:String, var accountName:String, var balance: Long){
    fun deposit(amount:Double):Double{
        val output = balance + amount
        return output
    }
    open fun withdraw(amount:Double):Double{
        val finalbalance = balance - amount
        return  finalbalance
    }
    fun details(){
        println("Account number $accountNumber with balance $balance is operated by $accountName")
    }
}

//Create another class SavingsAccount. It has the same functions and
//attributes as the current account except for one attribute, withdrawals: Int.
//Withdrawals is a counter variable that is used to keep track of how many
//withdrawals have been made from the account in a year. The only other
//difference is that the savings account withdraw() method first checks if the
//number of withdrawals is less than 4 for it to allow one to withdraw money
//from the account. It also increments the withdrawals attribute after a
//successful withdrawal (6pts)

class SavingsAccount( accountName: String, accountNumber: String,balance: Long, var withdrawals:Int):CurrentAccount("123-4-6-3","Mercy", 12344567){
    override fun withdraw(amount: Double): Double {
        var withdrawwithCondition = 0.0
        if (withdrawals < 4){
            val finalbalance = balance - amount
            withdrawwithCondition += finalbalance
            withdrawals ++
        }
        else{
            println("You have reached your maximum required withdrawals ")
        }
        return withdrawwithCondition
    }
}