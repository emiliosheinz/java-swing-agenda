package services

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

    fun saveUserInAgenda(name: String, phoneNumber: String) {
        validateSaveFields(name, phoneNumber)
    }

    fun removeUserFromAgenda(name: String, phoneNumber: String) {
        validateDeleteFields(name, phoneNumber)
    }
}
