package io.github.monthalcantara.bankaccount.controller

import io.github.monthalcantara.bankaccount.repository.AccountRepository
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/accounts")
class AccountController(var accountRepository: AccountRepository) {

    @GetMapping
    @Transactional
    fun findAllAccounts() = ResponseEntity.ok(accountRepository.findAll())
}