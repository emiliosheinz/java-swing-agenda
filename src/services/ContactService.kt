package services

import entity.ContactEntity
import repository.ContactRepository

class ContactService {

    private fun validateSaveFields(name: String, phoneNumber: String) {
        if (name.isNullOrBlank()) {
            throw IllegalArgumentException("Name cannot be empty.")
        }

        if(phoneNumber.isNullOrBlank()) {
            throw IllegalArgumentException("Phone number cannot be empty.")
        }
    }

    private fun validateDeleteFields(name: String, phoneNumber: String) {
        if(name.isNullOrBlank() || phoneNumber.isNullOrBlank()) {
            throw IllegalArgumentException("You need to select a contact no remove.")
        }
    }

    fun save(name: String, phoneNumber: String) {
        validateSaveFields(name, phoneNumber)

        val contact = ContactEntity(name, phoneNumber)
        ContactRepository.save(contact)
    }

    fun delete(name: String, phoneNumber: String) {
        validateDeleteFields(name, phoneNumber)
    }
}
