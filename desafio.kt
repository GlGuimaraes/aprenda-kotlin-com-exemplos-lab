import Usuario
import kotlin.contracts.contract
import Usuario as Usuario1

// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val idade: Int, val sexo: String)

data class ConteudoEducacional(val nome: String, val materia: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    private val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuarios: Usuario1) = usuarios.forEach { inscritos.add(it) }
    fun mostrarConteudos() = conteudos.forEach { println("${it.nome}, com duração de ${it.duracao} Horas")}
    fun alunosInscritos() = inscritos.forEach { println("${it.nome} ${it.idade} anos de idade e do sexo: ${it.sexo}") }

}



fun main() {

    val alunoRafael = Usuario("Rafael", 18, "M")
    val alunaMaria = Usuario("Maria", 32, "F")
    val alunoPaulo = Usuario("Paulo", 30, "M")
    val alunoLucas = Usuario("Lucas", 19, "M")
    val alunaRafaela = Usuario("Rafaela", 23, "F")
    val alunaLaura = Usuario("Laura", 18, "F")

    val conteudosGit: List<ConteudoEducacional> = listOf(
        ConteudoEducacional("Git e Github", "git"),
        ConteudoEducacional("Github do 0 ao avançado", "git")
    )
    val conteudosKotlin: List<ConteudoEducacional> = listOf(
        ConteudoEducacional("A história do Kotlin", "Kotlin"),
        ConteudoEducacional("Kotlin Orientado a Obejos", "Kotlin"),
        ConteudoEducacional("Kotlin Do 0 ao Avançado", "Kotlin")
    )
    val conteudosAndroidStudio: List<ConteudoEducacional> = listOf(
        ConteudoEducacional("A história do Android", "AndroidStudio"),
        ConteudoEducacional("TextView e Button", "AndroidStudio"),
        ConteudoEducacional("ImageView e LinearLayout", "AndroidStudio")
    )

    val git = Formacao("Turma Formação Git", conteudosGit,Nivel.INTERMEDIARIO)
    val kotlin = Formacao("Turma Kotlin", conteudosKotlin, Nivel.BASICO)
    val androidStudio = Formacao("Turma Android", conteudosAndroidStudio, Nivel.DIFICIL)

    conteudosGit.let {git.matricular(alunaMaria, alunoRafael)}
    val let = conteudosKotlin.let { kotlin.matricular(alunoPaulo, alunaLaura) }
    conteudosAndroidStudio.let { androidStudio.matricular(alunoLucas, alunaRafaela,alunaLaura)}



    println("Digite Qual Formação deseja saber as informações")
    println("[1] - Turma Foramção Git")
    println("[2] - Turma Kotlin")
    println("[3] - Turma Android")

    when (readln()) {
        "1" -> {
            println("Bem vindo a Formação ${git.nome}")
            println("Conteudos:")
            git.mostrarConteudos()
            println("Alunos Matriculados:")
            git.alunosInscritos()
        }
        "2" -> {
            println("Bem vindo a Formação: ${kotlin.nome}")
            println("Conteudos:")
            kotlin.mostrarConteudos()
            println("Alunos Matriculados:")
            kotlin.alunosInscritos()
        }
        "3" -> {
            println("Bem vindo a Formação: ${androidStudio.nome}")
            println("Conteudos:")
            androidStudio.mostrarConteudos()
            println("Alunos Matriculados:")
            androidStudio.alunosInscritos()
        }
        else -> {
            println("Digite uma opção válida")
        }
    }
}
