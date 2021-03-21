package io.github.monthalcantara.bankaccount.repository

import io.github.monthalcantara.bankaccount.model.Account
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AccountRepository: MongoRepository<Account, String> {

    fun findByDocument(document: String) : Optional<Account>
}