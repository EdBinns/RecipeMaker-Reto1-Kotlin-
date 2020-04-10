import java.lang.NullPointerException
import java.util.ArrayList

data class Ingredientes constructor(var nombre : String?)
data class Recipe constructor(var nombreReceta : String?, val Ingredientes : MutableList<Ingredientes>)

val listRecipes: MutableList<Recipe> = ArrayList()

fun main(args : Array<String>){
    showMenu()
}

fun showMenu(){
    val menu: String = """
        _________________________________________________
        Bienvenido a recipe maker
            1.Hacer una receta
            2.Ver mis recetas
            3.Salir
    """.trimIndent()
    println(menu)
    println("Ingrese el numero que desea: ")

    when(readLine()?.toInt()){
        1 ->  {makeRecipe()
               showMenu()
        }
        2 -> {
            viewRecipe()
            showMenu()
        }

        3 -> println("Muchas gracias por su visita")
        else -> {
            println("El elemento ingresado no es una opción")
            showMenu()
        }
    }

}
fun viewRecipe() {
    val paragraphViewReciper = """
        _________________________________________________
        Ver mis recetas
        
    """.trimIndent()
    val showRecipe= {
        println(paragraphViewReciper)
        for ((index, recipe) in listRecipes.withIndex()) { println("Esta viendo la receta  ${index + 1}  ${recipe.nombreReceta}")}}
    showRecipe()
}
fun makeRecipe() {
    val list: MutableList<Ingredientes> = ArrayList()

    println("Ingrese el nombre de la receta")
    val nameRecipe: String? = readLine()
    var flag: Boolean = true
    while (flag) {
        val namesingredients = """
            _________________________________________________
            La siguiente lista son los posibles ingredientes que podra tener su receta: 
                1.Agua
                2.Leche
                3.Carne
                4.Verduras
                5.Frutas
                6.Cereal
                7.Huevos
                8.Aceite
        """.trimIndent()
        println(namesingredients)
        println("Ingrese el numero correspondiente al ingrediente que desea ingresar a la receta: ")
        val nameIngredient: Int? = readLine()?.toInt()
        when(nameIngredient){
            1->list.add(Ingredientes("Agua"))
            2->list.add(Ingredientes("Leche"))
            3->list.add(Ingredientes("Carne"))
            4->list.add(Ingredientes("Verduras"))
            5->list.add(Ingredientes("Frutas"))
            6->list.add(Ingredientes("Cereal"))
            7->list.add(Ingredientes("Huevos"))
            8->list.add(Ingredientes("Aceite"))
            else-> println("Ingreso un valor invalido, por favor intentelo de nuevo")
        }
        println("Desea agregar otro ingrediente?(Si/No)")
        val askNextIngredient: String? = readLine()
        flag = askNextIngredient?.capitalize().equals("Si")
    }
    listRecipes.add(Recipe(nameRecipe, list))
}
