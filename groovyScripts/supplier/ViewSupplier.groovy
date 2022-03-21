partyId = parameters.partyId;
if (partyId) {
    supplierInfo = [:]
    supplierAddressInfo = [:]

    supplierRelationship = from("PartyRelationshipAndDetail").where("partyId", partyId).filterByDate().queryFirst()
    supplierInfo.partyId = partyId
    supplierInfo.groupName = supplierRelationship.groupName
    supplierAddressInfo.partyId = partyId
    
    supplierContactDetails = from("PartyContactDetailByPurpose").where("partyId", partyId, "contactMechPurposeTypeId", "PRIMARY_EMAIL").filterByDate().queryFirst()
    supplierInfo.infoString = supplierContactDetails?.infoString
    supplierInfo.emailContactId = supplierContactDetails?.contactMechId

    supplierContactDetails = from("PartyContactDetailByPurpose").where("partyId", partyId, "contactMechPurposeTypeId", "PRIMARY_PHONE").filterByDate().queryFirst()
    supplierInfo.contactNumber = supplierContactDetails?.contactNumber
    supplierInfo.numberContactId = supplierContactDetails?.contactMechId

    supplierContactDetails = from("PartyContactDetailByPurpose").where("partyId", partyId, "contactMechPurposeTypeId", "PRIMARY_LOCATION").filterByDate().queryFirst()
    supplierAddressInfo.addressContactId = supplierContactDetails?.contactMechId
    supplierAddressInfo.address1 = supplierContactDetails?.address1
    supplierAddressInfo.address2 = supplierContactDetails?.address2
    supplierAddressInfo.city = supplierContactDetails?.city
    supplierAddressInfo.postalCode = supplierContactDetails?.postalCode
    supplierAddressInfo.stateGeoName = supplierContactDetails?.stateGeoName
    supplierAddressInfo.countryGeoName = supplierContactDetails?.countryGeoName
    supplierInfo.supplierAddressInfo = supplierAddressInfo
    context.supplierInfo = supplierInfo
}
