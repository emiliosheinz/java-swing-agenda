package repository

import entity.ContactEntity

class ContactRepository {

    companion object {
        private val contactList = mutableListOf<ContactEntity>()

        fun save(contact: ContactEntity) {
            contactList.add(contact)
        }

        fun delete(contact: ContactEntity) {
            var index = -1

            for(item in contactList.withIndex()) {
                val isNameEquals = item.value.name == contact.name
                val isNumberEquals = item.value.phoneNumber == contact.phoneNumber

                if(isNameEquals && isNumberEquals) {
                    index = item.index
                    break
                }
            }

            if(index >= 0) {
                contactList.removeAt(index)
            }
        }

        fun getContactList(): List<ContactEntity> {
            return contactList
        }
    }
}