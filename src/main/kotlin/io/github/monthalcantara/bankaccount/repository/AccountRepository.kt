package io.github.monthalcantara.bankaccount.repository

import io.github.monthalcantara.bankaccount.model.Account
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

//Assim como feito no java o ":" indica que estou estendendo a interface MongoRepository
@Repository
interface AccountRepository: MongoRepository<Account, String> {

    /* Mesma ideia do Java buscando pelo documento, que é uma String que será
    recebida por parametro e retornará um Optional
   */
    fun findByDocument(document: String) : Optional<Account>
}