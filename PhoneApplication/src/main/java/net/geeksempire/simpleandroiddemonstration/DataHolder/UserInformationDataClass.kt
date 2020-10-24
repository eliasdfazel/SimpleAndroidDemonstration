package net.geeksempire.simpleandroiddemonstration.DataHolder

data class UserInformationDataClass (var uniqueUsername: String,
                                     var emailAddress: String,
                                     var phoneNumber: String,
                                     var phoneCountryCode: String = "0098" // Default Value
)