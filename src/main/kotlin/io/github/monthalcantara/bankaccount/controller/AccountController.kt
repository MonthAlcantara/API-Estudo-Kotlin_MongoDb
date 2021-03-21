package io.github.monthalcantara.bankaccount.controller

import io.github.monthalcantara.bankaccount.model.Account
import io.github.monthalcantara.bankaccount.repository.AccountRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/v1/accounts")
class AccountController(var accountRepository: AccountRepository) {

    //  Forma Java de Fazer
//    @PostMapping
//    @Transactional
//    fun createNewAccount(@RequestBody account: Account): ResponseEntity<Account> {
//        val accountSave = accountRepository.save(account)
//        return ResponseEntity(accountSave, HttpStatus.CREATED);
//    }

    /*
   * Num jeito mais Kotlin de criar o endpoint o Kotlin ja infere que o resultado após o igual será
   * o retorno da chamada
   * */
    @PostMapping
    @Transactional
    fun createNewAccount(@RequestBody account: Account) = ResponseEntity(accountRepository.save(account), HttpStatus.CREATED)

    @GetMapping
    @Transactional
    fun findAllAccounts() = ResponseEntity.ok(accountRepository.findAll())

    @GetMapping("/{id}")
    @Transactional
    fun getAccountById(@PathVariable("id") id: String): ResponseEntity<Account> {
        val account = accountRepository.findById(id)

        // o orElseThrow do kotlin abre uma chave ao invés do () como no java
        return ResponseEntity.ok(account.orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi encontrado account para o id $id") })
    }
}