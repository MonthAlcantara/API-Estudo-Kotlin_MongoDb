package io.github.monthalcantara.bankaccount.model

//Para que o Spring Data consiga atuar é preciso que a classe seja um data
data class Account(
        val id: String,
        val name:String,
        val document:String,
        val balance: Long? = 0 // Aceita valores null e já está sendo inicializada com 0
)
// {} Como essa classe não tem comportamentos, não preciso das chaves para delimitar o corpo