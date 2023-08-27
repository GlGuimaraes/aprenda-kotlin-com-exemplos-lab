import Usuario
import kotlin.contracts.contract
import Usuario as Usuario1

// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val idade: Int, val sexo: String)

data class ConteudoEducacional(val nome: String, val materia: String, val duracao: Int = 60,)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuarios: Usuario1) = usuarios.forEach { inscritos.add(it) }
    fun mostrarConteudos() = conteudos.forEach { println(it.nome ) }
    fun AlunosInscritos() = inscritos.forEach { println(it.nome) }

}



fun main() {

    val aluno_Rafael = Usuario("Rafael", 18, "M")
    val aluna_Maria = Usuario("Maria", 32, "F")
    val aluno_Paulo = Usuario("Paulo", 30, "M")
    val aluno_Lucas = Usuario("Lucas", 19, "M")
    val aluna_Rafaela = Usuario("Rafaela", 23, "F")
    val aluna_Laura = Usuario("Laura", 18, "F")

    val ConteudosGit: List<ConteudoEducacional> = listOf(
        ConteudoEducacional("Git e Github", "git"),
        ConteudoEducacional("Github do 0 ao avançado", "git")
    )
    val ConteudosKotlin: List<ConteudoEducacional> = listOf(
        ConteudoEducacional("A história do Kotlin", "Kotlin"),
        ConteudoEducacional("Kotlin Orientado a Obejos", "Kotlin"),
        ConteudoEducacional("Kotlin Do 0 ao Avançado", "Kotlin")
    )
    val ConteudosAndroidStudio: List<ConteudoEducacional> = listOf(
        ConteudoEducacional("A história do Android", "AndroidStudio"),
        ConteudoEducacional("TextView e Button", "AndroidStudio"),
        ConteudoEducacional("ImageView e LinearLayout", "AndroidStudio")
    )

    val Git = Formacao("Turma Formação Git", ConteudosGit,Nivel.INTERMEDIARIO)
    val Kotlin = Formacao("Turma Kotlin", ConteudosKotlin, Nivel.BASICO)
    val AndroidStudio = Formacao("Turma Android", ConteudosAndroidStudio, Nivel.DIFICIL)

    ConteudosGit?.let {Git.matricular(aluna_Maria, aluno_Rafael)}
    ConteudosKotlin?.let {Kotlin.matricular(aluno_Paulo, aluna_Laura) }
    ConteudosAndroidStudio?.let { AndroidStudio.matricular(aluno_Lucas, aluna_Rafaela,aluna_Laura)}



    println("Digite Qual Formação deseja saber as informações")
    println("[1] - Turma Foramção Git")
    println("[2] - Turma Kotlin")
    println("[3] - Turma Android")

    val resposta = readln()

    if (resposta == "1"){
        println("Bem vindo a Formação: ${Git.nome}")
        println("Conteudos:")
        Git.mostrarConteudos()
        println("Aluno Matriculados:")
        Git.AlunosInscritos()
    } else if(resposta == "2"){
        println("Bem vindo a Formação: ${Kotlin.nome}")
        println("Conteudos:")
        Kotlin.mostrarConteudos()
        println("Alunos Matriculados:")
        Kotlin.AlunosInscritos()
    }else if (resposta == "3"){
        println("Bem vindo a Formação: ${AndroidStudio.nome}")
        println("Conteudos:")
        AndroidStudio.mostrarConteudos()
        println("Alunos Matriculados:")
        AndroidStudio.AlunosInscritos()
    } else{
        println("Digite uma opção válida")
    }
}