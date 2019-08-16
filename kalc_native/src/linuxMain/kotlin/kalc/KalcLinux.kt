package kalc

import io.kaen.dagger.*

fun main() {
    do {
        println("Input Math Expression")
        val exp = readLine()
        exp?.let {
            try {
                val parser = ExpressionParser()
                val result = parser.evaluate(it)
                println("Result: $result")
            } catch (bs: BadSyntaxException) {
                println(bs.message)
            } catch (bf: BaseNotFoundException) {
                println(bf.message)
            } catch (de: DomainException) {
                println(de.message)
            } catch (ie: ImaginaryException) {
                println(ie.message)
            } catch (e: Exception) {
                if (e.message?.contains("Unsupported Operation") == true) {
                    println(e.message.toString())
                } else {
                    throw  e
                }
            }
        }
        println("evaluate another expression ?")
        val ans = readLine()
    } while (ans != "n" && ans != "no" && ans != "No" && ans != "N")
}