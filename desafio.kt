enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String)

data class ConteudoEducacional(
    var nome: String,
    val duracao: Int = 60,
    val nivel: Nivel = Nivel.BASICO
)

data class Formacao(
    val nome: String,
    var conteudos: List<ConteudoEducacional>,
    val nivel: Nivel
) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome.")
    }

    fun listarInscritos() {
        println("Inscritos na formação $nome:")
        inscritos.forEach { println("- ${it.nome}") }
    }
}

fun main() {
    // Criando conteúdos educacionais
    val kotlinBasico = ConteudoEducacional("Kotlin Básico", 60, Nivel.BASICO)
    val pooEmKotlin = ConteudoEducacional("POO com Kotlin", 90, Nivel.INTERMEDIARIO)
    val avancado = ConteudoEducacional("Kotlin Coroutines", 120, Nivel.AVANCADO)

    // Criando uma formação
    val formacaoKotlin = Formacao(
        nome = "Formação Kotlin Developer",
        conteudos = listOf(kotlinBasico, pooEmKotlin, avancado),
        nivel = Nivel.INTERMEDIARIO
    )

    // Criando usuários
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")
    val usuario3 = Usuario("Carlos")

    // Matriculando usuários
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    formacaoKotlin.matricular(usuario3)

    // Listando inscritos
    formacaoKotlin.listarInscritos()
}
