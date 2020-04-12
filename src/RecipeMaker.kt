import Models.*
import java.util.ArrayList




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
        println("Ingrese el numero correspondiente al tipo de ingrediente que desea ingresar a la receta: ")
        val nameIngredient: String? = readLine()
        when(nameIngredient?.toInt()){
            1->{
                var agua :Agua? = null
                val  parrafo = """
                    Ingrese el tipo de agua que desea:
                        1.Agua de manantial
                        2.Agua del grifo
                """.trimIndent()
                println(parrafo)
                val typeSelected = readLine()
                println("Ingrese la cantidad que desea agregar: ")
                val cant : Int?= readLine()?.toInt()
                when(typeSelected?.capitalize()){
                    "1"-> agua = cant?.let { Agua(nameIngredient, it,true) }!!
                    "2"-> agua = cant?.let { Agua(nameIngredient, it,false) }!!
                    else -> {println("No se ha logrado ingresar ese ingrediente, por favor vuelva a intentarlo")
                             makeRecipe()}
                }
                if (agua != null) {
                    list.add(agua)
                }
            }
            2->{
                var leche : Leche? = null
                val  parrafo = """
                    Ingrese el tipo de leche que desea:
                       1.Leche de vaca
                       2.Leche de cabra
                       3.Leche de oveja
                       4.Leche de camello
                """.trimIndent()
                println(parrafo)
                val typeSelected = readLine()
                println("Ingrese la cantidad que desea agregar: ")
                val cant : Int?= readLine()?.toInt()
                when(typeSelected){
                    "1"-> leche = cant?.let { Leche(nameIngredient, it, "Vaca") }
                    "2"-> leche = cant?.let { Leche(nameIngredient, it, "Cabra") }
                    "3"-> leche = cant?.let { Leche(nameIngredient, it, "Oveja") }
                    "4"-> leche = cant?.let { Leche(nameIngredient, it, "Camello") }
                    else -> {println("No se ha logrado ingresar ese ingrediente, por favor vuelva a intentarlo")
                        makeRecipe()}
                }
                if(leche != null)
                    list.add(leche)
            }
            3->{  var carne : Carnes? = null
                val  parrafo = """
                    Ingrese el tipo de carne que desea:
                       1.Res
                       2.Cerdo
                       3.Pollo
                       4.Pescado
                       """.trimIndent()
                println(parrafo)
                val typeSelected = readLine()
                println("Ingrese la cantidad que desea agregar: ")
                val cant : Int?= readLine()?.toInt()
                when(typeSelected){
                    "1"-> carne = cant?.let { Carnes(nameIngredient, it, "Res") }
                    "2"-> carne = cant?.let { Carnes(nameIngredient, it, "Cerdo") }
                    "3"-> carne = cant?.let { Carnes(nameIngredient, it, "Pollo") }
                    "4"-> carne = cant?.let { Carnes(nameIngredient, it, "Pescado") }
                    else -> {println("No se ha logrado ingresar ese ingrediente, por favor vuelva a intentarlo")
                        makeRecipe()}
                }
                if(carne != null)
                    list.add(carne)}
            4->{  var verdura : Verduras? = null
                val  parrafo = """
                    Ingrese la verdura  que desea:
                       1.Lechuga
                       2.Tomate
                       3.Zanahoria
                       4.Brocoli
                       5.Apio
                """.trimIndent()
                println(parrafo)
                val typeSelected = readLine()
                println("Ingrese la cantidad que desea agregar: ")
                val cant : Int?= readLine()?.toInt()
                when(typeSelected){
                    "1"-> verdura = cant?.let { Verduras("Lechuga", it, "Verde") }
                    "2"-> verdura = cant?.let { Verduras("Tomate", it, "Rojo") }
                    "3"-> verdura = cant?.let { Verduras("Zanahoria", it, "Anaranjado") }
                    "4"-> verdura = cant?.let { Verduras("Brocoli", it, "Verde") }
                    "5"-> verdura = cant?.let { Verduras("Apio", it, "Verde") }
                    else -> {println("No se ha logrado ingresar ese ingrediente, por favor vuelva a intentarlo")
                        makeRecipe()}
                }
                if(verdura != null)
                    list.add(verdura)}
            5->{  var fruta : Frutas? = null
                val  parrafo = """
                    Ingrese la fruta  que desea:
                       1.Manzana
                       2.Limon
                       3.Naranja
                       4.Banano
                       5.Mango
                """.trimIndent()
                println(parrafo)
                val typeSelected = readLine()
                println("Ingrese la cantidad que desea agregar: ")
                val cant : Int?= readLine()?.toInt()
                when(typeSelected){
                    "1"-> fruta = cant?.let { Frutas("Manzana", it, true
                    ) }
                    "2"-> fruta = cant?.let { Frutas("Limon", it, false) }
                    "3"-> fruta = cant?.let { Frutas("Naranja", it, false) }
                    "4"-> fruta = cant?.let { Frutas("Banano", it, true) }
                    "5"-> fruta = cant?.let { Frutas("Mango", it, false) }
                    else -> {println("No se ha logrado ingresar ese ingrediente, por favor vuelva a intentarlo")
                        makeRecipe()}
                }
                if(fruta != null)
                    list.add(fruta)}
            6->{ var cereal : Cereal? = null
                val  parrafo = """
                    Ingrese el tipo de cereal  que desea:
                       1.Trigo
                       2.Avena
                       3.Maiz
                """.trimIndent()
                println(parrafo)
                val typeSelected = readLine()
                println("Ingrese la cantidad que desea agregar: ")
                val cant : Int?= readLine()?.toInt()
                when(typeSelected){
                    "1"-> cereal = cant?.let { Cereal(nameIngredient, it, "Trigo") }
                    "2"-> cereal = cant?.let { Cereal(nameIngredient, it, "Avena") }
                    "3"-> cereal = cant?.let { Cereal(nameIngredient, it, "Maiz") }

                    else -> {println("No se ha logrado ingresar ese ingrediente, por favor vuelva a intentarlo")
                        makeRecipe()}
                }
                if(cereal != null)
                    list.add(cereal)}

            7->{ var huevo : Huevos? = null
                val  parrafo = """
                    Ingrese el tipo de huevo  que desea:
                       1.Huevos de gallina
                       2.Huevos de aveztrus
                       3.Huevos de codorniz
                """.trimIndent()
                println(parrafo)
                val typeSelected = readLine()
                println("Ingrese la cantidad que desea agregar: ")
                val cant : Int?= readLine()?.toInt()
                when(typeSelected){
                    "1"-> huevo = cant?.let { Huevos(nameIngredient, it, "Gallina") }
                    "2"-> huevo = cant?.let { Huevos(nameIngredient, it, "Aveztrus") }
                    "3"-> huevo = cant?.let { Huevos(nameIngredient, it, "Codorniz") }

                    else -> {println("No se ha logrado ingresar ese ingrediente, por favor vuelva a intentarlo")
                        makeRecipe()}
                }
                if(huevo != null)
                    list.add(huevo)}
            8->{ var aceite : Aceites? = null
                val  parrafo = """
                    Ingrese el tipo de aceite  que desea:
                       1.Aceite de girasol
                       2.Aceite de olivo
                       3.Aceite de coco
                """.trimIndent()
                println(parrafo)
                val typeSelected = readLine()
                println("Ingrese la cantidad que desea agregar: ")
                val cant : Int?= readLine()?.toInt()
                when(typeSelected){
                    "1"-> aceite = cant?.let { Aceites(nameIngredient, it, "Girasol") }
                    "2"-> aceite = cant?.let { Aceites(nameIngredient, it, "Olivo") }
                    "3"-> aceite = cant?.let { Aceites(nameIngredient, it, "Coco") }

                    else -> {println("No se ha logrado ingresar ese ingrediente, por favor vuelva a intentarlo")
                        makeRecipe()}
                }
                if(aceite != null)
                    list.add(aceite)}

            else -> println("Ha ingresado un dato incorrecto, por favor vuelva a intentarlo")

        }
        println("Desea agregar otro ingrediente?(Si/No)")
        val askNextIngredient: String? = readLine()
        flag = askNextIngredient?.capitalize().equals("Si")
        }
    listRecipes.add(Recipe(nameRecipe, list))
    }


