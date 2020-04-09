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
        2 -> { for ((index,recipe)  in listRecipes.withIndex()){ println("Esta viendo la receta  $index  ${recipe.nombreReceta}") }
               showMenu()
        }
        3 -> println("Muchas gracias por su visita")
        else -> {
            println("El elemento ingresado no es una opción")
            showMenu()
        }
    }

}

fun makeRecipe() {
    val list: MutableList<Ingredientes> = ArrayList()

    println("Ingrese el nombre de la receta")
    val nameRecipe: String? = readLine()
    var flag: Boolean = true
    while (flag) {
        println("Ingrese el nombre del ingrediente")
        val nameIngredient: String? = readLine()
        list.add(Ingredientes(nameIngredient))
        println("Desea agregar otro ingrediente?(Si/No)")
        val askNextIngredient: String? = readLine()
        flag = askNextIngredient?.capitalize().equals("Si")
    }
    listRecipes.add(Recipe(nameRecipe, list))
}
